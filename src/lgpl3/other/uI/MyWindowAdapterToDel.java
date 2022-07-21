package lgpl3.other.uI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import lgpl3.o.O;
import lgpl3.other.iO.IOr;

/**
 * 我的滑鼠監聽人.<br/>
 * My MouseListener.
 *
 * @version 2022/05/12_14:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=MyWindowAdapterToDel" >src</a>
 *
 */
public class MyWindowAdapterToDel extends WindowAdapter {

	private static final Class<?> THIS = MyWindowAdapterToDel.class;

	@Override
	public void windowClosing(WindowEvent e) {

		// 有上台 有下台
		try {
			IOr.delDirRecur(MySue.defPathOfDirToSaveMP); // new ThrToCmd(S_ARY_FOR_CMD_TO_DEL);

		} catch (IOException iOEx) {

			O.l(iOEx.toString(), THIS);
		}
	}
}
