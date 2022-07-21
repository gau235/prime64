package lgpl3.other.uI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * My PopupMenu.<br/>
 * My PopupMenu.
 *
 * @version 2021/09/06_09:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=MyPopupMenuWCpuQty" >MyPopupMenuWCpuQty.java</a>
 *
 */
@SuppressWarnings("serial")
public class MyPopupMenuWCpuQty extends JPopupMenu implements MouseListener, ActionListener {

	private static final Class<?> THIS = MyPopupMenuWCpuQty.class;

	public final JButton targetBtn;

	public final JMenuItem myMenuItem = new JMenuItem("#Thr");

	public final ButtonGroup myBtnGroup = new ButtonGroup();

	/**
	 * My PopupMenu.<br/>
	 * Constructor.
	 */
	public MyPopupMenuWCpuQty(int key32) {

		targetBtn = ((key32 == MySue.KEY_MP0) ? MySwingva.btnMP0 : MySwingva.btnEP0);

		myMenuItem.setBackground(MySwingva.COLOR_BACKGROUND);
		// myMenuItem.setOpaque(B.I);
		myMenuItem.setFont(MySwingva.dynaFontDialog_1_26);

		myMenuItem.setToolTipText("total CPU threads: " + O.$NUM_OF_CPU_THR);

		add(myMenuItem);

		addSeparator();

		int len = MySue.MY_ARY32_OF_CPU_THR.length, qty, defIdx, idx;

		if (key32 == MySue.KEY_MP0)

			defIdx = (O.isDev ? ((len >>> 1) - 1) : (len - 1)); // O.l("defIdx=" + defIdx, THIS);
		else
			defIdx = len - 1;

		JRadioButtonMenuItem rdBtnInMenu;
		for (idx = 0; idx != len; idx++) {

			qty = MySue.MY_ARY32_OF_CPU_THR[idx];

			rdBtnInMenu = new JRadioButtonMenuItem(Integer.toString(qty));
			rdBtnInMenu.addActionListener(this);
			rdBtnInMenu.setFont(MySwingva.dynaFontDialog_1_26);
			rdBtnInMenu.setBackground(MySwingva.COLOR_BACKGROUND);

			add(rdBtnInMenu);
			myBtnGroup.add(rdBtnInMenu);

			if (idx == defIdx) {

				rdBtnInMenu.setSelected(B.I); // init
				targetBtn.setText(Integer.toString(qty)); // init

			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) { // O.l("mouseClicked=" + e);
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
	public void actionPerformed(ActionEvent e) { // O.l("e.getSource()=" + e.getSource(), THIS);

		targetBtn.setText(((AbstractButton) e.getSource()).getSelectedObjects()[0].toString()); // #Thr
	}
}