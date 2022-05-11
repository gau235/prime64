package lgpl3.comb.sample;

import lgpl3.comb.thr.PeerByThrToDCirc;

/**
 * 環狀排列且全錯排.<br/>
 * Derangement and circular permutation.
 *
 * @version 2020/06/06_21:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=D44_PeerByThrToDCircBatch" >
 *          D44_PeerByThrToDCircBatch.java</a>
 *
 * @see P93_PCircAsDnk
 * 
 * @see P96_ThrToPCircAsDnk
 * 
 * @see P98_PeerByThrToPCircAsDnk
 * 
 * @see D44_PeerByThrToDCircBatch
 */
public class D44_PeerByThrToDCircBatch {

	public static void main(String[] sAry) throws Throwable {

		int nTime = 5;
		for (int i = 0; i != nTime; i++) {

			int n = 18;
			int k = 10;
			int numOfThr = 4;

			PeerByThrToDCirc thr = new PeerByThrToDCirc();
			thr.n = n;
			thr.k = k;
			thr.numOfThr = numOfThr;

			thr.start();
			thr.join();

		}
	}
}
