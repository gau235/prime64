package lgpl3.comb.b64W6;

import lgpl3.b32.B32va;
import lgpl3.o.B;

/**
 * The first index of cell from the right hand side is 0.
 *
 * @version 2021/02/05_22:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=B64W6_G" >B64W6_G.java</a>
 *
 * @see B64W6_J
 */
public abstract class B64W6_G extends B64W6_D {

	// private static final Class<?> THIS = B64W6_G.class;

	/**
	 * To convert.<br/>
	 * To convert.
	 *
	 * @see #toB32As2PowByB6Cell(long)
	 */
	public static int[] toAry32OfB32As2Pow(long b64W6) {

		int[] retAry32OfB32As2Pow = new int[totalVCell(b64W6)];
		int idx = 0;

		do
			retAry32OfB32As2Pow[idx++] = (0b1 << ((((int) b64W6) & MASK32) - 1)); // minus 1

		while (((int) (b64W6 >>>= $6)) != 0b0); // b64W6 不會在兩 cell 之間有空的 cell

		return retAry32OfB32As2Pow;

	}

	/**
	 * To convert.<br/>
	 * To convert.
	 *
	 * @see #toB64As2PowByB6Cell(long)
	 */
	public static long toB64W6ByLog2NPlus1(int b32As2Pow) {

		long retB64W6 = 0b0L;

		int lowest1;
		do
			retB64W6 = (retB64W6 << $6) | B32va.log2NPlus1(lowest1 = (-b32As2Pow & b32As2Pow));

		while ((b32As2Pow = (~lowest1 & b32As2Pow)) != 0b0);

		return revAmongVCell(retB64W6); // todo: improve revAmongVCell

	}

	/**
	 * To convert.<br/>
	 * To convert.
	 *
	 * @see #toB64As2PowByB6Cell(long)
	 */
	public static long toDescB64W6ByLog2NPlus1(int b32As2Pow) {

		long retB64W6 = 0b0L;

		int lowest1;
		do
			retB64W6 = (retB64W6 << $6) | B32va.log2NPlus1(lowest1 = (-b32As2Pow & b32As2Pow));

		while ((b32As2Pow = (~lowest1 & b32As2Pow)) != 0b0L);

		return retB64W6;

	}

	/**
	 * To convert.<br/>
	 * To convert.
	 *
	 * @see #toB64As2PowByB6Cell(long)
	 */
	public static int toB32As2PowByB6Cell(long b64W6) {

		// if (b64W6 == 0b0L) // while toB32As2PowByB6Cell(prefix); b64W6 can be 0
		// return 0b0;

		int retB32As2Pow = 0b0;

		do
			retB32As2Pow |= (0b1 << ((((int) b64W6) & MASK32) - 1));

		while (((int) (b64W6 >>>= $6)) != 0b0); // b64W6 不會在兩 cell 之間有空的 cell

		return retB32As2Pow;

	}

	/**
	 * To convert.<br/>
	 * To convert.
	 *
	 * @see #toDescB64W6ByLog2NPlus1(int)
	 */
	public static long toB64As2PowByB6Cell(long b64W6) { // b64W6 can be 0

		if (b64W6 == 0b0L)
			return 0b0L;

		long retB64As2Pow = 0b0L;

		do
			retB64As2Pow = retB64As2Pow | (0b1L << ((((int) b64W6) & MASK32) - 1)); // todo: 先 sort 後, 大的去聯集小的

		while (((int) (b64W6 >>>= $6)) != 0b0); // b64W6 不會在兩 cell 之間有空的 cell

		return retB64As2Pow;

	}

	/**
	 * baseB32 filter the new32 as b64W6 to b32.<br/>
	 * baseB32 filter the new32 as b64W6 to b32.
	 */
	public static int filterAftToB32As2PowByB6Cell(int baseB32, long b64W6) {

		int b32As2Pow = 0b0;

		do
			b32As2Pow |= (0b1 << ((((int) b64W6) & MASK32) - 1));

		while (((int) (b64W6 >>>= $6)) != 0b0); // b64W6 不會在兩 cell 之間有空的 cell

		return (~b32As2Pow & baseB32);

	}

	/**
	 * To asc.<br/>
	 * To asc.
	 */
	public static long ascToN(int n) {

		long retB64 = 0b0L;

		do {
			retB64 |= n;

			if (--n == 0b0)
				return retB64;

			retB64 <<= $6;

		} while (B.I);

	}

	/**
	 * To desc.<br/>
	 * To desc.
	 */
	public static long descTo1(int n) {

		long retB64 = 0b0L;

		int i = 1;
		do {
			retB64 |= i;

			if (i++ == n)
				return retB64;

			retB64 <<= $6;

		} while (B.I);

	}
}
