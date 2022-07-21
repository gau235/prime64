package lgpl3.o.ary;

import java.util.Arrays;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 本類別是使用 32 位元的整數陣列.<br/>
 * The array of 32 bit integer.
 *
 * @version 2021/06/14_20:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ary32va_A" >Ary32va_A.java</a>
 *
 * @see Ary32va
 */
public abstract class Ary32va_A {

	private static final Class<?> THIS = Ary32va_A.class;

	/**
	 * To sum.
	 */
	public static long sum64(int[] ary32, int from, int to) {

		long ans = 0L;

		for (; from < to; from++)

			ans += ary32[from];

		return ans;

	}

	/**
	 * 切掉陣列前面的多個 0.<br/>
	 * To remove all 0 of the head digits in the array.
	 *
	 * @see O#delTailAll0(int[])
	 */
	public static int[] delHeadAll0(int[] ary32) {

		int idxNot0 = 0, len = ary32.length;

		for (; idxNot0 != len; idxNot0++)

			if (ary32[idxNot0] != 0)

				break;

		if (idxNot0 != 0) // 縮短陣列情況下可用這個 // [0,0,5] => 3-2

			System.arraycopy(ary32, idxNot0, (ary32 = new int[idxNot0 = (len - idxNot0)]), 0, idxNot0);

		return ary32;

	}

	/**
	 * To gen the ascending int[].<br/>
	 * To gen the ascending int[].
	 */
	public static int[] genAscAry32From1(int len) {

		int[] ret = new int[len];

		for (int idx = 0; idx != len;)

			ret[idx] = ++idx;

		return ret;

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
	 * The bound and 0 are both inclusive.
	 *
	 * @see B64W6#findFirstOccurDownTo0(long, int, int)
	 */
	public static int findFirstOccurDownTo0(int[] ary32, int bound, int key32) {

		do
			if (ary32[bound] == key32)

				return bound;

		while (--bound >= 0);

		return Integer.MIN_VALUE; // todo: return -insertionPoint - 1

	}

	/**
	 * To check if contain.
	 *
	 * @see Aryva #ifContain(long[], int, int, long)
	 */
	public static boolean ifContain(int[] ary32, int from, int to, int key32) {

		for (; from < to; from++)

			if (ary32[from] == key32)

				return B.I;

		return B.O;

	}

	/**
	 * To sort in descending order.
	 */
	public static int[] sortDesc(int[] ary32) {

		if (ary32.length == 0)

			return ary32;

		Arrays.sort(ary32); // 破壞性寫入

		return rev(ary32);

	}
}