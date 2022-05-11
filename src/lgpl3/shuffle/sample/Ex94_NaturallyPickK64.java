package lgpl3.shuffle.sample;

import java.util.Arrays;

import lgpl3.comb.b64W6.B64W6;
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
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex94_NaturallyPickK64" >
 *          Ex94_NaturallyPickK64.java</a>
 *
 */
public class Ex94_NaturallyPickK64 {

	public static void main(String[] sAry) throws Throwable {

		final int nTest = 500;

		int[] ary32 = { 10, 20, 30, 40, 50 };

		int k = 4;

		O.l("ary32=");
		O.l(ary32);

		long[] tmpAry = new long[nTest];

		int iTest = 0;
		do
			tmpAry[iTest] = Shuffler.pickKNRetB64W6(ary32, k);

		while (++iTest != nTest);

		Arrays.sort(tmpAry);
		tmpAry = Aryva.distinct(tmpAry);

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		for (int i = 0; i != tmpAry.length; i++)
			retStr.append(B64W6.strByVCellAftRev(tmpAry[i])).append(O.C_A_L);

		O.l(retStr.append("total=" + tmpAry.length));

	}
}