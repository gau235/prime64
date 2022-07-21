package lgpl3.comb.stirlingN;

import lgpl3.comb.filter.Condi;
import lgpl3.o.O;

/**
 * Stirling number of the second kind.<br/>
 * Stirling number of the second kind.
 *
 * @version 2021/02/13_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=S2nk" >S2nk.java</a>
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
public abstract class S2nk extends S2nk_Z {

	// private static final Class<?> THIS = S2nk.class;

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

					if (colRecur(condi).i != int64ByDih(condi)) // O.eq(colRecur(condi).iLen, int64ByToDiI(condi));

						O.x("n, k, min, max=" + condi.n + ", " + condi.k + ", " + condi.min + ", " + condi.max);

					if (colRecur(condi).i != bigIntByDih(condi).longValue())

						O.x("n, k, min, max=" + condi.n + ", " + condi.k + ", " + condi.min + ", " + condi.max);

				}

		/////////////////////////////////////////////////////////

		for (int n = 10, k, min; n != 0; n--)

			for (k = n; k != 0; k--)

				for (min = n / k; min >= 1; min--) {

					condi.n = n;
					condi.k = k;
					condi.min = 0;
					condi.max = n;

					condi.checkArg();

					if (colToK(condi).i != int64ByDih(condi))

						O.x("n, k, min, max=" + condi.n + ", " + condi.k + ", " + condi.min + ", " + condi.max);

				}
	}
}
