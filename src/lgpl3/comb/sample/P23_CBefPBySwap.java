package lgpl3.comb.sample;

import lgpl3.comb.Pnk;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.O;
import lgpl3.o.ary.Aryva;

/**
 * Permutation.<br/>
 * Permutation.
 *
 * @version 2022/06/27_00:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=P23_CBefPBySwap" >src</a>
 *
 */
public class P23_CBefPBySwap {

	public static void main(String[] sAry) throws Throwable {

		int n = 4;
		int k = 3;

		long[] retAry = Pnk.colBySwap(n, k);

		Aryva.sortNCheckDup(retAry);

		if (n <= 5)

			for (int idx = 0, len = retAry.length; idx != len; idx++)

				O.l(B64W6.strByVCellMinus1AftRevBySAry(retAry[idx], O.S_ARY_A_Z));

		O.l("len=" + O.f(O.eq(retAry.length, Pnk.int64(n, k))));

	}
}