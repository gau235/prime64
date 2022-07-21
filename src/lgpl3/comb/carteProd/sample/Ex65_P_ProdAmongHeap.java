package lgpl3.comb.carteProd.sample;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.comb.carteProd.CarteProdPnk;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Seq;

/**
 * Cartesian product.<br/>
 * Cartesian product.
 *
 * @version 2021/04/27_11:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex65_P_ProdAmongHeap" >
 *          Ex65_P_ProdAmongHeap.java</a>
 *
 * @see Ex61_C_ProdAmongHeapOld
 */
public abstract class Ex65_P_ProdAmongHeap {

	public static void main(String[] sAry) throws Throwable {

		long b64W6WAllV32 = B64W6.genB64W6ByAry32(2, 2, 3);

		// int n = sAry.length;// sAry.length must gte B64W6.sum32(b64W6)
		int n = B64W6.sum32(b64W6WAllV32) + 1;

		Arr<Seq> arrOfSeq = CarteProdPnk.prodAmongGroup(n, b64W6WAllV32, B.I);

		StringBuilder str = CarteProdPnk.toStrByArrOfSeq(arrOfSeq, O.S_ARY_A_Z, O.S9, O.L);
		O.l("str=");
		O.l(str);

		O.eq(arrOfSeq.i, CarteProdPnk.mulAmongHeap(n, B64W6.easySortAftTotalVCell(b64W6WAllV32)));

		O.l("len=" + arrOfSeq.i);

	}
}
