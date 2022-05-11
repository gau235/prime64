package lgpl3.comb.wDup.sample;

import lgpl3.comb.wDup.DatWDup;
import lgpl3.o.O;
import lgpl3.shareWXyz.HxyVal;
import lgpl3.shareWXyz.Hxy;

/**
 * 即 n 個相同物品分成給 k 人, 每人最少 1 個.<br/>
 * To return the number of ways to share several identical items with every person.
 *
 * @version 2019/08/17_12:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex704_ToHxy" >Ex704_ToHxy.java</a>
 *
 * @see Ex704_ToHxy
 *
 * @see SP708_ToC
 *
 * @see SP709_ToP
 */
public abstract class Ex704_ToHxy {

	public static void main(String[] sAry) throws Throwable {

		String s = "A,A,A,C";

		int iWantPickN = 3;
		// int min = 0;

		DatWDup datWDup = new DatWDup();

		datWDup.oriS = s;
		datWDup.k = iWantPickN;

		// zw108.regToEx = "C,A";

		datWDup.initAll();

		///////////////////////////////////////

		long ans = HxyVal.int64WLim0ToMax(iWantPickN, datWDup.distinctSortedSAryToHxy.length, datWDup.b64W6OfQtyPlus1ToHxy);

		long[] aryOfB64W6 = Hxy.colWLim0ToMax(datWDup.k, datWDup.distinctSortedSAryToHxy.length, datWDup.b64W6OfQtyPlus1ToHxy);

		final int min = 0;
		for (int i = 0; i != aryOfB64W6.length; i++) {

			StringBuilder retStr = new StringBuilder();
			retStr.append(O.C91).append(Hxy.toStrByVCellPlusMinMinus1(aryOfB64W6[i], min)).append(O.C93);

			O.l(retStr);

		}

		if (ans != aryOfB64W6.length) {

			O.x("ans=" + ans + ", len=" + aryOfB64W6.length);

		}

		///////////////////////////////////////

		datWDup.addAftToInExByToH(aryOfB64W6);

		O.l("Max=" + O.f(datWDup.total32ToHxy));

		O.l(datWDup.retStrToHxy);

	}

}
