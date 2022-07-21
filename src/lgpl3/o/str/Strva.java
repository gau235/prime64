package lgpl3.o.str;

import lgpl3.o.O;

/**
 * 本類別字串娃.<br/>
 * The girl to handle string.
 *
 * @version 2021/08/29_10:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Strva" >Strva.java</a>
 *
 */
public abstract class Strva {

	// private static final Class<?> THIS = Strva.class;

	public static int numOfWordPerLineForS2 = 2;

	public static final StringBuilder STR_HTML_MIDDLE_TD = new StringBuilder("</td><td>");

	public static final StringBuilder STR_HTML_TABLE_END = new StringBuilder("</td></tr></table>");

	public static int maxRowInHtml = 1_000;

	/**
	 * To merge all string in array of string.
	 */
	public static StringBuilder mergeInStr(String[] sAry, CharSequence lineWr) {

		StringBuilder ret = new StringBuilder(O.defLenForStr);

		for (int idx = 0; idx != sAry.length;) {

			ret.append(sAry[idx]);

			if (++idx != sAry.length)

				ret.append(lineWr);

		}

		return ret;

	}
}
