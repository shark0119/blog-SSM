package com.hfxt.web.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import common.model.UploadModel;
import common.utils.FileUtils;
import common.utils.ImageHandler;
import common.utils.ImageZoomStrategy;

/**
 * 处理文件上传
 * <hr/>
 * D:\\iyuego\\uploads\\images保存图片,按admin,buyer,seller三种角色分,下面是日期,图片名称以用户ID_时间戳.
 * 
 * @author wanison
 * @version 1.0 2013-11-27
 * @class com.dicunicom.lhsh.web.UploadController
 */
@Controller("UploadController")
public class UploadController extends BaseController {

	/**
	 * 上传保存的绝对路径
	 */
	@Value("#{upload_pros['upload_root_dir']}")
	private String                  rootDir;

	private static final DateFormat DATE_FORMAT         = new SimpleDateFormat("yyyy-MM-dd");
	// 文件夹分隔符
	private static final char       FOLDER_SEPARATOR    = '/';
	// 文件名分隔符
	private static final char       FILE_SEPARATOR      = '_';
	// 文件的点号
	private static final char       EXTENSION_SEPARATOR = '.';

	private static final String     ZOOM_ONE_FILE_PREFIX    = "onezoom";

	private static final String     ZOOM_TWO_FILE_PREFIX    = "twozoom";
	
	@RequestMapping(value = "/upload/image", method = RequestMethod.POST)
	@ResponseBody
	public UploadModel uploadImage(@RequestParam("Filedata") MultipartFile file, @RequestParam(required = false, defaultValue = "none") String roleType, String userId,
	        @RequestParam(required = false) Integer width, @RequestParam(required = false) Integer height, @RequestParam(required = false) Double scaleValue,
	        @RequestParam(required = false) String zoomType,@RequestParam(required = false) String zoomCount,
	        @RequestParam(required = false) Long maxSize
			) throws IOException {
		
		//验证图片类型
		if(FileUtils.getFileTypeByStream(file.getBytes())==null){
			UploadModel sizeResult = new UploadModel();
			sizeResult.setStatus(301);//文件类型不被允许上传
			return sizeResult;
		}
		//验证图片文件大小
		long size = file.getSize();
		if(size>maxSize){
			UploadModel sizeResult = new UploadModel();
			return sizeResult;
		}
		
		// 创建文件夹
		String relativePath = mkdir_RelativeDir("images", roleType);

		// 获取文件扩展名 例如"jpg",".png"
		String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
		// 使用 用户ID+时间戳,生成文件名称
		String fileNameNotExtension = userId + FILE_SEPARATOR + System.currentTimeMillis();
		String fileName = fileNameNotExtension + EXTENSION_SEPARATOR + fileExtension;
		// 拼装文件的相对路径
		String relativeFilePath = relativePath + FOLDER_SEPARATOR + fileName;
		// 拼装文件的绝对路径
		String absoluteFilePath = rootDir + relativeFilePath;

		FileCopyUtils.copy(file.getBytes(), new File(absoluteFilePath));

		UploadModel result = new UploadModel(absoluteFilePath, relativeFilePath);

		// 传入zoomCount,0 无缩放 1 1次缩放 2 2次缩放
		if(StringUtils.isNotBlank(zoomCount)){
			
			if("1".equals(zoomCount)){  //1次缩放
				createZoom(result, fileNameNotExtension, fileExtension, relativePath, absoluteFilePath, ZOOM_ONE_FILE_PREFIX, zoomType, "1", width, height, scaleValue);
			}else if("2".equals(zoomCount)){  //2需要两次缩放
				createZoom(result, fileNameNotExtension, fileExtension, relativePath, absoluteFilePath, ZOOM_ONE_FILE_PREFIX, zoomType, "1", width, height, scaleValue);
				createZoom(result, fileNameNotExtension, fileExtension, relativePath, absoluteFilePath, ZOOM_TWO_FILE_PREFIX, zoomType, "2", width/8, height/8, scaleValue);
			}
		}
		return result;
		
	}
	@RequestMapping(value = "/upload/file", method = RequestMethod.POST)
	@ResponseBody
	public UploadModel uploadFile(@RequestParam("Filedata") MultipartFile file, @RequestParam(required = false, defaultValue = "none") String roleType, String userId,
	        @RequestParam(required = false) Long maxSize) throws IOException {
		UploadModel result = new UploadModel();
		
		//验证文件类型
		/*if(FileUtils.getFileTypeByStream(file.getBytes())==null){
			UploadModel sizeResult = new UploadModel();
			sizeResult.setStatus(1);//文件类型不被允许上传
			return sizeResult;
		}
		*/
		long size = file.getSize();
		if(size>maxSize){
			UploadModel sizeResult = new UploadModel();
			return sizeResult;
		}
		
		// 使用 用户ID+时间戳
		String fileNameNotExtension = userId + FILE_SEPARATOR + System.currentTimeMillis();
		// 创建文件夹
		String relativePath = mkdir_RelativeDir_file("files", roleType,fileNameNotExtension);
		
		// 获取文件扩展名 例如".txt"
		String fileExtension = FilenameUtils.getExtension(file
				.getOriginalFilename());
		// 只能上传文件，过滤不可上传的文件类型
		String fileFilt = ".RAR|.ZIP|.PDF|.PDFX|.TXT|.CSV|.XLS|.XLSX|.DOC.|.DOCX|.JPEG|.JPG|.GIF|.PNG";
		if (fileFilt.indexOf(fileExtension.toUpperCase()) <= -1) {
			result.setStatus(1);
			return result;
		}
		//文件名称
		String fileName = file.getOriginalFilename();
		// 拼装文件的相对路径
		String relativeFilePath = relativePath + FOLDER_SEPARATOR + fileName;
		// 拼装文件的绝对路径
		String absoluteFilePath = rootDir + relativeFilePath;

		FileCopyUtils.copy(file.getBytes(), new File(absoluteFilePath));
//		System.out.println("relativeFilePath"+relativeFilePath);
//		System.out.println("absoluteFilePath"+absoluteFilePath);
		result = new UploadModel(absoluteFilePath, relativeFilePath);
		return result;
		
	}
	/**
	 * 生成缩略图
	 * @param zoomRelativeFilePath
	 * @param zoomAbsoluteFilePath
	 * @param zoomFilePrefix
	 * @return
	 */
	public void createZoom(UploadModel result,String fileNameNotExtension,String fileExtension,String relativePath,String absoluteFilePath,String zoomFilePrefix,String zoomType,String count,int width,int height,Double scaleValue){
		ImageHandler imageHandler = new ImageHandler(absoluteFilePath);
		String zoomRelativeFilePath = relativePath + FOLDER_SEPARATOR + fileNameNotExtension + FILE_SEPARATOR + zoomFilePrefix + EXTENSION_SEPARATOR + fileExtension;
		String zoomAbsoluteFilePath = rootDir + zoomRelativeFilePath;
		if("1".equals(count)){
			result.setZoomOneAbsoluteFilePath(zoomAbsoluteFilePath);
			result.setZoomOneRelativeFilePath(zoomRelativeFilePath);
		}else if("2".equals(count)){
			result.setZoomTwoAbsoluteFilePath(zoomAbsoluteFilePath);
			result.setZoomTwoRelativeFilePath(zoomRelativeFilePath);
		}
		// d:/iyuego/uploads/images/admin/2014-05-25
		if ("WithWidthProportioning".equals(zoomType)) {
			imageHandler.resizeSave(zoomAbsoluteFilePath, new ImageZoomStrategy.WithWidthProportioning(width));
		}
		else if ("WithHeightProportioning".equals(zoomType)) {
			imageHandler.resizeSave(zoomAbsoluteFilePath, new ImageZoomStrategy.WithHeightProportioning(width));
		}
		else if ("WithWidthAndHeightProportioning".equals(zoomType)) {
			imageHandler.resizeSave(zoomAbsoluteFilePath, new ImageZoomStrategy.WithWidthAndHeightProportioning(width, height));
		}
		else if ("WithScaleValueProportioning".equals(zoomType)) {
			imageHandler.resizeSave(zoomAbsoluteFilePath, new ImageZoomStrategy.WithScaleValueProportioning(scaleValue));
		}
		else {
			if("1".equals(count)){
				result.setZoomOneAbsoluteFilePath(null);
				result.setZoomOneRelativeFilePath(null);
			}else if("2".equals(count)){
				result.setZoomTwoAbsoluteFilePath(null);
				result.setZoomTwoRelativeFilePath(null);
			}
		}
	}

