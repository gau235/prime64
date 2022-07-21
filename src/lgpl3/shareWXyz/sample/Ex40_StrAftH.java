package lgpl3.shareWXyz.sample;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.O;
import lgpl3.shareWXyz.Hxy;

/**
 * 即 n 個相同物品分成給 k 人, 每人最少 1 個.<br/>
 * To return the number of ways to share several identical items with every person.
 *
 * @version 2022/03/28_11:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex40_StrAftH" >Ex40_StrAftH.java </a>
 *
 * @see Ex42_GoWDupByH
 */
public class Ex40_StrAftH {

	public static void main(String[] sAry) throws Throwable {

		long b64W6 = B64W6.genB64W6ByAry32(1, 4, 2); // min==0
		b64W6 = B64W6.revAmongVCell(b64W6);

		int min = 1;

		O.l(Hxy.rowStrAftH(b64W6, min, O.S_ARY_A_Z));

	}
}
