package lgpl3.other.uI;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.prime64.Ranger;

/**
 * @version 2021/10/12_18:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=MySwingva_F" >MySwingva_F.java</a>
 *
 * @see MySwingva_L
 */
public abstract class MySwingva_F extends MySwingva_A {

	// private static final Class<?> THIS = MySwingva_F.class;

	/**
	 * To gen the Component.<br/>
	 * To gen the Component.
	 */
	public static JTextField genTxtfld(int i) {

		JTextField txtfld = new JTextField();

		txtfld.setHorizontalAlignment(JTextField.RIGHT);

		txtfld.setBackground(COLOR_TXT_BACKGROUND);
		txtfld.setSelectionColor(COLOR_BACKGROUND);

		// txtfld.setDoubleBuffered(B.I);

		if (i == MySue.KEY_MP0) {

			// txtfld.setPreferredSize(DIM_TXTFLD_MP0);
			// txtfld.setBounds(new Rectangle(5, 0, 200, 25));

			txtfld.setFont(dynaFontDialog_1_43);
			txtfld.setText(TXT_FOR_MP0);

			return txtfld;

		}

		if (i == MySue.KEY_MP1) {

			txtfld.setFont(dynaFontDialog_1_43);
			txtfld.setText(TXT_FOR_MP1);

			return txtfld;

		}

		if (i == MySue.KEY_EP0) {

			// txtfld.setPreferredSize(DIM_TXTFLD_MP0);

			txtfld.setFont(dynaFontDialog_1_43);
			txtfld.setText(TXT_FOR_EP0);

			return txtfld;

		}

		if (i == MySue.KEY_EP1) {

			txtfld.setFont(dynaFontDialog_1_43);
			txtfld.setText(TXT_FOR_EP1);

			return txtfld;

		}

		if (i == MySue.KEY_DIY0) {

			txtfld.setFont(dynaFontDialog_1_43);

			return txtfld;

		}

		if (i == MySue.KEY_DIY1) {

			txtfld.setFont(dynaFontDialog_1_43);

			return txtfld;

		}

		if (i == MySue.KEY_MP5 || i == MySue.KEY_EP5 || i == MySue.KEY_DIY5 || i == MySue.KEY_CONF5 || i == MySue.KEY_REC5) {

			// int wOfTxt = (int) (SwingUtilities.computeStringWidth(metricOfFontDialog_1_14, TXT_FOR_REC5) * 1.1F + 6.0F);
			// int hOfTxt = (int) (hOfFontDialog_1_14 * 1.1F + 2.0F);
			// txtfld.setPreferredSize(new Dimension(wOfTxt, hOfTxt));

			txtfld.setBorder(EMPTY_BORDER);
			txtfld.setFont(dynaFontDialog_1_17);

			txtfld.setEditable(B.O);
			txtfld.setOpaque(B.O);

			if (i == MySue.KEY_MP5)
				txtfld.setText(TXT_FOR_MP5);

			if (i == MySue.KEY_EP5)
				txtfld.setText(TXT_FOR_EP5);

			if (i == MySue.KEY_DIY5)
				txtfld.setText(TXT_FOR_DIY5);

			if (i == MySue.KEY_CONF5)
				txtfld.setText(TXT_FOR_CONF5);

			if (i == MySue.KEY_REC5)
				txtfld.setText(TXT_FOR_REC5);

			return txtfld;

		}

		// throw new IllegalArgumentException("i=" + i);

		return null; // important

	}

	/**
	 * To fill.<br/>
	 * To fill.
	 */
	public static void fillMapOfTxtfld(int from, int to) {

		for (; from <= to; from += MySue.INCR_OF_KEY) {

			MAP_OF_TXTFLD.a(from, genTxtfld(from));
			MAP_OF_TXTFLD.a(from + 1, genTxtfld(from + 1));
			MAP_OF_TXTFLD.a(from + 5, genTxtfld(from + 5));

		}
	}

	/**
	 * To gen the Component.<br/>
	 * To gen the Component.
	 */
	public static JButton genBtn(int i) {

		JButton btn = new JButton();

		btn.setOpaque(B.O); // opaque: 不透明
		btn.setFont(dynaFontDialog_1_43);

		if (i == MySue.KEY_MP0 || i == MySue.KEY_EP0 || i == MySue.KEY_DIY0) {

			if (i == MySue.KEY_MP0)
				btn.setToolTipText("Right click to set threads");

			// btn.setPreferredSize(DIM_BIG_BTN);

			return btn;

		}

		if (i == MySue.KEY_MP1 || i == MySue.KEY_EP1 || i == MySue.KEY_DIY1) {

			btn.setToolTipText(MySue.MY_TXT_ESC);

			return btn;

		}

		if (i == MySue.KEY_MP3 || i == MySue.KEY_EP3 || i == MySue.KEY_REC3) {

			btn.setFont(dynaFontDialog_1_26);
			btn.setDoubleBuffered(B.I);
			// btnKeyPlus3.setBackground(.COLOR_BACKGROUND);
			btn.setOpaque(B.O);
			btn.setText(MySue.MY_TXT_SAVE);
			btn.setToolTipText("save in the default dir");
			// btn.setPreferredSize(new Dimension(100, 30));

			return btn;

		}

		if (i == MySue.KEY_MP4 || i == MySue.KEY_EP4) {

			btn.setFont(dynaFontDialog_1_26);
			btn.setDoubleBuffered(B.I);
			// btn.setBackground(.COLOR_BACKGROUND);
			btn.setOpaque(B.O);
			btn.setText(MySue.MY_TXT_ESC);
			btn.setToolTipText("stop saving");

			return btn;

		}

		return null;

	}

