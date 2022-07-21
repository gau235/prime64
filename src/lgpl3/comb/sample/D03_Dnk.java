package lgpl3.comb.sample;

import lgpl3.comb.Dnk;
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
 * @version 2022/06/23_12:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=D03_Dnk" >src</a>
 */
public class D03_Dnk {

	public static void main(String[] sAry) throws Throwable {

		int n = 10;
		int k = 3;

		long[] ary = Dnk.col(n, k);

		Aryva.sortNCheckDup(ary);

		StringBuilder str;

		str = Dnk.htmlWHead(ary, O.S_ARY_A_Z, O.S_ARY_A_Z, "tabForPInEx");
		// Strva.toHtmlStrWOrderToDerByAryOfB64W6(aryOfB64W6, sAry, sHtmlClass);
		str = Pnk.strWWornHeadByAryOfRevB64W6(ary, O.S_ARY_A_Z, O.S_ARY_A_Z, O.L);
		str = Pnk.strByAryOfRevB64W6BySAry(ary, O.S_ARY_A_Z);

		O.l(str);

		O.l("len=" + O.eq(ary.length, Dnk.int64(n, k)));

	}
}
