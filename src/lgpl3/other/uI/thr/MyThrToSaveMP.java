package lgpl3.other.uI.thr;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import lgpl3.comb.filter.CompaForAryOfPrime;
import lgpl3.o.O;
import lgpl3.o.time.T10;
import lgpl3.other.iO.IOr;
import lgpl3.other.uI.MySue;
import lgpl3.other.uI.MySwingva;
import lgpl3.prime64.PrimeAry2D;

/**
 * 存檔.<br/>
 * To save.
 *
 * @version 2020/02/06_11:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=MyThrToSaveMP" >MyThrToSaveMP.java</a>
 *
 * @see MyThrToSaveEP
 */
public class MyThrToSaveMP extends Thread {

	private static final Class<?> THIS = MyThrToSaveMP.class;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public MyThrToSaveMP() {

		start(); // auto start
	}

	@Override
	public void run() {

		if (MySue.moonMP.otherThr.isAlive()) {

			O.l("not save when thr alive", THIS);

			return;

		}

		if (MySue.moonMP.primeAry2D.iLen == 0) {

			O.l("not save when len=0", THIS);

			return;

		}

		//////////////////////////////////////

		String sShortFileName = MySue.MY_FILE_BASENAME + T10.timeStr().replace(3, 4, O.S95) + O.S46 + MySue.MY_TXT_FILENAME_EXTENSION;

		Path pathOfFile = Paths.get(MySue.sDefDirToSaveMP + File.separatorChar + sShortFileName);

		try {
			IOr.newDirNFile(pathOfFile);

		} catch (Throwable throwable) {

			throwable.printStackTrace();

			return;

		}

		//////////////////////////////////////

		IOr.savePrimeToFile((PrimeAry2D) MySue.moonMP.primeAry2D.sort(CompaForAryOfPrime.COMPA), pathOfFile);

		MySwingva.btnMP3.setText(MySue.MY_TXT_OK_AFT_SAVE);

		return;

	}
}