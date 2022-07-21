package lgpl3.shareWXyz.sample;

import lgpl3.comb.Pnk;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.comb.wDup.sample.Ex704_ToHxy;
import lgpl3.o.O;
import lgpl3.shareWXyz.Hnr;
import lgpl3.shareWXyz.Hxy;
import lgpl3.shareWXyz.HxyVal;

/**
 * 即 n 個相同物品分成給 k 人, 每人最少 1 個.<br/>
 * To return the number of ways to share several identical items with every person.
 *
 * @version 2022/03/14_13:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex86_EasyH" >Ex86_EasyH.java</a>
 *
 * @see Ex704_ToHxy
 */
public class Ex86_EasyH {

	public static void main(String[] sAry) throws Throwable {

		sAry = new String[] { "紅", "黑", "白" };

		int numOfXyz = sAry.length;
		int totalN = 4;
		int min = 0;

		long ans = HxyVal.int64(totalN, numOfXyz, min, totalN);

		long[] ary = Hnr.easyRecur(numOfXyz, totalN);

		O.l("ary[0]=" + B64W6.str24(ary[0]));

		O.l(Pnk.strByAryOfRevB64W6BySAry(ary, sAry));

		O.l(Hxy.toStrByVCellPlusMinMinus1ByAry(ary, min, O.L));

		O.l("len=" + O.eq(ary.length, ans));

	}
}
