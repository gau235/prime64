package lgpl3.comb.stirlingN;

import java.math.BigInteger;

import lgpl3.comb.Cnk;
import lgpl3.comb.Pnk;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.comb.filter.Condi;
import lgpl3.divIntoHeap.Dih;

/**
 * Stirling number of the second kind.<br/>
 * Stirling number of the second kind.<br/>
 * 简称: 5 人分 3 群.
 *
 * @version 2021/01/18_12:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=S2nk_A" >S2nk_A.java</a>
 *
 * @see S2nk_B
 */
public abstract class S2nk_A {

	// private static final Class<?> THIS = S2nk_A.class;

	/**
	 * Stirling number of the second kind.<br/>
	 * Stirling number of the second kind.
	 */
	public static long int64ByDih(Condi condi) {

		final long[] ary = Dih.col(condi.n, condi.k, condi.min, condi.max);

		long b64W6ToC, b64W6ForDup, tmpAns, ans = 0L;

		int myN, diff = (condi.min - 1), idx = 0, tmp32; // diff is reduced for performance

		do {
			myN = condi.n;

			b64W6ForDup = b64W6ToC = B64W6.revAmongVCell(ary[idx]);

			tmpAns = 1L;
			do {
				tmpAns *= Cnk.int64(myN, (tmp32 = (((int) b64W6ToC) & B64W6.MASK32) + diff));

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

	/**
	 * Stirling number of the second kind.<br/>
	 * Stirling number of the second kind.
	 */
	public static BigInteger bigIntByDih(Condi condi) {

		final long[] ary = Dih.col(condi.n, condi.k, condi.min, condi.max);

		long b64W6ToC, b64W6ForDup;

		int myN, diff = (condi.min - 1), idx = 0, tmp32; // diff is reduced for performance

		BigInteger ans = BigInteger.ZERO, tmpAns;

		do {
			myN = condi.n;

			b64W6ForDup = b64W6ToC = B64W6.revAmongVCell(ary[idx]);

			tmpAns = BigInteger.ONE;
			do {

				tmpAns = tmpAns.multiply(Cnk.bigInt(myN, (tmp32 = (((int) b64W6ToC) & B64W6.MASK32) + diff)));

				myN -= tmp32;

			} while ((b64W6ToC >>>= B64W6.$6) != 0b0L);

			////////////////////// init to call countDupNRev
			if (condi.min == 0)

				while ((((int) b64W6ForDup) & B64W6.MASK32) == 1)

					b64W6ForDup >>>= B64W6.$6; // O.l("b64W6CountDup=" + B64W6.str24(b64W6CountDup), THIS);

			////////////////////// end init to call countDupNRev

			for (b64W6ForDup = B64W6.countDupNRev(b64W6ForDup); b64W6ForDup != 0b0L; b64W6ForDup >>>= B64W6.$6)

				tmpAns = tmpAns.divide(Pnk.bigInt(((int) b64W6ForDup) & B64W6.MASK32));

			ans = ans.add(tmpAns); // O.l("ans=" + ans , THIS);

		} while (++idx != ary.length);

		return ans;

	}
}
