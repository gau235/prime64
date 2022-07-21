package lgpl3.comb.b64WVCell.sample;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.O;

/**
 * To sort.<br/>
 * To sort.
 *
 * @version 2021/01/15_23:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex80_Sort" >Ex80_Sort.java</a>
 *
 */
public class Ex80_Sort {

	public static void main(String[] sAry) throws Throwable {

		// long b64W6 = 0b000000_000001_000101_000010L;
		long b64W6 = B64W6.genB64W6ByAry32(20, 4, 8, 4, 1);
		O.l("bef=" + B64W6.strByVCell(b64W6));
		O.l(B64W6.str24(b64W6));

		b64W6 = B64W6.easySortAftTotalVCell(b64W6);
		O.l("aft selSort=" + B64W6.strByVCell(b64W6));
		O.l(B64W6.str24(b64W6));

		b64W6 = B64W6.easySortDesc(b64W6, B64W6.totalVCell(b64W6));
		O.l("aft easySortDesc=" + B64W6.strByVCell(b64W6));
		O.l(B64W6.str24(b64W6));

		O.l("min=" + B64W6.getMin(b64W6));
		O.l("max=" + B64W6.getMax(b64W6));

	}
}
