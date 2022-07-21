package lgpl3.comb;

import lgpl3.b32.B32va;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.O;
import lgpl3.o.keyNV.KAryV32;

/**
 * @version 2022/06/23_12:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Dnk_J" >src</a>
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
	public static void colWNEqK(int baseB32, int rmdB32, int exBit, long prefix, KAryV32 ret) {

		prefix <<= B64W6.$6;

		// 在這裡也不行過濾掉 exBit, 濾掉 exBit 的話
		//
		// Dnk(3,2) 會變成
		// [B,] => A 被過濾掉
		// [C,] => A 被過濾掉
		// [C,] => B 被過濾掉
		if ((-rmdB32 & rmdB32) == rmdB32) { // n equals k

			ret.k[ret.v++] = (prefix | B32va.log2NPlus1(rmdB32));

			return;

		}

		int allBullet = (~exBit & rmdB32), bullet; // 在這裡才可過濾掉 exBit, 即這層不可有 exBit

		exBit = (-(exBit = (-(exBit << 1) & baseB32)) & exBit); // B32va.next1BitL

		do {
			if ((~(bullet = (-allBullet & allBullet)) & rmdB32) != exBit) // 提早判斷

				colWNEqK(baseB32, (~bullet & rmdB32), exBit, (prefix | B32va.log2NPlus1(bullet)), ret);

		} while ((allBullet = (~bullet & allBullet)) != 0b0);

	}

	/**
	 * 從 1 列全相異數列中取出 k 個數.<br/>
	 * To pick several numbers from a list of distinct numbers.
	 */
	public static void cBefColWNEqK(final int boundBit, int rmdK, int prefix, int curBit, KAryV32 ret) {

		if (--rmdK == 0) { // O.l("prefix=" + B32va.str16(prefix));

			do
				colWNEqK((rmdK = (curBit | prefix)), rmdK, (-rmdK & rmdK), 0b0L, ret); // 借用 rmdK 當容器

			while ((curBit <<= 1) != boundBit);

			return;

		}

		int newBoundBit = boundBit >>> rmdK;

		do
			cBefColWNEqK(boundBit, rmdK, (curBit | prefix), (curBit <<= 1), ret);

		while (curBit != newBoundBit);

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

		if (k == 1)

			return O.ARY0;

		KAryV32 retKV = new KAryV32(int64(n, k));

		cBefColWNEqK((0b1 << n), k, 0b0, 0b1, retKV);

		return retKV.k;

	}
}
