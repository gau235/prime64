package lgpl3.shuffle.sample;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.comb.filter.IdxSet32;
import lgpl3.o.O;
import lgpl3.o.ary.Aryva;
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
 * @version 2022/07/07_00:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex93_NaturallyPickKNRetB64W6" >src</a>
 *
 */
public class Ex93_NaturallyPickKNRetB64W6 {

	public static void main(String[] sAry) throws Throwable {

		int nTest = 300;

		int ary32[] = { 1, 2, 3, 4, 5 };

		int k = 5;

		long b64;

		IdxSet32 filter = new IdxSet32(B64W6.$MAX_INT32_IN_CELL);
		Seq ret = new Seq();

		do
			if (filter.aN(b64 = Shuffler.pickKNRetB64W6(ary32, k)))

				ret.a(b64);

		while (--nTest != 0);

		Aryva.sortNCheckDup(ret.trim().ary);

		for (; ret.i-- != 0;)

			O.l(B64W6.strByVCellAftRev(ret.ary[ret.i]));

		O.l("total=" + ret.ary.length);

	}
}