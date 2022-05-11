package lgpl3.o.str;

import java.util.Enumeration;
import java.util.Properties;

import lgpl3.o.O;
import lgpl3.o.ary.Arr;

/**
 * 本類別字串娃.<br/>
 * The girl to handle string.
 *
 * @version 2021/08/29_10:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Strva" >Strva.java</a>
 *
 */
public abstract class Strva {

	// private static final Class<?> THIS = Strva.class;

	public static int numOfWordPerLineForS2 = 2;

	public static final StringBuilder STR_HTML_MIDDLE_TD = new StringBuilder("</td><td>");

	public static final StringBuilder STR_HTML_TABLE_END = new StringBuilder("</td></tr></table>");

	public static int maxRowInHtml = 1_000;

	/**
	 * To merge all string in array of string.<br/>
	 * To merge all string in array of string.
	 */
	public static StringBuilder mergeInStr(String[] sAry, CharSequence lineWr) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);
		for (int idx = 0; idx != sAry.length;) {

			retStr.append(sAry[idx]);

			if (++idx != sAry.length)
				retStr.append(lineWr);

		}

		return retStr;

	}

	/**
	 * To merge all string in array of string.<br/>
	 * To merge all string in array of string.
	 */
	public static String[] mergeIn1SAry(Arr<String[]> arrOfSAry) {

		int idx;
		int bigLen = 0;

		String[][] sAry = arrOfSAry.arr;

		for (idx = 0; idx != arrOfSAry.iLen; idx++)
			bigLen += sAry[idx].length;

		String[] retSAry = new String[bigLen];

		int iRetSAry = 0;

		String[] tmpSAry;

		for (idx = 0; idx != arrOfSAry.iLen; idx++) {// todo: idx array copy

			System.arraycopy(tmpSAry = sAry[idx], 0, retSAry, iRetSAry, tmpSAry.length);

			iRetSAry = iRetSAry + tmpSAry.length;

		}

		return retSAry;

	}

	/**
	 * 把 TreeMap 轉字串建立者.<br/>
	 * To convert the TreeMap to StringBuilder with line wrapper.
	 */
	public static StringBuilder toStrOfProp(Properties prop, CharSequence lineWr) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		String key;
		for (Enumeration<?> en = prop.propertyNames(); en.hasMoreElements();)
			retStr.append(key = (String) en.nextElement()).append(O.C61).append(prop.getProperty(key)).append(lineWr);

		return retStr;

	}
}
