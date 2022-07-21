package lgpl3.comb;

import lgpl3.o.O;
import lgpl3.o.ary.Seq;

/**
 * 有留空的 circular 排列.<br/>
 * Circular permutation with blanks.
 *
 * @version 2021/05/22_21:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=PWBlankAsCirc" >PWBlankAsCirc.java</a>
 *
 * @see PWBlank
 */
public abstract class PWBlankAsCirc extends PWBlank_A {

	// private static final Class<?> THIS = PWBlankAsCirc.class;

	/**
	 * Circular permutation with blank.<br/>
	 * Circular permutation with blank.
	 */
	public static long int64(int n, int k) {

		if (n >= k)
			O.x("n=" + n + ", k=" + k);

		// n < k
		return (int64(k - 1) / int64(k - n));

	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public static long[] col(int n, int k) {

		if (n <= 0 || n > 30 || k <= 0 || n >= k)
			O.x("n=" + n + ", k=" + k);

		int b32Base = ~(-0b1 << k);

		// int theBlank = k - n;
		int b32Blank = (-0b1 << n) & b32Base; // 取高位

		long prefix = 0b1L; // fuck
		Seq seq = new Seq();
		col(b32Base, b32Blank, prefix, k, seq);

		return seq.trim().ary;

	}
}
