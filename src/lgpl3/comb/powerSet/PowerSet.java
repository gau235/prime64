package lgpl3.comb.powerSet;

import java.util.Arrays;

import lgpl3.b32.B32va;
import lgpl3.comb.Cnk;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.comb.selfCallva.SelfCallva;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Ary32_2D;
import lgpl3.o.ary.Ary32va;
import lgpl3.o.ary.Seq;
import lgpl3.o.ary.Seq32;
import lgpl3.o.keyNV.KAry32V32;

/**
 * @version 2022/04/28_00:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=PowerSet" >src</a>
 *
 * @see SelfCallva
 */
public abstract class PowerSet {

	private static final Class<?> THIS = PowerSet.class;

	/**
	 * To gen all subset.<br/>
	 * 100 個元素, 2^100 電腦當掉.
	 */
	public static void printAll(String[] sAry, int curIdx, String prefix) { // 遞迴是最後呼叫先執行, 後進先出

		B.n32++;

		if (curIdx == (sAry.length - 1)) { // Z 軸延伸

			O.l(prefix + sAry[curIdx]);
			O.l(prefix);

			return;

		}

		printAll(sAry, (curIdx + 1), (prefix + sAry[curIdx])); // 問取不取? 取
		printAll(sAry, (curIdx + 1), prefix); // 問取不取? 不取

	}

	/**
	 * To gen all subset.<br/>
	 * 100 個元素, 2^100 電腦當掉.
	 */
	public static void colRecur(final int[] baseAry32, int curIdx, Seq32 prefix, Ary32_2D ary32_2D) {

		B.n32++;

		if (curIdx == (baseAry32.length - 1)) { // Z 軸延伸

			ary32_2D.a(prefix.cNA(baseAry32[curIdx]).trim().ary32);
			ary32_2D.a(prefix.trim().ary32);

			return;

		}

		colRecur(baseAry32, (curIdx + 1), prefix.cNA(baseAry32[curIdx]), ary32_2D); // 問取不取? 取
		colRecur(baseAry32, (curIdx + 1), prefix, ary32_2D); // 問取不取? 不取

	}

	/**
	 * To gen all subset.<br/>
	 * A B C D 必然會抓到 D, 可嘗試把 D 改休止符.
	 *
	 * @see #printAll(String[], int, String)
	 */
	public static void colFromNone(int[] baseAry32, int idx, Seq32 prefix, Ary32_2D ret, int lv) { // 原創

		do {
			if (idx++ == baseAry32.length) {

				O.lv(lv, "ad none=" + prefix.toStr());

				ret.a(prefix.trim().ary32); // add none 加入休止符

				return;

			}

			O.lv(lv, "prefix=" + prefix.toStr() + " ad " + baseAry32[idx - 1]);

			colFromNone(baseAry32, idx, prefix.cNA(baseAry32[idx - 1]), ret, (lv + 1));

		} while (B.I);

	}

	/**
	 * To gen all subset.<br/>
	 * A B C D 必然會抓到 D, 可嘗試把 D 改休止符.
	 *
	 * @see #printAll(String[], int, String)
	 */
	public static Ary32_2D colFromNone(int[] baseAry32) {

		Ary32_2D ret = new Ary32_2D();

		colFromNone(baseAry32, 0, new Seq32(), ret, 1); // new Seq32() 空容器

		return ret;

	}

	/**
	 * To gen all subset.<br/>
	 * A B C D 必然會抓到 D, 可嘗試把 D 改休止符.
	 *
	 * @see #printAll(String[], int, String)
	 *
	 * @see Cnk #colFrom1ToN(int)
	 */
	public static void colRecurByExtTail(int prefix, int curB32, KAry32V32 ret, int lv) { // 原創 // 回傳 0b0 表示空集合

		B.n32++;

		do {
			if ((curB32 >>>= 1) == 0b1) {

				O.lv(lv, "ret=" + B32va.strByLog2HighestBitBySAry((prefix | curB32), O.S_ARY_A_Z));
				O.lv(lv, "ret=" + B32va.strByLog2HighestBitBySAry(prefix, O.S_ARY_A_Z));

				ret.k[ret.v++] = (prefix | curB32); // 倒數第 2
				ret.k[ret.v++] = prefix; // 倒數第 1

				return;

				// return ret; // 多個回傳值 到底是哪個

			}

			O.lv(lv, "prefix=" + B32va.strByLog2HighestBitBySAry(prefix, O.S_ARY_A_Z) + " ad " +

					B32va.strByLog2HighestBitBySAry(curB32, O.S_ARY_A_Z));

			colRecurByExtTail((prefix | curB32), curB32, ret, (lv + 1));

		} while (B.I);

	}

	/**
	 * To gen all subset.<br/>
	 * A B C D 必然會抓到 D, 可嘗試把 D 改休止符.
	 *
	 * @see #printAll(String[], int, String)
	 */
	public static int[] colRecurByExtTail(int nOfElem) {

		KAry32V32 ret = new KAry32V32(nOfElem = (0b1 << nOfElem)); // 借用 nOfElem 當容器

		colRecurByExtTail(0b0, nOfElem, ret, 1);

		return ret.k;

	}

	/**
	 * To collect those coins which match the value.<br/>
	 * To collect those coins which match the value.
	 */
	public static void colRecurAllMatchV(int[] baseAry32, int rmd32, int curIdx, long prefix, Seq retSeq) {

		B.n32++;

		final int curV = baseAry32[--curIdx];

		if (O.isDev)

			O.lv((baseAry32.length - curIdx), "prefix=" + B64W6.strByVCellAftRev(prefix) + " rmd=" + rmd32 + " curV=" + curV);

		rmd32 -= curV;

		if (curIdx == 0) {

			// if (rmd32 > 0) return;

			if (rmd32 == 0) {

				retSeq.a((prefix << B64W6.$6) | curV); // 問取不取? 取

				// return;

			}

			// if (rmd32 < 0) return;

			return;

		}

		if (rmd32 > 0) {

			colRecurAllMatchV(baseAry32, rmd32, curIdx, ((prefix << B64W6.$6) | curV), retSeq); // 問取不取? 取
			colRecurAllMatchV(baseAry32, (rmd32 + curV) /* 加回來 */, curIdx, prefix, retSeq); // 問取不取? 不取

			return;

		}

		if (rmd32 == 0) {

			retSeq.a((prefix << B64W6.$6) | curV); // 問取不取? 取

			// 不可 return; 有可能目標 50, 然而第 1 個硬幣就是 50, 還要看其他種類組合

			colRecurAllMatchV(baseAry32, (rmd32 + curV), curIdx, prefix, retSeq); // 問取不取? 不取

			return;

		}

		if (rmd32 < 0) {

			colRecurAllMatchV(baseAry32, (rmd32 + curV), curIdx, prefix, retSeq); // 問取不取? 不取

			return;

		}
	}

	/**
	 * To collect those coins which match the value.
	 */
	public static long[] colAllMatchV(int[] baseAry32, int targetV32) {

		if (O.isDev) {

			Arrays.sort(baseAry32); // 最好有排序

			O.l("baseAry32=" + Arrays.toString(Ary32va.rev(baseAry32.clone())), THIS);

		}

		Seq retSeq = new Seq();

		PowerSet.colRecurAllMatchV(baseAry32, targetV32, baseAry32.length, 0b0L, retSeq);

		return retSeq.trim().ary;

	}
}
