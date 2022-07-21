package lgpl3.comb.powerSet.sample;

import lgpl3.comb.powerSet.thr.ThrGenSubset;
import lgpl3.o.B;
import lgpl3.o.O;

/**
 * To gen subset.<br/>
 * To gen subset.
 *
 * @version 2022/04/17_18:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex66_ThrGenSubset" >Ex66_ThrGenSubset.java</a>
 *
 */
public class Ex66_ThrGenSubset {

	public static void main(String[] sAry) throws Throwable {

		final int size = 11;

		ThrGenSubset thr = new ThrGenSubset(size, B.I);

		O.l(thr.toStr());
		O.l("ans=" + thr.iLen);

	}
}
