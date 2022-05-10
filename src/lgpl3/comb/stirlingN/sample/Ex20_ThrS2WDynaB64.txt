package lgpl3.comb.stirlingN.sample;

import lgpl3.comb.filter.Condi;
import lgpl3.comb.stirlingN.S2nk;
import lgpl3.comb.stirlingN.thr.ThrS2WDynaB64;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.time.T64;

/**
 * Stirling2.<br/>
 * Stirling2.
 *
 * @version 2022/02/17_21:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex20_ThrS2WDynaB64" >Ex20_ThrS2WDynaB64.java</a>
 *
 */
public class Ex20_ThrS2WDynaB64 {

	public static void main(String[] sAry) throws Throwable {

		Condi condi = new Condi(); // note: min==0 when n < k error
		condi.n = 6;
		condi.k = 3;
		condi.min = 1;
		condi.max = condi.n;

		long t0 = O.t();

		ThrS2WDynaB64 thr = new ThrS2WDynaB64(condi, B.I);

		O.l(thr.sort().toStr()); // O.l(thr.toStr());

		O.l("S2(" + condi.n + "," + condi.k + ")=" + O.eq(thr.iLen, S2nk.int64ByDih(condi)));

		// O.l(S2nk.toStrByAry32_2DOfB32BySAry(S2nk.colRecur(condi), O.S_ARY_A_Z, O.L));

		O.l("B.n32=" + B.n32);

		B.n32 = 0; // fuck

		// O.l(thr.toHtmlStr(O.S_ARY_A_Z, "tabForStirling2"));
		O.l("costT=" + T64.difInF32Sec(t0) + "s");

	}
}
