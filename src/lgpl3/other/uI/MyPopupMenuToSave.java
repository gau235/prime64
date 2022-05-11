package lgpl3.other.uI;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * My PopupMenu.<br/>
 * My PopupMenu.
 *
 * @version 2021/10/13_12:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=MyPopupMenuToSave" >MyPopupMenuToSave.java</a>
 *
 */
@SuppressWarnings("serial")
public class MyPopupMenuToSave extends JPopupMenu implements MouseListener {

	private static final Class<?> THIS = MyPopupMenuToSave.class;

	public final JMenuItem menuItemToOpenDir; // MP, EP, REC

	public static Component componentViaEvent;

	public int myIdx;

	public int tmp32;

	/**
	 * My PopupMenu.<br/>
	 * Constructor.
	 */
	public MyPopupMenuToSave(int int32) {

		// O.l("int32=" + int32, THIS);

		myIdx = int32;

		menuItemToOpenDir = ((int32 == MySue.KEY_REC0) ? new JMenuItem("*.log") : new JMenuItem("*.txt"));

		// setBorder(MySwingva.EMPTY_BORDER);
		// setPreferredSize(new Dimension(wOfButton, hOfButton));
		setBackground(MySwingva.COLOR_BACKGROUND);

		menuItemToOpenDir.setBackground(MySwingva.COLOR_BACKGROUND);
		// menuItemToOpenDir.setForeground(MySwingva.COLOR_BACKGROUND);
		// menuItemToOpenDir.setOpaque(B.I);
		menuItemToOpenDir.setFont(MySwingva.dynaFontDialog_1_26);
		// menuItemToOpenDir.setPreferredSize(new Dimension(100, 30));
		// menuItemToOpenDir.setEnabled(B.O);
		// menuItemToOpenDir.setArmed(B.O);

		menuItemToOpenDir.setEnabled(B.O);

		menuItemToOpenDir.addMouseListener(this);
		add(menuItemToOpenDir);

		addSeparator();

		if (int32 == MySue.KEY_MP0 || int32 == MySue.KEY_EP0) {

			add(MySwingva.MAP_OF_BTN.get(int32 + 3));
			add(MySwingva.MAP_OF_BTN.get(int32 + 4));

		} else if (int32 == MySue.KEY_REC0)
			add(MySwingva.btnRec3);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) { // 只有 show 和 openDir 這 2 個事件

		// O.l(e.getSource().toString(), THIS);

		componentViaEvent = e.getComponent();
		tmp32 = e.getButton();

		if (componentViaEvent == MySwingva.btnMP3 || componentViaEvent == MySwingva.btnEP3) // 根本沒 Listener 監聽嗎

			O.x("fuck");

		if (componentViaEvent == menuItemToOpenDir) {

			if (tmp32 == 1)
				MySue.openDefDir();

			setVisible(B.I); // fuck
			// menuItemToOpenDir.setArmed(B.O);

			return;

		}

		if (tmp32 == 3) {

			if (myIdx == MySue.KEY_MP0 && !MySwingva.btnMP0.isEnabled()) {

				if (MyConfPane.CHK_TO_REPEAT_MP_EP.isSelected()) {

					O.l("not show while repeating", THIS);

					return;

				}

				if (O.isAlive(MySue.moonMP.otherThr)) {

					O.l("not show while other thread alive", THIS);

					return;

				}

				//////////////////////////////////////////////

				// setSize((int) (50 * MySwingva.f32ToZoom), (int) (110 * MySwingva.f32ToZoom));
				// setPreferredSize(new Dimension(110, 100));
				// updateUI();
				show(componentViaEvent, e.getX(), e.getY());
				// updateUI();

				return;

			}

			if (myIdx == MySue.KEY_EP0 && !MySwingva.btnEP0.isEnabled()) {

				if (MyConfPane.CHK_TO_REPEAT_MP_EP.isSelected()) {

					O.l("not show while repeating", THIS);

					return;

				}

				if (O.isAlive(MySue.fanOfMarker)) {

					O.l("not show while other thread alive", THIS);

					return;

				}

				show(componentViaEvent, e.getX(), e.getY());

				return;

			}

			if (myIdx == MySue.KEY_REC0) {

				if (MyTablePane.TABLE_MODEL.getDataVector().size() == 0) {

					O.l("not show while size = 0", THIS);

					return;

				}

				show(componentViaEvent, e.getX(), e.getY());

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