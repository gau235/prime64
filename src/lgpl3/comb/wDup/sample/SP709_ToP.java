package lgpl3.comb.wDup.sample;

import lgpl3.comb.wDup.DatWDup;
import lgpl3.comb.wDup.PWDup;
import lgpl3.comb.wDup.thr.ThrToPWDup;
import lgpl3.o.O;
import lgpl3.shareWXyz.Hxy;

/**
 * To pick with duplicated.<br/>
 *
 * @version 2019/08/17_16:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=SP709_ToP" >SP709_ToP.java</a>
 *
 * @see Ex704_ToHxy
 *
 * @see SP708_ToC
 *
 * @see SP709_ToP
 */
public abstract class SP709_ToP {

	public static void main(String[] sAry) throws Throwable {

		String s = "B,A,A,C";

		int iWantPickN = 2;
		// int min = 0;

		DatWDup datWDup = new DatWDup();

		datWDup.oriS = s;
		datWDup.k = iWantPickN;

		// datum.regToEx = "C";
		// datum.regToIn = "(深,深|_,)";
		// datum.regToEx = "(A,A|_,)";

		datWDup.initAll();

		/////////////////////////////////////////////////////

		long[] aryOfB64W6 = Hxy.colWLim0ToMax(datWDup.k, datWDup.distinctSortedSAryToHxy.length, datWDup.b64W6OfQtyPlus1ToHxy);
		O.l("aryOfB64W6.length=" + aryOfB64W6.length);

		final int min = 0;
		for (int i = 0; i != aryOfB64W6.length; i++) {

			// O.l("aaa=" + B64W6.str24(ary[i]));
			StringBuilder retStr = new StringBuilder();
			retStr.append(O.C91).append(Hxy.toStrByVCellPlusMinMinus1(aryOfB64W6[i], min)).append(O.C93);

			O.l(retStr);

		}

		long ans = PWDup.int64ByHxy(datWDup.k, datWDup.distinctSortedSAryToHxy.length, datWDup.b64W6OfQtyPlus1ToHxy);

		O.l("ans=" + ans);

		ThrToPWDup thrToPWDup = new ThrToPWDup(datWDup);
		thrToPWDup.run();

		O.l("toStrAftCOrP=");
		O.l(datWDup.toStrAftCOrP());

		O.l("total32ToP=" + datWDup.total32ToP);

	}

}
