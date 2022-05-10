package lgpl3.comb.b64W6;

import lgpl3.o.B;

/**
 * The first index of cell from the right hand side is 0.
 *
 * @version 2022/01/31_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=B64W6_A" >B64W6_A.java</a>
 *
 * @see B64W6_C
 */
public abstract class B64W6_A extends B64WB6CellFromR {

	// private static final Class<?> THIS = B64W6_A.class;

	/**
	 * To index of none 0 cells in a B64W6.<br/>
	 * The first index of cell from right hand side is 0.
	 */
	public static int totalVCell(long b64W6) {

		int tmp32 = ((int) b64W6);

		if ((tmp32 & MASK32) == 0b0)

			return 0;

		if ((tmp32 & MASK32_1_7TO_12) == 0b0)

			return 1;

		if ((tmp32 & MASK32_1_13TO_18) == 0b0)

			return 2;

		if ((tmp32 & MASK32_1_19TO_24) == 0b0)

			return 3;

		if ((tmp32 & MASK32_1_25TO_30) == 0b0)

			return 4;

		if ((b64W6 & MASK1_31TO_36) == 0b0L)

			return 5;

		if ((b64W6 & MASK1_37TO_42) == 0b0L)

			return 6;

		if ((b64W6 & MASK1_43TO_48) == 0b0L)

			return 7;

		if ((b64W6 & MASK1_49TO_54) == 0b0L)

			return 8;

		if ((b64W6 & MASK1_55TO_60) == 0b0L)

			return 9;

		return 10;

	}

	/**
	 * To reverse against every 6-bit cell.<br/>
	 * To reverse against every 6-bit cell.
	 */
	public static long revAmongVCell(long b64W6) {

		// if (b64W6 == 0b0L) return b64W6;

		long retB64W6 = 0b0L;

		do {
			retB64W6 |= (((int) b64W6) & MASK32);

			if ((b64W6 >>>= $6) == 0b0L) // b64 可在兩 cell 之間會有空的 cell

				return retB64W6;

			retB64W6 <<= $6;

		} while (B.I);

		// O.l("revAmongVCell=" + O.L + str24(retB64W6));

	}

	/**
	 * To reverse against every 6-bit cell.<br/>
	 * To reverse against every 6-bit cell.
	 */
	public static int revAmongVCell(int b32IntoB6) {

		int retB32IntoB6 = 0b0;

		do {
			retB32IntoB6 |= (b32IntoB6 & MASK32);

			if ((b32IntoB6 >>>= $6) == 0b0)

				return retB32IntoB6;

			retB32IntoB6 <<= $6;

		} while (B.I);

	}

//	public static int at(long b64W6, int idx) { // first index is 0
//
//		return ((int) (b64W6 >>> ($6 * idx))) & MASK32;
//	}

	/**
	 * To get the leftest none 0 value in cell of B64W6.<br/>
	 * To get the leftest none 0 value in cell of B64W6.
	 */
	public static int tailV(long b64W6) {

		// if (b64W6 == 0b0L) throw new IllegalArgumentException();

		do
			if ((b64W6 >>> $6) == 0b0L) // 1 cell

				return ((int) b64W6);

		while ((b64W6 >>>= $6) != 0b0L);

		throw new IllegalArgumentException();

	}
}
