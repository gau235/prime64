package lgpl3.comb.carteProd;

import lgpl3.b64.B64va;
import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Seq;
import lgpl3.o.str.Strva;

/**
 * Cartesian product.<br/>
 * Cartesian product.
 *
 * @version 2022/05/04_20:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=CarteProdCnk" >CarteProdCnk.java</a>
 *
 * @see CarteProd
 *
 * @see CarteProdCnk
 *
 * @see CarteProdPnk
 */
public abstract class CarteProdCnk extends CarteProdCnk_U {

	// private static final Class<?> THIS = CarteProdCnk.class;

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the array to StringBuilder.
	 */
	public static StringBuilder toStrByAryOfB64As2Pow(long[] aryOfB64As2Pow, String[] sAry) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		for (int idx = 0; idx != aryOfB64As2Pow.length;) {

			retStr.append(B64va.strByLog2InB64BySAry(aryOfB64As2Pow[idx], sAry));

			if (++idx != aryOfB64As2Pow.length)

				retStr.append(charSeqAsSeparator);

		}

		return retStr;

	}

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Arr to StringBuilder.
	 */
	public static StringBuilder toStrByArrOfSeq(Arr<Seq> arrOfSeq, String[] sAry, CharSequence charSeqAftRowNum32, CharSequence lineWr) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		Seq[] aryOfSeq = arrOfSeq.arr;

		for (int idx = 0; idx != arrOfSeq.iLen;) {

			// O.l("aryOfSeq[i]=" + aryOfSeq[i].toStr());
			retStr.append(idx + 1).append(charSeqAftRowNum32).append(toStrByAryOfB64As2Pow(aryOfSeq[idx++].trim().ary, sAry));

			if (idx != arrOfSeq.iLen)

				if (idx == Strva.maxRowInHtml)

					return retStr;
				else
					retStr.append(lineWr);

		}

		return retStr;

	}
}
