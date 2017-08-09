/*
 * 作者		www.TheWk.cn.vc
 * 开发环境	WindowsXp MyEclipse8.6 JDK1.6.0_29
 * 开发日期	2012-10-21
 */
package common.utils;

import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;


/**
 * <hr/>
 * 
 * @author www.TheWk.cn.vc
 * @version 1.0 2012-10-21
 * @class com.test.marvin.ImageHandler
 */
public class ImageHandler {

	private String      srcImagePath;

	private MarvinImage srcImage;

	private int         srcImageWidth;

	private int         srcImageHeight;

	/**
	 * @param srcImagePath
	 *        源图片的路径
	 */
	public ImageHandler(String srcImagePath) {
		this.srcImagePath = srcImagePath;
		this.loadImage();
	}

	/**
	 * 加载图片 <br/>
	 * 
	 * @author www.TheWk.cn.vc
	 */
	private void loadImage() {
		this.srcImage = MarvinImageIO.loadImage(this.srcImagePath);
		this.srcImageWidth = this.srcImage.getWidth();
		this.srcImageHeight = this.srcImage.getHeight();
	}

	/**
	 * 将图片保存到指定的路径
	 * 
	 * @param dstnImagePath
	 *        图片的目地的
	 * @author www.TheWk.cn.vc
	 */
	public void save(String dstnImagePath) {
		MarvinImageIO.saveImage(this.srcImage, dstnImagePath); // 保存图像
	}

	public void resizeSave(String dstnImagePath, ImageZoomStrategy zoomStrategy) {
		WidthHeight widthHeight = zoomStrategy.accep(this);
		this.resizeSave(dstnImagePath, widthHeight.getWidth(), widthHeight.getHeight());
	}

	/**
	 * 改变大小并将改变后的图片保存到指定的路径
	 * 
	 * @param dstnImagePath
	 *        图片的目地的
	 * @param dstnImageWidth
	 *        改变后的宽度
	 * @param dstnImageHeight
	 *        改变后的高度
	 * @author www.TheWk.cn.vc
	 */
	private void resizeSave(String dstnImagePath, int dstnImageWidth, int dstnImageHeight) {
		MarvinImage backImage = this.srcImage.clone();
		backImage.resize(dstnImageWidth, dstnImageHeight);
		MarvinImageIO.saveImage(backImage, dstnImagePath); // 保存图像
	}

	/**
	 * 图片的宽度
	 */
	public int getSrcImageWidth() {
		return this.srcImageWidth;
	}

	/**
	 * 图片的高度
	 */
	public int getSrcImageHeight() {
		return this.srcImageHeight;
	}

	public static class WidthHeight {

		private int width;
		private int height;

		public int getWidth() {
			return this.width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return this.height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

	}

	public static void main(String[] args) {
		String srcImagePath = "d://1.jpg"; // 源文件
		String dstnFile = "d://2.jpg"; // 目的地文件
		ImageHandler imageHandler = new ImageHandler(srcImagePath);
		imageHandler.resizeSave(dstnFile, new ImageZoomStrategy.WithWidthOrHeightBigProportioning(100));
	}

}
