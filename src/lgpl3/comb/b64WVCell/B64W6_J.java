package lgpl3.comb.b64WVCell;

import lgpl3.o.O;

/**
 * The first index of cell from the right hand side is 0.
 *
 * @version 2020/12/31_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=B64W6_J" >B64W6_J.java</a>
 *
 * @see B64W6_L
 */
public abstract class B64W6_J extends B64W6_G {

	// private static final Class<?> THIS = B64W6_J.class;

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public static StringBuilder str24(long int64) {

		// int64 &= $HEAD4_0_OF_64BIT;

		int len = 27, idx = len, iUnder = 0;

		char[] charAry = new char[len];

		while (idx-- != 0)

			charAry[idx] = O.C48;

		idx = len - 1;

		do {
			if ((((int) int64) & 0b1) != 0b0)

				charAry[idx] = O.C49;

			if (++iUnder == 6 || iUnder == 12 || iUnder == 18)

				charAry[--idx] = O.C95;

			// O.l("iUnder=" + iUnder, THIS);

			int64 >>>= 1;

		} while (idx-- != 0);

		return new StringBuilder(len).append(charAry);

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public static StringBuilder str(long int64) {

		// int64 &= $HEAD4_0_OF_64BIT; // O.l("int64=" + int64 , THIS);

		int len = 74, idx = len, iUnder = 0;

		char[] charAry = new char[len];

		while (idx-- != 0)

			charAry[idx] = O.C48;

		idx = len - 1;

		do {
			if ((((int) int64) & 0b1) != 0b0)

				charAry[idx] = O.C49;

			if (++iUnder == 6 || iUnder == 12 || iUnder == 18 || iUnder == 24 || iUnder == 30 || iUnder == 36 || iUnder == 42

					|| iUnder == 48 || iUnder == 54 || iUnder == 60)

				charAry[--idx] = O.C95;

			// O.l("iUnder=" + iUnder, THIS);

			int64 >>>= 1;

		} while (idx-- != 0);

		return new StringBuilder(len).append(charAry);

	}
}
