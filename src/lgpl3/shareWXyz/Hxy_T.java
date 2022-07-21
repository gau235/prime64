package lgpl3.shareWXyz;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.divIntoHeap.Dih;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Seq;

/**
 * @version 2022/03/09_16:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Hxy_T" >Hxy_T.java</a>
 *
 * @see Hxy_U
 */
public abstract class Hxy_T extends Hxy_A {

	private static final Class<?> THIS = Hxy_T.class;

	/**
	 * 即 n 個相同物品分成給 k 人, 每人最少 1 個.<br/>
	 * To return the number of ways to share several identical items with every person.<br/>
	 * int k as termination condition.
	 */
	public static void colRecurWLim0ToMax(int n, int k, final int min, final long b64W6ForMaxPlus1, long prefix, Seq seq) {

		// 先假設 min 是固定的, 因為 min 大部分從 1 或 0 開始

		B.n32++;

		if (k == 1) { // termination condition

			if (n <= (((int) b64W6ForMaxPlus1) & B64W6.MASK32)) { // limMax

				// O.l("tmp=" + B64W6.str24((prefix << B64W6.$6) | n), THIS);

				seq.a((prefix << B64W6.$6) | n);

			}

			return;

		}

		k--;

		// note: get every max from leftmost
		final int curMax = ((int) (b64W6ForMaxPlus1 >>> (B64W6.$6 * k)) & B64W6.MASK32);

		// O.l("curMax=" + curMax , THIS);

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

		for (; diyMin <= diyMax; diyMin++) {

			colRecurWLim0ToMax((n - diyMin), k, min, b64W6ForMaxPlus1, ((prefix << B64W6.$6) | diyMin), seq);
		}
	}

	/**
	 * 即 n 個相同物品分成給 k 人, 每人最少 1 個.<br/>
	 * To return the number of ways to share several identical items with every person.
	 *
	 * @see HxyVal #int64WLim0ToMax(int, int, long)
	 */
	// (5, 5, 3) => 000011_000101_000101 is good
	public static long[] colWLim0ToMax(int n, int k, long sortedDescB64W6ForMaxPlus1) {

		B.n32 = 0;

		n = n + k; // min==0

		Dih.checkArg(n, k, 1, n); // min=1, the sortedDescB64W6ForMaxPlus1 will limit all

		Seq seq = new Seq();
		colRecurWLim0ToMax(n, k, 1, sortedDescB64W6ForMaxPlus1, 0b0L, seq);

		O.l("B.n32=" + B.n32, THIS);

		return seq.trim().ary;

	}
}
