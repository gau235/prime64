package lgpl3.shareWXyz.sample;

import lgpl3.comb.Pnk;
import lgpl3.comb.b64W6.B64W6;
import lgpl3.comb.wDup.sample.Ex704_ToHxy;
import lgpl3.o.O;
import lgpl3.shareWXyz.Hnr;
import lgpl3.shareWXyz.Hxy;

/**
 * 即 n 個相同物品分成給 k 人, 每人最少 1 個.<br/>
 * To return the number of ways to share several identical items with every person.
 *
 * @version 2021/02/21_08:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex85_TestH" >Ex85_TestH.java</a>
 *
 * @see Ex704_ToHxy
 */
public class Ex85_TestH {

	public static void main(String[] sAry) throws Throwable {

		sAry = new String[] { "紅", "黑", "白" };

		int numOfXyz = sAry.length;
		int totalN = 5;

		long qtyB64 = B64W6.genB64W6ByAry32(2, 3, 4);

		long[] ary = Hnr.recur(numOfXyz, totalN, qtyB64);

		StringBuilder str = Pnk.strByAryOfRevB64W6BySAry(ary, sAry);
		O.l(str);

		str = Hxy.toStrByVCellPlusMinMinus1ByAry(ary, 0, O.L);
		O.l(str);

		O.l("len=" + ary.length);

	}
}
