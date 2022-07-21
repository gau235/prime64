package lgpl3.prime64;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.B;

/**
 * @version 2022/04/30_13:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Miner_Y" >src</a>
 *
 * @see Miner
 */
public abstract class Miner_Y extends Miner_J {

	private static final Class<?> THIS = Miner_Y.class;

	/**
	 * 找出從 2^63 到 n (含端點) 所含質數.<br/>
	 * To mine prime from 2^63 down to n (both inclusive).
	 *
	 * @see #mineNRetAry(long, long)
	 */
	public static long[] mineFrom2Pow63DownTo(long n) {

		long tail = Ranger.$MAX_PRIME_LESS_THAN_2POW63;

		long[] ret = new long[GuessFromGauss.guessTotalPNRetInt32(n, tail)];

		boolean b4 = B.I; // !B.O as 9_223_372_036_854_775_783L mod 6 == 1

		int idx;
		for (idx = 0; tail >= n; tail -= ((b4 = !b4) ? 4 : 2))

			if (testPrime(tail))

				ret[idx++] = tail;

		// O.l(retAry, THIS);
		//////////////////////////////////////// O.delTailAll0(retAry)

		for (idx = ret.length; idx-- != 0;)

			if (ret[idx] != 0L)

				break;

		if (++idx != ret.length) // 縮短陣列

			System.arraycopy(ret, 0, (ret = new long[idx]), 0, idx);

		////////////////////////////////////////

		return ret;

	}

	/**
	 * 此兩正整數之間 (含端點) 含有質數 ?<br/>
	 * from 必須大於等於 3<br/>
	 * Is there any prime between from and to (both inclusive)?<br/>
	 * Note: The from must be greater than or equal to 3.
	 */
	public static boolean isAnyPWithin(long from, long to) {

		// Ranger.checkBetween(from, Ranger.$3, to);

		from |= 0b1; // important, 4 ~ 4 will not do

		boolean b4;
		int r;

		if ((r = (int) (from % 6)) == 1) // 6n + 1

			b4 = B.I;
		else {

			if (r == 3) // 6n + 3

				from += 2; // 6n + 5

			b4 = B.O; // 6n + 5

		}

		b4 = !b4; // important

		if (to < Ranger.$2POW31_MINUS1) {

			for (int from32 = (int) from, to32 = (int) to; from32 <= to32; from32 += ((b4 = !b4) ? 4 : 2))

				if (testPrime32(from32))

					return B.I;

		} else

			for (; from <= to; from += ((b4 = !b4) ? 4 : 2))

				if (testPrime(from))

					return B.I;

		return B.O;

	}

	/**
	 * 此兩正整數之間 (含端點 ) 含有質數 ?<br/>
	 * Is there any prime between from and to (inclusive)?
	 */
	public static boolean isAnyPFromGtMaxPInMyAryPToN(long n) {

		long from = maxPInMyAryOfP + 2L; // without checking min prime 2

		if (n <= from)

			return B.O; // pretty good

		boolean b4;
		int r;

		if ((r = ((int) (from % 6))) == 1) // 6n + 1

			b4 = B.I;
		else {

			if (r == 3) // 6n + 3

				from += 2; // 6n + 5

			b4 = B.O; // 6n + 5

		}

		b4 = !b4; // important

		if (n < Ranger.$2POW31_MINUS1) {

			for (int from32 = (int) from, n32 = (int) n; from32 <= n32; from32 += ((b4 = !b4) ? 4 : 2))

				if (testPrime32(from32))

					return B.I;

		} else

			for (; from <= n; from += ((b4 = !b4) ? 4 : 2))

				if (testPrime(from))

					return B.I;

		return B.O;

	}

	/**
	 * 對 n 做質因數分解, n 必須大於 1.<br/>
	 * To decomposite the int64.<br/>
	 * The process of expressing a number as a product of its prime factors is called prime factor decomposition.
	 */
	public static long[] decompo(long n) { // n must be > 1

		long[] ret = new long[62]; // 2^63 - 1

		int iAryOfP = 1, iRet = 0;

		for (long div = 2L, sqrt = (long) StrictMath.sqrt(n); div <= sqrt; div = myAryOfP[iAryOfP++])

			for (; n % div == 0L; sqrt = (long) StrictMath.sqrt(n /= div))

				ret[iRet++] = div;

		// O.l("n=" + n, THIS);

		if (n > 1L)

			ret[iRet++] = n;

		// O.l("iRet=" + iRet, THIS);

		if (iRet != 62) // delTailAll0

			System.arraycopy(ret, 0, (ret = new long[iRet]), 0, iRet); // 用同一個陣列做 copy, 帥氣

		return ret;

	}

	/**
	 * 對 n 做質因數分解, n 必須大於 1<br/>
	 * To decomposite the int64<br/>
	 * The process of expressing a number as a product of its prime factors is called prime factor decomposition.
	 */
	public static long easyDecompo(long n) { // n must be > 1 // 原創

		int idx = 1;

		for (long div = 2L, sqrt = (long) StrictMath.sqrt(n); div <= sqrt; div = myAryOfP[idx++])

			if (n % div == 0L)

				return div;

		return n;

	}

	/**
	 * 對 n 階乘做質因數分解, n 必須大於 1.<br/>
	 * To decomposite the n!
	 */
	public static long easyDecompoFactorial(int n) { // 原創

		int idx = 0, myP = (int) myAryOfP[idx], p, count = 0;

		long ret = 0b0L;
		for (; myP <= n; myP = (int) myAryOfP[++idx], ret = ((ret << B64W6.$6) | count), count = 0)

			for (p = myP; p <= n; p *= myP)

				count += (n / p);

		return ret;

	}
}
