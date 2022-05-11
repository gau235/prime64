package lgpl3.comb.powerSet.sample;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.comb.powerSet.PowerSet;
import lgpl3.o.O;
import lgpl3.o.ary.Aryva;

/**
 * To gen subset.<br/>
 * To gen subset.
 *
 * @version 2022/04/24_23:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex17_ColRecurByExtTail" >
 *          Ex17_ColRecurByExtTail.java</a>
 *
 */
public class Ex17_ColRecurByExtTail {

	public static void main(String[] sAry) throws Throwable {

		long[] retAry = PowerSet.colRecurByExtTail(3);

		for (int idx = 0, size = Aryva.checkDup(retAry).length; idx != size; idx++)

			O.l(B64W6.strByVCell(retAry[idx]));

		O.l("total=" + retAry.length);

	}
}
