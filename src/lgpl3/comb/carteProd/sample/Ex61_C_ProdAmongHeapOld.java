package lgpl3.comb.carteProd.sample;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.comb.carteProd.CarteProdCnk;
import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Seq;

/**
 * @version 2022/07/09_00:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex61_C_ProdAmongHeapOld" >src</a>
 *
 * @see Ex65_P_ProdAmongHeap
 */
public abstract class Ex61_C_ProdAmongHeapOld {

	public static void main(String[] sAry) throws Throwable {

		long allVCell = B64W6.genB64W6ByAry32(2, 1, 2);
		O.l("allVCell=" + O.L + B64W6.str24(allVCell));

		int n = B64W6.sum32(allVCell) + 1;

		Arr<Seq> ret = CarteProdCnk.oldProdAmongHeap(n, allVCell);

		O.eq(ret.i, CarteProdCnk.mulAmongHeap(n, B64W6.easySortAftTotalVCell(allVCell)));

		O.l(CarteProdCnk.toStrByArrOfSeq(ret, O.S_ARY_A_Z, O.S9, O.L));

	}
}
