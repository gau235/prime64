package lgpl3.comb.onto;

import java.math.BigInteger;

import lgpl3.comb.Cnk;
import lgpl3.comb.Pnk;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.comb.filter.Condi;
import lgpl3.o.O;
import lgpl3.shareWXyz.Hxy;

/**
 * OntoP.<br/>
 * OntoP.
 *
 * @version 2022/02/23_17:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=OntoP" >OntoP.java</a>
 *
 * @see Onto
 */
public abstract class OntoP {

	private static final Class<?> THIS = OntoP.class;

	/**
	 * OntoP(n,k) = C(n-1,k-1)*n!<br/>
	 * OntoP(n,k) = C(n-1,k-1)*n!
	 */
	public static long int64(int n, int k) {

		if (n <= 0 || k <= 0 || n < k)

			O.x("n=" + n + ", k=" + k);

		return (k == 1) ? Pnk.int64(n) : Cnk.int64(n - 1, k - 1) * Pnk.int64(n);

	}

	/**
	 * OntoP(n,k) = C(n-1,k-1)*n!<br/>
	 * OntoP(n,k) = C(n-1,k-1)*n!
	 */
	public static BigInteger bigInt(int n, int k) {

		if (n <= 0 || k <= 0 || n < k)

			O.x("n=" + n + ", k=" + k);

		return (k == 1) ? Pnk.bigInt(n) : Cnk.bigInt(n - 1, k - 1).multiply(Pnk.bigInt(n));

	}

	/**
	 * 回傳 Onto 函數值; 求 n 本相異書分給 k 個人的方法數.<br/>
	 * To return the number of ways to give n distinguish books to k people<br/>
	 * then everyone at least gets one book.<br/>
	 * Onto(n,k)=C(k,0)*k^n -C(k,1)*(k-1)^n +C(k,2)*(k-2)^n- ... +-C(k,k-1)*1^n
	 */
	public static long int64ByHxy(Condi condi) {

		long[] ary = Hxy.col(condi.n, condi.k, condi.min, condi.max);

		// O.l("n, k, min, max=" + condi.n + ", " + condi.k + ", " + condi.min + ", " + condi.max, THIS);

		long b64W6ToC, tmpAns, ans = 0L;

		int myN, diff = (condi.min - 1), idx = 0, tmp32; // diff is reduced for performance

		do {
			myN = condi.n;

			b64W6ToC = B64W6.revAmongVCell(ary[idx]);
			// O.l("b64W6ToC=" + B64W6.str24((int) b64W6ToC), THIS);

			tmpAns = 1L;
			do {
				tmpAns *= Pnk.int64(myN, (tmp32 = (((int) b64W6ToC) & B64W6.MASK32) + diff));

				// O.l("myN", "tmp32", myN, tmp32);

				myN -= tmp32;

			} while ((b64W6ToC >>>= B64W6.$6) != 0b0L);

			ans += tmpAns;

		} while (++idx != ary.length);

		return ans;

	}

	/**
	 * 回傳 Onto 函數值; 求 n 本相異書分給 k 個人的方法數.<br/>
	 * To return the number of ways to give n distinguish books to k people<br/>
	 * then everyone at least gets one book.<br/>
	 * Onto(n,k)=C(k,0)*k^n -C(k,1)*(k-1)^n +C(k,2)*(k-2)^n- ... +-C(k,k-1)*1^n
	 */
	public static BigInteger bigIntByHxy(Condi condi) {

		long[] ary = Hxy.col(condi.n, condi.k, condi.min, condi.max);

		long b64W6ToC;

		BigInteger tmpAns, ans = BigInteger.ZERO;

		int myN, diff = (condi.min - 1), idx = 0, tmp32; // diff is reduced for performance

		do {
			myN = condi.n;

			b64W6ToC = B64W6.revAmongVCell(ary[idx]); // O.l("b64W6ToC=" + B64W6.str24((int) b64W6ToC), THIS);

			tmpAns = BigInteger.ONE;

			do {
				tmpAns = tmpAns.multiply(Pnk.bigInt(myN, (tmp32 = (((int) b64W6ToC) & B64W6.MASK32) + diff)));

				myN -= tmp32; // O.l("myN, tmp32=" + myN + "," + tmp32);

			} while ((b64W6ToC >>>= B64W6.$6) != 0b0L);

			ans = ans.add(tmpAns); // O.l("ans=" + ans, THIS);

		} while (++idx != ary.length);

		return ans;

	}

	/**
	 * If passes test.<br/>
	 * If passes test.
	 */
	public static void test() {

		Condi condi = new Condi();

		for (int n = 10, k, min; n != 0; n--)

			for (k = n; k != 0; k--)

				for (min = n / k; min >= 1; min--) {

					condi.n = n;
					condi.k = k;
					condi.min = min;
					condi.max = n;

					condi.checkArg();

					if (bigIntByHxy(condi).longValue() != int64ByHxy(condi))

						O.x(condi.toStr());

				}
	}
}
