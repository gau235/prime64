package lgpl3.shareWXyz.sample;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.shareWXyz.Hxy;
import lgpl3.shareWXyz.HxyVal;

/**
 * 即 n 個相同物品分成給 k 人, 每人最少 0 個.<br/>
 * To return the number of ways to share several identical items with every person.
 *
 * @version 2022/03/17_21:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex59_ColWLim0ToMax" >Ex59_ColWLim0ToMax.java</a>
 *
 */
public class Ex59_ColWLim0ToMax {

	public static void main(String[] sAry) throws Throwable {

		int n = 9;
		int k = 3;

		long b64W6ForMaxPlus1 = B64W6.genB64W6ByAry32(5, 5, 3); // min==0; 5, 5, 3 is good

		O.l("str24=" + B64W6.str24(b64W6ForMaxPlus1));
		O.l("toStrByVCell=" + B64W6.strByVCellAftRev(b64W6ForMaxPlus1));

		B.n32 = 0;

		long[] ary = Hxy.colWLim0ToMax(n, k, b64W6ForMaxPlus1);

		if (ary.length != 0)

			O.l("ary[0]=" + B64W6.str24(ary[0]));

		O.l(Hxy.toStrByVCellPlusMinMinus1ByAry(ary, 0, O.L));

		O.l("len=" + O.eq(ary.length, HxyVal.int64WLim0ToMax(n, k, b64W6ForMaxPlus1)));

		O.l("B.n32=" + B.n32);
		B.n32 = 0;

	}
}
