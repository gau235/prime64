package lgpl3.o;

import static java.lang.System.out;

/**
 * @version 2022/04/02_17:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=O_M" >O_M.java</a>
 *
 * @see O_V
 */
public abstract class O_M extends O_A {

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static void l(boolean b) {

		out.println(b);
	}

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static void l(int int32) {

		out.println(int32);
	}

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static void l(long n) {

		out.println(n);
	}

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static void l(float f32) {

		out.println(f32);
	}

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static void l(double f64) {

		out.println(f64);
	}

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static void l(char c) {

		out.println(c);
	}

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static void l(int[] ary32) {

		StringBuilder retStr = new StringBuilder(DEF_CAPACITY32_FOR_STR);

		int len = ((ary32.length > 10) ? 10 : ary32.length);

		for (int idx = 0; idx != len;) {

			retStr.append(ary32[idx]);

			if (++idx != ary32.length)
				retStr.append(C_A_L);

		}

		out.println(retStr);

	}

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static void l(long[] ary) {

		StringBuilder retStr = new StringBuilder(DEF_CAPACITY32_FOR_STR);

		int len = ((ary.length > 10) ? 10 : ary.length);

		for (int idx = 0; idx != len;) {

			retStr.append(ary[idx]);

			if (++idx != ary.length)
				retStr.append(C_A_L);

		}

		// if (ary.length != 0)
		out.println(retStr);

	}

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static void l(char[] charAry) {

		StringBuilder retStr = new StringBuilder(DEF_CAPACITY32_FOR_STR);

		int len = ((charAry.length > 10) ? 10 : charAry.length);

		for (int idx = 0; idx != len;) {

			retStr.append(charAry[idx]);

			if (++idx != charAry.length)
				retStr.append(C_A_L);

		}

		out.println(retStr);

	}

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static <T extends CharSequence> void l(T[] genericAry) { // ambiguous for String and String[]

		StringBuilder retStr = new StringBuilder(DEF_CAPACITY32_FOR_STR);

		int len = ((genericAry.length > 10) ? 10 : genericAry.length);

		for (int idx = 0; idx != len;) {

			retStr.append(genericAry[idx]);

			if (++idx != genericAry.length)
				retStr.append(C_A_L);

		}

		out.println(retStr);

	}

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static void l(String s) {

		out.println(s);
	}

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static void l(Object obj) {

		out.println(String.valueOf(obj));
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
	public static long xy(long n1, long n2) {

		out.println(new StringBuilder(DEF_CAPACITY32_FOR_STR).append("x, y = ").append(n1).append(STR_C44C32).append(n2));

		return n1;

	}

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static void l(CharSequence charSeq, Class<?> calledByWhichClass) {

		out.println(new StringBuilder(DEF_CAPACITY32_FOR_STR).append(charSeq).append(" @").append(calledByWhichClass.getSimpleName()));
	}
}
