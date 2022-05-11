package lgpl3.comb.onto.sample;

import lgpl3.comb.PInEx;
import lgpl3.comb.filter.Condi;
import lgpl3.comb.onto.Onto;
import lgpl3.comb.sample.P84_InEx;
import lgpl3.comb.stirlingN.S2P;
import lgpl3.comb.stirlingN.S2PCirc;
import lgpl3.comb.stirlingN.S2nk;
import lgpl3.o.O;

/**
 * The script for Onto function.<br/>
 * The script for Onto function.
 *
 * @version 2021/09/30_19:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex04_ScriptOntoByToInEx" >
 *          Ex04_ScriptOntoByToInEx.java</a>
 *
 * @see P84_InEx
 */
public class Ex04_ScriptOntoByToInEx {

	public static void main(String[] sAry) throws Throwable {

		Condi condi = new Condi();
		condi.n = 7;
		condi.k = 3;
		condi.min = 1;
		condi.max = condi.n;

		Object str = Onto.scriptByToInEx(condi, O.L);
		O.l("scriptOntoByToInEx=");
		O.l(str);
		O.l();

		str = Onto.script(condi, O.L);
		O.l("scriptOnto=");
		O.l(str);
		O.l();

		str = Onto.scriptByS2(condi, O.L);
		O.l("scriptByS2=");
		O.l(str);
		O.l();

		str = PInEx.script(condi.n, condi.k, O.L);
		O.l("scripPInEx=");
		O.l(str);
		O.l();

		str = S2nk.script(condi, O.L);
		O.l("scriptS2=");
		O.l(str);
		O.l();

		str = S2PCirc.script(condi, O.L);
		O.l("scriptS1=");
		O.l(str);
		O.l();

		str = S2P.script(condi, O.L);
		O.l("scriptS3=");
		O.l(str);
		O.l();

	}
}
