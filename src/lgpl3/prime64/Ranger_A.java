package lgpl3.prime64;

import lgpl3.o.O;

/**
 * 本類別區間計算娃, 計算出每一次要找質數的區間有多長.<br/>
 * To calculate the range (a number) for mine prime program.
 *
 * @version 2021/01/13_15:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ranger_A" >Ranger_A.java</a>
 *
 * @see Ranger
 */
public abstract class Ranger_A {

	// private static final Class<?> THIS = Ranger_A.class;

	public static final int TYPE32_ADD = 0b01;

	public static final int TYPE32_MUL = 0b10;

	/**
	 * 32 位元整數 100<br/>
	 * 32 位元整數 100
	 */
	public static final int $100_INT32 = 100;

	/**
	 * 2,147,483,647<br/>
	 * 0b111_1111_1111_1111_1111_1111_1111_1111L
	 */
	public static final long $2POW31_MINUS1 = 0b111_1111_1111_1111_1111_1111_1111_1111L;

	/**
	 * 3,037,000,499<br/>
	 * StrictMath.sqrt(Long.MAX_VALUE) &gt; this
	 */
	public static final long $SQRT_OF_2POW63_MINUS1 = 3_037_000_499L;

	/**
	 * 最小 range.<br/>
	 * The minimum range.
	 */
	public static final int $MIN_RANGE32_TO_MINE_PRIME = 10;

	/**
	 * 最大 range.<br/>
	 * The maximum range.
	 */
	public static final int $MAX_RANGE32_TO_MINE_PRIME = 4_000_000;

	/**
	 * 找質數的執行緒去找質數情況下的 big range.<br/>
	 * The big range for ThrToMinePrime.
	 */
	public static final int $MAX_BIG_RANGE32_FOR_THR_TO_MINE_PRIME = 8_000_000;

	/**
	 * 找質數的執行緒去找質數情況下的 big range.<br/>
	 * The big range for ThrToMinePrime.
	 */
	public static final int $MIN_BIG_RANGE32_FOR_THR_TO_MINE_PRIME = 40;

	/**
	 * 找質數數目的執行緒去找質數數目情況下的 big range for ThrToCountPrime.<br/>
	 * The big range for ThrToCountPrime to count prime.
	 */
	public static final int $MAX_BIG_RANGE32_FOR_THR_TO_COUNT_PRIME = 8_000_000;

	/**
	 * 找質數數目的執行緒去找質數數目情況下的 big range.<br/>
	 * The big range for ThrToMinePrime.
	 */
	public static final int $MIN_BIG_RANGE32_FOR_THR_TO_COUNT_PRIME = 40;

	/**
	 * 每次找質數時的運算當量.<br/>
	 * The quantity of calculating (every second?).
	 *
	 * @see GuessFromGauss#guessTotalPNRetInt32(long, long)
	 */
	public static final int $QTY_OF_CALCU_INT32 = 31_000_000;

	/**
	 * 找質數 minePrime 時所允許輸入最大數.<br/>
	 * The maximum input number when mining prime.
	 */
	// public static final long $MAX_TEST_N = 9_223_372_036_854_775_806L; // Long.MAX_VALUE-1
	public static final long $MAX_TEST_N = Long.MAX_VALUE -

			($MIN_BIG_RANGE32_FOR_THR_TO_MINE_PRIME * (O.$MAX_NUM_OF_CPU_THR + 1));

	public static final long $MAX_PRIME_LESS_THAN_2POW63 = 9_223_372_036_854_775_783L;

}
