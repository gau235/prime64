package lgpl3.o.time;

/**
 * 時間轉毫秒數.<br/>
 * The time in 64 bit millisecond.
 *
 * @version 2020/04/06_08:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=T64" >T64.java</a>
 *
 */
public abstract class T64 extends T64_R {

	// private static final Class<?> THIS = T64.class;

	/**
	 * 算時間差值.<br/>
	 * To return the difference.
	 */
	public static float difInF32Sec(long t0) {

		return (System.currentTimeMillis() - t0) / 1_000F;
	}

	/**
	 * 算時間差絕對值.<br/>
	 * To return the difference in absolute value.
	 */
	public static long[] dif(long t64_0, long t64_1) {

		if ((t64_1 -= t64_0) < 0L)
			t64_1 = -t64_1;

		long[] retAry = new long[5];

		retAry[0] = t64_1 / $1_DAY_IN_MILLI;
		retAry[1] = t64_1 % $1_DAY_IN_MILLI / $1_HOUR_IN_MILLI;
		retAry[2] = t64_1 % $1_HOUR_IN_MILLI / $1_MIN_IN_MILLI;
		retAry[3] = t64_1 % $1_MIN_IN_MILLI / $1_SEC_IN_MILLI;
		retAry[4] = t64_1 % $1_SEC_IN_MILLI;

		return retAry;
		// return dDay + "_" + String.format("%02d", dHour) + ":" + String.format("%02d", dMinute) + ":"
		// + String.format("%02d", dSecond);
	}

	/**
	 * 算時間差絕對值.<br/>
	 * To return the difference in absolute value.
	 */
	public static long[] dif(String formattedString0OrString0OfT64, String formattedString1OrString1OfT64) {

		if (formattedString0OrString0OfT64.indexOf(C47) <= 1)

			return dif(Long.parseLong(formattedString1OrString1OfT64), Long.parseLong(formattedString0OrString0OfT64));

		return dif(toT64(formattedString1OrString1OfT64), toT64(formattedString0OrString0OfT64));

	}
}
