package lgpl3.comb.carteProd.sample;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.comb.carteProd.CarteProdPnk;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Seq;

/**
 * @version 2020/02/13_20:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex67_P_ProdAmongDistinctGroup" >
 *          Ex67_P_ProdAmongDistinctGroup.java</a>
 */
public abstract class Ex67_P_ProdAmongDistinctGroup {

	public static void main(String[] sAry) throws Throwable {

		long b64W6ForAllV32 = B64W6.genB64W6ByAry32(1, 2, 3);

		int n = B64W6.sum32(b64W6ForAllV32) + 1; // must be gte sum32

		Arr<Seq> arrOfSeq = CarteProdPnk.prodAmongGroup(n, b64W6ForAllV32, B.O);

		O.l(CarteProdPnk.toStrByArrOfSeq(arrOfSeq, O.S_ARY_A_Z, O.S9, O.L));

		O.eq(arrOfSeq.iLen, CarteProdPnk.mulAmongBoxWTag(n, b64W6ForAllV32));

		O.l("len=" + arrOfSeq.iLen);

	}
}
