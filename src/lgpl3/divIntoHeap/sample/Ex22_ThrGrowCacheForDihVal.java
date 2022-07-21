package lgpl3.divIntoHeap.sample;

import lgpl3.divIntoHeap.thr.ThrGrowCacheForDihVal;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.time.T64;

/**
 * 相同物分堆.<br/>
 * 即 n 個相同物品分成 k 堆, 每堆最少 min 個.<br/>
 * To return the number of ways to divide several identical items into several identical heaps.
 *
 * @version 2022/03/24_11:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex22_ThrGrowCacheForDihVal" >
 *          Ex22_ThrGrowCacheForDihVal.java</a>
 *
 */
public class Ex22_ThrGrowCacheForDihVal {

	public static void main(String[] sAry) throws Throwable {

		final int nForCache = 360;

		new ThrGrowCacheForDihVal(nForCache, B.I);

		for (int from = 467, to = (from + 3); from <= to; from += 10) {

			int n = from;
			int k = 49; // int k = n / 3;
			int min = 1;
			int max = n; // int max = n - (k - 1) * min - 10;

			long t0 = O.t();

			long ans = ThrGrowCacheForDihVal.reguNAnsWCache(n, k, min, max);

			O.l("n,k,min,max=[" + n + "," + k + "," + min + "," + max + "]" + O.L + "=" + O.f(ans));
			O.l("=" + (float) ans);

			int[] reguAry32 = ThrGrowCacheForDihVal.regu(n, k, min, max);

			O.l("cached n,k,min,max=[" + reguAry32[0] + "," + k + "," + 1 + "," + reguAry32[1] + "]="
					+ ThrGrowCacheForDihVal.cacheAry[ThrGrowCacheForDihVal.getIdx(n, k, max)]);

			O.l("cost=" + T64.difInF32Sec(t0));

			O.l("=======================================");

		}
	}
}
