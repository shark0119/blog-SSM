/*
 * 作者		www.TheWk.cn.vc
 * 开发环境	Windows7 64位 MyEclipse8.6 JDK1.6.0_37
 * 开发日期	2013-11-13
 */
package common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <hr/>
 * 
 * @author www.TheWk.cn.vc
 * @version 1.0 2013-11-13
 * @class common.utils.DateUtils
 */
public abstract class DateUtils {

	private static final DateFormat DFYYYYMMDD = new SimpleDateFormat("yyMMdd");
	private static final DateFormat DFyyyyMMddHHmmssSSS = new SimpleDateFormat(
			"yyyyMMddHHmmssSSS");
	private static final DateFormat DFyyMMddHHmmssSSS = new SimpleDateFormat(
			"yyMMddHHmmssSSS");

	private DateUtils() {

	}

	/**
	 * 获取昨天的日期
	 */
	public static Date getYesterday() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		return calendar.getTime();
	}

	/**
	 * 获取明天的日期
	 */
	public static Date getTomorrow() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}

	/**
	 * 传入日期,增减该日期的秒数
	 */
	public static Date addSeconds(Date source, int seconds) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(source);
		calendar.add(Calendar.SECOND, seconds);
		return calendar.getTime();
	}

	/**
	 * 传入日期,增减该日期的天数
	 */
	public static Date addDays(Date source, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(source);
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();

	}

	/**
	 * 传入日期,增减该日期的月份
	 */
	public static Date addMonths(Date source, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(source);
		calendar.add(Calendar.MONTH, month);
		return calendar.getTime();
	}

	/**
	 * 获取当天日期的字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getFormatStringByDFYYMMDD(Date date) {
		return DFYYYYMMDD.format(date);
	}

	/**
	 * 获取当天包含毫秒的日期的字符串(四位年)
	 * 
	 * @param date
	 * @return
	 */
	public static String getFormatStringByDFyyyyMMddHHmmssSSS(Date date) {
		return DFyyyyMMddHHmmssSSS.format(date);
	}
	
	/**
	 * 获取当天包含毫秒的日期的字符串(两位年)
	 * 
	 * @param date
	 * @return
	 */
	public static String getFormatStringByDFyyMMddHHmmssSSS(Date date) {
		return DFyyMMddHHmmssSSS.format(date);
	}

	/**
	 * 比较两个日期是否同一天
	 * 
	 * @param day1
	 * @param day2
	 * @return
	 */
	public static boolean isSameDay(Date day1, Date day2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ds1 = sdf.format(day1);
		String ds2 = sdf.format(day2);
		if (ds1.equals(ds2)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 比较两个日期 相差的的天数，不管小时数。即使今天23点和明天1点之间也是1天
	 * 
	 * @param fDate
	 * @param oDate
	 * @return
	 */
	public static int daysOfTwo(Date fDate, Date oDate) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(fDate);
		int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
		aCalendar.setTime(oDate);
		int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
		return day2 - day1;
	}

	public static void main(String[] args) {
		System.out.println(getFormatStringByDFyyMMddHHmmssSSS(new Date()));
	}

}
