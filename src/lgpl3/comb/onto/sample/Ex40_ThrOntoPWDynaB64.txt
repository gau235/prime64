package lgpl3.comb.onto.sample;

import lgpl3.comb.filter.CompaForAryOfB64W6;
import lgpl3.comb.filter.Condi;
import lgpl3.comb.onto.OntoP;
import lgpl3.comb.onto.thr.ThrOntoPWDynaB64;
import lgpl3.comb.stirlingN.S2PCirc;
import lgpl3.comb.stirlingN.sample.Ex22_S2Recur;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Ary2D;

/**
 * Stirling number of the third kind.<br/>
 * Stirling number of the third kind.
 *
 * @version 2022/02/24_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex40_ThrOntoPWDynaB64" >
 *          Ex40_ThrOntoPWDynaB64.java</a>
 *
 * @see Ex22_S2Recur
 */
public class Ex40_ThrOntoPWDynaB64 {

	public static void main(String[] sAry) throws Throwable {

		Condi condi = new Condi();

		condi.n = 4;
		condi.k = 4;
		condi.min = 1;
		condi.max = condi.n;

		Ary2D retAry2D = (Ary2D) new ThrOntoPWDynaB64(condi, B.I).box.sort(CompaForAryOfB64W6.COMPA);

		if (condi.n <= 8)

			O.l(S2PCirc.toStrByAry2DOfB64W6BySAry(retAry2D, O.S_ARY_A_Z, O.L));

		O.l("len=" + O.eq(retAry2D.iLen, OntoP.int64(condi.n, condi.k)));

	}
}
