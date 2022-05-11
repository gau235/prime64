package lgpl3.divIntoHeap.sample;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.divIntoHeap.Dih;
import lgpl3.o.O;
import lgpl3.shareWXyz.Hxy;
import lgpl3.shareWXyz.sample.Ex02_HxyCol;

/**
 * n 個相同物品分成 k 堆, 每堆最少 min 個.<br/>
 * To return the number of ways to divide several identical items into several identical heaps.
 *
 * @version 2022/03/12_10:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex02_NatureDih" >Ex02_NatureDih.java</a>
 *
 * @see Ex02_HxyCol
 */
public class Ex02_NatureDih {

	public static void main(String[] sAry) throws Throwable {

		// n,k,min,mix as 18,3,1,8 => ans=7
		// n,k,min,mix as 20,3,2,8 => ans=4

		int n = 10;
		int k = 3;
		int min = 2;
		int max = n;

		long[] ary = Dih.natureCol(n, k, min);

		if (ary.length >= 2)

			O.l("ary[1]=" + O.L + B64W6.str24(ary[1]));

		O.l("========================" + O.L + Hxy.toStrByVCellPlusMinMinus1ByAry(ary, min, O.L));

		O.l(Hxy.toStrOf$ByAry(ary, min, O.L));

		O.l("ans=" + O.eq(ary.length, Dih.int64(n, k, min, max)));

	}
}
