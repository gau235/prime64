package lgpl3.comb;

import lgpl3.o.O;

/**
 * 排列.<br/>
 * Permutation.
 *
 * @version 2020/04/24_10:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Pnk" >Pnk.java</a>
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

		for (int n = 11, k; n != 0; n--)

			for (k = n; k != 0; k--) {

				ans = O.eq(Pnk.colRecur(n, k).length, Pnk.int64(n, k));

				O.eq(Pnk.colByLoopBreadth(n, k).length, ans);
				O.eq(Pnk.colByLoopBreadthNDepthFirst(n, k).length, ans);

			}
	}
}
