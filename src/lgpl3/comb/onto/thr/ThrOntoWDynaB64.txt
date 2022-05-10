package lgpl3.comb.onto.thr;

import lgpl3.b32.B32va;
import lgpl3.comb.filter.Condi;
import lgpl3.comb.onto.Onto;
import lgpl3.comb.stirlingN.thr.ThrS2WDynaB64;
import lgpl3.comb.stirlingN.thr.ThrS2WDynaB64_A;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.str.Strva;
import lgpl3.other.jsp.Jsp;

/**
 * Onto.<br/>
 * Onto.
 *
 * @version 2022/03/13_19:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=ThrOntoWDynaB64" >ThrOntoWDynaB64.java</a>
 *
 */
public class ThrOntoWDynaB64 extends ThrS2WDynaB64_A {

	private static final Class<?> THIS = ThrOntoWDynaB64.class;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrOntoWDynaB64(Condi condi, boolean isToRun) {

		n = condi.n;
		k = condi.k;
		min = condi.min;

		// if (min < 1) O.x("condi.min=" + min); // 天然 自然的檢驗

		max = condi.max;

		baseB32 = ~((-0b1) << n); // baseB32 = ~((-1) << n);

		nMulK = n * k;

		box = new long[(int) Onto.int64ByHxy(condi)];

		if (isToRun)

			run();

	}

	/**
	 * The tail process of S2 function.<br/>
	 * The tail process of S2 function.<br/>
	 * S2: 水平组合後再垂直组合<br/>
	 * Onto: 水平排列後再垂直组合
	 */
	public void cVert(final long prefix, int rmdB32) {

		B.n++;

		int lowest1 = (-rmdB32 & rmdB32), dToShift = 0; // displacement from the first cell

		// O.l("lowest1=" + B32va.str16(lowest1), THIS);

		if (lowest1 == rmdB32) { // termination condition

			do
				if (lowest1 > (((int) (prefix >>> dToShift)) & baseB32))

					if (ifEveryCellLegal(tmp = prefix | (((long) lowest1) << dToShift)))

						box[iLen++] = tmp; // to put on

			while ((dToShift += n) != nMulK);

			return;

		}

		do
			if (lowest1 > (tmp32 = ((int) (prefix >>> dToShift)) & baseB32))

				if (B32va.countOf1(tmp32) < max)

					cVert(prefix | (((long) lowest1) << dToShift), (~lowest1 & rmdB32));

		while ((dToShift += n) != nMulK);

	}

	/**
	 * 從 1 列全相異數列中取出 k 個數.<br/>
	 * To pick several numbers from a list of distinct numbers.
	 */
	public void pHori(int keptB32, int rmdK, long prefix) {

		int rmdB32 = (~keptB32 & baseB32), lowest1;

		// O.l("rmdB32=" + B32va.str16(rmdB32), THIS);
		// O.l("keptB32=" + B32va.str16(keptB32), THIS);

		if ((rmdB32 & 0b1) == 0b0 && (keptB32 & 0b1) == 0b0) // 基礎橫列必含有 A

			O.l("trim1=" + ThrS2WDynaB64.rowInAbc(keptB32), THIS);

		prefix <<= n;

		if (--rmdK == 0) {

			do {
				B.n32++;

				lowest1 = (-rmdB32 & rmdB32);

				if ((keptB32 & 0b1) == 0b0) { // 基礎橫列必含有 A

					if ((lowest1 & 0b1) != 0b0)

						cVert((prefix | 0b1), (~(keptB32 | 0b1) & baseB32));

					return; // 最多只有一次 後續沒有了

				} else
					cVert((prefix | lowest1), (~(keptB32 | lowest1) & baseB32));

			} while ((rmdB32 = (~lowest1 & rmdB32)) != 0b0);

			return; // 記得寫 return

		}

		do
			pHori(keptB32 | (lowest1 = (-rmdB32 & rmdB32)), rmdK, (prefix | lowest1));

		while ((rmdB32 = (~lowest1 & rmdB32)) != 0b0);

	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public void colWNEqK(long prefix, int keptB32) {

		int rmdB32 = (~keptB32 & baseB32);

		prefix <<= n;

		if ((-rmdB32 & rmdB32) == rmdB32) {

			box[iLen++] = (prefix | rmdB32);

			return;

		}

		int lowest1;
		do
			colWNEqK(prefix | (lowest1 = (-rmdB32 & rmdB32)), (keptB32 | lowest1));

		while ((rmdB32 = (~lowest1 & rmdB32)) != 0b0);

	}

	@Override
	public void run() {

		if (n == k) {

			colWNEqK(0b0L, 0b0);

			return;

		}

		// baseB32 = baseB32 >>> (min - 1); // todo: 基礎橫列必定要含有 A

		pHori(0b0, k, 0b0L);

	}

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Ery to StringBuilder.
	 */
	public StringBuilder toHtmlWHead(String[] sAry, String[] sAryForHead, CharSequence sHtmlClass) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		StringBuilder htmlStart1 = new StringBuilder("<table class=\"").append(sHtmlClass).append("\" ><thead><tr><td>");
		StringBuilder htmlEnd1 = new StringBuilder("</td></tr></thead>");

		StringBuilder htmlHead = new StringBuilder("<tr><td>");

		int iHead = 0;
		do {
			htmlHead.append(sAryForHead[iHead]);

			if (++iHead != k)

				htmlHead.append(Strva.STR_HTML_MIDDLE_TD);
			else {

				htmlHead.append("</td></tr>");

				break;

			}

		} while (B.I);

		for (int idx = 0, len = iLen; idx != len;) {

			retStr.append(htmlStart1).append(idx + 1).append(htmlEnd1);
			retStr.append(htmlHead);
			retStr.append("<tr>");

			tmp = box[idx];

			do {
				retStr.append("<td>").append(toHtmlRowStrBySAry((((int) tmp) & baseB32), sAry));

				if (((int) (tmp >>>= n)) == 0b0)

					break;
				else
					retStr.append("</td>");

			} while (B.I);

			retStr.append(Strva.STR_HTML_TABLE_END);

			if (++idx != len) {

				if (idx == Strva.maxRowInHtml)

					return retStr;
				else
					retStr.append(Jsp.L);

			}
		}

		return retStr;

	}
}
