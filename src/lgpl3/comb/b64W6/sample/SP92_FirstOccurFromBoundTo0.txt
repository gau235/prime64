package lgpl3.comb.b64W6.sample;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.O;

/**
 * @version 2020/04/22_12:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=SP92_FirstOccurFromBoundTo0" >
 *          SP92_FirstOccurFromBoundTo0.java</a>
 *
 * @see Ex88_TestSelSort
 */
public class SP92_FirstOccurFromBoundTo0 {

	public static void main(String[] sAry) throws Throwable {

		int[] ary32 = new int[] { 10, 20, 30, 40, 40 };

		long b64W6 = B64W6.genB64W6ByAry32(ary32);

		O.l("B64W6=" + B64W6.str(b64W6));

		O.l(B64W6.findFirstOccurDownTo0(b64W6, 1, 20));

	}
}