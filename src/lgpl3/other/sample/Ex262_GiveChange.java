package lgpl3.other.sample;

import lgpl3.comb.powerSet.thr.ThrGiveChange;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.shareWXyz.Hxy;

/**
 * To give change.<br/>
 * To give change.
 *
 * @version 2022/04/26_20:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex262_GiveChange" >Ex262_GiveChange.java</a>
 *
 */
public class Ex262_GiveChange {

	public static void main(String[] sAry) throws Throwable {

		int[] base = { 50, 20, 20, 15, 10, 2, 1, 1, 1 };

		int targetV = 75;

		long[] ary = new ThrGiveChange(base, targetV, B.I).box;

		for (int idx = 0, size = ary.length; idx != size; idx++)

			O.l(Hxy.toStrByVCellPlusMinMinus1(ary[idx], 1));

		O.l("B.n32=" + B.n32);
		B.n32 = 0;

	}
}