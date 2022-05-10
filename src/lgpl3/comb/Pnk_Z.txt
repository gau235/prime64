package lgpl3.comb;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.str.Strva;
import lgpl3.other.jsp.Jsp;

/**
 * @version 2022/04/03_11:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Pnk_Z" >Pnk_Z.java</a>
 *
 * @see Pnk
 */
public abstract class Pnk_Z extends Pnk_J {

	private static final Class<?> THIS = Pnk_Z.class;

	/**
	 * To string by B64W6.<br/>
	 * To string by B64W6.
	 */
	public static StringBuilder rowHtmlSizedFontAftRev(long b64W6, String[] sAry) {

		// String[] sAry2 = { "大", "犬", "夭", "天", "太", "木", "尤", "无" };

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		StringBuilder html1 = new StringBuilder("<font style=\"font-size:");

		StringBuilder html2 = new StringBuilder("px\">");

		StringBuilder html3 = new StringBuilder("</font>");

		b64W6 = B64W6.revAmongVCell(b64W6);

		int v, rate = 11; // idx = 0, totalVCell = B64W6.totalVCell(b64W6); // idx++ % totalVCell

		do {
			v = (((int) b64W6) & B64W6.MASK32);

			retStr.append(html1).append(rate * v).append(html2).append(sAry[0]).append(html3);

			if (((int) (b64W6 >>>= 6)) == 0b0)

				return retStr;

			retStr.append(O.C32);

		} while (B.I);

	}

	/**
	 * 單列沒 wear head.<br/>
	 * To convert the long[] of B64W6 to StringBuilder.
	 */
	public static StringBuilder htmlSizedFontAftRev(long[] ary, String[] sAry) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		for (int idx = 0, len = ary.length; idx != len;) {

			retStr.append(rowHtmlSizedFontAftRev(ary[idx], sAry));

			if (++idx != len)

				retStr.append(Jsp.L);

		}

		return retStr;

	}

	/**
	 * 單列沒 wear head.<br/>
	 * To convert the long[] of B64W6 to StringBuilder.
	 */
	public static StringBuilder strByAryOfRevB64W6BySAry(long[] ary, String[] sAry) { // called by Pnk not JSP

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		for (int idx = 0, len = ary.length; idx != len;) {

			retStr.append(B64W6.strByVCellMinus1AftRevBySAry(ary[idx], sAry));

			if (++idx != len)

				retStr.append(O.C_A_L);

		}

		return retStr;

	}

	/**
	 * 甲掛著金牌站在 1 號位置, 乙掛著銀牌站在 2 號位置.<br/>
	 * 3! * 3! 整個排列組合唯一有平方, 2 次方的應用案例.
	 */
	public static StringBuilder strWWornHeadByRevB64W6(long b64W6, String[] sAry, String[] sAryForHead) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		b64W6 = B64W6.revAmongVCell(b64W6);

		// if (b64W6 != 0b0L) O.l("b64W6=" + b64W6, THIS);

		int iHead = 0;
		do {
			retStr.append(sAryForHead[iHead]).append(O.C58).append(sAry[(((int) b64W6) & B64W6.MASK32) - 1]);

			if (++iHead == sAryForHead.length)

				iHead = 0;

			if ((b64W6 >>>= $6) == 0b0L)

				return retStr;
			else
				retStr.append(O.C44);

		} while (B.I);

	}

	/**
	 * 把 long[] of B64W6 轉成字串建立者.<br/>
	 * To convert the long[] of B64W6 to StringBuilder.
	 */
	public static StringBuilder strWWornHeadByAryOfRevB64W6(long[] ary, String[] sAry, String[] sAryForHead, CharSequence lineWr) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		for (int idx = 0, len = ary.length; idx != len;) {

			// O.l("tmpStr=" + toStrByB64W6(sAry, ary[i]), THIS);

			retStr.append(strWWornHeadByRevB64W6(ary[idx], sAry, sAryForHead));

			if (++idx != len)

				retStr.append(lineWr);

		}

		return retStr;

	}

	/**
	 * To StringBuilder by B64W6.<br/>
	 * To StringBuilder by B64W6.
	 */
	public static StringBuilder rowHtmlWWornHead(long b64W6, String[] sAry, StringBuilder strHead) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		b64W6 = B64W6.revAmongVCell(b64W6);

		retStr.append(strHead).append(O.C_A_L);
		retStr.append("<tr><td>");

		do {
			retStr.append(sAry[(((int) b64W6) & B64W6.MASK32) - 1]);

			if ((b64W6 >>>= $6) == 0b0L)

				return retStr.append("</td></tr>");
			else
				retStr.append(Strva.STR_HTML_MIDDLE_TD);

		} while (B.I);

	}

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Ery to StringBuilder.
	 *
	 * @see Dnk#toHtmlWHead(long[], String[], String[], CharSequence)
	 */
	public static StringBuilder htmlWWornHead(long[] aryOfB64W6, String[] sAry, String[] sAryForHead, CharSequence sHtmlClass) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		final StringBuilder strHtmlStart = new StringBuilder("<table class=\"").append(sHtmlClass).append("\" ><thead><tr><td>");
		final StringBuilder strHtmlStart2 = new StringBuilder("</td></tr></thead>").append(O.C_A_L);

		final StringBuilder strHead = new StringBuilder("<tr><td>");

		int idx = 0, totalVCell = B64W6.totalVCell(aryOfB64W6[0]), len;

		for (; B.I;) {

			strHead.append(Jsp.C_A_3_HTML_BLANK).append(sAryForHead[idx]).append(Jsp.C_A_3_HTML_BLANK);

			if (++idx != totalVCell)

				strHead.append(Strva.STR_HTML_MIDDLE_TD);
			else {

				strHead.append("</td></tr>");

				break;

			}
		}

		for (idx = 0, len = aryOfB64W6.length; idx != len;) {

			retStr.append(strHtmlStart).append(idx + 1).append(strHtmlStart2);
			retStr.append(rowHtmlWWornHead(aryOfB64W6[idx], sAry, strHead));
			retStr.append("</table>");

			if (++idx != len)

				if (idx == Strva.maxRowInHtml)

					return retStr;
				else
					retStr.append(Jsp.L);

		}

		return retStr;

	}
}
