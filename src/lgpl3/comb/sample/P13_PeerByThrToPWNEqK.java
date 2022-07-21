package lgpl3.comb.sample;

import lgpl3.comb.thr.PeerByThrToPWNEqK;

/**
 * 排列.<br/>
 * Permutation.
 *
 * @version 2020/09/27_16:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=P13_PeerByThrToPWNEqK" >
 *          P13_PeerByThrToPWNEqK.java</a>
 */
public class P13_PeerByThrToPWNEqK {

	public static void main(String[] args) throws Throwable {

		int n = 14;
		int k = 10;
		int numOfThr = 4;

		PeerByThrToPWNEqK peer = new PeerByThrToPWNEqK();
		peer.n = n;
		peer.k = k;
		peer.numOfThr = numOfThr;

		peer.start();

		// O.eqX(ary.length, Dnk.int64(n, k));
		// O.l("len=" + ary.length);

	}
}
