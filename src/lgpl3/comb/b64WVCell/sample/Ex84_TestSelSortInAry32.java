package lgpl3.comb.b64WVCell.sample;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.O;

/**
 * @version 2021/01/15_23:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex84_TestSelSortInAry32" >
 *          Ex84_TestSelSortInAry32.java</a>
 *
 * @see Ex88_TestSelSort
 */
public class Ex84_TestSelSortInAry32 {

	public static void swapValInAry32(int[] ary32, int idx1, int idx2) {

		int tmp32 = ary32[idx1];
		ary32[idx1] = ary32[idx2];
		ary32[idx2] = tmp32;

	}

	public static int[] selSort(int[] ary32) {

		int idxBig = 0, idxSmall;
		int idxMin, min;
		int tmp;
		for (; idxBig != ary32.length - 1; idxBig++) {

			idxMin = idxBig;
			min = ary32[idxBig];

			for (idxSmall = idxBig + 1; idxSmall != ary32.length; idxSmall++) {

				if ((tmp = ary32[idxSmall]) < min) {

					min = tmp;
					idxMin = idxSmall;

				}
			}

			if (idxMin != idxBig)
				swapValInAry32(ary32, idxBig, idxMin);

		}

		return ary32;

	}

	public static void main(String[] sAry) throws Throwable {

		int[] ary32 = new int[] { 10, 20, 30, 4, 5 };

		O.l(selSort(ary32.clone()));

		long b64W6 = B64W6.genB64W6ByAry32(ary32);

		b64W6 = B64W6.easySortAftTotalVCell(b64W6);

		O.l(B64W6.strByVCellAftRev(b64W6));

		b64W6 = B64W6.revAmongVCell(b64W6);

		O.l(B64W6.strByVCellAftRev(b64W6));

	}
}
