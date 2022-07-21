package lgpl3.comb.sample;

import lgpl3.comb.Cnk;
import lgpl3.o.O;

/**
 * The identical equation (identity) of C.<br/>
 * The identical equation (identity) of C.
 *
 * @version 2020/02/09_17:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex208_TheEqOfC" >Ex208_TheEqOfC.java</a>
 *
 * @see Cnk
 */
public abstract class Ex208_TheEqOfC {

	public static void main(String[] sAry) throws Throwable {

		int n = 14;

		int k1 = 4;
		int k2 = 3;
		int k3 = 5;

		long ans1 = Cnk.int64(n, k1);
		long ans2 = Cnk.int64(n - k1, k2);
		long ans3 = Cnk.int64(n - k1 - k2, k3);

		O.l("ans=" + (ans1 * ans2 * ans3));

		// C(9,4)*C(5,3) == C(9,3)*C(6,4)

	}
}
