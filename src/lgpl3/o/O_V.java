package lgpl3.o;

import java.lang.reflect.Array;

/**
 * @version 2021/10/23_13:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=O_V" >O_V.java</a>
 *
 * @see O_W
 */
public abstract class O_V extends O_M {

	/**
	 * 切掉陣列末的多個 0.<br/>
	 * To remove all 0 of the tail digits in the array.
	 */
	public static long[] delTailAll0(long[] ary) {

		int idxNot0 = ary.length;

		while (idxNot0-- != 0)

			if (ary[idxNot0] != 0L)

				break;

		// l("idxNot0=" + idxNot0, THIS);

		if (idxNot0 == -1) // l("idxNot0=" + idxNot0 + S32 + THIS);

			return ARY0;

		if (++idxNot0 != ary.length) // 縮短陣列情況下可用這個

			System.arraycopy(ary, 0, (ary = new long[idxNot0]), 0, idxNot0);

		return ary;

	}

	/**
	 * 切掉陣列末的多個 0.<br/>
	 * To remove all 0 of the tail digits in the array.
	 */
	public static int[] delTailAll0(int[] ary32) {

		int idxNot0 = ary32.length;

		while (idxNot0-- != 0)

			if (ary32[idxNot0] != 0)

				break;

		// l("idxNot0=" + idxNot0, THIS);

		if (idxNot0 == -1) // l("idxNot0=" + idxNot0 + S32 + THIS);

			return INT32_ARY0;

		if (++idxNot0 != ary32.length) // 縮短陣列情況下可用這個

			System.arraycopy(ary32, 0, (ary32 = new int[idxNot0]), 0, idxNot0);

		return ary32;

	}

	/**
	 * 切掉陣列末的多個 null.<br/>
	 * To remove all null of the tail digits in the array.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Object> T[] delTailAllNull(T[] objAry) { // ambiguous for Sting[] and Object[]

		int idxNot0 = objAry.length;

		while (idxNot0-- != 0)

			if (objAry[idxNot0] != null)

				break;

		if (idxNot0 == -1) // l("idxNot0=" + idxNot0 + S32 + THIS);

			return (T[]) OBJ_ARY0;

		if (++idxNot0 != objAry.length) // 縮短陣列情況下可用這個

			System.arraycopy(objAry, 0, (objAry = (T[]) Array.newInstance(objAry[0].getClass(), idxNot0)), 0, idxNot0);

		return objAry;

	}

	/**
	 * To get the String that is nested in between two Strings.<br/>
	 * Only the first match is returned.
	 */
	public static String subSBetween(StringBuilder oriStr, String sStart, String sEnd) { // pretty good // 原創

		int iStart = oriStr.indexOf(sStart);
		// final int iStart = str.lastIndexOf(sStart);

		if (iStart != -1) {

			final int iEnd = oriStr.indexOf(sEnd, (iStart += sStart.length())); // sStart.len > 0

			if (iEnd > iStart)

				return oriStr.substring(iStart, iEnd);

			// else xy(iStart, iEnd);

		}

		return null;

	}

	/**
	 * To get the String that is nested in between two Strings.<br/>
	 * Only the first match is returned.
	 */
	public static String subSBetween(String oriS, String sStart, String sEnd) { // pretty good // 原創

		int iStart = oriS.indexOf(sStart);

		if (iStart != -1) {

			final int iEnd = oriS.indexOf(sEnd, (iStart += sStart.length()));

			if (iEnd > iStart)

				return oriS.substring(iStart, iEnd);

		}

		return null;

	}

	/**
	 * To trim all string in array of string.<br/>
	 * To trim all string in array of string.
	 */
	public static String[] splitNTrimAll(CharSequence charSeq, String regexToSplit) {

		String tmpS = ((charSeq instanceof String) ? ((String) charSeq) : charSeq.toString());
		// l("tmpS=" + tmpS);

		String[] sAry = tmpS.split(regexToSplit);

		// l("sAry=");
		// l(sAry);
		// l("len=" + sAry.length);

		int len = sAry.length, idx = 0, iRet = 0;

		for (; idx != len;) {

			// if (Z.equals(tmpS = sAry[idx++].trim()))
			if ((tmpS = sAry[idx++]) == null || Z.equals(tmpS = tmpS.trim())) // tmpS must trim for 6! / 2! 3!

				continue;

			sAry[iRet++] = tmpS;

		}

		if (iRet != sAry.length)

			System.arraycopy(sAry, 0, (sAry = new String[iRet]), 0, iRet); // 用同一個陣列做 copy, 帥氣

		return sAry;

	}

	/**
	 * 執行緒活著嗎 ?<br/>
	 * Is the thread alive?
	 */
	public static <T extends Thread> boolean isAlive(T thr) {

		return ((thr != null) && thr.isAlive());
	}

	/**
	 * aryOfThr 內有執行緒活著嗎 ?<br/>
	 * Is there any thread alive in aryOfThr?
	 */
	public static <T extends Thread> boolean isAnyAlive(T[] aryOfThr) {

		T thr;

		for (int idx = 0; idx != aryOfThr.length; idx++)

			if (((thr = aryOfThr[idx]) != null) && thr.isAlive())

				return B.I;

		return B.O;

	}

	/**
	 * 停止 aryOfThr 內執行緒.<br/>
	 * To stop the threads of aryOfThr.
	 */
	@SuppressWarnings("deprecation")
	public static <T extends Thread> void stopAllAlive(T thr, T otherThr) {

		if ((thr != null) && thr.isAlive())

			thr.stop();

		if ((otherThr != null) && otherThr.isAlive())

			otherThr.stop();

	}

	/**
	 * 停止 aryOfThr 內執行緒.<br/>
	 * To stop the threads of aryOfThr.
	 */
	@SuppressWarnings("deprecation")
	public static <T extends Thread> void stopAllAlive(T thr, T[] aryOfThr) {

		if ((thr != null) && thr.isAlive())

			thr.stop();

		for (int idx = 0; idx != aryOfThr.length; idx++)

			if (((thr = aryOfThr[idx]) != null) && thr.isAlive())

				thr.stop();

	}
}
