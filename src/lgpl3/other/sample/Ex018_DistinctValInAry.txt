package lgpl3.other.sample;

import java.util.Arrays;

import lgpl3.o.O;
import lgpl3.o.ary.Aryva;

/**
 * To distinct.<br/>
 * To distinct.
 *
 * @version 2021/06/11_09:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex018_DistinctValInAry" >
 *          Ex018_DistinctValInAry.java</a>
 *
 */
public class Ex018_DistinctValInAry {

	public static void main(String[] sAry) throws Throwable {

		long[] tmpAry = { 10, 10, 20, 40, 40, 40, 45, 50, 50 };

		Arrays.sort(tmpAry);
		tmpAry = Aryva.distinct(tmpAry);

		O.l("distinctAry=");
		O.l(tmpAry);

	}
}