package lgpl3.comb.thr;

import lgpl3.b32.B32va;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.ary.Seq;
import lgpl3.o.thr.ThrWBox;

/**
 * 從 1 全相異數列中取出 n 個數.<br/>
 * To pick several numbers from a list of distinct numbers.
 *
 * @version 2020/09/27_21:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=ThrToPWNEqK" >ThrToPWNEqK.java</a>
 *
 * @see ThrToPWNEqK
 *
 * @see ThrCnkBySpareB64
 *
 * @see ThrToDCirc
 */
public class ThrToPWNEqK extends ThrWBox<Seq> {

	// private static final Class<?> THIS = ThrToPWNEqK.class;

	public static final int $6 = B64W6.$6;

	public int baseB32;

	public int count32;

	public int myIdx;

	public PeerByThrToPWNEqK peer;

	public static int maxRowForHtml = Integer.MAX_VALUE;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrToPWNEqK() {

		super.box = new Seq();
	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public void colRecur(int keptB32, long prefix) {

		if (baseB32 == 0 && peer.isToStopAll) {

			return;
		}

		int rmdB32 = baseB32 & ~keptB32;

		prefix <<= $6;

		// if (B32va.countOf1(rmdB32) == 1)
		if ((rmdB32 & -rmdB32) == rmdB32) {

			if (count32++ < maxRowForHtml) {

				box.a(prefix | B32va.log2NPlus1(rmdB32));
			}

			return;

		}

		int lowest1;
		do {

			colRecur(keptB32 | (lowest1 = (rmdB32 & -rmdB32)), prefix | B32va.log2NPlus1(lowest1));

		} while ((rmdB32 &= ~lowest1) != 0b0);

	}

	@Override
	public void run() {

		if (peer.isToStopAll) {

			return;
		}

		colRecur(0b0, 0b0L);

		synchronized (peer.keyToSyn) {

			peer.sum += count32;

			if (box.i != 0) {

				peer.ary2D.a(box.trim().ary);
			}

			if (peer.seq32AftC.i == 0) {

				peer.b32ForAllRunningThr &= ~(0b1 << myIdx);

				return;

			}

			//////////////////////////////
			ThrToPWNEqK thr = new ThrToPWNEqK();

			synchronized (peer.seq32AftC.keyToSyn) {

				thr.baseB32 = peer.seq32AftC.cutTail();
			}

			// O.l("seq32AftC.iLen=" + peer.seq32AftC.iLen , THIS);

			thr.myIdx = myIdx;

			thr.peer = peer;

			// O.l("myIdx=" + myIdx , THIS);

			thr.start();
			////////////////////////////

		}
	}
}
