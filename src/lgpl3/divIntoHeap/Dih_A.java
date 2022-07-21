package lgpl3.divIntoHeap;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.O;
import lgpl3.o.ary.Seq;

/**
 * @version 2022/02/27_22:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Dih_A" >Dih_A.java</a>
 *
 * @see Dih_L
 */
public abstract class Dih_A extends DivIntoHeap {

	private static final Class<?> THIS = Dih_A.class;

	/**
	 * 即 n 個相同物品分成 numOfHeap 堆, 每堆最少 minInHeap 個.<br/>
	 * To return the number of ways to divide several identical items into several identical heaps.
	 *
	 * @see Dih #colRecur(int, int, int, int, long, Seq)
	 */
	public static long recurForInt64(int n, int k, int min, int max) { // after regularized min always 1

		if (k == 2) // termination condition

			return (max - ((n + 1) >>> 1) + 1);

		// avg, min, max for 這一層
		// newMin, newMax for 下一層

		// int newN
		// int newK as k - 1
		// int newMin always 1 aft regularized
		// int newMax

		int avg = n / k;

		int newN, newMax; // int upperBound = Math.min(n / k, newMax);

		k--;

		// 10 into 3 heap
		// 3,1,6 不會有
		// 3,2,5 不會有
		// 3,3,4 ok
		// 3,4,3 不會有
		// 3,5,2 不會有

		long ans = 0L;

		for (int reguB32W6; min <= avg; min++) {

			newMax = ((newMax = n - min * k) > max) ? max : newMax; // newMax 每次都不一樣 (min 會加大)

			// newN between (newK * newMin) and (newK * newMax) // O.l("newN=" + newN, THIS);

			if ((newN = n - min) <= (k * newMax) && newN >= (k * min))

				if (min == 1)

					ans += recurForInt64(newN, k, 1, newMax);
				else {

					reguB32W6 = reguByMin1(newN, k, min, newMax);

					newN = (reguB32W6 & B64W6.MASK32);
					newMax = ((reguB32W6 >>> B64W6.$6) & B64W6.MASK32);

					ans += recurForInt64(newN, k, 1, newMax);

				}
		}

		return ans;

	}

	/**
	 * 即 n 個相同物品分成 numOfHeap 堆, 每堆最少 minInHeap 個.<br/>
	 * To return the number of ways to divide several identical items into several identical heaps.
	 *
	 * @see Dih #col(int, int, int, int, long)
	 */
	public static long int64(int n, int k, int min, int max) {

		// regularize
		// check arg
		// special case

		if (min < 0)

			O.x("n=" + n + ", k=" + k + ", min=" + min + ", max=" + max);

		int reguB32W6 = reguByMin1(n, k, min, max);

		n = (reguB32W6 & B64W6.MASK32);
		max = ((reguB32W6 >>> B64W6.$6) & B64W6.MASK32);

		// checkArg(n, k, 1, max);

		if ((n == (k + 1)) || n == k || k == 1)

			return 1L;

		return recurForInt64(n, k, 1, max);

	}
}
