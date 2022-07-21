package lgpl3.comb;

import lgpl3.b32.B32va;
import lgpl3.o.O;
import lgpl3.o.keyNV.KAryV32;

/**
 * @version 2022/05/23_21:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=PCirc_Z" >src</a>
 *
 * @see PCirc
 */
public abstract class PCirc_Z extends PCirc_A {

	private static final Class<?> THIS = PCirc_Z.class;

	/**
	 * 從 1 列全相異數列中取出 k 個數.<br/>
	 * To pick several numbers from a list of distinct numbers.
	 */
	public static void cBefColWNEqK(final int boundBit, int rmdK, int prefix, int curBit, KAryV32 kV) {

		if (--rmdK == 0) { // O.l("prefix=" + B32va.str16(prefix));

			int lowest1;

			do {
				rmdK = (curBit | prefix);

				colRecurWNEqK(B32va.log2NPlus1(lowest1 = (-rmdK & rmdK)), (~lowest1 & rmdK), kV); // 借用 rmdK 當容器

			} while ((curBit <<= 1) != boundBit);

			return;

		}

		int newBoundBit = boundBit >>> rmdK;

		do
			cBefColWNEqK(boundBit, rmdK, (curBit | prefix), (curBit <<= 1), kV);

		while (curBit != newBoundBit);

	}

	/**
	 * 從 1 全相異數列中取出 k 個數做環狀排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to do circular permutation.
	 */
	public static long[] colRecur(int n, int k) {

		if (n <= 0 || n > 30 || k <= 0 || n < k) // fuck, about 30, see toStrToOntoBySAryByB32

			O.x("n=" + n + ", k=" + k);

		KAryV32 ret = new KAryV32(int64(n, k));

		if (k == 1) {

			for (; n-- != 0;)

				ret.k[n] = (n + 1);

			return ret.k;

		}

		cBefColWNEqK((0b1 << n), k, 0b0, 0b1, ret);

		return ret.k;

	}
}
