package lgpl3.shareWXyz;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.divIntoHeap.Dih;
import lgpl3.o.B;
import lgpl3.o.ary.Seq;
import lgpl3.o.keyNV.KAryV32;

/**
 * Hxy(myN, myK) eq Hnr(myK, myN)
 *
 * @version 2022/03/03_18:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Hxy_A" >Hxy_A.java</a>
 *
 * @see Hxy_T
 */
public abstract class Hxy_A extends ShareWXyz {

	private static final Class<?> THIS = Hxy_A.class;

	/**
	 * 即 n 個相同物品分成給 k 人, 每人最少 1 個.<br/>
	 * To return the number of ways to share several identical items with every person. int restK as termination condition.
	 *
	 * @see Dih #colRecur(int, int, int, int, long, Seq)
	 */
	public static void colRecur(int n, int k, int min, int max, long prefix, KAryV32 kAryV32) {

		B.n32++;

		if (k == 1) {

			kAryV32.ary[kAryV32.int32++] = ((prefix << B64W6.$6) | n); // O.l(Hxy.toStrByVCellPlusMinMinus1(prefix, min));

			return;

		}

		// int newN
		// int newK as k - 1
		// int newMin after regularized min always 1
		// int newMax

		k--;

		int newMin = ((newMin = n - max * k) < min) ? min : newMin; // predict

		int newMax = ((newMax = n - k * min) > max) ? max : newMax; // predict

		// min (總是 from 原始 min) max for 這一層
		// newMin newMax for 下一層

		// 10 share with 3
		// 3,1,6 ok
		// 3,2,5 ok
		// 3,3,4 ok
		// 3,4,3 ok
		// 3,5,2 ok

		int upBound = newMax; // 下界 1, 上界最好為 n

		for (int giveV = newMin, rmdN; giveV <= upBound;) {

			rmdN = n - giveV;

			// O.l("up giveV=" + giveV + " rmdN=" + rmdN + ", k=" + k + ", min=" + newMin + ", max=" + newMax, THIS);

			if ((newMax * k) >= rmdN && (newMin * k) <= rmdN) {

				// O.l("add=", THIS); // B.n = 1 / 0;

				colRecur(rmdN, k, newMin, newMax, ((prefix << B64W6.$6) | giveV), kAryV32);

			}

			giveV++;

			// 以下用 [n,k,min,max]=[3,2,1,3] err
			// rmdN = n - giveV;
			// newMax = ((newMax = rmdN - newMin * k) > max) ? max : newMax; // newMax 每次都不一樣 newMin 穩定不變

			// O.l("down giveV=" + giveV + " rmdN=" + rmdN + ", k=" + k + ", min=" + newMin + ", max=" + newMax, THIS);

		}
	}

	/**
	 * 即 n 個相同物品分成給 k 人, 每人最少 1 個.<br/>
	 * To return the number of ways to share several identical items with every person.
	 *
	 * @see Dih#col(int, int, int, int)
	 */
	public static long[] col(int n, int k, int min, int max) {

		// regularize
		// check arg
		// special case

		int reguB32W6 = Dih.reguByMin1(n, k, min, max);

		n = (reguB32W6 & B64W6.MASK32);
		max = ((reguB32W6 >>> B64W6.$6) & B64W6.MASK32);

		// Dih.checkArg(n, k, 1, max);

		// O.x("aft n=" + n + ", k=" + k + ", min=" + 1 + ", max=" + max + THIS);

		KAryV32 retKAryV32 = new KAryV32(HxyVal.int64(n, k, 1, max));

		colRecur(n, k, 1, max, 0b0L, retKAryV32);

		return retKAryV32.ary;

	}
}
