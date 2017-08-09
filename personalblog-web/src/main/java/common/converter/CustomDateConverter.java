/*
 * 作者		www.TheWk.cn.vc
 * 开发环境	Windows7 64位 MyEclipse8.6 JDK1.6.0_45
 * 开发日期	2014年5月4日
 */
package common.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * 日期转换类
 * <hr/>
 * 
 * @author www.TheWk.cn.vc
 * @version 1.0 2014年5月4日
 * @class com.iyuego.converter.CustomDateConverter
 */
public class CustomDateConverter implements Converter<String, Date> {

	private static final DateFormat DATE_FORMATER = new SimpleDateFormat("yyyy-MM-dd");

	static {
		DATE_FORMATER.setLenient(false);
	}

	public Date convert(String source) {
		if (StringUtils.isBlank(source))
			return null;
		try {
			return DATE_FORMATER.parse(source);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
