package lgpl3.comb.sample;

import lgpl3.comb.Cnk;
import lgpl3.o.O;
import lgpl3.o.time.T64;

/**
 * To compare all the combination method.<br/>
 * To compare all the combination method.
 *
 * @version 2021/05/22_21:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex295_CompaOverC" >Ex295_CompaOverC.java</a>
 *
 */
public class Ex295_CompaOverC {

	public static void main(String[] sAry) throws Throwable {

		int n = 18;
		int k = 9;

		int nOfTest = 500;

		long t640;

		t640 = O.t();

		for (int i = 0; i != nOfTest; i++)
			Cnk.colByLoopBreadthFirst(n, k);

		O.l("colByLoop T=" + T64.difInF32Sec(t640));

		t640 = O.t();

		for (int i = 0; i != nOfTest; i++)
			Cnk.colRecur(n, k);

		O.l("colRecur T=" + T64.difInF32Sec(t640));

	}
}
