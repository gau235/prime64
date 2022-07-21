package lgpl3.prime64;

/**
 * 學數學家高斯猜輸入兩正整數之間所有質數數目.<br/>
 * To return guessed number of primes between two input numbers, basing on Gauss's Guess.
 *
 * @version 2022/03/21_20:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=GuessFromGauss" >GuessFromGauss.java</a>
 *
 */
public abstract class GuessFromGauss {

	private static final Class<?> THIS = GuessFromGauss.class;

	public static final float $F32_TO_FIX_TOTAL_P = 169F;

	/**
	 * The bound of guess.<br/>
	 * The bound of guess.
	 */
	public static final int $BOUND32_FOR_N2_TO_GUESS_TOTAL_P = 8_000_000;

	/**
	 * 學數學家高斯猜輸入兩正整數之間所有質數數目.<br/>
	 * To return guessed number of primes between two input numbers.
	 *
	 * @see #range32ToMinePrime(long)
	 */
	public static int guessTotalPNRetInt32(long n1, long n2) {

		if (n2 <= $BOUND32_FOR_N2_TO_GUESS_TOTAL_P)

			return (int) (((n2 - n1) >>> 2) + 4);

		float f32N1 = n1, f32N2 = n2;

		float n1DivLogN1 = f32N1 / (float) StrictMath.log1p(f32N1);
		float n2DivLogN2 = f32N2 / (float) StrictMath.log(f32N2);

		float log_N2PlusN1_MulLogN2 = (float) StrictMath.log(f32N2 + f32N1) * (float) StrictMath.log(f32N2);

		float nOfPrime = n2DivLogN2 - n1DivLogN1 + ((f32N2 - f32N1) / log_N2PlusN1_MulLogN2) + $F32_TO_FIX_TOTAL_P;

		// O.l("n1=" + n1 + " n2=" + n2 + " guess=" + (long) nOfPrime, THIS);

		return (int) nOfPrime;

	}

	/**
	 * 計算出每一次要找質數的區間有多長; 假設 n1 近似 n2.<br/>
	 * To calculate the range (a number) for computing one time.
	 *
	 * @see #guessTotalPNRetInt32(long, long)
	 */
	public static int range32ToMinePrime(long n1) {

		// if (n1 < 4_000L) n1 = 4_000;

		long tmpN2 = n1 + 4_000;

		float f32AvgSqrt = ((float) StrictMath.sqrt(n1) + (float) StrictMath.sqrt(tmpN2)) / 2F;
		// l("f32AvgSqrt=" + f32AvgSqrt + S32 + THIS);

		float numOfTest = f32AvgSqrt / (float) StrictMath.log(f32AvgSqrt);
		// l("numOfTest=" + numOfTest + S32 + THIS);

		float f32Range = Ranger.$QTY_OF_CALCU_INT32 / numOfTest;

		if (tmpN2 < Ranger.$2POW31_MINUS1)

			f32Range *= 2.3F; // fuck

		int range32 = (int) f32Range;

		// O.l("range32ToMinePrime=" + O.f(range32) + " n1=" + O.f(n1), THIS);

		if (range32 > Ranger.$MAX_RANGE32_TO_MINE_PRIME)

			return Ranger.$MAX_RANGE32_TO_MINE_PRIME;

		if (range32 < Ranger.$MIN_RANGE32_TO_MINE_PRIME)

			return Ranger.$MIN_RANGE32_TO_MINE_PRIME;

		return (range32 >>> 3) << 3;

	}

	/**
	 * 計算出每 1 次要找質數的區間有多長.<br/>
	 * To calculate the range (a number) for computing one time.
	 */
	public static int bigRange32ForThrToMinePrime(long n1) {

		int range32 = range32ToMinePrime(n1) * 10;

		if (range32 > Ranger.$MAX_BIG_RANGE32_FOR_THR_TO_MINE_PRIME)

			return Ranger.$MAX_BIG_RANGE32_FOR_THR_TO_MINE_PRIME;

		if (range32 < Ranger.$MIN_BIG_RANGE32_FOR_THR_TO_MINE_PRIME)

			return Ranger.$MIN_BIG_RANGE32_FOR_THR_TO_MINE_PRIME;

		// O.lD("bigRange32ForThrToMinePrime=" + O.f(range32) + " n1=" + O.f(n1), THIS);

		return (range32 >>> 3) << 3;

	}

	/**
	 * 計算出每一次要找質數的區間有多長.<br/>
	 * To calculate the range(a number) for computing one time.
	 *
	 * @see #guessTotalPNRetInt32(long, long)
	 */
	public static int range32ToCountPrime(long n1) {

		int range32 = (range32ToMinePrime(n1) >>> 1) * 3;

		if (range32 > Ranger.$MAX_RANGE32_TO_MINE_PRIME)

			return Ranger.$MAX_RANGE32_TO_MINE_PRIME;

		if (range32 < Ranger.$MIN_RANGE32_TO_MINE_PRIME)

			return Ranger.$MIN_RANGE32_TO_MINE_PRIME;

		return (range32 >>> 3) << 3;

	}

	/**
	 * 計算出每一次要測試的質數有多少個.<br/>
	 * How many tests it needs to test a num?<br/>
	 * 根號N / ln 根號N
	 *
	 * @see #guessTotalPNRetInt32(long, long)
	 */
	public static int lenOfPreBuildPrimeAry(int int32) {

		float f32Sqrt = (float) StrictMath.sqrt(int32);

		return (int) (f32Sqrt / (float) StrictMath.log(f32Sqrt));

	}
}
