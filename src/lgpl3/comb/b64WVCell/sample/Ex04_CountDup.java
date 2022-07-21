package lgpl3.comb.b64WVCell.sample;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.O;

/**
 * To count the occurrence of every value.<br/>
 * To count the occurrence of every value.
 *
 * @version 2020/03/02_20:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex04_CountDup" >Ex04_CountDup.java</a>
 *
 */
public class Ex04_CountDup {

	public static void main(String[] sAry) throws Throwable {

		long b64W6 = B64W6.genB64W6ByAry32(50, 50, 3, 3, 3);
		O.l("bef=" + O.L + B64W6.str24(b64W6));

		O.l("countDup=" + O.L + B64W6.str24(B64W6.countDup(B64W6.easySortAftTotalVCell(b64W6))));

	}
}
