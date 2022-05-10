package lgpl3.other.sample;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * The public Pane; the public Panel.
 *
 * @version 2020/09/14_14:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex090_MainFrame" >Ex090_MainFrame.java</a>
 *
 * @see Ex091_LsnrForMainFrame
 */
public class Ex090_MainFrame {

	private static final Class<?> THIS = Ex090_MainFrame.class;

	public static JTextField txtfld1 = new JTextField("13");
	public static JTextField txtfld2 = new JTextField("5");

	public static JButton btn1 = new JButton(">");
	public static JButton btn2 = new JButton();

	public static Ex091_LsnrForMainFrame ex091_LsnrForMainFrame = new Ex091_LsnrForMainFrame();

	public static JTextArea txtarea = new JTextArea();

	public static JScrollPane scrlpane = new JScrollPane();

	public static GridBagConstraints gridBagConstr = new GridBagConstraints();

	public static JPanel jPanel = new JPanel();

	public static JTabbedPane jTabbedPane = new JTabbedPane(JTabbedPane.BOTTOM, JTabbedPane.SCROLL_TAB_LAYOUT);

	public static JFrame mainFrame = new JFrame();

	public static Font dynaFontDialog_1_35;

	public static float f32ToZoom = 1.0F;

	public Ex090_MainFrame() {

		// setDoubleBuffered

		// txtfld1.setPreferredSize(new Dimension(100, 35));
		txtfld1.setFont(dynaFontDialog_1_35);
		txtfld1.setHorizontalAlignment(JTextField.RIGHT);

		// txtfld2.setPreferredSize(new Dimension(100, 35));
		txtfld2.setFont(dynaFontDialog_1_35);
		txtfld2.setHorizontalAlignment(JTextField.RIGHT);

		// btn1.setPreferredSize(new Dimension(70, 35));
		btn1.setFont(dynaFontDialog_1_35);
		btn1.addMouseListener(ex091_LsnrForMainFrame);

		// btn2.setPreferredSize(new Dimension(70, 35));
		btn2.setFont(dynaFontDialog_1_35);
		btn2.addMouseListener(ex091_LsnrForMainFrame);

		// txtarea.setPreferredSize(new Dimension(500, 300));
		txtarea.setDoubleBuffered(B.I);
		txtarea.setFont(dynaFontDialog_1_35);
		// txtarea.setEditable(B.O);

		scrlpane.setDoubleBuffered(B.I);
		scrlpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrlpane.setViewportView(txtarea);

		///////////////////////////////

		double myY1 = 0.00;

		jPanel.setLayout(new GridBagLayout());

		gridBagConstr.gridx = 0; // txtfld1
		gridBagConstr.gridy = 0;
		gridBagConstr.gridwidth = 1;
		gridBagConstr.gridheight = 1;
		gridBagConstr.weightx = 0.3;
		gridBagConstr.weighty = myY1;

		gridBagConstr.fill = GridBagConstraints.BOTH;

		jPanel.add(txtfld1, gridBagConstr);

		gridBagConstr.gridx = 1;// txtfld2
		gridBagConstr.gridy = 0;
		gridBagConstr.gridwidth = 1;
		gridBagConstr.gridheight = 1;
		gridBagConstr.weightx = 0.3;
		gridBagConstr.weighty = myY1;

		gridBagConstr.fill = GridBagConstraints.BOTH;

		jPanel.add(txtfld2, gridBagConstr);

		gridBagConstr.gridx = 2;// btn1
		gridBagConstr.gridy = 0;
		gridBagConstr.gridwidth = 1;
		gridBagConstr.gridheight = 1;
		gridBagConstr.weightx = 0.2;
		gridBagConstr.weighty = myY1;

		gridBagConstr.fill = GridBagConstraints.BOTH;

		jPanel.add(btn1, gridBagConstr);

		gridBagConstr.gridx = 3; // btn2
		gridBagConstr.gridy = 0;
		gridBagConstr.gridwidth = 1;
		gridBagConstr.gridheight = 1;
		gridBagConstr.weightx = 0.2;
		gridBagConstr.weighty = myY1;

		gridBagConstr.fill = GridBagConstraints.BOTH;

		jPanel.add(btn2, gridBagConstr);

		gridBagConstr.gridx = 0; // scrlpane
		gridBagConstr.gridy = 1;
		gridBagConstr.gridwidth = 4;
		gridBagConstr.gridheight = 1;
		gridBagConstr.weightx = 1;
		gridBagConstr.weighty = 1.0 - myY1; // important

		gridBagConstr.fill = GridBagConstraints.BOTH;

		jPanel.add(scrlpane, gridBagConstr);

		////////////////////////////////////////////

		jTabbedPane.addTab("Test", jPanel);

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
	public static void main(String[] sAry) {

		dynaFontDialog_1_35 = new Font(Font.DIALOG, 1, (int) (35.0F * f32ToZoom));

		int32Width = (int) (W_DESKTOP_F32 * f32ToZoom * 0.37F);
		int32Height = (int) (H_DESKTOP_F32 * f32ToZoom * 0.34F);

		O.l("int32Width=" + int32Width + O.S32 + "int32Height=" + int32Height, THIS);

		new Ex090_MainFrame();

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainFrame.setSize(int32Width, int32Height);

		mainFrame.setContentPane(jTabbedPane);

		mainFrame.setLocation((int) (W_DESKTOP_F32 / 3), (int) (H_DESKTOP_F32 / 4));

		mainFrame.setVisible(B.I);

	}
}
