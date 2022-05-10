package lgpl3.comb.stirlingN.sample;

import lgpl3.comb.filter.CompaForAryOfB64W6;
import lgpl3.comb.filter.Condi;
import lgpl3.comb.stirlingN.S2P;
import lgpl3.comb.stirlingN.S2PCirc;
import lgpl3.comb.stirlingN.thr.ThrS2PWDynaB64;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Ary2D;

/**
 * Stirling number of the third kind.<br/>
 * Stirling number of the third kind.
 *
 * @version 2022/02/21_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex30_ThrS2PWDynaB64" >Ex30_ThrS2PWDynaB64.java</a>
 *
 * @see Ex22_S2Recur
 */
public class Ex30_ThrS2PWDynaB64 {

	public static void main(String[] sAry) throws Throwable {

		Condi condi = new Condi();

		condi.n = 3;
		condi.k = 3;
		condi.min = 0;
		condi.max = condi.n;

		Ary2D retAry2D = (Ary2D) new ThrS2PWDynaB64(condi, B.I).box.sort(CompaForAryOfB64W6.COMPA);

		if (condi.n <= 8)
			O.l(S2PCirc.toStrByAry2DOfB64W6BySAry(retAry2D, O.S_ARY_A_Z, O.L));

		O.l("len=" + O.eq(retAry2D.iLen, S2P.int64ByDih(condi)));

	}
}
