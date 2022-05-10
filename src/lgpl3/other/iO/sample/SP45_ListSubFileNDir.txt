package lgpl3.other.iO.sample;

import lgpl3.o.O;
import lgpl3.other.iO.IOr;

/**
 * 列出某資料夾下所有子資料夾或檔案名稱 ( 對子資料夾以遞迴方式繼續列出 ).<br/>
 * <br/>
 * To list sub directory or file of the directory with recursion.
 * 
 * @version 2020/02/10_22:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=SP45_ListSubFileNDir" >SP45_ListSubFileNDir.java</a>
 * 
 */
public class SP45_ListSubFileNDir {

	public static void main(String[] sAry) throws Throwable {

		String regToIn = O.Z;
		// String regToEx = O.L;
		String regToEx = "(.bat|.class|.html|.txt|.xml|$R|.jar)";

		StringBuilder str = IOr.listSubFileNDir("C:/tmp/prime64Lgpl/src", regToIn, regToEx);

		String s = "javac -encoding UTF-8 -cp .;*;./lib/;./lib/* ";
		s = s + str.toString().replace(O.L, "\njavac -encoding UTF-8 -cp .;*;./lib/;./lib/* ");

		O.l(s);

	}

}
