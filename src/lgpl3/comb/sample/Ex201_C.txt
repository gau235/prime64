package lgpl3.comb.sample;

import lgpl3.comb.Cnk;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Seq32;

/**
 * 組合.<br/>
 * Combination.
 *
 * @version 2020/09/28_21:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex201_C" >Ex201_C.java</a>
 *
 */
public class Ex201_C {

	public static void main(String[] sAry) throws Throwable {

		int n = 3;
		int k = 2;

		Seq32 seq32 = new Seq32();

		Cnk.colRecur(0b1 << n, k, 0b0, 0b1, seq32);
		int[] ary32 = seq32.trim().ary32;

		StringBuilder str = Cnk.strByAryOfB32As2Pow(ary32);

		O.l("str=" + O.L + str);

		O.eq(ary32.length, Cnk.int64(n, k));

		O.l("len=" + ary32.length);

		O.l("Adder32.y32=" + B.n32);
		B.n32 = 0;

	}
}
