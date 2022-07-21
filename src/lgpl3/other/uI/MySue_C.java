package lgpl3.other.uI;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.UIManager;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Seq;
import lgpl3.o.str.SByN;

/**
 * @version 2019/08/02_21:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=MySue_C" >MySue_C.java</a>
 *
 * @see MySue_G
 */
public abstract class MySue_C extends MySue_A {

	// private static final Class<?> THIS = MySue_C.class;

	/**
	 * To format text in JTextField.<br/>
	 * To format text in JTextField.
	 */
	public static void formatTxtOfN(JTextField txtfld, JTextField otherTxtfld) {

		String txt = txtfld.getText().trim();

		try {
			txtfld.setText(O.f(SByN.df(txt)).toString());

		} catch (NumberFormatException numberFormatEx) {

			throw numberFormatEx;
		}

		///////////////////////////////////////////////

		txt = otherTxtfld.getText().trim();

		try {
			otherTxtfld.setText(O.f(SByN.df(txt)).toString());

		} catch (NumberFormatException numberFormatEx) {

			throw numberFormatEx;
		}
	}

	/**
	 * 前置動作<br/>
	 * To act before the action.
	 *
	 * @see MySue#actAftStopped(int)
	 */
	public static void actBef(int key32) {

		JTextField txtfld0 = MySwingva.MAP_OF_TXTFLD.get(key32);
		JTextField txtfld1 = MySwingva.MAP_OF_TXTFLD.get(key32 + 1);

		txtfld0.setEditable(B.O);
		// txtfld0.requestFocusInWindow();
		txtfld1.setEditable(B.O);

		// txtfld1.selectAll();

		MySwingva.MAP_OF_BTN.get(key32).setEnabled(B.O);

		///////////////////////////////////////////////

		UIManager.put("ProgressBar.selectionBackground", Color.BLACK); // 變成黑色
		MySwingva.MAP_OF_PROGR_BAR.get(key32).updateUI();

		///////////////////////////////////////////////

	}

	/**
	 * To get the param<br/>
	 * To get the param.
	 */
	public static long[] getAryOfParam(int key32) {

		Seq seq = new Seq();

		try {

			long n1 = SByN.df(MySwingva.MAP_OF_TXTFLD.get(key32).getText().trim());
			long n2 = SByN.df(MySwingva.MAP_OF_TXTFLD.get(key32 + 1).getText().trim());
			int numOfThr = Integer.parseInt(MySwingva.MAP_OF_BTN.get(key32).getText());

			if (n1 > n2) {

				long tmp = n1;
				n1 = n2;
				n2 = tmp;

			}

			// O.lD("n1=" + n1, THIS);

			seq.a(n1);
			seq.a(n2);
			seq.a(numOfThr);

		} catch (NumberFormatException numberFormatEx) {

			throw numberFormatEx;
		}

		return seq.ary;

	}
}
