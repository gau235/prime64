package lgpl3.shuffle.sample;

import lgpl3.o.O;
import lgpl3.shuffle.Shuffler;

/**
 * To shuffle the array.<br/>
 * To shuffle the array.
 *
 * @version 2022/06/15_10:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex88_PickK" >src</a>
 *
 */
public class Ex88_PickK {

	public static void main(String[] sAry) throws Throwable {

		sAry = new String[] { "A", "B", "C", "D", "E", "F", };

		int k = 3;

		O.l("sAry=");
		O.l(sAry);

		sAry = Shuffler.pickK(sAry, k);

		O.l("pick " + k + "=");
		O.l(sAry);

	}
}