package lgpl3.other.sample;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import lgpl3.o.O;
import lgpl3.o.time.T64;
import lgpl3.other.iO.IOr;
import lgpl3.other.jsp.Jsp_D;

/**
 * To update the time stamp.<br/>
 * To update the time stamp.
 *
 * @version 2022/05/16_10:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex994_ReplaceTimestamp" >src</a>
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

	/**
	 * 把程式碼存檔.<br/>
	 * To save the source code to file.
	 */
	public static void writeCharSeqToFile(CharSequence charSeq, Path pathOfFile) {

		try (BufferedWriter bufW = Files.newBufferedWriter(pathOfFile, StandardCharsets.UTF_8,

				StandardOpenOption.TRUNCATE_EXISTING)) { // java bug

			bufW.append(charSeq).flush();

		} catch (IOException iOEx) {

			iOEx.printStackTrace();
		}
	}

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

		writeCharSeqToFile(sCode, pathOfFile);

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

		writeCharSeqToFile(oriS, pathOfFile);

	}

	public static void replace_Jsp_D() {

		Path pathOfFile = Paths.get("C:/tmp/Jsp_D.java");
		String sCode = IOr.readStrFrom(pathOfFile).toString();

		String tmpS = O.subSBetween(sCode, "LOGIN_ID = \"", "\";");

		sCode = sCode.replaceFirst(tmpS, "c64tw_c64twtab1");

		tmpS = O.subSBetween(sCode, "LOGIN_PASSWORD = \"", "\";");
		sCode = sCode.replaceFirst(tmpS, IOr.readStrFrom(Paths.get("C:/passwordFtp.txt")).toString().split(O.S61)[1]);

		O.l("sCode=" + O.L + sCode);

		writeCharSeqToFile(sCode, pathOfFile);

	}

	public static void replace_Ex989_ScanHttpPage() {

		Path pathOfFile = Paths.get("C:/tmp/Ex989_ScanHttpPage.java");

		String sCode = IOr.readStrFrom(pathOfFile).toString();

		writeCharSeqToFile(sCode.replaceFirst(O.subSBetween(sCode, "sUrl = \"", "\";"), "http://123"), pathOfFile);

	}

	public static void main(String[] sAry) throws Throwable {

		replace_B();
		replace_O();

		replace_Jsp_D();
		replace_Ex989_ScanHttpPage();

	}
}