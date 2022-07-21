package lgpl3.other.sample;

import lgpl3.eqDiv.Fr64;
import lgpl3.o.O;
import lgpl3.o.time.T64;

/**
 * 畢達哥拉斯 Pythagoras 三元數.<br/>
 * Pythagorean triple.
 *
 * @version 2022/05/16_15:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex222_PythagoreTriple" > Ex222_PythagoreTriple.java</a>
 *
 */
public class Ex222_PythagoreTriple {

	public static void main(String[] sAry) throws Throwable {

		// 5*5 (25-1)/2 (25+1)/2 => 5,12,13
		// 7*7 (49-1)/2 (49+1)/2 => 7,24,25
		// 9*9 (49-1)/2 (81+1)/2 => 9,40,41

		long t0 = O.t();

		int lower = 1, upper = 500, i1, i2, i3;

		for (i1 = lower; i1 < upper; i1++)

			for (i2 = i1 + 1; i2 < upper; i2++)

				for (i3 = i2 + 1; i3 < upper; i3++)

					if (Fr64.gcd(i1, i2) == 1L)

						if ((i1 * i1) + (i2 * i2) == (i3 * i3))

							O.l(new StringBuilder(O.defLenForStr).append(i1).append(O.STR_C44C32).append(i2).

									append(O.STR_C44C32).append(i3));

		O.l(T64.difInF32Sec(t0) + " s");

	}
}