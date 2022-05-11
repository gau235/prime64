package lgpl3.comb.stirlingN;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.comb.filter.Condi;
import lgpl3.comb.onto.Onto;
import lgpl3.divIntoHeap.Dih;
import lgpl3.o.B;
import lgpl3.o.O;

/**
 * Lah number.<br/>
 * Stirling number of the third kind.<br/>
 *
 * @version 2022/02/07_15:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=S2D" >S2D.java</a>
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
public abstract class S2D extends S2D_A {

	// private static final Class<?> THIS = S2D.class;

	/**
	 * Stirling number of the second kind.<br/>
	 * Stirling number of the second kind.
	 *
	 * @see Onto#script(Condi, CharSequence)
	 */
	public static StringBuilder script(Condi condi, CharSequence lineWr) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		final int diff = condi.min - 1; // reduced for performance
		long[] ary = Dih.col(condi.n, condi.k, condi.min, condi.max);

		long b64W6ForC;
		long b64W6ForDup;

		int restN = condi.n;
		int val;
		int iAry = 0;

		do {

			b64W6ForC = B64W6.revAmongVCell(ary[iAry]);
			b64W6ForDup = b64W6ForC;

			if (condi.min == 0) {

				// O.l("b64W6CountDup=" + O.L + B64W6.str24(b64W6CountDup) , THIS);
				while (((((int) b64W6ForDup) & B64W6.MASK32)) == 1) {

					b64W6ForDup >>>= B64W6.$6;
					// O.l("in b64W6CountDup=" + O.L + B64W6.str24(b64W6CountDup) , THIS);

				}

			}

			b64W6ForDup = B64W6.countDupNRev(b64W6ForDup);

			do {

				val = ((int) b64W6ForC & B64W6.MASK32) + diff;

				retStr.append(O.C67).append(O.C40).append(restN).append(O.C44).append(val).append(O.C41);
				retStr.append(O.C42).append("D(").append(val).append(")");

				restN -= val;

				if ((b64W6ForC >>>= B64W6.$6) != 0b0L) {

					retStr.append(O.C42);

				} else {

					break;
				}

			} while (B.I);

			// O.l("b64W6CountDup=" + O.L + B64W6.str24(b64W6CountDup) , THIS);

			while (b64W6ForDup != 0b0L) {

				retStr.append(O.C47).append(((int) b64W6ForDup) & B64W6.MASK32).append(O.C33); // /n!
				b64W6ForDup >>>= B64W6.$6;

			}

			restN = condi.n;

			if (++iAry < ary.length) {

				retStr.append(lineWr).append(O.C43);
			}

		} while (iAry != ary.length);

		return retStr;

	}

}
