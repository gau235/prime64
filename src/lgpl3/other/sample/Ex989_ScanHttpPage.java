package lgpl3.other.sample;

import lgpl3.o.O;
import lgpl3.other.jsp.Jsp;

/**
 * To open a Http connection.<br/>
 * To open a Http connection.
 *
 * @version 2022/01/29_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex989_ScanHttpPage" >Ex989_ScanHttpPage.java</a>
 *
 */
public class Ex989_ScanHttpPage {

	public static void main(String[] sAry) throws Throwable {

		String sUrl = "http://123";

		String sHtml = Jsp.doPostNDownload(sUrl).toString();
		// O.l(sHtml);

		sHtml = sHtml.substring(sHtml.indexOf("class=\"main_right_margin\">"));

		String target11 = "【";
		String target12 = "】";

		String tmpS;

		for (int count = 8; sHtml.indexOf(target11) != -1 && count != 0; count--) {

			tmpS = O.subSBetween(sHtml, target11, target12);
			O.l(tmpS);

			O.l();

			sHtml = sHtml.substring(sHtml.indexOf(target12) + 1);
			// O.l("sHtml=" + sHtml);

		}
	}
}