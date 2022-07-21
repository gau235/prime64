package lgpl3.comb.powerSet.sample;

import lgpl3.comb.powerSet.PowerSet;
import lgpl3.o.B;
import lgpl3.o.O;

/**
 * To gen subset.<br/>
 * To gen subset.
 *
 * @version 2022/04/24_11:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex16_PrintSubset" >Ex16_PrintSubset.java</a>
 *
 */
public class Ex16_PrintSubset {

	public static void main(String[] sAry) throws Throwable {

		sAry = new String[] { "A", "B", "C", };

		PowerSet.printAll(sAry, 0, "");

		O.l("B.n32=" + B.n32);
		B.n32 = 0;

	}
}
