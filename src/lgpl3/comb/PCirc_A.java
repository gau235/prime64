package lgpl3.comb;

import java.math.BigInteger;

import lgpl3.o.O;

/**
 * 環狀排列.<br/>
 * Circular permutation.
 *
 * @version 2022/06/01_16:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=PCirc_A" >PCirc_A.java</a>
 *
 * @see PCirc_Z
 */
public abstract class PCirc_A extends Pnk_Z {

	// private static final Class<?> THIS = PCirc_A.class;

	/**
	 * Circular permutation.
	 *
	 * @see Pnk#int64(int)
	 */
	public static long int64(int n) {

		// if (n < 0) O.x("n=" + n);

		if (n == 0 || n == 1 || n == 2)

			return 1L;

		if (n == 3)

			return 2L;

		if (n == 4)

			return 6L;

		if (n == 5)

			return 24L;

		if (n == 6)

			return 120L;

		if (n == 7)

			return 720L;

		if (n == 8)

			return 5_040L;

		if (n == 9)

			return 40_320L;

		if (n == 10)

			return 362_880L;

		if (n == 11)

			return 3_628_800L;

		if (n == 12)

			return 39_916_800L;

		if (n == 13)

			return 479_001_600L;

		if (n == 14)

			return 6_227_020_800L;

		if (n == 15)

			return 87_178_291_200L;

		if (n == 16)

			return 1_307_674_368_000L;

		if (n == 17)

			return 20_922_789_888_000L;

		if (n == 18)

			return 355_687_428_096_000L;

		if (n == 19)

			return 6_402_373_705_728_000L;

		if (n == 20)

			return 121_645_100_408_832_000L;

		if (n == 21)

			return 2_432_902_008_176_640_000L;

		throw new IllegalArgumentException();

	}

	/**
	 * Circular permutation.
	 *
	 * @see Pnk#bigInt(int)
	 */
	public static BigInteger bigInt(int n) {

		if (n <= 0)

			O.x("n=" + n);

		if (n == 1 || n == 2)

			return BigInteger.ONE;

		BigInteger ans = BigInteger.ONE;

		for (; --n != 1;)

			ans = ans.multiply(BigInteger.valueOf(n));

		return ans;

	}

	/**
	 * Circular permutation.<br/>
	 * P(n,k)/k
	 *
	 * @see Pnk#int64(int, int)
	 */
	public static long int64(int n, int k) {

		if (n <= 0 || k < 0 || n < k)

			O.x("n=" + n + ", k=" + k);

		if (k == 0)

			return 1L;

		long ans = 1L;
		for (int to = n - k; n > to; n--)

			ans *= n;

		return (ans / k);

	}

	/**
	 * Circular permutation.
	 *
	 * @see Pnk#bigInt(int, int)
	 */
	public static BigInteger bigInt(int n, int k) {

		if (n <= 0 || k < 0 || n < k)

			O.x("n=" + n + ", k=" + k);

		if (k == 0)

			return BigInteger.ONE;

		BigInteger ret = BigInteger.ONE;

		for (int to = n - k; n > to; n--)

			ret = ret.multiply(BigInteger.valueOf(n));

		return ret.divide(BigInteger.valueOf(k));

	}
}
