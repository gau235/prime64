package lgpl3.comb.sample;

import lgpl3.b32.B32va;
import lgpl3.comb.Cnk;
import lgpl3.o.O;

/**
 * 組合.<br/>
 * Combination.
 *
 * @version 2022/03/15_10:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex206_CByB32As2Pow" >Ex206_CByB32As2Pow.java</a>
 *
 */
public class Ex206_CByB32As2Pow {

	public static void main(String[] sAry) throws Throwable {

		int n = 4;
		int k = 2;

		int[] ary32 = Cnk.colRecur(n, k);

		for (int idx = 0; idx != ary32.length; idx++)

			O.l(B32va.str16(ary32[idx]));

		O.l(Cnk.strByAryOfB32As2Pow(ary32));

		O.l("C(" + n + "," + k + ")=" + O.eq(ary32.length, Cnk.int64(n, k)));

	}
}
