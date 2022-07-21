package lgpl3.comb.onto.sample;

import lgpl3.comb.filter.Condi;
import lgpl3.comb.onto.OntoWMin0;
import lgpl3.comb.onto.thr.ThrOntoWMin0WDynaB64;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.time.T64;

/**
 * OntoWMin0(n,k).<br/>
 * OntoWMin0(n,k).
 *
 * @version 2022/02/17_18:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex60_ThrOntoWMin0WDynaB64" >
 *          Ex60_ThrOntoWMin0WDynaB64.java</a>
 *
 * @see Ex60_ThrOntoWMin0WDynaB64
 *
 * @see Ex52_OntoWMin0ByLoop
 */
public class Ex60_ThrOntoWMin0WDynaB64 {

	public static void main(String[] sAry) throws Throwable {

		Condi condi = new Condi();
		condi.n = 5;
		condi.k = 3;
		condi.min = 0;
		condi.max = condi.n;

		condi.checkArg();

		O.l("preLen=" + O.f(OntoWMin0.int64ByHxy(condi)));

		long t0 = O.t();

		ThrOntoWMin0WDynaB64 thr = new ThrOntoWMin0WDynaB64(condi, B.I);

		thr.sort(); // todo: n=10, k=3 too slow

		O.l(thr.toStr());

		O.l("len=" + O.f(O.eq(thr.iLen, OntoWMin0.int64ByHxy(condi))) + O.S9 + T64.difInF32Sec(t0) + "s");

	}
}
