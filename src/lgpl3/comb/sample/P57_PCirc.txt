package lgpl3.comb.sample;

import lgpl3.comb.PCirc;
import lgpl3.comb.Pnk;
import lgpl3.o.O;

/**
 * 環狀排列.<br/>
 * Circular permutation.
 *
 * @version 2021/05/22_11:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=P57_PCirc" >P57_PCirc.java</a>
 *
 */
public class P57_PCirc {

	public static void main(String[] sAry) throws Throwable {

		int n = 5;
		int k = 3;

		long[] ary = PCirc.colRecur(n, k);

		O.l(Pnk.strByAryOfRevB64W6BySAry(ary, O.S_ARY_A_Z));

		O.l("len=" + O.eq(ary.length, PCirc.int64(n, k)));

	}
}
