package lgpl3.prime64;

import lgpl3.o.B;

/**
 * @version 2020/12/26_14:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Miner_D" >Miner_D.java</a>
 *
 * @see Miner_J
 */
public abstract class Miner_D extends Miner_A {

	// private static final Class<?> THIS = Miner_D.class;

	/**
	 * 根據內建 oriAryOfP 檢驗此奇數 (大於等於 5) 是否為質數.<br/>
	 * To test if the natOddN (great than or equal to 5) is a prime by the inside oriAryOfP.
	 *
	 * @see #testPrime(long)
	 */
	public static boolean testPrime32(int natOddN32) {

		int div32 = 3;

		int idx = 2; // important, oriAryOfP[2]==5L
		final int sqrt32 = (int) StrictMath.sqrt(natOddN32);

		do {

			if (natOddN32 % div32 == 0)
				return B.O;

		} while ((div32 = (int) oriAryOfP[idx++]) <= sqrt32);

		return B.I;

	}

	/**
	 * 根據內建 oriAryOfP 檢驗此奇數 (大於等於 17) 是否為質數.<br/>
	 * To test if the natOddN (great than or equal to 17) is a prime by the inside oriAryOfP.
	 *
	 * @see #testPrimeFromDiv17(long)
	 */
	public static boolean testPrime32FromDiv17(int natOddN32) {

		int div32 = 17;

		int idx = 7; // important

		// O.lD("P 7=" + oriAryOfP[idx], THIS);

		final int sqrt32 = (int) StrictMath.sqrt(natOddN32);

		do {

			if ((natOddN32 % div32) == 0)
				return B.O;

		} while ((div32 = (int) oriAryOfP[idx++]) <= sqrt32);

		return B.I;

	}

	/**
	 * 根據內建 oriAryOfP 檢驗此奇數 (大於等於 5) 是否為質數.<br/>
	 * To test if the natOddN (great than or equal to 5) is a prime by the inside oriAryOfP.
	 *
	 * @see #testPrime32(int)
	 */
	public static boolean testPrime(long natOddN) {

		long div = 3L;

		int idx = 2; // important, oriAryOfP[2]==5L
		final long sqrt = (long) StrictMath.sqrt(natOddN);

		do
			if (((int) (natOddN % div)) == 0)
				return B.O;

		while ((div = oriAryOfP[idx++]) <= sqrt);

		return B.I;

	}

	/**
	 * 根據內建 oriAryOfP 檢驗此奇數 (大於等於 17) 是否為質數.<br/>
	 * To test if the natOddN (great than or equal to 17) is a prime by the inside oriAryOfP.
	 *
	 * @see #testPrime32FromDiv17(int)
	 */
	public static boolean testPrimeFromDiv17(long natOddN) {

		long div = 17L;

		int idx = 7;
		// O.l(oriAryOfP[idx] , THIS);

		final long sqrt = (long) StrictMath.sqrt(natOddN);

		do {

			if (((int) (natOddN % div)) == 0)
				return B.O;

		} while ((div = oriAryOfP[idx++]) <= sqrt);

		return B.I;

	}
}
