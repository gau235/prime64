package lgpl3.comb;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.str.Strva;
import lgpl3.other.jsp.Jsp;

/**
 * @version 2021/05/16_18:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Dnk_Z" >Dnk_Z.java</a>
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

		StringBuilder ret = new StringBuilder(O.defLenForStr);
		ret.append("<tr><td>");

		// b64W6 must be converted twice for D(n,k)
		long sortedB64W6 = B64W6.easySort(b64W6, totalVCell);

		do {
			ret.append(Jsp.C_A_3_HTML_BLANK).append(sAryForHead[(((int) sortedB64W6) & B64W6.MASK32) - 1]).

					append(Jsp.C_A_3_HTML_BLANK);

			if ((sortedB64W6 >>>= B64W6.$6) == 0b0L) {

				ret.append("</td></tr>");

				break;

			} else
				ret.append(Strva.STR_HTML_MIDDLE_TD);

		} while (B.I);

		ret.append("<tr><td>");

		// b64W6 must be converted twice for D(n,k)
		long revB64W6 = B64W6.revAmongVCell(b64W6);

		do {
			ret.append(sAry[(((int) revB64W6) & B64W6.MASK32) - 1]);

			if ((revB64W6 >>>= B64W6.$6) == 0b0L)

				return ret.append("</td></tr>");
			else
				ret.append(Strva.STR_HTML_MIDDLE_TD);

		} while (B.I);

	}

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Ery to StringBuilder.
	 *
	 * @see Pnk#htmlWWornHead(long[], String[], String[], CharSequence)
	 */
	public static StringBuilder htmlWHead(long[] aryOfB64W6, String[] sAry, String[] sAryForHead, CharSequence sHtmlClass) {

		StringBuilder ret = new StringBuilder(O.defLenForStr);

		final StringBuilder htmlStart1 = new StringBuilder("<table class=\"").append(sHtmlClass).append("\" ><thead><tr><td>");
		final StringBuilder htmlEnd1 = new StringBuilder("</td></tr></thead>").append(O.C_A_L);

		final int totalVCell = B64W6.totalVCell(aryOfB64W6[0]); // PInEx(3,1,1) bug if aryOfB64W6.len eq 0
		for (int idx = 0; idx != aryOfB64W6.length;) {

			ret.append(htmlStart1).append(idx + 1).append(htmlEnd1);
			ret.append(rowHtmlWHead(aryOfB64W6[idx], totalVCell, sAry, sAryForHead));
			ret.append("</table>");

			if (++idx != aryOfB64W6.length) {

				if (idx == Strva.maxRowInHtml)

					return ret;
				else
					ret.append(Jsp.L);

			}
		}

		return ret;

	}
}
