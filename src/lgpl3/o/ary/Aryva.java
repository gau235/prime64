package lgpl3.o.ary;

import java.util.Arrays;

import lgpl3.o.O;

/**
 * 陣列小幫手娃.<br/>
 * The aid to array.
 *
 * @version 2021/02/07_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Aryva" >Aryva.java</a>
 *
 * @see Ary32va
 */
public abstract class Aryva extends Aryva_A {

	private static final Class<?> THIS = Aryva.class;

	/**
	 * To distinct.<br/>
	 * To distinct.
	 *
	 * @see Ary32va #distinct(int[])
	 */
	public static long[] distinct(long[] sortedAry) {

		int idx = 1, len = sortedAry.length, newIdx = 1;
		long max = sortedAry[0], v;

		for (; idx != len; idx++) // O.l("v=" + sortedAry[i] + ", iRet=" + iRet + ", max=" + max);

			if ((v = sortedAry[idx]) != max) // if ((v = sortedAry[i]) > max) {

				sortedAry[newIdx++] = max = v; // 連用 2 個等號

		// O.l("newIdx=" + newIdx, THIS);
		if (newIdx != len)

			System.arraycopy(sortedAry, 0, (sortedAry = new long[newIdx]), 0, newIdx);

		return sortedAry;

	}

	/**
	 * To difference.<br/>
	 * To difference.
	 */
	public static long[] ex(long[] sortedAry, long[] exAry) {

		int idx = 0, len = sortedAry.length;

		long key;

		int searchFrom = 0, searchTo = exAry.length, retIdx, newLen = 0;

		for (; idx != len; idx++) {

			O.l("ex=" + Arrays.toString(Arrays.copyOfRange(exAry, searchFrom, searchTo)));

			retIdx = Arrays.binarySearch(exAry, searchFrom, searchTo, key = sortedAry[idx]);

			O.l("retIdx=" + retIdx);

			O.l("(searchFrom + retIdx)=" + (searchFrom + retIdx));

			// -insertionPoint - 1

			if ((searchFrom + retIdx) < -1)

				searchFrom++; // O.l("searchFrom++ ");

			if (retIdx < 0)

				if (idx == newLen)

					++newLen;
				else
					sortedAry[newLen++] = key; // 使用原陣列當容器

		}

		if (newLen != len)

			System.arraycopy(sortedAry, 0, (sortedAry = new long[newLen]), 0, newLen);

		return sortedAry;

	}
}
