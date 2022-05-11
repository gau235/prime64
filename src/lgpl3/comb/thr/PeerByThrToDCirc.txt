package lgpl3.comb.thr;

import lgpl3.b32.B32va;
import lgpl3.comb.Cnk;
import lgpl3.comb.DCirc;
import lgpl3.comb.b64W6.B64W6;
import lgpl3.comb.filter.SetWBst32;
import lgpl3.o.O;
import lgpl3.o.ary.Ary2D;
import lgpl3.o.ary.Seq32;
import lgpl3.o.time.T64;
import lgpl3.other.jsp.ThrToSendHttpErr;

/**
 * The thread with box.<br/>
 * The XOR cost much time.
 *
 * @version 2020/09/19_10:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=PeerByThrToDCirc" >PeerByThrToDCirc.java</a>
 *
 */
public class PeerByThrToDCirc extends Thread {

	// private static final Class<?> THIS = PeerByThrToDCirc.class;

	/**
	 * 數字的格式, 如 1,993.123<br/>
	 * The regex for float.
	 */
	public static final String REGEX_FLOAT = PeerByThrToDWNEqK.REGEX_FLOAT;

	public int n;

	public int k;

	public int numOfThr;

	/**
	 * 用於多執行緒的同步.<br/>
	 * For synchronizing.
	 */
	public final Object keyToSyn = new Object();

	public long sum;

	public Seq32 seq32AftC;

	public int b32ForAllRunningThr;

	public Ary2D ary2D = new Ary2D();

	public boolean isToStopAll;

	public int duration = 600;

	@Override
	public void run() {

		final long t0 = System.currentTimeMillis();

		ThrToDCirc.maxRowForHtml = 1; // fuck
		ThrToDCirc thr;

		final long ans = DCirc.int64(n, k);
		final float f32Denominator = ans / 100F;

		float f32CostT;

		if (n == k) {

			seq32AftC = new Seq32(new int[] { ~(-0b1 << n) });

		} else {

			seq32AftC = new Seq32();
			Cnk.colRecur((0b1 << n), k, 0b0, 0b1, seq32AftC);

			seq32AftC.rev(); // important

		}

		O.l("C(" + n + "," + k + ")=" + O.f(seq32AftC.iLen));
		// O.l("numOfThr=" + numOfThr + " iLen=" + seq32AftC.iLen);

		if (numOfThr > seq32AftC.iLen) {

			O.x("numOfThr=" + numOfThr + " iLen=" + seq32AftC.iLen);
		}

		b32ForAllRunningThr = (0b1 << numOfThr) - 0b1;
		// O.l("b32ForAllRunningThr=" + B32va.str16(b32ForAllRunningThr));

		// to start some thread /////////////////////////////////

		int idx = 0;
		int baseB32;
		do {

			thr = new ThrToDCirc();

			thr.n = n;
			thr.k = k;

			synchronized (seq32AftC.keyToSyn) { // sum=0M 102.2%

				baseB32 = seq32AftC.cutTail();
			}

			thr.baseB32 = baseB32;
			thr.lowestV = B32va.log2NPlus1(baseB32 & -baseB32);
			thr.setWBst32 = new SetWBst32(B32va.biLog2NPlus1(baseB32));

			thr.myIdx = idx;

			thr.peer = this;

			thr.start();

		} while (++idx != numOfThr);

		O.l("numOfRemainedThr=" + O.f(seq32AftC.iLen));

		do {

			// O.l("doneAry=" + Arrays.toString(doneAry));

			try {

				sleep(duration);

			} catch (InterruptedException interruptedEx) {

				interruptedEx.printStackTrace();
			}

			if (isToStopAll) {

				return;
			}

			O.l("sum=" + O.f((sum >>> 20)) + "M" + O.S9 + String.format(REGEX_FLOAT, (sum / f32Denominator)) + "%");

		} while (b32ForAllRunningThr != 0b0);

		if (isToStopAll) {

			return;
		}

		O.eq(sum, ans);

		f32CostT = T64.difInF32Sec(t0);

		// ary2D.sort(CompaForAryOfB64W6.COMPA);

		long[] theAry = ary2D.mergeIn1Ary();

		if (O.isDev) {

			for (int i = 0; i != theAry.length && i < 100; i++) {

				O.l(B64W6.strByVCellMinus1AftRevBySAry(theAry[i], O.S_ARY_A_Z));
			}
		}

		O.l("Dc(" + n + "," + k + ")=" + f32CostT + "s" + O.S9 + "thr=" + numOfThr + O.S9 + "mem=" + O.f(O.totalMem()) + O.S9 + "sum="
				+ O.f(sum));

		/////////////////////////////

		if (O.isDev && f32CostT > 30)
			new ThrToSendHttpErr(("Dc(" + n + "," + k + ")=" + f32CostT), ("thr=" + numOfThr));

		/////////////////////////////

	}
}