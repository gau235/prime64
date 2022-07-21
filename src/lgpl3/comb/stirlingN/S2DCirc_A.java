package lgpl3.comb.stirlingN;

import lgpl3.comb.DCirc;
import lgpl3.comb.Pnk;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.comb.filter.Condi;
import lgpl3.divIntoHeap.Dih;

/**
 * Stirling number of the second kind.<br/>
 * Stirling number of the second kind.<br/>
 * 简称: 5 人分 3 群.
 *
 * @version 2022/02/06_15:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=S2DCirc_A" >S2DCirc_A.java</a>
 *
 * @see S2DCirc
 */
public abstract class S2DCirc_A extends S2nk_Z {

	// private static final Class<?> THIS = S2DCirc_A.class;

	/**
	 * Stirling number of the second kind.<br/>
	 * Stirling number of the second kind.
	 */
	public static long int64ByToDiI(Condi condi) {

		final long[] ary = Dih.col(condi.n, condi.k, condi.min, condi.max);

		long b64W6ToC, b64W6ForDup, tmpAns, ans = 0L;

		int myN, diff = (condi.min - 1), idx = 0, tmp32; // diff is reduced for performance

		do {
			myN = condi.n;

			b64W6ForDup = b64W6ToC = B64W6.revAmongVCell(ary[idx]);

			tmpAns = 1L;
			do {
				tmpAns *= DCirc.int64(myN, (tmp32 = (((int) b64W6ToC) & B64W6.MASK32) + diff));

				myN -= tmp32; // O.l("myN", "tmp", myN, tmp); // O.l("tmpAns=" + tmpAns, THIS);

			} while ((b64W6ToC >>>= B64W6.$6) != 0b0L);

			////////////////////// init to call countDupNRev
			if (condi.min == 0)

				while ((((int) b64W6ForDup) & B64W6.MASK32) == 1)

					b64W6ForDup >>>= B64W6.$6; // O.l("b64W6CountDup=" + B64W6.str24(b64W6CountDup), THIS);

			////////////////////// end init to call countDupNRev

			for (b64W6ForDup = B64W6.countDupNRev(b64W6ForDup); b64W6ForDup != 0b0L; b64W6ForDup >>>= B64W6.$6)

				tmpAns /= Pnk.int64(((int) b64W6ForDup) & B64W6.MASK32);

			ans += tmpAns; // O.l("ans=" + ans, THIS);

		} while (++idx != ary.length);

		return ans;

	}
}
