package lgpl3.other.sample;

import java.io.File;
import java.nio.file.Paths;
import java.util.TreeMap;

import lgpl3.o.O;
import lgpl3.other.iO.IOr;

/**
 * 列出某資料夾下所有子資料夾或檔案名稱 ( 對子資料夾以遞迴方式繼續列出 ).<br/>
 * To list sub directory or file of the directory with recursion.
 *
 * @version 2022/05/11_10:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex886_SearchSrc" >src</a>
 *
 * @see Ex888_SearchSrc
 */
public class Ex886_SearchSrc {

	/**
	 * To load source code then to put in map wrapper.<br/>
	 * To load source code then to put in map wrapper.
	 */
	public static TreeMap<String, StringBuilder> loadSrcNNameOfClass(String[] sAryForFilePath) {

		TreeMap<String, StringBuilder> ret = new TreeMap<String, StringBuilder>();

		String nameByFile, linkName;

		StringBuilder strSrc;

		for (int idx = 0; idx != sAryForFilePath.length; idx++) {

			strSrc = IOr.readStrFrom(Paths.get(nameByFile = sAryForFilePath[idx]));

			linkName = O.subSBetween(strSrc, "nameOfClass=", O.S34);

			nameByFile = nameByFile.substring((nameByFile.lastIndexOf(File.separator) + 1), nameByFile.lastIndexOf(O.S46));

			if (!linkName.equals(nameByFile))

				O.x("nameByFile=" + nameByFile + " linkName=" + linkName);

			ret.put(nameByFile, strSrc);

		}

		return ret;

	}

	/**
	 * To load source code then to put in map wrapper.<br/>
	 * To load source code then to put in map wrapper.
	 */
	public static String simpleNameOfClass(String key, StringBuilder strSrc) {

		// if (key.startsWith("G")) O.l("here=" + key, Ex886_SearchSrc.class);

		String ret = null;

		try {
			ret = O.subSBetween(strSrc, "public class ", " ").trim();

		} catch (NullPointerException nullPointerEx1) {

			try {
				ret = O.subSBetween(strSrc, "public abstract class ", " ").trim();

			} catch (NullPointerException nullPointerEx2) {

				try {
					ret = O.subSBetween(strSrc, "public final class ", " ").trim();

				} catch (NullPointerException nullPointerEx3) {

					O.x("key=" + key);
				}
			}
		}

		return ret;

	}
}
