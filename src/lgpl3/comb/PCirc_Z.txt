package lgpl3.comb;

import lgpl3.b32.B32va;
import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.O;
import lgpl3.o.keyNV.KAryV32;

/**
 * @version 2021/01/23_21:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=PCirc_Z" >PCirc_Z.java</a>
 *
 * @see PCirc
 */
public abstract class PCirc_Z extends PCirc_A {

	// private static final Class<?> THIS = PCirc_Z.class;

	/**
	 * 從 1 全相異數列中取出 k 個數做環狀排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to do circular permutation.
	 */
	public static long[] colRecur(int n, int k) {

		if (n <= 0 || n > 30 || k <= 0 || n < k) // fuck, about 30, see toStrToOntoBySAryByB32
			O.x("n=" + n + ", k=" + k);

		KAryV32 retKAryV32 = new KAryV32(int64(n, k));

		if (k == 1) {

			for (int i = 1; i <= n; i++)

				retKAryV32.ary[retKAryV32.int32++] = i;

			return retKAryV32.ary;

		}

		int[] ary32 = Cnk.colRecur(n, k);

		if (k == 2) {

			for (int idx = 0; idx != ary32.length; idx++)

				retKAryV32.ary[retKAryV32.int32++] = B64W6.toDescB64W6ByLog2NPlus1(ary32[idx]);

			return retKAryV32.ary;

		}

		for (int baseB32, idx = 0, lowest1; idx != ary32.length; idx++) // O.l("baseB32=" + B32va.str16(baseB32), THIS);

			colRecurWNEqK(B32va.log2NPlus1(lowest1 = (-(baseB32 = ary32[idx]) & baseB32)), (~lowest1 & baseB32), retKAryV32);

		return retKAryV32.ary;

	}
}
