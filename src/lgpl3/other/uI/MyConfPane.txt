package lgpl3.other.uI;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.other.iO.IOr;
import lgpl3.prime64.Miner;

/**
 * My JPanel to configure.<br/>
 * My JPanel to configure.
 *
 * @version 2022/05/07_19:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=MyConfPane" >MyConfPane.java</a>
 *
 */
@SuppressWarnings("serial")
public class MyConfPane extends JScrollPane implements MouseListener {

	private static final Class<?> THIS = MyConfPane.class;

	public static int idx = 0;

	public static final JTextField TXTFLD_FOR_DEF_DIR_TO_SAVE = new JTextField();

	public static final JButton BTN_TO_DEL_DIR = new JButton((++idx) + ". Delete the dir above for saved files");

	public static final JButton BTN_TO_OPEN_DIR = new JButton(Integer.toString(++idx) + ". Open the dir above for saved files");

	public static final JCheckBox CHK_TO_SEND_ERR = new JCheckBox(Integer.toString(++idx) + ". Send error log to c64.tw");

	public static final JButton BTN_TO_GC = new JButton(Integer.toString(++idx) + ". Java GC and show max kept prime");

	public static final JCheckBox CHK_TO_REPEAT_MP_EP = new JCheckBox(Integer.toString(++idx) + ". Repeat MP and EP both 100 times");

	public static Object objViaSource;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public MyConfPane() {

		JPanel tmpPanel = new JPanel();

		tmpPanel.setBorder(MySwingva.EMPTY_BORDER);

		tmpPanel.setBackground(MySwingva.COLOR_TXT_BACKGROUND); // COLOR_BACKGROUND

		tmpPanel.setLayout(new GridLayout(0, 1));

		tmpPanel.setDoubleBuffered(B.I);

		////////////////////////////////////////////////////////////////

		TXTFLD_FOR_DEF_DIR_TO_SAVE.setBorder(MySwingva.EMPTY_BORDER);

		TXTFLD_FOR_DEF_DIR_TO_SAVE.setFont(MySwingva.dynaFontDialog_1_26);

		TXTFLD_FOR_DEF_DIR_TO_SAVE.setBackground(MySwingva.COLOR_TXT_BACKGROUND);

		TXTFLD_FOR_DEF_DIR_TO_SAVE.setToolTipText("The dir for saved files");

		TXTFLD_FOR_DEF_DIR_TO_SAVE.setEditable(B.O);

		TXTFLD_FOR_DEF_DIR_TO_SAVE.setText(MySue.sDefDirToSaveMP);

		TXTFLD_FOR_DEF_DIR_TO_SAVE.setSelectionColor(MySwingva.COLOR_BACKGROUND);
		tmpPanel.add(TXTFLD_FOR_DEF_DIR_TO_SAVE);

		BTN_TO_DEL_DIR.setFont(MySwingva.dynaFontDialog_1_26);
		BTN_TO_DEL_DIR.setOpaque(B.O);
		// BTN_TO_DEL_DIR.setHorizontalAlignment(SwingConstants.LEFT);
		BTN_TO_DEL_DIR.setToolTipText(MySue.sDefDirToSaveMP);
		BTN_TO_DEL_DIR.addMouseListener(this);
		tmpPanel.add(BTN_TO_DEL_DIR);

		///////////////////////////////////////////
		JLabel tmpLab = new JLabel();
		tmpLab.setOpaque(B.I);
		// tmpLab.setForeground(MySwingva.COLOR_TXT_BACKGROUND);
		tmpLab.setBackground(MySwingva.COLOR_TXT_BACKGROUND);

		tmpPanel.add(tmpLab);
		///////////////////////////////////////////

		BTN_TO_OPEN_DIR.setFont(MySwingva.dynaFontDialog_1_26);
		BTN_TO_OPEN_DIR.setOpaque(B.O);
		// BTN_TO_OPEN_DIR.setHorizontalAlignment(SwingConstants.LEFT);
		BTN_TO_OPEN_DIR.setToolTipText(MySue.sDefDirToSaveMP);
		BTN_TO_OPEN_DIR.addMouseListener(this);
		tmpPanel.add(BTN_TO_OPEN_DIR);

		CHK_TO_SEND_ERR.setFont(MySwingva.dynaFontDialog_1_26);
		CHK_TO_SEND_ERR.setBackground(MySwingva.COLOR_TXT_BACKGROUND);
		// CHK_TO_SEND_ERR.setBorder(MySwingva.EMPTY_BORDER);
		CHK_TO_SEND_ERR.setSelected(B.I);
		tmpPanel.add(CHK_TO_SEND_ERR);

		BTN_TO_GC.setFont(MySwingva.dynaFontDialog_1_26);
		BTN_TO_GC.setOpaque(B.O);
		// BTN_TO_GC.setHorizontalAlignment(SwingConstants.LEFT);
		BTN_TO_GC.addMouseListener(this);
		tmpPanel.add(BTN_TO_GC);

		CHK_TO_REPEAT_MP_EP.setFont(MySwingva.dynaFontDialog_1_26);
		CHK_TO_REPEAT_MP_EP.setBackground(MySwingva.COLOR_TXT_BACKGROUND);
		tmpPanel.add(CHK_TO_REPEAT_MP_EP);

		///////////////////////////////////////////
		JLabel tmpLab2 = new JLabel();
		tmpLab2.setOpaque(B.I);
		// tmpLab2.setForeground(MySwingva.COLOR_TXT_BACKGROUND);
		tmpLab2.setBackground(MySwingva.COLOR_TXT_BACKGROUND);

		tmpPanel.add(tmpLab2);
		///////////////////////////////////////////

		/////////////////////////////////////////////////////////////

		setBorder(MySwingva.EMPTY_BORDER);
		setBackground(MySwingva.COLOR_TXT_BACKGROUND);
		setDoubleBuffered(B.I);

		setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		// setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);

		JScrollBar vScrlbar = getVerticalScrollBar();
		vScrlbar.setBackground(MySwingva.COLOR_BACKGROUND);
		vScrlbar.setBorder(MySwingva.EMPTY_BORDER);
		vScrlbar.setDoubleBuffered(B.I);

		setViewportView(tmpPanel);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		objViaSource = e.getComponent();

		if (objViaSource == BTN_TO_DEL_DIR) {

			if (JOptionPane.showConfirmDialog(null, "Do you want to keep it?", "Confirm",

					JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {

				O.l("delDirRecur=" + MySue.sDefDirToSaveMP, THIS);

				try {
					IOr.delDirRecur(MySue.defPathOfDirToSaveMP); // new ThrToCmd(S_ARY_FOR_CMD_TO_DEL);

				} catch (IOException iOEx) {

					O.l(iOEx.toString(), THIS);
				}
			}

			return;

		}

		if (objViaSource == BTN_TO_OPEN_DIR) {

			MySue.openDefDir();

			return;

		}

		if (objViaSource == BTN_TO_GC) {

			O.RUNTIME.gc();

			O.l("gc", THIS);

			O.l("maxP=" + O.f(Miner.maxInOriAryP()) + O.L + "maxTestN=" + O.f(Miner.curMaxNToTest()));

			return;

		}
	}
}
