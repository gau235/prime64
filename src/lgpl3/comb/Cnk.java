package lgpl3.comb;

import lgpl3.b32.B32va;
import lgpl3.b64.B64va;
import lgpl3.comb.selfCallva.Recur;
import lgpl3.o.O;
import lgpl3.o.str.Strva;
import lgpl3.other.jsp.Jsp;

/**
 * 本类别组合数学, 算高中数学的排列组合.<br/>
 * To do some Combinatorics exercise.
 *
 * @version 2022/04/25_20:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Cnk" >src</a>
 *
 * @see Recur
 */
public abstract class Cnk extends Cnk_V {

	// private static final Class<?> THIS = Cnk.class;

	/**
	 * 轉成字串建立者.
	 */
	public static StringBuilder strByAryOfB32As2Pow(int[] ary32) {

		StringBuilder ret = new StringBuilder(O.defLenForStr);

		for (int idx = 0, len = ary32.length; idx != len;) {

			ret.append(B32va.strByLog2LowestBitBySAry(ary32[idx], O.S_ARY_A_Z));

			if (++idx != len)

				ret.append(O.C_A_L);

		}

		return ret;

	}

	/**
	 * 轉成字串建立者.
	 */
	public static StringBuilder strByAryOfB64As2Pow(long[] ary) {

		StringBuilder ret = new StringBuilder(O.defLenForStr);

		for (int idx = 0, len = ary.length; idx != len;) {

			ret.append(B64va.strByLog2InB64BySAry(ary[idx], O.S_ARY_A_Z));

			if (++idx != len)

				ret.append(O.C_A_L);

		}

		return ret;

	}

	/**
	 * 轉成字串建立者.
	 */
	public static StringBuilder htmlByAryOfB32As2PowBySAry(int[] ary32, String[] sAry, CharSequence sHtmlClass) {

		StringBuilder ret = new StringBuilder(O.defLenForStr);

		StringBuilder strHtmlStart = new StringBuilder("<table class=\"").append(sHtmlClass).append("\" ><thead><tr><td>");
		StringBuilder strHtmlStart2 = new StringBuilder("</td></tr></thead>").append(O.C_A_L);

		for (int idx = 0; idx != ary32.length;) {

			ret.append(strHtmlStart).append(idx + 1).append(strHtmlStart2);
			ret.append("<tr><td>");
			ret.append(B32va.strByLog2LowestBitBySAry(ary32[idx], sAry));
			ret.append(Strva.STR_HTML_TABLE_END);

			if (++idx != ary32.length)

				if (idx == Strva.maxRowInHtml)

					return ret;
				else
					ret.append(Jsp.L);

		}

		return ret;

	}
}