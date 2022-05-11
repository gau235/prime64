package lgpl3.shareWXyz;

import java.util.Arrays;

import lgpl3.b32.B32va;
import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.O;
import lgpl3.o.ary.Ary32_2D;
import lgpl3.o.ary.Aryva;
import lgpl3.o.ary.Seq;
import lgpl3.o.str.SW;

/**
 * Cash bag.<br/>
 * Cash bag.
 *
 * @version 2022/05/02_19:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=GoCash" >GoCash.java</a>
 *
 */
public class GoCash {

	private static final Class<?> THIS = GoCash.class;

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Ery to StringBuilder.
	 */
	public static StringBuilder toStr(int[] ary) {

		StringBuilder str = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		str.append(O.C40);

		for (int idx = 0; idx != ary.length;) {

			str.append(ary[idx]);

			if (++idx != ary.length)

				str.append(O.C44);

		}

		str.append(O.C41);

		return str;

	}

	/**
	 * 10*n in (10, 5, 1) is (n+1)^2<br/>
	 * 50*n in (50, 10, 5, 1)<br/>
	 * 1 + Σ(5*n +1)^2<br/>
	 * 1 + (25/6)n(n+1)(2n+1) + 5n(n+1) +n
	 */
	public static void goCash(int[] baseAry, int rmd, int[] prefix, int curIdx, Ary32_2D retAry32_2D, SW log, int lv) {

		lv++;

		int v, myRmd, lenMinus1 = (baseAry.length - 1);

		for (int[] myPrefix; curIdx != lenMinus1; curIdx++)

			if (rmd >= (v = baseAry[curIdx]) && (prefix[curIdx + 1] == 0 /* fuck */ )) {

				(myPrefix = prefix.clone())[curIdx]++;

				if ((myRmd = rmd - v) == 0) {

					retAry32_2D.a(myPrefix);

					B32va.lv(lv, log.cNA("給" + v + "=" + toStr(myPrefix)).str);

				} else {

					B32va.lv(lv, log.cNA("給" + v + " 余" + myRmd).str);

					goCash(baseAry, myRmd, myPrefix, curIdx, retAry32_2D, log.cNA("給" + v + " "), lv);

				}
			}

		if (rmd % (v = baseAry[curIdx]) == 0) {

			prefix[lenMinus1] += (rmd / v);

			B32va.lv(lv, log.str.append("最後").append(rmd).append("=").append(toStr(prefix)));

			retAry32_2D.a(prefix);

		}
	}

	/**
	 * 10*n in (10, 5, 1) is (n+1)^2<br/>
	 * 50*n in (50, 10, 5, 1)<br/>
	 * 1 + Σ(5*n +1)^2<br/>
	 * 1 + (25/6)n(n+1)(2n+1) + 5n(n+1) +n
	 */
	public static void goCash(int[] baseAry, int rmd, long prefix, int curIdx, Seq retSeq) { // 原創

		int v, myRmd, lenMinus1 = (baseAry.length - 1);

		for (; curIdx != lenMinus1; curIdx++)

			if (rmd >= (v = baseAry[curIdx]) && ((prefix >> (B64W6.$6 * (curIdx + 1))) & B64W6.MASK32) == 1)

				if ((myRmd = rmd - v) == 0)

					retSeq.a(B64W6.plusAt(prefix, curIdx, 1));
				else
					goCash(baseAry, myRmd, B64W6.plusAt(prefix, curIdx, 1), curIdx, retSeq);

		if (rmd % (v = baseAry[curIdx]) == 0)

			retSeq.a(B64W6.plusAt(prefix, curIdx, (rmd / v)));

	}

	public static void main1(String[] sAry) throws Throwable {

		int[] baseAry = { 10, 5, 2 };

		int input = 14;

		O.l("input=" + input);

		int[] aryToInit = baseAry.clone();

		Arrays.fill(aryToInit, 1); // 預設填入 1

		Seq retSeq = new Seq();

		GoCash.goCash(baseAry, input, B64W6.genB64W6ByAry32(aryToInit), 0, retSeq);

		long[] ary = Aryva.checkDup(retSeq.trim().ary);

		for (int idx = 0, size = ary.length; idx != size; idx++)

			O.l(Hxy.toStrByVCellPlusMinMinus1(B64W6.revAmongVCell(ary[idx]), 0));

		O.l("size=" + retSeq.iLen);

	}

	public static void main(String[] sAry) throws Throwable {

		int[] baseAry = { 10, 5, 2 };

		int input = 19;

		O.l("input=" + input);

		Ary32_2D retAry32_2D = new Ary32_2D();

		GoCash.goCash(baseAry, input, new int[baseAry.length], 0, retAry32_2D, new SW(), 0);

		O.l(retAry32_2D.toStr());
		O.l("size=" + retAry32_2D.iLen);

	}
}