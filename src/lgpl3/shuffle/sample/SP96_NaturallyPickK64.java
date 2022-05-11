package lgpl3.shuffle.sample;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.comb.filter.SetWBst32;
import lgpl3.o.O;
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
 * @version 2020/09/13_21:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=SP96_NaturallyPickK64"
 *          >SP96_NaturallyPickK64.java</a>
 * 
 */
public class SP96_NaturallyPickK64 {

	public static void main(String[] sAry) throws Throwable {

		final int nTest = 2000;

		int[] ary32 = { 1, 2, 3, 4, 5 };

		int k = 5;

		O.l("ary32=");
		O.l(ary32);

		SetWBst32 setWBst32 = new SetWBst32(ary32.length);
		long[] tmpAry = new long[nTest];

		int idx = 0;
		int iTest = 0;
		long b64;
		do {

			if (setWBst32.addIfNotFound(b64 = Shuffler.pickKNRetB64W6(ary32, k))) {

				tmpAry[idx++] = b64;
			}

		} while (++iTest != nTest);

		tmpAry = O.delTailAll0(tmpAry);

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		for (int i = 0; i != tmpAry.length; i++) {

			retStr.append(B64W6.strByVCellAftRev(tmpAry[i])).append(O.C_A_L).append(O.C_A_L);
		}

		O.l(retStr.append("total=" + tmpAry.length));

	}
}