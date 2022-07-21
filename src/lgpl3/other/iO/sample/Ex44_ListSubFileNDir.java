package lgpl3.other.iO.sample;

import java.nio.file.Paths;

import lgpl3.o.O;
import lgpl3.other.iO.IOr;

/**
 * 列出某資料夾下所有子資料夾或檔案名稱 ( 對子資料夾以遞迴方式繼續列出 ).<br/>
 * To list sub directory or file of the directory with recursion.
 *
 * @version 2022/05/15_22:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex44_ListSubFileNDir" >src</a>
 *
 */
public class Ex44_ListSubFileNDir {

	public static void main(String[] sAry) throws Throwable {

		// String sRootDir = "C:/tmp/srcTxtNDoc/src/lgpl3";
		String sRootDir = "Z:/";

		// String regToIn = "(64)";
		String regToIn = O.Z;
		String regToEx = "RECYCLE|System Volume|pagefile.sys|.git";
		// String regToEx = O.LINE_SEPARATOR;

		StringBuilder str = IOr.listSubFileNDir(sRootDir, regToIn, regToEx);

		IOr.toUtf8FileAftNew(Paths.get("C:\\Users\\gau\\Desktop\\z.txt"), str);

		int rnd = O.rnd100();

		if (rnd < 5)

			O.l(str);

		O.l("rnd=" + rnd);

	}
}
