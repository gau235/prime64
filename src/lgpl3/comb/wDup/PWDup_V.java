package lgpl3.comb.wDup;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.B;

/**
 * @version 2019/08/17_18:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=PWDup_V" >PWDup_V.java</a>
 *
 * @see PWDup
 */
public abstract class PWDup_V extends PWDup_A {

	private static final Class<?> THIS = PWDup_V.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * To check if contain key (none 0).<br/>
	 * To check if contain key (none 0).
	 */
	public static boolean isToPutOn_old(long prefixB64W6, int curQR, boolean isToPermutate) {

		int q = curQR / DatWDup.DEF_DIVISOR_INT32;
		int r = curQR % DatWDup.DEF_DIVISOR_INT32;

		if (prefixB64W6 == 0b0L) {

			if (r == 0) {

				return B.I;

			}

		}

		// O.l("isToPutOn: qR,q,r=" + O.L + qR + "," + q + "," + r);

		int maxRBehind = Integer.MIN_VALUE;// fuck
		do {

			int b6Minus1 = (((int) prefixB64W6) & B64W6.MASK32) - 1;
			int qB6Minus1 = b6Minus1 / DatWDup.DEF_DIVISOR_INT32;

			// O.l("check q, qB6Minus1=" + O.L + q + ", " + qB6Minus1);
			if (q == qB6Minus1) {

				maxRBehind = b6Minus1 % DatWDup.DEF_DIVISOR_INT32; // rB6Minus1

				break;// fuck;

			}

		} while (isToPermutate && ((prefixB64W6 = prefixB64W6 >>> B64W6.$6) != 0b0L));

		// O.l("isToPutOn maxRBehind, q, r=" + O.L + maxRBehind + "," + q + "," + r);

		if (maxRBehind == Integer.MIN_VALUE) {// not the same q

			if (r == 0) {

				return B.I;

			}

		} else {// check max r

			if (r == (maxRBehind + 1)) {

				// O.l("check rBase=" + rBase);
				return B.I;

			}

		}

		return B.O;

	}

}
