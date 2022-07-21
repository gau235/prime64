package lgpl3.other.uI;

import java.awt.Color;
import java.awt.Font;
import java.nio.charset.Charset;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.other.uI.thr.MyThrToShowCpuLoad;

/**
 * 本類別是主程式進入點.<br/>
 * The main method of this program.
 *
 * @version 2022/05/07_19:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Main" >Main.java</a>
 *
 */
public abstract class Main extends MySwingva {

	private static final Class<?> THIS = Main.class;

	public static final String S_ZOOM_EQ = "zoom=";

	/**
	 * To initialize UIManager.
	 */
	public static void initUIManager() {

		// ColorUIResource oldProgrBarSelectionBackground = (ColorUIResource) UIManager.getDefaults().get(
		// "ProgressBar.selectionBackground");
		// ColorUIResource oldProgrBarSelectionForeground = (ColorUIResource) UIManager.getDefaults().get(
		// "ProgressBar.selectionForeground");

		UIManager.put("ProgressBar.selectionForeground", COLOR_TXT_BACKGROUND);
		// progrBar.updateUI();

		UIManager.put("ProgressBar.selectionBackground", COLOR_TXT_BACKGROUND);
		// UIManager.put("ProgressBar.selectionBackground", Color.RED);

		UIManager.put("MenuItem.disabledForeground", Color.BLACK);
		// menuItemToOpenDir.updateUI();

		UIManager.put("OptionPane.buttonFont", dynaFontDialog_1_17);

		// UIManager.put("OptionPane.font", dynaFontDialog_1_17);

		UIManager.put("OptionPane.messageFont", dynaFontDialog_1_26);

	}

	/**
	 * To initial for the developer.<br/>
	 * To initial for the developer.
	 */
	public static void initForDev() {

		if (O.isDev) {

			String sCmd = "\njava -cp ./*; -jar prime64Lgpl3_xxx.jar zoom=1.2";

			txtareaDiy0.append(sCmd);

			// tabbedPane0.setSelectedIndex(1);

		}
	}

	/**
	 * 使用者接觸到的 UI, 也是主程式進入點.<br/>
	 * The main UI of this program.
	 */
	public static void main(String[] sAry) {

		// O.isDev = B.O;

		try {
			if (sAry.length != 0)

				f32ToZoom = Float.parseFloat(sAry[0].replace(S_ZOOM_EQ, O.Z));

		} catch (Throwable throwable) {

			throwable.printStackTrace();
		}

		////////////////////////////////////////////////

		if (O.isDev) {

			O.l("f32ToZoom=" + f32ToZoom, THIS);
			O.l("file.encoding=" + System.getProperty("file.encoding"), THIS);
			O.l("defaultCharset=" + Charset.defaultCharset(), THIS);

			O.l("繁體中文", THIS); // why Zulu java 7 console can not show this
			O.l("简体中文", THIS); // why Zulu java 7 console can not show this

			O.getSysUserDotName();

		}

		dynaFontDialog_1_17 = new Font(Font.DIALOG, 1, (int) (17.0F * f32ToZoom)); // MP5 for tablet
		dynaFontDialog_1_26 = new Font(Font.DIALOG, 1, (int) (26.0F * f32ToZoom)); // rec
		dynaFontDialog_1_43 = new Font(Font.DIALOG, 1, (int) (43.0F * f32ToZoom)); // big txtfld

		metricOfFontDialog_1_26 = TMP_CONTAINER.getFontMetrics(dynaFontDialog_1_26);
		metricOfFontDialog_1_30 = TMP_CONTAINER.getFontMetrics(dynaFontDialog_1_43);

		hOfFontDialog_1_26 = metricOfFontDialog_1_26.getAscent() /* + metricOfFontDialog_1_26.getDescent() */;

		int32Width = (int) (W_SCREEN_F32 * f32ToZoom * 0.60F);
		int32Height = (int) (H_SCREEN_F32 * f32ToZoom * 0.65F);

		if (O.isDev)

			O.l("int32Width=" + int32Width + " int32Height=" + int32Height, THIS);

		//////////////////////////////////////////////////////////

		try {
			MySue.defPathOfDirToSaveMP = Paths.get(O.Z).toAbsolutePath().resolve(MySue.S_TMP_DIR);
			// Files.createDirectories(MyAide.defPathOfDirToSaveMP);

			MySue.defDirToSaveMP = MySue.defPathOfDirToSaveMP.toFile();

		} catch (Throwable throwable) {

			throwable.printStackTrace();

			return;

		}

		MySue.sDefDirToSaveMP = MySue.defPathOfDirToSaveMP.toString(); // fuck

		initUIManager(); // must be here

		new MySwingva();

		initForDev();

		mainFrame = new JFrame();

		if (O.isDev)

			mainFrame.addWindowListener(new MyWindowAdapterToDel());

		// mainFrame.setUndecorated(B.I); // remove 默认边框后，不能拖动

		mainFrame.setSize(int32Width, int32Height);

		mainFrame.setBackground(COLOR_BACKGROUND);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // DISPOSE_ON_CLOSE

		mainFrame.setContentPane(tabbedPane0);
		// mainFrame.getRootPane().setBorder(EMPTY_BORDER);

		mainFrame.setLocation((W_SCREEN - int32Width) / 2, (H_SCREEN - int32Height) / 4);
		// mainFrame.setResizable(B.O);
		// mainFrame.setUndecorated(B.I);
		// mainFrame.setFont(dynaFontDialog_1_43);

		// mainFrame.pack();
		mainFrame.setVisible(B.I);

		// O.l("mainFrame location=" + mainFrame.getLocation(), THIS);

		txtfldMP0.requestFocusInWindow();
		// txtfldMP0.selectAll();

		new MyThrToShowCpuLoad();

	}
}
