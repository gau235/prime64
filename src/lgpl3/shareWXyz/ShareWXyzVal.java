package lgpl3.shareWXyz;

import lgpl3.comb.Cnk;
import lgpl3.comb.Pnk;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.divIntoHeap.Dih;
import lgpl3.o.O;
import lgpl3.o.ary.Seq;
import lgpl3.o.keyNV.KAryV32;

/**
 * 即 n 個相同物品分成給 k 人, 每人最少 1 個.<br/>
 * The number of ways to share several identical items with every person.
 *
 * @version 2022/03/05_11:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=ShareWXyzVal" >ShareWXyzVal.java</a>
 *
 * @see HxyVal_A
 *
 * @see Dih
 *
 * @see HxyVal
 *
 * @see Hxy
 */
public abstract class ShareWXyzVal {

	private static final Class<?> THIS = ShareWXyzVal.class;

	/**
	 * 6!/(1!*2!*3!)<br/>
	 * 6!/(1!*2!*3!)
	 */
	public static long factorialNDiv(long factorialOfK, long b64W6OfQtyPlus1) {

		int vCell = (((int) b64W6OfQtyPlus1) & B64W6.MASK32);
		do
			if (--vCell > 1) // O.l("vCell=" + vCell, THIS);

				factorialOfK /= Pnk.int64(vCell);

		while ((vCell = ((int) (b64W6OfQtyPlus1 >>>= B64W6.$6)) & B64W6.MASK32) != 0b0);

		return factorialOfK;

	}

	/**
	 * 即 n 個相同物品分成給 k 人, 每人最少 1 個.<br/>
	 * To return the number of ways to share several identical items with every person.
	 */
	// todo: get int64 by Dih with factorialOfK recursively
	public static long int64ByDih(int n, int k, int min, int max) { // O.l("min=" + min, THIS);

		long[] ary = Dih.col(n, k, min, max);

		long factorialOfK = Pnk.int64(k), b64W6Dup, tmp, ans = 0L;

		for (int idx = ary.length, vCell; idx-- != 0;) {

			b64W6Dup = B64W6.countDupNRev(ary[idx]);

			tmp = factorialOfK;

			for (; b64W6Dup != 0b0L; b64W6Dup >>>= B64W6.$6)

				if ((vCell = ((int) b64W6Dup) & B64W6.MASK32) != 0b0) // O.l("vCell=" + vCell, THIS);

					tmp /= Pnk.int64(vCell);

			ans += tmp;

		}

		return ans;

	}

	/**
	 * 即 n 個相同物品分成給 k 人, 每人最少 1 個.<br/>
	 * To return the number of ways to share several identical items with every person. <br/>
	 * The k as termination condition.
	 *
	 * @see Hxy #colRecur(int, int, int, int, long, KAryV32)
	 *
	 * @see Dih #colRecur(int, int, int, int, long, Seq)
	 */
	public static long recur(int n, int k, int max) { // after regularized min always 1

		if (k-- == 1)

			return 1L;

		// min (總是 from 1) max for 這一層
		// newMin newMax for 下一層

		// int newN
		// int newK as k - 1
		// int newMin after regularized min always 1
		// int newMax

		// 10 share with 3
		// 3,1,6 ok
		// 3,2,5 ok
		// 3,3,4 ok
		// 3,4,3 ok
		// 3,5,2 ok

		long ans = 0L;

		int avg = max; // 下界 1, 上界最好為 n

		int maxXNewK = max * k; // newK is k-1

		// todo: newMax 每次都不一樣 newMin 穩定不變 想處理但是很棘手

		for (int giveV = 1, rmdN, tmp32; giveV <= avg; giveV++) {

			rmdN = n - giveV;

			if (maxXNewK >= rmdN && k <= rmdN /* rmdN >= newK * (min=1) */ )

				if (max >= rmdN - (tmp32 = (k - 1))) // 下界 1, 上界最好為 n

					ans += Cnk.int64(rmdN - 1, tmp32); // 下一層的行為
				else
					ans += recur(rmdN, k, ((Dih.reguByMin1(rmdN, k, 1, max) >>> B64W6.$6) & B64W6.MASK32) /* reguMax */);

		}

		return ans;

	}

	/**
	 * 即 n 個相同物品分成給 k 人, 每人最少 1 個.<br/>
	 * To return the number of ways to share several identical items with every person.
	 *
	 * @see Dih #col(int, int, int, int)
	 */
	public static long int64(int n, int k, int min, int max) {

		// regularize
		// check arg
		// special case

		if (min < 0)

			O.x("n=" + n + ", k=" + k + ", min=" + min + ", max=" + max);

		int reguB32W6 = Dih.reguByMin1(n, k, min, max);

		n = (reguB32W6 & B64W6.MASK32);
		max = ((reguB32W6 >>> B64W6.$6) & B64W6.MASK32);

		// Dih.checkArg(n, k, 1, max);

		if (n == k || k == 1)

			return 1L;

		return recur(n, k, max);

	}
}
