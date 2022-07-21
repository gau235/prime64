package lgpl3.comb.carteProd;

import lgpl3.comb.filter.Condi;
import lgpl3.comb.stirlingN.S2nk;
import lgpl3.o.O;

/**
 * Cartesian product.<br/>
 * Cartesian product.
 *
 * @version 2022/05/04_20:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=CarteProdCnk" >CarteProdCnk.java</a>
 *
 * @see CarteProd
 *
 * @see CarteProdCnk
 *
 * @see CarteProdPnk
 */
public abstract class CarteProdCnk extends CarteProdCnk_Z {

	// private static final Class<?> THIS = CarteProdCnk.class;

	/**
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

					if (S2nk.carteProd(condi).i != S2nk.int64ByDih(condi))

						O.x("n, k, min, max=" + condi.n + ", " + condi.k + ", " + condi.min + ", " + condi.max);

				}
	}
}
