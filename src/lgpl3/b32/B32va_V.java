package lgpl3.b32;

import lgpl3.b64.B64va;

/**
 * @version 2020/04/15_12:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=B32va_V" >src</a>
 *
 * @see B32va
 */
public abstract class B32va_V extends B32va_B {

	// private static final Class<?> THIS = B32va_V.class;

	/**
	 * 以 2 為底取 log.<br/>
	 * To log with base 2.
	 *
	 * @see #log2NPlus1(int)
	 *
	 * @see B64va#log2(long)
	 *
	 * @see B64va#log2NPlus1(long)
	 */
	public static int log2(int b32As2Pow) {

		if (b32As2Pow == 0b1)

			return 0;

		if (b32As2Pow == 0b10)

			return 1;

		if (b32As2Pow == 0b100)

			return 2;

		if (b32As2Pow == 0b1000)

			return 3;

		if (b32As2Pow == 0b1_0000)

			return 4;

		if (b32As2Pow == 0b10_0000)

			return 5;

		if (b32As2Pow == 0b100_0000)

			return 6;

		if (b32As2Pow == 0b1000_0000)

			return 7;

		if (b32As2Pow == 0b1_0000_0000)

			return 8;

		if (b32As2Pow == 0b10_0000_0000)

			return 9;

		if (b32As2Pow == 0b100_0000_0000)

			return 10;

		if (b32As2Pow == 0b1000_0000_0000)

			return 11;

		if (b32As2Pow == 0b1_0000_0000_0000)

			return 12;

		if (b32As2Pow == 0b10_0000_0000_0000)

			return 13;

		if (b32As2Pow == 0b100_0000_0000_0000)

			return 14;

		if (b32As2Pow == 0b1000_0000_0000_0000)

			return 15;

		if (b32As2Pow == 0b1_0000_0000_0000_0000)

			return 16;

		if (b32As2Pow == 0b10_0000_0000_0000_0000)

			return 17;

		if (b32As2Pow == 0b100_0000_0000_0000_0000)

			return 18;

		if (b32As2Pow == 0b1000_0000_0000_0000_0000)

			return 19;

		if (b32As2Pow == 0b1_0000_0000_0000_0000_0000)

			return 20;

		if (b32As2Pow == 0b10_0000_0000_0000_0000_0000)

			return 21;

		if (b32As2Pow == 0b100_0000_0000_0000_0000_0000)

			return 22;

		if (b32As2Pow == 0b1000_0000_0000_0000_0000_0000)

			return 23;

		if (b32As2Pow == 0b1_0000_0000_0000_0000_0000_0000)

			return 24;

		if (b32As2Pow == 0b10_0000_0000_0000_0000_0000_0000)

			return 25;

		if (b32As2Pow == 0b100_0000_0000_0000_0000_0000_0000)

			return 26;

		if (b32As2Pow == 0b1000_0000_0000_0000_0000_0000_0000)

			return 27;

		if (b32As2Pow == 0b1_0000_0000_0000_0000_0000_0000_0000)

			return 28;

		if (b32As2Pow == 0b10_0000_0000_0000_0000_0000_0000_0000)

			return 29;

		if (b32As2Pow == 0b100_0000_0000_0000_0000_0000_0000_0000)

			return 30;

		// if (b32As2Pow == 0b1000_0000_0000_0000_0000_0000_0000_0000) return 31;

		throw new IllegalArgumentException("b32As2Pow=" + b32As2Pow);

	}

	/**
	 * 以 2 為底取 log.<br/>
	 * To log with base 2.
	 *
	 * @see #log2(int)
	 *
	 * @see B64va#log2(long)
	 *
	 * @see B64va#log2NPlus1(long)
	 */
	public static int log2NPlus1(int b32As2Pow) {

		if (b32As2Pow == 0b1)
			return 1;

		if (b32As2Pow == 0b10)
			return 2;

		if (b32As2Pow == 0b100)
			return 3;

		if (b32As2Pow == 0b1000)
			return 4;

		if (b32As2Pow == 0b1_0000)
			return 5;

		if (b32As2Pow == 0b10_0000)
			return 6;

		if (b32As2Pow == 0b100_0000)
			return 7;

		if (b32As2Pow == 0b1000_0000)
			return 8;

		if (b32As2Pow == 0b1_0000_0000)
			return 9;

		if (b32As2Pow == 0b10_0000_0000)
			return 10;

		if (b32As2Pow == 0b100_0000_0000)
			return 11;

		if (b32As2Pow == 0b1000_0000_0000)
			return 12;

		if (b32As2Pow == 0b1_0000_0000_0000)
			return 13;

		if (b32As2Pow == 0b10_0000_0000_0000)
			return 14;

		if (b32As2Pow == 0b100_0000_0000_0000)
			return 15;

		if (b32As2Pow == 0b1000_0000_0000_0000)
			return 16;

		if (b32As2Pow == 0b1_0000_0000_0000_0000)
			return 17;

		if (b32As2Pow == 0b10_0000_0000_0000_0000)
			return 18;

		if (b32As2Pow == 0b100_0000_0000_0000_0000)
			return 19;

		if (b32As2Pow == 0b1000_0000_0000_0000_0000)
			return 20;

		if (b32As2Pow == 0b1_0000_0000_0000_0000_0000)
			return 21;

		if (b32As2Pow == 0b10_0000_0000_0000_0000_0000)
			return 22;

		if (b32As2Pow == 0b100_0000_0000_0000_0000_0000)
			return 23;

		if (b32As2Pow == 0b1000_0000_0000_0000_0000_0000)
			return 24;

		if (b32As2Pow == 0b1_0000_0000_0000_0000_0000_0000)
			return 25;

		if (b32As2Pow == 0b10_0000_0000_0000_0000_0000_0000)
			return 26;

		if (b32As2Pow == 0b100_0000_0000_0000_0000_0000_0000)
			return 27;

		if (b32As2Pow == 0b1000_0000_0000_0000_0000_0000_0000)
			return 28;

		if (b32As2Pow == 0b1_0000_0000_0000_0000_0000_0000_0000)
			return 29;

		if (b32As2Pow == 0b10_0000_0000_0000_0000_0000_0000_0000)
			return 30;

		if (b32As2Pow == 0b100_0000_0000_0000_0000_0000_0000_0000)
			return 31;

		// if (b32As2Pow == 0b1000_0000_0000_0000_0000_0000_0000_0000) return 32;

		throw new IllegalArgumentException("b32As2Pow=" + b32As2Pow);

	}
}
