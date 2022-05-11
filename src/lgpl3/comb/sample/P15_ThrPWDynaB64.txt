package lgpl3.comb.sample;

import lgpl3.comb.Pnk;
import lgpl3.comb.thr.ThrPWDynaB64;
import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 排列.<br/>
 * Permutation.
 *
 * @version 2020/10/20_22:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=P15_ThrPWDynaB64" >P15_ThrPWDynaB64.java</a>
 */
public class P15_ThrPWDynaB64 {

	public static void main(String[] args) throws Throwable {

		int n = 60;
		int k = 2;

		ThrPWDynaB64 thr = new ThrPWDynaB64(n, k, B.I);

		O.l(thr.toStr());

		O.l("len=" + O.eq(thr.box.iLen, Pnk.int64(n, k)));

	}
}
