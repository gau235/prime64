package lgpl3.comb.powerSet.sample;

import lgpl3.comb.powerSet.PowerSet;
import lgpl3.o.B;
import lgpl3.o.O;

/**
 * To match value; balance.<br/>
 * 高考普考.
 *
 * @version 2022/04/26_12:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex72_MatchV_Sqst" >Ex72_MatchV_Sqst.java</a>
 *
 * @see PowerSet#printAll(String[], int, String)
 */
public class Ex72_MatchV_Sqst {

	public static int[] ary = { 7, 3, 2, 5, 8 };
	// public static int[] ary = { 50, 20, 20, 15, 10, 2, 1, 1, 1 };

	public static boolean sqst(String prefix, int idx, int rmd) {

		if (rmd == 0) {

			O.l(prefix);

			return B.I;

		}

		if (idx < 0 || rmd < 0) {

			O.l("fail");

			return B.O;

		}

		boolean inclu = sqst((prefix + ary[idx] + " "), (idx - 1), (rmd - ary[idx]));

		boolean exclu = sqst(prefix, (idx - 1), rmd);

		return (inclu || exclu);

	}

	public static void main(String[] sAry) {

		int targetV = 14;
		// int targetV32 = 75;

		sqst("", (ary.length - 1), targetV);

	}
}