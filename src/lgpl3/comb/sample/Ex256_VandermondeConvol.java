package lgpl3.comb.sample;

import lgpl3.comb.VandermondeConvol;
import lgpl3.o.O;

/**
 * Vandermonde Convolution.<br/>
 * Vandermonde Convolution.
 *
 * @version 2019/06/27_21:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex256_VandermondeConvol" >
 *          Ex256_VandermondeConvol.java</a>
 *
 */
public class Ex256_VandermondeConvol {

	public static void main(String[] sAry) throws Throwable {

		final int totalN = 12; // 包牌幾支
		final int totalK = 5; // 單張彩卷 5 個號碼

		final int partN = 5; // 這次中幾支

		StringBuilder str = VandermondeConvol.script(totalN, totalK, partN);

		O.l(str);

		// Object ooo = Cnk.bigInt(3, 8);
		// Cnk.int64(3, 8);

	}
}