package lgpl3.prime64;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 本类别抽象找质数的人, 是我造质数卵时最先写的类别.<br/>
 * 耗能量的质数卵, 我当初发明它是要找出初数和末数间所有的质数, 我无意间用它测试电脑效能.<br/>
 * 我觉得武功愈高, 佛法也要愈高; 所以我开放原始码.<br/>
 * 我更有人性.<br/>
 * <br/>
 * 质数卵设计的取舍:<br/>
 * 1. 人性 (阴暗面)<br/>
 * 2. 生创力<br/>
 * 3. 结构 (建构, 简单和容易改动, 容易维护)<br/>
 * 4. 退场机制, 有上台就得有下台<br/>
 * 5. 执行效能<br/>
 *
 * 11. 思想方面: 人类因为有梦想而伟大, 人类因为认识自己的有限, 认识自己的渺小, 因为去认识自己而伟大<br/>
 * 12. 思想方面: 武功愈高, 佛法也要愈高<br/>
 * <br/>
 * 找质数的人找质数是去抓内建的质数阵列内的质数来检验你输入的数是否为质数, 所以内建的质数阵列内含质数要连续, 且够大.<br/>
 * <br/>
 * The first class I wrote in this program.<br/>
 * This program is Little Sequence Prime64 Miner Escapable (LSPME), version prime64Lgpl3;<br/>
 * and is used to mine the primes less than 64 bit integer on your personal computer.<br/>
 * If you want to develop the more martial, you will need more Buddhism.<br/>
 *
 * @version 2021/08/27_23:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Miner_A" >Miner_A.java</a>
 *
 * @see PrimeAry2D
 *
 * @see Miner_D
 */
public abstract class Miner_A {

	private static final Class<?> THIS = Miner_A.class;

	/**
	 * 找質數的人初始化時會找 1 ~ $INIT_TAIL_N32_FOR_ORI_ARY_OF_P 的質數.<br/>
	 * The tail prime of origin array of prime.
	 */
	public static final int $INIT_TAIL_N32_FOR_ORI_ARY_OF_P = 55_109;

	/**
	 * 找質數的人初始化時會找 1 ~ $INIT_TAIL_N32_FOR_ORI_ARY_OF_P 的質數.<br/>
	 * 用來裝這些質數的陣列的長度.<br/>
	 * The length of origin array of prime.
	 */
	public static final int $COUNT32_OF_P_LTE_INIT_TAIL_N32 = 5_601;

	/**
	 * 此自然數是質數 ?<br/>
	 * Is the nature odd number a prime?<br/>
	 * Note: n must be odd and be greater than or equal to 3
	 */
	public static boolean testPrime32(int oddN32) {

		for (int div32 = 3; div32 * div32 <= oddN32; div32 += 2)

			if (oddN32 % div32 == 0)

				return B.O;

		return B.I;

	}

	/**
	 * 初始化 (質數) 陣列.<br/>
	 * To init the origin array of primes.
	 */
	public static long[] genOriAryOfP() {

		if (oriAryOfP != null)

			O.x(); // just be called one time

		long[] retAry = new long[$COUNT32_OF_P_LTE_INIT_TAIL_N32];

		int idx = 0, n32 = 5;

		retAry[idx++] = 2L; // fuck
		retAry[idx++] = 3L; // fuck

		for (boolean b4 = B.I; n32 <= $INIT_TAIL_N32_FOR_ORI_ARY_OF_P; n32 += ((b4 = !b4) ? 4 : 2))

			if (testPrime32(n32))

				retAry[idx++] = n32; // keep it

		// O.l("genOriAryOfP maxP=" + O.f(retAry[retAry.length - 1]), THIS);

		return retAry;

	}

	/**
	 * 內建的質數陣列.<br/>
	 * The inside origin array of prime.
	 */
	public static long[] oriAryOfP = genOriAryOfP();

	/**
	 * 內建的質數陣列的長度.<br/>
	 * The length of the inside the origin array of prime.
	 */
	public static int lenMinus1OfOriAryOfP = oriAryOfP.length - 1;

	/**
	 * 執行擴充質數陣列的最大值.<br/>
	 * The maximum number to grow the origin array of prime.
	 */
	public static final long $MAX_TAIL_N_FOR_GROW_ORI_ARY_OF_P = 3_037_000_507L; // 3,037,000,499

	/**
	 * The max length of the origin array of prime.<br/>
	 * The max length of the origin array of prime.
	 */
	public static final int $MAX_LEN_OF_ORI_ARY_OF_P = 146_144_319;

	/**
	 * Current max prime.<br/>
	 * Current max prime.
	 */
	public static long maxInOriAryP() {

		return oriAryOfP[lenMinus1OfOriAryOfP];
	}

	/**
	 * Current max n to test.<br/>
	 * Current max n to test.
	 */
	public static long curMaxNToTest() {

		double f64 = oriAryOfP[lenMinus1OfOriAryOfP]; // 用過 float 了

		return ((f64 *= f64) < Ranger.$MAX_TEST_N) ? ((long) f64) : Ranger.$MAX_TEST_N;

	}

	/**
	 * 內建的物件, 用於多執行緒的存取控制.<br/>
	 * For synchronizing.
	 */
	public static final Object KEY_TO_SYN = new Object();

	/**
	 * 置換成另一個質數陣列.<br/>
	 * To replace with another origin array of prime.
	 */
	public static void setOriAryOfP(long[] aryOfP, Class<?> calledByWhichClass) {

		synchronized (KEY_TO_SYN) {

			oriAryOfP = aryOfP;
			lenMinus1OfOriAryOfP = aryOfP.length - 1;

		}

		if (O.isDev)

			O.l("setOriAryOfP to " + O.f(aryOfP[lenMinus1OfOriAryOfP]), calledByWhichClass);

	}
}