	/**
	 * To fill.<br/>
	 * To fill.
	 */
	public static void fillMapOfBtn(int from, int to) {

		for (; from <= to; from += MySue.INCR_OF_KEY) {

			MAP_OF_BTN.a(from, genBtn(from));
			MAP_OF_BTN.a(from + 1, genBtn(from + 1));
			MAP_OF_BTN.a(from + 3, genBtn(from + 3));
			MAP_OF_BTN.a(from + 4, genBtn(from + 4));

		}
	}

	/**
	 * To gen the Component.<br/>
	 * To gen the Component.
	 */
	public static JProgressBar genProgrBar(int i) {

		JProgressBar progrBar = new JProgressBar(0, Ranger.$100_INT32);

		// progrBar.setPreferredSize(new Dimension(int32Width - 4, 20));

		progrBar.setFont(dynaFontDialog_1_17);

		progrBar.setStringPainted(B.I);
		progrBar.setBorderPainted(B.O);
		progrBar.setBackground(COLOR_TXT_BACKGROUND);
		progrBar.setForeground(Color.BLACK);
		progrBar.setBorder(EMPTY_BORDER);

		progrBar.setDoubleBuffered(B.I);

		return progrBar;

	}

	/**
	 * To fill.<br/>
	 * To fill.
	 */
	public static void fillMapOfProgrBar(int from, int to) {

		for (; from <= to; from += MySue.INCR_OF_KEY)
			MAP_OF_PROGR_BAR.a(from, genProgrBar(from));

	}

	/**
	 * To gen the Component.<br/>
	 * To gen the Component.
	 */
	public static JTextArea genTxtarea(int i) {

		JTextArea txtarea = new JTextArea();

		// txtarea.setLineWrap(B.I);
		// txtarea.setWrapStyleWord(B.I);
		txtarea.setBorder(EMPTY_BORDER);
		txtarea.setFont(dynaFontDialog_1_43);
		txtarea.setBackground(COLOR_TXT_BACKGROUND);
		txtarea.setSelectionColor(COLOR_BACKGROUND);

		txtarea.setEditable(B.O);

		txtarea.setDoubleBuffered(B.I);

		if (i == MySue.KEY_MP0) {

			StringBuilder str = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);
			str.append("please click top right button to start");
			str.append(O.C_A_L);
			str.append(O.C118);
			str.append(O.S_UPDATED_TIME_AS_VERSION);
			str.append(O.C_A_L);

			txtarea.setText(str.toString());

		}

		if (i == MySue.KEY_EP0) {

			// txtarea.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			// txtarea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			// txtarea.setAlignmentX(JTextArea.RIGHT_ALIGNMENT);

			StringBuilder str = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);
			str.append("Warning:");
			str.append(O.C_A_L);
			str.append("The high temperature caused by running");
			str.append(O.C_A_L);
			str.append("this program will harm your computer.");
			str.append(O.C_A_L);
			str.append("It suggests take a break every");
			str.append(O.C_A_L);
			str.append("30 minutes to cool down your computer.");
			str.append(O.C_A_L);

			txtarea.setText(str.toString());

		}

		if (i == MySue.KEY_DIY0) {

			txtarea.setEditable(B.I);

			// txtarea.setText(O.S_UPDATED_TIME_AS_VERSION);

		}

		return txtarea;

	}

	/**
	 * To fill.<br/>
	 * To fill.
	 */
	public static void fillMapOfTxtarea(int from, int to) {

		for (; from <= to; from += MySue.INCR_OF_KEY)
			MAP_OF_TXTAREA.a(from, genTxtarea(from));

	}

	/**
	 * To gen the Component.<br/>
	 * To gen the Component.
	 */
	public static JScrollPane genScrlpane(int i) {

		JScrollPane scrlpane = new JScrollPane();
		JScrollBar hScrlbar, vScrlbar;

		if (i == MySue.KEY_MP0 || i == MySue.KEY_EP0)
			scrlpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		scrlpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrlpane.setBorder(EMPTY_BORDER);
		scrlpane.setDoubleBuffered(B.I);

		//////////////////////////////////////////////////////////

		hScrlbar = scrlpane.getHorizontalScrollBar();
		hScrlbar.setBackground(COLOR_BACKGROUND);
		hScrlbar.setBorder(EMPTY_BORDER);
		hScrlbar.setDoubleBuffered(B.I);

		vScrlbar = scrlpane.getVerticalScrollBar();
		vScrlbar.setBackground(COLOR_BACKGROUND);
		vScrlbar.setBorder(EMPTY_BORDER);
		vScrlbar.setDoubleBuffered(B.I);

		// O.l("scrlpane i=" + i, THIS);
		// scrlpane.setMinimumSize(new Dimension(0, 0)); // fuck

		if (i == MySue.KEY_MP0 || i == MySue.KEY_EP0)
			vScrlbar.addMouseListener(new MyPopupMenuToSave(i));

		scrlpane.setViewportView(MAP_OF_TXTAREA.get(i));

		return scrlpane;

	}

	/**
	 * To fill.<br/>
	 * To fill.
	 */
	public static void fillMapOfScrlpane(int from, int to) {

		for (; from <= to; from += MySue.INCR_OF_KEY)
			if (from != MySue.KEY_CONF0)
				MAP_OF_SCRLPANE.a(from, genScrlpane(from));

	}
}
