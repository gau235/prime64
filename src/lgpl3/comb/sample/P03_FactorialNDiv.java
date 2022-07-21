package lgpl3.comb.sample;

import lgpl3.comb.Pnk;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.O;
import lgpl3.shareWXyz.HxyVal;

/**
 * 排列.<br/>
 * Permutation.
 *
 * @version 2021/05/19_20:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=P03_FactorialNDiv" >P03_FactorialNDiv.java</a>
 *
 */
public class P03_FactorialNDiv {

	public static void main(String[] sAry) throws Throwable {

		long b64W6OfQtyPlus1 = B64W6.genB64W6ByAry32(2, 3, 4, 4); // 1,2,3,3; all plus 1

		O.l("ans=" + O.f(HxyVal.factorialNDiv(Pnk.int64(9), b64W6OfQtyPlus1)));

	}
}
