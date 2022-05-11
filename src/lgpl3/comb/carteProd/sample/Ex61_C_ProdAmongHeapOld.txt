package lgpl3.comb.carteProd.sample;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.comb.carteProd.CarteProdCnk;
import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Seq;

/**
 * @version 2020/03/18_21:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex61_C_ProdAmongHeapOld" >
 *          Ex61_C_ProdAmongHeapOld.java</a>
 *
 * @see Ex65_P_ProdAmongHeap
 */
public abstract class Ex61_C_ProdAmongHeapOld {

	public static void main(String[] sAry) throws Throwable {

		long b64W6WAllV = B64W6.genB64W6ByAry32(2, 1, 2);
		O.l("b64W6WAllV=" + O.L + B64W6.str24(b64W6WAllV));

		int n = B64W6.sum32(b64W6WAllV) + 1;

		Arr<Seq> arrOfSeq = CarteProdCnk.oldProdAmongHeap(n, b64W6WAllV);

		O.eq(arrOfSeq.iLen, CarteProdCnk.mulAmongHeap(n, B64W6.easySortAftTotalVCell(b64W6WAllV)));

		O.l(CarteProdCnk.toStrByArrOfSeq(arrOfSeq, O.S_ARY_A_Z, O.S9, O.L));

	}
}
