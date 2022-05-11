package lgpl3.comb.onto.thr;

import java.util.Arrays;

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
 * OntoWMin0.<br/>
 * OntoWMin0.
 *
 * @version 2022/02/03_15:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=ThrOntoWMin0WDynaB64" >
 *          ThrOntoWMin0WDynaB64.java</a>
 *
 */
public class ThrOntoWMin0WDynaB64 extends ThrS2WDynaB64_A {

	private static final Class<?> THIS = ThrOntoWMin0WDynaB64.class;

	public final int mask32; // b64 可在兩 cell 之間會有空的 cell; 最多 32 字母

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrOntoWMin0WDynaB64(Condi condi, boolean isToRun) {

		// O.l("n, k, min, max=" + condi.n + ", " + condi.k + ", " + condi.min + ", " + condi.max, THIS);

		n = condi.n;
		k = condi.k;
		max = condi.max;

		baseB32 = ~((-0b1) << n); // baseB32 = ~((-1) << n);

		nMulK = n * k;

		boundBit = (0b1 << (condi.n - 1));

		mask32 = ~(-0b1 << n);

		box = new long[(int) Onto.int64ByHxy(condi)];

		if (isToRun)

			run();

	}

	/**
	 * To put n people in k rooms.<br/>
	 * To put n people in k rooms.
	 */
	public void colRecur(final long b64, final int curB32As2Pow) {

		B.n32++;
		// O.l("curB32As2Pow=" + curB32As2Pow, THIS);

		int dToShift = 0; // displacement from the first cell

		if (curB32As2Pow == boundBit) {

			do
				if (B32va.countOf1(((int) (b64 >>> dToShift)) & mask32) < max)

					if (!O.IS_LINUX || (iLen < Strva.maxRowInHtml))

						box[iLen++] = b64 | (((long) curB32As2Pow) << dToShift); // to put on

			while ((dToShift += n) != nMulK);

			return;

		}

		do
			if (B32va.countOf1(((int) (b64 >>> dToShift)) & mask32) < max)

				colRecur(b64 | (((long) curB32As2Pow) << dToShift), curB32As2Pow << 1);

		while ((dToShift += n) != nMulK);

	}

	@Override
	public void run() {

		colRecur(0b0L, 0b1);
	}

	/**
	 * If less than.<br/>
	 * If less than.
	 */
	@Override
	public boolean ifLt(long b64A, long b64B) {

		long b64A2 = b64A, b64B2 = b64B; // 全域變數 tmp 已經有人用掉
		int tmp32A, tmp32B;

		// 第一輪先比每個房間內部人數
		b64A2 = b64A;
		b64B2 = b64B;

		do {
			tmp32A = ((int) b64A2) & baseB32;
			tmp32B = ((int) b64B2) & baseB32;

			// Integer.bitCount
			tmp32A = tmp32A - ((tmp32A >>> 1) & 0x55555555);
			tmp32A = (tmp32A & 0x33333333) + ((tmp32A >>> 2) & 0x33333333);
			tmp32A = (tmp32A + (tmp32A >>> 4)) & 0x0f0f0f0f;
			tmp32A = tmp32A + (tmp32A >>> 8);
			tmp32A = tmp32A + (tmp32A >>> 16);
			tmp32A &= 0x3f;

			// Integer.bitCount
			tmp32B = tmp32B - ((tmp32B >>> 1) & 0x55555555);
			tmp32B = (tmp32B & 0x33333333) + ((tmp32B >>> 2) & 0x33333333);
			tmp32B = (tmp32B + (tmp32B >>> 4)) & 0x0f0f0f0f;
			tmp32B = tmp32B + (tmp32B >>> 8);
			tmp32B = tmp32B + (tmp32B >>> 16);
			tmp32B &= 0x3f;

			if (tmp32A < tmp32B) // 反向

				return B.O;

			if (tmp32A > tmp32B)

				return B.I;

			// if (tmp32A < tmp32B) return B.I; // 出現 [A,D,E|B|C] 小於 [A,B,D|C|E]

			b64A2 >>>= n;

		} while ((b64B2 >>>= n) != 0b0L); // b64 可在兩 cell 之間會有空的 cell; 最多 32 字母

		// O.l("b64A=" + B64va.str(b64A) + O.L + "b64B=" + B64va.str(b64B));

		// 第二輪針對每一個房間內的人名比順序
		// b64A, b64B 沒有使用過

		int lowest1A, lowest1B;
		do {

			tmp32A = ((int) b64A) & baseB32;
			tmp32B = ((int) b64B) & baseB32;

			do {
				lowest1A = -tmp32A & tmp32A;
				lowest1B = -tmp32B & tmp32B;

				if (lowest1A < lowest1B) // 反向

					return B.O;

				if (lowest1A > lowest1B)

					return B.I;

				tmp32A = (~lowest1A & tmp32A);

			} while ((tmp32B = (~lowest1B & tmp32B)) != 0b0);

			b64A >>>= n;

		} while ((b64B >>>= n) != 0b0L); // b64 可在兩 cell 之間會有空的 cell; 最多 32 字母

		throw new RuntimeException(); // never reaches

	}

