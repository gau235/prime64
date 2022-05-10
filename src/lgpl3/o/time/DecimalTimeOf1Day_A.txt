package lgpl3.o.time;

import lgpl3.eqDiv.Fr64;
import lgpl3.o.str.SByN;

/**
 * 10 進位格式化的時間.<br/>
 * 1 day=10 hour.<br/>
 * 1 hour=10 minute.<br/>
 * 1 minute=10 second.<br/>
 * 20:26:20=635.73 (6 new hour, 3 new minute, 5 new second, 73 new centisecond)<br/>
 * <br/>
 * The time in new decimal format.
 *
 * @version 2017/02/23_07:37:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=DecimalTimeOf1Day_A" >DecimalTimeOf1Day_A.java</a>
 *
 * @see DecimalTimeOf1Day_Z
 */
public abstract class DecimalTimeOf1Day_A extends SByN {

	// private static final Class<?> THIS = DecimalTimeOf1Day_A.class;

	/**
	 * 1 新天的毫秒數.<br/>
	 * 1 new day in old millisecond.
	 */
	public static final Fr64 $1_DAY_AGAINST_OLD_DAY = Fr64.$1;

	/**
	 * 1 新天的小時數.<br/>
	 * 1 new day in hour.
	 */
	public static final Fr64 $1_DAY_AGAINST_OLD_HOUR = new Fr64(24L);

	/**
	 * 1 新天的分鐘數.<br/>
	 * 1 new day in minute.
	 */
	public static final Fr64 $1_DAY_AGAINST_OLD_MINUTE = new Fr64(1_440L);

	/**
	 * 1 新天的秒數.<br/>
	 * 1 new day in old second.
	 */
	public static final Fr64 $1_DAY_AGAINST_OLD_SEC = new Fr64(86_400L);

	/**
	 * 1 新天的毫秒數.<br/>
	 * 1 new day in old millisecond.
	 */
	public static final Fr64 $1_DAY_AGAINST_OLD_MILLI_SEC = new Fr64(86_400_000L);

	/**
	 * 1 新小時的小時數.<br/>
	 * 1 new hour in old hour.
	 */
	public static final Fr64 $1_HOUR_AGAINST_OLD_HOUR = new Fr64(24L, 10L);

	/**
	 * 1 新小時的分鐘數.<br/>
	 * 1 new hour in old minute.
	 */
	public static final Fr64 $1_HOUR_AGAINST_OLD_MINUTE = new Fr64(1_440L, 10L);

	/**
	 * 1 新小時的秒數.<br/>
	 * 1 new hour in old second.
	 */
	public static final Fr64 $1_HOUR_AGAINST_OLD_SEC = new Fr64(86_400L, 10L);

	/**
	 * 1 新小時的毫秒數.<br/>
	 * 1 new hour in old millisecond.
	 */
	public static final Fr64 $1_HOUR_AGAINST_OLD_MILLI_SEC = new Fr64(86_400_000L, 10L);

	/**
	 * 1 新分鐘的分鐘數.<br/>
	 * 1 new minute in old minute.
	 */
	public static final Fr64 $1_MINUTE_AGAINST_OLD_MINUTE = new Fr64(1_440L, 100L);

	/**
	 * 1 新分鐘的秒數.<br/>
	 * 1 new minute in old second.
	 */
	public static final Fr64 $1_MINUTE_AGAINST_OLD_SEC = new Fr64(86_400L, 100L);

	/**
	 * 1 新分鐘的毫秒數.<br/>
	 * 1 new minute in old millisecond.
	 */
	public static final Fr64 $1_MINUTE_AGAINST_OLD_MILLI_SEC = new Fr64(86_400_000L, 100L);

	/**
	 * 1 新秒的秒數.<br/>
	 * 1 new second in old second.
	 */
	public static final Fr64 $1_SEC_AGAINST_OLD_SEC = new Fr64(86_400L, 1_000L);

	/**
	 * 1 新秒的毫秒數.<br/>
	 * 1 new second in old millisecond.
	 */
	public static final Fr64 $1_SEC_AGAINST_OLD_MILLI_SEC = new Fr64(86_400_000L, 1_000L);

	/**
	 * 1 新小秒 ( 分秒 ) 的秒數.<br/>
	 * 1 new decisecond in old second.
	 */
	public static final Fr64 $1_DECI_SEC_AGAINST_OLD_SEC = new Fr64(86_400L, 10_000L);

	/**
	 * 1 新小秒 ( 分秒 ) 的毫秒數.<br/>
	 * 1 new decisecond in old millisecond.
	 */
	public static final Fr64 $1_DECI_SEC_AGAINST_OLD_MILLI_SEC = new Fr64(86_400_000L, 10_000L);

	/**
	 * 1 新厘秒的秒數.<br/>
	 * 1 new centisecond in old second.
	 */
	public static final Fr64 $1_CENTI_SEC_AGAINST_OLD_SEC = new Fr64(86_400L, 100_000L);

	/**
	 * 1 新厘秒的毫秒數.<br/>
	 * 1 new centisecond in old millisecond.
	 */
	public static final Fr64 $1_CENTI_SEC_AGAINST_OLD_MILLI_SEC = new Fr64(86_400_000L, 100_000L);

	/**
	 * 1 新毫秒的毫秒數.<br/>
	 * 1 new millisecond in old millisecond.
	 */
	public static final Fr64 $1_MILLI_SEC_AGAINST_OLD_MILLI_SEC = new Fr64(86_400_000L, 1_000_000L);

	// =========================================================================

	/**
	 * 1 天的新天數.<br/>
	 * 1 old day in new day.
	 */
	public static final Fr64 $1_OLD_DAY_AGAINST_DAY = Fr64.$1;

