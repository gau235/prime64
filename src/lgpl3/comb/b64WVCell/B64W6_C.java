package lgpl3.comb.b64WVCell;

import lgpl3.o.B;

/**
 * The first index of cell from the right hand side is 0.
 *
 * @version 2021/03/15_12:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=B64W6_C" >B64W6_C.java</a>
 *
 * @see B64W6_D
 */
public abstract class B64W6_C extends B64W6_A {

	// private static final Class<?> THIS = B64W6_C.class;

	/**
	 * To swap the value in the cells.<br/>
	 * To swap the value in the cells.
	 */
	public static long swapVCell(long b64W6, int idx1, int idx2) {

		int v1 = ((int) (b64W6 >>> ($6 * idx1))) & MASK32; // at(b64W6, idx1);
		int v2 = ((int) (b64W6 >>> ($6 * idx2))) & MASK32; // at(b64W6, idx2);

		// b64W6 = pasteAt(b64W6, idx1, v2);
		if (idx1 == 0)

			b64W6 = (b64W6 & MASK32_0) | v2; // clear cell first

		else if (idx1 == 1)

			b64W6 = (b64W6 & MASK32_0_7TO_12) | (v2 << 6); // clear cell first

		else if (idx1 == 2)

			b64W6 = (b64W6 & MASK32_0_13TO_18) | (v2 << 12); // clear cell first

		else if (idx1 == 3)

			b64W6 = (b64W6 & MASK32_0_19TO_24) | (v2 << 18); // clear cell first

		else if (idx1 == 4)

			b64W6 = (b64W6 & MASK32_0_25TO_30) | (v2 << 24); // clear cell first

		else if (idx1 == 5)

			b64W6 = (b64W6 & MASK0_31TO_36) | ((long) v2 << 30); // clear cell first

		else if (idx1 == 6)

			b64W6 = (b64W6 & MASK0_37TO_42) | ((long) v2 << 36); // clear cell first

		else if (idx1 == 7)

			b64W6 = (b64W6 & MASK0_43TO_48) | ((long) v2 << 42); // clear cell first

		else if (idx1 == 8)

			b64W6 = (b64W6 & MASK0_49TO_54) | ((long) v2 << 48); // clear cell first

		else // if (idx1 == 9)

			b64W6 = (b64W6 & MASK0_55TO_60) | ((long) v2 << 54);

		/////////////////////////////////////////////////////////////////

		// pasteAt(b64W6, idx2, v1);

		if (idx2 == 0)

			return (b64W6 & MASK32_0) | v1; // clear cell first

		if (idx2 == 1)

			return (b64W6 & MASK32_0_7TO_12) | (v1 << 6); // clear cell first

		if (idx2 == 2)

			return (b64W6 & MASK32_0_13TO_18) | (v1 << 12); // clear cell first

		if (idx2 == 3)

			return (b64W6 & MASK32_0_19TO_24) | (v1 << 18); // clear cell first

		if (idx2 == 4)

			return (b64W6 & MASK32_0_25TO_30) | (v1 << 24); // clear cell first

		if (idx2 == 5)

			return (b64W6 & MASK0_31TO_36) | ((long) v1 << 30); // clear cell first

		if (idx2 == 6)

			return (b64W6 & MASK0_37TO_42) | ((long) v1 << 36); // clear cell first

		if (idx2 == 7)

			return (b64W6 & MASK0_43TO_48) | ((long) v1 << 42); // clear cell first

		if (idx2 == 8)

			return (b64W6 & MASK0_49TO_54) | ((long) v1 << 48); // clear cell first

		// if (idx2 == 9)
		return (b64W6 & MASK0_55TO_60) | ((long) v1 << 54);

	}

	///////////////////////////////////////////////////////////////////////

	/**
	 * To get min.<br/>
	 * To get min.
	 */
	public static int getMin(long b64W6) {

		int min = $MAX_INT32_IN_CELL, vCell;
		do
			if ((vCell = (((int) b64W6) & MASK32)) < min)

				min = vCell; // O.l("val=" + val + O.S9 + THIS);

		while ((b64W6 >>>= $6) != 0b0L);

		return min;

	}

	/**
	 * To get max.<br/>
	 * To get max.
	 */
	public static int getMax(long b64W6) {

		int max = 1, vCell;
		do
			if ((vCell = (((int) b64W6) & MASK32)) > max)

				max = vCell; // O.l("val=" + val + O.S9 + THIS);

		while ((b64W6 >>>= $6) != 0b0L);

		return max;

	}

	/**
	 * To replace the cell at index of B64W6.<br/>
	 * To replace the cell at index of B64W6.
	 */
	public static long pasteAt(long b64W6, int idx, int v32) { // first index is 0

		if (idx == 0)

			return (b64W6 & MASK32_0) | v32; // clear cell first

		if (idx == 1)

			return (b64W6 & MASK32_0_7TO_12) | (v32 << 6); // clear cell first

		if (idx == 2)

			return (b64W6 & MASK32_0_13TO_18) | (v32 << 12); // clear cell first

		if (idx == 3)

			return (b64W6 & MASK32_0_19TO_24) | (v32 << 18); // clear cell first

		if (idx == 4)

			return (b64W6 & MASK32_0_25TO_30) | (v32 << 24); // clear cell first

		if (idx == 5)

			return (b64W6 & MASK0_31TO_36) | ((long) v32 << 30); // clear cell first

		if (idx == 6)

			return (b64W6 & MASK0_37TO_42) | ((long) v32 << 36); // clear cell first

		if (idx == 7)

			return (b64W6 & MASK0_43TO_48) | ((long) v32 << 42); // clear cell first

		if (idx == 8)

			return (b64W6 & MASK0_49TO_54) | ((long) v32 << 48); // clear cell first

		// if (idx == 9)
		return (b64W6 & MASK0_55TO_60) | ((long) v32 << 54);

	}

	/**
	 * To plus.<br/>
	 * To plus.
	 */
	public static long plusAt(long b64W6, int idx, int v32) {

		idx *= $6;

		v32 = (((int) (b64W6 >>> idx)) & MASK32) + v32;

		// O.l("v32=" + (((int) (b64W6 >>> idx)) & MASK32));
		// O.l("v32=" + v32);

		return (b64W6 & ~(MASK1_1TO_6 << idx)) | (((long) v32) << idx);

	}

	/**
	 * To plus all VCell with v32.<br/>
	 * To plus all VCell with v32.
	 */
	public static long plusAllWV32(long b64W6, int v32) {

		long retB64W6 = 0b0L;

		do {
			retB64W6 |= (((int) b64W6) & MASK32) + v32;

			if ((b64W6 >>>= $6) == 0b0L)

				break;

			retB64W6 <<= $6;

		} while (B.I);

		b64W6 = retB64W6;
		retB64W6 = 0b0L;

		// revAmongVCell
		do {
			retB64W6 |= (((int) b64W6) & MASK32);

			if ((b64W6 >>>= $6) == 0b0L)

				return retB64W6;

			retB64W6 <<= $6;

		} while (B.I);

	}

	/**
	 * To plus all VCell with v32.<br/>
	 * To plus all VCell with v32.
	 */
	public static long plusAllWV32NRev(long b64W6, int v32) {

		long retB64W6 = 0b0L;

		do {
			retB64W6 |= ((((int) b64W6) & MASK32) + v32);

			if (((int) (b64W6 >>>= $6)) == 0b0)

				return retB64W6;

			retB64W6 <<= $6;

		} while (B.I);

	}
}
