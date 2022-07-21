package lgpl3.comb.onto;

import lgpl3.comb.filter.Condi;
import lgpl3.o.O;

/**
 * OntoWMin0(n,k).<br/>
 * OntoWMin0(n,k).
 *
 * @version 2022/02/01_10:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=OntoWMin0" >OntoWMin0.java</a>
 *
 */
public abstract class OntoWMin0 extends OntoWMin0_A {

	// private static final Class<?> THIS = OntoWMin0.class;

	/**
	 * If passes test.<br/>
	 * If passes test.
	 */
	public static void test() {

		Condi condi = new Condi();
		condi.min = 0; // fuck

		for (int n = 8, k; n != 0; n--) // todo when n=9 outOfMem err

			for (k = n; k != 0; k--) {

				condi.n = n;
				condi.k = k;

				condi.max = n;

				condi.checkArg();

				if (colByLoop(condi).i != O.pow(k, n))

					O.x(condi.toStr());

				if (int64ByHxy(condi) != O.pow(k, n))

					O.x(condi.toStr());

				if (bigIntByHxy(condi).longValue() != O.pow(k, n))

					O.x(condi.toStr());

			}
	}
}
