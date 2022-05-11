package lgpl3.other.uI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import lgpl3.o.keyNV.MapK32V;

/**
 * 本類別用來收集一些 swing 元件.<br/>
 * To generate some swing components.
 *
 * @version 2021/10/12_18:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=MySwingva_A" >MySwingva_A.java</a>
 *
 * @see MySwingva_F
 */
public abstract class MySwingva_A {

	// private static final Class<?> THIS = MySwingva_A.class;

	public static final Color COLOR_BACKGROUND = new Color(0xB0DDF2); // 0xFFAACC, 0xC0FFCC

	public static final Color COLOR_TXT_BACKGROUND = new Color(0xC8DDF2);
	// 0xCCDEF3, MetalTabbedPaneUI.paintTabBackground

	public static final EmptyBorder EMPTY_BORDER = new EmptyBorder(0, 0, 0, 0);

	public static final Container TMP_CONTAINER = new Container();

	/**
	 * 裝元件的 TreeMap.<br/>
	 * The TreeMap of the component.
	 */
	public static final MapK32V<JTextField> MAP_OF_TXTFLD = new MapK32V<JTextField>();

	/**
	 * 裝元件的 TreeMap.<br/>
	 * The TreeMap of the component.
	 */
	public static final MapK32V<JButton> MAP_OF_BTN = new MapK32V<JButton>();

	/**
	 * 裝元件的 TreeMap.<br/>
	 * The TreeMap of the component.
	 */
	public static final MapK32V<JProgressBar> MAP_OF_PROGR_BAR = new MapK32V<JProgressBar>();

	/**
	 * 裝元件的 TreeMap.<br/>
	 * The TreeMap of the component.
	 */
	public static final MapK32V<JTextArea> MAP_OF_TXTAREA = new MapK32V<JTextArea>();

	/**
	 * 裝元件的 TreeMap.<br/>
	 * The TreeMap of the component.
	 */
	public static final MapK32V<JScrollPane> MAP_OF_SCRLPANE = new MapK32V<JScrollPane>();

	/**
	 * 裝元件的 TreeMap.<br/>
	 * The TreeMap of the component.
	 */
	public static final MapK32V<JPanel> MAP_OF_PANEL = new MapK32V<JPanel>();

	/////////////////////////////////////////////////////////////////////////////

	public static Font dynaFontDialog_1_17; // MP5

	public static Font dynaFontDialog_1_26; // rec

	public static Font dynaFontDialog_1_43; // big txtfld

	public static FontMetrics metricOfFontDialog_1_26;

	public static FontMetrics metricOfFontDialog_1_30;

	public static int hOfFontDialog_1_26;

	/////////////////////////////////////////////////////////////////////////////

	public static final String TXT_FOR_MP0 = "12,345,678";

	public static final String TXT_FOR_MP1 = "1";

	public static final String TXT_FOR_MP5 = "MinePrime";

	public static final String TXT_FOR_EP0 = "1";

	public static final String TXT_FOR_EP1 = "3,037,000,507";

	public static final String TXT_FOR_EP5 = "EtchPrime";

	public static final String TXT_FOR_DIY5 = "DIY "; // with 1 blank

	public static final String TXT_FOR_CONF5 = "Conf "; // with 1 blank

	public static final String TXT_FOR_REC5 = "Rec "; // with 1 blank

	public static Dimension getDimOfScreen() {

		try {
			return Toolkit.getDefaultToolkit().getScreenSize();

		} catch (Throwable throwable) {

			throwable.printStackTrace();
		}

		return new Dimension(1600, 900); // for Linux in VM

	}

	public static final Dimension DIM_OF_SCREEN = getDimOfScreen();

	public static final float W_SCREEN_F32 = (float) DIM_OF_SCREEN.getWidth();

	public static final float H_SCREEN_F32 = (float) DIM_OF_SCREEN.getHeight();

	public static final int W_SCREEN = (int) W_SCREEN_F32;

	public static final int H_SCREEN = (int) H_SCREEN_F32;

	public static int int32Width;

	public static int int32Height;

}
