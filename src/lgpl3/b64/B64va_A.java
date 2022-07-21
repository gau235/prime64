package lgpl3.b64;

/**
 * @version 2020/04/15_12:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=B64va_A" >B64va_A.java</a>
 *
 * @see B64va_L
 */
public abstract class B64va_A {

	// private static final Class<?> THIS = B64va_A.class;

	/**
	 * The String.<br/>
	 * The String.
	 */
	public static final String S_64BIT_$0_W_UNDERLINE = "0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000";

	/**
	 * The String.<br/>
	 * The String.
	 */
	public static final String S_64BIT_$1_W_UNDERLINE = "0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0001";

//	/**
//	 * Not as toB32As2PowByAryOfB32As2Pow.<br/>
//	 * Not as toB32As2PowByAryOfB32As2Pow.
//	 */
//	public static long toB64As2PowByAry32(int[] ary32) {
//
//		long b64As2Pow = 0b0L;
//		long tmp;
//
//		for (int idx = 0; idx != ary32.length; idx++) {
//
//			tmp = 0b1L << (ary32[idx] - 1);
//			b64As2Pow |= tmp;
//
//		}
//
//		return b64As2Pow;
//
//	}

	/**
	 * To count.<br/>
	 * To count.
	 */
	public static int countOf1(long b64) {

		int b8, count = 0;
		do {

			b8 = ((int) b64);

			if ((b8 & 0b0000_0001) != 0b0)
				count++;

			if ((b8 & 0b0000_0010) != 0b0)
				count++;

			if ((b8 & 0b0000_0100) != 0b0)
				count++;

			if ((b8 & 0b0000_1000) != 0b0)
				count++;

			if ((b8 & 0b0001_0000) != 0b0)
				count++;

			if ((b8 & 0b0010_0000) != 0b0)
				count++;

			if ((b8 & 0b0100_0000) != 0b0)
				count++;

			if ((b8 & 0b1000_0000) != 0b0)
				count++;

		} while ((b64 >>>= 8) != 0b0L);

		return count;

	}

	/**
	 * next bit.<br/>
	 * next bit.
	 */
	public static long next1BitL(long baseB64, long curBit) {

		// ex: baseB32=101010
		// ex: curBit =000010
		// => curBit=000100 (左移) => -curBit=111100 ( 對數字 2 的 n 次方取負號, 恰好是前面位元補 1)
		// => 111100 & baseB32 => 把 baseB32 右半部遮蔽 (也遮蔽 curBit)
		// => new baseB32 = 101000

		// 最後取 lowest1

		curBit = (-(curBit << 1) & baseB64);

		return (-curBit & curBit); // lowest1

	}
}
