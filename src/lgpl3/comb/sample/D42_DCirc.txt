package lgpl3.comb.sample;

import lgpl3.comb.DCirc;
import lgpl3.comb.Pnk;
import lgpl3.comb.b64W6.B64W6;
import lgpl3.comb.thr.ThrToDCirc;
import lgpl3.o.O;
import lgpl3.o.time.T64;

/**
 * 環狀排列且全錯排.<br/>
 * Derangement and circular permutation.
 *
 * @version 2020/06/06_21:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=D42_DCirc" >D42_DCirc.java</a>
 *
 * @see P93_PCircAsDnk
 *
 * @see P96_ThrToPCircAsDnk
 *
 * @see P98_PeerByThrToPCircAsDnk
 *
 * @see D42_DCirc
 */
public class D42_DCirc {

	public static void main(String[] sAry) throws Throwable {

		int n = 4;
		int k = 4;

		long t0 = O.t();

		ThrToDCirc thrToDCirc = new ThrToDCirc();
		thrToDCirc.col(n, k);

		long[] ary = thrToDCirc.box.trim().ary;

		O.l("ans=" + DCirc.int64(n, k));

		O.eq(thrToDCirc.count32, DCirc.int64(n, k));
		O.eq(ary.length, DCirc.int64(n, k));

		// java.util.Arrays.sort(ary);

		// O.l("firstRow=" + B64W6.str24(ary[0]));
		O.l("firstRow=" + B64W6.strByVCellMinus1AftRevBySAry(ary[0], O.S_ARY_A_Z));

		StringBuilder str;
		str = Pnk.strByAryOfRevB64W6BySAry(ary, O.S_ARY_A_Z);
		O.l(str);

		O.l("len=" + O.f(ary.length));
		O.l("costT=" + T64.difInF32Sec(t0));

	}
}
