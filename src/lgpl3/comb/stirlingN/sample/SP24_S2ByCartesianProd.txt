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
 * @version 2020/02/12_20:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=SP24_S2ByCartesianProd" >
 *          SP24_S2ByCartesianProd.java</a>
 *
 * @see Ex22_S2Recur
 *
 * @see SP24_S2ByCartesianProd
 */
public class SP24_S2ByCartesianProd {

	public static void main(String[] sAry) throws Throwable {

		Condi condi = new Condi();
		condi.n = 5;
		condi.k = 3;
		condi.min = 1;
		condi.max = condi.n;

		condi.checkArg();

		Arr<Seq> arrOfSeq = S2nk.carteProd(condi);

		long ans = S2nk.int64ByDih(condi);
		if (arrOfSeq.iLen != ans) {

			O.x("len=" + arrOfSeq.iLen + " ans=" + ans);

		}

		StringBuilder str = CarteProdCnk.toStrByArrOfSeq(arrOfSeq, O.S_ARY_A_Z, O.S9, O.L);
		O.l(str);

		O.l("len=" + arrOfSeq.iLen);
		O.l("ans=" + ans);

	}

}
