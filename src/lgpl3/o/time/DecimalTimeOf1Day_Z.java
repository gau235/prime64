package lgpl3.o.time;

import java.util.Calendar;
import java.util.TimeZone;

import lgpl3.o.O;

/**
 * @version 2020/04/06_08:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=DecimalTimeOf1Day_Z" >DecimalTimeOf1Day_Z.java</a>
 *
 * @see T10
 */
public abstract class DecimalTimeOf1Day_Z extends DecimalTimeOf1Day_A {

	// private static final Class<?> THIS = DecimalTimeOf1Day_Z.class;

	/**
	 * 1 新天的毫秒數.<br/>
	 * 1 new day in old millisecond.
	 */
	public static final long $1_DAY_IN_OLD_MILLI_SEC = 86_400_000L;

	// /**
	// * 1 新天的毫秒數.<br/>
	// * 1 new day in old millisecond.
	// */
	// public static final int $1_DAY_in_OLD_MILLI_SEC_INT32 = 86_400_000;

	// /**
	// * 今天 1 天的厘秒數.<br/>
	// * To get the time of 1 day in centisecond from formattedStringOfT10.
	// */
	// public static int toCentiSec(String formattedStringOfT10) {
	//
	// int int32Centisec = Integer.parseInt(formattedStringOfT10.replace(S46, Z));
	//
	// return int32Centisec;
	//
	// }

	/**
	 * 今天 1 天的毫秒數.<br/>
	 * To get the time of 1 day in old millisecond from formattedStringOfT64.
	 */
	public static long getOldMillisecOfToday(String formattedStringOfT64, TimeZone timeZone) {

		// formattedStringOfT64="2012/08/01_01:00:00.123";

		int idxOfColon = formattedStringOfT64.indexOf(C58);

		long hourInT64 = Long.parseLong(formattedStringOfT64.substring(idxOfColon - 2, idxOfColon)) * T64.$1_HOUR_IN_MILLI;
		O.l("hourInT64=" + formattedStringOfT64.substring(idxOfColon - 2, idxOfColon));
		idxOfColon = idxOfColon + 1;

		long minuteInT64 = Long.parseLong(formattedStringOfT64.substring(idxOfColon, idxOfColon + 2)) * T64.$1_MIN_IN_MILLI;
		O.l("minuteInT64=" + formattedStringOfT64.substring(idxOfColon, idxOfColon + 2));
		idxOfColon = idxOfColon + 3;

		long secInT64 = Long.parseLong(formattedStringOfT64.substring(idxOfColon, idxOfColon + 2)) * T64.$1_SEC_IN_MILLI;
		O.l("secInT64=" + formattedStringOfT64.substring(idxOfColon, idxOfColon + 2));
		idxOfColon = idxOfColon + 3;

		long millisecInT64 = 0;
		if (formattedStringOfT64.indexOf(C46) > 0) {

			millisecInT64 = Long.parseLong(formattedStringOfT64.substring(idxOfColon));
			O.l("millisecInT64=" + formattedStringOfT64.substring(idxOfColon));

		}

		// l("getRawOffset=" + timeZone.getRawOffset());

		return hourInT64 + minuteInT64 + secInT64 + millisecInT64 - timeZone.getRawOffset();

	}

	/**
	 * 今天 1 天的毫秒數.<br/>
	 * To get the time of 1 day in old millisecond.
	 */
	public static long getOldMilliSecOfToday() {

		return (System.currentTimeMillis()) % $1_DAY_IN_OLD_MILLI_SEC;
	}

	/**
	 * 今天 1 天的毫秒數.<br/>
	 * To get the time of 1 day in old millisecond (absolute time in millisecond).
	 */
	public static long getOldMilliSecOfTodayByOldWay() {

		Calendar cal = Calendar.getInstance(T64.TIME_ZONE_GMT_0);// fuck

		long hourInOldMilliSec = T64.$1_HOUR_IN_MILLI * cal.get(Calendar.HOUR_OF_DAY);

		long minuteInOldMilliSec = T64.$1_MIN_IN_MILLI * cal.get(Calendar.MINUTE);

		long secInOldMilliSec = T64.$1_SEC_IN_MILLI * cal.get(Calendar.SECOND);

		long oldMilliSec = cal.get(Calendar.MILLISECOND);

		return hourInOldMilliSec + minuteInOldMilliSec + secInOldMilliSec + oldMilliSec;

	}

