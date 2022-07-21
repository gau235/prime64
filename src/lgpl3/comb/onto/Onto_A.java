package lgpl3.comb.onto;

import java.math.BigInteger;

import lgpl3.comb.Cnk;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.comb.filter.Condi;
import lgpl3.o.O;
import lgpl3.shareWXyz.Hxy;

/**
 * 回傳 Onto 函數值; 求 n 本相異書分給 k 個小孩的方法數.<br/>
 * To return the number of that m distinguish books giving to n people<br/>
 * then everyone at least got one.<br/>
 * Onto(n,k)=C(k,0)*k^n -C(k,1)*(k-1)^n +C(k,2)*(k-2)^n- ... +-C(k,k-1)*1^n
 *
 * @version 2021/09/30_19:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Onto_A" >Onto_A.java</a>
 *
 * @see Onto_J
 */
public abstract class Onto_A {

	// private static final Class<?> THIS = Onto_A.class;

	/**
	 * 回傳 Onto 函數值; 求 n 本相異書分給 k 個人的方法數.<br/>
	 * To return the number of ways to give n distinguish books to k people<br/>
	 * then everyone at least gets one book.<br/>
	 * Onto(n,k)=C(k,0)*k^n -C(k,1)*(k-1)^n +C(k,2)*(k-2)^n- ... +-C(k,k-1)*1^n
	 */
	public static long int64ByToInEx(int n, int k) {

		long ans = 0L;

		for (int i = 0; i != k; i++)

			if ((i & 0b1) == 0b0) // O.l("C(" + n + "," + i + ")*" + (n - i) + "^" + m, THIS);

				ans = ans + Cnk.int64(k, i) * O.pow(k - i, n);
			else
				ans = ans - Cnk.int64(k, i) * O.pow(k - i, n);

		return ans;

	}

	/**
	 * 回傳 Onto 函數值; 求 n 本相異書分給 k 個人的方法數.<br/>
	 * To return the number of ways to give n distinguish books to k people<br/>
	 * then everyone at least gets one book.<br/>
	 * Onto(n,k)=C(k,0)*k^n -C(k,1)*(k-1)^n +C(k,2)*(k-2)^n- ... +-C(k,k-1)*1^n
	 */
	public static BigInteger bigIntByToInEx(int n, int k) {

		BigInteger ans = BigInteger.ZERO;

		for (int i = 0; i != k; i++)

			if ((i & 0b1) == 0b0) // O.l("C(" + n + "," + i + ")*" + (n - i) + "^" + m , THIS);

				ans = ans.add(Cnk.bigInt(k, i).multiply(BigInteger.valueOf(k - i).pow(n)));
			else
				ans = ans.subtract(Cnk.bigInt(k, i).multiply(BigInteger.valueOf(k - i).pow(n)));

		return ans;

	}

	/**
	 * 回傳 Onto 函數值; 求 n 本相異書分給 k 個人的方法數.<br/>
	 * To return the number of ways to give n distinguish books to k people<br/>
	 * then everyone at least gets one book.<br/>
	 * Onto(n,k)=C(k,0)*k^n -C(k,1)*(k-1)^n +C(k,2)*(k-2)^n- ... +-C(k,k-1)*1^n
	 */
	public static long int64ByHxy(Condi condi) {

		long[] ary = Hxy.col(condi.n, condi.k, condi.min, condi.max);

		long b64W6ToC, tmpAns, ans = 0L;

		int myN = condi.n, diff = (condi.min - 1), idx = 0, tmp32; // diff is reduced for performance

		while (idx != ary.length) {

			b64W6ToC = B64W6.revAmongVCell(ary[idx]);
			// O.l("b64W6ToC=" + B64W6.str24((int) b64W6ToC), THIS);
			// O.l("b64W6ToC=" + B64W6.toStrForToDiI(B64W6.revAmongVCell(b64W6ToC), 0), THIS);

			tmpAns = 1L;

			do {
				tmpAns *= Cnk.int64(myN, (tmp32 = (((int) b64W6ToC) & B64W6.MASK32) + diff));

				myN -= tmp32; // O.l("restN", "tmp", restN, tmp); // O.l("tmpAns=" + tmpAns, THIS);

			} while ((b64W6ToC >>>= B64W6.$6) != 0b0L);

			if (++idx < ary.length)

				myN = condi.n;

			ans += tmpAns;

		}

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

		int myN = condi.n, diff = (condi.min - 1), idx = 0, tmp32; // diff is reduced for performance

		while (idx != ary.length) {

			b64W6ToC = B64W6.revAmongVCell(ary[idx]); // O.l("b64W6ToC=" + B64W6.str24((int) b64W6ToC), THIS);

			tmpAns = BigInteger.ONE;

			do {

				tmpAns = tmpAns.multiply(Cnk.bigInt(myN, (tmp32 = (((int) b64W6ToC) & B64W6.MASK32) + diff)));

				myN -= tmp32; // O.l("myN, tmp32=" + myN + "," + tmp32);

			} while ((b64W6ToC >>>= B64W6.$6) != 0b0L);

			if (++idx < ary.length)

				myN = condi.n;

			ans = ans.add(tmpAns); // O.l("ans=" + ans, THIS);

		}

		return ans;

	}
}
