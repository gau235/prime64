package lgpl3.shareWXyz;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.divIntoHeap.Dih;
import lgpl3.o.B;

/**
 * @version 2022/03/05_11:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=HxyVal_A" >HxyVal_A.java</a>
 *
 * @see HxyVal
 */
public abstract class HxyVal_A extends ShareWXyzVal {

	private static final Class<?> THIS = HxyVal_A.class;

	/**
	 * 即 n 個相同物品分成給 k 人, 每人最少 1 個.<br/>
	 * To return the number of ways to share several identical items with every person.<br/>
	 * k as termination condition.
	 */
	public static long recurInt64WLim0ToMax(int n, int k, final int min, final long b64W6ForMaxPlus1, long prefix) {

		B.n32++;

		if (k == 1) {

			if (n <= (((int) b64W6ForMaxPlus1) & B64W6.MASK32)) // need to be limited by bound32Max

				return 1L;

			return 0L;

		}

		k--;

		// note: get every max from leftmost
		final int curMax = ((int) (b64W6ForMaxPlus1 >>> (B64W6.$6 * k)) & B64W6.MASK32);

		final int globalMax = (((int) b64W6ForMaxPlus1) & B64W6.MASK32); // tail

		// O.l("globalMax=" + globalMax, THIS);

		// Hxy(10,3) with limMax[2,9,9]
		// diyMax may be 8 as 8 + 1 + 1 = 10
		// but diyMax can not > 2

		int diyMax = ((diyMax = n - min * k) > curMax) ? curMax : diyMax; // predict

		// Hxy(10,3) with limMax[2,8,9] // more and more larger
		// diyMin may be -6 as -6 + 8 + 8 = 10
		// but diyMin can not < 1

		int diyMin = ((diyMin = n - globalMax * k) < min) ? min : diyMin; // predict

		long ans = 0L;

		for (; diyMin <= diyMax; diyMin++) {

			ans += recurInt64WLim0ToMax((n - diyMin), k, min, b64W6ForMaxPlus1, (prefix << B64W6.$6) | diyMin);
		}

		return ans;

	}

	/**
	 * 即 n 個相同物品分成給 k 人, 每人最少 1 個.<br/>
	 * To return the number of ways to share several identical items with every person.
	 *
	 * @see Hxy #colWLim0ToMax(int, int, long)
	 */
	public static long int64WLim0ToMax(int n, int k, long sortedB64W6ForMaxPlus1 /* sorted desc */) {

		// O.l("sortedB64W6ForMaxPlus1=" + O.L + B64W6.str24(sortedB64W6ForMaxPlus1), THIS);
		// sortedB64W6ForMaxPlus1 = B64W6.revAmongVCell(sortedB64W6ForMaxPlus1);

		n = n + k; // min must be 0

		// must check B64W6.$MAX_INT32_IN_CELL
		Dih.checkArg(n, k, 1, n); // now min=1, the sortedB64W6ForMaxPlus1 will limit all

		return recurInt64WLim0ToMax(n, k, 1, sortedB64W6ForMaxPlus1, 0b0L);

	}
}
