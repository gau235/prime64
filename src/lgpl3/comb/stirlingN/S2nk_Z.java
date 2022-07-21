package lgpl3.comb.stirlingN;

import lgpl3.b32.B32va;
import lgpl3.o.O;
import lgpl3.o.ary.Ary32_2D;
import lgpl3.o.str.Strva;
import lgpl3.other.jsp.Jsp;

/**
 * @version 2022/05/07_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=S2nk_Z" >src</a>
 *
 * @see S2nk
 */
public abstract class S2nk_Z extends S2nk_Y {

	// private static final Class<?> THIS = S2nk_Z.class;

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Ery to StringBuilder.
	 */
	public static StringBuilder strByAry32_2DOfB32BySAry(Ary32_2D ary32_2D, String[] sAry) {

		StringBuilder ret = new StringBuilder(O.defLenForStr);

		int aryOfAry32[][] = ary32_2D.arr, ary32[], iBig, lenBig = ary32_2D.i, iSmall, tmpB32;

		for (iBig = 0; iBig != lenBig;) {

			ary32 = aryOfAry32[iBig];
			ret.append(O.C91);

			for (iSmall = 0; iSmall != ary32.length;) {

				// the char '_'
				ret.append(((tmpB32 = ary32[iSmall]) == 0b0) ? O.C95 : B32va.strByLog2LowestBitBySAry(tmpB32, sAry));

				if (++iSmall != ary32.length)

					ret.append(O.C124);

			}

			ret.append(O.C93);

			if (++iBig != lenBig)

				ret.append(O.C_A_L);

		}

		return ret;

	}

	/**
	 * To StringBuilder from String ary via bit32.<br/>
	 * To StringBuilder from String ary via bit32.
	 */
	public static StringBuilder rowHtmlByB32BySAry(int b32As2Pow, String[] sAry) {

		StringBuilder ret = new StringBuilder(O.defLenForStr);

		// if (b32As2Pow == 0b0) return retStr.append(Jsp.C_A_6_HTML_BLANK);

		int lowest1, count = 0;

		do
			if ((lowest1 = (-b32As2Pow & b32As2Pow)) == b32As2Pow)

				return ret.append(sAry[B32va.log2(lowest1)]);
			else {

				ret.append(sAry[B32va.log2(lowest1)]);

				if (++count == Strva.numOfWordPerLineForS2) {

					ret.append(Jsp.BR);
					count = 0;

				} else
					ret.append(O.C32);

			}

		while ((b32As2Pow = (~lowest1 & b32As2Pow)) != 0b0);

		throw new RuntimeException(); // never reaches

	}

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Ery to StringBuilder.
	 */
	public static StringBuilder htmlByAry32_2DOfB32BySAry(Ary32_2D ary32_2D, String[] sAry, CharSequence sHtmlClass) {

		StringBuilder retStr = new StringBuilder(O.defLenForStr);

		StringBuilder htmlStart1 = new StringBuilder("<table class=\"").append(sHtmlClass).append("\" ><thead><tr><td>");
		StringBuilder htmlEnd1 = new StringBuilder("</td></tr></thead><tr><td>");

		int aryOfAry32[][] = ary32_2D.arr, ary32[], iBig, lenBig = ary32_2D.i, iSmall;

		for (iBig = 0; iBig != lenBig;) {

			ary32 = aryOfAry32[iBig];

			retStr.append(htmlStart1).append(iBig + 1).append(htmlEnd1);

			for (iSmall = 0; iSmall != ary32.length;) {

				retStr.append(rowHtmlByB32BySAry(ary32[iSmall], sAry));

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
