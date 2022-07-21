package lgpl3.other.sample;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import lgpl3.o.O;

/**
 * 我的滑鼠監聽人.<br/>
 * My MouseListener.
 *
 * @version 2021/06/11_09:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex091_LsnrForMainFrame" >
 *          Ex091_LsnrForMainFrame.java</a>
 *
 * @see Ex090_MainFrame
 */
public class Ex091_LsnrForMainFrame implements MouseListener {

	private static final Class<?> THIS = Ex091_LsnrForMainFrame.class;

	public static Object tmpObj;

	public static void diy() {

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

		tmpObj = e.getSource();

		diy();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