	/**
	 * 1 天的新小時數.<br/>
	 * 1 old day in new hour.
	 */
	public static final Fr64 $1_OLD_DAY_AGAINST_HOUR = new Fr64(10L);

	/**
	 * 1 天的新分鐘數.<br/>
	 * 1 old day in new minute.
	 */
	public static final Fr64 $1_OLD_DAY_AGAINST_MINUTE = new Fr64(100L);

	/**
	 * 1 天的新秒數.<br/>
	 * 1 old day in new second.
	 */
	public static final Fr64 $1_OLD_DAY_AGAINST_SEC = new Fr64(1_000L);

	/**
	 * 1 天的新小秒 ( 分秒 ) 數.<br/>
	 * 1 old day in new decisecond.
	 */
	public static final Fr64 $1_OLD_DAY_AGAINST_DECI_SEC = new Fr64(10_000L);

	/**
	 * 1 天的新厘秒數.<br/>
	 * 1 old day in new centisecond.
	 */
	public static final Fr64 $1_OLD_DAY_AGAINST_CNTI_SEC = new Fr64(100_000L);

	/**
	 * 1 天的新毫秒數.<br/>
	 * 1 old day in new millisecond.
	 */
	public static final Fr64 $1_OLD_DAY_AGAINST_MILLI_SEC = new Fr64(1_000_000L);

	/**
	 * 1 小時的新小時數.<br/>
	 * 1 old hour in new hour.
	 */
	public static final Fr64 $1_OLD_HOUR_AGAINST_HOUR = new Fr64(10L, 24L);

	/**
	 * 1 小時的新分鐘數.<br/>
	 * 1 old hour in new minute.
	 */
	public static final Fr64 $1_OLD_HOUR_AGAINST_MINUTE = new Fr64(100L, 24L);

	/**
	 * 1 小時的新秒數.<br/>
	 * 1 old hour in new second.
	 */
	public static final Fr64 $1_OLD_HOUR_AGAINST_SEC = new Fr64(1_000L, 24L);

	/**
	 * 1 小時的新小秒 ( 分秒 ) 數.<br/>
	 * 1 old hour in new decisecond.
	 */
	public static final Fr64 $1_OLD_HOUR_AGAINST_DECI_SEC = new Fr64(10_000L, 24L);

	/**
	 * 1 小時的新厘秒數.<br/>
	 * 1 old hour in new centisecond.
	 */
	public static final Fr64 $1_OLD_HOUR_AGAINST_CNTI_SEC = new Fr64(100_000L, 24L);

	/**
	 * 1 小時的新毫秒數.<br/>
	 * 1 old hour in new millisecond.
	 */
	public static final Fr64 $1_OLD_HOUR_AGAINST_MILLI_SEC = new Fr64(1_000_000L, 24L);

	/**
	 * 1 分鐘的新分鐘數.<br/>
	 * 1 old minute in new minute.
	 */
	public static final Fr64 $1_OLD_MINUTE_AGAINST_MINUTE = new Fr64(100L, 1_440L);

	/**
	 * 1 分鐘的新秒數.<br/>
	 * 1 old minute in new second.
	 */
	public static final Fr64 $1_OLD_MINUTE_AGAINST_SEC = new Fr64(1_000L, 1_440L);

	/**
	 * 1 分鐘的新小秒 ( 分秒 ) 數.<br/>
	 * 1 old minute in new decisecond.
	 */
	public static final Fr64 $1_OLD_MINUTE_AGAINST_DECI_SEC = new Fr64(10_000L, 1_440L);

	/**
	 * 1 分鐘的新厘秒數.<br/>
	 * 1 old minute in new centisecond.
	 */
	public static final Fr64 $1_OLD_MINUTE_AGAINST_CENTI_SEC = new Fr64(100_000L, 1_440L);

	/**
	 * 1 分鐘的新毫秒數.<br/>
	 * 1 old minute in new millisecond.
	 */
	public static final Fr64 $1_OLD_MINUTE_AGAINST_MILLI_SEC = new Fr64(1_000_000L, 1_440L);

	/**
	 * 1 秒的新秒數.<br/>
	 * 1 old second in new second.
	 */
	public static final Fr64 $1_OLD_SEC_AGAINST_SEC = new Fr64(1_000L, 86_400L);

	/**
	 * 1 秒的新小秒 ( 分秒 ) 數.<br/>
	 * 1 old second in new decisecond.
	 */
	public static final Fr64 $1_OLD_SEC_AGAINST_DECI_SEC = new Fr64(10_000L, 86_400L);

	/**
	 * 1 秒的新厘秒數.<br/>
	 * 1 old second in new centisecond.
	 */
	public static final Fr64 $1_OLD_SEC_AGAINST_CENTI_SEC = new Fr64(100_000L, 86_400L);

	/**
	 * 1 秒的新毫秒數.<br/>
	 * 1 old second in new millisecond.
	 */
	public static final Fr64 $1_OLD_SEC_AGAINST_MILLI_SEC = new Fr64(1_000_000L, 86_400L);

	/**
	 * 1 毫秒的新厘秒數.<br/>
	 * 1 old millisecond in new centisecond.
	 */
	public static final Fr64 $1_OLD_MILLI_SEC_AGAINST_CENTI_SEC = new Fr64(100_000L, 86_400_000L);

	/**
	 * 1 毫秒的新毫秒數.<br/>
	 * 1 old millisecond in new millisecond.
	 */
	public static final Fr64 $1_OLD_MILLI_SEC_AGAINST_MILLI_SEC = new Fr64(1_000_000L, 86_400_000L);

}
