package lgpl3.other.sample;

import lgpl3.o.O;
import lgpl3.o.ary.Aryva;

/**
 * To trim.<br/>
 * To trim.
 *
 * @version 2021/06/30_20:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex003_TrimNull" >Ex003_TrimNull.java</a>
 *
 */
public class Ex003_TrimNull {

	public static void main1(String[] sAry) throws Throwable {

		String[] objAry = new String[] { null, null, null };

		O.l(objAry);

		objAry = O.delTailAllNull(objAry);

		O.l("aft=");
		O.l(objAry);
		O.l(objAry.length);

	}

	public static void main(String[] sAry) throws Throwable {

		long[] ary1 = new long[] { 0, 0, 0, 0 };
		// long[] ary1 = { 40, 20, 30, 0 };
		ary1 = Aryva.delHeadAll0(ary1);

		// ary1 = O.delTailAll0(ary1);

		O.l(ary1);

	}
}
