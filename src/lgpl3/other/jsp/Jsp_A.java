package lgpl3.other.jsp;

import lgpl3.o.O_V;

/**
 * 本類別 Jsp.<br/>
 *
 * @version 2022/05/20_13:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Jsp_A" >Jsp_A.java</a>
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
	 * 長度 0 的字串陣列.<br/>
	 * The String array which length is 0.
	 */
	public static final String[] S_ARY0 = new String[0];

	/**
	 * 長度 0 的 StringBuilder 陣列.<br/>
	 * The StringBuilder array which length is 0.
	 */
	public static final StringBuilder[] STR_ARY0 = new StringBuilder[0];

	/**
	 * 長度 0 的 CharSequence 陣列.<br/>
	 * The CharSequence array which length is 0.
	 */
	public static final CharSequence[] CHAR_SEQ_ARY0 = new CharSequence[0];

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
	public static final char[] C_A_3_HTML_BLANK = new char[] { '&', 'n', 'b', 's', 'p', ';', '&', 'n', 'b', 's', 'p', ';', '&',

			'n', 'b', 's', 'p', ';' };

	/**
	 * The &nbsp;.<br/>
	 * The &nbsp;.
	 */
	public static final char[] C_A_6_HTML_BLANK = new char[] { '&', 'n', 'b', 's', 'p', ';', '&', 'n', 'b', 's', 'p', ';', '&',

			'n', 'b', 's', 'p', ';', '&', 'n', 'b', 's', 'p', ';', '&', 'n', 'b', 's', 'p', ';', '&', 'n', 'b', 's', 'p', ';' };

}