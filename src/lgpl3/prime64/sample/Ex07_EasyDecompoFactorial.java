package lgpl3.prime64.sample;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.O;
import lgpl3.prime64.Miner;

/**
 * 對 n 階乘做質因數分解, n 必須大於 1
 *
 * @version 2022/05/26_20:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex07_EasyDecompoFactorial" >src</a>
 *
 */
public class Ex07_EasyDecompoFactorial {

	public static void main(String[] sAry) throws Throwable {

		long b64W6 = Miner.easyDecompoFactorial(30);

		O.l("ans=" + B64W6.str24(b64W6));
		O.l("ans=" + B64W6.strByVCellAftRev(b64W6));

	}
}