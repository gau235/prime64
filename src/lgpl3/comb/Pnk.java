package lgpl3.comb;

import lgpl3.o.O;
import lgpl3.o.keyNV.KAryV32;

/**
 * 排列.<br/>
 * Permutation.
 *
 * @version 2022/06/24_10:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Pnk" >src</a>
 *
 * @see PByToInEx
 *
 * @see PWBlank
 */
public abstract class Pnk extends Pnk_Z {

	/**
	 * If passes test.
	 */
	public static void test() {

		long ans;

		KAryV32 kAryV32;

		for (int n = 11, k; n != 0; n--)

			for (k = n; k != 0; k--) {

				ans = O.eq(colRecur(n, k).length, int64(n, k));

				O.eq(colByLoopBreadth(n, k).length, ans);
				O.eq(colByLoopBreadthNDepthFirst(n, k).length, ans);

				///////////////////////////////////////////////////

				colRecurWNGteK(~(-0b1 << n), 0b0L, kAryV32 = new KAryV32(int64(n, k)), k);

				O.eq(kAryV32.v, ans);

			}
	}
}
