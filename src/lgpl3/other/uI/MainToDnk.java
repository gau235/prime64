package lgpl3.other.uI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * @version 2021/09/07_19:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=MainToDnk" >MainToDnk.java</a>
 *
 * @see MyLsnrToPCircAsDnk
 */
public class MainToDnk {

	private static final Class<?> THIS = MainToDnk.class;

	public static JTextField txtfld01 = new JTextField("12");
	public static JTextField txtfld02 = new JTextField("10");

	public static JTextField txtfld11 = new JTextField("12");
	public static JTextField txtfld12 = new JTextField("10");

	public static JTextField txtfld21 = new JTextField("12");
	public static JTextField txtfld22 = new JTextField("10");

	public static JButton btn01 = new JButton();
	public static JButton btn02 = new JButton();

	public static JButton btn11 = new JButton();
	public static JButton btn12 = new JButton();

	public static JButton btn21 = new JButton();
	public static JButton btn22 = new JButton();

	public static GridLayout myGridLayout = new GridLayout(1, 4);

	public static JPanel jPanel0 = new JPanel();
	public static JPanel jPanel1 = new JPanel();
	public static JPanel jPanel2 = new JPanel();

	public static JTabbedPane jTabPane0 = new JTabbedPane(JTabbedPane.BOTTOM, JTabbedPane.SCROLL_TAB_LAYOUT);

	public static JFrame myFrame = new JFrame();

	public static Font dynaFontDialog_1_36;

	public static Font dynaFontDialog_1_14;

	public static float f32ToZoom = 1.1F;

	public static MyLsnrToPCircAsDnk myLsnrToPCircAsDnk = new MyLsnrToPCircAsDnk();

	public static MyLsnrToDCirc myLsnrToDCirc = new MyLsnrToDCirc();

	public static MyLsnrToDnk myLsnrToDnk = new MyLsnrToDnk();

	public MainToDnk() {

		// txtfld01.setPreferredSize(new Dimension(100, 35));
		txtfld01.setFont(dynaFontDialog_1_36);
		txtfld01.setHorizontalAlignment(JTextField.RIGHT);

		txtfld02.setFont(dynaFontDialog_1_36);
		txtfld02.setHorizontalAlignment(JTextField.RIGHT);

		// txtfld01.setPreferredSize(new Dimension(100, 35));
		txtfld11.setFont(dynaFontDialog_1_36);
		txtfld11.setHorizontalAlignment(JTextField.RIGHT);

		txtfld12.setFont(dynaFontDialog_1_36);
		txtfld12.setHorizontalAlignment(JTextField.RIGHT);

		txtfld21.setFont(dynaFontDialog_1_36);
		txtfld21.setHorizontalAlignment(JTextField.RIGHT);

		txtfld22.setFont(dynaFontDialog_1_36);
		txtfld22.setHorizontalAlignment(JTextField.RIGHT);

		///////////////////////////////

		// btn01.setPreferredSize(new Dimension(70, 35));
		btn01.setFont(dynaFontDialog_1_36);
		btn01.addMouseListener(myLsnrToPCircAsDnk);
		btn01.addMouseListener(new MyPopupMenuWCpuQtyToDnk(btn01));

		btn02.setFont(dynaFontDialog_1_36);
		btn02.addMouseListener(myLsnrToPCircAsDnk);

		btn11.setFont(dynaFontDialog_1_36);
		btn11.addMouseListener(myLsnrToDCirc);
		btn11.addMouseListener(new MyPopupMenuWCpuQtyToDnk(btn11));

		btn12.setFont(dynaFontDialog_1_36);
		btn12.addMouseListener(myLsnrToDCirc);

		btn21.setFont(dynaFontDialog_1_36);
		btn21.addMouseListener(myLsnrToDnk);
		btn21.addMouseListener(new MyPopupMenuWCpuQtyToDnk(btn21));

		btn22.setFont(dynaFontDialog_1_36);
		btn22.addMouseListener(myLsnrToDnk);

		///////////////////////////////

		jPanel0.setLayout(myGridLayout);
		jPanel0.setDoubleBuffered(B.I);

		jPanel0.add(txtfld01);
		jPanel0.add(txtfld02);
		jPanel0.add(btn01);
		jPanel0.add(btn02);

		////////////////////////////////////////////

		jPanel1.setLayout(myGridLayout);
		jPanel1.setDoubleBuffered(B.I);

		jPanel1.add(txtfld11);
		jPanel1.add(txtfld12);
		jPanel1.add(btn11);
		jPanel1.add(btn12);

		////////////////////////////////////////////

		jPanel2.setLayout(myGridLayout);
		jPanel2.setDoubleBuffered(B.I);

		jPanel2.add(txtfld21);
		jPanel2.add(txtfld22);
		jPanel2.add(btn21);
		jPanel2.add(btn22);

		////////////////////////////////////////////

		jTabPane0.setFont(dynaFontDialog_1_14);
		jTabPane0.setDoubleBuffered(B.I);

		jTabPane0.addTab(" PcD", jPanel0);
		jTabPane0.addTab(" Dc ", jPanel1);
		jTabPane0.addTab("  D  ", jPanel2);

	}

	public static final Dimension DIM_OF_DESKTOP = Toolkit.getDefaultToolkit().getScreenSize();

	public static final float W_DESKTOP_F32 = (float) DIM_OF_DESKTOP.getWidth();

	public static final float H_DESKTOP_F32 = (float) DIM_OF_DESKTOP.getHeight();

	public static int int32Width;

	public static int int32Height;

	/**
	 * 使用者接觸到的 UI, 也是主程式進入點.<br/>
	 * The main UI of this program.
	 */
	public static void main(String[] sAry) throws Throwable {

		dynaFontDialog_1_36 = new Font(Font.DIALOG, 1, (int) (36.0F * f32ToZoom));
		dynaFontDialog_1_14 = new Font(Font.DIALOG, 1, (int) (14.0F * f32ToZoom));

		int32Width = (int) (W_DESKTOP_F32 * f32ToZoom * 0.25F);
		int32Height = (int) (H_DESKTOP_F32 * f32ToZoom * 0.20F);

		new MainToDnk();

		if (O.isDev) {

			O.l("int32Width=" + int32Width + " int32Height=" + int32Height, THIS);
			jTabPane0.setSelectedIndex(0);

		}

		myFrame = new JFrame();

		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myFrame.setSize(int32Width, int32Height);
		// mainFrame.setDoubleBuffered(B.I);

		myFrame.setContentPane(jTabPane0);

		myFrame.setLocation((int) (W_DESKTOP_F32 * 0.7F), (int) (H_DESKTOP_F32 / 4));

		myFrame.setVisible(B.I);

		O.l("If you do not like this, you may click the [X] in the upper right corner of the window.");

	}
}
