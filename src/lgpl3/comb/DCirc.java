package lgpl3.comb;

import lgpl3.comb.thr.PeerByThrToPCircAsDnk;
import lgpl3.comb.thr.ThrToDCirc;
import lgpl3.comb.thr.ThrToPCircAsDnk;
import lgpl3.o.O;

/**
 * @version 2020/03/30_09:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=DCirc" >DCirc.java</a>
 *
 * @see Dnk
 */
public abstract class DCirc extends DCirc_A {

	// private static final Class<?> THIS = DCirc.class;

	/**
	 * If passes test.<br/>
	 * If passes test.
	 */
	public static void test() {

		final int endN = 10;

		ThrToPCircAsDnk thrToPCircAsDnk;
		ThrToDCirc thrToDCirc;
		PeerByThrToPCircAsDnk peerByThrToPCircAsDnk;

		for (int n = 2; n <= endN; n++) {

			for (int k = 2; k <= n; k++) {

				thrToPCircAsDnk = new ThrToPCircAsDnk();
				thrToPCircAsDnk.col(n, k);

				// O.l("ThrToPCircAsDnk.maxRowForHtml=" + ThrToPCircAsDnk.maxRowForHtml , THIS);

				O.eq(thrToPCircAsDnk.box.i, int64(n, k));

				thrToDCirc = new ThrToDCirc();
				thrToDCirc.col(n, k);

				// O.l("n=" + n , THIS);
				// O.l("k=" + k , THIS);

				O.eq(thrToDCirc.box.i, int64(n, k));

			}
		}

		for (int n = 2; n <= endN; n++) {

			for (int k = 2; k <= n; k++) {

				peerByThrToPCircAsDnk = new PeerByThrToPCircAsDnk();
				peerByThrToPCircAsDnk.n = n;
				peerByThrToPCircAsDnk.k = k;
				peerByThrToPCircAsDnk.numOfThr = 1;
				peerByThrToPCircAsDnk.duration = 110;
				peerByThrToPCircAsDnk.run();

				// O.l("n=" + n , THIS);
				O.eq(peerByThrToPCircAsDnk.sum, int64(n, k));

			}
		}
	}
}
