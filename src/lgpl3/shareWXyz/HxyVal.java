package lgpl3.shareWXyz;

import lgpl3.divIntoHeap.Dih;
import lgpl3.o.O;

/**
 * 即 n 個相同物品分成給 k 人, 每人最少 1 個.<br/>
 * The number of ways to share several identical items with every person.
 *
 * @version 2022/03/15_11:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=HxyVal" >HxyVal.java</a>
 *
 * @see Dih
 *
 * @see HxyVal
 *
 * @see Hxy
 */
public abstract class HxyVal extends HxyVal_A {

	// private static final Class<?> THIS = HxyVal.class;

	/**
	 * If passes test.<br/>
	 * If passes test.
	 *
	 * @see Dih#test()
	 */
	public static void test() {

		O.eq(Hxy.col(10, 3, 2, 4).length, 6);
		O.eq(Hxy.col(10, 3, 2, 7).length, 15);

		int n, k, min, endMin;
		int max, startMax, endMax;

		for (n = 1; n <= 10; n++)

			for (k = 1; k <= 10; k++) {

				for (min = 0, endMin = n / k; min <= endMin; min++) {

					startMax = (int) StrictMath.ceil(((float) n) / k);
					endMax = n - (k - 1) * min;

					for (max = startMax; max <= endMax; max++) {

						// O.l("n=" + n + ", k=" + k + ", min=" + min + ", max=" + max, THIS);

						O.eq(int64(n, k, min, max), int64ByDih(n, k, min, max));
						O.eq(Hxy.col(n, k, min, max).length, int64ByDih(n, k, min, max));

					}
				}
			}
	}
}
