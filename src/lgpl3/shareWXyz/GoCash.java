package lgpl3.shareWXyz;

import lgpl3.comb.b64WVCell.B64W6;
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
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=GoCash" >GoCash.java</a>
 *
 */
public class GoCash {

	private static final Class<?> THIS = GoCash.class;

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Ery to StringBuilder.
	 */
	public static StringBuilder toStr(int[] ary) {

		StringBuilder ret = new StringBuilder(O.defLenForStr);

		ret.append(O.C40);

		for (int idx = 0; idx != ary.length;) {

			ret.append(ary[idx]);

			if (++idx != ary.length)

				ret.append(O.C44);

		}

		ret.append(O.C41);

		return ret;

	}

	/**
	 * 10*n in (10, 5, 1) is (n+1)^2<br/>
	 * 50*n in (50, 10, 5, 1)<br/>
	 * 1 + Σ(5*n +1)^2<br/>
	 * 1 + (25/6)n(n+1)(2n+1) + 5n(n+1) +n
	 */
	public static void goCash(int[] baseAry, int rmd, int[] prefix, int curIdx, Ary32_2D ret, SW log, int lv) {

		lv++;

		int lenMinus1 = (baseAry.length - 1), v, myPrefix[], myRmd;

		for (; curIdx != lenMinus1; curIdx++)

			if (rmd >= (v = baseAry[curIdx]) && (prefix[curIdx + 1] == 0 /* fuck */ )) {

				(myPrefix = prefix.clone())[curIdx]++;

				if ((myRmd = rmd - v) == 0) {

					ret.a(myPrefix);

					O.lv(lv, log.cNA("給" + v + "=" + toStr(myPrefix)).str);

				} else {

					O.lv(lv, log.cNA("給" + v + " 余" + myRmd).str);

					goCash(baseAry, myRmd, myPrefix, curIdx, ret, log.cNA("給" + v + " "), lv);

				}
			}

		if (rmd % (v = baseAry[curIdx]) == 0) {

			prefix[lenMinus1] += (rmd / v);

			O.lv(lv, log.str.append("最後").append(rmd).append("=").append(toStr(prefix)));

			ret.a(prefix);

		}
	}

	/**
	 * 10*n in (10, 5, 1) is (n+1)^2<br/>
	 * 50*n in (50, 10, 5, 1)<br/>
	 * 1 + Σ(5*n +1)^2<br/>
	 * 1 + (25/6)n(n+1)(2n+1) + 5n(n+1) +n
	 */
	public static Ary32_2D goCashNRetAry32_2D(int[] baseAry /* sortedDesc */, int targetV32) { // 原創

		Ary32_2D ret = new Ary32_2D();

		GoCash.goCash(baseAry, targetV32, new int[baseAry.length], 0, ret, new SW(), 0);

		return (Ary32_2D) ret.trim();

	}

	/**
	 * 10*n in (10, 5, 1) is (n+1)^2<br/>
	 * 50*n in (50, 10, 5, 1)<br/>
	 * 1 + Σ(5*n +1)^2<br/>
	 * 1 + (25/6)n(n+1)(2n+1) + 5n(n+1) +n
	 */
	public static void goCash(int[] baseAry, int rmd, long prefix, int curIdx, Seq retSeq) { // 原創

		int lenMinus1 = (baseAry.length - 1), v, myRmd;

		for (; curIdx != lenMinus1; curIdx++)

			if (rmd >= (v = baseAry[curIdx]) && ((prefix >> (B64W6.$6 * (curIdx + 1))) & B64W6.MASK32) == 1)

				if ((myRmd = rmd - v) == 0)

					retSeq.a(B64W6.plusAt(prefix, curIdx, 1));
				else
					goCash(baseAry, myRmd, B64W6.plusAt(prefix, curIdx, 1), curIdx, retSeq);

		if (rmd % (v = baseAry[curIdx]) == 0)

			retSeq.a(B64W6.plusAt(prefix, curIdx, (rmd / v)));

	}

	/**
	 * 10*n in (10, 5, 1) is (n+1)^2<br/>
	 * 50*n in (50, 10, 5, 1)<br/>
	 * 1 + Σ(5*n +1)^2<br/>
	 * 1 + (25/6)n(n+1)(2n+1) + 5n(n+1) +n
	 */
	public static long[] goCash(int[] baseAry /* sortedDesc */, int targetV32) { // 原創

		Seq retSeq = new Seq();

		GoCash.goCash(baseAry, targetV32, B64W6.genB64W6WAll1(baseAry.length), 0, retSeq);

		return retSeq.trim().ary;

	}

	public static void main1(String[] sAry) throws Throwable {

		int baseAry[] = { 10, 5, 2 };

		int targetV = 14;

		O.l("targetV=" + targetV);

		long[] ary = Aryva.checkDup(GoCash.goCash(baseAry, targetV));

		for (int idx = 0, size = ary.length; idx != size; idx++)

			O.l(Hxy.toStrByVCellPlusMinMinus1(B64W6.revAmongVCell(ary[idx]), 0));

		O.l("size=" + ary.length);

	}

	public static void main2(String[] sAry) throws Throwable {

		int[] baseAry = { 10, 5, 2 };

		int targetV = 19;

		O.l("targetV=" + targetV);

		Ary32_2D ret = GoCash.goCashNRetAry32_2D(baseAry, targetV);

		O.l(ret.toStr());
		O.l("size=" + ret.i);

	}

	public static void main(String[] sAry) throws Throwable {

		// 1 + Σ(5*n +1)^2

		long n = 3_160_000;

		double ans = 1;

		for (; n != 0; n--)

			ans += (n * 5 + 1) * (n * 5 + 1);

		O.l("ans=" + ans); // ans=2.6295430808154338E20

	}
}