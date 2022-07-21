package lgpl3.shareWXyz;

import java.util.Arrays;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.divIntoHeap.Dih;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.str.Strva;
import lgpl3.other.jsp.Jsp;

/**
 * @version 2022/03/16_13:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Hxy" >Hxy.java</a>
 *
 * @see Dih
 *
 * @see HxyVal
 *
 * @see Hxy
 */
public abstract class Hxy extends Hxy_Z {

	private static final Class<?> THIS = Hxy.class;

	/**
	 * The base char array.<br/>
	 * The base char array.
	 */
	public static char[] genCharAryOf$() {

		int len = 64;

		char[] retCharAry = new char[len];

		do
			retCharAry[--len] = O.C36;

		while (len != 0);

		return retCharAry;

	}

	/**
	 * The base char array.<br/>
	 * The base char array.
	 */
	public static final char[] CHAR_ARY_OF_$ = genCharAryOf$();

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public static StringBuilder toStrOf$(long b64W6, int min) { // it is like: $,$,$$$

		StringBuilder ret = new StringBuilder(O.defLenForStr);

		b64W6 = B64W6.revAmongVCell(b64W6); // O.l("revAmongVCell=" + str24(b64W6), THIS);

		int diff = (min - 1), vCell;

		do {
			vCell = (((int) b64W6) & B64W6.MASK32) + diff;

			if (((int) (b64W6 >>>= B64W6.$6)) == 0b0) { // terminate

				if (vCell == 0)

					ret.append(O.C95);
				else
					ret.append(Arrays.copyOfRange(CHAR_ARY_OF_$, 0, vCell));

				return ret;

			}

			if (vCell == 0)

				ret.append("_,");
			else
				ret.append(Arrays.copyOfRange(CHAR_ARY_OF_$, 0, vCell)).append(O.C44);

		} while (B.I);

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public static StringBuilder toStrOf$ByAry(long[] aryOfB64W6, int min, CharSequence lineWr) { // lineWr for JSP

		StringBuilder retStr = new StringBuilder(O.defLenForStr);

		for (int idx = 0, len = aryOfB64W6.length; idx != len;) {

			retStr.append(O.C91).append(toStrOf$(aryOfB64W6[idx], min)).append(O.C93);

			if (++idx != len)

				retStr.append(lineWr);

		}

		return retStr;

	}

	/**
	 * To StringBuilder by B64W6.<br/>
	 * To StringBuilder by B64W6.
	 */
	public static StringBuilder rowHtmlWHead(long b64W6, int min, StringBuilder htmlHead) {

		StringBuilder retStr = new StringBuilder(O.defLenForStr);

		b64W6 = B64W6.revAmongVCell(b64W6);

		retStr.append(htmlHead).append(O.C_A_L);

		retStr.append("<tr><td>");

		min--;

		do {
			retStr.append((((int) b64W6) & B64W6.MASK32) + min);

			if ((b64W6 >>>= B64W6.$6) == 0b0L)

				return retStr.append("</td></tr>");
			else
				retStr.append(Strva.STR_HTML_MIDDLE_TD);

		} while (B.I);

	}

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Ery to StringBuilder.
	 */
	public static StringBuilder toHtmlStrToHWHeadSByAryOfB64W6(long[] aryOfB64W6, int min, String[] sAryForHead, CharSequence sHtmlClass) {

		StringBuilder retStr = new StringBuilder(O.defLenForStr);

		final StringBuilder htmlStart1 = new StringBuilder("<table class=\"").append(sHtmlClass).append("\" ><thead><tr><td>");
		final StringBuilder htmlEnd1 = new StringBuilder("</td></tr></thead>").append(O.C_A_L);

		final StringBuilder htmlHead = new StringBuilder("<tr><td>");

		int idx = 0;
		do {
			htmlHead.append(sAryForHead[idx]);

			if (++idx != sAryForHead.length)

				htmlHead.append(Strva.STR_HTML_MIDDLE_TD);
			else {

				htmlHead.append("</td></tr>");

				break;

			}

		} while (B.I);

		for (idx = 0; idx != aryOfB64W6.length;) {

			retStr.append(htmlStart1).append(idx + 1).append(htmlEnd1);
			retStr.append(rowHtmlWHead(aryOfB64W6[idx], min, htmlHead));
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
