package lgpl3.comb.sample;

import lgpl3.comb.thr.PeerByThrToDWNEqK;

/**
 * 環狀排列且全錯排.<br/>
 * Derangement and circular permutation.
 *
 * @version 2020/03/27_18:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=D13_PeerByThrToDnk">D13_PeerByThrToDnk.java</a>
 *
 */
public class D13_PeerByThrToDnk {

	public static void main(String[] sAry) throws Throwable {

		int n = 12;
		int k = 7;
		int numOfThr = 4;

		PeerByThrToDWNEqK thr = new PeerByThrToDWNEqK();
		thr.n = n;
		thr.k = k;
		thr.numOfThr = numOfThr;

		thr.start();

	}
}
