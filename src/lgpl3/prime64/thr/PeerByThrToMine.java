package lgpl3.prime64.thr;

import lgpl3.comb.filter.CompaForAryOfPrime;
import lgpl3.o.O;
import lgpl3.o.thr.ThrWBox;
import lgpl3.o.time.T64;
import lgpl3.prime64.PrimeAry2D;

/**
 * 監測用執行緒, 監測工作中的執行緒.<br/>
 * The thread to peek.
 *
 * @version 2020/03/24_21:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=PeerByThrToMine" >PeerByThrToMine.java</a>
 *
 * @see ThrToMine
 */
public class PeerByThrToMine extends ThrWBox<Moon<ThrToMine>> {

	private static final Class<?> THIS = PeerByThrToMine.class;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public PeerByThrToMine(Moon<ThrToMine> moon) {

		box = moon;
	}

	@Override
	public void run() {

		ThrToMine[] aryOfThr = box.aryOfThr;
		PrimeAry2D pAry2D = box.primeAry2D;

		StringBuilder str;

		do {

			try {
				sleep(duration32);

			} catch (InterruptedException interruptedEx) {

				interruptedEx.printStackTrace();
			}

			if (pAry2D.i != 0) {

				str = new StringBuilder(O.defLenForStr);
				str.append("len=" + O.f(pAry2D.i)).append(O.C_A_L);
				str.append("tailP=" + O.f(pAry2D.tailP())).append(O.C_A_L);

				O.l(str);

			}

		} while (O.isAnyAlive(aryOfThr));

		pAry2D.sort(CompaForAryOfPrime.COMPA);

		/////////////////////////////////////
		str = new StringBuilder(O.defLenForStr);
		str.append("len=" + O.f(pAry2D.i)).append(O.C_A_L);
		str.append("tailP=" + O.f(pAry2D.tailP()));

		O.l(str, THIS);
		/////////////////////////////////////

		str = new StringBuilder(O.defLenForStr);
		O.l(str.append(O.f(pAry2D.totalP())).append(" p").append(O.C_A_L).append(T64.difInF32Sec(tStart)).append(" s"), THIS);

		// O.lD("len=" + pAry2D.iLen, THIS);

	}
}
