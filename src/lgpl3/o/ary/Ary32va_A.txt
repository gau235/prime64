package lgpl3.o.ary;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 本類別是使用 32 位元的整數陣列.<br/>
 * The array of 32 bit integer.
 *
 * @version 2021/06/14_20:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ary32va_A" >Ary32va_A.java</a>
 *
 * @see Ary32va
 */
public abstract class Ary32va_A {

	private static final Class<?> THIS = Ary32va_A.class;

	/**
	 * To sum.<br/>
	 * To sum.
	 */
	public static long sum64(int[] ary32) {

		long ans = 0L;

		for (int idx = ary32.length; idx-- != 0;)

			ans += ary32[idx];

		return ans;

	}

	/**
	 * To sum.<br/>
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

		int[] retAry32 = new int[len];

		for (int idx = 0; idx != len;)

			retAry32[idx] = ++idx;

		return retAry32;

	}

	/**
	 * To check if find.<br/>
	 * To check if find.
	 */
	public static int findFirstOccur(int[] ary32, int fromIdx, int key32) {

		for (int len = ary32.length; fromIdx != len; fromIdx++)

			if (ary32[fromIdx] == key32)

				return fromIdx;

		return Integer.MIN_VALUE; // todo: return -insertionPoint - 1

	}

	/**
	 * To check if find.<br/>
	 * To check if find.
	 *
	 * @see B64W6#findFirstOccurDownTo0(long, int, int)
	 */
	public static int findFirstOccurDownTo0(int[] ary32, int bound, int key32) {

		for (; bound >= 0; bound--)

			if (ary32[bound] == key32)

				return bound;

		return Integer.MIN_VALUE; // todo: return -insertionPoint - 1

	}

	/**
	 * To check if contain.<br/>
	 * To check if contain.
	 */
	public static boolean ifContain(int[] ary32, int from, int to, int key32) {

		for (; from < to; from++)

			if (ary32[from] == key32)

				return B.I;

		return B.O;

	}
}