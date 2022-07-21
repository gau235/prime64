package lgpl3.comb.b64WVCell.sample;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.O;

/**
 * To paste.<br/>
 * To paste.
 *
 * @version 2019/03/21_12:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=SP06_PasteAt" >SP06_PasteAt.java</a>
 *
 */
public class SP06_PasteAt {

	public static void main(String[] sAry) throws Throwable {

		long b64W6 = 0b000101_000111L;

		//////////////////////
		b64W6 = B64W6.pasteAt(b64W6, 0, 5);
		// O.l("bef=" + B64W6.str24(b64W6));

		b64W6 = B64W6.pasteAt(b64W6, 1, 4);
		b64W6 = B64W6.pasteAt(b64W6, 2, 6);
		O.l("bef=" + B64W6.str24(b64W6));

		b64W6 = B64W6.revAmongVCell(B64W6.easySortAftTotalVCell(b64W6));

		O.l("aft=" + B64W6.str24(b64W6));

		StringBuilder str = B64W6.strByVCellAftRev(b64W6);
		O.l(str);

		long b64W6_2 = B64W6.revAmongVCell(b64W6);
		O.l("revAmongVCell=" + O.L + B64W6.str24(b64W6_2));

	}

}
