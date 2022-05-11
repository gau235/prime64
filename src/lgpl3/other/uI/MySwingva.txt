package lgpl3.other.uI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.Document;

import lgpl3.o.B;
import lgpl3.prime64.Miner;

/**
 * 本類別用來收集一些 swing 元件.<br/>
 * To generate some swing components.
 *
 * @version 2021/09/06_09:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=MySwingva" >MySwingva.java</a>
 *
 * @see Miner
 */
public class MySwingva extends MySwingva_L {

	// private static final Class<?> THIS = MySwingva.class;

	public static JTextField txtfldMP0;
	public static JTextField txtfldMP1;
	public static JTextField txtfldMP5;

	public static JTextField txtfldEP0;
	public static JTextField txtfldEP1;
	public static JTextField txtfldEP5;

	public static JTextField txtfldDiy0;
	public static JTextField txtfldDiy1;
	public static JTextField txtfldDiy5;

	public static JTextField txtfldConf5;

	public static JTextField txtfldRec5;

	public static JButton btnMP0;
	public static JButton btnMP1;
	public static JButton btnMP3;
	public static JButton btnMP4;

	public static JButton btnEP0;
	public static JButton btnEP1;
	public static JButton btnEP3;
	public static JButton btnEP4;

	public static JButton btnDiy0;
	public static JButton btnDiy1;

	public static JButton btnRec3;

	public static JProgressBar progrBarMP0;
	public static JProgressBar progrBarEP0;

	public static JTextArea txtareaMP0;
	public static JTextArea txtareaEP0;
	public static JTextArea txtareaDiy0;

	public static Document docMP0;
	public static Document docEP0;

	public static JScrollPane scrlpaneMP0;

	public static JTabbedPane tabbedPane0;

	public static JFrame mainFrame;

	public static float f32ToZoom = 1.0F;

	/**
	 * To gen the Component.<br/>
	 * To gen the Component.
	 */
	public static JPanel genJPanel(int i) {

		JPanel jPanel = new JPanel();

		jPanel.setBorder(EMPTY_BORDER);
		jPanel.setBackground(COLOR_BACKGROUND);
		jPanel.setDoubleBuffered(B.I);
		// jPanel.setMinimumSize(new Dimension(W_SCREEN, H_SCREEN));
		// jPanel.setPreferredSize(new Dimension(2000 - 10, 2000 - 62));
		// jPanel.setBounds(0, 0, 2000, 2000 - 222);

		return setGridBagConstr(i, jPanel);

	}

	/**
	 * To fill.<br/>
	 * To fill.
	 */
	public static void fillMapOfPanel(int from, int to) {

		for (; from <= to; from += MySue.INCR_OF_KEY) // O.l("fillMapOfPanel=" + from, THIS);

			MAP_OF_PANEL.a(from, genJPanel(from));

	}

