package lgpl3.other.uI.thr;

import java.io.File;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;
import java.nio.file.Paths;

import lgpl3.o.O;
import lgpl3.o.time.T10;
import lgpl3.other.iO.IOr;
import lgpl3.other.uI.MySue;
import lgpl3.other.uI.MySwingva;

/**
 * 存檔.<br/>
 * To save.
 *
 * @version 2021/08/26_13:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=MyThrToSaveEP" >MyThrToSaveEP.java</a>
 *
 * @see MyThrToSaveMP
 */
public class MyThrToSaveEP extends Thread {

	private static final Class<?> THIS = MyThrToSaveEP.class;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public MyThrToSaveEP() {

		start(); // auto start
	}

	@Override
	public void run() {

		if (MySue.fanOfMarker.isAlive()) {

			O.l("not save when thr alive", THIS);

			return;

		}

		//////////////////////////////////////

		Path pathOfFile = Paths.get(MySue.sDefDirToSaveMP + File.separatorChar + MySue.MY_FILE_BASENAME +

				T10.timeStr().replace(3, 4, O.S95) + O.S46 + MySue.MY_TXT_FILENAME_EXTENSION);

		try {
			IOr.newDirNFile(pathOfFile);

		} catch (Throwable throwable) {

			if (!(throwable instanceof FileAlreadyExistsException))

				O.l(throwable.toString(), THIS);

			return;

		}

		//////////////////////////////////////

		IOr.savePrimeToFile(MySue.fanOfMarker.box, MySue.fanOfMarker.oriN1, MySue.fanOfMarker.oriN2, pathOfFile);

		MySwingva.btnEP3.setText(MySue.MY_TXT_OK_AFT_SAVE);

		return;

	}
}