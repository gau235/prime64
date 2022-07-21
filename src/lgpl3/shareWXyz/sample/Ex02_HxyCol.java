package lgpl3.shareWXyz.sample;

import lgpl3.divIntoHeap.sample.Ex05_DivIntoHeap;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.shareWXyz.Hxy;
import lgpl3.shareWXyz.HxyVal;

/**
 * 即 n 個相同物品分成給 k 人, 每人最少 1 個.<br/>
 * To return the number of ways to share several identical items with every person.
 *
 * @version 2022/03/05_18:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex02_HxyCol" >Ex02_HxyCol.java</a>
 *
 * @see Ex05_DivIntoHeap
 */
public class Ex02_HxyCol {

	public static void main(String[] sAry) throws Throwable {

		int n = 3;
		int k = 2;
		int min = 2;
		int max = 10;

		// O.l("n=" + n + ", k=" + k + ", min=" + min + ", max=" + max, Ex02_HxyCol.class);

		long[] ary = Hxy.col(n, k, min, max);

		O.l(Hxy.toStrByVCellPlusMinMinus1ByAry(ary, min, O.L));

		O.l(Hxy.toStrOf$ByAry(ary, min, O.L));

		O.eq(ary.length, HxyVal.int64(n, k, min, max));

		O.l("len=" + O.eq(ary.length, HxyVal.int64ByDih(n, k, min, max)));

		O.l("B.n32=" + B.n32);

		B.n32 = 0;

	}
}
