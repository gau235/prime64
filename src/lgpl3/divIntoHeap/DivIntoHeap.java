package lgpl3.divIntoHeap;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.comb.filter.Condi;
import lgpl3.divIntoHeap.thr.ThrGrowCacheForDihVal;
import lgpl3.o.O;
import lgpl3.shareWXyz.Hxy;
import lgpl3.shareWXyz.HxyVal;

/**
 * 相同物分堆.<br/>
 * 即 n 個相同物品分成 k 堆, 每堆最少 min 個.<br/>
 * To return the number of ways to divide several identical items into several identical heaps.
 *
 * @version 2022/03/01_21:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=DivIntoHeap" >DivIntoHeap.java</a>
 *
 * @see Dih_A
 *
 * @see Dih
 *
 * @see HxyVal
 *
 * @see Hxy
 */
public abstract class DivIntoHeap {

	private static final Class<?> THIS = DivIntoHeap.class;

	/**
	 * 檢查參數合法性.<br/>
	 * Is the argument legal?
	 */
	public static void checkArg(int n, int k, int min, int max) {

		if (k > B64W6.$TOTAL_CELL || k > n || k < 1 || min < 1 || max > n)

			O.x("n=" + n + ", k=" + k + ", min=" + min + ", max=" + max);

		int nEqDivK = n / k;
		if (nEqDivK < min || nEqDivK > max)

			O.x("n=" + n + ", k=" + k + ", min=" + min + ", max=" + max);

		if (((n - min * (k - 1)) > B64W6.$MAX_INT32_IN_CELL) /* && (n > k * max) */)

			O.x("n=" + n + ", k=" + k + ", min=" + min + ", max=" + max);

	}

	/**
	 * to regularize.<br/>
	 * to regularize.
	 */
	public static int reguByMin1(int n, int k, int min, int max) { // return: 0b_max_n

		int diffOrNewMax;

		if (min != 1) {

			diffOrNewMax = min - 1; // min always 1

			n -= k * diffOrNewMax;

			// O.l("n =" + n, THIS);

			max -= diffOrNewMax;

		}

		// diffOrNewMax = n - (k-1)*min

		max = (max > (diffOrNewMax = (n - k + 1))) ? diffOrNewMax : max;

		if (n <= 0 || max <= 0)

			O.x("n=" + n + ", k=" + k + ", min=" + min + ", max=" + max);

		return ((max << B64W6.$6) | n); // O.l("retB32W6=" + retB32W6, THIS);

	}

	/**
	 * to regularize.<br/>
	 * to regularize.
	 *
	 * @see ThrGrowCacheForDihVal#regu(int, int, int, int)
	 */
	public static Condi reguNCheck(Condi condi) {

		int n = condi.n;
		int k = condi.k;
		int min = condi.min;
		int max = condi.max;

		if (min != 1) {

			int diff = min - 1; // reduce the min to 1

			n -= diff * k;

			min = 1; // fuck
			max -= diff;

		}

		int reguMax = n - k + 1; // n-(k-1)*min
		if (max > reguMax)

			max = reguMax;

		if (k > B64W6.$TOTAL_CELL || k > n || k < 1)

			O.x("n=" + n + ", k=" + k + ", min=" + min + ", max=" + max);

		if ((n - (k - 1) /* min eq 1 */ > B64W6.$MAX_INT32_IN_CELL) || (n > max * k)) // note: n=10 k=3 max=3

			O.x("n=" + n + ", k=" + k + ", min=" + min + ", max=" + max);

		//////////////////////////////////////////

		condi = new Condi();

		condi.n = n;
		condi.k = k;
		condi.min = 1;
		condi.max = max;

		return condi;

	}
}
