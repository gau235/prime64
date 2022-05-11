package lgpl3.comb.sample;

import lgpl3.comb.Pnk;
import lgpl3.o.O;
import lgpl3.o.keyNV.KAryV32;

/**
 * 排列.<br/>
 * Permutation.
 *
 * @version 2022/05/02_21:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex104_P_HtmlSizedFont" >Ex104_P_HtmlSizedFont.java</a>
 */
public class Ex104_P_HtmlSizedFont {

	public static void main(String[] sAry) throws Throwable {

		String[] sAry2 = { "夭", "天", "太", "木", "尤", "无" };

		int n = 4;
		int k = n;

		KAryV32 kAryV32 = new KAryV32(Pnk.int64(n, k));

		Pnk.colRecurWNGteK(~(-0b1 << n), 0b0L, 0, k, kAryV32);

		O.l(Pnk.htmlSizedFontAftRev(kAryV32.ary, sAry2));

	}
}
