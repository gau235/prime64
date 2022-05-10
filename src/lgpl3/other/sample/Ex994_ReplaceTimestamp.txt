package lgpl3.other.sample;

import java.nio.file.Path;
import java.nio.file.Paths;

import lgpl3.o.O;
import lgpl3.o.time.T64;
import lgpl3.other.iO.IOr;
import lgpl3.other.jsp.Jsp_D;

/**
 * To update the time stamp.<br/>
 * To update the time stamp.
 *
 * @version 2021/10/16_10:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex994_ReplaceTimestamp" >
 *          Ex994_ReplaceTimestamp.java</a>
 *
 * @see lgpl3.o.O
 *
 * @see Jsp_D
 *
 * @see lgpl3.o.B
 *
 * @see Ex989_ScanHttpPage
 */
public class Ex994_ReplaceTimestamp {

	public static void replace_B() {

		Path pathOfFile = Paths.get("C:/tmp/B.java");
		String sCode = IOr.readStrFrom(pathOfFile).toString();

		String tmpS = O.subSBetween(sCode, "[toReplace1", "toReplace1]");

		sCode = sCode.replace(tmpS, "//"); // must call replaceFirst but java's bug

		// O.l("sCode1=" + O.L + sCode);

		////////////////////////////////////////

		tmpS = O.subSBetween(sCode, "[toReplace2", "toReplace2]");

		sCode = sCode.replace(tmpS, "//"); // must call replaceFirst but java's bug

		O.l("sCode2=" + O.L + sCode);

		IOr.writeCharSeqToFile(sCode, pathOfFile);

	}

	public static void replace_O() {

		Path pathOfFile = Paths.get("C:/tmp/O.java");

		String oriS = IOr.readStrFrom(pathOfFile).toString();

		String tmpS = O.subSBetween(oriS, "S_UPDATED_TIME_AS_VERSION = \"", "\";");

		O.l("oldTime=" + tmpS);

		oriS = oriS.replace(tmpS, T64.toTimeStrWGmt().toString()); // must replaceFirst but bug

		tmpS = O.subSBetween(oriS, "S_UPDATED_TIME_AS_VERSION = \"", "\";");

		O.l("newTime=" + tmpS);

		O.l("sCode=" + O.L + oriS);

		IOr.writeCharSeqToFile(oriS, pathOfFile);

	}

	public static void replace_CompaForStrAry() {

		Path pathOfFile = Paths.get("C:/tmp/CompaForStrAry.java");
		String sCode = IOr.readStrFrom(pathOfFile).toString();

		sCode = sCode.replace(O.subSBetween(sCode, "[toReplace1", "toReplace1]"), "//");
		// must call replaceFirst but java's bug

		O.l("sCode=" + O.L + sCode);

		IOr.writeCharSeqToFile(sCode, pathOfFile);

	}

	public static void replace_Jsp_D() {

		Path pathOfFile = Paths.get("C:/tmp/Jsp_D.java");
		String sCode = IOr.readStrFrom(pathOfFile).toString();

		String tmpS = O.subSBetween(sCode, "LOGIN_ID = \"", "\";");

		sCode = sCode.replaceFirst(tmpS, "c64tw_c64twtab1");

		tmpS = O.subSBetween(sCode, "LOGIN_PASSWORD = \"", "\";");
		sCode = sCode.replaceFirst(tmpS, IOr.readStrFrom(Paths.get("C:/passwordFtp.txt")).toString().split(O.S61)[1]);

		O.l("sCode=" + O.L + sCode);

		IOr.writeCharSeqToFile(sCode, pathOfFile);

	}

	public static void replace_Ex989_ScanHttpPage() {

		Path pathOfFile = Paths.get("C:/tmp/Ex989_ScanHttpPage.java");

		String sCode = IOr.readStrFrom(pathOfFile).toString();

		IOr.writeCharSeqToFile(sCode.replaceFirst(O.subSBetween(sCode, "sUrl = \"", "\";"), "http://123"), pathOfFile);

	}

	public static void main(String[] sAry) throws Throwable {

		replace_B();
		replace_O();
		replace_CompaForStrAry();
		replace_Jsp_D();
		replace_Ex989_ScanHttpPage();

	}
}