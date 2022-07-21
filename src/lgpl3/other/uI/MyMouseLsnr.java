package lgpl3.other.uI;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.str.SByN;
import lgpl3.other.uI.thr.MyThrToSaveEP;
import lgpl3.other.uI.thr.MyThrToSaveMP;
import lgpl3.prime64.Goldbach;
import lgpl3.prime64.Miner;

/**
 * 我的滑鼠監聽人.<br/>
 * My MouseListener.
 *
 * @version 2021/09/12_19:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=MyMouseLsnr" >MyMouseLsnr.java</a>
 *
 */
public class MyMouseLsnr implements MouseListener {

	private static final Class<?> THIS = MyMouseLsnr.class;

	// public static Component componentViaEvent;

	public static int tmp32;

	/**
	 * DIY.<br/>
	 * DIY.
	 */
	public static void diy() {

		MySwingva.txtfldDiy1.setText(O.Z);

		long n = SByN.df(MySwingva.txtfldDiy0.getText().trim()), tmp;

		if ((((int) n) & 0b1) == 0b0)

			MySwingva.txtfldDiy1.setText((tmp = Goldbach.decompo(n)) + " + " + (n - tmp));
		else
			MySwingva.txtfldDiy1.setText((tmp = Miner.easyDecompo(n)) + " * " + (n / tmp));

		O.l("diy", THIS);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		tmp32 = e.getButton();

		if (tmp32 == 1)
			actByMouse(e.getComponent()); // O.l("e.getModifiers()=" + e.getModifiers(), THIS);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	/**
	 * To act by mouse.<br/>
	 * To act by mouse.
	 */
	@SuppressWarnings("deprecation")
	public static void actByMouse(Component component) {

		// O.l("component=" + component, THIS);

		if (component == MySwingva.btnMP0) {

			if (MySwingva.btnMP0.isEnabled()) { // synchronized (KEY_TO_SYN) {

				if (MySue.myThrToSaveMP.isAlive()) {

					O.l("MySue.myThrToSaveMP=" + MySue.myThrToSaveMP, THIS);

					return;

				}

				MySue.doMinePrime();

			}

			return;

		}

		if (component == MySwingva.btnEP0) {

			if (MySwingva.btnEP0.isEnabled()) {

				if (MySue.myThrToSaveEP.isAlive()) {

					O.l("myThrToSaveEP alive", THIS);

					return;

				}

				MySue.doEtchPrime();

			}

			return;

		}

		if (component == MySwingva.btnMP1 || component == MySwingva.btnEP1) {

			MySue.stopNClear(component);

			return;

		}

		if (component == MySwingva.btnMP3) {

			if (!MySwingva.btnMP3.isEnabled())
				return;

			MySwingva.btnMP3.setEnabled(B.O);

			MySue.myThrToSaveMP = new MyThrToSaveMP();

			return;

		}

		if (component == MySwingva.btnMP4) {

			if (!MySwingva.btnMP3.isEnabled()) {

				MySue.myThrToSaveMP.stop();

				MySwingva.btnMP3.setText(MySue.MY_TXT_SAVE);
				MySwingva.btnMP3.setEnabled(B.I);

			}

			return;

		}

		if (component == MySwingva.btnEP3) {

			if (!MySwingva.btnEP3.isEnabled())
				return;

			MySwingva.btnEP3.setEnabled(B.O);

			MySue.myThrToSaveEP = new MyThrToSaveEP();

			return;

		}

		if (component == MySwingva.btnEP4) {

			if (!MySwingva.btnEP3.isEnabled()) {

				MySue.myThrToSaveEP.stop();

				MySwingva.btnEP3.setText(MySue.MY_TXT_SAVE);
				MySwingva.btnEP3.setEnabled(B.I);

			}

			return;

		}

		if (component == MySwingva.btnRec3) {

			MySue.writeDatToFile();

			return;

		}

		if (component == MySwingva.btnDiy0) {

			diy();

			return;

		}

		if (component == MySwingva.btnDiy1) {

			return;

		}

		if (component == MySwingva.txtfldMP5) {

			MySwingva.tabbedPane0.setSelectedIndex(0);

			return;

		}

		if (component == MySwingva.txtfldEP5) {

			// O.l("sourceObj=" + sourceObj , THIS);
			MySwingva.tabbedPane0.setSelectedIndex(1);

			return;

		}

		if (component == MySwingva.txtfldDiy5) {

			MySwingva.tabbedPane0.setSelectedIndex(2);

			return;

		}

		if (component == MySwingva.txtfldConf5) {

			MySwingva.tabbedPane0.setSelectedIndex(3);

			return;

		}

		if (component == MySwingva.txtfldRec5) {

			MySwingva.tabbedPane0.setSelectedIndex(4);

			return;

		}
	}
}
