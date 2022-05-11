package lgpl3.shareWXyz;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.str.Strva;

/**
 * @version 2022/03/16_22:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Hxy_Z" >Hxy_Z.java</a>
 *
 * @see Hxy
 */
public abstract class Hxy_Z extends Hxy_U {

	private static final Class<?> THIS = Hxy_Z.class;

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public static StringBuilder toStrByVCellPlusMinMinus1(long b64W6, int min) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		b64W6 = B64W6.revAmongVCell(b64W6);

		--min;

		do {
			retStr.append((((int) b64W6) & B64W6.MASK32) + min);

			if (((int) (b64W6 >>>= B64W6.$6)) == 0b0) // terminate

				return retStr;

			retStr.append(O.C44);

		} while (B.I);

	}

	/**
	 * To StringBuilder as [1,1,2].<br/>
	 * To StringBuilder as [1,1,2].
	 */
	public static StringBuilder toStrByVCellPlusMinMinus1ByAry(long[] aryOfB64W6, int min, CharSequence lineWr) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		for (int idx = 0, len = aryOfB64W6.length; idx != len;) {

			retStr.append(O.C91).append(toStrByVCellPlusMinMinus1(aryOfB64W6[idx], min)).append(O.C93);

			if (++idx != len)

				if (idx == Strva.maxRowInHtml)

					return retStr;
				else
					retStr.append(lineWr);

		}

		return retStr;

	}

	/**
	 * To StringBuilder by B64W6.<br/>
	 * To StringBuilder by B64W6.
	 */
	public static StringBuilder rowStrAftH(long b64W6, int min, String[] sAry) {

		// sample:
		// [1,1,4]
		// [2,1,3]
		// [4,1,1]
		//
		// b64W6 = B64W6.revAmongVCell(b64W6);
		//
		// String s = "紅,黑,白";
		// from 紅,紅,紅
		// to 白,白,白
		// 人類習慣不用 revAmongVCell

		// 有嘗試過類似 B64W6.plusAllWV32 加入 -1 來 reduce 但效果不好

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR), tmpStr;

		for (int diff = (min - 1), vCell, idx = 0; B.I; idx++) {

			// O.l("vCell=" + ((((int) b64W6) & B64W6.MASK32) + diff), THIS);

			if ((vCell = (((int) b64W6) & B64W6.MASK32) + diff) != 0) {

				tmpStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

				do
					tmpStr.append(sAry[idx]).append(O.C44);

				while (--vCell != 0);

				retStr.append(tmpStr);

			}

			if (((int) (b64W6 >>>= B64W6.$6)) == 0b0) // todo: need to improve

				return retStr.deleteCharAt(retStr.length() - 1); // just one time

		}
	}

	/**
	 * To StringBuilder by B64W6.<br/>
	 * To StringBuilder by B64W6.
	 */
	public static StringBuilder toStrToHByAryOfB64W6(long[] aryOfB64W6, final int min, String[] sAry, CharSequence prefix,
			CharSequence lineWr) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		for (int idx = 0, len = aryOfB64W6.length; idx != len;) {

			retStr.append(idx + 1).append(prefix).append(rowStrAftH(aryOfB64W6[idx], min, sAry));

			if (++idx != len)

				if (idx == Strva.maxRowInHtml)

					return retStr;
				else
					retStr.append(lineWr);

		}

		return retStr;

	}
}
