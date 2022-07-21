package lgpl3.comb.stirlingN;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.comb.filter.Condi;
import lgpl3.comb.onto.Onto;
import lgpl3.divIntoHeap.Dih;
import lgpl3.o.B;
import lgpl3.o.O;

/**
 * @version 2018/04/09_21:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=S2PCirc_Y" >S2PCirc_Y.java</a>
 *
 * @see S2PCirc_Z
 */
public abstract class S2PCirc_Y extends S2PCirc_A {

	private static final Class<?> THIS = S2PCirc_Y.class;

	/**
	 * Stirling number of the first kind.<br/>
	 * Stirling number of the first kind.
	 *
	 * @see Onto#script(Condi, CharSequence)
	 */
	public static StringBuilder script(Condi condi, CharSequence lineWr) {

		StringBuilder retStr = new StringBuilder(O.defLenForStr);

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
			// O.l("b64W6CountDup=" + O.L + B64W6.str24(b64W6CountDup) , THIS);

			do {

				val = ((int) b64W6ForC & B64W6.MASK32) + diff;

				retStr.append(O.C67).append(O.C40).append(restN).append(O.C44).append(val).append(O.C41);
				retStr.append(O.C42).append("Pc(").append(val).append(")");

				restN = restN - val;

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
