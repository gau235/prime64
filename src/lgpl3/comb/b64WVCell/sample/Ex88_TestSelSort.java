package lgpl3.comb.b64WVCell.sample;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.O;

/**
 * @version 2021/05/22_11:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex88_TestSelSort" >Ex88_TestSelSort.java</a>
 *
 * @see Ex84_TestSelSortInAry32
 */
public class Ex88_TestSelSort {

	public static void main(String[] sAry) throws Throwable {

		int[] ary32 = new int[] { 1, 52, 3, 4, 5, 51, 2, 53, 54 };

		O.l(Ex84_TestSelSortInAry32.selSort(ary32.clone()));

		long b64W6 = B64W6.genB64W6ByAry32(ary32);
		long b64W6_2 = B64W6.genB64W6ByAry32(ary32);

		b64W6_2 = B64W6.easySortAftTotalVCell(b64W6_2);

		O.l(B64W6.strByVCellAftRev(b64W6));

		b64W6 = B64W6.revAmongVCell(b64W6);

		O.l(B64W6.strByVCellAftRev(b64W6));

	}
}