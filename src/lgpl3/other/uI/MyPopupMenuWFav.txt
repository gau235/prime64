package lgpl3.other.uI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.prime64.Etchva;

/**
 * My PopupMenu.<br/>
 * My PopupMenu.
 *
 * @version 2021/09/06_09:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=MyPopupMenuWFav" >MyPopupMenuWFav.java</a>
 *
 */
@SuppressWarnings("serial")
public class MyPopupMenuWFav extends JPopupMenu implements MouseListener, ActionListener {

	// private static final Class<?> THIS = MyPopupMenuWFav.class;

	public final int key32;

	public final JButton targetBtn1;

	public final JButton targetBtn0;

	public final JMenuItem myMenuItem = new JMenuItem("Fav");

	public final JRadioButtonMenuItem fav1, fav2;

	public final ButtonGroup myBtnGroup = new ButtonGroup();

	/**
	 * My PopupMenu.<br/>
	 * Constructor.
	 */
	public MyPopupMenuWFav(int key32) {

		if ((this.key32 = key32) == MySue.KEY_MP1) {

			targetBtn1 = MySwingva.btnMP1;
			targetBtn0 = MySwingva.btnMP0;

		} else {

			targetBtn1 = MySwingva.btnEP1;
			targetBtn0 = MySwingva.btnEP0;

		}

		myMenuItem.setBackground(MySwingva.COLOR_BACKGROUND);
		// myMenuItem.setOpaque(B.I);
		myMenuItem.setFont(MySwingva.dynaFontDialog_1_26);

		add(myMenuItem);

		addSeparator();

		fav1 = new JRadioButtonMenuItem("fav1");
		fav1.addActionListener(this);
		fav1.setFont(MySwingva.dynaFontDialog_1_26);
		fav1.setBackground(MySwingva.COLOR_BACKGROUND);
		fav1.setSelected(B.I); // init

		add(fav1);
		myBtnGroup.add(fav1);

		fav2 = new JRadioButtonMenuItem("fav2");
		fav2.addActionListener(this);
		fav2.setFont(MySwingva.dynaFontDialog_1_26);
		fav2.setBackground(MySwingva.COLOR_BACKGROUND);

		add(fav2);
		myBtnGroup.add(fav2);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		// O.l("mouseClicked=" + e);
	}

	@Override
	public void mousePressed(MouseEvent e) {

		// O.l("mousePressed=" + e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		if ((e.getButton() == MouseEvent.BUTTON3) && targetBtn0.isEnabled())

			show(targetBtn1, e.getX(), e.getY());

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object objViaSource = e.getSource();

		if (key32 == MySue.KEY_MP1) {

			if (objViaSource == fav1) {

				MySwingva.txtfldMP0.setText(MySwingva.TXT_FOR_MP0);
				MySwingva.txtfldMP1.setText(MySwingva.TXT_FOR_MP1);

			} else if (objViaSource == fav2) {

				MySwingva.txtfldMP0.setText(O.f(3_037_000_507L));
				MySwingva.txtfldMP1.setText(O.f(2));

			}

		} else if (key32 == MySue.KEY_EP1) {

			if (objViaSource == fav1) {

				MySwingva.txtfldEP0.setText(MySwingva.TXT_FOR_EP0);
				MySwingva.txtfldEP1.setText(MySwingva.TXT_FOR_EP1);

			} else if (objViaSource == fav2) {

				MySwingva.txtfldEP0.setText(O.f(2));
				MySwingva.txtfldEP1.setText(O.f(Etchva.$MAX_TEST_N_OVER_1_ARY32));

			}
		}
	}
}