package lgpl3.o;

import static java.lang.System.out;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * The origin.<br/>
 * The origin.
 *
 * @version 2021/09/16_10:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=O" >O.java</a>
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
	 * The user.name.<br/>
	 * The user.name.
	 */
	public static final String SYS_USER_DOT_NAME = System.getProperty("user.name"); // getSysUserDotName();

	/**
	 * Is to develop?<br/>
	 * Is to develop?
	 */
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
	public static final String[] S_ARY_A_Z = { S65, S66, S67, S68, S69, S70, S71, S72, S73, S74, S75, S76, S77, S78, S79, S80, S81, S82,
			S83, S84, S85, S86, S87, S88, S89, S90 };

	/**
	 * The updated time.<br/>
	 * The updated time.
	 */
	public static final String S_UPDATED_TIME_AS_VERSION = "2022/05/11_14:00:34+08:00"; // will auto update

}