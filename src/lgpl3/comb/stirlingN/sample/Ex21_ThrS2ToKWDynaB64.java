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
 * @version 2022/02/18_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex21_ThrS2ToKWDynaB64" >
 *          Ex21_ThrS2ToKWDynaB64.java</a>
 *
 */
public class Ex21_ThrS2ToKWDynaB64 {

	public static void main(String[] sAry) throws Throwable {

		Condi condi = new Condi(); // note: min==0 when n < k error
		condi.n = 5;
		condi.k = 5;
		condi.min = 0;
		condi.max = condi.n;

		long t0 = O.t();

		ThrS2WDynaB64 thr = (ThrS2WDynaB64) new ThrS2WDynaB64(condi, B.I).sort();

		O.l(thr.toStr() + "\nlen=" + O.eq(thr.iLen, S2nk.int64ByDih(condi)));

		O.l("costT=" + T64.difInF32Sec(t0) + "s");

	}
}