	/**
	 * To gen the Component.<br/>
	 * To gen the Component.
	 */
	public static JTabbedPane genTabbedPane() {

		tabbedPane0 = new JTabbedPane(JTabbedPane.BOTTOM, JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane0.setBorder(EMPTY_BORDER);

		// tabbedPane0.setPreferredSize(new Dimension(int32Width, int32Height));
		tabbedPane0.setBackground(COLOR_BACKGROUND);
		// tabbedPane0.setLayout(new FlowLayout());

		int iTab = 0, iPanel = -MySue.INCR_OF_KEY; // fuck

		tabbedPane0.addTab(null, MAP_OF_PANEL.get(iPanel += MySue.INCR_OF_KEY));
		tabbedPane0.setTabComponentAt(iTab++, MAP_OF_TXTFLD.get(MySue.KEY_MP5));
		// ((JPanel)tabbedPane0.getComponentAt(0)).setBorder(EMPTY_BORDER);

		tabbedPane0.addTab(null, MAP_OF_PANEL.get(iPanel += MySue.INCR_OF_KEY));
		tabbedPane0.setTabComponentAt(iTab++, MAP_OF_TXTFLD.get(MySue.KEY_EP5));

		tabbedPane0.addTab(null, MAP_OF_PANEL.get(iPanel += MySue.INCR_OF_KEY)); // DIY
		tabbedPane0.setTabComponentAt(iTab++, MAP_OF_TXTFLD.get(MySue.KEY_DIY5));

		tabbedPane0.addTab(null, new MyConfPane()); // conf
		tabbedPane0.setTabComponentAt(iTab++, MAP_OF_TXTFLD.get(MySue.KEY_CONF5));

		tabbedPane0.addTab(null, new MyTablePane()); // rec
		tabbedPane0.setTabComponentAt(iTab++, MAP_OF_TXTFLD.get(MySue.KEY_REC5));

		return tabbedPane0;

	}

	/**
	 * To add all listeners.<br/>
	 * To add all listeners.
	 */
	public static void addMouseLsnrToComponent() {

		JTextField txtfld;
		JButton btn;

		final MyMouseLsnr myMouseLsnr = new MyMouseLsnr();

		for (int idx = MySue.KEY_MP0, to = MySue.KEY_REC5; idx <= to; idx++) {

			if ((txtfld = MAP_OF_TXTFLD.get(idx)) != null) {

				if (idx % MySue.INCR_OF_KEY == 5)

					txtfld.addMouseListener(myMouseLsnr);

			}

			if ((btn = MAP_OF_BTN.get(idx)) != null) {

				btn.addMouseListener(myMouseLsnr);

				if (idx == MySue.KEY_MP0 || idx == MySue.KEY_EP0)

					btn.addMouseListener(new MyPopupMenuWCpuQty(idx));

				else if (idx == MySue.KEY_MP1 || idx == MySue.KEY_EP1)

					btn.addMouseListener(new MyPopupMenuWFav(idx));

			}
		}
	}

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public MySwingva() {

		fillMapOfTxtfld(MySue.KEY_MP0, MySue.KEY_REC0);

		fillMapOfBtn(MySue.KEY_MP0, MySue.KEY_REC0);

		fillMapOfProgrBar(MySue.KEY_MP0, MySue.KEY_EP0);

		fillMapOfTxtarea(MySue.KEY_MP0, MySue.KEY_DIY0);

		fillMapOfScrlpane(MySue.KEY_MP0, MySue.KEY_DIY0);

		fillMapOfPanel(MySue.KEY_MP0, MySue.KEY_DIY0);

		txtfldMP0 = MAP_OF_TXTFLD.get(MySue.KEY_MP0);
		txtfldMP1 = MAP_OF_TXTFLD.get(MySue.KEY_MP1);
		txtfldMP5 = MAP_OF_TXTFLD.get(MySue.KEY_MP5);

		txtfldEP0 = MAP_OF_TXTFLD.get(MySue.KEY_EP0);
		txtfldEP1 = MAP_OF_TXTFLD.get(MySue.KEY_EP1);
		txtfldEP5 = MAP_OF_TXTFLD.get(MySue.KEY_EP5);

		txtfldDiy0 = MAP_OF_TXTFLD.get(MySue.KEY_DIY0);
		txtfldDiy1 = MAP_OF_TXTFLD.get(MySue.KEY_DIY1);
		txtfldDiy5 = MAP_OF_TXTFLD.get(MySue.KEY_DIY5);

		txtfldConf5 = MAP_OF_TXTFLD.get(MySue.KEY_CONF5);

		txtfldRec5 = MAP_OF_TXTFLD.get(MySue.KEY_REC5);

		btnMP0 = MAP_OF_BTN.get(MySue.KEY_MP0);
		btnMP1 = MAP_OF_BTN.get(MySue.KEY_MP1);
		btnMP3 = MAP_OF_BTN.get(MySue.KEY_MP3);
		btnMP4 = MAP_OF_BTN.get(MySue.KEY_MP4);

		btnEP0 = MAP_OF_BTN.get(MySue.KEY_EP0);
		btnEP1 = MAP_OF_BTN.get(MySue.KEY_EP1);
		btnEP3 = MAP_OF_BTN.get(MySue.KEY_EP3);
		btnEP4 = MAP_OF_BTN.get(MySue.KEY_EP4);

		btnDiy0 = MAP_OF_BTN.get(MySue.KEY_DIY0);
		btnDiy1 = MAP_OF_BTN.get(MySue.KEY_DIY1);

		btnRec3 = MAP_OF_BTN.get(MySue.KEY_REC3);

		progrBarMP0 = MAP_OF_PROGR_BAR.get(MySue.KEY_MP0);
		progrBarEP0 = MAP_OF_PROGR_BAR.get(MySue.KEY_EP0);

		txtareaMP0 = MAP_OF_TXTAREA.get(MySue.KEY_MP0);
		txtareaEP0 = MAP_OF_TXTAREA.get(MySue.KEY_EP0);
		txtareaDiy0 = MAP_OF_TXTAREA.get(MySue.KEY_DIY0);

		scrlpaneMP0 = MAP_OF_SCRLPANE.get(MySue.KEY_MP0);

		docMP0 = txtareaMP0.getDocument();
		docEP0 = txtareaEP0.getDocument();

		tabbedPane0 = genTabbedPane();

		addMouseLsnrToComponent();

	}
}
