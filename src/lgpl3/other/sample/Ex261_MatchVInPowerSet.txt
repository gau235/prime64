package lgpl3.other.sample;

import lgpl3.comb.powerSet.PowerSet;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.shareWXyz.Hxy;

/**
 * To match the target value with coins in the power set.<br/>
 * The power set.
 *
 * @version 2022/04/26_13:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex261_MatchVInPowerSet" >
 *          Ex261_MatchVInPowerSet.java</a>
 *
 */
public class Ex261_MatchVInPowerSet {

	public static void main(String[] sAry) throws Throwable {

		int[] base = { 50, 20, 20, 15, 10, 2, 1, 1, 1 };

		int targetV = 75;

		long[] ary = PowerSet.colAllMatchV(base, targetV);

		for (int idx = 0, size = ary.length; idx != size; idx++)

			O.l(Hxy.toStrByVCellPlusMinMinus1(ary[idx], 1));

		O.l("B.n32=" + B.n32);
		B.n32 = 0;

	}
}