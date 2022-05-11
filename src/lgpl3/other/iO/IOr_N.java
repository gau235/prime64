package lgpl3.other.iO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import lgpl3.o.O;
import lgpl3.o.str.Strva;

/**
 * @version 2022/04/19_19:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=IOr_N" >IOr_N.java</a>
 *
 * @see IOr_R
 */
public abstract class IOr_N extends IOr_A {

	// private static final Class<?> THIS = IOr_N.class;

	/**
	 * 讀取文字檔內容.<br/>
	 * To read the source code file.
	 */
	public static StringBuilder readStrFrom(Path pathOfFile) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		try (BufferedReader bufR = Files.newBufferedReader(pathOfFile, StandardCharsets.UTF_8)) {

			int lenOfStr;
			for (String s; (s = bufR.readLine()) != null;)

				retStr.append(s).append(O.C_A_L);

			if ((lenOfStr = retStr.length()) > O.C_A_L.length)

				retStr.delete(lenOfStr - O.C_A_L.length, lenOfStr);

		} catch (IOException iOEx) {

			iOEx.printStackTrace();
		}

		return retStr;

	}

	/**
	 * 把程式碼存檔.<br/>
	 * To save the source code to file.
	 */
	public static void appendCharSeqToFile(CharSequence charSeq, Path pathOfFile) {

		try (BufferedWriter bufW = Files.newBufferedWriter(pathOfFile, StandardCharsets.UTF_8, StandardOpenOption.APPEND);) {

			bufW.append(charSeq).flush();

		} catch (IOException iOEx) {

			iOEx.printStackTrace();
		}
	}

	/**
	 * 把程式碼存檔.<br/>
	 * To save the source code to file.
	 */
	public static void writeCharSeqToFile(CharSequence charSeq, Path pathOfFile) {

		try (BufferedWriter bufW = Files.newBufferedWriter(pathOfFile, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);) {

			bufW.append(charSeq).flush();

		} catch (IOException iOEx) {

			iOEx.printStackTrace();
		}
	}

	/**
	 * 橫列轉直行.<br/>
	 * To divide a row to some rows.
	 */
	public static String[] readNSplit1RowToSAry(Path pathOfFile, String regexToSplit) {

		return O.splitNTrimAll(readStrFrom(pathOfFile), regexToSplit);
	}

	/**
	 * 直行轉橫列.<br/>
	 * To merge some rows into 1 row.
	 */
	public static StringBuilder readNMergeSomeSInto1Row(Path pathOfFile, String regexToSplit, CharSequence lineWr) {

		return Strva.mergeInStr(O.splitNTrimAll(readStrFrom(pathOfFile), regexToSplit), lineWr);
	}
}