	/**
	 * 取得 10 進位格式化的時間字串, 如 1356062400045 轉換過為 939.29+333<br/>
	 * To get the time in new decimal format.
	 */
	public static StringBuilder toTimeStrWGmt(long oldMilliSecOfToday, TimeZone timeZone) {

		long rawOffset = timeZone.getRawOffset();

		long int64Centisecond = ((oldMilliSecOfToday + rawOffset) % $1_DAY_IN_OLD_MILLI_SEC) * 100_000L / $1_DAY_IN_OLD_MILLI_SEC;

		StringBuilder str = pad0D5(int64Centisecond);

		rawOffset = rawOffset * 1_000L / $1_DAY_IN_OLD_MILLI_SEC;

		if (rawOffset >= 0) {

			str.append(C43);

		} else {

			str.append(C45);

		}

		if (rawOffset < 0L) {

			rawOffset = -rawOffset;
		}

		// return str.append(pad0D3(StrictMath.abs(rawOffset))).insert(3, C46);
		return str.append(pad0D3(rawOffset)).insert(3, C46);

	}

	/**
	 * 取得 10 進位格式化的時間字串, 如 939.29+333<br/>
	 * To get the time in new decimal format.
	 */
	public static StringBuilder toTimeStrWGmt(TimeZone timeZone) {

		return toTimeStrWGmt(System.currentTimeMillis(), timeZone);
	}

	/**
	 * 取得 10 進位格式化的時間字串, 如 939.29+333<br/>
	 * To get the time in new decimal format.
	 */
	public static StringBuilder toTimeStrWGmt() {

		return toTimeStrWGmt(System.currentTimeMillis(), T64.DEF_TIME_ZONE);
	}

	/**
	 * 取得 10 進位格式化的時間字串, 如 1356062400045 轉換過為 939.29<br/>
	 * To get the time in new decimal format.
	 */
	public static StringBuilder toTimeStr(long oldMilliSecOfToday, TimeZone timeZone) {

		long int64 = ((oldMilliSecOfToday + timeZone.getRawOffset()) % $1_DAY_IN_OLD_MILLI_SEC) * 100_000L / $1_DAY_IN_OLD_MILLI_SEC;// to

		StringBuilder str = pad0D5(int64);

		return str.insert(3, C46);

	}

	/**
	 * 現在時間的厘秒數.<br/>
	 * To get the now time in centisecond.
	 */
	public static int centiSec() {

		long oldMilliSecOfToday = (System.currentTimeMillis() + T64.DEF_TIME_ZONE.getRawOffset()) % $1_DAY_IN_OLD_MILLI_SEC;
		long int64Centisecond = oldMilliSecOfToday * 100_000L / $1_DAY_IN_OLD_MILLI_SEC;// to centisecond

		return (int) int64Centisecond;

	}

	/**
	 * 取得 10 進位格式化的時間字串, 如 939.29<br/>
	 * To get the time in new decimal format.
	 */
	public static StringBuilder toTimeStr(TimeZone timeZone) {

		long oldMilliSecOfToday = (System.currentTimeMillis() + timeZone.getRawOffset()) % $1_DAY_IN_OLD_MILLI_SEC;
		long int64Centisecond = oldMilliSecOfToday * 100_000L / $1_DAY_IN_OLD_MILLI_SEC;// to centisecond

		StringBuilder str = pad0D5(int64Centisecond);

		return str.insert(3, C46);

	}

	/**
	 * 取得 10 進位格式化的時間字串, 如 939.29<br/>
	 * To get the time in new decimal format.
	 */
	public static StringBuilder toTimeStr() {

		long oldMilliSecOfToday = (System.currentTimeMillis() + T64.DEF_TIME_ZONE.getRawOffset()) % $1_DAY_IN_OLD_MILLI_SEC;
		long int64Centisecond = oldMilliSecOfToday * 100_000L / $1_DAY_IN_OLD_MILLI_SEC;// to centisecond

		StringBuilder str = pad0D5(int64Centisecond);

		return str.insert(3, C46);

	}

	/**
	 * 取得 10 進位格式化的時間字串, 如 939.29<br/>
	 * To get the time in new decimal format.
	 */
	public static StringBuilder timeStr() {

		long oldMilliSecOfToday = (System.currentTimeMillis() + T64.DEF_TIME_ZONE.getRawOffset()) % $1_DAY_IN_OLD_MILLI_SEC;
		long int64Centisecond = oldMilliSecOfToday * 100_000L / $1_DAY_IN_OLD_MILLI_SEC;// to centisecond

		StringBuilder str = pad0D5(int64Centisecond);

		return str.insert(3, C46);

	}
}
