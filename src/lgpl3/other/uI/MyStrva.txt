package lgpl3.other.uI;

import javax.swing.SwingUtilities;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.str.SByN;
import lgpl3.o.time.T64;
import lgpl3.other.jsp.ThrToSendHttpErr;
import lgpl3.prime64.PrimeAry2D;

/**
 * 本類別字串娃.<br/>
 * My girl to handle the string.
 *
 * @version 2021/09/07_19:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=MyStrva" >MyStrva.java</a>
 *
 */
public abstract class MyStrva {

	// private static final Class<?> THIS = MyStrva.class;

	/**
	 * Default capacity for StringBuilder.<br/>
	 * Default capacity for StringBuilder.
	 */
	public static final int DEF_CAPACITY32_FOR_STR = 0b1 << 15; // 8000 p * 1000 ary, every p is 20

	/**
	 * If to show every prime.<br/>
	 * If to show every prime.
	 */
	public static boolean isToShowEveryPrime = B.I;

	/**
	 * 3 blanks.<br/>
	 * 3 blanks.
	 */
	public static final StringBuilder STR_4_BLANK = new StringBuilder("    ");

	/**
	 * 把陣列轉成字串建立者.<br/>
	 * To convert the array to StringBuilder.
	 */
	public static StringBuilder toStrFromAryOfP(long[] ary, int numOfWordPerLine) {

		StringBuilder retStr = new StringBuilder(DEF_CAPACITY32_FOR_STR);

		int countOfWordInLine = 0;
		for (int idx = ary.length - 1; idx != -1; idx--) {

			retStr.append(ary[idx]);

			if (idx != 0)
				retStr.append(O.STR_C44C32);

			if (++countOfWordInLine == numOfWordPerLine) {

				retStr.append(O.C_A_L);
				countOfWordInLine = 0;

			}
		}

		return retStr;

	}

	/**
	 * 計算一列有多少個數.<br/>
	 * To count the number of String in every row.
	 */
	public static int countNumOfStringPerLine(long maxPrime) {

		int ans = 4; // def

		if (MySwingva.scrlpaneMP0 == null)
			return ans;

		StringBuilder singleStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR).append(maxPrime).append(O.C44).append(O.C32);

		// O.lD("scrlpaneMP0.getViewport().getWidth()=" + scrlpaneMP0.getViewport().getWidth(), THIS);
		// O.lD("txtarea.getFont()=" + txtarea.getFont(), THIS);
		// O.lD("mainFrame.getWidth=" + MyComponentva.mainFrame.getWidth(), THIS);

		int widthOfSingleString = SwingUtilities.computeStringWidth(MySwingva.metricOfFontDialog_1_30, singleStr.toString());

		if ((ans = (MySwingva.scrlpaneMP0.getViewport().getWidth() / widthOfSingleString)) == 0)
			return 1;

		return ans;

	}

	/**
	 * To generate the head str.<br/>
	 * To generate the head str.
	 */
	public static StringBuilder genHeadStr() {

		return new StringBuilder(O.DEF_CAPACITY32_FOR_STR).append(O.C_A_L).append(T64.toTimeStrWGmt()).append(O.C_A_L);
	}

	/**
	 * 生成欲顯示文字 .<br/>
	 * To generate the str of the summary of the paragraph.
	 */
	public static StringBuilder genSummaryOfSeg(StringBuilder strN1, StringBuilder strN2, StringBuilder strTotalP,
			StringBuilder strTimeCost) {

		StringBuilder str = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		str.append(O.C_A_L);
		str.append(strN2).append(" ~ ").append(strN1).append(STR_4_BLANK).append(strTotalP).append(" p   ").append(strTimeCost)
				.append(" s");
		str.append(O.C_A_L);

		// O.lD("genSummaryOfSeg=" + str, THIS);

		return str;

	}

	/**
	 * 生成欲顯示文字 .<br/>
	 * To generate the text to show.
	 */
	public static StringBuilder genStrToShowFrom1PrimeAry(long[] aryOfP, float timeCost) {

		StringBuilder str = new StringBuilder(DEF_CAPACITY32_FOR_STR);

		int len = aryOfP.length;

		if (len != 0) {

			StringBuilder strN1, strN2, strTotalP, strTimeCost;
			long tailP = aryOfP[len - 1];

			strN1 = new StringBuilder(O.f(aryOfP[0]));
			strN2 = new StringBuilder(O.f(tailP));
			strTotalP = new StringBuilder(O.f(len));
			strTimeCost = new StringBuilder(String.format(SByN.REGEX_FLOAT, timeCost));

			str.append(genSummaryOfSeg(strN1, strN2, strTotalP, strTimeCost));

			if (isToShowEveryPrime) // O.lD("countNumOfStringPerLine=" + countNumOfStringPerLine(tailP), THIS);
				str.append(toStrFromAryOfP(aryOfP, countNumOfStringPerLine(tailP))).append(O.C_A_L);

		}

		return str;

	}

	/**
	 * To gen str to show.<br/>
	 * To gen str to show.
	 */
	public static StringBuilder genSegFromPrimeAry2D(PrimeAry2D primeAry2D, float timeCost) {

		StringBuilder str = new StringBuilder(DEF_CAPACITY32_FOR_STR);

		final int lenMinus = primeAry2D.iLen - 1;
		int idxViewed = primeAry2D.idxViewed;
		long[] aryOfP;

		int idx = lenMinus;
		for (; idx != idxViewed; idx--) { // todo: why for (idx ++ len primeAry2D) 停在 99 %

			// if (idx < 0) return new StringBuilder(DEF_CAPACITY32_FOR_STR);

			if ((aryOfP = primeAry2D.arr[idx]) == null) {

				new ThrToSendHttpErr("#genSegFromPrimeAry2D", "idx=" + idx);

				break; // miss some ary

			}

			str.append(genStrToShowFrom1PrimeAry(aryOfP, timeCost)); // aryOfP not null

		}

		primeAry2D.idxViewed = lenMinus;

		return str;

	}

	/**
	 * To get done str.<br/>
	 * To get done str.
	 */
	public static StringBuilder genAllThrTerminatedStr(StringBuilder strN1, StringBuilder strN2, StringBuilder strTotalP,
			StringBuilder strTimeCost) {

		return new StringBuilder(O.DEF_CAPACITY32_FOR_STR).append(strN1).append(" ~ ").append(strN2).append(STR_4_BLANK).append(strTotalP)
				.append(" p   ").append(strTimeCost).append(" s").append(O.C_A_L);

	}
}
