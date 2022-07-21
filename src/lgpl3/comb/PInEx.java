package lgpl3.comb;

import lgpl3.b32.B32va;
import lgpl3.comb.b64WVCell.B64W6;
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
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=PInEx" >src</a>
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
	 */
	public static void colWNEqK(int baseB32, int rmdB32, int headKToEx, int exBit, long prefix, KAryV32 ret, int lv) {

		prefix <<= B64W6.$6;

		// O.lv(lv, "rmdB32=" + B32va.str16(rmdB32));

		// 在這裡也不行過濾掉 exBit, 濾掉 exBit 的話
		//
		// Dnk(3,2) 會變成
		// [B,] => A 被過濾掉
		// [C,] => A 被過濾掉
		// [C,] => B 被過濾掉
		if ((-rmdB32 & rmdB32) == rmdB32) { // n equals k

			// O.lv(lv, "prefix=" + B64W6.str24((prefix | B32va.log2NPlus1(rmdB32))));

			ret.k[ret.v++] = (prefix | B32va.log2NPlus1(rmdB32));

			return;

		}

		int allBullet, bullet;

		if (headKToEx-- > 0) {

			// O.lv(lv, "headKToEx=" + headKToEx);

			allBullet = (~exBit & rmdB32); // 在這裡才可過濾掉 exBit, 即本層不可有 exBit

			// O.lv(lv, "ex allBullet=" + B32va.str16(allBullet));

			exBit = (-(exBit = (-(exBit << 1) & baseB32)) & exBit); // B32va.next1BitL

			// O.lv(lv, "ex exBit=" + B32va.str16(exBit));

			do {
				bullet = (-allBullet & allBullet);

				if ((headKToEx <= 0) || (~bullet & rmdB32) != exBit) // 提早判斷

					colWNEqK(baseB32, (~bullet & rmdB32), headKToEx, exBit, (prefix | B32va.log2NPlus1(bullet)), ret, lv + 1);

			} while ((allBullet = (~bullet & allBullet)) != 0b0);

		} else {

			allBullet = rmdB32; // O.l("allBullet=" + B32va.str16(allBullet));

			do {
				bullet = (-allBullet & allBullet);

				colWNEqK(baseB32, (~bullet & rmdB32), headKToEx, exBit, (prefix | B32va.log2NPlus1(bullet)), ret, lv + 1);

			} while ((allBullet = (~bullet & allBullet)) != 0b0); // 子彈打完

		}
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

		if (k < headKToEx)

			O.x("k=" + k + ", headKToEx=" + headKToEx);

		if (k == 1 && headKToEx == 1)

			return O.ARY0;

		int[] ary32AftC = Cnk.colRecur(n, k);

		KAryV32 retKV = new KAryV32(int64(n, k, headKToEx));

		for (int idx = 0, len = ary32AftC.length, allBit; idx != len; idx++)

			colWNEqK((allBit = ary32AftC[idx]), allBit, headKToEx, (-allBit & allBit), 0b0L, retKV, 1);

		return retKV.k;

	}

	/**
	 * If passes test.
	 */
	public static void test() {

		int n, k, endN = 10, headKToEx;

		for (n = endN; n != 0; n--)

			for (k = n; k != 0; k--)

				for (headKToEx = k; headKToEx >= 0; headKToEx--)

					if (Aryva.checkDup(col(n, k, headKToEx)).length != int64(n, k, headKToEx))

						O.x("n=" + n + ", k=" + k + ", headKToEx=" + headKToEx);

	}
}
