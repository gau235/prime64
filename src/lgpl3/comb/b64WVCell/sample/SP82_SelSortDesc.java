package lgpl3.comb.b64WVCell.sample;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.O;

/**
 * Sorting test.<br/>
 * Sorting test.
 *
 * @version 2019/04/13_19:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=SP82_SelSortDesc" >SP82_SelSortDesc .java </a>
 *
 */
public class SP82_SelSortDesc {

	public static void main(String[] sAry) throws Throwable {

		long b64W6 = 0b000010_001000L;

		//////////////////////
		b64W6 = B64W6.pasteAt(b64W6, 0, 5);
		b64W6 = B64W6.pasteAt(b64W6, 1, 4);
		b64W6 = B64W6.pasteAt(b64W6, 2, 6);
		O.l("bef=" + B64W6.str24(b64W6));
		// b64W6 = B64W6.bubbleSort(b64W6);
		b64W6 = B64W6.revAmongVCell(B64W6.easySortAftTotalVCell(b64W6));

		O.l("aft=" + B64W6.str24(b64W6));

		StringBuilder ooo = B64W6.strByVCellAftRev(b64W6);
		O.l(ooo);

		long bbb = B64W6.revAmongVCell(b64W6);
		O.l(B64W6.str24(bbb));

	}

}
