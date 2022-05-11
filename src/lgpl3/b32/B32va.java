package lgpl3.b32;

import static java.lang.System.out;

import lgpl3.o.O;
import lgpl3.o.ary.Ary32va;

/**
 * 本類別是使用 2 進位.<br/>
 * The 2 bit digit.
 *
 * @version 2022/02/26_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=B32va" >B32va.java</a>
 *
 * @see Ary32va
 */
public abstract class B32va extends B32va_V {

	private static final Class<?> THIS = B32va.class;

	/**
	 * The blank.<br/>
	 * The blank.
	 */
	public static final StringBuilder STR_$4BLANK = new StringBuilder("    ");

	/**
	 * 分配下去.<br/>
	 * To distribute.
	 */
	public static int[] distributeOver1Ary32(int b32As2Pow) {

		int[] retAry32 = new int[Integer.bitCount(b32As2Pow)];

		int idx = 0, lowest1;
		do
			retAry32[idx++] = lowest1 = (-b32As2Pow & b32As2Pow); // 連用 2 個等號

		while ((b32As2Pow = (~lowest1 & b32As2Pow)) != 0b0);

		return retAry32;

	}

//	/**
//	 * To Ary32.<br/>
//	 * To Ary32.
//	 */
//	public static int toB32As2PowByAryOfB32As2Pow(int[] ary32) {
//
//		int b32As2Pow = ary32[0];
//
//		for (int idx = 1; idx != ary32.length; idx++)
//
//			b32As2Pow |= ary32[idx];
//
//		return b32As2Pow;
//
//	}

	/**
	 * 回傳 2 進位字串建立者.<br/>
	 * To StringBuilder of 2 bit digit.
	 */
	public static StringBuilder str16(int int32) {

		int len = 19, idx = len, iUnder = 0;

		char[] charAry = new char[len];

		while (idx-- != 0)

			charAry[idx] = O.C48;

		idx = len - 1;

		do {
			if ((int32 & 0b1) != 0b0)

				charAry[idx] = O.C49;

			if (++iUnder == 4 || iUnder == 8 || iUnder == 12)

				charAry[--idx] = O.C95;

			// O.l("iUnder=" + iUnder, THIS);

			int32 >>>= 1;

		} while (idx-- != 0);

		// O.l("int32=" + Integer.toBinaryString(int32), THIS);

		return new StringBuilder(len).append(charAry);

	}

	/**
	 * 回傳 2 進位字串建立者.<br/>
	 * To StringBuilder of 2 bit digit.
	 */
	public static StringBuilder str(int int32) {

		int len = 39, idx = len, iUnder = 0;

		char[] charAry = new char[len];

		while (idx-- != 0)

			charAry[idx] = O.C48;

		idx = len - 1;

		do {
			if ((int32 & 0b1) != 0b0)

				charAry[idx] = O.C49;

			if (++iUnder == 4 || iUnder == 8 || iUnder == 12 || iUnder == 16 || iUnder == 20 || iUnder == 24 || iUnder == 28)

				charAry[--idx] = O.C95;

			// O.l("iUnder=" + iUnder, THIS);

			int32 >>>= 1;

		} while (idx-- != 0);

		// O.l("int32=" + Integer.toBinaryString(int32), THIS);

		return new StringBuilder(len).append(charAry);

	}

	/**
	 * To StringBuilder from String array via bit32.<br/>
	 * To StringBuilder from String array via bit32.
	 */
	public static StringBuilder strByLog2InB32BySAry(int b32As2Pow, String[] sAry) {

		StringBuilder ret = new StringBuilder(O.DEF_CAPACITY32_FOR_STR); // O.l(sAry);

		int lowest1;
		do
			if ((lowest1 = (-b32As2Pow & b32As2Pow)) == b32As2Pow)

				return ret.append(sAry[log2(lowest1)]);
			else
				ret.append(sAry[log2(lowest1)]).append(O.C44);

		while ((b32As2Pow = (~lowest1 & b32As2Pow)) != 0b0);

		throw new RuntimeException("b32As2Pow=" + str(b32As2Pow));

	}

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static int lv(int lv, CharSequence name, int int32) { // min lv is 1 嗎 // 原創

		StringBuilder ret = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		for (int count = lv; --count != 0;)

			ret.append(STR_$4BLANK);

		ret.append(lv).append(O.C32).append(name);

		out.println((int32 == 0b0) ? ret.append("=_") : ret.append(O.C61).append(strByLog2InB32BySAry(int32, O.S_ARY_A_Z)));

		return lv;

	}

	/**
	 * 印出文字.<br/>
	 * To print line.
	 */
	public static int lv(int lv, CharSequence charSeq) { // 原創

		StringBuilder ret = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		for (int count = lv; --count != 0;)

			ret.append(STR_$4BLANK);

		ret.append(lv).append(O.C32).append(charSeq);

		out.println(ret);

		return lv;

	}
}