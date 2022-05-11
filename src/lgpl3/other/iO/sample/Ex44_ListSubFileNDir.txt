package lgpl3.other.iO.sample;

import java.util.regex.Pattern;

import lgpl3.o.O;
import lgpl3.other.iO.IOr;

/**
 * 列出某資料夾下所有子資料夾或檔案名稱 ( 對子資料夾以遞迴方式繼續列出 ).<br/>
 * To list sub directory or file of the directory with recursion.
 *
 * @version 2021/06/15_22:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex44_ListSubFileNDir" >
 *          Ex44_ListSubFileNDir.java</a>
 *
 */
public class Ex44_ListSubFileNDir {

	public static void main(String[] sAry) throws Throwable {

		// String sRootDir = "C:/tmp/srcTxtNDoc/src/lgpl3";
		String sRootDir = "Z:/";

		// String regToIn = "(64)";
		String regToIn = O.Z;
		String regToEx = "RECYCLE|System";
		// String regToEx = O.LINE_SEPARATOR;

		Pattern patternIn = Pattern.compile(regToIn);
		Pattern patternEx = Pattern.compile(regToEx);
		//
		// O.l("patternIn.matcher(sRootDir).find()=" + patternIn.matcher(sRootDir).find() + O.S32 + Ex44_ListSubFileNDir.class);

		StringBuilder str = IOr.listSubFileNDir(sRootDir, regToIn, regToEx);
		O.l(str);

		/////////////////////////////////////////////
		sAry = str.toString().split(O.LINE_SEPARATOR);

		for (int i = 0; i != sAry.length; i++) {

			if (sAry[i].endsWith(".txt"))
				O.l(sAry[i]);

		}
	}
}
