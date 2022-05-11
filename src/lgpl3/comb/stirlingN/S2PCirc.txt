package lgpl3.comb.stirlingN;

import lgpl3.comb.Pnk;
import lgpl3.comb.filter.Condi;
import lgpl3.o.O;

/**
 * Stirling number of the first kind.<br/>
 * Stirling number of the first kind.
 *
 * @version 2022/02/11_13:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=S2PCirc" >S2PCirc.java</a>
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
public abstract class S2PCirc extends S2PCirc_Z {

	private static final Class<?> THIS = S2PCirc.class;

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

						O.x(condi.toStr());

				}

		////////////////////////////////////////////////////////////////////////

		// sum of S1 is n!

		long sum = 0L;

		for (int n = 10, k; n != 0; n--) {

			for (k = n; k != 0; k--) {

				condi.n = n;
				condi.k = k;
				condi.min = 1;
				condi.max = n;

				condi.checkArg();

				// O.x(condi.toStr());

				sum += int64ByDih(condi); // O.l("sum=" + sum, THIS);

			}

			if (sum != Pnk.int64(n))

				O.x(condi.toStr());

			sum = 0L; // fuck

		}
	}
}
