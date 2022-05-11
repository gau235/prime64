package lgpl3.comb.thr;

import lgpl3.b32.B32va;
import lgpl3.o.ary.Seq;
import lgpl3.o.thr.ThrWBox;

/**
 * 全錯排.<br/>
 * 即 n 個人排成一列後解散再排成一列, 沒有人排在自己原先的位置的方法數.<br/>
 * D(n)=nD(n-1)+(-1)^n<br/>
 * 0, 1, 2, 9, 44, 265, 1854,...<br/>
 * To return the number of ways that n people line up then dismiss, and<br/>
 * line up again but nobody is at the previous position.
 *
 * @version 2020/09/29_20:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=ThrToDWNEqK" >ThrToDWNEqK.java</a>
 *
 * @see ThrToPByB64As2Pow
 *
 * @see ThrToCBySpareB64As2Pow
 *
 * @see ThrToDWNEqK
 *
 * @see ThrToDCirc
 *
 * @see ThrToPCircAsDnk
 */
public class ThrToDWNEqK extends ThrWBox<Seq> {

	// private static final Class<?> THIS = ThrToDWNEqK.class;

	public int n;

	public int baseB32;

	public int count32;

	public int myIdx;

	public PeerByThrToDWNEqK peer;

	public static int maxRowForHtml = Integer.MAX_VALUE;

	public static final int $6 = 6;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrToDWNEqK() {

		super.box = new Seq();
	}

	/**
	 * 回傳全錯排.<br/>
	 * 即 n 個人排成一列後解散再排成一列, 沒有人排在自己原先的位置的方法數.<br/>
	 * D(n)=nD(n-1)+(-1)^n<br/>
	 * 0, 1, 2, 9, 44, 265, 1854,...<br/>
	 * To return the number of ways that n people line up then dismiss, and<br/>
	 * line up again but nobody is at the previous position.
	 */
	public void colRecur(int keptB32, int b32ForI_th, long prefix) {

		if (peer.isToStopAll) {

			return;
		}

		int baseExKept = baseB32 & ~keptB32;
		// important: baseExKept can not be: baseB32^i_th1Lowest1(baseB32, i_th)
		// such as: ABCD^BC (prefix) = AD, but AD can not do ^ C (the i_th1Lowest1)

		prefix <<= $6;

		// if (b32ForI_th == b32ForK) {
		if ((baseExKept & -baseExKept) == baseExKept) { // n equals k, only 1 bit remained

			if (baseExKept != b32ForI_th && (count32++ < maxRowForHtml)) {

				box.a(prefix | B32va.log2NPlus1(baseExKept));
			}

			return;

		}

		baseExKept &= ~b32ForI_th;

		b32ForI_th = -(b32ForI_th << 1) & baseB32;
		b32ForI_th &= -b32ForI_th;

		int lowest1;
		do {

			colRecur(keptB32 | (lowest1 = (baseExKept & -baseExKept)), b32ForI_th, prefix | B32va.log2NPlus1(lowest1));

		} while ((baseExKept &= ~lowest1) != 0b0);

	}

	@Override
	public void run() {

		if (peer.isToStopAll) {

			return;
		}

		// O.l("myIdx=" + myIdx , THIS);
		colRecur(0b0, baseB32 & -baseB32, 0b0L);

		synchronized (peer.keyToSyn) {

			peer.sum += count32;

			if (box.iLen != 0) {

				// peer.ary2D.a(box.trim().sort().ary); // maybe do not need to sort
				peer.ary2D.a(box.trim().ary);

			}

			if (peer.seq32AftC.iLen == 0) {

				peer.b32ForAllRunningThr &= ~(0b1 << myIdx);

				return;

			}

			//////////////////////////////
			ThrToDWNEqK thr = new ThrToDWNEqK();
			thr.n = n;

			synchronized (peer.seq32AftC.keyToSyn) {

				thr.baseB32 = peer.seq32AftC.cutTail();
			}
			// O.l("seq32AftC.iLen=" + peer.seq32AftC.iLen , THIS);

			thr.peer = peer;

			thr.myIdx = myIdx;
			// O.l("myIdx=" + myIdx , THIS);

			// O.l("isDaemon=" + thr.isDaemon() , THIS);
			thr.start();
			////////////////////////////

		}
	}
}
