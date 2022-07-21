package lgpl3.comb;

import java.math.BigInteger;

import lgpl3.comb.powerSet.PowerSet;
import lgpl3.o.O;
import lgpl3.o.keyNV.KAry32V32;

/**
 * 求有幾種組合情況的方法數.
 *
 * @version 2022/04/21_20:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Cnk_A" >src</a>
 *
 * @see Cnk_V
 */
public abstract class Cnk_A {

	private static final Class<?> THIS = Cnk_A.class;

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
	 * 求有幾種組合情況的方法數.
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

	/**
	 * 從 1 列全相異數列中取出 k 個數.
	 */
	public static void colRecur(final int boundBit, int rmdK, int prefix, int curBit, KAry32V32 kV) {

		// B.n32++;

		if (--rmdK == 0) { // termination condition

			do
				kV.k[kV.v++] = (curBit | prefix);

			while ((curBit <<= 1) != boundBit);

			return;

		}

		// if you pick 3 from [A,B,C,D] then at most you can start from B as [B,C,D] not [C,D,X]
		int newBoundBit = boundBit >>> rmdK;

		// O.l("rmdK=" + rmdK + ", newBoundBit=" + B32va.str16(newBoundBit), THIS);

		do
			colRecur(boundBit, rmdK, (curBit | prefix), (curBit <<= 1), kV);

		while (curBit != newBoundBit); // while ((curBit << rmdK) <= boundBit);
		// while ((curBit << rmdK) < newBoundBit);

	}

	/**
	 * 從 1 列全相異數列中取出 k 個數.
	 */
	public static int[] colRecur(int n, int k) {

		if (n > 30) // fuck see toStrToOntoBySAryByB32

			O.x("n=" + n);

		if (n == k)

			return new int[] { ~(-0b1 << n) };

		KAry32V32 retKV = new KAry32V32(int64(n, k));

		colRecur((0b1 << n), k, 0b0, 0b1, retKV); // O.l(retKV.toStr(), THIS);

		return retKV.k;

	}

	/**
	 * 組合總數.<br/>
	 * To collect all C(n,k)
	 *
	 * @see PowerSet #colRecurByExtTail(int, int, KAry32V32, int)
	 */
	public static int[] colFrom1ToN(int n) {

		int my1ShiftLN = (0b1 << n), k;

		KAry32V32 ret = new KAry32V32(my1ShiftLN - 1);

		for (k = 1; k <= n; k++)

			colRecur(my1ShiftLN, k, 0b0, 0b1, ret);

		return ret.k;

	}
}
