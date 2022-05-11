package lgpl3.comb;

import lgpl3.b32.B32va;
import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.O;
import lgpl3.o.ary.Seq;
import lgpl3.o.keyNV.KAryV32;

/**
 * @version 2022/02/22_23:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Pnk_H" >Pnk_H.java</a>
 *
 * @see Pnk_J
 */
public abstract class Pnk_H extends Pnk_A {

	// private static final Class<?> THIS = Pnk_H.class;

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public static void colRecurWNGteK(int baseB32, long prefix, int keptB32, int rmdK, KAryV32 kAryV32) {

		int rmdB32 = (~keptB32 & baseB32), lowest1; // rmdB32 是子彈

		prefix <<= $6;

		if (--rmdK == 0) { // O.l("baseB32=", "keptB32=", baseB32, keptB32);

			do
				kAryV32.ary[kAryV32.int32++] = (prefix | B32va.log2NPlus1(lowest1 = (-rmdB32 & rmdB32)));

			while ((rmdB32 = (~lowest1 & rmdB32)) != 0b0);

			return;

		}

		do
			colRecurWNGteK(baseB32, (prefix | B32va.log2NPlus1(lowest1 = (-rmdB32 & rmdB32))), (keptB32 | lowest1), rmdK, kAryV32);

		while ((rmdB32 = (~lowest1 & rmdB32)) != 0b0); // 子彈打完

	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public static void colByLoopBreadth(int baseB32, long prefix, Seq seq) {

		int rmdB32 = B64W6.filterAftToB32As2PowByB6Cell(baseB32, prefix), lowest1;

		do
			seq.a((prefix << B64W6.$6) | B32va.log2NPlus1(lowest1 = (-rmdB32 & rmdB32)));

		while ((rmdB32 = (~lowest1 & rmdB32)) != 0b0);

	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public static long[] colByLoopBreadth(int n, int k) { // 如同廣先搜尋

		final int baseB32 = ~(-0b1 << n); // O.l("baseB32=" + baseB32, THIS);

		Seq retSeq = new Seq();

		// init
		int idx = 1;
		do
			retSeq.a(idx);

		while (idx++ != n);
		// end init

		if (--k == 0)

			return retSeq.trim().ary;

		Seq tmpSeq;

		do {
			tmpSeq = new Seq();

			for (idx = 0; idx != retSeq.iLen; idx++) // 如同廣先搜尋

				colByLoopBreadth(baseB32, retSeq.ary[idx], tmpSeq);

			retSeq = tmpSeq;

		} while (--k != 0);

		return retSeq.trim().ary;

	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public static void colRecurWNEqK(long prefix, int rmdB32, KAryV32 retKAryV32) {

		prefix <<= $6;

		if ((-rmdB32 & rmdB32) == rmdB32) {

			retKAryV32.ary[retKAryV32.int32++] = (prefix | B32va.log2NPlus1(rmdB32));

			return;

		}

		int myRmdB32 = rmdB32, lowest1; // 子彈 O.l("tmpR32=" + B32va.str16(tmpR32));

		do
			colRecurWNEqK((prefix | B32va.log2NPlus1(lowest1 = (-myRmdB32 & myRmdB32))), (~lowest1 & rmdB32), retKAryV32);

		while ((myRmdB32 = (~lowest1 & myRmdB32)) != 0b0); // 子彈打完

	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public static long[] colRecur(int n, int k) {

		if (n <= 0 || n > 30 || k <= 0 || n < k) // fuck, about 30, see toStrToOntoBySAryByB32, B32va.log2

			O.x("n=" + n + ", k=" + k);

		KAryV32 retKAryV32 = new KAryV32(int64(n, k));

		int[] ary32 = Cnk.colRecur(n, k);

		for (int idx = 0; idx != ary32.length; idx++)

			colRecurWNEqK(0b0L, ary32[idx], retKAryV32);

		return retKAryV32.ary;

	}
}
