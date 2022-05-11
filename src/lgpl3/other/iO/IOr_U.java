package lgpl3.other.iO;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import lgpl3.o.O;

/**
 * @version 2020/02/02_02:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=IOr_U" >IOr_U.java</a>
 *
 * @see IOr_W
 */
public abstract class IOr_U extends IOr_R {

	// private static final Class<?> THIS = IOr_U.class;

	/**
	 * 列出某資料夾下所有子資料夾或檔案名稱 ( 對子資料夾以遞迴方式繼續列出 ).<br/>
	 * To list sub directory or file of the directory with recursion.
	 */
	public static void listSubFileNDir(String sRootDir, Pattern patternIn, Pattern patternEx, StringBuilder retStr) throws IOException {

		final File dir = new File(sRootDir);

		// O.l("sRootDir=" + sRootDir, THIS);
		// O.l("isDir=" + dir.isDirectory(), THIS);

		File[] aryOfFileOrDir = dir.listFiles();
		File fileOrDir;
		String sCanonicalPath;

		for (int i = 0; i != aryOfFileOrDir.length; i++) {

			fileOrDir = aryOfFileOrDir[i];
			sCanonicalPath = fileOrDir.getCanonicalPath();
			// O.l("sCanonicalPath=" + sCanonicalPath , THIS);

			if ((patternIn.matcher(sCanonicalPath).find()) && (!patternEx.matcher(sCanonicalPath).find())) {

				retStr.append(sCanonicalPath).append(O.C_A_L);

				if (fileOrDir.isDirectory())
					listSubFileNDir(sCanonicalPath, patternIn, patternEx, retStr);

			}
		}
	}

	/**
	 * 列出某資料夾下所有子資料夾或檔案名稱 ( 對子資料夾以遞迴方式繼續列出 ).<br/>
	 * To list sub directory or file of the directory with recursion.
	 */
	public static StringBuilder listSubFileNDir(String sRootDir, String regToIn, String regToEx) throws IOException {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		Pattern patternIn = Pattern.compile(regToIn);
		Pattern patternEx = Pattern.compile(regToEx);

		if ((patternIn.matcher(sRootDir).find()) && (!patternEx.matcher(sRootDir).find()))
			listSubFileNDir(sRootDir, patternIn, patternEx, retStr);

		return retStr;

	}
}