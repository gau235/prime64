package lgpl3.other.jsp;

import java.io.IOException;
import java.util.Arrays;

import lgpl3.o.str.SW;
import lgpl3.other.iO.IOr;

/**
 * @version 2021/06/16_09:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Jsp_K" >Jsp_K.java</a>
 *
 * @see Jsp_U
 */
public abstract class Jsp_K extends Jsp_D {

	// private static final Class<?> THIS = Jsp_K.class;

	/**
	 * To gen array.<br/>
	 * To gen array.
	 */
	public static int[] genAry32FromDirtyCharSeq(CharSequence charSeq) {

		final String sSeparator = S44;

		final String theChineseBlank = new String("\u3000"); // 全形空白
		final String theChineseComma = new String("\uFF0C"); // 全形逗號 全形逗點

		l("theChineseBlank=" + theChineseBlank);
		l("theChineseComma=" + theChineseComma);

		String dirtyS = ((charSeq instanceof String) ? (String) charSeq : charSeq.toString());

		dirtyS = dirtyS.replace(theChineseBlank, sSeparator);
		dirtyS = dirtyS.replace(theChineseComma, sSeparator);
		dirtyS = dirtyS.replace(S32, sSeparator); // 空白

		l("new dirtyS=" + dirtyS);

		String[] sAry = splitNTrimAll(dirtyS, sSeparator);

		int[] retAry32 = new int[sAry.length];

		int iRet = 0;
		for (int idx = 0; idx != sAry.length; idx++) {

			try {
				retAry32[iRet] = Integer.parseInt(sAry[idx]);

			} catch (NumberFormatException numberFormatEx) {

				l(numberFormatEx);

				continue; // go to idx++

			}

			iRet++; // fuck

		}

		// l("retAry32=" + S32 + THIS);
		// l(retAry32);

		return delTailAll0(retAry32);

	}

	/**
	 * To view.<br/>
	 * To view.
	 */
	public static StringBuilder viewSource(String fromPath, String link) throws IOException {

		SW str = new SW();
		str.lineWr = L;

		// ex: ".java", ".html", ".jar", ".bat", ".xml", ".jsp";

		String regToIn = Z;
		String regToEx = "@@@@@"; // L.toString();

		StringBuilder strOfPath = IOr.listSubFileNDir(fromPath, regToIn, regToEx);

		String[] aryOfPath = strOfPath.toString().split(LINE_SEPARATOR); // fuck

		Arrays.sort(aryOfPath);

		for (int i = 0; i != aryOfPath.length; i++) {

			String sPath = aryOfPath[i].trim();

			sPath = sPath.replace(fromPath, Z);

			sPath = sPath.replace("\\", "/");
			String nameOfClassTxt = sPath.substring(sPath.lastIndexOf("/") + 1);

			sPath = link + sPath + "\" id=\"" + nameOfClassTxt + "\" style=\"font-size:20px; color: #000000;\" target=\"_blank\" >" + sPath
					+ "</a>";

			str.l(sPath);

		}

		return str.str;

	}
}