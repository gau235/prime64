package lgpl3.comb.onto.sample;

import lgpl3.comb.carteProd.thr.ThrCarteProdCAmongBoxWTag;
import lgpl3.comb.filter.Condi;
import lgpl3.comb.onto.Onto;
import lgpl3.comb.stirlingN.sample.Ex22_S2Recur;
import lgpl3.o.O;
import lgpl3.o.ary.Ary32_2D;

/**
 * Onto.<br/>
 * The Onto function.
 *
 * @version 2021/03/25_22:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex24_OntoByCarteProd" >
 *          Ex24_OntoByCarteProd.java</a>
 *
 * @see Ex22_S2Recur
 */
public class Ex24_OntoByCarteProd {

	public static void main(String[] sAry) throws Throwable {

		Condi condi = new Condi();
		condi.n = 6;
		condi.k = 2;
		condi.min = 3;
		condi.max = condi.n;

		condi.checkArg(); // fuck

		Ary32_2D ary32_2D = Onto.onto(condi);

		O.l("str=" + O.L + ThrCarteProdCAmongBoxWTag.toStrByAry32_2D(ary32_2D, O.S_ARY_A_Z, O.S9, O.L));

		O.l("len=" + O.eq(ary32_2D.i, Onto.int64ByHxy(condi)));
		O.l("int64ByToInEx=" + Onto.int64ByToInEx(condi.n, condi.k));

	}
}
