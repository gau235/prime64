package lgpl3.o.time;

/**
 * @version 2021/10/02_10:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=T64_R" >T64_R.java</a>
 *
 * @see T64
 */
public abstract class T64_R extends T64_M {

	// private static final Class<?> THIS = T64_R.class;

	/**
	 * 取得時間字串 0 到 4, 如: 2015/01/18_11:02:00.123+0800 取得 2015<br/>
	 * To get time's substring from 0 to 4.
	 */
	public static String subS0To4() {

		return toTimeStrWMilliSecWGmt().substring(0, 4);
	}

	/**
	 * 取得時間字串 5 到 10, 如: 2015/01/18_11:02:00.123+0800 取得 01/18<br/>
	 * To get time's substring from 5 to 10.
	 */
	public static String subS5To10() {

		return toTimeStrWMilliSecWGmt().substring(5, 10);
	}

	/**
	 * 取得時間字串 11 到 16, 如: 2015/01/18_11:02:00.123+0800 取得 11:02<br/>
	 * To get time's substring from 11 to 16.
	 */
	public static String subS11To16() {

		return toTimeStrWMilliSecWGmt().substring(11, 16);
	}

	/**
	 * 取得時間字串 0 到 10, 如: 2015/01/18_11:02:00.123+0800 取得 2015/01/18<br/>
	 * To get time's substring from 0 to 10.
	 */
	public static String subS0To10() {

		return toTimeStrWMilliSecWGmt().substring(0, 10);
	}

	/**
	 * 取得時間字串 11 到 19, 如: 2015/01/18_11:02:00.123+0800 取得 11:02:00<br/>
	 * To get time's substring from 11 to 19.
	 */
	public static String subS11To19() {

		return toTimeStrWMilliSecWGmt().substring(11, 19);
	}

	/**
	 * 取得時間字串 5 到 16, 如: 2015/01/18_11:02:00.123+0800 取得 01/18_11:02<br/>
	 * To get time's substring from 5 to 16.
	 */
	public static String subS5To16() {

		return toTimeStrWMilliSecWGmt().substring(5, 16);
	}

	/**
	 * 取得時間字串 0 到 16, 如: 2015/01/18_11:02:00.123+0800 取得 2015/01/18_11:02<br/>
	 * To get time's substring from 0 to 16.
	 */
	public static String subS0To16() {

		return toTimeStrWMilliSecWGmt().substring(0, 16);
	}

	/**
	 * 取得時間字串 5 到 19, 如: 2015/01/18_11:02:00.123+0800 取得 01/18_11:02:00<br/>
	 * To get time's substring from 5 to 19.
	 */
	public static String subS5To19() {

		return toTimeStrWMilliSecWGmt().substring(5, 19);
	}
}
