package lgpl3.other.uI.thr;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import lgpl3.o.O;
import lgpl3.o.str.SByN;
import lgpl3.other.iO.IOr;
import lgpl3.other.uI.MySue;

/**
 * 存檔.<br/>
 * To save.
 *
 * @version 2022/05/06_11:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=MyThrToSaveErr" >src</a>
 *
 * @see MyThrToSaveEP
 */
public class MyThrToSaveErr extends Thread {

	private static final Class<?> THIS = MyThrToSaveErr.class;

	public CharSequence note;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public MyThrToSaveErr(CharSequence note) {

		this.note = note;

		start(); // auto start

	}

	@Override
	public void run() {

		O.l("HERE", THIS);

		Path pathOfFile = Paths.get(MySue.sDefDirToSaveMP + File.separatorChar + SByN.genPadded0Str("err", 4, ".txt"));

		try {
			IOr.toUtf8FileAftNew(pathOfFile, note);

		} catch (IOException iOEx) {

			O.l(iOEx.toString(), THIS);
		}
	}
}