package lgpl3.comb.sample;

import lgpl3.comb.thr.PeerByThrToPCircAsDnk;

/**
 * 環狀排列且全錯排.<br/>
 * Derangement and circular permutation.
 *
 * @version 2020/03/27_18:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=P98_PeerByThrToPCircAsDnk" >
 *          P98_PeerByThrToPCircAsDnk.java</a>
 * 
 */
public class P98_PeerByThrToPCircAsDnk {

	public static void main(String[] sAry) throws Throwable {

		int n = 12;
		int k = 10;
		int numOfThr = 8;

		PeerByThrToPCircAsDnk thr = new PeerByThrToPCircAsDnk();
		thr.n = n;
		thr.k = k;
		thr.numOfThr = numOfThr;

		thr.start();

	}
}
