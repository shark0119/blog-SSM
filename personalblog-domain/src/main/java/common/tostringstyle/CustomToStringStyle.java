package common.tostringstyle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CustomToStringStyle extends ToStringStyle {

	public static final ToStringStyle Style            = new CustomToStringStyle();
	
	private static final long serialVersionUID = 4177983870975161684L;

	/**
	 * <p>
	 * Constructor.
	 * </p>
	 * <p>
	 * Use the static constant rather than instantiating.
	 * </p>
	 */
	public CustomToStringStyle() {
		super();
		this.setContentStart("[");
		this.setFieldSeparator(SystemUtils.LINE_SEPARATOR + "  ");
		this.setFieldSeparatorAtStart(true);
		this.setContentEnd(SystemUtils.LINE_SEPARATOR + "]");
	}

	/**
	 * <p>
	 * Ensure <code>Singleton</code> after serialization.
	 * </p>
	 * 
	 * @return the singleton
	 */
	private Object readResolve() {
		return ToStringStyle.MULTI_LINE_STYLE;
	}

	@Override
	public void append(StringBuffer buffer, String fieldName, Object value, Boolean fullDetail) {
		if (value != null) {
			this.appendFieldStart(buffer, fieldName);
			this.appendInternal(buffer, fieldName, value, this.isFullDetail(fullDetail));
			this.appendFieldEnd(buffer, fieldName);
		}
	}

	public static final String toString(Object obj) {
		return ToStringBuilder.reflectionToString(obj, CustomToStringStyle.Style).toString();
	}

	public static String arrayToString(String[] array) {
		String result = "";
		for (int i = 0; i < array.length; i++) {
			result = result + "_" + array[i];
		}
		return result;
	}

	public static String[] stringToArray(String str) {
		return str.split("_");
	}

	// before{1,2,3} after{2,4,5}
	public static Map<String, List<String>> findEx(String[] before, String[] after) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		map.put("del", findNoExist(before, after));
		map.put("add", findNoExist(after, before));
		return map;
	}

	private static List<String> findNoExist(String[] arg1, String[] arg2) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < arg1.length; i++) {
			boolean isExist = false;
			for (int j = 0; j < arg2.length; j++) {
				if (arg1[i].equals(arg2[j])) {
					isExist = true;
					break;
				}
			}
			if (!isExist) {
				list.add(arg1[i]);
			}
		}
		return list;
	}
}
