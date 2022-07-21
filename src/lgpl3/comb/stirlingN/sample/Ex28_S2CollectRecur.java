package lgpl3.comb.stirlingN.sample;

import lgpl3.comb.filter.CompaForAry32OfB32As2Pow;
import lgpl3.comb.filter.Condi;
import lgpl3.comb.stirlingN.S2nk;
import lgpl3.o.O;
import lgpl3.o.ary.Ary32_2D;

/**
 * Stirling number of the second kind.<br/>
 * Stirling number of the second kind.
 *
 * @version 2022/02/17_21:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex28_S2CollectRecur" >Ex28_S2CollectRecur.java</a>
 *
 */
public class Ex28_S2CollectRecur {

	public static void main(String[] sAry) throws Throwable {

		int n = 5;
		int k = 3;

		Condi condi = new Condi();
		condi.n = n;
		condi.k = k;
		condi.min = 0;
		condi.max = n;

		Ary32_2D retAry32_2D = (Ary32_2D) S2nk.colToK(condi).sort(CompaForAry32OfB32As2Pow.COMPA);

		O.l(S2nk.strByAry32_2DOfB32BySAry(retAry32_2D, O.S_ARY_A_Z));

		O.l("len=" + O.eq(retAry32_2D.i, S2nk.int64ByDih(condi)));

	}
}
