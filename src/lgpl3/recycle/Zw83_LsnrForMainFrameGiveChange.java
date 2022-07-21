package lgpl3.recycle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import lgpl3.comb.powerSet.thr.ThrGiveChange;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.str.SByN;
import lgpl3.other.jsp.Jsp;
import lgpl3.shareWXyz.Hxy;

/**
 * 我的滑鼠監聽人.<br/>
 * My MouseListener.
 *
 * @version 2021/11/29_19:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Zw83_LsnrForMainFrameGiveChange" >
 *          Zw83_LsnrForMainFrameGiveChange.java</a>
 *
 * @see Zw84_MainFrameGiveChange
 */
public class Zw83_LsnrForMainFrameGiveChange implements MouseListener {

	private static final Class<?> THIS = Zw83_LsnrForMainFrameGiveChange.class;

	public static Object tmpObj;

	public static void diy() {

		int[] base = Jsp.genAry32FromDirtyCharSeq(Zw84_MainFrameGiveChange.txtfld1.getText().trim());

		int targetV = (int) SByN.df(Zw84_MainFrameGiveChange.txtfld2.getText().trim());

		// O.l("targetV=" + targetV, THIS);

		long[] retAry = new ThrGiveChange(base, targetV, B.I).box;

		for (int idx = 0, size = retAry.length; idx != size; idx++)

			Zw84_MainFrameGiveChange.txtarea.append(Hxy.toStrByVCellPlusMinMinus1(retAry[idx], 1).append(O.C_A_L).toString());

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		tmpObj = e.getSource();

		if (tmpObj == Zw84_MainFrameGiveChange.btn1) {

			diy();

			return;

		}

		if (tmpObj == Zw84_MainFrameGiveChange.btn2) {

			Zw84_MainFrameGiveChange.txtarea.setText(null);

			return;

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
