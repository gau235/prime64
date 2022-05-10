package lgpl3.comb.stirlingN;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Ary2D;
import lgpl3.o.str.Strva;
import lgpl3.other.jsp.Jsp;

/**
 * @version 2021/02/05_22:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=S2PCirc_Z" >S2PCirc_Z.java</a>
 *
 * @see S2PCirc
 */
public abstract class S2PCirc_Z extends S2PCirc_Y {

	private static final Class<?> THIS = S2PCirc_Z.class;

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Ary2D to StringBuilder.
	 */
	public static StringBuilder toStrByAry2DOfB64W6BySAry(Ary2D ary2D, String[] sAry, CharSequence lineWr) { // for S1

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		long[][] arrOfAry = ary2D.arr;

		int lenBig = ary2D.iLen, iBig, iSmall;

		long[] ary;

		for (iBig = 0; iBig != lenBig;) {

			ary = arrOfAry[iBig];
			retStr.append(O.C91);

			for (iSmall = 0; iSmall != ary.length;) {

				retStr.append(B64W6.strByVCellMinus1AftRevBySAry(ary[iSmall], sAry));

				if (++iSmall != ary.length)

					retStr.append(O.C124);

			}

			retStr.append(O.C93);

			if (++iBig != lenBig)

				retStr.append(lineWr);

		}

		return retStr;

	}

	/**
	 * To string by B64W6.<br/>
	 * To string by B64W6.
	 */
	public static StringBuilder rowHtmlAftS1S3(long b64W6, String[] sAry) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		if (b64W6 == 0L)

			return retStr.append(Jsp.C_A_6_HTML_BLANK);

		b64W6 = B64W6.revAmongVCell(b64W6);
		// O.l("revAmongVCell=" + B64W6.str24(b64W6));

		int count = 0;

		do {
			retStr.append(sAry[(((int) b64W6) & B64W6.MASK32) - 1]).append(O.C32);

			if ((b64W6 >>>= B64W6.$6) == 0b0L)

				return retStr;

			else if (++count == Strva.numOfWordPerLineForS2) {

				retStr.append(Jsp.BR);
				count = 0;

			}

		} while (B.I);

	}

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Ary2D to StringBuilder.
	 */
	public static StringBuilder toHtmlAftS1S3(Ary2D ary2D, String[] sAry, CharSequence sHtmlClass) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		StringBuilder htmlStart1 = new StringBuilder("<table class=\"").append(sHtmlClass).append("\" ><thead><tr><td>");
		StringBuilder htmlEnd1 = new StringBuilder("</td></tr></thead><tr><td>");

		long[][] arrOfAry = ary2D.arr;
		long[] ary;

		int iBig, lenBig = ary2D.iLen, iSmall;

		for (iBig = 0; iBig != lenBig;) {

			ary = arrOfAry[iBig];

			retStr.append(htmlStart1).append(iBig + 1).append(htmlEnd1);

			for (iSmall = 0; iSmall != ary.length;) {

				retStr.append(rowHtmlAftS1S3(ary[iSmall], sAry));

				if (++iSmall != ary.length)

					retStr.append(Strva.STR_HTML_MIDDLE_TD);

			}

			retStr.append(Strva.STR_HTML_TABLE_END);

			if (++iBig != lenBig) {

				if (iBig == Strva.maxRowInHtml)

					return retStr;
				else
					retStr.append(Jsp.L);

			}
		}

		return retStr;

	}
}
