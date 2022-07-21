package lgpl3.comb.stirlingN.sample;

import lgpl3.comb.filter.CompaForAryOfB64W6;
import lgpl3.comb.filter.Condi;
import lgpl3.comb.stirlingN.S2PCirc;
import lgpl3.comb.stirlingN.thr.ThrS2PCircWDynaB64;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Ary2D;

/**
 * Stirling number of the third kind.<br/>
 * Stirling number of the third kind.
 *
 * @version 2022/02/21_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex10_ThrS2PCircWDynaB64" >
 *          Ex10_ThrS2PCircWDynaB64.java</a>
 *
 * 
 *
 * @see Ex10_ThrS2PCircWDynaB64
 */
public class Ex10_ThrS2PCircWDynaB64 {

	public static void main(String[] sAry) throws Throwable {

		Condi condi = new Condi();

		condi.n = 2;
		condi.k = 2;
		condi.min = 0;
		condi.max = condi.n;

		Ary2D retAry2D = (Ary2D) new ThrS2PCircWDynaB64(condi, B.I).box.sort(CompaForAryOfB64W6.COMPA);

		if (condi.n <= 9)
			O.l(S2PCirc.toStrByAry2DOfB64W6BySAry(retAry2D, O.S_ARY_A_Z, O.L));

		O.l("len=" + O.eq(retAry2D.i, S2PCirc.int64ByDih(condi)));

	}
}
