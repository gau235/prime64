package lgpl3.comb.sample;

import lgpl3.comb.PWBlank;
import lgpl3.comb.PWBlankAsCirc;
import lgpl3.o.O;

/**
 * 有留空的 circular 排列.<br/>
 * Circular permutation with blanks.
 *
 * @version 2021/05/22_21:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=P68_PWBlankAsCirc" >P68_PWBlankAsCirc.java</a>
 *
 */
public class P68_PWBlankAsCirc {

	public static void main(String[] sAry) throws Throwable {

		int n = 2;
		int k = 5;

		long[] ary = PWBlankAsCirc.col(n, k);

		O.eq(ary.length, PWBlankAsCirc.int64(n, k));

		O.l(PWBlank.toStrForPWBlankByAryOfB64W6(ary, n, O.S_ARY_A_Z, O.L));

	}
}
