package lgpl3.comb.carteProd;

import lgpl3.b64.B64va;
import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Seq;
import lgpl3.o.str.Strva;

/**
 * @version 2022/05/04_20:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=CarteProdCnk_Z" >CarteProdCnk_Z.java</a>
 *
 * @see CarteProdCnk
 */
public abstract class CarteProdCnk_Z extends CarteProdCnk_A {

	private static final Class<?> THIS = CarteProdCnk_Z.class;

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the array to StringBuilder.
	 */
	public static StringBuilder toStrByAryOfB64As2Pow(long[] aryOfB64As2Pow, String[] sAry) {

		StringBuilder ret = new StringBuilder(O.defLenForStr);

		for (int idx = 0; idx != aryOfB64As2Pow.length;) {

			ret.append(B64va.strByLog2InB64BySAry(aryOfB64As2Pow[idx], sAry));

			if (++idx != aryOfB64As2Pow.length)

				ret.append(charSeqAsSeparator);

		}

		return ret;

	}

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Arr to StringBuilder.
	 */
	public static StringBuilder toStrByArrOfSeq(Arr<Seq> arrOfSeq, String[] sAry, CharSequence charSeqAftRowNum32,

			CharSequence lineWr) {

		StringBuilder ret = new StringBuilder(O.defLenForStr);

		Seq[] aryOfSeq = arrOfSeq.arr;

		for (int idx = 0; idx != arrOfSeq.i;) {

			// O.l("aryOfSeq[i]=" + aryOfSeq[i].toStr());
			ret.append(idx + 1).append(charSeqAftRowNum32).append(toStrByAryOfB64As2Pow(aryOfSeq[idx++].trim().ary, sAry));

			if (idx != arrOfSeq.i)

				if (idx == Strva.maxRowInHtml)

					return ret;
				else
					ret.append(lineWr);

		}

		return ret;

	}
}
