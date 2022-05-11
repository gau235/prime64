package lgpl3.other.sample;

import java.util.concurrent.ThreadLocalRandom;

import lgpl3.o.O;
import lgpl3.o.str.SW;
import lgpl3.o.time.T64;
import lgpl3.other.jsp.Jsp;
import lgpl3.other.jsp.ThrToSendHttpErr;
import lgpl3.prime64.Miner;
import lgpl3.prime64.PrimeAry2D;
import lgpl3.prime64.thr.Moon;
import lgpl3.prime64.thr.ThrToMine;

/**
 * 啟動多執行緒找質數.<br/>
 * To mine prime with threads.
 *
 * @version 2021/09/02_22:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex983_TestCurMaxNToTest" >
 *          Ex983_TestCurMaxNToTest.java</a>
 *
 */
public class Ex983_TestCurMaxNToTest {

	private static final Class<?> THIS = Ex983_TestCurMaxNToTest.class;

	public static void main(String[] sAry) throws Throwable {

		final int numOfThr = O.MY_ARY32_OF_CPU_THR[O.MY_ARY32_OF_CPU_THR.length >>> 1];

		final int nOfTest = 10;

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		Moon<ThrToMine> moonMP;

		long n1, n2;
		for (int idx = 0; idx != nOfTest; idx++) {

			n1 = Miner.curMaxNToTest() - rnd.nextInt(2_000);
			n2 = Miner.curMaxNToTest();

			O.l("n1=" + O.f(n1) + O.L + "n2=" + O.f(n2), THIS);

			moonMP = Miner.mineWThr(n1, n2, numOfThr);

			moonMP.otherThr.run();

			PrimeAry2D headPrimeAry2D = moonMP.primeAry2D;
			int ansMP = headPrimeAry2D.totalP();

			/////////////////////////////////////////////////////////////

			int ansCP = Miner.countP(n1, n2);

			if (ansMP != ansCP) {

				SW errS = new SW();
				errS.lineWr = Jsp.L;

				errS.l(T64.timeStr() + O.S32 + THIS);
				errS.l("n1=" + Jsp.L + n1);
				errS.l("n2=" + Jsp.L + n2);
				errS.l("ansMP=" + Jsp.L + ansMP);
				errS.l("ansCP=" + Jsp.L + ansCP);

				new ThrToSendHttpErr(errS.str, O.SYS_USER_DOT_NAME);

				O.x("err:" + O.L + "n1=" + O.f(n1) + O.L + "n2=" + O.f(n2) + O.L + "ansMP=" + O.f(ansMP) + O.L + "ansCP=" + O.f(ansCP));

			}
		}
	}
}
