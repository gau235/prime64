package lgpl3.comb.carteProd.sample;

import lgpl3.b64.B64va;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.comb.carteProd.CarteProdCnk;
import lgpl3.comb.carteProd.thr.ThrCarteProdCAmongBoxWTag;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Ary32_2D;

/**
 * To product.<br/>
 * To product.
 *
 * @version 2022/03/29_10:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex24_ThrCarteProdCAmongBoxWTag" >
 *          Ex24_ThrCarteProdCAmongBoxWTag.java</a>
 *
 */
public class Ex24_ThrCarteProdCAmongBoxWTag {

	public static void main(String[] sAry) throws Throwable {

		int allBit = 0b1011_1111;
		long allV = B64W6.genB64W6ByAry32(1, 3);

		Ary32_2D reAry32_2D = new ThrCarteProdCAmongBoxWTag(allBit, allV, B.I).box;

		O.eq(reAry32_2D.i, CarteProdCnk.mulAmongBoxWTag(B64va.countOf1(allBit), allV));

		O.l(ThrCarteProdCAmongBoxWTag.toStrByAry32_2D(reAry32_2D, O.S_ARY_A_Z, O.S9, O.L));

	}
}