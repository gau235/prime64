package lgpl3.comb.stirlingN.sample;

import lgpl3.comb.carteProd.CarteProdCnk;
import lgpl3.comb.filter.Condi;
import lgpl3.comb.stirlingN.S2nk;
import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Seq;

/**
 * Stirling number of the second kind.<br/>
 * Stirling number of the second kind.
 *
 * @version 2022/07/01_00:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex24_S2ByCarteProd" >src</a>
 *
 * @see Ex22_S2Recur
 *
 * @see Ex24_S2ByCarteProd
 */
public class Ex24_S2ByCarteProd {

	public static void main(String[] sAry) throws Throwable {

		Condi condi = new Condi();
		condi.n = 5;
		condi.k = 3;
		condi.min = 1;
		condi.max = condi.n;

		condi.checkArg();

		Arr<Seq> arrOfSeq = S2nk.carteProd(condi);

		O.l(CarteProdCnk.toStrByArrOfSeq(arrOfSeq, O.S_ARY_A_Z, O.S9, O.L));

		O.l("len=" + O.eq(arrOfSeq.i, S2nk.int64ByDih(condi)));

	}
}
