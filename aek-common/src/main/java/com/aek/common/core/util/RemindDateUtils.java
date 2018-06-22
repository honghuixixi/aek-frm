package com.aek.common.core.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 获取 当前年、半年、季度、月、日、小时 开始结束时间
 */
public class RemindDateUtils {

	private static final SimpleDateFormat SHORT_SDF = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat LONG_HOUR_SDF = new SimpleDateFormat("yyyy-MM-dd HH");
	private static final SimpleDateFormat LONG_SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 获得本周的第一天，周一
	 * 
	 * @return
	 */
	public static Date getCurrentWeekDayStartTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		try {
			int weekday = c.get(Calendar.DAY_OF_WEEK) - 2;
			c.add(Calendar.DATE, -weekday);
			c.setTime(LONG_SDF.parse(SHORT_SDF.format(c.getTime()) + " 00:00:00"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c.getTime();
	}

	/**
	 * 获得本周的最后一天，周日
	 * 
	 * @return
	 */
	public static Date getCurrentWeekDayEndTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		try {
			int weekday = c.get(Calendar.DAY_OF_WEEK);
			c.add(Calendar.DATE, 8 - weekday);
			c.setTime(LONG_SDF.parse(SHORT_SDF.format(c.getTime()) + " 23:59:59"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c.getTime();
	}

	/**
	 * 获得本天的开始时间，即2012-01-01 00:00:00
	 * 
	 * @return
	 */
	public static Date getCurrentDayStartTime(Date now) {
		try {
			now = SHORT_SDF.parse(SHORT_SDF.format(now));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获得本天的结束时间，即2012-01-01 23:59:59
	 * 
	 * @return
	 */
	public static Date getCurrentDayEndTime(Date now) {
		try {
			now = LONG_SDF.parse(SHORT_SDF.format(now) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获得本小时的开始时间，即2012-01-01 23:59:59
	 * 
	 * @return
	 */
	public static Date getCurrentHourStartTime(Date now) {
		try {
			now = LONG_HOUR_SDF.parse(LONG_HOUR_SDF.format(now));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获得本小时的结束时间，即2012-01-01 23:59:59
	 * 
	 * @return
	 */
	public static Date getCurrentHourEndTime(Date now) {
		try {
			now = LONG_SDF.parse(LONG_HOUR_SDF.format(now) + ":59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获得本月的开始时间，即2012-01-01 00:00:00
	 * 
	 * @return
	 */
	public static Date getCurrentMonthStartTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		Date now = null;
		try {
			c.set(Calendar.DATE, 1);
			now = SHORT_SDF.parse(SHORT_SDF.format(c.getTime()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 当前月的结束时间，即2012-01-31 23:59:59
	 * 
	 * @return
	 */
	public static Date getCurrentMonthEndTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		Date now = null;
		try {
			c.set(Calendar.DATE, 1);
			c.add(Calendar.MONTH, 1);
			c.add(Calendar.DATE, -1);
			now = LONG_SDF.parse(SHORT_SDF.format(c.getTime()) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 当前年的开始时间，即2012-01-01 00:00:00
	 * 
	 * @return
	 */
	public static Date getCurrentYearStartTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		Date now = null;
		try {
			c.set(Calendar.MONTH, 0);
			c.set(Calendar.DATE, 1);
			now = SHORT_SDF.parse(SHORT_SDF.format(c.getTime()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 当前年的结束时间，即2012-12-31 23:59:59
	 * 
	 * @return
	 */
	public static Date getCurrentYearEndTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		Date now = null;
		try {
			c.set(Calendar.MONTH, 11);
			c.set(Calendar.DATE, 31);
			now = LONG_SDF.parse(SHORT_SDF.format(c.getTime()) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 当前季度的开始时间，即2012-01-1 00:00:00
	 * 
	 * @return
	 */
	public static Date getCurrentQuarterStartTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			if (currentMonth <= 3) {
				c.set(Calendar.MONTH, 1 - 1);
				c.set(Calendar.DATE, 1);
			} else if (currentMonth >= 4 && currentMonth <= 6) {
				c.set(Calendar.MONTH, 4 - 1);
				c.set(Calendar.DATE, 1);
			} else if (currentMonth >= 7 && currentMonth <= 9) {
				c.set(Calendar.MONTH, 7 - 1);
				c.set(Calendar.DATE, 1);
			} else if (currentMonth >= 10 && currentMonth <= 12) {
				c.set(Calendar.MONTH, 10 - 1);
				c.set(Calendar.DATE, 1);
			}
			now = LONG_SDF.parse(SHORT_SDF.format(c.getTime()) + " 00:00:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(DateUtil.format(now));
		return now;
	}

	/**
	 * 当前季度的结束时间，即2012-03-31 23:59:59
	 * 
	 * @return
	 */
	public static Date getCurrentQuarterEndTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int currentMonth = c.get(Calendar.MONTH) + 1;
		System.out.println("currentMonth" + currentMonth);
		Date now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 3) {
				c.set(Calendar.MONTH, 3 - 1);
				c.set(Calendar.DATE, 31);
			} else if (currentMonth >= 4 && currentMonth <= 6) {
				c.set(Calendar.MONTH, 6 - 1);
				c.set(Calendar.DATE, 30);
			} else if (currentMonth >= 7 && currentMonth <= 9) {
				c.set(Calendar.MONTH, 9 - 1);
				c.set(Calendar.DATE, 30);
			} else if (currentMonth >= 10 && currentMonth <= 12) {
				c.set(Calendar.MONTH, 12 - 1);
				c.set(Calendar.DATE, 31);
			}
			now = LONG_SDF.parse(SHORT_SDF.format(c.getTime()) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获取前/后半年的开始时间
	 * 
	 * @return
	 */
	public static Date getHalfYearStartTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 6) {
				c.set(Calendar.MONTH, 0);
			} else if (currentMonth >= 7 && currentMonth <= 12) {
				c.set(Calendar.MONTH, 6);
			}
			c.set(Calendar.DATE, 1);
			now = LONG_SDF.parse(SHORT_SDF.format(c.getTime()) + " 00:00:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;

	}

	/**
	 * 获取前/后半年的结束时间
	 * 
	 * @return
	 */
	public static Date getHalfYearEndTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 6) {
				c.set(Calendar.MONTH, 5);
				c.set(Calendar.DATE, 30);
			} else if (currentMonth >= 7 && currentMonth <= 12) {
				c.set(Calendar.MONTH, 11);
				c.set(Calendar.DATE, 31);
			}
			now = LONG_SDF.parse(SHORT_SDF.format(c.getTime()) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

}