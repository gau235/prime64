package lgpl3.comb.sample;

import lgpl3.comb.Cnk;
import lgpl3.comb.thr.ThrCnkBySpareB64;
import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 組合 (取物).<br/>
 * Combination.
 *
 * @version 2022/07/09_00:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex290_ThrCnkBySpareB64Old" >src</a>
 */
public class Ex290_ThrCnkBySpareB64Old {

	public static void main(String[] sAry) throws Throwable {

		int n = 5;
		int k = 4;

		int oriAllBit = ~(-0b1 << n);

		ThrCnkBySpareB64 thrC = new ThrCnkBySpareB64(oriAllBit, k, B.O);

		thrC.oldColRecur(oriAllBit, 0b0L, (-oriAllBit & oriAllBit), k);

		O.l(thrC.box);

		// O.eq(thrC.box.length, Cnk.int64(n, k));

		O.l(Cnk.strByAryOfB64As2Pow(thrC.box));

	}

	public static void main2(String[] sAry) throws Throwable {

		int n = 5;
		int k = 2;

		long allBit = ~(-0b1 << n);

		long rmdBit = allBit;

		long firstBit = -rmdBit & rmdBit;

		rmdBit = ~firstBit & rmdBit;

		long secBit = -rmdBit & rmdBit;

		ThrCnkBySpareB64 thrC = new ThrCnkBySpareB64(rmdBit, k - 1, B.O);

		thrC.oldColRecur(rmdBit, firstBit, secBit, k - 1);

		O.l(thrC.box);

		O.eq(thrC.box.length, Cnk.int64(n - 1, k - 1));

		O.l(Cnk.strByAryOfB64As2Pow(thrC.box));

	}
}
