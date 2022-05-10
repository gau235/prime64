package lgpl3.comb.stirlingN;

import lgpl3.b32.B32va;
import lgpl3.o.O;
import lgpl3.o.ary.Ary32_2D;
import lgpl3.o.str.Strva;
import lgpl3.other.jsp.Jsp;

/**
 * @version 2021/02/07_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=S2nk_Z" >S2nk_Z.java</a>
 *
 * @see S2nk
 */
public abstract class S2nk_Z extends S2nk_Y {

	// private static final Class<?> THIS = S2nk_Z.class;

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Ery to StringBuilder.
	 */
	public static StringBuilder toStrByAry32_2DOfB32BySAry(Ary32_2D ary32_2D, String[] sAry, CharSequence lineWr) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		int[][] aryOfAry32 = ary32_2D.arr;
		int[] ary32;

		int iBig, lenBig = ary32_2D.iLen, iSmall, tmpB32;

		for (iBig = 0; iBig != lenBig;) {

			ary32 = aryOfAry32[iBig];
			retStr.append(O.C91);

			for (iSmall = 0; iSmall != ary32.length;) {

				if ((tmpB32 = ary32[iSmall]) == 0b0)

					retStr.append(O.C95); // the char '_'
				else
					retStr.append(B32va.strByLog2InB32BySAry(tmpB32, sAry));

				if (++iSmall != ary32.length)

					retStr.append(O.C124);

			}

			retStr.append(O.C93);

			if (++iBig != lenBig)

				retStr.append(lineWr);

		}

		return retStr;

	}

	/**
	 * To StringBuilder from String ary via bit32.<br/>
	 * To StringBuilder from String ary via bit32.
	 */
	public static StringBuilder toHtmlRowStrByB32BySAry(int b32As2Pow, String[] sAry) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		// if (b32As2Pow == 0b0) return retStr.append(Jsp.C_A_6_HTML_BLANK);

		int lowest1, count = 0;

		do {

			if ((lowest1 = (-b32As2Pow & b32As2Pow)) == b32As2Pow)

				return retStr.append(sAry[B32va.log2(lowest1)]);
			else {

				retStr.append(sAry[B32va.log2(lowest1)]);

				if (++count == Strva.numOfWordPerLineForS2) {

					retStr.append(Jsp.BR);
					count = 0;

				} else
					retStr.append(O.C32);

			}

		} while ((b32As2Pow = (~lowest1 & b32As2Pow)) != 0b0);

		throw new RuntimeException(); // never reaches

	}

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Ery to StringBuilder.
	 */
	public static StringBuilder toHtmlStrByAry32_2DOfB32BySAry(Ary32_2D ary32_2D, String[] sAry, CharSequence sHtmlClass) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		StringBuilder htmlStart1 = new StringBuilder("<table class=\"").append(sHtmlClass).append("\" ><thead><tr><td>");
		StringBuilder htmlEnd1 = new StringBuilder("</td></tr></thead><tr><td>");

		int[][] aryOfAry32 = ary32_2D.arr;
		int[] ary32;

		int iBig, lenBig = ary32_2D.iLen, iSmall;

		for (iBig = 0; iBig != lenBig;) {

			ary32 = aryOfAry32[iBig];

			retStr.append(htmlStart1).append(iBig + 1).append(htmlEnd1);

			for (iSmall = 0; iSmall != ary32.length;) {

				retStr.append(toHtmlRowStrByB32BySAry(ary32[iSmall], sAry));

				if (++iSmall != ary32.length)

					retStr.append(Strva.STR_HTML_MIDDLE_TD);

			}

			retStr.append(Strva.STR_HTML_TABLE_END);

			if (++iBig != lenBig)

				if (iBig == Strva.maxRowInHtml)

					return retStr;
				else
					retStr.append(Jsp.L);

		}

		return retStr;

	}
}
