package lgpl3.o.ary;

import java.util.Arrays;

import lgpl3.o.O;

/**
 * 本類別是使用 32 位元的整數陣列.<br/>
 * The array of 32 bit integer.
 *
 * @version 2022/04/14_09:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ary32va" >Ary32va.java</a>
 *
 * @see Aryva
 */
public abstract class Ary32va extends Ary32va_A {

	private static final Class<?> THIS = Ary32va.class;

	/**
	 * To compare.<br/>
	 * To compare.
	 */
	public static int[] eq(int[] ary32A, int[] ary32B) {

		if (ary32A != ary32B) {

			if (ary32A == null || ary32B == null)

				O.x();

			int lenA = ary32A.length;

			if (ary32B.length != lenA)

				O.x();

			while (lenA-- != 0)

				if (ary32A[lenA] != ary32B[lenA])

					O.x();

		}

		return ary32A;

	}

	/**
	 * To check if there is duplicated.<br/>
	 * To check if there is duplicated.
	 */
	public static int[] checkDup(int[] sortedAry32) {

		if (sortedAry32.length == 0)

			return sortedAry32;

		int idx = (sortedAry32.length - 1), tail = sortedAry32[idx], head;

		for (; idx > 0; tail = head)

			if (tail == (head = sortedAry32[--idx]))

				O.x("idx=" + idx);

		return sortedAry32;

	}

	/**
	 * To distinct.<br/>
	 * To distinct.
	 *
	 * @see Aryva#distinct(long[])
	 */
	public static int[] distinct(int[] sortedAry32) {

		int idx = 1, len = sortedAry32.length, newIdx = 1, max = sortedAry32[0], v;

		for (; idx != len; idx++) // O.l("v=" + sortedAry32[i] + ", idx=" + idx + ", max=" + max);

			if ((v = sortedAry32[idx]) != max) // if ((v = sortedAry32[i]) > max) {

				sortedAry32[newIdx++] = max = v; // 連用 2 個等號

		if (newIdx != len)

			System.arraycopy(sortedAry32, 0, (sortedAry32 = new int[newIdx]), 0, newIdx);

		return sortedAry32;

	}

	/**
	 * To difference.<br/>
	 * To difference.
	 */
	public static int[] ex(int[] sortedAry32, int[] exAry32) {

		int idx = 0, len = sortedAry32.length, key32;

		int searchFrom = 0, searchTo = exAry32.length, retIdx, newLen = 0;

		for (; idx != len; idx++) {

			O.l("ex=" + Arrays.toString(Arrays.copyOfRange(exAry32, searchFrom, searchTo)));

			retIdx = Arrays.binarySearch(exAry32, searchFrom, searchTo, key32 = sortedAry32[idx]);

			O.l("retIdx=" + retIdx);

			O.l("(searchFrom + retIdx)=" + (searchFrom + retIdx));

			// -insertionPoint - 1

			if ((searchFrom + retIdx) < -1) // if (key != oldKey) { // changed

				searchFrom++; // O.l("searchFrom++ ");

			if (retIdx < 0)

				if (idx == newLen)

					++newLen;
				else
					sortedAry32[newLen++] = key32; // 使用原陣列當容器

		}

		if (newLen != len)

			System.arraycopy(sortedAry32, 0, (sortedAry32 = new int[newLen]), 0, newLen);

		return sortedAry32;

	}

	/**
	 * 陣列內元素位置顛倒.<br/>
	 * To reverse.
	 */
	public static int[] rev(int[] ary32) {

		// Arrays.sort(ary32, Collections.reverseOrder());
		// equivalent:
		// Arrays.sort(ary32);
		// Ary32va.rev(ary32);

		int idx = 0, lenDiv2 = (ary32.length >>> 1), lenMinus1 = (ary32.length - 1), tmp32;

		for (; idx != lenDiv2; idx++) {

			tmp32 = ary32[idx];
			ary32[idx] = ary32[lenMinus1 - idx];
			ary32[lenMinus1 - idx] = tmp32;

		}

		return ary32;

	}

	/**
	 * To convert.<br/>
	 * To convert.
	 */
	public static int[] toAry32(long[] ary) {

		int len = ary.length;

		int[] ary32 = new int[len];

		while (len-- != 0)

			ary32[len] = (int) ary[len];

		return ary32;

	}
}