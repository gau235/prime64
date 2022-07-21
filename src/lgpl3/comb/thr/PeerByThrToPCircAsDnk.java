package lgpl3.comb.thr;

import lgpl3.comb.DCirc;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.O;
import lgpl3.o.ary.Ary2D;
import lgpl3.o.ary.Seq32;
import lgpl3.o.time.T64;
import lgpl3.other.jsp.ThrToSendHttpErr;

/**
 * The thread with box.<br/>
 * The XOR cost much time.
 *
 * @version 2021/06/05_14:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=PeerByThrToPCircAsDnk" >src</a>
 *
 */
public class PeerByThrToPCircAsDnk extends Thread {

	private static final Class<?> THIS = PeerByThrToPCircAsDnk.class;

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

		ThrToPCircAsDnk.maxRowForHtml = 1;
		ThrToPCircAsDnk thr;

		final long ans = DCirc.int64(n, k);
		final float f32Denominator = ans / 100F;

		float f32CostT;

		if (n == k)
			seq32AftC = new Seq32(new int[] { ~(-0b1 << n) });

		else {

			seq32AftC = new Seq32();
			PeerByThrToPWNEqK.colRecur((0b1 << n), k, 0b0, 0b1, seq32AftC);

			seq32AftC.rev(); // important

		}

		O.l("C(" + n + "," + k + ")=" + O.f(seq32AftC.i));
		// O.l("numOfThr=" + numOfThr + " iLen=" + seq32AftC.iLen);

		if (numOfThr > seq32AftC.i)
			O.x("numOfThr=" + numOfThr + " iLen=" + seq32AftC.i);

		b32ForAllRunningThr = ~(-0b1 << numOfThr);
		// O.l("b32ForAllRunningThr=" + B32va.str16(b32ForAllRunningThr));

		// to start some thread /////////////////////////////////
		int idx = 0;
		do {

			thr = new ThrToPCircAsDnk();

			thr.n = n;

			thr.kMinus1 = k - 1;
			thr.kOrKMinus1 = k;

			if ((k & 0b1) == 0b0 && O.isDev)
				thr.kOrKMinus1 = thr.kMinus1;

			synchronized (seq32AftC.keyToSyn) {

				thr.baseB32 = seq32AftC.cutTail();
			}

			thr.sortedB64W6 = B64W6.toB64W6ByLog2NPlus1(thr.baseB32);

			thr.myIdx = idx;

			thr.peer = this;

			thr.start();

		} while (++idx != numOfThr);

		O.l("numOfRemainedThr=" + seq32AftC.i + O.S9 + THIS);

		do {

			try {

				sleep(duration);

			} catch (InterruptedException interruptedEx) {

				interruptedEx.printStackTrace();
			}

			if (isToStopAll)
				return;

			O.l("sum=" + O.f((sum >>> 20)) + "M" + O.S9 + String.format(REGEX_FLOAT, (sum / f32Denominator)) + "%");

		} while (b32ForAllRunningThr != 0b0);

		if (isToStopAll)
			return;

		O.eq(sum, ans);

		f32CostT = T64.difInF32Sec(t0);

		// ary2D.sort(CompaForAryOfB64W6.COMPA);

		long[] theAry = ary2D.mergeIn1Ary();

		for (int i = 0; i != theAry.length && i < 100; i++)
			O.l(B64W6.strByVCellMinus1AftRevBySAry(theAry[i], O.S_ARY_A_Z));

		O.l("PcD(" + n + "," + k + ")=" + f32CostT + "s" + O.S9 + "thr=" + numOfThr);

		/////////////////////////////

		if (O.isDev && f32CostT > 10)
			new ThrToSendHttpErr(("PcD(" + n + "," + k + ")=" + f32CostT), ("thr=" + numOfThr));

		/////////////////////////////

	}
}