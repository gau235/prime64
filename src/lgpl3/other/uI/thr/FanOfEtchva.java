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
import lgpl3.prime64.Ranger;
import lgpl3.prime64.thr.Moon;
import lgpl3.prime64.thr.ThrToEtch;

/**
 * To monitor.<br/>
 * To monitor.
 *
 * @version 2020/02/01_17:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=FanOfEtchva" >FanOfEtchva.java</a>
 *
 * @see FanOfThrToMine
 *
 * @see FanOfMarker
 *
 * @see FanOfEtchva
 */
public final class FanOfEtchva extends ThrWBox<Moon<ThrToEtch>> {

	private static final Class<?> THIS = FanOfEtchva.class;

	public final long oriN1;

	public final long oriN2;

	public final long n2MinusN1;

	public JProgressBar myPctBar;

	public JTextArea myTxt; // 繞過去, 直接打中要害: 資料結構

	public Document myDoc;

	public final Recva recva = new Recva();

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public FanOfEtchva(Moon<ThrToEtch> moon) {

		box = moon;

		oriN1 = moon.oriN1;
		oriN2 = moon.oriN2;

		n2MinusN1 = oriN2 - oriN1;

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

		ThrToEtch headThr;
		long curN1;

		String sTimeCost;
		StringBuilder str;

		int curDocLen;
		do {

			headThr = box.aryOfThr[0];
			curN1 = headThr.myN1;

			try {
				sleep(duration32);

			} catch (InterruptedException interruptedEx) {

				interruptedEx.printStackTrace();
			}

			if (headThr.myN1 > curN1)
				myPctBar.setValue(Ranger.calcuPct((curN1 = headThr.myN1), oriN1, n2MinusN1));

			sTimeCost = String.format(SByN.REGEX_FLOAT, T64.difInF32Sec(tStart));
			str = new StringBuilder(O.defLenForStr);

			str.append(O.C32).append(O.f(curN1 >>> 20)).append(" M / ").append(O.f(oriN2 >>> 20)).append(" M");

			str.append(O.C32).append(O.C32).append(O.C32).append(O.C32).append(sTimeCost).append(" s").append(O.C_A_L);

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

			myTxt.insert(str.toString(), 0);
			myTxt.setCaretPosition(0);

		} while (O.isAnyAlive(box.aryOfThr));

		//////////////////////////////////////////// set recva
		recva.n1 = oriN1;
		recva.n2 = oriN2;
		recva.numOfThr = box.numOfThr;

		recva.totalP = box.totalP;
		recva.f32TimeCost = T64.difInF32Sec(tStart);

		recva.note = new StringBuilder(O.defLenForStr).append("EP").append(SByN.pad0D2(box.numOfThr));
		recva.tmpObj = O.SYS_USER_DOT_NAME;

		////////////////////////////////////////////////////

		StringBuilder strDone = new StringBuilder(O.defLenForStr);
		strDone.append(O.C32).append(O.f(recva.n1)).append(O.C32).append(O.C126).append(O.C32).append(O.f(recva.n2));
		strDone.append(O.C32).append(O.C32).append(O.C32).append(O.f(recva.totalP)).append(O.C32).append(O.C112);
		strDone.append(O.C32).append(O.C32).append(O.C32);
		strDone.append(String.format(SByN.REGEX_FLOAT, recva.f32TimeCost)).append(O.C32).append(O.C115).append(O.C_A_L);

		myTxt.insert(strDone.toString(), 0);
		myPctBar.setValue(Ranger.$100_INT32);

		MySue.insertRowIntoTable(MySue.toAryOfStrForRowInTable(recva));

		if (MyConfPane.CHK_TO_REPEAT_MP_EP.isSelected() && (++MySue.pctWhileRepeatEP) < 100) {

			if (oriN2 >= 123_456_789) {

				// marker.box = null;
				myTxt = null;

				O.gc(THIS);

			}

			try {
				sleep(duration32 << 1);

			} catch (InterruptedException interruptedEx) {

				interruptedEx.printStackTrace();
			}

			myPctBar.setValue(0);

			MySue.doEtchPrimeNRepeat(oriN1, oriN2, box.numOfThr);

		}
	}
}
