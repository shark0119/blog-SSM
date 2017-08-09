package com.hfxt.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import common.model.JsonCrudModel;
/**
 * @author Administrator
 * 
 * @createdate 2015-8-20 下载文件
 */
@Controller("DownLoadController")
public class DownLoadController extends BaseController {

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	@ResponseBody
	public void download(HttpServletRequest request,HttpServletResponse response) throws Exception {
		// 得到要下载的文件名
		String fileName = request.getParameter("filename"); // yiwen.txt
		String loadUrl = request.getParameter("path"); // files/admin/2015-08-20/2_1440040741362/yiwen.txt

		// 文件保存的地址：F:\\workspace\\atqs\\atqs-page\\src\\main\\webapp\\upload
		String fileSaveRootPath = request.getRealPath("/upload");

		// 处理文件名
		String realname = fileName.substring(fileName.indexOf("_") + 1);
		// 设置响应头，控制浏览器下载该文件
		//response.setHeader("Content-Disposition", "inline;filename ="+ URLEncoder.encode(realname, "UTF-8"));
		response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(realname, "UTF-8"));
		// 读取要下载的文件，保存到文件输入流
		FileInputStream in = new FileInputStream(fileSaveRootPath + "\\" + loadUrl);
		BufferedInputStream inStream = new BufferedInputStream(in);
		// 创建缓冲区
		byte buffer[] = new byte[1024];
		int len = 0;
		// 循环将输入流中的内容读取到缓冲区当中
		BufferedOutputStream out = new BufferedOutputStream(
				response.getOutputStream()); // 获得输出
		try {
			while ((len = inStream.read(buffer)) > 0) {
				//输出缓冲区的内容到浏览器，实现文件下载
				out.write(buffer, 0, len);
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			inStream.close();
			out.close();
		}
	}

	/**
	 * 判断附件是否存在
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(method = RequestMethod.POST, value = "checkIsExist")
	@ResponseBody
	public JsonCrudModel<Object> checkIsExist(HttpServletRequest request,HttpServletResponse response,String path)
			throws Exception {
		final JsonCrudModel<Object> result = new JsonCrudModel<Object>();
		// 文件保存的地址：F:\\workspace\\atqs\\atqs-page\\src\\main\\webapp\\upload
		String fileSaveRootPath = request.getRealPath("/upload");
		// 得到要下载的文件
		File file = new File(fileSaveRootPath + "\\" + path);
		// 如果文件不存在
		if (!file.exists()) {
			result.setStatus(JsonCrudModel.Status_Error);
		}else{
			result.setStatus(JsonCrudModel.Status_Success);
		}
		return result;
	}

}
