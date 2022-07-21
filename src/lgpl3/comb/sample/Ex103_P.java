package lgpl3.comb.sample;

import lgpl3.comb.Pnk;
import lgpl3.o.O;
import lgpl3.o.keyNV.KAryV32;

/**
 * 排列.<br/>
 * Permutation.
 *
 * @version 2022/02/02_21:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex103_P" >Ex103_P.java</a>
 */
public class Ex103_P {

	public static void main(String[] sAry) throws Throwable {

		int n = 5;
		int k = 4;

		KAryV32 kAryV32 = new KAryV32(Pnk.int64(n, k));

		Pnk.colRecurWNGteK(~(-0b1 << n), 0b0L, kAryV32, k);

		O.l(Pnk.strByAryOfRevB64W6BySAry(kAryV32.k, O.S_ARY_A_Z));

		O.l("len=" + O.eq(Pnk.colRecur(n, k).length, Pnk.int64(n, k)));

	}
}
