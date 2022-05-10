package lgpl3.o.time;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * @version 2020/04/04_20:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=T64_A" >T64_A.java</a>
 *
 * @see T64_M
 */
public abstract class T64_A extends Time64 {

	// private static final Class<?> THIS = T64_A.class;

	/**
	 * 取得現在時間轉成格式化的時間字串建立者, 格式如 2012/12/21_12:00:00<br/>
	 * To return current time in formatted StringBuilder, for example: 2012/12/21_12:00:00
	 */
	public static StringBuilder timeStr() {

		return new StringBuilder(String.format(DEF_REGEX_TIME, Calendar.getInstance()));
	}

	/**
	 * 把以 64 位元整數表示的時間值, 轉格式化的時間字串建立者, 格式如 2012/12/21_12:00:00<br/>
	 * To convert the time in millisecond to formatted StringBuilder of time.<br/>
	 * For example: 2012/12/21_12:00:00
	 */
	public static StringBuilder toTimeStr(long milliSec, TimeZone timeZone) {

		Calendar cal = Calendar.getInstance(timeZone);
		cal.setTimeInMillis(milliSec); // 1311487484432

		return new StringBuilder(String.format(DEF_REGEX_TIME, cal));

	}

	/**
	 * 把以 64 位元整數表示的時間值, 轉格式化的時間字串建立者, 格式如 2012/12/21_12:00:00+08:00<br/>
	 * To convert the time in millisecond to formatted StringBuilder of time.<br/>
	 * For example: 2012/12/21_12:00:00+08:00
	 */
	public static StringBuilder toTimeStrWGmt() {

		StringBuilder str = new StringBuilder(String.format(DEF_REGEX_TIME_W_GMT, Calendar.getInstance()));

		return str.insert(str.length() - 2, C58);

	}

	/**
	 * 把以 64 位元整數表示的時間值, 轉格式化的時間字串建立者, 格式如 2012/12/21_12:00:00+08:00<br/>
	 * To convert the time in millisecond to formatted StringBuilder of time.<br/>
	 * For example: 2012/12/21_12:00:00+08:00
	 */
	public static StringBuilder toTimeStrWGmt(long milliSec, TimeZone timeZone) {

		Calendar cal = Calendar.getInstance(timeZone);
		cal.setTimeInMillis(milliSec);

		StringBuilder str = new StringBuilder(String.format(DEF_REGEX_TIME_W_GMT, cal));
		return str.insert(str.length() - 2, C58);

	}

	/**
	 * 把以 64 位元整數表示的時間值, 轉格式化的時間字串建立者, 格式如 2012/12/21_12:00:00.550+08:00<br/>
	 * To convert the time in millisecond to formatted StringBuilder of time.<br/>
	 * For example: 2012/12/21_12:00:00.550+08:00
	 */
	public static StringBuilder toTimeStrWMilliSecWGmt() {

		StringBuilder str = new StringBuilder(String.format(DEF_REGEX_TIME_W_MILLI_SEC_W_GMT, Calendar.getInstance()));

		return str.insert(str.length() - 2, C58);

	}

	/**
	 * 把以 64 位元整數表示的時間值, 轉格式化的時間字串建立者, 格式如 2012/12/21_12:00:00.550+08:00<br/>
	 * To convert the time in millisecond to formatted StringBuilder of time.<br/>
	 * For example: 2012/12/21_12:00:00.550+08:00
	 */
	public static StringBuilder toTimeStrWMilliSecWGmt(long milliSec, TimeZone timeZone) {

		Calendar cal = Calendar.getInstance(timeZone);
		cal.setTimeInMillis(milliSec);

		StringBuilder str = new StringBuilder(String.format(DEF_REGEX_TIME_W_MILLI_SEC_W_GMT, cal));
		return str.insert(str.length() - 2, C58);

	}
}
