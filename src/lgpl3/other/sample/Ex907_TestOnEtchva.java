package lgpl3.other.sample;

import lgpl3.o.O;
import lgpl3.prime64.Etchva;
import lgpl3.prime64.thr.Moon;
import lgpl3.prime64.thr.ThrToEtch;

/**
 * The test on to mark primes.<br/>
 * The test on to mark primes.
 *
 * @version 2021/09/02_22:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex907_TestOnEtchva" >Ex907_TestOnEtchva.java</a>
 *
 */
public class Ex907_TestOnEtchva extends Thread {

	public static void main(String[] sAry) {

		long n1 = 1;
		long n2 = 22_345_678_900L;

		Moon<ThrToEtch> moon = Etchva.etchWThr(n1, n2, 10);

		moon.otherThr.run();

		if (n2 == Etchva.$MAX_TEST_N_OVER_1_ARY32)

			O.eq(moon.totalP, 5_586_502_342L);
		else
			O.eq(moon.totalP, 980_867_749);

		///////////////////////////////////////

		n1 = 22_345_678_900L;
		n2 = Etchva.$MAX_TEST_N_OVER_1_ARY32;
		moon = Etchva.etchWThr(n1, n2, 10);

		moon.otherThr.run();

	}
}