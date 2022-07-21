package lgpl3.comb;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 有留空的排列.<br/>
 * Permutation with blanks.
 *
 * @version 2021/05/22_19:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=PWBlank" >PWBlank.java</a>
 *
 */
public abstract class PWBlank extends PWBlank_A {

	// private static final Class<?> THIS = PWBlank.class;

	/**
	 * To StringBuilder for Permutation with blank.<br/>
	 * To StringBuilder for Permutation with blank.
	 */
	public static StringBuilder toStrByB64W6IfLte(long b64W6, int nReal, String[] sAry) {

		StringBuilder retStr = new StringBuilder(O.defLenForStr);

		b64W6 = B64W6.revAmongVCell(b64W6);

		int v;
		do {

			v = (((int) b64W6) & B64W6.MASK32);

			if ((b64W6 >>>= B64W6.$6) == 0b0L) {

				if (v > nReal)
					retStr.append(O.C95);

				else
					retStr.append(sAry[v - 1]); // O.C65 is 'A'

				return retStr;

			} else {

				if (v > nReal)
					retStr.append(O.C95);

				else
					retStr.append(sAry[v - 1]); // O.C65 is 'A'

				retStr.append(O.C44);

			}

		} while (B.I);

	}

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the long[] to StringBuilder.
	 */
	public static StringBuilder toStrForPWBlankByAryOfB64W6(long[] aryOfB64W6, int nReal, String[] sAry, CharSequence lineWr) {

		StringBuilder retStr = new StringBuilder(O.defLenForStr);

		for (int i = 0; i != aryOfB64W6.length;) {

			retStr.append(toStrByB64W6IfLte(aryOfB64W6[i], nReal, sAry));

			if (++i != aryOfB64W6.length)
				retStr.append(lineWr);

		}

		return retStr;

	}
}
