package lgpl3.comb.stirlingN.thr;

import lgpl3.b32.B32va;
import lgpl3.comb.filter.CompaForAry32OfB32As2Pow;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.str.Strva;
import lgpl3.o.thr.ThrWBox;
import lgpl3.other.jsp.Jsp;

/**
 * S2.<br/>
 * S2.
 *
 * @version 2022/04/16_19:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=ThrS2WDynaB64_A" >ThrS2WDynaB64_A.java</a>
 *
 * @see ThrS2WDynaB64
 */
public abstract class ThrS2WDynaB64_A extends ThrWBox<long[]> {

	private static final Class<?> THIS = ThrS2WDynaB64_A.class;

	public int n;

	public int k;

	public int min;

	public int max;

	public int baseB32;

	public int nMulK;

	public int boundBit;

	public int iLen;

	public int tmp32;

	public long tmp;

	/**
	 * To StringBuilder from String array via bit32.<br/>
	 * To StringBuilder from String array via bit32.
	 */
	public static StringBuilder rowInAbc(int b32As2Pow) { // 最多 32 字母

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		int lowest1;
		do
			if ((lowest1 = (-b32As2Pow & b32As2Pow)) == b32As2Pow)

				return retStr.append((char) (65 + B32va.log2(lowest1)));
			else
				retStr.append((char) (65 + B32va.log2(lowest1))).append(O.C44);

		while ((b32As2Pow = (~lowest1 & b32As2Pow)) != 0b0);

		throw new RuntimeException("b32As2Pow=" + b32As2Pow); // never reaches

	}

	/**
	 * To StringBuilder from String ary via bit32.<br/>
	 * To StringBuilder from String ary via bit32.
	 */
	public static StringBuilder toHtmlRowStrBySAry(int b32As2Pow, String[] sAry) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		int lowest1, count = 0;

		do {
			if ((lowest1 = (-b32As2Pow & b32As2Pow)) == b32As2Pow)

				return retStr.append(sAry[B32va.log2(lowest1)]);
			else {

				retStr.append(sAry[B32va.log2(lowest1)]);

				if (++count == Strva.numOfWordPerLineForS2) {

					retStr.append(Jsp.BR);
					count = 0;

				} else
					retStr.append(O.C32);

			}

		} while ((b32As2Pow = (~lowest1 & b32As2Pow)) != 0b0);

		throw new RuntimeException(); // never reaches

	}

	/**
	 * To check if int32 all between min and max (both inclusive).<br/>
	 * To check if int32 all between min and max (both inclusive).
	 */
	public boolean ifEveryCellLegal(long b64) {

		do
			if (((tmp32 = B32va.countOf1(((int) b64) & baseB32)) < min) || (tmp32 > max)) // O.l("bitCount=" + bitCount, THIS);

				return B.O;

		while (((int) (b64 >>>= n)) != 0b0); // 在兩 cell 沒有空的 cell

		return B.I;

	}

	/**
	 * If less than.<br/>
	 * If less than.
	 */
	public boolean ifLt(long b64A, long b64B) {

		long b64A2 = b64A, b64B2 = b64B; // 全域變數 tmp 已經有人用掉

		// 比房間總數量
		int tmp32A = 0, tmp32B = 0;
		do
			tmp32A++;

		while (((int) (b64A2 >>>= n)) != 0b0); // 最多 32 字母

		do
			tmp32B++;

		while (((int) (b64B2 >>>= n)) != 0b0);

		if (tmp32A < tmp32B)

			return B.I;

		if (tmp32A > tmp32B)

			return B.O;

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

			if (tmp32A < tmp32B)

				return B.I;

			if (tmp32A > tmp32B)

				return B.O;

			// if (tmp32A < tmp32B) return B.I; // 出現 [A,D,E|B|C] 小於 [A,B,D|C|E]

			b64A2 >>>= n;

		} while (((int) (b64B2 >>>= n)) != 0b0); // 最多 32 字母

		// 第二輪針對每一個房間內的人名比順序
		// b64A, b64B 沒有使用過

		do {
			tmp32A = ((int) b64A) & baseB32;
			tmp32B = ((int) b64B) & baseB32;

			if ((tmp32A = CompaForAry32OfB32As2Pow.compaToSelSort(tmp32A, tmp32B)) < 0)

				return B.I;

			if (tmp32A > 0)

				return B.O;

			b64A >>>= n;

		} while (((int) (b64B >>>= n)) != 0b0); // 最多 32 字母

		throw new RuntimeException(); // never reaches

	}

	/**
	 * To sort.<br/>
	 * To sort.
	 */
	public ThrS2WDynaB64_A sort() { // selSort

		if (iLen <= 1)

			return this;

		int lenMinus1 = (iLen - 1), step = 0, i, iVMin;

		long vStep, vMin;

		do {
			vMin = vStep = box[iVMin = step];
			i = step + 1; // 不會只排序 1 個元素

			do
				if (ifLt(tmp = box[i], vMin)) {

					iVMin = i;
					vMin = tmp;

				}

			while (++i != iLen);

			if (iVMin != step) { // swap

				box[iVMin] = vStep;
				box[step] = vMin;

			}

		} while (++step != lenMinus1);

		return this;

	}

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Ery to StringBuilder.
	 */
	public StringBuilder toStr() {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		for (int idx = 0; idx != iLen;) { // len could be 0

			retStr.append(O.C91);

			tmp = box[idx];

			do {
				if ((tmp32 = ((int) tmp) & baseB32) == 0b0) // b64 可在兩 cell 之間會有空的 cell; 最多 32 字母

					O.x("todo: remove me");
				else
					retStr.append(rowInAbc(tmp32));

				if (((int) (tmp >>>= n)) == 0b0)

					break;
				else
					retStr.append(O.C124);

			} while (B.I);

			retStr.append(O.C93);

			if (++idx != iLen)

				retStr.append(O.C_A_L);

		}

		return retStr;

	}

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Ery to StringBuilder.
	 */
	public StringBuilder toHtmlStr(String[] sAry, CharSequence sHtmlClass) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		StringBuilder htmlStart1 = new StringBuilder("<table class=\"").append(sHtmlClass).append("\" ><thead><tr><td>");
		StringBuilder htmlEnd1 = new StringBuilder("</td></tr></thead>");

		for (int idx = 0; idx != iLen;) {

			retStr.append(htmlStart1).append(idx + 1).append(htmlEnd1).append(O.C_A_L);
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

			if (++idx != iLen) {

				if (idx == Strva.maxRowInHtml)

					return retStr;
				else
					retStr.append(Jsp.L);

			}
		}

		return retStr;

	}
}
