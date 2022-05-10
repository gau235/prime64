package lgpl3.comb;

import lgpl3.b32.B32va;
import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.O;
import lgpl3.o.keyNV.K64V32V32;
import lgpl3.o.keyNV.KAryV32;

/**
 * @version 2022/03/22_23:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Dnk_J" >Dnk_J.java</a>
 *
 * @see Dnk_Z
 */
public abstract class Dnk_J extends Dnk_A {

	private static final Class<?> THIS = Dnk_J.class;

	/**
	 * 在一個已完成的錯排隊伍 (全錯排) 中, 若 n 坐了第 k 位:<br/>
	 * 情況 1: 假設 k 去坐第 n 位時, 除了 n 和 k 以外還有 n-2 人, 其錯排數為 D(n-2)<br/>
	 *
	 * 情況 2: 假設 k 不坐在第 n 位 (強假設), 可把第 n 位當成一個另類的 "第 k 位" (k 的忌諱)<br/>
	 * 這時包括 k 在內的剩下 n-1 人形成的每一種錯排,<br/>
	 * 都等價於 n-1 人隊伍的錯排 (只是其中 k 這人的忌諱已變成第 n 位)<br/>
	 *
	 * 尼古拉一世·伯努利: Dn=(n-1)*(Dn-1+Dn-2)
	 */
	public static void colWNEqK(final int baseB32, K64V32V32 k64V32V32, KAryV32 kAryV32) { // i_th as 0b0010

		// O.l("baseB32=" + B32va.str16(baseB32), THIS);

		// K64V32V32: prefix, keptB32, i_th
		long prefix = k64V32V32.int64;

		int keptB32 = k64V32V32.int32A, i_th = k64V32V32.int32B;

		int rmdB32 = (~keptB32 & baseB32); // 直接用 rmdB32 &= ~i_th // 出現 err

		// important: rmdB32 can not be: baseB32^i_th1Lowest1(baseB32, i_th)
		// such as: ABCD^BC (prefix) = AD, but AD can not XOR C (the i_th1Lowest1)

		if (rmdB32 == i_th)
			return;

		prefix <<= B64W6.$6;

		// 在這裡也不行過濾掉 i_th
		// 濾掉 i_th 的話
		// Dnk(3,2) 會變成
		// [B,] => A 被過濾掉
		// [C,] => A 被過濾掉
		// [C,] => B 被過濾掉

		// n equals k
		if ((-rmdB32 & rmdB32) == rmdB32) {

			kAryV32.ary[kAryV32.int32++] = (prefix | B32va.log2NPlus1(rmdB32));

			return;

		}

		rmdB32 = (~i_th & rmdB32); // 在這裡才可過濾掉 i_th, 即這層不可有 i_th

		i_th = (-(i_th << 1) & baseB32); // B32va.next1BitL();
		i_th = (-i_th & i_th); // gen new i_th

		int lowest1;
		do
			colWNEqK(baseB32, new K64V32V32((prefix | B32va.log2NPlus1(lowest1 = (-rmdB32 & rmdB32))), (keptB32 | lowest1), i_th), kAryV32);

		while ((rmdB32 = (~lowest1 & rmdB32)) != 0b0);

	}

	/**
	 * 在一個已完成的錯排隊伍 (全錯排) 中, 若 n 坐了第 k 位:<br/>
	 * 情況 1: 假設 k 去坐第 n 位時, 除了 n 和 k 以外還有 n-2 人, 其錯排數為 D(n-2)<br/>
	 *
	 * 情況 2: 假設 k 不坐在第 n 位 (強假設), 可把第 n 位當成一個另類的 "第 k 位" (k 的忌諱)<br/>
	 * 這時包括 k 在內的剩下 n-1 人形成的每一種錯排,<br/>
	 * 都等價於 n-1 人隊伍的錯排 (只是其中 k 這人的忌諱已變成第 n 位)<br/>
	 *
	 * 尼古拉一世·伯努利: Dn=(n-1)*(Dn-1+Dn-2)
	 */
	public static long[] col(int n, int k) {

		if (n <= 0 || n > 30 || k <= 0 || n < k) // fuck, about 30, see toStrToOntoBySAryByB32, B32va.log2AtB32

			O.x("n=" + n + ", k=" + k);

		int[] ary32AftC = Cnk.colRecur(n, k);

		KAryV32 retKAryV32 = new KAryV32(int64(n, k));

		for (int baseB32, idx = 0, len = ary32AftC.length; idx != len; idx++)

			// K64V32V32: prefix, keptB32, i_th
			colWNEqK((baseB32 = ary32AftC[idx]), new K64V32V32(0b0L, 0b0, (-baseB32 & baseB32)), retKAryV32);

		return retKAryV32.ary;

	}
}
