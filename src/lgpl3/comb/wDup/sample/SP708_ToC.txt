package lgpl3.comb.wDup.sample;

import lgpl3.comb.wDup.DatWDup;
import lgpl3.comb.wDup.thr.ThrToCWDup;
import lgpl3.o.O;
import lgpl3.shareWXyz.HxyVal;

/**
 * To pick with duplicated.<br/>
 *
 * @version 2020/02/15_17:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=SP708_ToC" >SP708_ToC.java</a>
 *
 * @see Ex704_ToHxy
 *
 * @see SP708_ToC
 *
 * @see SP709_ToP
 */
public abstract class SP708_ToC {

	public static void main(String[] sAry) throws Throwable {

		String s = "1,2,3,4,1,2,3,4,5,6,5,6";

		int iWantPickN = 2;
		// int min = 0;

		DatWDup datWDup = new DatWDup();

		datWDup.oriS = s;
		datWDup.k = iWantPickN;

		// datum.regToEx = "C";

		datWDup.initAll();

		ThrToCWDup thrToCWDup = new ThrToCWDup(datWDup);
		thrToCWDup.run();

		long ans = HxyVal.int64WLim0ToMax(iWantPickN, datWDup.distinctSortedSAryToHxy.length, datWDup.b64W6OfQtyPlus1ToHxy);
		O.l("ans=" + O.f(ans));

		O.l("toStrAftCOrP=");
		O.l(datWDup.toStrAftCOrP());

		O.l("total32ToC=" + datWDup.total32ToC + O.S9 + SP708_ToC.class);

	}
}