	/**
	 * 创建相对路径的文件夹,并返回相对路径
	 */
	// D:\\iyuego\\uploads,按admin,buyer,seller三种角色分,下面是日期,图片名称以用户ID_时间戳.
	private String mkdir_RelativeDir(String fileType, String roleType) {
		String str_FileType = FOLDER_SEPARATOR + fileType;
		String str_FileType_RoleType = str_FileType + FOLDER_SEPARATOR + roleType;
		final String strDate = DATE_FORMAT.format(new Date());
		String str_FileType_RoleType_Date = str_FileType_RoleType + FOLDER_SEPARATOR + strDate;
		File file_RootDir_FileType_RoleType_Date = new File(rootDir + str_FileType_RoleType_Date);
		if (!file_RootDir_FileType_RoleType_Date.exists()) {
			file_RootDir_FileType_RoleType_Date.mkdirs();
		}
		return str_FileType_RoleType_Date;
	}
	/**
	 * 上传文件 生成的文件夹目录
	 * @param fileType
	 * @param roleType
	 * @param fileNameNotExtension
	 * @return
	 */
	private String mkdir_RelativeDir_file(String fileType, String roleType,String fileNameNotExtension) {
		String str_FileType = FOLDER_SEPARATOR + fileType;
		String str_FileType_RoleType = str_FileType + FOLDER_SEPARATOR + roleType;
		final String strDate = DATE_FORMAT.format(new Date());
		String str_FileType_RoleType_Date = str_FileType_RoleType + FOLDER_SEPARATOR + strDate + FOLDER_SEPARATOR + fileNameNotExtension;
		File file_RootDir_FileType_RoleType_Date = new File(rootDir + str_FileType_RoleType_Date);
		if (!file_RootDir_FileType_RoleType_Date.exists()) {
			file_RootDir_FileType_RoleType_Date.mkdirs();
		}
		return str_FileType_RoleType_Date;
	}
	
	
	
	public static void main(String[] args) {
		for (int i = 9; i >= 0; i--) {
			for (int j = 9; j >= 0; j--)
				System.out.println("<option value=\"" + i + "" + j + "\">" + i + "." + j + "折</option>");
		}
	}
}
