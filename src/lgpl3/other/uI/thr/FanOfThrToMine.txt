package lgpl3.other.uI.thr;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import lgpl3.comb.filter.CompaForAryOfPrime;
import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.o.str.SByN;
import lgpl3.o.thr.ThrWBox;
import lgpl3.o.time.T64;
import lgpl3.other.jsp.ThrToSendHttpErr;
import lgpl3.other.uI.MySwingva;
import lgpl3.other.uI.MyConfPane;
import lgpl3.other.uI.MyStrva;
import lgpl3.other.uI.MySue;
import lgpl3.other.uI.Recva;
import lgpl3.prime64.PrimeAry2D;
import lgpl3.prime64.Ranger;
import lgpl3.prime64.thr.Moon;
import lgpl3.prime64.thr.ThrToMine;

/**
 * 本類別質數隊伍迷.<br/>
 * The fan to peek the PrimeAry2D.
 *
 * @version 2020/02/06_11:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=FanOfThrToMine" >FanOfThrToMine.java</a>
 *
 * @see FanOfThrToMine
 *
 * @see FanOfMarker
 *
 * @see FanOfEtchva
 */
public class FanOfThrToMine extends ThrWBox<Moon<ThrToMine>> {

	private static final Class<?> THIS = FanOfThrToMine.class;

	public final long n2MinusN1;

	public JProgressBar myPctBar;

	public JTextArea myTxt;

	public Document myDoc;

	public final Recva recva = new Recva();

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public FanOfThrToMine(Moon<ThrToMine> moon) {

		box = moon;

		n2MinusN1 = moon.oriN2 - moon.oriN1;

		myTxt = MySwingva.txtareaMP0;
		myDoc = MySwingva.docMP0;

		myPctBar = MySwingva.progrBarMP0;

		MyStrva.isToShowEveryPrime = (box.numOfThr <= MySue.MAX_NUM_OF_THR_TO_SHOW_EVERY_PRIME);

		start(); // auto start

	}

	/**
	 * 回報 minePrime 方法對 PrimeAry2D 作用的情況.<br/>
	 * To report the influence on PrimeAry2D during the minePrime method proceeding.
	 */
	@Override
	public void run() {

		// myTxt.setText(O.Z); // for to repeat
		myTxt.insert(MyStrva.genHeadStr().toString(), 0);

		PrimeAry2D pAry2D = box.primeAry2D;

		final Object otherKey = pAry2D.keyToSyn;

		int fromIdx = 0;
		int toIdx;

		CompaForAryOfPrime compaForAryOfPrime = CompaForAryOfPrime.COMPA;

		long curTailP;
		long tailPForPct = 0L;

		StringBuilder str;

		int curLenOfDoc;
		do {

			try {
				sleep(duration32);

			} catch (InterruptedException interruptedEx) {

				interruptedEx.printStackTrace();
			}

			synchronized (otherKey) {

				if ((toIdx = pAry2D.iLen) > fromIdx)
					pAry2D.sort(fromIdx, (fromIdx = toIdx), compaForAryOfPrime);

			}

			if ((n2MinusN1 != 0L) && (curTailP = pAry2D.tailP()) > tailPForPct)
				myPctBar.setValue(Ranger.calcuPct((tailPForPct = curTailP), box.oriN1, n2MinusN1));

			str = MyStrva.genSegFromPrimeAry2D(pAry2D, T64.difInF32Sec(tStart));

			if ((curLenOfDoc = myDoc.getLength()) > MySue.BOUND32_TO_CLEAR_TXT) {

				if (O.isDev)
					O.l("clear doc, len=" + O.f(curLenOfDoc), THIS);

				try {
					myDoc.remove(0, curLenOfDoc);

				} catch (BadLocationException badLocationEx) {

					badLocationEx.printStackTrace();
				}

				curLenOfDoc = 0;

			}

			myTxt.insert(str.toString(), 0);
			myTxt.setCaretPosition(0);

		} while ((pAry2D.idxViewed != (toIdx - 1)) || O.isAnyAlive(box.aryOfThr));

		recva.totalP = pAry2D.totalP();
		recva.f32TimeCost = T64.difInF32Sec(tStart);

		myPctBar.setValue(Ranger.$100_INT32);

		///////////////////////////////////// set recva

		recva.n1 = box.oriN1;
		recva.n2 = box.oriN2;
		recva.numOfThr = box.numOfThr;

		recva.note = new StringBuilder(O.DEF_CAPACITY32_FOR_STR).append("MP").append(SByN.pad0D2(box.numOfThr));

		recva.tmpObj = O.SYS_USER_DOT_NAME;

		/////////////////////////////////////////////////

		Arr<CharSequence> arrOfCharSeq = MySue.genArrAsRowInTable(recva);

		MySue.insertRowIntoTable(arrOfCharSeq);

		myTxt.insert(MyStrva.genAllThrTerminatedStr((StringBuilder) arrOfCharSeq.arr[0], (StringBuilder) arrOfCharSeq.arr[1],
				(StringBuilder) arrOfCharSeq.arr[3], (StringBuilder) arrOfCharSeq.arr[4]).toString(), 0);

		if (O.isDev)
			O.l("PrimeAry2D len=" + O.f(pAry2D.iLen), THIS);

		/////////////////////////////////////////////////

		if (MyConfPane.CHK_TO_SEND_ERR.isSelected())
			new ThrToSendHttpErr("numOfThr=" + recva.numOfThr, O.SYS_USER_DOT_NAME);

		/////////////////////////////////////////////////

		if (MyConfPane.CHK_TO_REPEAT_MP_EP.isSelected() && (++MySue.pctWhileRepeatMP) < 100) {

			if (box.oriN2 >= 123_456_789) {

				box.primeAry2D = null;
				myTxt = null;

				O.RUNTIME.gc();

				if (O.isDev)
					O.l("gc", THIS);

			}

			try {
				sleep(duration32 << 1);

			} catch (InterruptedException interruptedEx) {

				interruptedEx.printStackTrace();
			}

			myPctBar.setValue(0); // for to repeat

			MySue.doMinePrimeNRepeat(box.oriN1, box.oriN2, box.numOfThr);

		}
	}
}
