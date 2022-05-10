package lgpl3.other.sample;

import java.nio.file.Paths;
import java.util.TreeMap;
import java.util.regex.Pattern;

import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.other.iO.IOr;

/**
 * 列出某資料夾下所有子資料夾或檔案名稱 ( 對子資料夾以遞迴方式繼續列出 ).<br/>
 * <br/>
 * To list sub directory or file of the directory with recursion.
 * 
 * @version 2020/02/11_10:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex888_SearchSrc" >Ex888_SearchSrc.java</a>
 * 
 */
public class Ex888_SearchSrc {

	/**
	 * To load source code then to put in map wrapper.<br/>
	 * To load source code then to put in map wrapper.
	 */
	public static TreeMap<String, StringBuilder> loadSourceCodeNNameOfClass(String[] sAryForFilePath) {

		TreeMap<String, StringBuilder> mapToReturn = new TreeMap<String, StringBuilder>();

		for (int i = 0; i != sAryForFilePath.length; i++) {

			// O.l("sAry[i]=" + sAry[i] , THIS);

			StringBuilder strSourceCode = IOr.readStrFrom(Paths.get(sAryForFilePath[i]));
			// StringBuilder strSourceCodeWComment =new StringBuilder(strSourceCode );

			// String s = strSourceCode.toString();
			//
			// try {
			//
			// s = new String(s.getBytes("UTF-8"), "MS950");
			//
			// } catch (UnsupportedEncodingException e) {
			//
			// e.printStackTrace();
			//
			// }
			//
			// strSourceCode = new StringBuilder(s);

			String nameOfOnlyClass = O.subSBetween(strSourceCode, "nameOfClass=", O.S34);
			mapToReturn.put(nameOfOnlyClass, strSourceCode);
			// mapToReturn.put(nameOfOnlyClass, strSourceCodeWComment);

		}

		return mapToReturn;

	}

	public static void main(String[] sAry) throws Throwable {

		TreeMap<String, StringBuilder> mapOfSrc = null;

		String regToIn = O.Z;
		String regToEx = O.LINE_SEPARATOR;

		try {

			String stringRootDir = "./src/lgpl3";
			StringBuilder str = IOr.listSubFileNDir(stringRootDir, regToIn, regToEx);
			String[] sAryForFilePath = str.toString().split(O.LINE_SEPARATOR);

			Arr<String> arrOfS = new Arr<String>(String.class);

			for (String s : sAryForFilePath) {

				if (s.endsWith(".java")) {

					arrOfS.a(s);

				}

			}

			mapOfSrc = loadSourceCodeNNameOfClass(arrOfS.trim().arr);

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

		String[] sAryOfKey = mapOfSrc.keySet().toArray(O.S_ARY0);
		StringBuilder[] sAryOfVal = mapOfSrc.values().toArray(O.STR_ARY0);

		for (int i = 0, lenMinus1 = sAryOfKey.length - 1; i <= lenMinus1; i++) {

			String key = sAryOfKey[i];
			StringBuilder strSrc = sAryOfVal[i];

			// Pattern patternIn = Pattern.compile(regToIn,Pattern.CASE_INSENSITIVE);
			Pattern patternIn = Pattern.compile(regToIn);

			if ((patternIn.matcher(strSrc).find())) {

				O.l("found=" + key);

			}

		}

		O.l("done@" + Ex888_SearchSrc.class);

	}

}
