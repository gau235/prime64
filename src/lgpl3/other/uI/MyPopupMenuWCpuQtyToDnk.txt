package lgpl3.other.uI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * My PopupMenu.<br/>
 * My PopupMenu.
 *
 * @version 2021/09/06_09:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=MyPopupMenuWCpuQtyToDnk" >
 *          MyPopupMenuWCpuQtyToDnk.java</a>
 *
 */
@SuppressWarnings("serial")
public class MyPopupMenuWCpuQtyToDnk extends JPopupMenu implements MouseListener, ActionListener {

	// private static final Class<?> THIS = MyPopupMenuWCpuQtyToDnk.class;

	public final JButton targetBtn;

	public final ButtonGroup myBtnGroup = new ButtonGroup();

	/**
	 * My PopupMenu.<br/>
	 * Constructor.
	 */
	public MyPopupMenuWCpuQtyToDnk(JButton targetBtn) {

		this.targetBtn = targetBtn;

		int qty;

		int defIdx = (O.isDev ? (O.MY_ARY32_OF_CPU_THR.length >>> 1) : (O.MY_ARY32_OF_CPU_THR.length - 1));

		JRadioButtonMenuItem rdBtnInMenu;
		for (int idx = 0; idx != O.MY_ARY32_OF_CPU_THR.length; idx++) {

			// O.l("defI=" + defI , THIS);

			qty = O.MY_ARY32_OF_CPU_THR[idx];

			rdBtnInMenu = new JRadioButtonMenuItem(Integer.toString(qty));
			rdBtnInMenu.addActionListener(this);
			rdBtnInMenu.setFont(new Font(Font.DIALOG, 1, (int) (30.0F * MainToDnk.f32ToZoom)));

			add(rdBtnInMenu);
			myBtnGroup.add(rdBtnInMenu);

			if (idx == defIdx) {

				rdBtnInMenu.setSelected(B.I); // init
				targetBtn.setText(Integer.toString(qty)); // init

			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		if ((e.getButton() == MouseEvent.BUTTON3) && targetBtn.isEnabled())

			show(targetBtn, e.getX(), e.getY());

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		targetBtn.setText(((AbstractButton) e.getSource()).getSelectedObjects()[0].toString()); // #Thr
	}
}