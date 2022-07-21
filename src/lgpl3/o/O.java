package lgpl3.o;

import static java.lang.System.out;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Properties;

/**
 * The origin.<br/>
 * The origin.
 *
 * @version 2021/09/16_10:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=O" >O.java</a>
 *
 */
public abstract class O extends O_W {

	/**
	 * To getSysUserDotName.<br/>
	 * To getSysUserDotName.
	 */
	public static String getSysUserDotName() {

		try {

			String fileDotEncoding = System.getProperty("file.encoding");
			out.println("file.encoding=" + fileDotEncoding + S32 + O.class);

			String oldUserDotName = System.getProperty("user.name");
			String newUserDotName = new String(oldUserDotName.getBytes(fileDotEncoding), StandardCharsets.UTF_8);
			// String newS = new String(oldS.getBytes("MS950"), "UTF8");
			// String newS = new String(oldS.getBytes("UTF8"), "MS950");

			out.println("oldUserDotName=" + oldUserDotName + S32 + O.class);
			out.println("newUserDotName=" + newUserDotName + S32 + O.class);

			// out.println("newUserDotName=" + new String(oldS.getBytes(), "MS950") + S32 + O.class);
			// out.println("newUserDotName=" + new String(oldS.getBytes(), "UTF8") + S32 + O.class);

			return newUserDotName;

		} catch (UnsupportedEncodingException unsupportedEncodingEx) {

			unsupportedEncodingEx.printStackTrace();
			return null;

		}
	}

	/**
	 * To merge all string in array of string.
	 */
	public static String[] mergeIn1SAry(String[]... sAry2D) {

		int idx = 0, bigLen = 0;

		for (; idx != sAry2D.length; bigLen += sAry2D[idx++].length)
			;

		String[] ret = new String[bigLen], tmpSAry;

		// O.l(ret);

		for (idx = 0, bigLen = 0; idx != sAry2D.length; idx++, bigLen += tmpSAry.length)

			System.arraycopy(tmpSAry = sAry2D[idx], 0, ret, bigLen, tmpSAry.length);

		return ret;

	}

	/**
	 * 把 TreeMap 轉字串建立者.<br/>
	 * To convert the TreeMap to StringBuilder with line wrapper.
	 */
	public static StringBuilder strOfProp(Properties prop, CharSequence lineWr) {

		StringBuilder ret = new StringBuilder(O.defLenForStr);

		String key;

		for (Enumeration<?> en = prop.propertyNames(); en.hasMoreElements();)

			ret.append(key = (String) en.nextElement()).append(O.C61).append(prop.getProperty(key)).append(lineWr);

		return ret;

	}

	/**
	 * The user.name.<br/>
	 * The user.name.
	 */
	public static final String SYS_USER_DOT_NAME = System.getProperty("user.name"); // getSysUserDotName();

	/**
	 * Is to develop?<br/>
	 * Is to develop?
	 */
	// 原創
	public static boolean isDev = "gau".equalsIgnoreCase(SYS_USER_DOT_NAME) || "demo".equalsIgnoreCase(SYS_USER_DOT_NAME);

	/**
	 * Is Linux?<br/>
	 * Is Linux?
	 */
	public static final boolean IS_LINUX = ("linux".compareToIgnoreCase(System.getProperty("os.name")) == 0);

	/**
	 * The String array.<br/>
	 * The String array.
	 */
	public static final String[] S_ARY_A_Z = { S65, S66, S67, S68, S69, S70, S71, S72, S73, S74, S75, S76, S77, S78, S79, S80,

			S81, S82, S83, S84, S85, S86, S87, S88, S89, S90 };

	/**
	 * The updated time.<br/>
	 * The updated time.
	 */
	public static final String S_UPDATED_TIME_AS_VERSION = "2022/07/20_16:15:03+08:00"; // will auto update

}