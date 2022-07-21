package lgpl3.comb.stirlingN;

import java.math.BigInteger;

import lgpl3.comb.Cnk;
import lgpl3.comb.Pnk;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.comb.filter.Condi;
import lgpl3.divIntoHeap.Dih;
import lgpl3.o.O;

/**
 * Stirling number of the third kind.<br/>
 * Lah numbers.<br/>
 * 简称: 5 人排 3 队.
 *
 * @version 2022/02/23_17:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=S2P_A" >S2P_A.java</a>
 *
 * @see S2P_Y
 */
public abstract class S2P_A extends S2nk_Z {

	// private static final Class<?> THIS = S2P_A.class;

	/**
	 * To divide into then to permutate.<br/>
	 * To divide into then to permutate.
	 *
	 * @see #bigIntByDih(Condi)
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
				tmpAns *= Pnk.int64(myN, (tmp32 = (((int) b64W6ToC) & B64W6.MASK32) + diff));

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
	 * To divide into then to permutate.<br/>
	 * To divide into then to permutate.
	 *
	 * @see #int64ByDih(Condi)
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

				tmpAns = tmpAns.multiply(Pnk.bigInt(myN, (tmp32 = (((int) b64W6ToC) & B64W6.MASK32) + diff)));

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

	/**
	 * Stirling number of the third kind.<br/>
	 * S3(n,k) = C(n-1,k-1)*n!/k!<br/>
	 * Lah Number.
	 */
	public static long int64(int n, int k) {

		if (n <= 0 || k <= 0 || n < k)

			O.x("n=" + n + ", k=" + k);

		return (k == 1) ? Pnk.int64(n) : (Cnk.int64(n - 1, k - 1) * (Pnk.int64(n) / Pnk.int64(k)));

	}

	/**
	 * Stirling number of the third kind.<br/>
	 * S3(n,k) = C(n-1,k-1)*n!/k!<br/>
	 * Lah Number.
	 */
	public static BigInteger bigInt(int n, int k) {

		if (n <= 0 || k <= 0 || n < k)

			O.x("n=" + n + ", k=" + k);

		return (k == 1) ? Pnk.bigInt(n) : Cnk.bigInt(n - 1, k - 1).multiply(Pnk.bigInt(n).divide(Pnk.bigInt(k)));

	}
}
