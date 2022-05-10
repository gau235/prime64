package lgpl3.comb.carteProd.sample;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.O;

/**
 * To product.<br/>
 * To product.
 *
 * @version 2018/05/22_13:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex22_CarteProdNMerge" >
 *          Ex22_CarteProdNMerge.java</a>
 *
 */
public class Ex22_CarteProdNMerge {

	public static void main(String[] sAry) throws Throwable {

		long b64W6 = B64W6.genB64W6ByAry32(1, 2);

		long b64W6_2 = B64W6.genB64W6ByAry32(15, 16);
		long b64W6_3 = B64W6.genB64W6ByAry32(25, 26);

		O.l("bef1=" + O.L + B64W6.str24(b64W6));
		O.l("bef1=" + O.L + B64W6.strByVCellAftRev(b64W6));

		long[] retAry = { 0b0L };
		// retAry = CarteProd.prodNMergeInB64W6(b64W6, b64W6_2, b64W6_3); // CarteProd.prodNMergeInB64W6 被拿掉

		for (int i = 0; i != retAry.length; i++) {

			long b64 = B64W6.revAmongVCell(retAry[i]);

			StringBuilder str = B64W6.strByVCellAftRev(b64);

			O.l();

			O.l("aft=" + O.L + B64W6.str24(b64));
			O.l("aft=" + str);

		}
	}
}
