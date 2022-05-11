package lgpl3.other.uI;

import java.awt.Component;

import javax.swing.JProgressBar;
import javax.swing.UIManager;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.other.uI.thr.FanOfEtchva;
import lgpl3.other.uI.thr.FanOfMarker;
import lgpl3.other.uI.thr.FanOfThrToMine;
import lgpl3.prime64.Etchva;
import lgpl3.prime64.Ranger;
import lgpl3.prime64.thr.Marker;

/**
 * @version 2021/09/06_09:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=MySue_G" >MySue_G.java</a>
 *
 * @see MySue_L
 */
public abstract class MySue_G extends MySue_C {

	private static final Class<?> THIS = MySue_G.class;

	/**
	 * 執行 mine prime 動作.<br/>
	 * To mine prime.
	 *
	 * @see #stopNClear(Component)
	 */
	public static void doMinePrime() {

		try {

			actBef(KEY_MP0);

			long[] ary = getAryOfParam(KEY_MP0);

			long n1 = O.gte(ary[0], 1);
			long n2 = O.gte(ary[1], 1);
			int numOfThr = (int) O.gte(ary[2], 1);

			checkArgBefMine(n1, n2, numOfThr);

			moonMP = mineWThr(n1, n2, numOfThr);

			moonMP.otherThr = new FanOfThrToMine(moonMP);

		} catch (Throwable throwable) {

			throwable.printStackTrace();
			MySwingva.txtareaMP0.insert(throwable.toString() + O.L, 0);

		}
	}

	/**
	 * 執行 mine prime 動作.<br/>
	 * To mine prime.
	 *
	 * @see #stopNClear(Component)
	 */
	public static void doMinePrimeNRepeat(long n1, long n2, int numOfThr) {

		try {

			moonMP = mineWThr(n1, n2, numOfThr);

			moonMP.otherThr = new FanOfThrToMine(moonMP);

		} catch (Throwable throwable) {

			throwable.printStackTrace();
			MySwingva.txtareaMP0.insert(throwable.toString() + O.L, 0);

		}
	}

	/**
	 * 執行 mark prime 動作.<br/>
	 * To mark prime.
	 *
	 * @see #stopNClear(Component)
	 */
	public static void doEtchPrime() {

		try {

			actBef(KEY_EP0);

			long[] ary = getAryOfParam(KEY_EP0);

			long n1 = O.gte(ary[0], 1);
			long n2 = O.gte(ary[1], 1);
			int numOfThr = (int) O.gte(ary[2], 1);

			Ranger.checkBetween(n2, n1, Etchva.$MAX_TEST_N_OVER_1_ARY32);

			if (numOfThr == 1) {

				myMarker = new Marker(n1, n2, B.O);
				myMarker.start();

				fanOfMarker = new FanOfMarker(n1, n2, myMarker);

			} else
				fanOfEtchva = new FanOfEtchva(Etchva.etchWThr(n1, n2, numOfThr));

		} catch (Throwable throwable) {

			throwable.printStackTrace();
			MySwingva.txtareaEP0.insert(throwable.toString() + O.L, 0);

		}
	}

	/**
	 * 執行 mark prime 動作.<br/>
	 * To mark prime.
	 *
	 * @see #stopNClear(Component)
	 */
	public static void doEtchPrimeNRepeat(long n1, long n2, int numOfThr) {

		try {

			if (numOfThr == 1) {

				myMarker = new Marker(n1, n2, B.O);
				myMarker.start();

				fanOfMarker = new FanOfMarker(n1, n2, myMarker);

			} else
				fanOfEtchva = new FanOfEtchva(Etchva.etchWThr(n1, n2, numOfThr));

		} catch (Throwable throwable) {

			throwable.printStackTrace();
			MySwingva.txtareaEP0.insert(throwable.toString() + O.L, 0);

		}
	}

	/**
	 * 後置動作<br/>
	 * To act after the action.
	 *
	 * @see #actBef(int)
	 */
	public static void actAftStopped(int key32) {

		MySwingva.MAP_OF_TXTFLD.get(key32).setEditable(B.I);
		MySwingva.MAP_OF_TXTFLD.get(key32 + 1).setEditable(B.I);

		MySwingva.MAP_OF_BTN.get(key32).setEnabled(B.I);

		JProgressBar progrBar = MySwingva.MAP_OF_PROGR_BAR.get(key32);
		progrBar.setValue(0);

		///////////////////////////////////////////////

		UIManager.put("ProgressBar.selectionBackground", MySwingva.COLOR_TXT_BACKGROUND); // 變成保護色
		progrBar.updateUI();

		///////////////////////////////////////////////

		MySwingva.MAP_OF_TXTAREA.get(key32).setText(O.Z);

	}

	/**
	 * To stop.<br/>
	 * To stop.
	 */
	public static void stopNClear(Component component) {

		if (component == MySwingva.btnMP1) {

			if (O.isDev)
				O.l("begin stopNClearMP", THIS);

			MyConfPane.CHK_TO_REPEAT_MP_EP.setSelected(B.O);

			if (moonMP != null) {

				FanOfThrToMine fanOfThrToMine = (FanOfThrToMine) moonMP.otherThr;

				fanOfThrToMine.myPctBar = null; // not to show

				fanOfThrToMine.myTxt = null; // not to show
				fanOfThrToMine.myDoc = null; // gc

				O.stopAllAlive(fanOfThrToMine, moonMP.aryOfThr);

			}

			actAftStopped(KEY_MP0);

			formatTxtOfN(MySwingva.txtfldMP0, MySwingva.txtfldMP1);

			if (O.isDev)
				O.l("end stopNClear", THIS);

			return;

		}

		if (component == MySwingva.btnEP1) {

			if (O.isDev)
				O.l("begin stopNClear", THIS);

			MyConfPane.CHK_TO_REPEAT_MP_EP.setSelected(B.O);

			if (fanOfMarker != null) {

				fanOfMarker.myPctBar = null; // not to show
				fanOfMarker.myTxt = null; // not to show

				O.stopAllAlive(fanOfMarker, myMarker);

				myMarker.box = null; // gc 注意 int[] 陣列不容易被設定為 null

			}

			if (fanOfEtchva != null) { // 並行, 且不可用: else if (fanOfEtchva != null)

				fanOfEtchva.myPctBar = null; // not to show
				fanOfEtchva.myTxt = null; // not to show

				O.stopAllAlive(fanOfEtchva, fanOfEtchva.box.aryOfThr);

			}

			actAftStopped(KEY_EP0);

			formatTxtOfN(MySwingva.txtfldEP0, MySwingva.txtfldEP1);

			if (O.isDev)
				O.l("end stopNClear", THIS);

			return;

		}
	}
}
