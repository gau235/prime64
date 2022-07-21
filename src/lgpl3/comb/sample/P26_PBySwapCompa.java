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
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=P26_PBySwapCompa" >src</a>
 *
 */
public class P26_PBySwapCompa {

	public static void main(String[] sAry) throws Throwable {

		int n = 10;

		KAryV32 kV = new KAryV32(Pnk.int64(n));

		long prefix = B64W6.genB64W6ByAry32(Ary32va.genAscAry32From1(n)), retAry[] = kV.k, t0;

		t0 = O.t();

		Pnk.colBySwap(prefix, n, 0, kV);

		float tF = T64.difInF32Sec(t0);

		if (n <= 5)

			for (int idx = 0; idx != retAry.length; idx++)

				O.l(B64W6.strByVCellMinus1BySAry(retAry[idx], O.S_ARY_A_Z));

		O.l("len=" + O.f(O.eq(retAry.length, Pnk.int64(n))));
		O.l("costT=" + tF);
		O.l("nOfCall=" + O.f(B.n32));

		B.n32 = 0;

		O.l("===================================");

		kV.v = 0; // reset

		t0 = O.t();

		Pnk.colRecurWNGteK(~(-0b1 << n), 0b0L, kV, n);

		tF = T64.difInF32Sec(t0);

		if (n <= 5)

			O.l(Pnk.strByAryOfRevB64W6BySAry(kV.k, O.S_ARY_A_Z));

		O.l("len=" + O.f(O.eq(kV.v, Pnk.int64(n))));
		O.l("costT=" + tF);
		O.l("nOfCall=" + O.f(B.n32));

		B.n32 = 0;

	}
}