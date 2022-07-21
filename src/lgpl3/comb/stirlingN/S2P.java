package lgpl3.comb.stirlingN;

import lgpl3.comb.filter.Condi;
import lgpl3.o.O;

/**
 * Lah number.<br/>
 * Stirling number of the third kind.
 *
 * @version 2020/03/26_20:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=S2P" >S2P.java</a>
 *
 * @see S2PCirc
 *
 * @see S2nk
 *
 * @see S2P
 *
 * @see S2D
 *
 * @see S2DCirc
 */
public abstract class S2P extends S2P_Z {

	// private static final Class<?> THIS = S2P.class;

	/**
	 * If passes test.<br/>
	 * If passes test.
	 */
	public static void test() {

		Condi condi = new Condi();

		for (int n = 10, k, min; n != 0; n--)

			for (k = n; k != 0; k--)

				for (min = n / k; min >= 1; min--) {

					condi.n = n;
					condi.k = k;
					condi.min = min;
					condi.max = n;

					condi.checkArg();

					if (bigIntByDih(condi).longValue() != int64ByDih(condi))

						O.x("n, k, min, max=" + condi.n + ", " + condi.k + ", " + condi.min + ", " + condi.max);

				}

	}
}
