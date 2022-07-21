package lgpl3.b64;

import lgpl3.b32.B32va;
import lgpl3.o.O;

/**
 * 本類別是使用 2 進位.<br/>
 * The 2 bit digit.
 *
 * @version 2022/05/10_20:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=B64va" >B64va.java</a>
 *
 * @see B32va
 */
public abstract class B64va extends B64va_L {

	// private static final Class<?> THIS = B64va.class;

	/**
	 * 回傳 2 進位字串建立者.<br/>
	 * To StringBuilder of 2 bit digit.
	 */
	public static StringBuilder str(long int64) {

		if (int64 == 0L)

			return new StringBuilder(S_64BIT_$0_W_UNDERLINE);

		if (int64 == 1L)

			return new StringBuilder(S_64BIT_$1_W_UNDERLINE);

		int len = 79, idx = len, iUnderl = 0;

		char[] charAry = new char[len];

		while (idx-- != 0)

			charAry[idx] = O.C48;

		idx = len - 1;

		do {
			if (((int) int64 & 0b1) != 0b0)

				charAry[idx] = O.C49;

			if (++iUnderl == 4 || iUnderl == 8 || iUnderl == 12 || iUnderl == 16 || iUnderl == 20 || iUnderl == 24 ||

					iUnderl == 28 || iUnderl == 32 || iUnderl == 36 || iUnderl == 40 || iUnderl == 44 || iUnderl == 48 ||

					iUnderl == 52 || iUnderl == 56 || iUnderl == 60)

				charAry[--idx] = O.C95;

			// O.l("iUnder=" + iUnder, THIS);

			int64 >>>= 1;

		} while (idx-- != 0);

		// O.l("int64=" + int64, THIS);

		return new StringBuilder(len).append(charAry);

	}

	/**
	 * To StringBuilder from String array via bit64.<br/>
	 * To StringBuilder from String array via bit64.
	 */
	public static StringBuilder strByLog2InB64BySAry(long b64As2Pow, String[] sAry) {

		StringBuilder ret = new StringBuilder(O.defLenForStr);

		long lowest1;
		do
			if ((lowest1 = (-b64As2Pow & b64As2Pow)) == b64As2Pow)

				return ret.append(sAry[log2(lowest1)]);
			else
				ret.append(sAry[log2(lowest1)]).append(O.C44);

		while ((b64As2Pow = (~lowest1 & b64As2Pow)) != 0b0L);

		throw new IllegalArgumentException("b64As2Pow=" + str(b64As2Pow));

	}
}
