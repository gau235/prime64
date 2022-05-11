package lgpl3.comb.onto.sample;

import lgpl3.comb.filter.Condi;
import lgpl3.comb.onto.Onto;
import lgpl3.comb.onto.thr.ThrOntoWDynaB64;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.time.T64;

/**
 * The Onto function.<br/>
 * The Onto function.
 *
 * @version 2022/02/09_19:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex10_ThrOntoWDynaB64" >Ex10_ThrOntoWDynaB64.java</a>
 *
 */
public class Ex10_ThrOntoWDynaB64 {

	public static void main(String[] sAry) throws Throwable {

		// O.isDev = B.O;

		int n = 6;
		int k = 3;

		Condi condi = new Condi();
		condi.n = n;
		condi.k = k;
		condi.min = 1; // condi.min = 0;
		condi.max = n;

		long t0 = O.t();

		ThrOntoWDynaB64 thr = new ThrOntoWDynaB64(condi, B.I);

		if (n < 10)

			O.l(thr.sort().toStr());

		O.l("Onto(" + n + "," + k + ")=" + O.eq(thr.iLen, Onto.int64ByHxy(condi)) + O.S9 + T64.difInF32Sec(t0) + "s");

		O.l("B.n32=" + B.n32);
		B.n32 = 0;

		O.l("B.n=" + B.n);
		B.n = 0;

	}
}
