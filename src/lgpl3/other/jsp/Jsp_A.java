package lgpl3.other.jsp;

import lgpl3.o.O_V;

/**
 * 本類別 Jsp.<br/>
 * priority: System great than char[] great than StringBuilder great than String.
 *
 * @version 2021/05/24_18:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Jsp_A" >Jsp_A.java</a>
 *
 * @see Jsp_D
 */
public abstract class Jsp_A extends O_V {

	// private static final Class<?> THIS = Jsp_A.class;

	/**
	 * HTML 換行符號.<br/>
	 * The HTML line separator.
	 */
	public static final StringBuilder BR = new StringBuilder("<br/>");

	/**
	 * HTML 換行符號.<br/>
	 * The HTML line separator.
	 */
	public static final String S_BR = BR.toString();

	/**
	 * 換行符號.<br/>
	 * The line separator.
	 */
	public static final StringBuilder L = new StringBuilder(S_BR).append(C_A_L);

	/**
	 * The &nbsp;.<br/>
	 * The &nbsp;.
	 */
	public static final char[] C_A_HTML_BLANK = new char[] { '&', 'n', 'b', 's', 'p', ';' };

	/**
	 * The &nbsp;.<br/>
	 * The &nbsp;.
	 */
	public static final char[] C_A_2_HTML_BLANK = new char[] { '&', 'n', 'b', 's', 'p', ';', '&', 'n', 'b', 's', 'p', ';' };

	/**
	 * The &nbsp;.<br/>
	 * The &nbsp;.
	 */
	public static final char[] C_A_3_HTML_BLANK = new char[] { '&', 'n', 'b', 's', 'p', ';', '&', 'n', 'b', 's', 'p', ';', '&', 'n', 'b',
			's', 'p', ';' };

	/**
	 * The &nbsp;.<br/>
	 * The &nbsp;.
	 */
	public static final char[] C_A_6_HTML_BLANK = new char[] { '&', 'n', 'b', 's', 'p', ';', '&', 'n', 'b', 's', 'p', ';', '&', 'n', 'b',
			's', 'p', ';', '&', 'n', 'b', 's', 'p', ';', '&', 'n', 'b', 's', 'p', ';', '&', 'n', 'b', 's', 'p', ';' };

}