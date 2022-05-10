package lgpl3.comb.thr;

import lgpl3.b32.B32va;
import lgpl3.comb.Cnk;
import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Seq;
import lgpl3.o.keyNV.KAry32V32;
import lgpl3.o.thr.ThrWBox;

/**
 * 環狀排列且全錯排.<br/>
 * Derangement and circular permutation.
 *
 * @version 2021/06/02_21:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=ThrToPCircAsDnk" >ThrToPCircAsDnk.java</a>
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
public class ThrToPCircAsDnk extends ThrWBox<Seq> {

	// private static final Class<?> THIS = ThrToPCircAsDnk.class;

	public int n;

	public int kMinus1;

	public int kOrKMinus1;

	public int baseB32;

	public long sortedB64W6;

	public long tmp;

	public int count32;

	public int myIdx;

	public PeerByThrToPCircAsDnk peer;

	public static int maxRowForHtml = Integer.MAX_VALUE;

	public static final int $6 = 6;

	/**
	 * 0b11_1111<br/>
	 * 0b11_1111
	 */
	public static final int MASK32 = 0b11_1111;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrToPCircAsDnk() {

		super.box = new Seq();
	}

	/**
	 * To check.<br/>
	 * To check.
	 */
	public long ifDerAftRotateToHead(long b64W6) {

		boolean isDebug = (b64W6 == 0b000001_000011_000010_000100);
		isDebug = B.O;

		final long oldB64W6 = b64W6;

		long mySortedB64W6;

		int xToRotate = kMinus1;
		int dToShift;

		do {

			tmp = b64W6;
			mySortedB64W6 = sortedB64W6;

			if (isDebug) {

				O.l("" + B64W6.strByVCellAftRev(tmp) + " from " + B64W6.strByVCellAftRev(oldB64W6) + O.L
						+ B64W6.strByVCellAftRev(mySortedB64W6) + " sorted");

				O.l("" + B64W6.str24(tmp) + O.L + B64W6.str24(mySortedB64W6) + " sorted");
				O.l("idx0=" + (((int) tmp) & MASK32));

			}

			dToShift = kOrKMinus1;

			loopToShift: {

				do {

					if ((((int) tmp) & MASK32) == (((int) mySortedB64W6) & MASK32)) {

						if (isDebug)
							O.l("break=" + (char) (64 + (((int) tmp) & MASK32)));

						break loopToShift; // matches

					}

					tmp >>>= $6;
					mySortedB64W6 >>>= $6;

				} while (--dToShift != 0);

				return b64W6; // not match any cell, success

			} // loopToShift:

			// rotateR
			b64W6 = (((b64W6 & MASK32) << (kMinus1 * $6)) | (b64W6 >>> $6));

			if (isDebug)
				O.l("rotateR=" + B64W6.strByVCellAftRev(b64W6));
			// end rotateR

			// rotateL
//			long aaa = B64W6.MASK1_1TO_6 << (kMinus1 * B64W6.$6);
//			long bbb = ~aaa;
//
//			aaa = aaa & b64W6;
//			aaa = aaa >>> (kMinus1 * B64W6.$6);
//
//			b64W6 = bbb & b64W6;
//			b64W6 = b64W6 << B64W6.$6;
//			b64W6 = b64W6 | aaa;
//
//			O.l("rotateL=" + B64W6.str24(b64W6));
			// end rotateL

		} while (--xToRotate != 0);

		return 0b0L;

	}

	/**
	 * 環狀排列且全錯排.<br/>
	 * Derangement and circular permutation.
	 */
	public void colRecurWNEqK(int keptB32, long prefix) {

		if (baseB32 == 0b0 && peer.isToStopAll)
			return;

		int rmdB32 = (~keptB32 & baseB32);
		// O.l("rmdB32=" + O.L + B64W6.str24(rmdB32));

		prefix <<= $6;

		if ((-rmdB32 & rmdB32) == rmdB32) {

			long tmpB64 = (prefix | B32va.log2NPlus1(rmdB32));
			// O.l("check=" + abc(tmpB64));

			if ((tmpB64 = ifDerAftRotateToHead(tmpB64)) != 0b0L) {

				// O.l("add=" + abc(tmpB64) + O.L);

				if (count32++ < maxRowForHtml)
					box.a(tmpB64);

			}

			return;

		}

		int lowest1;
		do
			colRecurWNEqK((keptB32 | (lowest1 = (-rmdB32 & rmdB32))), (prefix | B32va.log2NPlus1(lowest1)));

		while ((rmdB32 = (~lowest1 & rmdB32)) != 0b0);

	}

	/**
	 * 環狀排列且全錯排.<br/>
	 * Derangement and circular permutation.
	 */
	public void col(int n, int k) {

		this.n = n;
		this.kMinus1 = k - 1;
		this.kOrKMinus1 = k;

		if ((k & 0b1) == 0b0 && O.isDev) // 發現: 偶數可以少做一次
			kOrKMinus1 = kMinus1;

		int[] ary32;

		////////////////////////
		final int len;
		if (n == k) {

			ary32 = new int[] { ~(-0b1 << n) };
			len = 1;

		} else {

			KAry32V32 kAry32V32 = new KAry32V32(Cnk.int64(n, k));
			Cnk.colRecur((0b1 << n), k, 0b0, 0b1, kAry32V32);

			ary32 = kAry32V32.ary32;
			len = kAry32V32.int32;

		}

		////////////////////////

		int keptB32;
		for (int idx = 0; idx != len; idx++) {

			baseB32 = ary32[idx];
			sortedB64W6 = B64W6.toB64W6ByLog2NPlus1(baseB32);
			// sortedB64W6 = B64W6.toDescB64W6ByLog2NPlus1(baseB32);

			colRecurWNEqK(keptB32 = (-baseB32 & baseB32), B32va.log2NPlus1(keptB32));

		}
	}

	@Override
	public void run() {

		if (peer.isToStopAll)
			return;

		// O.l("myIdx=" + myIdx , THIS);

		int keptB32;
		colRecurWNEqK(keptB32 = (-baseB32 & baseB32), B32va.log2NPlus1(keptB32));

		synchronized (peer.keyToSyn) {

			peer.sum += count32;

			if (box.iLen != 0)
				peer.ary2D.a(box.trim().sort().ary);

			if (peer.seq32AftC.iLen == 0) {

				peer.b32ForAllRunningThr &= ~(0b1 << myIdx);

				return;

			}

			// start a new thr
			ThrToPCircAsDnk thr = new ThrToPCircAsDnk();

			thr.n = n;
			thr.kMinus1 = kMinus1;
			thr.kOrKMinus1 = kOrKMinus1;

			thr.baseB32 = peer.seq32AftC.cutTail();

			thr.sortedB64W6 = B64W6.toB64W6ByLog2NPlus1(thr.baseB32);

			thr.myIdx = myIdx;

			thr.peer = peer;

			// O.l("isDaemon=" + thr.isDaemon() , THIS);
			thr.start();
			// end start a new thr

		}
	}
}