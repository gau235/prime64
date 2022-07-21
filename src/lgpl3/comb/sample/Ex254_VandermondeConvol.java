package lgpl3.comb.sample;

import java.math.BigInteger;

import lgpl3.comb.Cnk;
import lgpl3.comb.Pnk;
import lgpl3.o.O;
import lgpl3.o.str.SByN;

/**
 * Vandermonde Convolution.<br/>
 * Vandermonde Convolution.
 *
 * @version 2021/05/19_20:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex254_VandermondeConvol" >
 *          Ex254_VandermondeConvol.java</a>
 *
 */
public class Ex254_VandermondeConvol {

	/**
	 * 求有幾種組合情況的方法數.<br/>
	 * C(n,k).<br/>
	 * C(0,0)=1, C(1,0)=1, C(0,1)=0.<br/>
	 * C(0,-2) will throw Exception.<br/>
	 * The number of ways of combination of the two input numbers (0 &lt;= k &lt;= n).
	 *
	 * @see Pnk#bigInt(int, int)
	 */
	public static BigInteger c(int n, int k) {

		if (n < 0 || k < 0)
			O.x("n=" + n + ", k=" + k);

		if (k == 0 || n == k) // fuck
			return BigInteger.ONE;

		if (n < k)
			return BigInteger.ZERO;

		if (k > (n >>> 1))
			k = n - k;

		return Pnk.bigInt(n, k).divide(Pnk.bigInt(k));

	}

	public static void main(String[] sAry) throws Throwable {

		// Vandermonde's convolution
		final int totalN = 39;// 全部幾支
		final int totalK = 5;// 單張彩卷 5 個號碼

		final int partN = 8;// 包牌幾支

		int hitN = totalK;
		int iLowerBound = 2;

		BigInteger sum = BigInteger.ZERO;

		for (; hitN >= 0; hitN--) {

			if (hitN >= iLowerBound)
				O.l("hitN=" + hitN);

			else
				O.l("hitN=" + hitN + " no money");

			int tmpA = partN;
			int tmpB = hitN;
			int tmpC = totalN - partN;
			int tmpD = totalK - hitN;

			BigInteger tmpBigInt = c(tmpA, tmpB).multiply(c(tmpC, tmpD));

			O.l("C(" + tmpA + "," + tmpB + ")*C(" + tmpC + "," + tmpD + ") = " + SByN.f(tmpBigInt));

			if (hitN >= iLowerBound)
				sum = sum.add(tmpBigInt);

			O.l();

		}

		BigInteger total = Cnk.bigInt(totalN, totalK);

		O.l("sum=" + SByN.f(sum));
		O.l("total=" + SByN.f(total) + O.L);

		O.l("hit rate=" + (sum.floatValue() / total.floatValue()));

	}
}