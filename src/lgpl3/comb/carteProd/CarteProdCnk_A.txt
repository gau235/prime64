package lgpl3.comb.carteProd;

import lgpl3.comb.Cnk;
import lgpl3.comb.Pnk;
import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Seq;

/**
 * To product.<br/>
 * To product.
 *
 * @version 2021/03/19_10:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=CarteProdCnk_A" >CarteProdCnk_A.java</a>
 *
 * @see CarteProdCnk_U
 */
public abstract class CarteProdCnk_A extends CarteProd {

	// private static final Class<?> THIS = CarteProdCnk_A.class;

	/**
	 * To sum after to multiply.
	 *
	 * @see CarteProdPnk#mulAmongBoxWTag(int, long)
	 */
	public static long mulAmongBoxWTag(int n, long b64W6) {

		long ans = 1L;

		int vCell = ((int) b64W6) & B64W6.MASK32;
		do {
			ans *= Cnk.int64(n, vCell);
			n -= vCell;

		} while ((vCell = ((int) (b64W6 >>>= B64W6.$6)) & B64W6.MASK32) != 0b0);

		// O.l("ans=" + ans , THIS);

		return ans;

	}

	/**
	 * To sum after to multiply.
	 *
	 * @see CarteProdPnk#mulAmongHeap(int, long)
	 */
	public static long mulAmongHeap(int n, long sortedB64W6) { // must be sorted

		long ans = 1L;
		final long oldB64 = sortedB64W6; // must keep

		int vCell = ((int) sortedB64W6) & B64W6.MASK32, tmp32;
		do {
			ans *= Cnk.int64(n, vCell);
			n -= vCell;

		} while ((vCell = ((int) (sortedB64W6 >>>= B64W6.$6)) & B64W6.MASK32) != 0b0);

		if ((tmp32 = B64W6.countDupNRev(oldB64)) == 0b0)

			return ans;

		do
			ans /= Pnk.int64(tmp32 & B64W6.MASK32);

		while ((tmp32 >>>= B64W6.$6) != 0b0);

		return ans; // O.l("ans=" + ans, THIS);

	}

	/**
	 * To union.<br/>
	 * To union.
	 */
	public static long unionAll(Seq seq) {

		long[] ary = seq.ary;

		int idx = seq.iLen - 1;
		long retB64As2Pow = ary[idx];

		for (; idx-- != 0;)

			retB64As2Pow |= ary[idx];

		// O.l("unionAll=" + B32va.str((int) retB64As2Pow) + O.S9 + THIS);

		return retB64As2Pow;

	}

	/**
	 * To clone then to join.<br/>
	 * To clone then to join.
	 */
	public static void cloneNJoinIfGt(Seq leftSeq, long[] rightAryOfB64As2Pow, final int iFound, Arr<Seq> retArr) {

		if (iFound == Integer.MIN_VALUE) // O.l("iFound=" + iFound , THIS);

			for (int idx = 0; idx != rightAryOfB64As2Pow.length; idx++)

				retArr.a(leftSeq.cNA(rightAryOfB64As2Pow[idx]));

		else {

			long left = leftSeq.ary[iFound], leftLowest1 = (-left & left), right; // O.l("leftLowest1=" + leftLowest1, THIS);

			for (int idx = 0; idx != rightAryOfB64As2Pow.length; idx++)

				if ((-(right = rightAryOfB64As2Pow[idx]) & right) > leftLowest1)

					retArr.a(leftSeq.cNA(right));

		}
	}
}
