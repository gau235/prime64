package lgpl3.comb;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.str.Strva;
import lgpl3.other.jsp.Jsp;

/**
 * @version 2021/05/16_18:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Dnk_Z" >Dnk_Z.java</a>
 *
 * @see Dnk
 */
public abstract class Dnk_Z extends Dnk_J {

	// private static final Class<?> THIS = Dnk_Z.class;

	/**
	 * To StringBuilder by B64W6.<br/>
	 * To StringBuilder by B64W6.
	 */
	public static StringBuilder rowHtmlWHead(long b64W6, int totalVCell, String[] sAry, String[] sAryForHead) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);
		retStr.append("<tr><td>");

		// b64W6 must be converted twice for D(n,k)
		long sortedB64W6 = B64W6.easySort(b64W6, totalVCell);

		do {
			retStr.append(Jsp.C_A_3_HTML_BLANK).append(sAryForHead[(((int) sortedB64W6) & B64W6.MASK32) - 1]).append(Jsp.C_A_3_HTML_BLANK);

			if ((sortedB64W6 >>>= B64W6.$6) == 0b0L) {

				retStr.append("</td></tr>");

				break;

			} else
				retStr.append(Strva.STR_HTML_MIDDLE_TD);

		} while (B.I);

		retStr.append("<tr><td>");

		// b64W6 must be converted twice for D(n,k)
		long revB64W6 = B64W6.revAmongVCell(b64W6);

		do {
			retStr.append(sAry[(((int) revB64W6) & B64W6.MASK32) - 1]);

			if ((revB64W6 >>>= B64W6.$6) == 0b0L)

				return retStr.append("</td></tr>");
			else
				retStr.append(Strva.STR_HTML_MIDDLE_TD);

		} while (B.I);

	}

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Ery to StringBuilder.
	 *
	 * @see Pnk#htmlWWornHead(long[], String[], String[], CharSequence)
	 */
	public static StringBuilder toHtmlWHead(long[] aryOfB64W6, String[] sAry, String[] sAryForHead, CharSequence sHtmlClass) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		final StringBuilder htmlStart1 = new StringBuilder("<table class=\"").append(sHtmlClass).append("\" ><thead><tr><td>");
		final StringBuilder htmlEnd1 = new StringBuilder("</td></tr></thead>").append(O.C_A_L);

		final int totalVCell = B64W6.totalVCell(aryOfB64W6[0]); // PInEx(3,1,1) bug if aryOfB64W6.len eq 0
		for (int idx = 0; idx != aryOfB64W6.length;) {

			retStr.append(htmlStart1).append(idx + 1).append(htmlEnd1);
			retStr.append(rowHtmlWHead(aryOfB64W6[idx], totalVCell, sAry, sAryForHead));
			retStr.append("</table>");

			if (++idx != aryOfB64W6.length) {

				if (idx == Strva.maxRowInHtml)

					return retStr;
				else
					retStr.append(Jsp.L);

			}
		}

		return retStr;

	}
}
