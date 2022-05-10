package lgpl3.comb.sample;

import lgpl3.b32.B32va;
import lgpl3.comb.Cnk;
import lgpl3.comb.filter.CompaForAry32OfB32As2Pow;
import lgpl3.o.O;

/**
 * 組合.<br/>
 * Combination.
 *
 * @version 2022/02/08_22:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex209_CByLoopWSelSort" >
 *          Ex209_CByLoopWSelSort.java</a>
 */
public class Ex209_CByLoopWSelSort {

	public static void main(String[] sAry) throws Throwable {

		int n = 4;
		int k = 3;

		int[] ary32 = Cnk.colByLoopBreadthFirst(n, k);

		CompaForAry32OfB32As2Pow.selSortDesc(ary32);

		for (int i = 0; i != ary32.length; i++)

			O.l(B32va.str16(ary32[i]));

		O.l(Cnk.strByAryOfB32As2Pow(ary32));

		O.l("len=" + O.eq(ary32.length, Cnk.int64(n, k)));

	}
}
