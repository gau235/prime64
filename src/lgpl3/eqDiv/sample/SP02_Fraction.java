package lgpl3.eqDiv.sample;

import lgpl3.eqDiv.Fr64;
import lgpl3.o.O;

/**
 * 分數運算.<br/>
 * An easy test for fraction.
 *
 * @version 2022/05/17_10:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=SP02_Fraction" >SP02_Fraction.java</a>
 *
 * @see SP06_Fraction
 */
public class SP02_Fraction {

	public static void main(String[] sAry) throws Throwable {

		Fr64 f1 = new Fr64("1/2");
		Fr64 f2 = new Fr64("1/3");

		Fr64 f3 = f1.add(f2);

		O.l(f3.toStr());

	}
}