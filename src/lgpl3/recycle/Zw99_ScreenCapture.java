package lgpl3.recycle;

import java.awt.AWTException;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.other.uI.MySue;
import lgpl3.other.uI.MySwingva;

/**
 * The screen capture.
 *
 * @version 2021/11/29_19:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Zw99_ScreenCapture" >Zw99_ScreenCapture.java</a>
 *
 */
public class Zw99_ScreenCapture implements MouseListener {

	public static final Dimension DIM_OF_DESKTOP = Toolkit.getDefaultToolkit().getScreenSize();

	public static final float W_DESKTOP_F32 = (float) DIM_OF_DESKTOP.getWidth();

	public static final float H_DESKTOP_F32 = (float) DIM_OF_DESKTOP.getHeight();

	public static final Font MY_FONT = new Font(Font.DIALOG, Font.BOLD, 28);

	public static JTextField txtfld1 = new JTextField("256");
	public static JTextField txtfld2 = new JTextField("63");
	public static JTextField txtfld3 = new JTextField("768");
	public static JTextField txtfld4 = new JTextField("467");

	public static JButton btn1 = new JButton("dir");

	public static JButton btn2 = new JButton("@");

	public static JFrame mainFrame = new JFrame();

	public static Robot genRobot() {

		try {
			return new Robot();

		} catch (AWTException awtEx) {

			awtEx.printStackTrace();

			return null;

		}
	}

	public static final Robot ROBOT = genRobot();

	public static Path genPathOfDir() {

		try {
			return Files.createDirectories(Paths.get(O.Z).toAbsolutePath().resolve(MySue.S_TMP_DIR));

		} catch (IOException iOEx) {

			iOEx.printStackTrace();

			return null;

		}
	}

	public static Path pathOfDir = genPathOfDir();

	public static int iForName = 11;

	public static void screenCapture(int x, int y, int w, int h) throws IOException {

		O.l(new String[] { "x", "n", "w", "h" });
		O.l(new int[] { x, y, w, h });

		File pngFile;
		while ((pngFile = pathOfDir.resolve((iForName++) + ".png").toFile()).exists()) // while 只有一句
			;

		BufferedImage bufferedImg = ROBOT.createScreenCapture(new Rectangle(x, y, w, h));
		ImageIO.write(bufferedImg, "png", pngFile);

	}

	public Zw99_ScreenCapture() {

		// setDoubleBuffered

		txtfld1.setHorizontalAlignment(JTextField.RIGHT);
		txtfld1.setBackground(MySwingva.COLOR_TXT_BACKGROUND);
		txtfld1.setFont(MY_FONT);

		txtfld2.setHorizontalAlignment(JTextField.RIGHT);
		txtfld2.setBackground(MySwingva.COLOR_TXT_BACKGROUND);
		txtfld2.setFont(MY_FONT);

		txtfld3.setHorizontalAlignment(JTextField.RIGHT);
		txtfld3.setBackground(MySwingva.COLOR_TXT_BACKGROUND);
		txtfld3.setFont(MY_FONT);

		txtfld4.setHorizontalAlignment(JTextField.RIGHT);
		txtfld4.setBackground(MySwingva.COLOR_TXT_BACKGROUND);
		txtfld4.setFont(MY_FONT);

		btn1.setFont(MY_FONT);
		btn1.addMouseListener(this);

		btn2.setFont(MY_FONT);
		btn2.addMouseListener(this);

		Container contentPane = mainFrame.getContentPane();

		/////////////////////////////////////

		contentPane.setLayout(new GridLayout(0, 1)); // why can not GridLayout

		contentPane.add(txtfld1);
		contentPane.add(txtfld2);
		contentPane.add(txtfld3);
		contentPane.add(txtfld4);

		contentPane.add(btn1);
		contentPane.add(btn2);

		//////////////////////////////////////

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		if (e.getSource() == btn1) {

			try {
				MySue.MY_DESKTOP.open(pathOfDir.toFile());

			} catch (IllegalArgumentException | IOException ex) {

				ex.printStackTrace();
			}

		} else {

			try {
				screenCapture(Integer.parseInt(txtfld1.getText().trim()), Integer.parseInt(txtfld2.getText().trim()),
						Integer.parseInt(txtfld3.getText().trim()), Integer.parseInt(txtfld4.getText().trim()));

			} catch (IOException iOEx) {

				iOEx.printStackTrace();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	/**
	 * 使用者接觸到的 UI, 也是主程式進入點.<br/>
	 * The main UI of this program.
	 */
	public static void main(String[] sAry) {

		new Zw99_ScreenCapture();

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainFrame.setSize((int) (W_DESKTOP_F32 / 11), (int) (H_DESKTOP_F32 / 2.2F));

		mainFrame.setLocation((int) (W_DESKTOP_F32 / 1.17), (int) (H_DESKTOP_F32 / 4));

		mainFrame.setVisible(B.I);

	}
}
