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
 * @version 2022/05/09_10:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex22_S2Recur" >src</a>
 *
 * @see Ex22_S2Recur
 */
public class Ex22_S2Recur {

	public static void main(String[] sAry) throws Throwable {

		Condi condi = new Condi();
		condi.n = 5;
		condi.k = 2;
		condi.min = 2;
		condi.max = condi.n;

		condi.checkArg();

		// Strva.numOfWordPerLineForS2 = 1;

		Ary32_2D ary32_2D = (Ary32_2D) S2nk.colRecur(condi).sort(CompaForAry32OfB32As2Pow.COMPA);

		O.l(S2nk.strByAry32_2DOfB32BySAry(ary32_2D, O.S_ARY_A_Z));
		O.l();

		O.l(S2nk.htmlByAry32_2DOfB32BySAry(ary32_2D, O.S_ARY_A_Z, "tabForS2"));

		O.l("len=" + O.eq(ary32_2D.i, S2nk.int64ByDih(condi)));

		O.l("B.n32=" + B.n32);
		B.n32 = 0;

	}
}
