package lgpl3.other.sample;

import lgpl3.o.O;
import lgpl3.other.jsp.Jsp;

/**
 * 檢查新版.<br/>
 * To check if it is up to date.
 *
 * @version 2021/08/23_12:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex136_CheckVersion" >Ex136_CheckVersion.java</a>
 *
 */
public class Ex136_CheckVersion {

	public static void main(String[] sAry) throws Throwable {

		String sUrl = "http://c64.tw/w20/prime64Lgpl/srcTxtNDoc/src/lgpl3/o/O.txt";

		StringBuilder strSrc = Jsp.doPostNDownload(sUrl);
		// O.l(strSrc);

		if (strSrc.indexOf("S_UPDATED_TIME_AS_VERSION") > 0) {

			String sVersion = O.subSBetween(strSrc, "S_UPDATED_TIME_AS_VERSION = \"", "\"");

			O.l("oldversion=" + O.L + sVersion);
			O.l("newversion=" + O.L + O.S_UPDATED_TIME_AS_VERSION);

		}

		O.l("package=" + O.subSBetween(strSrc, "package ", O.S59));
		O.l("nameOfClass=" + O.subSBetween(strSrc, "nameOfClass=", O.S34));

	}
}
