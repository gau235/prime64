package lgpl3.comb;

import java.math.BigInteger;

import lgpl3.o.O;
import lgpl3.o.str.SByN;

/**
 * C(39,5) 可以表示成窮舉法 Σ [ C(有中, k) * C(沒中, 5-k) ] 取 k 從 0~5<br/>
 * 窮舉法
 *
 * @version 2021/05/22_19:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=VandermondeConvol_A" >VandermondeConvol_A.java</a>
 *
 * @see VandermondeConvol
 */
public abstract class VandermondeConvol_A {

	// private static final Class<?> THIS = VandermondeConvol_A.class;

	/**
	 * Vandermonde's convolution.<br/>
	 * Vandermonde's convolution.
	 */
	public static StringBuilder script(int totalN, int totalK, int partN) {

		StringBuilder retStr = new StringBuilder(O.defLenForStr);

		final int totalNMinusPartN = totalN - partN;

		int iLowerBound = partN;
		BigInteger sum = BigInteger.ZERO;
		BigInteger tmpBigInt;

		for (; iLowerBound >= 0; iLowerBound--) {

			int totalKMinusILowerBound = totalK - iLowerBound;
			// O.l("iLowerBound=" + iLowerBound);
			if (iLowerBound <= totalK) {

				if ((partN < iLowerBound) || (totalNMinusPartN < totalKMinusILowerBound))
					tmpBigInt = BigInteger.ZERO;

				else
					tmpBigInt = Cnk.bigInt(partN, iLowerBound).multiply(Cnk.bigInt(totalNMinusPartN, totalKMinusILowerBound));

				retStr.append("C(" + partN + "," + iLowerBound + ")*C(" + totalNMinusPartN + "," + totalKMinusILowerBound + ") = "
						+ SByN.f(tmpBigInt));

				sum = sum.add(tmpBigInt);
				retStr.append(O.C_A_L);

			}
		}

		tmpBigInt = Cnk.bigInt(totalN, totalK);
		retStr.append(O.C_A_L).append("C(" + totalN + "," + totalK + ") = " + SByN.f(tmpBigInt));

		O.eq(sum.compareTo(tmpBigInt), 0);

		return retStr;

	}
}
