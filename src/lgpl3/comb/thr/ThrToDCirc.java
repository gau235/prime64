package lgpl3.comb.thr;

import lgpl3.b32.B32va;
import lgpl3.comb.Cnk;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.comb.filter.SetWBst32;
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
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=ThrToDCirc" >ThrToDCirc.java</a>
 *
 * @see ThrPnkBySpareB64
 *
 * @see ThrCnkBySpareB64
 *
 * @see ThrToDWNEqK
 *
 * @see ThrToDCirc
 *
 * @see ThrToPCircAsDnk
 */
public class ThrToDCirc extends ThrWBox<Seq> {

	// private static final Class<?> THIS = ThrToDCirc.class;

	public int n;

	public int k;

	public int baseB32;

	public int lowestV;

	public static final int $6 = 6;

	public static final long MASK_1 = 0b1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111L;

	public SetWBst32 setWBst32; // filter

	public static int maxRowForHtml = Integer.MAX_VALUE;

	public int count32;

	public int myIdx;

	public PeerByThrToDCirc peer;

	public long tmp;

	public int tmp32;

	/**
	 * To rotate.<br/>
	 * To rotate.
	 */
	public long rotateMinVCellToHead(long b64W6) {

		// int iFound = 8; // 'A' must not be at index 9, so there is not necessary to check index 9

		if ((((int) b64W6) & B64W6.MASK32) == lowestV) { // first index is 0

			// return b64W6; // iFound = 0;

			return b64W6 >>> $6;

		} else if (((int) b64W6 & B64W6.MASK32_1_7TO_12) >>> 6 == lowestV) {

			// iFound = 1;
			// tmp32 = 6;

			return (((b64W6 & ~(MASK_1 << 6)) << (((k - 1) << 1) * 3)) | (b64W6 >>> 6)) >>> 6;

		} else if (((int) b64W6 & B64W6.MASK32_1_13TO_18) >>> 12 == lowestV) {

			// iFound = 2;
			// tmp32 = 12;

			return (((b64W6 & ~(MASK_1 << 12)) << (((k - 2) << 1) * 3)) | (b64W6 >>> 12)) >>> 6;

		} else if (((int) b64W6 & B64W6.MASK32_1_19TO_24) >>> 18 == lowestV) {

			// iFound = 3;
			// tmp32 = 18;

			return (((b64W6 & ~(MASK_1 << 18)) << (((k - 3) << 1) * 3)) | (b64W6 >>> 18)) >>> 6;

		} else if (((int) b64W6 & B64W6.MASK32_1_25TO_30) >>> 24 == lowestV) {

			// iFound = 4;
			// tmp32 = 24;

			return (((b64W6 & ~(MASK_1 << 24)) << (((k - 4) << 1) * 3)) | (b64W6 >>> 24)) >>> 6;

		} else if (((int) ((b64W6 & B64W6.MASK1_31TO_36) >>> 30)) == lowestV) {

			// iFound = 5;
			// tmp32 = 30;

			return (((b64W6 & ~(MASK_1 << 30)) << (((k - 5) << 1) * 3)) | (b64W6 >>> 30)) >>> 6;

		} else if (((int) ((b64W6 & B64W6.MASK1_37TO_42) >>> 36)) == lowestV) {

			// iFound = 6;
			// tmp32 = 36;

			return (((b64W6 & ~(MASK_1 << 36)) << (((k - 6) << 1) * 3)) | (b64W6 >>> 36)) >>> 6;

		} else if (((int) ((b64W6 & B64W6.MASK1_43TO_48) >>> 42)) == lowestV) {

			// iFound =7;
			// tmp32 = 42;

			return (((b64W6 & ~(MASK_1 << 42)) << (((k - 7) << 1) * 3)) | (b64W6 >>> 42)) >>> 6;

		}

		// iFound =8;
		// tmp32 = 48;

		return (((b64W6 & ~(MASK_1 << 48)) << (((k - 8) << 1) * 3)) | (b64W6 >>> 48)) >>> 6;

		// tmp32 = $6 * iFound; // assume iFound = 0 or 1 or little num

		// D,C,A,B
		// iFound=1
		// ~(MASK_1 << $6*1) is ~0b111111_111111_111111_000000;
		// b64W6 & ~0b111111_111111_111111_000000
		// 先產生 0,0,0,B 後 shift left 變 B,0,0,0
		// B,0,0,0 去聯集 0,D,C,A

		// return (((b64W6 & ~(MASK_1 << tmp32)) << ($6 * (k - iFound))) | (b64W6 >>> tmp32)) >>> $6;

	}

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrToDCirc() {

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
	public void colRecurWNEqK(int keptB32, int b32ForI_th, long prefix) {

		if (baseB32 == 0 && peer.isToStopAll) {

			return;
		}

		int baseExKept = baseB32 & ~keptB32;
		// important: baseExKept can not be: baseB32^i_th1Lowest1(baseB32, i_th)
		// such as: ABCD^BC (prefix) = AD, but AD can not do ^ C (the i_th1Lowest1)

		prefix <<= $6;

		if ((baseExKept & -baseExKept) == baseExKept) { // n equals k, only 1 bit remained

			if (baseExKept != b32ForI_th) {

				tmp = prefix | B32va.log2NPlus1(baseExKept);
				// O.l("tmp=" + B64W6.toStrByValMinus1InVCell(tmp, O.S_ARY_A_P));

				// if (treeMap.put(B64W6.rotateMaxToR(tmp, k), O.OBJ) == null) {
				if (setWBst32.addIfNotFound(rotateMinVCellToHead(tmp)) && (count32++ < maxRowForHtml)) {

					box.a(tmp);
				}
			}

			return;

		}

		baseExKept &= ~b32ForI_th;

		// i_th = B32va.next1BitL(baseB32, i_th);
		b32ForI_th = -(b32ForI_th << 1) & baseB32;
		b32ForI_th &= -b32ForI_th;

		int lowest1;
		do {

			colRecurWNEqK(keptB32 | (lowest1 = (baseExKept & -baseExKept)), b32ForI_th, prefix | B32va.log2NPlus1(lowest1));

		} while ((baseExKept &= ~lowest1) != 0b0);

	}

	public void col(int n, int k) { // collect

		this.n = n;
		this.k = k;

		int[] ary32 = Cnk.colRecur(n, k);

		for (int i = 0; i != ary32.length; i++) {

			baseB32 = ary32[i];
			lowestV = B32va.log2NPlus1(-baseB32 & baseB32);
			setWBst32 = new SetWBst32(B32va.biLog2NPlus1(baseB32));

			colRecurWNEqK(0b0, (-baseB32 & baseB32), 0b0L);

		}
	}

	@Override
	public void run() {

		if (peer.isToStopAll) {

			return;
		}

		colRecurWNEqK(0b0, baseB32 & -baseB32, 0b0L);

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
			ThrToDCirc thr = new ThrToDCirc();
			int baseB32;

			thr.n = n;
			thr.k = k;

			synchronized (peer.seq32AftC.keyToSyn) {

				baseB32 = peer.seq32AftC.cutTail();
			}

			thr.baseB32 = baseB32;
			thr.lowestV = B32va.log2NPlus1(baseB32 & -baseB32);
			thr.setWBst32 = new SetWBst32(B32va.biLog2NPlus1(baseB32));

			thr.peer = peer;

			thr.myIdx = myIdx;
			// O.l("myIdx=" + myIdx , THIS);

			// O.l("isDaemon=" + thr.isDaemon() , THIS);
			thr.start();
			////////////////////////////

		}
	}
}