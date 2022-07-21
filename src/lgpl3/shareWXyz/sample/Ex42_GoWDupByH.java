package lgpl3.shareWXyz.sample;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.comb.wDup.sample.Ex704_ToHxy;
import lgpl3.o.O;
import lgpl3.shareWXyz.Hxy;
import lgpl3.shareWXyz.HxyVal;

/**
 * 即 n 個相同物品分成給 k 人, 每人最少 1 個.<br/>
 * To return the number of ways to share several identical items with every person.
 *
 * @version 2022/03/16_22:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex42_GoWDupByH" >Ex42_GoWDupByH.java</a>
 *
 * @see Ex704_ToHxy
 */
public class Ex42_GoWDupByH {

	public static void main(String[] sAry) throws Throwable {

		String s = "紅,黑, 白";

		sAry = O.splitNTrimAll(s, O.S44);

		int n = 3;
		int k = sAry.length;
		int min = 0;
		int max = n;

		long[] ary = Hxy.col(n, k, min, max);

		O.l(Hxy.toStrToHByAryOfB64W6(ary, min, sAry, "\t", O.L));

		for (int idx = 0; idx != ary.length;)

			O.l("allV=" + B64W6.strByVCellAftRev(ary[idx++]));

		O.l("ans=" + O.eq(ary.length, HxyVal.int64(n, k, min, max)));

	}
}
