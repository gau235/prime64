package lgpl3.other.sample;

import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Seq;
import lgpl3.o.ary.Seq32;

/**
 * To print the array.<br/>
 * To print the array.
 *
 * @version 2020/02/24_08:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex155_PrintArr" >Ex155_PrintArr.java</a>
 *
 */
public class Ex155_PrintArr {

	public static void main(String[] sAry) throws Throwable {

		Arr<String> arrOfS = new Arr<String>(String.class);

		arrOfS.a("A");
		arrOfS.a("HHH");
		arrOfS.a("C");

		O.l(arrOfS.toStr());
		O.l("==========");

		Seq seq = new Seq();
		seq.a(5);
		seq.a(5);
		seq.a(7);

		O.l(seq.toStr());
		O.l("==========");

		Seq32 seq32 = new Seq32();
		seq32.a(15);
		seq32.a(5);
		seq32.a(75);

		O.l(seq32.toStr());
		O.l("==========");

		O.l(new int[] { 52, 3, 8 });

	}

}