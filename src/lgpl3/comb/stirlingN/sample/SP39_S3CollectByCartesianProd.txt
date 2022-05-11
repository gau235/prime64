package lgpl3.comb.stirlingN.sample;

import lgpl3.comb.carteProd.CarteProdPnk;
import lgpl3.comb.filter.Condi;
import lgpl3.comb.stirlingN.S2P;
import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Seq;

/**
 * Stirling number of the third kind.<br/>
 * Stirling number of the third kind.
 *
 * @version 2020/02/13_20:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=SP39_S3CollectByCartesianProd" >
 *          SP39_S3CollectByCartesianProd.java</a>
 *
 * @see SP39_S3CollectByCartesianProd
 */
public class SP39_S3CollectByCartesianProd {

	public static void main(String[] sAry) throws Throwable {

		Condi condi = new Condi();
		condi.n = 5;
		condi.k = 2;
		condi.min = 0;
		condi.max = condi.n;

		condi.checkArg();

		Arr<Seq> arrOfSeq = S2P.colToKByToGoByCartesianProd(condi);

		long ans = S2P.int64ByDih(condi);
		if (arrOfSeq.iLen != ans) {

			O.x("len=" + arrOfSeq.iLen + " ans=" + ans);

		}

		StringBuilder str = CarteProdPnk.toStrByArrOfSeq(arrOfSeq, O.S_ARY_A_Z, O.S9, O.L);
		O.l(str);

		O.l("len=" + arrOfSeq.iLen);
		O.l("ans=" + ans);

	}

}
