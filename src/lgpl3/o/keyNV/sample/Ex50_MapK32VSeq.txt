package lgpl3.o.keyNV.sample;

import lgpl3.o.O;
import lgpl3.o.ary.Seq;
import lgpl3.o.keyNV.MapK32VSeq;

/**
 * To use MapK32VSeq.<br/>
 * To use MapK32VSeq.
 *
 * @version 2021/10/27_17:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex50_MapK32VSeq" >Ex50_MapK32VSeq.java</a>
 *
 */
public class Ex50_MapK32VSeq {

	public static void main(String[] args) throws Throwable { // 東方人 儒教方法 定位系統 非廣先搜尋

		final int n = 3;

		MapK32VSeq map = new MapK32VSeq();

		map.a(1, new Seq(100, 200, 300));
		map.a(2, new Seq());
		map.a(3, new Seq());

		O.l("init  map=\n" + map.toStr());

		int lv = 1;

		Seq curSeq;
		Seq nextSeq;

		Seq retSeq = new Seq();

		long headV;

		do {

			O.l("lv=====" + lv);

			if (lv < n) {

				if ((curSeq = map.get(lv)).iLen == 0) {

					lv--;

					O.l("continue lv=" + lv);

					continue;

				}

				nextSeq = map.get(lv + 1);

				if ((headV = curSeq.cutHead()) >= 0) {

					nextSeq.a(headV + 1);
					nextSeq.a(headV + 1);

					lv++;

				} else
					lv--;

				O.l("map=\n" + map.toStr());

			} else {

				if ((curSeq = map.get(lv)).iLen == 0) {

					if (lv == 1)

						break;
					else {

						lv--;
						continue;

					}
				}

				O.l("gte curSeq=" + curSeq.toStr());

				while ((headV = curSeq.cutHead()) >= 0) // 分發完
					retSeq.a(headV + 1);

				lv--;

				O.l("retSeq=" + retSeq.toStr());

			}

		} while (lv != 0);

		O.l("aft map=\n" + map.toStr());

		O.l("retSeq=" + retSeq.toStr());

	}
}
