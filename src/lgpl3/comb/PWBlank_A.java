package lgpl3.comb;

import lgpl3.b32.B32va;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.O;
import lgpl3.o.ary.Seq;

/**
 * @version 2021/05/22_19:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=PWBlank_A" >PWBlank_A.java</a>
 *
 * @see PWBlank
 */
public abstract class PWBlank_A extends Pnk_Z {

	// private static final Class<?> THIS = PWBlank_A.class;

	/**
	 * Permutation with blanks.<br/>
	 * k!/(k-n)!
	 */
	public static long int64(int n, int k) {

		if (n >= k)
			O.x("n=" + n + ", k=" + k);

		// n < k
		return (int64(k) / int64(k - n));

	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public static void col(final int b32Base, final int b32Blank, long prefix, final int k, Seq seq) {

		int keptB32;
		if (prefix == 0b0L)
			keptB32 = 0b0;

		else
			keptB32 = B64W6.toB32As2PowByB6Cell(prefix);

		int rmdB32 = (~keptB32 & b32Base);

		if ((B32va.countOf1(keptB32) + 1) == k) {

			int lowest1;
			for (; rmdB32 != 0b0; rmdB32 = (~lowest1 & rmdB32)) {

				lowest1 = (-rmdB32 & rmdB32);

				if ((b32Blank & lowest1) == 0b0)
					seq.a((prefix << B64W6.$6) | B32va.log2NPlus1(lowest1));

				else {

					if (lowest1 > B32va.highest1(keptB32))
						seq.a((prefix << B64W6.$6) | B32va.log2NPlus1(lowest1));

					else
						continue;

				}
			}

			return;

		}

		int lowest1;
		for (; rmdB32 != 0b0; rmdB32 = (~lowest1 & rmdB32)) {

			lowest1 = (-rmdB32 & rmdB32);

			if ((b32Blank & lowest1) == 0b0)
				col(b32Base, b32Blank, (prefix << B64W6.$6) | B32va.log2NPlus1(lowest1), k, seq);

			else {

				if (lowest1 > B32va.highest1(keptB32))
					col(b32Base, b32Blank, (prefix << B64W6.$6) | B32va.log2NPlus1(lowest1), k, seq);

				else
					continue;

			}
		}
	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public static long[] col(int n, int k) {

		if (n <= 0 || n > 30 || k <= 0)
			O.x("n=" + n + ", k=" + k);

		int b32Base = ~(-0b1 << k);

		// int theBlank = k - n;
		int b32Blank = (-0b1 << n) & b32Base; // 取高位

		// O.l("b32Base=" + B32va.str(b32Base));
		// O.l("b32Blank=" + B32va.str(b32Blank));

		Seq seq = new Seq();

		col(b32Base, b32Blank, 0b0L, k, seq);

		return seq.trim().ary;

	}
}
