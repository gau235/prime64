package lgpl3.comb.b64WVCell.sample;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.O;

/**
 * To rotate.<br/>
 * To rotate.
 *
 * @version 2020/05/21_22:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex07_FindIdx" >Ex07_FindIdx.java</a>
 *
 */
public class Ex07_FindIdx {

	public static void main(String[] sAry) throws Throwable {

		long b64W6 = B64W6.genB64W6ByAry32(22, 30, 4, 20, 50, 10, 1, 12, 13, 48);

		int max = B64W6.getMax(b64W6);
		O.l("max=" + max);

		int iFound = B64W6.findIdx(b64W6, max);
		O.l("iFound=" + iFound);

	}
}
