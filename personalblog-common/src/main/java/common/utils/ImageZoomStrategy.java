/*
 * 作者		www.TheWk.cn.vc
 * 开发环境	WindowsXp MyEclipse8.6 JDK1.6.0_29
 * 开发日期	2012-10-21
 */
package common.utils;

import common.utils.ImageHandler.WidthHeight;

/**
 * 缩放策略.需要在accp方法中,重写zoomWidth和zoomHeight的值
 * <hr/>
 */
public interface ImageZoomStrategy {

	WidthHeight accep(ImageHandler handler);

	/**
	 * 按宽度等比例
	 */
	public static class WithWidthProportioning implements ImageZoomStrategy {

		private int width;

		public WithWidthProportioning(int width) {
			this.width = width;
		}

		public WidthHeight accep(ImageHandler handler) {
			int srcWidth = handler.getSrcImageWidth();
			int srcHeight = handler.getSrcImageHeight();
			WidthHeight widthHeight = new WidthHeight();
			widthHeight.setWidth(this.width);
			widthHeight.setHeight((int) (srcHeight * (((double) this.width / srcWidth))));
			return widthHeight;
		}

	}

	/**
	 * 按高度等比例
	 */
	public static class WithHeightProportioning implements ImageZoomStrategy {

		private int height;

		public WithHeightProportioning(int height) {
			this.height = height;
		}

		public WidthHeight accep(ImageHandler handler) {
			int srcWidth = handler.getSrcImageWidth();
			int srcHeight = handler.getSrcImageHeight();

			WidthHeight widthHeight = new WidthHeight();
			widthHeight.setWidth((int) (srcWidth * (((double) height / srcHeight))));
			widthHeight.setHeight(height);
			return widthHeight;
		}

	}

	/**
	 * 按宽度和高度,哪个值大,按哪个值缩放
	 */
	public static class WithWidthOrHeightBigProportioning implements ImageZoomStrategy {

		private int value;

		public WithWidthOrHeightBigProportioning(int value) {
			this.value = value;
		}

		public WidthHeight accep(ImageHandler handler) {
			int srcWidth = handler.getSrcImageWidth();
			int srcHeight = handler.getSrcImageHeight();

			WidthHeight widthHeight = new WidthHeight();
			if (srcWidth >= srcHeight) {
				widthHeight.setWidth(this.value);
				widthHeight.setHeight((int) (srcHeight * (((double) this.value / srcWidth))));
			}
			else {
				widthHeight.setWidth((int) (srcWidth * (((double) value / srcHeight))));
				widthHeight.setHeight(value);
			}
			return widthHeight;
		}
	}

	/**
	 * 按宽度和高度,哪个值小,按哪个值缩放
	 */
	public static class WithWidthOrHeightSmallProportioning implements ImageZoomStrategy {

		private int value;

		public WithWidthOrHeightSmallProportioning(int value) {
			this.value = value;
		}

		public WidthHeight accep(ImageHandler handler) {
			int srcWidth = handler.getSrcImageWidth();
			int srcHeight = handler.getSrcImageHeight();
			WidthHeight widthHeight = new WidthHeight();
			if (srcWidth <= srcHeight) {
				widthHeight.setWidth(this.value);
				widthHeight.setHeight((int) (srcHeight * (((double) this.value / srcWidth))));
			}
			else {
				widthHeight.setWidth((int) (srcWidth * (((double) value / srcHeight))));
				widthHeight.setHeight(value);
			}
			return widthHeight;
		}
	}

	/**
	 * 按倍数缩放 scaleValue>0
	 */
	public static class WithScaleValueProportioning implements ImageZoomStrategy {

		private double scaleValue;

		public WithScaleValueProportioning(double scaleValue) {
			this.scaleValue = scaleValue;
		}

		public WidthHeight accep(ImageHandler handler) {
			int srcWidth = handler.getSrcImageWidth();
			int srcHeight = handler.getSrcImageHeight();
			WidthHeight widthHeight = new WidthHeight();
			widthHeight.setWidth((int) (this.scaleValue * srcWidth));
			widthHeight.setHeight((int) (this.scaleValue * srcHeight));
			return widthHeight;
		}
	}

	/**
	 * 按指定的宽度和高度缩放
	 */
	public static class WithWidthAndHeightProportioning implements ImageZoomStrategy {

		private int width;
		private int height;

		public WithWidthAndHeightProportioning(int width, int height) {
			this.width = width;
			this.height = height;
		}

		public WidthHeight accep(ImageHandler handler) {
			WidthHeight widthHeight = new WidthHeight();
			widthHeight.setWidth(this.width);
			widthHeight.setHeight(this.height);
			return widthHeight;
		}
	}
}
