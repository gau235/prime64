package lgpl3.other.sample;

import static java.lang.System.out;

import lgpl3.o.O;
import lgpl3.o.ary.Aryva;

/**
 * To trim.<br/>
 * To trim.
 *
 * @version 2022/04/30_20:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex003_DelTailAllNull" >src</a>
 *
 */
public class Ex003_DelTailAllNull {

	public static void main1(String[] sAry) throws Throwable {

		String[] objAry = new String[] { null, null, null };

		O.l(objAry);

		objAry = O.delTailAllNull(objAry);

		O.l("aft=");
		O.l(objAry);

		out.println(objAry.length);

	}

	public static void main(String[] sAry) throws Throwable {

		long[] ary = new long[] { 0, 0, 0, 0 };

		ary = new long[] { 40, 20, 30, 0 };

		O.l(O.delTailAll0(ary));

		O.l("=====");

		O.l(Aryva.delHeadAll0(ary));

	}
}
