package lgpl3.comb.sample;

import lgpl3.comb.PInEx;
import lgpl3.comb.Pnk;
import lgpl3.o.O;
import lgpl3.o.ary.Aryva;

/**
 * 排容原理.<br/>
 * 例如 :<br/>
 * A, B, C, D 排成一列, 但 A 不排第 1 位, B 不排第 2 位的方法數 :<br/>
 * 為 4 人有 2 人是限定條件 inEx(4,2).<br/>
 * <br/>
 * To return the inclusion and exclusion function result, the number of<br/>
 * that n people line up but k guys not at their position.<br/>
 * PInEx(n,k)=C(k,0)*n! -C(k,1)*(n-1)! +C(k,2)*(n-2)! - ... +-C(k,k)*(n-k)!
 *
 * @version 2022/06/22_11:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=P84_InEx" >src</a>
 */
public class P84_InEx {

	public static void main(String[] sAry) throws Throwable {

		int n = 5;
		int k = 3;

		int headKToEx = 2;

		// int allBit = ~(-0b1 << n);

		// KAryV32 retKV = new KAryV32(PInEx.int64(n, k, headKToEx));

		// O.l("ans=" + PInEx.int64(n, k, headKToEx));

		// PInEx.colWNEqK(allBit, allBit, headKToEx, (-allBit & allBit), 0b0L, retKV, 1);

		// long[] ary = retKV.k;

		long[] ary = PInEx.col(n, k, headKToEx);

		Aryva.sortNCheckDup(ary);

		O.l(Pnk.strByAryOfRevB64W6BySAry(ary, O.S_ARY_A_Z));

		O.l("len=" + O.eq(ary.length, PInEx.int64(n, k, headKToEx)));

	}
}
