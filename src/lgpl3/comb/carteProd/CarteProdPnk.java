package lgpl3.comb.carteProd;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Seq;
import lgpl3.o.str.Strva;

/**
 * Cartesian product.<br/>
 * Cartesian product.
 *
 * @version 2021/04/27_11:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=CarteProdPnk" >CarteProdPnk.java</a>
 *
 * @see CarteProd
 *
 * @see CarteProdCnk
 *
 * @see CarteProdPnk
 */
public abstract class CarteProdPnk extends CarteProdPnk_L {

	// private static final Class<?> THIS = CarteProdPnk.class;

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the array to StringBuilder.
	 */
	public static StringBuilder toStrByAryOfB64W6(long[] aryOfB64As2Pow, String[] sAry) {

		StringBuilder retStr = new StringBuilder(O.defLenForStr);

		for (int idx = 0; idx != aryOfB64As2Pow.length;) {

			retStr.append(B64W6.strByVCellMinus1AftRevBySAry(aryOfB64As2Pow[idx], sAry));

			if (++idx != aryOfB64As2Pow.length)

				retStr.append(charSeqAsSeparator);

		}

		return retStr;

	}

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Arr to StringBuilder.
	 */
	public static StringBuilder toStrByArrOfSeq(Arr<Seq> arrOfSeq, String[] sAry, CharSequence charSeqAftRowNum32,

			CharSequence lineWr) {

		StringBuilder retStr = new StringBuilder(O.defLenForStr);

		Seq[] aryOfSeq = arrOfSeq.arr;
		for (int i = 0, len = arrOfSeq.i; i != len;) {

			retStr.append(i + 1).append(charSeqAftRowNum32).append(toStrByAryOfB64W6(aryOfSeq[i].trim().ary, sAry));

			if (++i != len) {

				if (i == Strva.maxRowInHtml)

					return retStr;
				else
					retStr.append(lineWr);

			}
		}

		return retStr;

	}
}
