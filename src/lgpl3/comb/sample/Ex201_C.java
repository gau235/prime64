package lgpl3.comb.sample;

import lgpl3.comb.Cnk;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.keyNV.KAry32V32;

/**
 * 組合.<br/>
 * Combination.
 *
 * @version 2022/04/28_21:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex201_C" >Ex201_C.java</a>
 *
 */
public class Ex201_C {

	public static void main(String[] sAry) throws Throwable {

		int n = 3;
		int k = 2;

		KAry32V32 retKV = new KAry32V32(Cnk.int64(n, k));

		Cnk.colRecur(0b1 << n, k, 0b0, 0b1, retKV);

		O.l(Cnk.strByAryOfB32As2Pow(retKV.k));

		O.l("len=" + O.eq(retKV.v, Cnk.int64(n, k)));

		O.l("B.n32=" + B.n32);
		B.n32 = 0;

	}
}
