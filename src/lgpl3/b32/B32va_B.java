package lgpl3.b32;

/**
 * @version 2021/02/06_18:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=B32va_B" >B32va_B.java</a>
 *
 * @see B32va_V
 */
public abstract class B32va_B extends B32va_A {

	// private static final Class<?> THIS = B32va_B.class;

	/**
	 * highest1.<br/>
	 * highest1.
	 *
	 * @see Integer#highestOneBit(int)
	 */
	public static int highest1(int positiveB32) {

		// if (positiveB32 == 0b0) return 0b0;
		// int old32 = positiveB32;

		int nOfLeading0 = 31;

		if (positiveB32 >= $2POW16) {

			nOfLeading0 -= 16;
			positiveB32 >>>= 16;

		}

		if (positiveB32 >= $2POW8) {

			nOfLeading0 -= 8;
			positiveB32 >>>= 8;

		}

		if (positiveB32 >= $2POW4) {

			nOfLeading0 -= 4;
			positiveB32 >>>= 4;

		}

		if (positiveB32 >= $2POW2) {

			nOfLeading0 -= 2;
			positiveB32 >>>= 2;

		}

		// int aaa = old32 & ($_2POW31 >>> (nOfLeading0 - (positiveB32 >>> 1)));
		// int bbb = $_2POW31 >>> (nOfLeading0 - (positiveB32 >>> 1));

		// O.eqX(aaa, bbb);

		return (Integer.MIN_VALUE >>> (nOfLeading0 - (positiveB32 >>> 1)));

	}

	/**
	 * To count.<br/>
	 * To count.
	 */
	public static int countOf1(int b32) {

		// Integer.bitCount()
		// Long.bitCount()

		// int32 = int32 - ((int32 >>> 1) & 0b0101_0101_0101_0101);
		// int32 = (int32 & 0b0011_0011_0011_0011) + ((int32 >>> 2) & 0b0011_0011_0011_0011);
		// int32 = (int32 + (int32 >>> 4)) & 0b0000_1111_0000_1111;
		// int32 = int32 + (int32 >>> 8);
		// int32 = int32 + (int32 >>> 16);
		// int32 &= 0b0000_0000_0011_1111;

		int count = 0;

		do {
			if ((b32 & 0b0000_0001) != 0b0)

				count++;

			if ((b32 & 0b0000_0010) != 0b0)

				count++;

			if ((b32 & 0b0000_0100) != 0b0)

				count++;

			if ((b32 & 0b0000_1000) != 0b0)

				count++;

			if ((b32 & 0b0001_0000) != 0b0)

				count++;

			if ((b32 & 0b0010_0000) != 0b0)

				count++;

			if ((b32 & 0b0100_0000) != 0b0)

				count++;

			if ((b32 & 0b1000_0000) != 0b0)

				count++;

		} while ((b32 >>>= 8) != 0b0);

		return count;

	}

	/**
	 * 以 2 為底取 log.<br/>
	 * To log with base 2.
	 *
	 * @see Integer#numberOfLeadingZeros(int)
	 */
	public static int biLog2(int positiveB32) {

		int nOfLeading0 = 31;

		if (positiveB32 >= $2POW16) {

			nOfLeading0 -= 16;
			positiveB32 >>>= 16;

		}

		if (positiveB32 >= $2POW8) {

			nOfLeading0 -= 8;
			positiveB32 >>>= 8;

		}

		if (positiveB32 >= $2POW4) {

			nOfLeading0 -= 4;
			positiveB32 >>>= 4;

		}

		if (positiveB32 >= $2POW2) {

			nOfLeading0 -= 2;
			positiveB32 >>>= 2;

		}

		// O.l("nOfLeading0=" + nOfLeading0 , THIS);
		// return (nOfLeading0 - (positiveB32 >>> 1));

		return 31 - (nOfLeading0 - (positiveB32 >>> 1));

	}

	/**
	 * 以 2 為底取 log.<br/>
	 * To log with base 2.
	 */
	public static int biLog2NPlus1(int positiveB32) {

		int nOfLeading0 = 31;

		if (positiveB32 >= $2POW16) {

			nOfLeading0 -= 16;
			positiveB32 >>>= 16;

		}

		if (positiveB32 >= $2POW8) {

			nOfLeading0 -= 8;
			positiveB32 >>>= 8;

		}

		if (positiveB32 >= $2POW4) {

			nOfLeading0 -= 4;
			positiveB32 >>>= 4;

		}

		if (positiveB32 >= $2POW2) {

			nOfLeading0 -= 2;
			positiveB32 >>>= 2;

		}

		return 32 - (nOfLeading0 - (positiveB32 >>> 1));

	}

	/**
	 * next bit.<br/>
	 * next bit.
	 */
	public static int next1BitL(int baseB32, int curBit) {

		// ex: baseB32=101010
		// ex: curBit=000010
		// => curBit=000100 (左移) => curBit=111100 // 對數字 2 的 n 次方取負號, 恰好是在其左邊位元全都補 1
		// => 111100 & baseB32 => 把 baseB32 右半部遮蔽
		// => 101000

		// 最後取 lowest1

		curBit = (-(curBit << 1) & baseB32);

		return (-curBit & curBit); // lowest1

	}
}
