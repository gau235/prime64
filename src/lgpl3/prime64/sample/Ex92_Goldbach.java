package lgpl3.prime64.sample;

import java.util.concurrent.ThreadLocalRandom;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.prime64.Goldbach;

/**
 * Goldbach's Conjecture.
 *
 * @version 2022/05/27_23:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex92_Goldbach" >src</a>
 *
 */
public class Ex92_Goldbach {

	public static void main(String[] sAry) throws Throwable {

		long n = ThreadLocalRandom.current().nextInt(4321);
		long p1, ary[];

		// n |= 0b1;

		if ((n & 0b1) == 0b0)

			O.l(n + " = " + (p1 = Goldbach.decompo(n)) + " + " + (n - p1));
		else {

			ary = Goldbach.decompoOdd(n);

			O.l(n + " = " + ary[0] + " + " + ary[1] + " + " + ary[2]);
			O.l("count=" + B.n32);

		}
	}
}
