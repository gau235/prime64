package lgpl3.comb.sample;

import lgpl3.comb.Pnk;
import lgpl3.o.O;
import lgpl3.o.keyNV.KAryV32;

/**
 * 排列.<br/>
 * Permutation.
 *
 * @version 2022/05/22_21:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex104_P_HtmlSizedFont" >src</a>
 */
public class Ex104_P_HtmlSizedFont {

	public static void main(String[] sAry) throws Throwable {

		String[] mySAry = { "大", "犬", "太", "夭", "天", "夫", "木" };

		int n = 4;
		int k = n;

		KAryV32 kV = new KAryV32(Pnk.int64(n, k));

		Pnk.colRecurWNGteK(~(-0b1 << n), 0b0L, kV, k);

		O.l(Pnk.htmlSizedFontAftRev(kV.k, mySAry));

	}
}
