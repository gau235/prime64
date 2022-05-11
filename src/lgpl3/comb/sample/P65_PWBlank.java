package lgpl3.comb.sample;

import lgpl3.comb.PWBlank;
import lgpl3.comb.Pnk;
import lgpl3.o.O;

/**
 * 有留空的排列.<br/>
 * To permutate with blanks.
 *
 * @version 2021/05/22_17:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=P65_PWBlank" >P65_PWBlank.java</a>
 *
 */
public class P65_PWBlank {

	public static void main(String[] sAry) throws Throwable {

		int n = 2;
		int k = 5;

		long[] ary = PWBlank.col(n, k);

		O.eq(ary.length, PWBlank.int64(n, k));

		StringBuilder str1 = PWBlank.toStrForPWBlankByAryOfB64W6(ary, n, O.S_ARY_A_Z, O.L);
		O.l("str1=" + O.L + str1 + O.L);

		StringBuilder str2 = Pnk.strByAryOfRevB64W6BySAry(ary, O.S_ARY_A_Z);
		O.l("str2=" + O.L + str2);

	}
}
