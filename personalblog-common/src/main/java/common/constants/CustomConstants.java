package common.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义常量
 */
public interface CustomConstants {
	

	public abstract class ContentType {

		/**
		 * 返回图片类型
		 */
		public static final String Image_Jpeg             = "image/jpeg";
		/**
		 * 返回文本类型
		 */
		public static final String Text_Plain             = "text/plain";
		/**
		 * 返回用户下载的类型
		 */
		public static final String Application_X_DOWNLOAD = "application/x-download";
		/**
		 * 返回JSON类型
		 */
		public static final String Json                   = "application/json";
	}

	/**
	 * 显示状态
	 */
	public abstract class Sys_Show_Status {

		public static final int                  Yes           = 1;
		public static final int                  No            = 2;
		public static final int                  Default_Value = Yes;

		public static final Map<Integer, String> valueMap      = new HashMap<Integer, String>();

		static {
			valueMap.put(Yes, "显示");
			valueMap.put(No, "隐藏");
		}

		public static String getStringAsValue(int value) {
			String result = valueMap.get(value);
			if (result == null || result.length() == 0) {
				return valueMap.get(No);
			}
			return result;
		}
	}

	/**
	 * 启用状态
	 */
	public abstract class Sys_Enabled {

		public static final int                  Yes           = 1;
		public static final int                  No            = 2;
		public static final int                  Default_Value = Yes;

		public static final Map<Integer, String> valueMap      = new HashMap<Integer, String>();

		static {
			valueMap.put(Yes, "启用");
			valueMap.put(No, "禁用");
		}

		public static String getStringAsValue(int value) {
			String result = valueMap.get(value);
			if (result == null || result.length() == 0) {
				return valueMap.get(No);
			}
			return result;
		}
	}
	
}
