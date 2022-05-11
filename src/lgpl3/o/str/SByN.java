package lgpl3.o.str;

import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

import lgpl3.o.O;
import lgpl3.o.O_A;

/**
 * 本類別字串來自於數.<br/>
 * The string of number.
 *
 * @version 2020/04/06_08:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=SByN" >SByN.java</a>
 *
 * @see O
 */
public abstract class SByN extends O_A {

	/**
	 * 數字的格式, 如 1,993.123<br/>
	 * The regex for float.
	 */
	public static final String REGEX_FLOAT = "%,.3f";

	/**
	 * 檢查字串是 null 或字串是空字串.<br/>
	 * To check if the string is null or empty string.
	 */
	public static boolean isNullOrEmpty(String s) {

		return (s == null || Z.equals(s));
	}

	// /**
	// * 檢查字串是 null 或字串是空字串.<br/>
	// * To check if the string is null or empty string.
	// */
	// public static boolean isAnyNullOrEmpty(String... sAry) {
	//
	// for (int i = 0; i != sAry.length; i++) {
	// String s = sAry[i];
	// if (s == null || Z.equals(s)) {
	// return B.I;
	//
	// }

	/**
	 * 把數字轉格式化字串.<br/>
	 * To format and to string.
	 *
	 * @see #df(String)
	 */
	public static String f(BigInteger bigInt) {

		return String.format(REGEX_INT, bigInt);
	}

	/**
	 * 把格式化字串轉數字.<br/>
	 * To deformat and to int64.
	 *
	 * @see #f(long)
	 */
	public static long df(String string) {

		return Long.parseLong(string.replace(S44, Z));
	}

	/**
	 * 把正整數或 0 轉成 numOfDigit 位數的字串 ( 由數字組成, 自動前面補 0).<br/>
	 * 英國人的人生就是玩 26 字母與 10 數字而已.<br/>
	 * To convert a positive or 0 number to a numOfDigit digits string.
	 */
	public static StringBuilder toPadded0Str(String prefix, String postfix, long positiveOr0Num, int numOfDigit) {

		if (positiveOr0Num < 0)
			x();

		// return String.format("%0" + numOfDigit + "d", positiveOr0Num);
		StringBuilder strOfNum = new StringBuilder(String.format(S37 + S48 + numOfDigit + S100, positiveOr0Num));

		return new StringBuilder(prefix).append(strOfNum).append(postfix);

	}

	/**
	 * 把正整數或 0 轉成 numOfDigit 位數的字串 ( 由數字組成, 自動前面補 0 ).<br/>
	 * To convert a positive or 0 number to a numOfDigit digits string.
	 */
	public static StringBuilder pad0D2(long positiveOr0Num) {

		return new StringBuilder(String.format("%02d", positiveOr0Num));
	}

	/**
	 * 把正整數或 0 轉成 numOfDigit 位數的字串 ( 由數字組成, 自動前面補 0 ).<br/>
	 * To convert a positive or 0 number to a numOfDigit digits string.
	 */
	public static StringBuilder pad0D3(long positiveOr0Num) {

		return new StringBuilder(String.format("%03d", positiveOr0Num));
	}

	/**
	 * 把正整數或 0 轉成 numOfDigit 位數的字串 ( 由數字組成, 自動前面補 0 ).<br/>
	 * To convert a positive or 0 number to a numOfDigit digits string.
	 */
	public static StringBuilder pad0D4(long positiveOr0Num) {

		return new StringBuilder(String.format("%04d", positiveOr0Num));
	}

	/**
	 * 把正整數或 0 轉成 numOfDigit 位數的字串 ( 由數字組成, 自動前面補 0 ).<br/>
	 * To convert a positive or 0 number to a numOfDigit digits string.
	 */
	public static StringBuilder pad0D5(long positiveOr0Num) {

		return new StringBuilder(String.format("%05d", positiveOr0Num));
	}

	/**
	 * 產生一個 numOfDigit 位數的字串 ( 由數字組成, 自動前面補 0).<br/>
	 * To create a numOfDigit digits string.
	 */
	public static StringBuilder genPadded0Str(String prefix, String postfix, int numOfDigit) {

		return toPadded0Str(prefix, postfix, ThreadLocalRandom.current().nextLong(pow(10, numOfDigit)), numOfDigit);
	}
}
