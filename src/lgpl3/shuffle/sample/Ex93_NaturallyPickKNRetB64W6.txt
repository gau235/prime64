package lgpl3.shuffle.sample;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.comb.filter.IdxSet32;
import lgpl3.o.O;
import lgpl3.o.ary.Seq;
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
 * @version 2021/04/15_15:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex93_NaturallyPickKNRetB64W6">
 *          Ex93_NaturallyPickKNRetB64W6.java</a>
 *
 */
public class Ex93_NaturallyPickKNRetB64W6 {

	public static void main(String[] sAry) throws Throwable {

		final int nTest = 300;

		int[] ary32 = { 1, 2, 3, 4, 5 };

		// int k = ary32.length;
		int k = 5;

		O.l("ary32=");
		O.l(ary32);

		IdxSet32 idxSet32 = new IdxSet32(ary32.length + 1);
		Seq retSeq = new Seq();

		long b64;
		int iTest = 0;
		do {

			b64 = Shuffler.pickKNRetB64W6(ary32, k);

			if (idxSet32.addIfNotFound(b64))
				retSeq.a(b64);

		} while (++iTest != nTest);

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);
		long[] tmpAry = retSeq.sort().trim().ary;

		for (int i = 0; i != tmpAry.length; i++)
			retStr.append(B64W6.strByVCellAftRev(tmpAry[i])).append(O.C_A_L).append(O.C_A_L);

		O.l(retStr.append("total=" + tmpAry.length));

	}
}