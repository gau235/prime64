package lgpl3.other.sample;

import java.io.IOException;
import java.util.TreeMap;

import lgpl3.o.O;
import lgpl3.o.str.Strva;
import lgpl3.o.time.T64;
import lgpl3.other.jsp.Jsp;

/**
 * To open a Http connection.<br/>
 * To open a Http connection.
 *
 * @version 2018/08/15_14:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex246_WinningNum539" >Ex246_WinningNum539.java</a>
 *
 */
public class Ex246_WinningNum539 {

	public static String[] strAryWinningNumRecent3Day() throws IOException {

		String sUrl = "http://www.taiwanlottery.com.tw/lotto/DailyCash/history.aspx";
		TreeMap<String, String> mapOfParam = new TreeMap<String, String>();

		StringBuilder str = Jsp.doPostNDownload(sUrl, mapOfParam);
		// O.l(str);

		String[] sAryDate = new String[3];
		sAryDate[0] = T64.toTimeStr(O.t() - T64.$1_DAY_IN_MILLI * 0, T64.DEF_TIME_ZONE).substring(5, 10);
		sAryDate[1] = T64.toTimeStr(O.t() - T64.$1_DAY_IN_MILLI * 1, T64.DEF_TIME_ZONE).substring(5, 10);
		sAryDate[2] = T64.toTimeStr(O.t() - T64.$1_DAY_IN_MILLI * 2, T64.DEF_TIME_ZONE).substring(5, 10);

		String[] retSAry = new String[] { "<hr>", "<hr>", "<hr>" };
		int idxS = 0;
		int offset = 945;

		if (O.IS_LINUX)
			offset = 930;

		for (int i = 0; i != 3; i++) {

			if (str.indexOf(sAryDate[idxS]) > 0) {

				int idx = str.indexOf(sAryDate[idxS]) + offset;
				// O.l(index);

				String tmpS = str.substring(idx, idx + 620).trim();

				String[] tmpSAry = O.splitNTrimAll(tmpS, "</span>");// only \n fuck
				// O.l(tmpSAry);

				tmpS = tmpSAry[0].substring(tmpSAry[0].length() - 2, tmpSAry[0].length()) + ",&nbsp;";
				tmpS += tmpSAry[1].substring(tmpSAry[1].length() - 2, tmpSAry[1].length()) + ",&nbsp;";
				tmpS += tmpSAry[2].substring(tmpSAry[2].length() - 2, tmpSAry[2].length()) + ",&nbsp;";
				tmpS += tmpSAry[3].substring(tmpSAry[3].length() - 2, tmpSAry[3].length()) + ",&nbsp;";
				tmpS += tmpSAry[4].substring(tmpSAry[4].length() - 2, tmpSAry[4].length());

				retSAry[idxS] = sAryDate[idxS] + Jsp.L + tmpS + O.L + "<hr>";

				// O.l("retSAry[idxS]=" + retSAry[idxS]);

			}

			idxS++;

		}

		return retSAry;

	}

	public static void main(String[] sAry) throws Throwable {

		StringBuilder str = Strva.mergeInStr(strAryWinningNumRecent3Day(), Jsp.L);
		O.l(str);
		// O.l(strAryWinningNumIn3Day());

	}
}
