package lgpl3.comb.stirlingN.sample;

import lgpl3.comb.filter.CompaForAry32OfB32As2Pow;
import lgpl3.comb.filter.Condi;
import lgpl3.comb.stirlingN.S2nk;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Ary32_2D;

/**
 * Stirling number of the second kind.<br/>
 * Stirling number of the second kind.
 *
 * @version 2020/02/09_10:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex22_S2Recur" >Ex22_S2Recur.java</a>
 *
 *
 *
 * @see Ex22_S2Recur
 */
public class Ex22_S2Recur {

	public static void main(String[] sAry) throws Throwable {

		Condi condi = new Condi();
		condi.n = 5;
		condi.k = 2;
		condi.min = 1;
		condi.max = condi.n;

		condi.checkArg();

		// Strva.numOfWordPerLineForS2 = 1;

		Ary32_2D ary32_2D = S2nk.colRecur(condi);
		ary32_2D.sort(CompaForAry32OfB32As2Pow.COMPA);

		long ans = S2nk.int64ByDih(condi);

		O.eq(ary32_2D.iLen, ans);

		StringBuilder str = S2nk.toStrByAry32_2DOfB32BySAry(ary32_2D, O.S_ARY_A_Z, O.L);
		O.l(str);
		O.l();

		O.l(S2nk.toHtmlStrByAry32_2DOfB32BySAry(ary32_2D, O.S_ARY_A_Z, "tabForS2"));

		O.l("len=" + ary32_2D.iLen);
		O.l("ans=" + ans);

		O.l("B.n32=" + B.n32);
		B.n32 = 0;

	}
}
