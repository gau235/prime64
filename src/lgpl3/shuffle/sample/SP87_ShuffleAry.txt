package lgpl3.shuffle.sample;

import lgpl3.o.O;
import lgpl3.shuffle.Shuffler;

/**
 * To shuffle the array.<br/>
 * <br/>
 * To shuffle the array.
 * 
 * @version 2020/01/16_21:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=SP87_ShuffleAry" >SP87_ShuffleAry.java </a>
 * 
 */
public class SP87_ShuffleAry {

	public static void main(String[] sAry) throws Throwable {

		sAry = new String[] { "A", "B", "C", "D", "E", "F", };

		O.l("sAry=");
		O.l(sAry);
		sAry = Shuffler.shuffle(sAry);

		O.l();
		O.l("aft shuffle=");
		O.l(sAry);

	}

}