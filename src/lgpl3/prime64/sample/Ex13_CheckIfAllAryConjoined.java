package lgpl3.prime64.sample;

import lgpl3.o.O;
import lgpl3.o.time.T64;
import lgpl3.prime64.Miner;
import lgpl3.prime64.PrimeAry2D;
import lgpl3.prime64.thr.Moon;
import lgpl3.prime64.thr.PeerByThrToMine;
import lgpl3.prime64.thr.ThrToMine;

/**
 * To replace.<br/>
 * To replace.
 *
 * @version 2021/08/26_13:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex13_CheckIfAllAryConjoined" >
 *          Ex13_CheckIfAllAryConjoined.java</a>
 *
 * @see PeerByThrToMine
 */
public abstract class Ex13_CheckIfAllAryConjoined {

	public static void main(String[] sAry) throws Throwable {

		long t0 = O.t();

		final long n1 = 1;

		final long n2 = 123456789;
		final int numOfThr = 8;

		Moon<ThrToMine> moonMP = Miner.mineWThr(n1, n2, numOfThr);

		moonMP.otherThr.run();

		O.l("timeCost=" + T64.difInF32Sec(t0));
		O.l("primeAry2D.len=" + moonMP.primeAry2D.iLen);

		PrimeAry2D.checkIfAllAryConjoined(moonMP.primeAry2D);

		Miner.setOriAryOfP(moonMP.primeAry2D.mergeIn1Ary(), Ex13_CheckIfAllAryConjoined.class);

		O.l("timeCost=" + T64.difInF32Sec(t0));

	}
}
