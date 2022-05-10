package lgpl3.prime64;

import java.math.BigInteger;

import lgpl3.o.O;

/**
 * 本類別區間計算娃, 計算出每一次要找質數的區間有多長.<br/>
 * To calculate the range (a number) for mine prime program.
 *
 * @version 2015/02/22_20:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ranger" >Ranger.java</a>
 *
 */
public abstract class Ranger extends Ranger_A {

	// private static final Class<?> THIS = Ranger.class;

	/**
	 * 檢查是否超出界限.<br/>
	 * To check if it is between.
	 */
	public static void checkBetween(long from, long to, long originFrom, long originTo) {

		if (!(from <= to) || !(originFrom <= originTo))
			O.x();

		if (!(originFrom <= from) || !(to <= originTo))
			O.x();

	}

	/**
	 * 檢查是否超出界限.<br/>
	 * To check if it is between.
	 */
	public static void checkBetween(long num, long originFrom, long originTo) {

		if (!(originFrom <= originTo))
			O.x("originFrom=" + originFrom + ", originTo=" + originTo);

		if (!(originFrom <= num) || !(num <= originTo))
			O.x("num=" + num + ", originFrom=" + originFrom + ", originTo=" + originTo);

	}

	/**
	 * 運算並檢查是否超出界限 (Fr64).<br/>
	 * To calculate and to check if out of bound.
	 */
	public static long calculateNCheckOutOfBound(long n1, long n2, int type32) { // Fr64

		if (type32 == TYPE32_ADD) {

			if ((n1 += n2) >= 0)
				return n1;

			throw new ArithmeticException(n1 + O.S32 + O.S43 + O.S32 + n2 + " out of bound");

		}

		if (type32 == TYPE32_MUL) {

			if (n1 <= $SQRT_OF_2POW63_MINUS1 && n2 <= $SQRT_OF_2POW63_MINUS1)
				return n1 * n2;

			else {

				BigInteger big1 = BigInteger.valueOf(n1);
				BigInteger big2 = BigInteger.valueOf(n2);

				long prod = big1.multiply(big2).longValue();

				if (prod == n1 * n2)
					return prod;

				throw new ArithmeticException(n1 + O.S32 + O.S42 + O.S32 + n2 + " out of bound");

			}
		}

		throw new ArithmeticException("Fr64 out of bound");

	}

	/**
	 * 計算出已經找到的質數的比例.<br/>
	 * To calculate the percent.
	 */
	public static int calcuPct(long curN, long n1, long n2MinusN1) {

		// if (n2MinusN1 == 0) return 99;

		int pct = (int) (((curN - n1) * $100_INT32) / n2MinusN1);

		return ((pct < $100_INT32) ? pct : 99);

	}

	/**
	 * 計算出已經找到的質數的比例.<br/>
	 * To calculate the percent.
	 */
	public static int calcuPct(long curN, long tailN) {

		int pct = (int) ((curN * $100_INT32) / tailN);

		return ((pct < $100_INT32) ? pct : 99);

	}
}
