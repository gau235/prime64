package lgpl3.shuffle.sample;

import java.util.Arrays;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.O;
import lgpl3.o.ary.Aryva;
import lgpl3.shuffle.Shuffler;

/**
 * 排列的實驗法及逼近法<br/>
 * <br/>
 *
 * 排列 [A,B,C]<br/>
 * <br/>
 * 1. 取數列的子集合 <br/>
 * 2. 放入容器以過濾重複<br/>
 * <br/>
 *
 * 部份相同物排列 [A,A,B]<br/>
 * <br/>
 * 1. 取數列的子集合<br/>
 * 2. 放入容器以過濾重複<br/>
 * <br/>
 *
 * 組合 (取物) [A,B,C]<br/>
 * <br/>
 * 1. 取數列的子集合<br/>
 * 2. 排序<br/>
 * 3. 放入容器以過濾重複<br/>
 * <br/>
 *
 * 部份相同物組合 (取物) [A,A,B]<br/>
 * <br/>
 * 1. 取數列的子集合<br/>
 * 2. 排序<br/>
 * 3. 放入容器以過濾重複<br/>
 *
 * @version 2021/04/27_11:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex94_NaturallyPickK64" >src</a>
 *
 */
public class Ex94_NaturallyPickK64 {

	public static void main(String[] sAry) throws Throwable {

		int nTest = 500;

		int[] ary32 = { 10, 20, 30, 40, 50 };

		int k = 4;

		long[] ret = new long[nTest];

		do
			ret[--nTest] = Shuffler.pickKNRetB64W6(ary32, k);

		while (nTest != 0);

		// O.l(ret);

		Arrays.sort(ret);

		Aryva.checkDup(ret = Aryva.distinct(ret));

		for (int idx = 0; idx != ret.length; idx++)

			O.l(B64W6.strByVCellAftRev(ret[idx]));

		O.l("total=" + ret.length);

	}
}