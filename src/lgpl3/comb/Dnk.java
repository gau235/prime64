package lgpl3.comb;

import lgpl3.o.O;
import lgpl3.o.ary.Aryva;

/**
 * To derange.<br/>
 * To derange.
 *
 * @version 2021/05/22_11:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Dnk" >Dnk.java</a>
 *
 * @see Pnk
 *
 * @see DCirc
 */
public abstract class Dnk extends Dnk_Z {

	// private static final Class<?> THIS = Dnk.class;

	/**
	 * If passes test.<br/>
	 * If passes test.
	 */
	public static void test() {

		int n, k, endN = 11;

		for (n = endN; n > 0; n--)

			for (k = n; k > 0; k--)

				O.eq(int64(n, k), bigInt(n, k).longValue());

		for (n = endN; n > 0; n--)

			for (k = n; k > 0; k--)

				O.eq(Aryva.checkDup(col(n, k)).length, int64(n, k));

		long sum = 0L;

		for (n = endN; n > 0; n--) {

			for (k = n; k > 0; k--)

				sum += int64(n, k);

			O.eq(sum + 1L, Pnk.int64(n)); // sum(D(n,k)) + 1 = n!

			sum = 0L;

		}
	}
}
