package lgpl3.prime64.sample;

import java.util.concurrent.ThreadLocalRandom;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.prime64.Goldbach;

/**
 * Goldbach's Conjecture.<br/>
 * Goldbach's Conjecture.
 *
 * @version 2021/08/27_23:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex90_Goldbach" >Ex90_Goldbach.java</a>
 *
 */
public class Ex90_Goldbach {

	public static void main(String[] sAry) throws Throwable {

		int n = ThreadLocalRandom.current().nextInt(54321);
		// n |= 0b1;

		if ((n & 0b1) == 0b0) {

			long p1 = Goldbach.conj(n);
			O.l(n + "=" + p1 + O.S32 + O.S85 + O.S32 + (n - p1));

		} else {

			long[] ary = Goldbach.conjOdd(n);
			O.l(n + "=" + ary[0] + " + " + ary[1] + " + " + ary[2]);
			O.l("count=" + B.n32);

		}
	}
}
