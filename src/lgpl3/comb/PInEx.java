package lgpl3.comb;

import lgpl3.b32.B32va;
import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.O;
import lgpl3.o.ary.Aryva;
import lgpl3.o.keyNV.KAryV32;

/**
 * 排容原理.<br/>
 * 例如 :<br/>
 * A, B, C, D 排成一列, 但 A 不排第 1 位, B 不排第 2 位的方法數 :<br/>
 * 為 4 人有 2 人是限定條件 inEx(4,2).<br/>
 * <br/>
 * To return the inclusion and exclusion function result, the number of<br/>
 * that n people line up but k guys not at their position.<br/>
 * PInEx(n,k)=C(k,0)*n! -C(k,1)*(n-1)! +C(k,2)*(n-2)! - ... +-C(k,k)*(n-k)!
 *
 * @version 2022/03/22_11:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=PInEx" >PInEx.java</a>
 *
 * @see Dnk
 */
public abstract class PInEx extends PByToInEx {

	private static final Class<?> THIS = PInEx.class;

	/**
	 * 回傳亂序數.<br/>
	 * 即 n 個人排成一列後解散再排成一列, 沒有人排在自己原先的位置的方法數.<br/>
	 * D(n)=nD(n-1)+(-1)^n<br/>
	 * 0, 1, 2, 9, 44, 265, 1854,...<br/>
	 * To return the number of ways that n people line up then dismiss, and<br/>
	 * line up again but nobody is at the previous position.
	 *
	 * @see Dnk
	 */
	public static void colWNEqK(final int baseB32, int keptB32, int headKToEx, long prefix, KAryV32 kAryV32, int i_th) {

		int rmdB32 = (~keptB32 & baseB32);

		if ((rmdB32 == i_th) && (headKToEx > 0)) // O.l("headKToEx=" + headKToEx, THIS);
			return;

		prefix <<= B64W6.$6;

		// n equals k
		if ((-rmdB32 & rmdB32) == rmdB32) { // only 1 bit remained

			kAryV32.ary[kAryV32.int32++] = (prefix | B32va.log2NPlus1(rmdB32));

			return;

		}

		// PInEx(3,1,1) 此時取物取出 A 但 A 要殺掉, 此時取物取出 B 但 B 要殺掉

		if (headKToEx-- > 0) {

			rmdB32 = (~i_th & rmdB32); // 在這裡才可過濾掉 i_th

			i_th = (-(i_th << 1) & baseB32); // B32va.next1BitL();
			i_th = (-i_th & i_th); // gen new i_th

		}

		int lowest1;
		do
			colWNEqK(baseB32, (keptB32 | (lowest1 = (-rmdB32 & rmdB32))), headKToEx, (prefix | B32va.log2NPlus1(lowest1)), kAryV32, i_th);

		while ((rmdB32 = (~lowest1 & rmdB32)) != 0b0);

	}

	/**
	 * 回傳亂序數.<br/>
	 * 即 n 個人排成一列後解散再排成一列, 沒有人排在自己原先的位置的方法數.<br/>
	 * D(n)=nD(n-1)+(-1)^n<br/>
	 * 0, 1, 2, 9, 44, 265, 1854,...<br/>
	 * To return the number of ways that n people line up then dismiss, and<br/>
	 * line up again but nobody is at the previous position.
	 */
	public static long[] col(int n, int k, int headKToEx) {

		if (n <= 0 || n > 30 || k <= 0 || n < k || headKToEx < 0)
			O.x("n=" + n + ", k=" + k + ", headKToEx=" + headKToEx);

		// if (k < headKToEx)
		// O.x("k=" + k + ", headKToEx=" + headKToEx);

		int[] ary32AftC = Cnk.colRecur(n, k);

		KAryV32 retKAryV32 = new KAryV32(int64(n, k, headKToEx));

		for (int baseB32, idx = 0, len = ary32AftC.length; idx != len; idx++)

			colWNEqK((baseB32 = ary32AftC[idx]), 0b0, headKToEx, 0b0L, retKAryV32, (-baseB32 & baseB32));

		return retKAryV32.ary;

	}

	/**
	 * If passes test.<br/>
	 * If passes test.
	 */
	public static void test() {

		int n, k, endN = 10, headKToEx;

		for (n = endN; n > 0; n--)

			for (k = n; k > 0; k--)

				for (headKToEx = k; headKToEx > 0; headKToEx--)

					O.eq(Aryva.checkDup(col(n, k, headKToEx)).length, int64(n, k, headKToEx));

	}
}
