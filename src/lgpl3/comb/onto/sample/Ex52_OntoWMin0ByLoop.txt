package lgpl3.comb.onto.sample;

import lgpl3.comb.filter.CompaForAry32OfB32As2PowWEmpty;
import lgpl3.comb.filter.Condi;
import lgpl3.comb.onto.OntoWMin0;
import lgpl3.comb.stirlingN.S2nk;
import lgpl3.o.O;
import lgpl3.o.ary.Ary32_2D;

/**
 * OntoWMin0(n,k)<br/>
 * OntoWMin0(n,k)
 *
 * @version 2022/01/29_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex52_OntoWMin0ByLoop" >
 *          Ex52_OntoWMin0ByLoop.java</a>
 *
 * @see Ex60_ThrOntoWMin0WDynaB64
 *
 * @see Ex52_OntoWMin0ByLoop
 */
public class Ex52_OntoWMin0ByLoop {

	public static void main(String[] sAry) throws Throwable {

		Condi condi = new Condi();
		condi.n = 3;
		condi.k = 3;
		condi.min = 0;
		condi.max = condi.n;

		condi.checkArg();

		Ary32_2D ary32_2D = OntoWMin0.colByLoop(condi);

		// O.l("ary32_2D=\n" + ary32_2D.toStr());

		// ary32_2D.sort(CompaForAry32OfB32As2Pow.COMPA);
		ary32_2D.sort(CompaForAry32OfB32As2PowWEmpty.COMPA);

		O.l(S2nk.toStrByAry32_2DOfB32BySAry(ary32_2D, O.S_ARY_A_Z, O.L));

		O.l("len=" + O.eq(ary32_2D.iLen, OntoWMin0.int64ByHxy(condi)));

	}
}
