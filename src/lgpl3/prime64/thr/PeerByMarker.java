package lgpl3.prime64.thr;

import lgpl3.o.O;
import lgpl3.o.thr.ThrWBox;
import lgpl3.o.time.T64;

/**
 * 監測 Marker 執行緒, 監測工作中的執行緒.<br/>
 * The thread to peek at Marker.
 *
 * @version 2021/09/02_22:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=PeerByMarker" >PeerByMarker.java</a>
 *
 */
public class PeerByMarker extends ThrWBox<Marker> {

	private static final Class<?> THIS = PeerByMarker.class;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public PeerByMarker(Marker marker) {

		box = marker;
	}

	@Override
	public void run() {

		do {

			try {
				sleep(duration32);

			} catch (InterruptedException interruptedEx) {

				interruptedEx.printStackTrace();
			}

			O.l(O.f(box.div32) + O.S32 + O.S47 + O.S32 + O.f(box.sqrt32OfTailNPlus1), THIS);

		} while (box.isAlive());

		// O.l("tailN=" + O.f(box.tailN), THIS);

		final long totalP = box.countP(1L, box.tailN);

		StringBuilder str = new StringBuilder(O.defLenForStr);

		str.append(O.C32).append(1).append(O.C32).append(O.C126).append(O.C32).append(O.f(box.tailN));
		str.append(O.C32).append(O.C32).append(O.C32);
		str.append(O.f(totalP)).append(O.C32).append(O.C112).append(O.C32).append(O.C32).append(O.C32);
		str.append(T64.difInF32Sec(tStart)).append(O.C32).append(O.C115);

		O.l(str, THIS);

	}
}
