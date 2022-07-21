package lgpl3.other.uI.thr;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import lgpl3.o.O;
import lgpl3.o.str.SByN;
import lgpl3.o.thr.ThrWBox;
import lgpl3.o.time.T64;
import lgpl3.other.uI.MyConfPane;
import lgpl3.other.uI.MyStrva;
import lgpl3.other.uI.MySue;
import lgpl3.other.uI.MySwingva;
import lgpl3.other.uI.Recva;
import lgpl3.prime64.Miner;
import lgpl3.prime64.Ranger;
import lgpl3.prime64.thr.Marker;

/**
 * To monitor.<br/>
 * To monitor.
 *
 * @version 2020/02/01_17:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=FanOfMarker" >FanOfMarker.java</a>
 *
 * @see FanOfThrToMine
 *
 * @see FanOfMarker
 *
 * @see FanOfEtchva
 */
public final class FanOfMarker extends ThrWBox<Marker> {

	private static final Class<?> THIS = FanOfMarker.class;

	public final long oriN1;

	public final long oriN2;

	public JProgressBar myPctBar;

	public JTextArea myTxt; // 繞過去, 直接打中要害: 資料結構

	public Document myDoc;

	public final Recva recva = new Recva();

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public FanOfMarker(long n1, long n2, Marker marker) {

		oriN1 = n1;
		oriN2 = n2;

		super.box = marker;

		myPctBar = MySwingva.progrBarEP0;
		myTxt = MySwingva.txtareaEP0;
		myDoc = MySwingva.docEP0;

		start(); // auto start

	}

	/**
	 * 回報 Marker 執行的情況.<br/>
	 * To report the proceeding of Marker.
	 */
	@Override
	public void run() {

		myTxt.insert(MyStrva.genHeadStr().toString(), 0);

		int curDiv32 = box.div32;

		StringBuilder str;

		int curDocLen;

		do {

			try {
				sleep(duration32);

			} catch (InterruptedException interruptedEx) {

				interruptedEx.printStackTrace();
			}

			if (box.div32 > curDiv32)
				myPctBar.setValue(Ranger.calcuPct((curDiv32 = box.div32), box.sqrt32OfTailNPlus1));

			str = new StringBuilder(O.defLenForStr);
			str.append(O.f(box.div32)).append(" / ").append(O.f(box.sqrt32OfTailNPlus1));
			str.append(O.strForIndent).append(String.format(SByN.REGEX_FLOAT, T64.difInF32Sec(tStart))).append(" s");
			str.append(O.C_A_L);

			if ((curDocLen = myDoc.getLength()) > MySue.BOUND32_TO_CLEAR_TXT) {

				if (O.isDev)
					O.l("clear doc, len=" + O.f(curDocLen), THIS);

				try {
					myDoc.remove(0, curDocLen);

				} catch (BadLocationException badLocationEx) {

					badLocationEx.printStackTrace();
				}

				curDocLen = 0;

			}

			try {
				myDoc.insertString(0, str.toString(), null);

			} catch (BadLocationException badLocationEx) {

				badLocationEx.printStackTrace();
			}

			// myTxt.insert(str.toString(), 0);
			myTxt.setCaretPosition(0);

		} while (box.isAlive());

		///////////////// timeCost//////
		O.l("timeCost=" + T64.difInF32Sec(tStart), THIS);
		///////////////// timeCost//////

		//////////////////////////////////////////// set recva
		recva.n1 = oriN1;
		recva.n2 = oriN2;
		recva.numOfThr = 1;

		recva.totalP = box.countP(oriN1, oriN2);
		recva.f32TimeCost = T64.difInF32Sec(tStart);

		recva.note = new StringBuilder(O.defLenForStr).append("EP").append(SByN.pad0D2(1));
		recva.tmpObj = O.SYS_USER_DOT_NAME;

		/////////////////////////////////////////////////
		MySue.checkErrNSend(this, recva.totalP);
		/////////////////////////////////////////////////

		O.l("timeAftCountP=" + T64.difInF32Sec(tStart), THIS);

		StringBuilder strDone = new StringBuilder(O.defLenForStr);
		strDone.append(O.f(recva.n1)).append(" ~ ").append(O.f(recva.n2));
		strDone.append(O.strForIndent).append(O.f(recva.totalP)).append(" p").append(O.strForIndent);
		strDone.append(String.format(SByN.REGEX_FLOAT, recva.f32TimeCost)).append(" s").append(O.C_A_L);

		MySue.insertRowIntoTable(MySue.toAryOfStrForRowInTable(recva));

		myPctBar.setValue(Ranger.$100_INT32);

		myTxt.insert(strDone.toString(), 0);

		////////////////////////////////////////////////////

		if (O.IS_HIGH_XMX && (oriN1 == 1L) && (oriN2 <= Miner.$MAX_TAIL_N_FOR_GROW_MY_ARY_OF_P) &&

				Miner.isAnyPFromGtMaxPInMyAryPToN(oriN2)) {

			Miner.setMyAryOfP(box.retrieveP(oriN1, oriN2), THIS);

		}

		O.l("timeCostAll=" + T64.difInF32Sec(tStart), THIS);

		if (MyConfPane.CHK_TO_REPEAT_MP_EP.isSelected() && (++MySue.pctWhileRepeatEP) < 100) {

			if (oriN2 >= 123_456_789) {

				box.box = null;
				myTxt = null;

				O.gc(THIS);

			}

			try {
				sleep(duration32 << 1);

			} catch (InterruptedException interruptedEx) {

				interruptedEx.printStackTrace();
			}

			myPctBar.setValue(0);

			MySue.doEtchPrimeNRepeat(oriN1, oriN2, 1);

		}
	}
}
