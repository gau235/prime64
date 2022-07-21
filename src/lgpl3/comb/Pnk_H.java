package lgpl3.comb;

import lgpl3.b32.B32va;
import lgpl3.b64.B64va;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Seq;
import lgpl3.o.keyNV.KAryV32;

/**
 * @version 2022/06/22_23:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Pnk_H" >src</a>
 *
 * @see Pnk_J
 */
public abstract class Pnk_H extends Pnk_A {

	// private static final Class<?> THIS = Pnk_H.class;

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public static void colRecurWNEqK(int rmdB32, long prefix, KAryV32 kV) {

		prefix <<= B64W6.$6;

		if ((-rmdB32 & rmdB32) == rmdB32) {

			kV.k[kV.v++] = (prefix | B32va.log2NPlus1(rmdB32));

			return;

		}

		int allBullet = rmdB32, bullet; // O.l("bullet=" + B32va.str16(allBullet));

		do
			colRecurWNEqK((~(bullet = (-allBullet & allBullet)) & rmdB32), (prefix | B64va.log2NPlus1(bullet)), kV);

		while ((allBullet = (~bullet & allBullet)) != 0b0); // 子彈打完

	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public static long[] colRecur(int n, int k) {

		if (n <= 0 || n > 30 || k <= 0 || n < k) // fuck, about 30, see toStrToOntoBySAryByB32, B32va.log2

			O.x("n=" + n + ", k=" + k);

		KAryV32 retKV = new KAryV32(int64(n, k));

		int[] ary32 = Cnk.colRecur(n, k);

		for (int idx = 0; idx != ary32.length; idx++)

			colRecurWNEqK(ary32[idx], 0b0L, retKV);

		return retKV.k;

	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public static void colRecurWNGteK(int rmdB32, long prefix, KAryV32 kV, int lv) {

		B.n32++;

		prefix <<= B64W6.$6;

		if (--lv == 0) { // O.l("rmdB32=" + rmdB32);

			do
				kV.k[kV.v++] = (prefix | B64va.log2NPlus1(lv = (-rmdB32 & rmdB32))); // 借用 lv 當 lowest1

			while ((rmdB32 = (~lv & rmdB32)) != 0b0L);

			return;

		}

		int allBullet = rmdB32, bullet; // O.l("bullet=" + B32va.str16(allBullet));

		do
			colRecurWNGteK((~(bullet = (-allBullet & allBullet)) & rmdB32), (prefix | B64va.log2NPlus1(bullet)), kV, lv);

		while ((allBullet = (~bullet & allBullet)) != 0b0); // 子彈打完

	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public static void colByLoopBreadth(int baseB32, long prefix, Seq seq) {

		baseB32 = B64W6.filterAftToB32As2PowByVCell(baseB32, prefix); // 借用 baseB32 當 rmdB32

		prefix <<= B64W6.$6;

		int lowest1;
		do
			seq.a(prefix | B32va.log2NPlus1(lowest1 = (-baseB32 & baseB32)));

		while ((baseB32 = (~lowest1 & baseB32)) != 0b0);

	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public static long[] colByLoopBreadth(int n, int k) { // 如同廣先搜尋

		int baseB32 = ~(-0b1 << n), idx = 1; // O.l("baseB32=" + baseB32, THIS);

		Seq seqSun = new Seq(), seqMoon = new Seq(), seqToSwap; // 提升可閱讀性 但是浪費記憶體

		// init
		do
			seqSun.a(idx);

		while (idx++ != n);
		// end init

		if (--k == 0)

			return seqSun.trim().ary;

		do {
			idx = 0;
			n = seqSun.i;

			do
				colByLoopBreadth(baseB32, seqSun.ary[idx], seqMoon); // 如同廣先搜尋

			while (++idx != n); // termination condition

			// swap 重複使用 // 原創
			seqToSwap = seqSun;

			seqSun = seqMoon;

			(seqMoon = seqToSwap).i = 0;
			// end swap 重複使用

		} while (--k != 0);

		return seqSun.trim().ary;

	}
}
