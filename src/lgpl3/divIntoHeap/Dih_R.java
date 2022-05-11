package lgpl3.divIntoHeap;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.keyNV.KAryV32;
import lgpl3.shareWXyz.Hxy;

/**
 * @version 2022/03/02_11:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Dih_R" >Dih_R.java</a>
 *
 * @see Dih
 */
public abstract class Dih_R extends Dih_L {

	private static final Class<?> THIS = Dih_R.class;

	/**
	 * n 個相同物品分成 k 堆, 每堆最少 min 個.<br/>
	 * To return the number of ways to divide several identical items into several identical heaps.
	 *
	 * @see Hxy #colRecur(int, int, int, int, long, KAryV32)
	 */
	public static void colRecur(int n, int k, int min, int max, long prefix, KAryV32 kAryV32) {

		// B.n32++;

		if (k == 1) {

			kAryV32.ary[kAryV32.int32++] = ((prefix << B64W6.$6) | n); // O.l( B64W6.toStrForToDiI(prefix, min) , THIS);

			return;

		}

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

		for (; min <= avg; min++) {

			newMax = ((newMax = n - min * k) > max) ? max : newMax; // newMax 每次都不一樣 (min 會加大)

			// newN between (newK * newMin) and (newK * newMax) // O.l("newN=" + newN, THIS);

			if ((newN = n - min) <= (k * newMax) && newN >= (k * min)) // 預測下一層的行為

				// 回傳樣態 不需要正規化
				colRecur(newN, k, min, newMax, ((prefix << B64W6.$6) | min), kAryV32);

		}
	}

	/**
	 * n 個相同物品分成 k 堆, 每堆最少 min 個.<br/>
	 * To return the number of ways to divide several identical items into several identical heaps.
	 *
	 * @see Hxy #col(int, int, int, int)
	 */
	public static long[] col(int n, int k, int min, int max) { // reduced for performance; min allowed 0

		int reguB32W6 = reguByMin1(n, k, min, max);

		n = (reguB32W6 & B64W6.MASK32);
		max = ((reguB32W6 >>> B64W6.$6) & B64W6.MASK32);

		checkArg(n, k, 1, max); // todo: remove me

		KAryV32 retKAryV32 = new KAryV32(int64(n, k, 1, max));

		colRecur(n, k, 1, max, 0b0L, retKAryV32);

		// O.l("str=" + O.L + B64va.toStrForToDiI(seq.trim().ary, O.L));

		return retKAryV32.ary;

	}
}
