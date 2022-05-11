package lgpl3.comb.sample;

import lgpl3.comb.Cnk;
import lgpl3.comb.thr.ThrToCBySpareB64As2Pow;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Ary32va;
import lgpl3.shuffle.Shuffler;

/**
 * 組合 (取物).<br/>
 * Combination.
 *
 * @version 2022/04/13_23:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex289_ThrToCBySpareB64As2Pow" >
 *          Ex289_ThrToCBySpareB64As2Pow.java</a>
 */
public class Ex289_ThrToCBySpareB64As2Pow {

	public static void main(String[] sAry) throws Throwable {

		int n = 5;
		int k = 3;

		int[] ary32 = Cnk.colRecur(n, k);
		O.l("C(" + n + "," + k + ")=" + O.f(ary32.length));

		int tmp32 = ~(-0b1 << n);
		tmp32 <<= 4;

		String spareS = Integer.toString(tmp32, 2);
		O.l("spareS=" + spareS);

		spareS = new String(Shuffler.shuffle(spareS.toCharArray()));
		O.l("spareSAftShuffle=" + spareS);

		long allBit = Integer.parseInt(spareS, 2);

		// long allBit = 0b1110;

		ThrToCBySpareB64As2Pow thrToC = new ThrToCBySpareB64As2Pow(allBit, k, B.I);

		O.l(Cnk.strByAryOfB64As2Pow(thrToC.box));

		O.l("len=" + O.f(O.eq(thrToC.iLen, Ary32va.checkDup(ary32).length)));

		O.l("B.n32=" + B.n32);

		B.n32 = 0; // fuck

	}
}
