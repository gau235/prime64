package lgpl3.other.sample;

import java.util.concurrent.ThreadLocalRandom;

import lgpl3.o.O;
import lgpl3.prime64.GuessFromGauss;

/**
 * To guess the number of primes.<br/>
 * To guess the number of primes.
 *
 * @version 2018/04/07_12:03:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex984_GuessTotalP" >Ex984_GuessTotalP.java</a>
 *
 */
public class Ex984_GuessTotalP {

	public static void main(String[] sAry) throws Throwable {

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		for (int idx = 0; idx != 20; idx++) {

			final long n1 = rnd.nextInt(400) + 1;
			final long n2 = 923_456_789 + rnd.nextInt(2_000_000);

			long g1 = GuessFromGauss.guessTotalPNRetInt32(n1, n2);
			long g2 = (GuessFromGauss.guessTotalPNRetInt32(n1, n2) / 3) << 2;

			if (StrictMath.abs(g1 - g2) > 235)
				O.l(O.f(n1) + " ~ " + O.f(n2) + O.L + "g1=" + O.f(g1) + O.L + "g2=" + O.f(g2), Ex984_GuessTotalP.class);

		}
	}
}