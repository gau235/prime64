package lgpl3.comb;

import java.math.BigInteger;

import lgpl3.o.O;

/**
 * 組合 (取物).<br/>
 * To do some Combinatorics exercise.
 *
 * @version 2021/02/21_20:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Cnk_A" >Cnk_A.java</a>
 *
 * @see Cnk_L
 */
public abstract class Cnk_A {

	// private static final Class<?> THIS = Cnk_A.class;

	/**
	 * 求有幾種組合情況的方法數.<br/>
	 * C(n,k)<br/>
	 * C(0,0)=1, C(1,0)=1, C(0,1)=0<br/>
	 * C(0,-2) will throw Exception.<br/>
	 * The number of ways of combination of the two input numbers (0 &lt;= k &lt;= n)
	 */
	public static long int64(int n, int k) {

		if (n < 0 || k < 0 || n < k)

			O.x("n=" + n + ", k=" + k);

		if (k > (n >>> 1))

			k = n - k;

		if (k == 0)

			return 1L;

		long ans = 1L;

		int to = n - k;
		for (k = 1; n != to;)

			ans = (ans * n--) / k++;

		return ans;

	}

	/**
	 * 求有幾種組合情況的方法數.<br/>
	 * C(n,k)<br/>
	 * C(0,0)=1, C(1,0)=1, C(0,1)=0<br/>
	 * C(0,-2) will throw Exception.<br/>
	 * The number of ways of combination of the two input numbers (0 &lt;= k &lt;= n)
	 */
	public static BigInteger bigInt(int n, int k) {

		if (n < 0 || k < 0 || n < k)

			O.x("n=" + n + ", k=" + k);

		if (k > (n >>> 1))

			k = n - k;

		if (k == 0)

			return BigInteger.ONE;

		BigInteger ans = BigInteger.ONE;

		for (int to = n - k; n > to; n--)

			ans = ans.multiply(BigInteger.valueOf(n));

		return ans.divide(Pnk.bigInt(k));

	}
}
