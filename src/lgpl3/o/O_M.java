package lgpl3.o;

import static java.lang.System.out;

/**
 * @version 2022/05/02_17:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=O_M" >O_M.java</a>
 *
 * @see O_V
 */
public abstract class O_M extends O_A {

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static void l(int[] ary32) { // print 10 elem

		StringBuilder str = new StringBuilder(defLenForStr);

		int len = ((ary32.length > 10) ? 10 : ary32.length);

		for (int idx = 0; idx != len;) {

			str.append(ary32[idx]);

			if (++idx != ary32.length)

				str.append(C_A_L);

		}

		out.println(str);

	}

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static void l(long[] ary) {

		StringBuilder str = new StringBuilder(defLenForStr);

		int len = ((ary.length > 10) ? 10 : ary.length);

		for (int idx = 0; idx != len;) {

			str.append(ary[idx]);

			if (++idx != ary.length)

				str.append(C_A_L);

		}

		// if (ary.length != 0)
		out.println(str);

	}

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static void l(char[] charAry) {

		out.println(charAry); // 自動轉換成文字
	}

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static <T extends CharSequence> void l(T[] genericAry) { // ambiguous for String and String[]

		StringBuilder str = new StringBuilder(defLenForStr);

		int len = ((genericAry.length > 10) ? 10 : genericAry.length);

		for (int idx = 0; idx != len;) {

			str.append(genericAry[idx]);

			if (++idx != genericAry.length)

				str.append(C_A_L);

		}

		out.println(str);

	}

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static void l(CharSequence charSeq) {

		out.println((charSeq instanceof String) ? ((String) charSeq) : charSeq.toString());
	}

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static void l() {

		out.println();
	}

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static void l(CharSequence charSeq, Class<?> calledByWhichClass) {

		out.println(new StringBuilder(defLenForStr).append(charSeq).append(" @").append(calledByWhichClass.getSimpleName()));
	}

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static int lv(int lv, CharSequence charSeq) { // 原創

		StringBuilder str = new StringBuilder(defLenForStr);

		for (int count = lv; --count != 0;)

			str.append(strForIndent);

		str.append(lv).append(C32).append(charSeq);

		out.println(str);

		return lv;

	}

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static long xy(long n1, long n2) {

		out.println(new StringBuilder(defLenForStr).append("x, y = ").append(n1).append(STR_C44C32).append(n2));

		return n1;

	}
}
