package lgpl3.other.sample;

import java.util.TreeMap;
import java.util.regex.Pattern;

import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.other.iO.IOr;
import lgpl3.other.jsp.Jsp;

/**
 * 列出某資料夾下所有子資料夾或檔案名稱 (對子資料夾以遞迴方式繼續列出).<br/>
 * To list sub directory or file of the directory with recursion.
 *
 * @version 2022/05/17_10:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex888_SearchSrc" >src</a>
 *
 */
public class Ex888_SearchSrc extends Ex886_SearchSrc {

	private static final Class<?> THIS = Ex886_SearchSrc.class;

	public static void main(String[] sAry) throws Throwable {

		TreeMap<String, StringBuilder> mapOfSrc;

		String regToIn = O.Z;
		String regToEx = O.LINE_SEPARATOR;

		String sRootDir = "./src/lgpl3";

		String sRootDir2 = "C:/tmp/prime64Lgpl/src/lgpl3";

		StringBuilder str;

		try {
			str = IOr.listSubFileNDir(sRootDir, regToIn, regToEx);

		} catch (NullPointerException nullPointerEx) {

			str = IOr.listSubFileNDir(sRootDir2, regToIn, regToEx);
		}

		String[] sAryForFilePath = str.toString().split(O.LINE_SEPARATOR);

		Arr<String> arrOfS = new Arr<String>(String.class);

		for (String s : sAryForFilePath)

			if (s.endsWith(".java"))

				arrOfS.a(s);

		mapOfSrc = loadSrcNNameOfClass(arrOfS.trim().arr);

		String[] allKey = mapOfSrc.keySet().toArray(Jsp.S_ARY0);
		StringBuilder[] allStr = mapOfSrc.values().toArray(Jsp.STR_ARY0);

		String key, simpleNameOfClass;

		int idx = 0, count = 0;
		for (; idx != allKey.length; idx++)

			if (!(simpleNameOfClass = simpleNameOfClass(key = allKey[idx], str = allStr[idx])).equals(key)) {

				O.l(key + "===" + simpleNameOfClass);

				count++;

			}

		O.l("count=" + count, THIS);

	}

	public static void main2(String[] sAry) throws Throwable { // to search

		TreeMap<String, StringBuilder> mapOfSrc = null;

		String regToIn = O.Z;
		String regToEx = O.LINE_SEPARATOR;

		try {

			String stringRootDir = "./src/lgpl3";
			StringBuilder str = IOr.listSubFileNDir(stringRootDir, regToIn, regToEx);
			String[] sAryForFilePath = str.toString().split(O.LINE_SEPARATOR);

			Arr<String> arrOfS = new Arr<String>(String.class);

			for (String s : sAryForFilePath)

				if (s.endsWith(".java"))

					arrOfS.a(s);

			mapOfSrc = loadSrcNNameOfClass(arrOfS.trim().arr);

		} catch (Exception e) {

			e.printStackTrace();
		}

		regToIn = "(\\+ O.C[0-9][0-9]|\\+ O.C[0-9][0-9][0-9]|\\+ O.STR_C44C32)";
		regToIn = "(\\+ C[0-9][0-9]|\\+ C[0-9][0-9][0-9]|\\+ STR_C44C32)";

		regToIn = "(O.C[0-9][0-9] \\+|O.C[0-9][0-9][0-9] \\+|O.STR_C44C32 \\+)";
		regToIn = "(C[0-9][0-9] \\+|C[0-9][0-9][0-9] \\+|STR_C44C32 \\+)";

		regToIn = "O.S46 \\+";
		regToIn = "append\\(O.S[0-9][0-9]";
		regToIn = "append\\(SW[0-9][0-9]";
		regToIn = "append\\(O.L";
		regToIn = "append\\(L";
		regToIn = "\\+ L";
		regToIn = "\\+ O.L";

		regToIn = "replaceAll";
		regToIn = "nameOfClass=";
		// regToIn = "Gp(?!z|l)";

		O.l("search[" + regToIn + "]");

		String[] sAryOfKey = mapOfSrc.keySet().toArray(Jsp.S_ARY0);
		StringBuilder[] sAryOfVal = mapOfSrc.values().toArray(Jsp.STR_ARY0);

		for (int i = 0, lenMinus1 = sAryOfKey.length - 1; i <= lenMinus1; i++) {

			String key = sAryOfKey[i];
			StringBuilder strSrc = sAryOfVal[i];

			// Pattern patternIn = Pattern.compile(regToIn,Pattern.CASE_INSENSITIVE);
			Pattern patternIn = Pattern.compile(regToIn);

			if ((patternIn.matcher(strSrc).find()))

				O.l("found=" + key);

		}

		O.l("done@" + Ex888_SearchSrc.class);

	}
}
