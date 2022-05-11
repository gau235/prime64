package lgpl3.divIntoHeap;

import lgpl3.divIntoHeap.thr.ThrGrowCacheForDihVal;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.shareWXyz.Hxy;
import lgpl3.shareWXyz.HxyVal;

/**
 * 相同物分堆.<br/>
 * 即 n 個相同物品分成 k 堆, 每堆最少 min 個.<br/>
 * To return the number of ways to divide several identical items into several identical heaps.
 *
 * @version 2022/03/27_22:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Dih" >Dih.java</a>
 *
 * @see Dih
 *
 * @see HxyVal
 *
 * @see Hxy
 */
public abstract class Dih extends Dih_R {

	private static final Class<?> THIS = Dih.class;

	/**
	 * If passes test.<br/>
	 * If passes test.
	 */
	public static void test() {

		// n,k,min,mix as 18,3,1,8 => ans=7
		// n,k,min,mix as 20,3,2,8 => ans=4

		long[] ary = Dih.natureCol(18, 3, 1);

		O.gte(ary[ary.length - 1], 63);

		O.eq(ary.length, 27);
		O.eq(Dih.natureCol(20, 3, 2).length, 24);

		// n,k,min,max=[467,49,1,467]
		// =9,011,331,301,502,787,549
		// =9.0113312E18

		final int nForCache = 360;

		O.eq(new ThrGrowCacheForDihVal(nForCache, B.I).reguNAnsWCache(467, 49, 1, 467), 9_011_331_301_502_787_549L);

		int n, k, min, endMin;
		int max, qAsMax, endMax;

		for (n = 1; n <= 20; n++)

			for (k = 1; k <= 10; k++)

				for (min = 0, endMin = n / k; min <= endMin; min++) {

					qAsMax = n / k; // int qAsMax = Math.ceil((float) n / (float) k);

					if (k * qAsMax != n)

						qAsMax++;

					endMax = n - (k - 1) * min;

					for (max = qAsMax; max <= endMax; max++) {

						O.l("n, k, min, max=" + n + ", " + k + ", " + min + ", " + max, THIS);

						if (int64(n, k, min, max) != col(n, k, min, max).length)

							O.x("n, k, min, max=" + n + ", " + k + ", " + min + ", " + max);

						if (int64(n, k, min, max) != ThrGrowCacheForDihVal.reguNAnsWCache(n, k, min, max))

							O.x("n, k, min, max=" + n + ", " + k + ", " + min + ", " + max);

					}
				}
	}

}
