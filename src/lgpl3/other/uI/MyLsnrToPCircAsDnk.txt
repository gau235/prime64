package lgpl3.other.uI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import lgpl3.comb.thr.PeerByThrToPCircAsDnk;
import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 我的滑鼠監聽人.<br/>
 * My MouseListener.
 *
 * @version 2020/05/23_10:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=MyLsnrToPCircAsDnk" >MyLsnrToPCircAsDnk.java</a>
 *
 * @see MainToDnk
 */
public class MyLsnrToPCircAsDnk implements MouseListener {

	private static final Class<?> THIS = MyLsnrToPCircAsDnk.class;

	public static Object objViaSource;

	public static PeerByThrToPCircAsDnk peer;

	/**
	 * The String array for the commands.<br/>
	 * The String array for the commands.
	 */
	public static final String[] S_ARY_CMD_CLS = MyLsnrToDnk.S_ARY_CMD_CLS;

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		objViaSource = e.getSource();

		if (e.getButton() == 1) {

			if (objViaSource == MainToDnk.btn01) {

				if (peer != null && peer.isToStopAll == B.O)
					return;

				int n = Integer.parseInt(MainToDnk.txtfld01.getText().trim());
				int k = Integer.parseInt(MainToDnk.txtfld02.getText().trim());
				int numOfThr = Integer.parseInt(MainToDnk.btn01.getText());

				if (k > 10 || numOfThr > O.MY_ARY32_OF_CPU_THR[0])
					O.x();

				peer = new PeerByThrToPCircAsDnk();
				peer.n = n;
				peer.k = k;
				peer.numOfThr = numOfThr;

				peer.start();

				MainToDnk.btn01.setEnabled(B.O);

				return;

			}

			if (objViaSource == MainToDnk.btn02) {

				peer.isToStopAll = B.I; // just write one row, keep it simple

				try {
					new ProcessBuilder(S_ARY_CMD_CLS).inheritIO().start().waitFor();

				} catch (Throwable throwable) {

					throwable.printStackTrace();
				}

				O.l("stop", THIS);

				MainToDnk.btn01.setEnabled(B.I);

				return;

			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
