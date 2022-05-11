package lgpl3.comb.carteProd.sample;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.comb.carteProd.CarteProdCnk;
import lgpl3.o.O;

/**
 * To product.<br/>
 * To product.
 *
 * @version 2022/03/17_16:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex33_C_MulAmongBoxWTag" >
 *          Ex33_C_MulAmongBoxWTag.java</a>
 *
 */
public class Ex33_C_MulAmongBoxWTag {

	public static void main(String[] sAry) throws Throwable {

		long allV = B64W6.genB64W6ByAry32(2, 1, 2, 2, 1);
		O.l("bef=" + O.L + B64W6.str24(allV));

		int n = B64W6.sum32(allV) + 1;

		O.l("ans=" + CarteProdCnk.mulAmongBoxWTag(n, allV));

		O.l("countDup=" + O.L + B64W6.str24(B64W6.countDup(B64W6.easySortAftTotalVCell(allV))));

	}
}
