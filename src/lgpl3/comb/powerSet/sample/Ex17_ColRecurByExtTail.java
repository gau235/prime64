package lgpl3.comb.powerSet.sample;

import lgpl3.b32.B32va;
import lgpl3.comb.powerSet.PowerSet;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Ary32_2D;
import lgpl3.o.ary.Ary32va;

/**
 * To gen subset.<br/>
 * To gen subset.
 *
 * @version 2022/04/24_23:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex17_ColRecurByExtTail" >src</a>
 *
 */
public class Ex17_ColRecurByExtTail {

	public static void main1(String[] sAry) throws Throwable {

		int[] base = new int[] { 10, 20, 30 };

		Ary32_2D ret = PowerSet.colFromNone(base);

		O.l(ret.toStr());

		O.l("total=" + ret.i);

		O.l("B.n32=" + B.n32);
		B.n32 = 0;

	}

	public static void main(String[] sAry) throws Throwable {

		int n = 3;

		int ret[] = PowerSet.colRecurByExtTail(n), idx = 0, len = Ary32va.checkDup(ret).length;

		while (idx != len)

			O.l(B32va.strByLog2HighestBitBySAry(ret[idx++], O.S_ARY_A_Z));

		O.l("total=" + ret.length);

		O.l("B.n32=" + B.n32);
		B.n32 = 0;

	}
}
