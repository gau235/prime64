package lgpl3.comb.stirlingN.sample;

import lgpl3.comb.DCirc;
import lgpl3.comb.Dnk;
import lgpl3.comb.PInEx;
import lgpl3.comb.Pnk;
import lgpl3.comb.carteProd.CarteProdCnk;
import lgpl3.comb.filter.Condi;
import lgpl3.comb.onto.Onto;
import lgpl3.comb.onto.OntoP;
import lgpl3.comb.onto.OntoWMin0;
import lgpl3.comb.onto.thr.ThrOntoPWDynaB64;
import lgpl3.comb.onto.thr.ThrOntoWDynaB64;
import lgpl3.comb.onto.thr.ThrOntoWMin0WDynaB64;
import lgpl3.comb.stirlingN.S2P;
import lgpl3.comb.stirlingN.S2PCirc;
import lgpl3.comb.stirlingN.S2nk;
import lgpl3.comb.stirlingN.thr.ThrS2PCircWDynaB64;
import lgpl3.comb.stirlingN.thr.ThrS2PWDynaB64;
import lgpl3.comb.stirlingN.thr.ThrS2WDynaB64;
import lgpl3.divIntoHeap.Dih;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.shareWXyz.HxyVal;

/**
 * To test Stirling number.<br/>
 * To test Stirling number.
 *
 * @version 2022/05/11_13:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex95_TestOnStirling" >src</a>
 *
 */
public abstract class Ex95_TestOnStirling {

	/**
	 * If passes test.
	 */
	public static void test() {

		Condi condi = new Condi();

		for (int n = 10, k, min; n != 0; n--)

			for (k = n; (k != 0) && (n * k <= 64); k--)

				for (min = n / k; min >= 0; min--) {

					condi.n = n;
					condi.k = k;
					condi.min = min;
					condi.max = n;

					condi.checkArg();

					O.l(condi.toStr(), Ex95_TestOnStirling.class);

					if (new ThrS2WDynaB64(condi, B.I).iLen != S2nk.int64ByDih(condi))

						O.x(condi.toStr());

					if (new ThrS2PWDynaB64(condi, B.I).box.i != S2P.int64ByDih(condi))

						O.x(condi.toStr());

					if (new ThrS2PCircWDynaB64(condi, B.I).box.i != S2PCirc.int64ByDih(condi))

						O.x(condi.toStr());

					if ((min != 0) && new ThrOntoWDynaB64(condi, B.I).iLen != Onto.int64ByHxy(condi))

						O.x(condi.toStr());

					if ((min != 0) && new ThrOntoPWDynaB64(condi, B.I).box.i != OntoP.int64ByHxy(condi))

						O.x(condi.toStr());

					if ((min == 0) && new ThrOntoWMin0WDynaB64(condi, B.I).iLen != OntoWMin0.int64ByHxy(condi))

						O.x(condi.toStr());

					if ((min != 0) && S2nk.int64ByDih(condi) * Pnk.int64(k) != Onto.int64ByHxy(condi))

						O.x(condi.toStr());

					if ((min != 0) && S2P.int64ByDih(condi) * Pnk.int64(k) != OntoP.int64ByHxy(condi))

						O.x(condi.toStr());

				}
	}

	public static void main(String[] sAry) throws Throwable {

		test();

		Pnk.test();
		PInEx.test();

		Dnk.test();
		DCirc.test();

		HxyVal.test();
		Dih.test();

		Onto.test();
		OntoP.test();
		OntoWMin0.test();

		S2nk.test();
		S2PCirc.test();
		S2P.test();

		CarteProdCnk.test();

	}
}
