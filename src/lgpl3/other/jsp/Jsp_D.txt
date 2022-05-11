package lgpl3.other.jsp;

import java.util.TimeZone;

import lgpl3.o.str.Strva;

/**
 * @version 2022/02/02_14:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Jsp_D" >Jsp_D.java</a>
 *
 * @see Jsp_K
 */
public abstract class Jsp_D extends Jsp_A {

	// private static final Class<?> THIS = Jsp_D.class;

	public static final String $HOME = "http://c64.tw";

	public static final String $HOME_PREFIX = "http://c64.tw/";

	public static final String $JDK_DOWNLOAD = "http://www.oracle.com/technetwork/java/javase/downloads";

	public static final String $JAR_N_USER_GUIDE_ZIP = $HOME_PREFIX + "w20/prime64Lgpl/jarNUserGuide.zip";

	public static final String $STRING_FILE_PRIME64_DIY_PORTABLE = "prime64Lgpl3DiyPortable.zip";

	public static final String $STRING_FILE_PRIME64_PORTABLE = "prime64Lgpl3Portable.zip";

	public static final String $PRIME64_DIY_PORTABLE = $HOME_PREFIX + "w20/prime64Lgpl/" + $STRING_FILE_PRIME64_DIY_PORTABLE;

	// public static final String $PRIME64_PORTABLE = $HOME_PREFIX + "w20/prime64Lgpl/" + $STRING_FILE_PRIME64_PORTABLE;
	public static final String $PRIME64_PORTABLE = $HOME_PREFIX + "d2.jsp";

	public static final String $PRIME64_JAVA_DOC = $HOME_PREFIX + "w20/prime64Lgpl/srcTxtNDoc/doc";

	public static final String $PRIME64_PDF = $HOME_PREFIX + "w20/prime64Old/userGuide.pdf";

	public static final TimeZone MY_TIME_ZONE = TimeZone.getTimeZone("Asia/Taipei");

	public static Class<?> classInsForDbDriver;

	public static final String DB_URL = "jdbc:mysql://localhost/c64tw_c64twtab1?useUnicode=true&characterEncoding=utf8";

	/**
	 * The String POST.<br/>
	 * The String POST.
	 */
	public static final String STRING_POST = "POST";

	public static final String LOGIN_ID = "123";

	public static final String LOGIN_PASSWORD = "456";

	/**
	 * For Jsp.<br/>
	 * For Jsp.
	 *
	 * @see Strva#maxRowInHtml
	 */
	public static int int32MaxRowForHtmlInJsp = 0b1_000_000_000_000_000;

	/**
	 * 用於多執行緒的同步.<br/>
	 * For synchronizing.
	 */
	public static final Object KEY_TO_SYN = new Object();

}