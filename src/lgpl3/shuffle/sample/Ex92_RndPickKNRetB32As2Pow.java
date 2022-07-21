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
 * @version 2022/06/27_00:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex92_RndPickKNRetB32As2Pow" >src</a>
 *
 */
public class Ex92_RndPickKNRetB32As2Pow { // Cnk

	public static void main(String[] sAry) throws Throwable {

		int nTest = 150;

		int ary32[] = { 1, 2, 3, 4, 5, 6, 7, 8 }, k = 3;

		O.l("ary32=");
		O.l(ary32);

		long tmp, pickedAry[];

		IdxSet32 filter = new IdxSet32(B64W6.$MAX_INT32_IN_CELL);
		Seq ret = new Seq();

		do
			if (filter.aN(tmp = B64W6.toDescB64W6ByLog2NPlus1(Shuffler.pickKNRetB32As2Pow(ary32.length, k))))

				ret.a(tmp);

		while (--nTest != 0);

		pickedAry = Aryva.sortNCheckDup(ret.trim().ary);

		O.l("pick=");

		for (int idx = 0; idx != ret.i; idx++)

			O.l(B64W6.strByVCellAftRev(pickedAry[idx]));

		O.l("total=" + pickedAry.length);

	}
}