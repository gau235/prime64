package lgpl3.comb.sample;

import lgpl3.comb.thr.PeerByThrToDCirc;

/**
 * 環狀排列且全錯排.<br/>
 * Derangement and circular permutation.
 *
 * @version 2020/05/22_14:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=D43_PeerByThrToDCirc" >
 *          D43_PeerByThrToDCirc.java</a>
 * 
 */
public class D43_PeerByThrToDCirc {

	public static void main(String[] sAry) throws Throwable {

		int n = 11;
		int k = 10;
		int numOfThr = 4;

		PeerByThrToDCirc thr = new PeerByThrToDCirc();
		thr.n = n;
		thr.k = k;
		thr.numOfThr = numOfThr;

		thr.start();

	}
}
