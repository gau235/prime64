package lgpl3.other.sample;

import lgpl3.b32.B32va;
import lgpl3.comb.Pnk;
import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Seq;
import lgpl3.o.keyNV.MapK32VSeq;

/**
 * 排列.<br/>
 * Permutation.
 *
 * @version 2021/09/29_12:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex016_PByLoop" >Ex016_PByLoop.java</a>
 *
 */
public abstract class Ex016_PByLoop {

	public static Seq appendTail(int baseB32, long prefix, Seq retSeq) {

		prefix <<= B64W6.$6;

		int rmdB32 = B64W6.filterAftToB32As2PowByB6Cell(baseB32, prefix);
		int lowest1;

		do
			retSeq.a(prefix | B32va.log2NPlus1(lowest1 = (-rmdB32 & rmdB32)));

		while ((rmdB32 = (~lowest1 & rmdB32)) != 0b0);

		return retSeq;

	}

	public static void main(String[] args) throws Throwable { // 廣先搜尋嗎

		int n = 3;
		int k = n;
		int baseB32 = ~(-0b1 << n);

		int nMinus1 = n - 1;

		// init
		MapK32VSeq map = new MapK32VSeq();

		int lv = 1;
		do
			map.a(lv, new Seq());

		while (lv++ != n);

		lv = 1; // fuck
		appendTail(baseB32, 0b0L, map.get(lv));
		// end init

		O.l("init map=\n" + map.toStr());

		Seq seq;
		Seq nextSeq;

		int idx;
		Seq retSeq = map.get(n);

		do {

			if (lv == nMinus1) {

				O.l("up lv=" + lv);
				O.l("up map=\n" + map.toStr());

				seq = map.get(lv--);

				if (seq.iLen == 0) {

					if (lv == 0)
						break;
					else
						continue;

				}

				O.l("up seq=" + seq.toStr());

				idx = 0;
				do {

					O.l("add in retSeq=" + seq.ary[idx]);

					appendTail(baseB32, seq.ary[idx], retSeq);

				} while (++idx != seq.iLen);

				seq.iLen = 0; // batch process

				O.l("up lv=" + lv);
				O.l("up map=\n" + map.toStr());

			} else { // lv < n- 1

				O.l("down lv=" + lv);
				O.l("down map=\n" + map.toStr());

				seq = map.get(lv);

				if (seq.iLen == 0) {

					O.l("seq.iLen 0 continue lv=" + lv);

					lv--;

					continue;

				}

				O.l("down head=" + seq.head());

				nextSeq = map.get(++lv);
				O.l("down nextSeq=" + nextSeq.toStr());

				appendTail(baseB32, seq.cutHead(), nextSeq);

				O.l("down lv=" + lv);
				O.l("down map=\n" + map.toStr());

			}

		} while (lv != 0); // while (lv >= 1 && ++O.y32 < 100)

		O.l("done map=\n" + map.toStr());

		long[] ary = retSeq.trim().ary;
		O.eq(ary.length, Pnk.int64(n, k));

		O.l(Pnk.strByAryOfRevB64W6BySAry(ary, O.S_ARY_A_Z));

		O.l("O.y32=" + B.n32);

	}
}
