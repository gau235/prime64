package lgpl3.shareWXyz.sample;

import lgpl3.comb.wDup.DatWDup;
import lgpl3.comb.wDup.sample.Ex704_ToHxy;
import lgpl3.o.O;
import lgpl3.shareWXyz.Hxy;
import lgpl3.shareWXyz.HxyVal;

/**
 * 即 n 個相同物品分成給 k 人, 每人最少 1 個.<br/>
 * To return the number of ways to share several identical items with every person.
 *
 * @version 2019/08/17_18:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=SP66_GoWDupS" >SP66_GoWDupS.java </a>
 *
 * @see Ex704_ToHxy
 */
public class SP66_GoWDupS {

	public static void main(String[] sAry) throws Throwable {

		String s = "B,B,B,C,C";
		// String s = "黑AA白";

		int iWantPickN = 3;
		int min = 0;

		DatWDup datWDup = new DatWDup();

		datWDup.oriS = s;
		datWDup.k = iWantPickN;

		datWDup.initAll();

		long[] ary = Hxy.colWLim0ToMax(iWantPickN, datWDup.distinctSortedSAryToHxy.length, datWDup.b64W6OfQtyPlus1ToHxy);

		long ans = HxyVal.int64WLim0ToMax(iWantPickN, datWDup.distinctSortedSAryToHxy.length, datWDup.b64W6OfQtyPlus1ToHxy);

		StringBuilder str = Hxy.toStrToHByAryOfB64W6(ary, min, datWDup.distinctSortedSAryToHxy, "\t", O.L);
		O.l(str);

		O.l("ans=" + O.eq(ary.length, ans));

	}

}