	/**
	 * To sort.<br/>
	 * To sort.
	 */
	@Override
	public ThrOntoWMin0WDynaB64 sort() { // selSort

		if (!O.isDev) {

			Arrays.sort(box);

			return this;

		}

		int len = iLen;
		if (len <= 1)

			return this;

		int lenMinus1 = (len - 1), step = 0, i, iVMin;

		long vStep, vMin;
		do {

			vMin = vStep = box[iVMin = step];
			i = step + 1; // 不會只排序 1 個元素

			do
				if (ifLt(tmp = box[i], vMin)) {

					iVMin = i;
					vMin = tmp;

				}

			while (++i != len);

			if (iVMin != step) { // swap

				box[iVMin] = vStep;
				box[step] = vMin;

			}

			if (O.isDev && (step % 800) == 0)

				O.l("step=" + O.f(step), THIS);

		} while (++step != lenMinus1);

		return this;

	}

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Ery to StringBuilder.
	 */
	@Override
	public StringBuilder toStr() {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		int len = iLen, idx, tmpK;

		for (idx = 0; idx != len;) { // len could be 0

			retStr.append(O.C91);

			tmp = box[idx];
			tmpK = k;

			do {

				if ((tmp32 = ((int) tmp) & baseB32) == 0b0) // b64 可在兩 cell 之間會有空的 cell; 最多 32 字母

					retStr.append(O.C95); // the char '_' or C32
				else
					retStr.append(rowInAbc(tmp32));

				tmp >>>= n;

				if (--tmpK == 0) // OntoWMin0

					break;
				else
					retStr.append(O.C124);

			} while (B.I);

			retStr.append(O.C93);

			if (++idx != len)
				retStr.append(O.C_A_L);

		}

		return retStr;

	}

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Ery to StringBuilder.
	 */
	public StringBuilder toHtmlWHead(String[] sAry, String[] sAryForHead, CharSequence sHtmlClass) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		StringBuilder strTheadStart = new StringBuilder("<table class=\"").append(sHtmlClass).append("\" ><thead><tr><td>");
		StringBuilder strTheadEnd = new StringBuilder("</td></tr></thead>");

		final StringBuilder strHead = new StringBuilder("<tr><td>");

		int iHead = 0;
		do {
			strHead.append(sAryForHead[iHead]);

			if (++iHead != k)

				strHead.append(Strva.STR_HTML_MIDDLE_TD);
			else {

				strHead.append("</td></tr>");

				break;

			}

		} while (B.I);

		for (int idx = 0, len = iLen, atK; idx != len;) { // len could be 0

			retStr.append(strTheadStart).append(idx + 1).append(strTheadEnd);
			retStr.append(strHead);
			retStr.append("<tr>");

			tmp = box[idx];
			atK = 0;

			do {
				if ((tmp32 = ((int) tmp) & mask32) == 0b0) // b64 可在兩 cell 之間會有空的 cell; 最多 32 字母

					retStr.append("<td>").append(Jsp.C_A_6_HTML_BLANK);
				else
					retStr.append("<td>").append(ThrS2WDynaB64.toHtmlRowStrBySAry(tmp32, sAry));

				tmp >>>= n; // b64 可在兩 cell 之間會有空的 cell

				if (++atK == k)
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

		// O.l(retStr, THIS);

		return retStr;

	}
}
