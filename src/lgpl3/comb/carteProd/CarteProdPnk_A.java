package lgpl3.comb.carteProd;

import lgpl3.comb.Pnk;
import lgpl3.comb.b64W6.B64W6;

/**
 * To product.<br/>
 * To product.
 *
 * @version 2020/09/23_20:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=CarteProdPnk_A" >CarteProdPnk_A.java</a>
 *
 * @see CarteProdPnk_L
 */
public abstract class CarteProdPnk_A extends CarteProd {

	// private static final Class<?> THIS = CarteProdPnk_A.class;

	/**
	 * To product.<br/>
	 * To product.
	 *
	 * @see CarteProdCnk#mulAmongBoxWTag(int, long)
	 */
	public static long mulAmongBoxWTag(int n, long b64W6) {

		long ans = 1L;

		int vCell = ((int) b64W6) & B64W6.MASK32;
		do {
			ans *= Pnk.int64(n, vCell);
			n -= vCell;

		} while ((vCell = ((int) (b64W6 >>>= B64W6.$6)) & B64W6.MASK32) != 0b0);

		// O.l("ans=" + ans , THIS);

		return ans;

	}

	/**
	 * To product.<br/>
	 * To product.
	 *
	 * @see CarteProdCnk#mulAmongHeap(int, long)
	 */
	public static long mulAmongHeap(int n, long sortedB64W6) { // must be sorted for countDu

		long ans = 1L;
		final long oldB64 = sortedB64W6; // must keep

		int vCell = ((int) sortedB64W6) & B64W6.MASK32, tmp32;
		do {
			ans *= Pnk.int64(n, vCell);
			n -= vCell;

		} while ((vCell = ((int) (sortedB64W6 >>>= B64W6.$6)) & B64W6.MASK32) != 0b0);

		if ((tmp32 = B64W6.countDupNRev(oldB64)) == 0b0)

			return ans;

		do
			ans /= Pnk.int64(tmp32 & B64W6.MASK32);

		while ((tmp32 >>>= B64W6.$6) != 0b0);

		return ans; // O.l("ans=" + ans, THIS);

	}
}
