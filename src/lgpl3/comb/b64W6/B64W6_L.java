package lgpl3.comb.b64W6;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * The first index of cell from the right hand side is 0.
 *
 * @version 2022/04/16_22:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=B64W6_L" >B64W6_L.java</a>
 *
 * @see B64W6
 */
public abstract class B64W6_L extends B64W6_J { // B64W6 預設轉字串會先 rev

	// private static final Class<?> THIS = B64W6_L.class;

	/**
	 * To string by B64W6.<br/>
	 * 0b0000_000001_000100_000100_001000 as 1,4,4,8
	 */
	public static StringBuilder strByVCellAftRev(long b64W6) {

		StringBuilder ret = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		b64W6 = revAmongVCell(b64W6);

		do {
			ret.append(((int) b64W6) & MASK32);

			if (((int) (b64W6 >>>= $6)) == 0b0)

				return ret;

			ret.append(O.C44);

		} while (B.I);

	}

	/**
	 * To string by B64W6.<br/>
	 * 0b0000_000001_000100_000100_001000 as 1,4,4,8
	 */
	public static StringBuilder strByVCell(long b64W6) {

		StringBuilder ret = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		do {
			ret.append(((int) b64W6) & MASK32);

			if (((int) (b64W6 >>>= $6)) == 0b0)

				return ret;

			ret.append(O.C44);

		} while (B.I);

	}

	/**
	 * To string by B64W6.<br/>
	 * To string by B64W6.
	 */
	public static StringBuilder strByVCellMinus1AftRevBySAry(long b64W6, String[] sAry) {

		StringBuilder ret = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		// if (b64W6 == 0b0L) return ret;

		b64W6 = revAmongVCell(b64W6);

		do {
			ret.append(sAry[(((int) b64W6) & MASK32) - 1]);

			if (((int) (b64W6 >>>= $6)) == 0b0)

				return ret;

			ret.append(O.C44);

		} while (B.I);

	}

	/**
	 * To string by B64W6.<br/>
	 * To string by B64W6.
	 */
	public static StringBuilder strByVCellMinus1BySAry(long b64W6, String[] sAry) {

		StringBuilder ret = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		do {
			ret.append(sAry[(((int) b64W6) & MASK32) - 1]);

			if (((int) (b64W6 >>>= $6)) == 0b0)

				return ret;

			ret.append(O.C44);

		} while (B.I);

	}
}
