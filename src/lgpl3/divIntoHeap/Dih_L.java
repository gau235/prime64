package lgpl3.divIntoHeap;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.O;
import lgpl3.o.ary.Aryva;
import lgpl3.o.keyNV.KAryV32;
import lgpl3.shareWXyz.Hxy;

/**
 * @version 2022/04/05_20:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Dih_L" >Dih_L.java</a>
 *
 * @see Dih_R
 */
public abstract class Dih_L extends Dih_A {

	private static final Class<?> THIS = Dih_L.class;

	/**
	 * n 個相同物品分成 k 堆, 每堆最少 min 個.<br/>
	 * To return the number of ways to divide several identical items into several identical heaps.
	 */
	public static void natureColRecurForMaxN(int n, int k, int min, long prefix, KAryV32 retKAryV32) { // max eq n 才可用

		if (k == 1) {

			retKAryV32.ary[retKAryV32.int32++] = ((prefix << B64W6.$6) | n);

			// if (O.isDev) O.l("add=" + Hxy.toStrByVCellPlusMinMinus1(((prefix << B64W6.$6) | n), 1), THIS);

			return;

		}

		n -= min; // O.l("n=" + n, THIS);

		k--;

		prefix <<= B64W6.$6;

		do
			natureColRecurForMaxN(n, k, min, (prefix | min), retKAryV32);

		while (--n >= (k * ++min)); // n minus 1 then min plus 1

	}

	/**
	 * n 個相同物品分成 k 堆, 每堆最少 min 個.<br/>
	 * To return the number of ways to divide several identical items into several identical heaps.
	 *
	 * @see Hxy #col(int, int, int, int)
	 */
	public static long[] natureCol(int n, int k, int min) { // max must be n 才可用

		n = reguByMin1(n, k, min, n) & B64W6.MASK32;

		// if (k == 1) return new long[] { n };

		KAryV32 retKAryV32 = new KAryV32(int64(n, k, 1, n));

		natureColRecurForMaxN(n, k, 1, 0b0L, retKAryV32);

		if (O.isDev)

			O.eq(retKAryV32.int32, Aryva.checkDup(retKAryV32.ary).length);

		return retKAryV32.ary;

	}
}
