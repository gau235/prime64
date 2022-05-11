package lgpl3.comb.sample;

import lgpl3.comb.Cnk;
import lgpl3.o.O;

/**
 * 組合總數.<br/>
 * To collect all C(n,k)
 *
 * @version 2022/04/07_15:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex211_ColFrom1ToN" >Ex211_ColFrom1ToN.java</a>
 *
 */
public class Ex211_ColFrom1ToN {

	public static void main(String[] sAry) throws Throwable {

		int n = 5;

		int[] ary32 = Cnk.colFrom1ToN(n);

		O.l(Cnk.strByAryOfB32As2Pow(ary32));

		O.l("len=" + O.eq(ary32.length, ((0b1 << n) - 1)));

	}
}
