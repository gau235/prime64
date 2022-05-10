package lgpl3.comb.sample;

import lgpl3.comb.DCirc;
import lgpl3.comb.PCirc;
import lgpl3.comb.Pnk;
import lgpl3.comb.b64W6.B64W6;
import lgpl3.comb.thr.ThrToPCircAsDnk;
import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 環狀排列且全錯排.<br/>
 * Derangement and circular permutation.
 *
 * @version 2021/05/28_00:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=P93_PCircAsDnk" >P93_PCircAsDnk.java</a>
 *
 */
public class P93_PCircAsDnk {

	/**
	 * 把 long[] of B64W6 轉成字串建立者.<br/>
	 * To convert the long[] of B64W6 to StringBuilder.
	 */
	public static long fix(long b64W6, int totalV, final long sortedB64W6) {

		final long oldB64W6 = b64W6;

		long mySortedB64;

		int xToRotate = totalV - 1;
		int dToShift;

		long tmp;
		do {

			tmp = b64W6;
			mySortedB64 = sortedB64W6;

			O.l("tmp=" + B64W6.strByVCellAftRev(tmp) + " old=" + B64W6.strByVCellAftRev(oldB64W6));

			O.l("tmp=" + B64W6.str24(tmp));
			// O.l("idx0=" + (((int) tmp) & MASK32));

			O.l("mySortedB64=" + B64W6.strByVCellAftRev(mySortedB64));
			O.l("mySortedB64=" + B64W6.str24(mySortedB64));

			dToShift = totalV;

			loopToShift: {

				do {

					if ((((int) tmp) & ThrToPCircAsDnk.MASK32) == (((int) mySortedB64) & ThrToPCircAsDnk.MASK32)) {

						O.l("break=" + (char) (64 + (((int) tmp) & ThrToPCircAsDnk.MASK32)));

						break loopToShift; // matches

					}

					tmp >>>= B64W6.$6;
					mySortedB64 >>>= B64W6.$6;

				} while (--dToShift != 0);

				return b64W6; // not match any cell, success

			} // loopToShift:

			b64W6 = (((b64W6 & ThrToPCircAsDnk.MASK32) << ((totalV - 1) * B64W6.$6)) | (b64W6 >>> B64W6.$6));

			O.l("rotateR=" + B64W6.strByVCellAftRev(b64W6));
			// end rotateR

		} while (--xToRotate != 0);

		return 0b0L;

	}

	/**
	 * 把 long[] of B64W6 轉成字串建立者.<br/>
	 * To convert the long[] of B64W6 to StringBuilder.
	 */
	public static StringBuilder toStr(long[] ary) {

		final boolean isToFix = B.O;

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		long tmp;

		int totalV = B64W6.totalVCell(tmp = ary[0]);
		long sortedB64 = B64W6.easySort(tmp, totalV);

		for (int i = 0; i != ary.length;) {

			if (isToFix) {

				tmp = fix(ary[i], totalV, sortedB64);
				retStr.append(B64W6.strByVCellAftRev(tmp));

			} else
				retStr.append(B64W6.strByVCellAftRev(ary[i]));

			if (++i != ary.length)
				retStr.append(O.C_A_L);

		}

		return retStr;

	}

	/**
	 * To reverse.<br/>
	 * To reverse.
	 */
	public static long[] revAmongVCellAll(long[] ary) {

		long[] retAry = new long[ary.length];

		for (int idx = 0; idx != ary.length; idx++)
			retAry[idx] = B64W6.revAmongVCell(ary[idx]);

		return retAry;

	}

	public static void main(String[] sAry) throws Throwable {

		int n = 5;
		int k = 5;

		ThrToPCircAsDnk thr = new ThrToPCircAsDnk();
		thr.col(n, k);

		long[] ary = thr.box.trim().ary;

		O.eq(thr.box.iLen, DCirc.int64(n, k));

		// java.util.Arrays.sort(ary);
		O.l("firstRow=" + B64W6.str24(ary[0]));

		StringBuilder str = Pnk.strByAryOfRevB64W6BySAry(revAmongVCellAll(ary), O.S_ARY_A_Z);
		// str = Pva.toStrWWornSHeadByAryOfB64W6(ary, O.S_ARY_A_Z, O.S_ARY_A_Z, O.L);

		// StringBuilder str = toStr(ary);
		O.l(str);

		O.l("len=" + O.f(thr.box.iLen) + O.S9 + "diff=" + (PCirc.int64(n) - thr.count32));

	}
}
