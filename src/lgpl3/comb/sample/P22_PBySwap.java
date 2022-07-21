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
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=P22_PBySwap" >src</a>
 *
 */
public class P22_PBySwap {

	public static void main(String[] sAry) throws Throwable {

		int n = 5;

		KAryV32 retKV = new KAryV32(Pnk.int64(n));

		long prefix = B64W6.genB64W6ByAry32(Ary32va.genAscAry32From1(n));

		long t0 = O.t();

		Pnk.colBySwap(prefix, n, 0, retKV);

		float tF = T64.difInF32Sec(t0);

		long[] retAry = retKV.k;

		// Aryva.sortNCheckDup(retAry);

		if (n <= 5)

			for (int idx = 0; idx != retAry.length; idx++)

				O.l(B64W6.strByVCellMinus1BySAry(retAry[idx], O.S_ARY_A_Z));
		// O.l(B64W6.strByVCellMinus1AftRevBySAry(retAry[idx], O.S_ARY_A_Z));

		O.l("len=" + O.f(O.eq(retKV.v, Pnk.int64(n))));
		O.l("costT=" + tF);
		O.l("nOfCall=" + O.f(B.n32));

		B.n32 = 0;

	}
}