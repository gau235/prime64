package lgpl3.other.sample;

import java.util.concurrent.ThreadLocalRandom;

import lgpl3.eqDiv.Fr64;
import lgpl3.o.O;

/**
 * 分數運算.<br/>
 * An easy test for fraction.
 *
 * @version 2021/03/01_12:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex908_TestOnFraction" >Ex908_TestOnFraction.java</a>
 *
 */
public class Ex908_TestOnFraction {

	public static void main(String[] sAry) throws Throwable {

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		for (int i = 0; i != 50; i++) {

			long nu1 = rnd.nextInt(1000);
			long de1 = nu1 * rnd.nextInt(10) + 1;
			long nu2 = rnd.nextInt(2000);

			nu2 = -nu2;
			long de2 = de1 * rnd.nextInt(100) + 1;

			O.l("nu1=" + nu1);
			O.l("de1=" + de1);
			O.l("nu2=" + nu2);
			O.l("de2=" + de2);

			Fr64 fr641 = new Fr64(nu1, de1);
			Fr64 fr642 = new Fr64(nu2, de2);

			O.l("fr641=" + fr641);
			O.l("fr642=" + fr642);

			Fr64 fr643 = fr641.add(fr642);
			Fr64 fr644 = fr641.sub(fr642);

			Fr64 fr647 = fr642.add(fr641);
			Fr64 fr648 = fr642.sub(fr641);

			O.eq(fr643.neg().compareTo(fr647.neg()), 0);
			O.eq(fr644.compareTo(fr648.neg()), 0);

		}
	}
}
