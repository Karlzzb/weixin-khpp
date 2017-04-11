package com.khpp.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	private static final String FULL_DATE_FORMATE = "yyyy-MM-dd HH:mm:ss";
	private static final String TIME_DATE_FORMATE = "HH:mm:ss";
	private static final String TIGHT_DATE_FORMATE = "yyyyMMddHHmmss";

	/**
	 * get date after/before baseDaten n hours
	 * 
	 * @param baseDate
	 * @param n
	 *            + after - before
	 * @return
	 */
	public static Date hourSwing(Date baseDate, int n) {
		return DateUtil.swing(baseDate, Calendar.HOUR_OF_DAY, n);
	}

	/**
	 * get date after/before baseDate n days
	 * 
	 * @param baseDate
	 * @param n
	 *            + after - before
	 * @return
	 */
	public static Date daySwing(Date baseDate, int n) {
		return DateUtil.swing(baseDate, Calendar.DATE, n);
	}

	private static Date swing(Date baseDate, final int unit, int changes) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(baseDate);
		cal.add(unit, changes);
		return cal.getTime();
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @param time
	 * @param x
	 * @return
	 */
	public static String dateToFullString(Date time) {
		return dateToString(time, FULL_DATE_FORMATE);
	}

	/**
	 * HH:mm:ss
	 * 
	 * @param time
	 * @param x
	 * @return
	 */
	public static String dateToTimeString(Date time) {
		return dateToString(time, TIME_DATE_FORMATE);
	}

	private static String dateToString(Date time, String format) {
		if (time == null)
			return "";

		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(time);
	}

	public static String dateToTightString(Date time) {
		return dateToString(time, TIGHT_DATE_FORMATE);
	}
}
