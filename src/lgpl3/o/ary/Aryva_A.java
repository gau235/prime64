package lgpl3.o.ary;

import java.util.Arrays;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 陣列小幫手娃.<br/>
 * The aid to array.
 *
 * @version 2022/03/10_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Aryva_A" >Aryva_A.java</a>
 *
 * @see Aryva
 */
public abstract class Aryva_A {

	private static final Class<?> THIS = Aryva_A.class;

	/**
	 * To sum.
	 */
	public static long sum(long[] ary, int from, int to) {

		long ans = 0L;

		for (; from < to; from++)

			ans += ary[from];

		return ans;

	}

	/**
	 * 切掉陣列前面的多個 0.<br/>
	 * To remove all 0 of the head digits in the array.
	 *
	 * @see O#delTailAll0(long[])
	 */
	public static long[] delHeadAll0(long[] ary) {

		int idxNot0 = 0, len = ary.length;

		for (; idxNot0 != len; idxNot0++)

			if (ary[idxNot0] != 0L)

				break;

		if (idxNot0 != 0) // 用於縮短陣列情況下

			System.arraycopy(ary, idxNot0, (ary = new long[idxNot0 = (len - idxNot0)]), 0, idxNot0); // [0,0,9,8] => 4-2

		return ary;

	}

	/**
	 * To check if contain.<br/>
	 * To check if contain.
	 *
	 * @see Ary32va #ifContain(int[], int, int, int)
	 */
	public static boolean ifContain(long[] ary, int from, int to, long key) {

		for (; from < to; from++)

			if (ary[from] == key)

				return B.I;

		return B.O;

	}

	/**
	 * 陣列內元素位置顛倒.<br/>
	 * To reverse.
	 */
	public static long[] rev(long[] ary) {

		int idx = 0, lenDiv2 = (ary.length >>> 1), lenMinus1 = (ary.length - 1);

		long tmp;

		for (; idx != lenDiv2; idx++) {

			tmp = ary[idx];
			ary[idx] = ary[lenMinus1 - idx];
			ary[lenMinus1 - idx] = tmp;

		}

		return ary;

	}

	/**
	 * To compare.<br/>
	 * To compare.
	 */
	public static long[] eq(long[] aryA, long[] aryB) {

		if (aryA != aryB) {

			if (aryA == null || aryB == null)

				O.x();

			int lenA = aryA.length;

			if (aryB.length != lenA)

				O.x();

			while (lenA-- != 0)

				if (aryA[lenA] != aryB[lenA])

					O.x();

		}

		return aryA;

	}

	/**
	 * To check if there is duplicated.<br/>
	 * To check if there is duplicated.
	 */
	public static long[] sortDesc(long[] ary) {

		if (ary.length == 0)

			return ary;

		Arrays.sort(ary); // 破壞性寫入

		return rev(ary);

	}

	/**
	 * To check if there is duplicated.<br/>
	 * To check if there is duplicated.
	 */
	public static long[] checkDup(long[] sortedAry) { // todo: new method sortNCheckDup

		// O.l ("len=" + sortedAry.length, THIS);

		if (sortedAry.length == 0)

			return sortedAry;

		int idx = (sortedAry.length - 1);

		long tail = sortedAry[idx], head;

		for (; idx > 0; tail = head)

			if (tail == (head = sortedAry[--idx]))

				O.x("idx=" + idx);

		return sortedAry;

	}

	/**
	 * To check if there is duplicated.<br/>
	 * To check if there is duplicated.
	 */
	public static long[] sortNCheckDup(long[] ary) {

		if (ary.length == 0)

			return ary;

		Arrays.sort(ary); // 破壞性寫入

		// java.util.DualPivotQuicksort.sort(ary, 0, ary.length - 1, null, 0, 0);

		int idx = (ary.length - 1);

		long tail = ary[idx], head;

		for (; idx > 0; tail = head)

			if (tail == (head = ary[--idx]))

				O.x("idx=" + idx);

		return ary;

	}

	/**
	 * To check if there is duplicated.<br/>
	 * To check if there is duplicated.
	 */
	public static long[] sortDescNCheckDup(long[] ary) { // todo: Ary32va 也要有此方法

		if (ary.length == 0)

			return ary;

		Arrays.sort(ary); // 破壞性寫入

		// java.util.DualPivotQuicksort.sort(ary, 0, ary.length - 1, null, 0, 0);

		rev(ary);

		int idx = (ary.length - 1);

		long tail = ary[idx], head;

		for (; idx > 0; tail = head)

			if (tail == (head = ary[--idx]))

				O.x("idx=" + idx);

		return ary;

	}
}
