package lgpl3.eqDiv.sample;

import lgpl3.eqDiv.Fr64;
import lgpl3.o.O;
import lgpl3.o.time.T64;

/**
 * 分數運算.<br/>
 * The easy test for fraction.
 *
 * @version 2019/05/27_10:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=SP06_Fraction" >SP06_Fraction.java</a>
 *
 */
public class SP06_Fraction {

	public static void main(String[] sAry) throws Throwable {

		Fr64 ans = Fr64.$0;

		long t0 = O.t();

		for (int i = 1; i != 10; i++)

			ans = ans.add(new Fr64(1, i));

		O.l(ans.toStr());
		// O.l("=" + ans.toBigDecimal());
		O.l("t=" + T64.difInF32Sec(t0));

	}

}