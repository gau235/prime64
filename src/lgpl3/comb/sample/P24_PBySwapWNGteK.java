package lgpl3.comb.sample;

import lgpl3.comb.Pnk;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Ary32va;
import lgpl3.o.keyNV.KAryV32;
import lgpl3.o.time.T64;

/**
 * Permutation.<br/>
 * Permutation.
 *
 * @version 2022/06/25_00:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=P24_PBySwapWNGteK" >src</a>
 *
 */
public class P24_PBySwapWNGteK {

	public static void main(String[] sAry) throws Throwable {

		int n = 6;
		int k = 4; // lv

		KAryV32 retKV = new KAryV32(Pnk.int64(n, k));

		long prefix = B64W6.genB64W6ByAry32(Ary32va.genAscAry32From1(n));

		long t0 = O.t();

		Pnk.colBySwapWNGteK(prefix, n, 0, retKV, k);

		float tF = T64.difInF32Sec(t0);

		long[] retAry = retKV.k;

		if (k <= 5)

			for (int idx = 0; idx != retAry.length; idx++)

				O.l(B64W6.strByVCellMinus1BySAry(retAry[idx], O.S_ARY_A_Z));

		O.l("len=" + O.f(O.eq(retKV.v, Pnk.int64(n, k))));
		O.l("costT=" + tF);
		O.l("nOfCall=" + O.f(B.n32));

		B.n32 = 0;

	}
}