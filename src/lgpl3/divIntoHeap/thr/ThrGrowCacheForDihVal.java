package lgpl3.divIntoHeap.thr;

import lgpl3.divIntoHeap.Dih;
import lgpl3.o.O;
import lgpl3.o.time.T64;

/**
 * 相同物分堆.<br/>
 * 即 n 個相同物品分成 k 堆, 每堆最少 min 個.<br/>
 * To return the number of ways to divide several identical items into several identical heaps.
 *
 * @version 2022/03/29_11:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=ThrGrowCacheForDihVal" >
 *          ThrGrowCacheForDihVal.java</a>
 *
 * @see Dih
 */
public class ThrGrowCacheForDihVal extends Thread {

	private static final Class<?> THIS = ThrGrowCacheForDihVal.class;

	public static final int N_OF_BIT_TO_SHIFT_L = 9;

	public static final int MAX32_N = 467;

	/**
	 * The cacheAry.<br/>
	 * The cacheAry.
	 */
	public static long[] cacheAry;

	public static int nForCache;

	/**
	 * to regularize.<br/>
	 * to regularize.
	 */
	public static int[] regu(int n, int k, int min, int max) {

		int diffOrNewMax;

		if (min != 1) { // O.l("n=" + n + ", k=" + k + ", min=" + min + ", max=" + max, THIS);

			diffOrNewMax = min - 1; // min always 1

			n -= k * diffOrNewMax;
			max -= diffOrNewMax;

		}

		// diffOrNewMax = n - (k-1)*min

		return new int[] { n, (max < (diffOrNewMax = n - k + 1)) ? max : diffOrNewMax };

	}

	/**
	 * 0b_max_k_n<br/>
	 * 0b_max_k_n
	 */
	public static int getIdx(int n, int k, int max) {

		int idx = max << N_OF_BIT_TO_SHIFT_L;

		idx |= k;

		idx <<= N_OF_BIT_TO_SHIFT_L;

		return (idx | n);

	}

	/**
	 * 相同物分堆.<br/>
	 * 即 n 個相同物品分成 numOfHeap 堆, 每堆最少 minInHeap 個.<br/>
	 * To return the number of ways to divide several identical items into several identical heaps.
	 */
	public static long ansWCache(int n, int k, int min, int max) {

		if (k == 2) // termination condition

			return max - ((n + 1) >>> 1) + 1; // int ceilOfNDiv2 = (n + 1) >>> 1;

		long ans;

		if (n <= nForCache && (ans = cacheAry[getIdx(n, k, max)]) != 0L) // hit

			return ans;

		// O.x("n=" + n + ", k=" + k + ", min=" + min + ", max=" + max);

		int avg = n / k;

		int newN, newMax;

		k--;

		ans = 0L;

		for (int[] reguAry32; min <= avg; min++) {

			newMax = ((newMax = n - min * k) > max) ? max : newMax; // newMax 每次都不一樣 (min 會加大)

			if ((newN = n - min) <= (k * newMax) && newN >= (k * min)) // 預測下一層的行為

				ans += (min == 1) ? ansWCache(newN, k, 1 /* aft regu min always 1 */, newMax)

						: ansWCache((reguAry32 = regu(newN, k, min, newMax))[0], k, 1, reguAry32[1]);

		}

		return ans;

	}

	/**
	 * 相同物分堆.<br/>
	 * 即 n 個相同物品分成 numOfHeap 堆, 每堆最少 minInHeap 個.<br/>
	 * To return the number of ways to divide several identical items into several identical heaps.
	 */
	public static long reguNAnsWCache(int n, int k, int min, int max) {

		// O.l("n=" + n + ", k=" + k + ", min=" + min + ", max=" + max, THIS);

		// regularize
		// check arg
		// special case

		if (min < 0)

			O.x("n=" + n + ", k=" + k + ", min=" + min + ", max=" + max);

		int[] reguAry32 = regu(n, k, min, max);

		n = reguAry32[0];

		max = reguAry32[1];

		if (n == (k + 1) || n == k || k == 1)

			return 1L;

		return ansWCache(n, k, 1, max);

	}

	/**
	 * Constructor.<br/>
	 * Constructor.
	 */
	public ThrGrowCacheForDihVal(int n, boolean isToRun) {

		if ((nForCache = n) > MAX32_N)

			O.x("n=" + n);

		if (isToRun)

			run();

	}

	/**
	 * To grow cache.<br/>
	 * To grow cache.
	 */
	@Override
	public void run() { // grow cache

		long t0 = O.t();

		int len = (0b1 << N_OF_BIT_TO_SHIFT_L);

		len <<= N_OF_BIT_TO_SHIFT_L;
		len <<= N_OF_BIT_TO_SHIFT_L;

		cacheAry = new long[len];

		O.l("cacheAry.len=" + O.f(len), THIS);

		int n, k, max, startMax, endMax;

		long ans;

		for (n = 1; n <= nForCache; n++) {

			for (k = 1; k <= n; k++) {

				startMax = (int) StrictMath.ceil((float) n / (float) k);
				endMax = n - (k - 1); // n - (k - 1)*min

				for (max = startMax; max <= endMax; max++) {

					cacheAry[getIdx(n, k, max)] = ans = reguNAnsWCache(n, k, 1, max);

					if (n < (MAX32_N >>> 3))

						O.l("n,k,min,max=[" + n + "," + k + "," + 1 + "," + max + "]=" + O.f(ans), THIS);

					// if (ans > (9_000_000_000_000_000_000L) || ans < 0L) {
					//
					// O.l("n,k,min,max=" + n + ", " + k + ", " + 1 + ", " + max , THIS);
					// O.l("ans=" + O.f(ans), THIS);

				}
			}
		}

		O.l("doneGrowCache, cost=" + T64.difInF32Sec(t0), THIS);

	}
}
