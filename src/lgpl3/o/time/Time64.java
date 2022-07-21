package lgpl3.o.time;

import java.util.TimeZone;

import lgpl3.o.Origin;

/**
 * 時間轉毫秒數.<br/>
 * The time in 64 bit millisecond.
 *
 * @version 2020/04/06_08:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Time64" >Time64.java</a>
 *
 * @see T64_A
 */
public abstract class Time64 extends Origin {

	// private static final Class<?> THIS = Time64.class;

	/**
	 * 非數字的格式.<br/>
	 * The regex for not a number.
	 */
	public static final String REGEX_NOT_NUM = "[^0-9]";

	/**
	 * 時間轉字串的格式, 如 2012/12/21_12:00:00<br/>
	 * The format, for example: 2012/12/21_12:00:00
	 */
	public static final String DEF_REGEX_TIME = "%1$tY/%1$tm/%1$td_%1$tH:%1$tM:%1$tS";

	/**
	 * 時間轉字串的格式, 如 2012/12/21_12:00:00.550<br/>
	 * The format, for example: 2012/12/21_12:00:00.550
	 */
	public static final String DEF_REGEX_TIME_W_MILLI_SEC = "%1$tY/%1$tm/%1$td_%1$tH:%1$tM:%1$tS.%1$tL";

	/**
	 * 時間轉字串的格式, 如 2012/12/21_12:00:00+0800.<br/>
	 * 後需再轉為 2012/12/21_12:00:00+08:00<br/>
	 * The format, for example: 2012/12/21_12:00:00+08:00.
	 */
	public static final String DEF_REGEX_TIME_W_GMT = "%1$tY/%1$tm/%1$td_%1$tH:%1$tM:%1$tS%1$tz";

	/**
	 * 時間轉字串的格式, 如 2012/12/21_12:00:00.550+0800.<br/>
	 * 後需再轉為 2012/12/21_12:00:00.550+08:00<br/>
	 * The format, for example: 2012/12/21_12:00:00.550+0800.
	 */
	public static final String DEF_REGEX_TIME_W_MILLI_SEC_W_GMT = "%1$tY/%1$tm/%1$td_%1$tH:%1$tM:%1$tS.%1$tL%1$tz";

	/**
	 * 1 秒的毫秒數.<br/>
	 * 1 second in millisecond.
	 */
	public static final long $1_SEC_IN_MILLI = 1_000L;

	/**
	 * 1 分鐘的毫秒數.<br/>
	 * 1 minute in millisecond.
	 */
	public static final long $1_MIN_IN_MILLI = 60_000L; // $1_SEC_AS_MILLI * 60;

	/**
	 * 1 小時的毫秒數.<br/>
	 * 1 hour in millisecond.
	 */
	public static final long $1_HOUR_IN_MILLI = 3_600_000L; // $1_MIN_AS_MILLI * 60;

	/**
	 * 1 天的毫秒數.<br/>
	 * 1 day in millisecond.
	 */
	public static final long $1_DAY_IN_MILLI = 86_400_000L; // $1_HOUR_AS_MILLI * 24;

	/**
	 * The TimeZone GMT+0000.<br/>
	 * The TimeZone GMT+0000.
	 */
	public static final TimeZone TIME_ZONE_GMT_0 = TimeZone.getTimeZone("GMT+00:00");

	/**
	 * 預設的 TimeZone.<br/>
	 * Default TimeZone.
	 */
	public static final TimeZone DEF_TIME_ZONE = TimeZone.getDefault();

	/**
	 * GMT.<br/>
	 * GMT.
	 */
	public static final String STRING_GMT = "GMT";

}
