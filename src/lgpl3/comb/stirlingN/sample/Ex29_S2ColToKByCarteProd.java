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
 * @version 2021/03/12_20:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex29_S2ColToKByCarteProd" >
 *          Ex29_S2ColToKByCarteProd.java</a>
 *
 * 
 *
 * @see Ex22_S2Recur
 */
public class Ex29_S2ColToKByCarteProd {

	public static void main(String[] sAry) throws Throwable {

		Condi condi = new Condi();
		condi.n = 5;
		condi.k = 3;
		condi.min = 0;
		condi.max = condi.n;

		condi.checkArg();

		Arr<Seq> arrOfSeq = S2nk.colToKByCarteProd(condi);

		long ans = S2nk.int64ByDih(condi);
		if (arrOfSeq.i != ans) {

			O.x("len=" + arrOfSeq.i + " ans=" + ans);

		}

		StringBuilder str = CarteProdCnk.toStrByArrOfSeq(arrOfSeq, O.S_ARY_A_Z, O.S9, O.L);
		O.l(str);

		O.l("len=" + arrOfSeq.i);
		O.l("ans=" + ans);

	}

}
