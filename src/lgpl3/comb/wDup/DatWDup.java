package lgpl3.comb.wDup;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.keyNV.K64V32;
import lgpl3.o.str.Strva;
import lgpl3.recycle.Zw18;
import lgpl3.shareWXyz.Hxy;

/**
 * The datum for to Hxy.<br/>
 *
 * @version 2019/08/17_15:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=DatWDup" >DatWDup.java</a>
 *
 * @see Zw18
 */
public class DatWDup extends DatWDup_A {

	private static final Class<?> THIS = DatWDup.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * To string by B64W6.<br/>
	 * To string by B64W6.
	 */
	public StringBuilder toRowStrAftCOrP(long b64W6) {

		StringBuilder retStr = new StringBuilder(O.defLenForStr);

		b64W6 = B64W6.revAmongVCell(b64W6);

		do {

			retStr.append(distinctSortedSAry[(((int) b64W6) & B64W6.MASK32) - 1]);

			if ((b64W6 = b64W6 >>> B64W6.$6) == 0b0L) {

				return retStr;

			} else {

				retStr.append(charSeqAsSeparator);

			}

		} while (B.I);

	}

	/**
	 * To add then to append.<br/>
	 * To add then to append.
	 */
	public boolean isToEx(long b64W6) {

		StringBuilder tmpStr = toRowStrAftCOrP(b64W6);

		return matcherEx.reset(tmpStr).find();

	}

	/**
	 * To add then to append.<br/>
	 * To add then to append.
	 */
	public boolean ifPassToInEx(long b64W6) {

		StringBuilder tmpStr = toRowStrAftCOrP(b64W6);

		return matcherIn.reset(tmpStr).find() && (!matcherEx.reset(tmpStr).find());

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public StringBuilder toStrAftCOrP() {

		StringBuilder str = new StringBuilder(O.defLenForStr);

		K64V32 k64V32;
		for (int i = 0, size = mapK64V32.i; i != size;) {

			k64V32 = mapK64V32.arr[i];

			// int min = 1;
			// StringBuilder sDiI = B64W6.toStrForToDiI(k64V32.b64, min);// b64W6OfQtyPlus1
			// O.l("add " + sDiI);
			//
			// StringBuilder str24 = B64W6.str24((int) k64V32.b64);
			//
			// O.l("add " + str24);

			str.append(prefixForRowNum).append(i + 1).append(postfixForRowNum).append(toRowStrAftCOrP(k64V32.k)).append(prefixForVal)
					.append(k64V32.v).append(postfixForVal).append(lineWr);

			if (++i != size) {

				str.append(lineWr);

				if (i == Strva.maxRowInHtml) {

					return str;

				}

			}

		}

		return str;

	}

	/**
	 * To add then to append.<br/>
	 * To add then to append.
	 */
	public void addAftToInExByToH(long[] aryOfB64W6) {

		StringBuilder tmpStr;
		for (int i = 0; i != aryOfB64W6.length; i++) {

			tmpStr = Hxy.rowStrAftH(aryOfB64W6[i], 0, distinctSortedSAryToHxy);
			// O.l(tmpStr , THIS);

			if (matcherIn.reset(tmpStr).find() && (!matcherEx.reset(tmpStr).find())) {

				if (total32ToHxy++ < Strva.maxRowInHtml) {

					retStrToHxy.append(prefixForRowNum).append(total32ToHxy).append(postfixForRowNum).append(tmpStr).append(lineWr);

				}

			}

		}

	}

}
