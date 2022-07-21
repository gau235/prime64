package lgpl3.prime64.thr;

import lgpl3.o.O;
import lgpl3.o.thr.ThrWBox;
import lgpl3.o.time.T64;
import lgpl3.prime64.Etchva;

/**
 * 監測用執行緒, 監測工作中的執行緒.<br/>
 * The thread to peek.
 *
 * @version 2021/09/02_22:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=PeerByThrToEtch" >PeerByThrToEtch.java</a>
 *
 * @see ThrToMine
 */
public class PeerByThrToEtch extends ThrWBox<Moon<ThrToEtch>> {

	private static final Class<?> THIS = PeerByThrToEtch.class;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public PeerByThrToEtch(Moon<ThrToEtch> moon) {

		box = moon;
	}

	@Override
	public void run() {

		ThrToEtch[] aryOfThr = box.aryOfThr;

		do {

			try {
				sleep(duration32);

			} catch (InterruptedException interruptedEx) {

				interruptedEx.printStackTrace();
			}

			O.l("myN1=" + O.f(aryOfThr[0].myN1) + " costT=" + T64.difInF32Sec(tStart), THIS);

		} while (O.isAnyAlive(aryOfThr));

		StringBuilder str = new StringBuilder(O.defLenForStr);

		str.append("totalP=" + O.f(box.totalP)).append(" p").append(O.C_A_L);

		O.l(str.append("costT=").append(T64.difInF32Sec(tStart)).append(" s"), THIS);

		if (O.isDev)
			O.l("RANGE32=" + O.f(Etchva.RANGE32), THIS);

	}
}
