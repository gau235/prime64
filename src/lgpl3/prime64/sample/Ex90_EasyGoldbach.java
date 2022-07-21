package lgpl3.prime64.sample;

import java.util.concurrent.ThreadLocalRandom;

import lgpl3.o.O;
import lgpl3.prime64.Goldbach;

/**
 * Goldbach's Conjecture.
 *
 * @version 2022/05/27_23:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex90_EasyGoldbach" >src</a>
 *
 */
public class Ex90_EasyGoldbach {

	public static void main(String[] sAry) throws Throwable {

		long n = ThreadLocalRandom.current().nextInt(4321);
		long p1, n2;

		int b32A, b32B;

		n = 1361;

		if ((n & 0b1) == 0b0)

			O.l(n + " = " + (p1 = Goldbach.decompo(n)) + " + " + (n - p1));
		else {

			n2 = Goldbach.easyDecompoOdd(n);

			b32A = ((int) (n2 & (-0b1)));
			b32B = ((int) ((n2 >>> 32) & (-0b1)));

			O.l(n + " = " + b32A + " + " + b32B + " + " + (n - b32A - b32B));

		}
	}
}
