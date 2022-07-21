package lgpl3.comb;

import java.math.BigInteger;

import lgpl3.comb.filter.Condi;
import lgpl3.comb.onto.Onto;
import lgpl3.o.O;

/**
 * 排容原理.<br/>
 * 例如 :<br/>
 * A, B, C, D 排成一列, 但 A 不排第 1 位, B 不排第 2 位的方法數 :<br/>
 * 為 4 人有 2 人是限定條件 inEx(4,2).<br/>
 * <br/>
 * To return the inclusion and exclusion function result, the number of<br/>
 * that n people line up but k guys not at their position.<br/>
 * PInEx(n,k)=C(k,0)*(n-0)! -C(k,1)*(n-1)! +C(k,2)*(n-2)! - ... +-C(k,k)*(n-k)!
 *
 * @version 2021/05/22_11:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=PByToInEx" >PByToInEx.java</a>
 *
 * @see PInEx
 */
public abstract class PByToInEx extends Pnk_Z {

	// private static final Class<?> THIS = PByToInEx.class;

	/**
	 * 排容原理.<br/>
	 * 例如 :<br/>
	 * A, B, C, D 排成一列, 但 A 不排第 1 位, B 不排第 2 位的方法數 :<br/>
	 * 為 4 人有 2 人是限定條件 PInEx(4,2).<br/>
	 * To return the inclusion and exclusion function result, the number of<br/>
	 * that n people line up but k guys not at their position.<br/>
	 * PInEx(n,k)=C(k,0)*(n-0)! -C(k,1)*(n-1)! +C(k,2)*(n-2)! - ... +-C(k,k)*(n-k)!
	 */
	public static long int64(int n, int k) {

		if (n <= 0 || k < 0 || n < k)

			O.x("n=" + n + ", k=" + k);

		long ans = 0L;

		for (int i = 0; i <= k; i++)

			if ((i & 0b1) == 0b0) // even

				ans += Cnk.int64(k, i) * int64(n - i);
			else
				ans -= Cnk.int64(k, i) * int64(n - i);

		return ans;

	}

	/**
	 * 排容原理.<br/>
	 * 例如 :<br/>
	 * A, B, C, D 排成一列, 但 A 不排第 1 位, B 不排第 2 位的方法數 :<br/>
	 * 為 4 人有 2 人是限定條件 PInEx(4,2).<br/>
	 * To return the inclusion and exclusion function result, the number of<br/>
	 * that n people line up but k guys not at their position.<br/>
	 * PInEx(n,k)=C(k,0)*(n-0)! -C(k,1)*(n-1)! +C(k,2)*(n-2)! - ... +-C(k,k)*(n-k)!
	 */
	public static long int64(int n, int k, int headKToEx) {

		if (n <= 0 || k < 0 || headKToEx < 0 || n < k || k < headKToEx)

			O.x("n=" + n + ", k=" + k + ", headKToEx=" + headKToEx);

		long ans = 0L;

		for (int i = 0; i <= headKToEx; i++)

			if ((i & 0b1) == 0b0)

				ans += Cnk.int64(headKToEx, i) * int64(k - i);
			else
				ans -= Cnk.int64(headKToEx, i) * int64(k - i);

		return ans * Cnk.int64(n, k);

	}

	/**
	 * 排容原理.<br/>
	 * 例如 :<br/>
	 * A, B, C, D 排成一列, 但 A 不排第 1 位, B 不排第 2 位的方法數 :<br/>
	 * 為 4 人有 2 人是限定條件 PInEx(4,2).<br/>
	 * To return the inclusion and exclusion function result, the number of<br/>
	 * that n people line up but k guys not at their position.<br/>
	 * PInEx(n,k)=C(k,0)*(n-0)! -C(k,1)*(n-1)! +C(k,2)*(n-2)! - ... +-C(k,k)*(n-k)!
	 */
	public static BigInteger bigInt(int n, int k) {

		if (n <= 0 || k < 0 || n < k)

			O.x("n=" + n + ", k=" + k);

		BigInteger ans = BigInteger.ZERO;

		for (int i = 0; i <= k; i++)

			if ((i & 0b1) == 0b0)

				ans = ans.add(Cnk.bigInt(k, i).multiply(bigInt(n - i)));
			else
				ans = ans.subtract(Cnk.bigInt(k, i).multiply(bigInt(n - i)));

		return ans;

	}

	/**
	 * 排容原理.<br/>
	 * 例如 :<br/>
	 * A, B, C, D 排成一列, 但 A 不排第 1 位, B 不排第 2 位的方法數 :<br/>
	 * 為 4 人有 2 人是限定條件 PInEx(4,2).<br/>
	 * To return the inclusion and exclusion function result, the number of<br/>
	 * that n people line up but k guys not at their position.<br/>
	 * PInEx(n,k)=C(k,0)*(n-0)! -C(k,1)*(n-1)! +C(k,2)*(n-2)! - ... +-C(k,k)*(n-k)!
	 */
	public static BigInteger bigInt(int n, int k, int headKToEx) {

		if (n <= 0 || k < 0 || headKToEx < 0 || n < k || k < headKToEx)

			O.x("n=" + n + ", k=" + k + ", headKToEx=" + headKToEx);

		BigInteger ans = BigInteger.ZERO;

		for (int i = 0; i <= headKToEx; i++)

			if ((i & 0b1) == 0b0)

				ans = ans.add(Cnk.bigInt(headKToEx, i).multiply(bigInt(k - i)));
			else
				ans = ans.subtract(Cnk.bigInt(headKToEx, i).multiply(bigInt(k - i)));

		return ans.multiply(Cnk.bigInt(n, k));

	}

	/**
	 * 排列套用排容原理.<br/>
	 * 例如 :<br/>
	 * A, B, C, D, E, F, G 排成一列, 但 A 不排第 1 位, B 不排第 2 位, C 不排第 3 位的方法數 :<br/>
	 * 為 7 人有 3 人是限定條件 PInEx(7,3).<br/>
	 * To return the inclusion and exclusion function result, the number of<br/>
	 * that n people line up but headKToEx guys not at their position.<br/>
	 * PInEx(7,3)= C(3,0)*7! -C(3,1)*6!+C(3,2)*5! -C(3,3)*4!
	 *
	 * @see Onto#scriptByToInEx(Condi, CharSequence)
	 */
	public static StringBuilder script(int n, int headKToEx, CharSequence lineWr) {

		if (n < 0 || headKToEx < 0 || n < headKToEx)

			O.x("n=" + n + ", headKToEx=" + headKToEx);

		StringBuilder ret = new StringBuilder(O.defLenForStr);

		for (int i = 0; i <= headKToEx; i++)

			if ((i & 0b1) == 0b0) // 0, 2, 4,...

				ret.append("C(").append(headKToEx).append(O.C44).append(i).append(")*").append(n - i).append("! ");

			else {

				ret.append("-C(").append(headKToEx).append(O.C44).append(i).append(")*").append(n - i).append(O.C33);

				if (i < headKToEx)

					ret.append(lineWr).append(O.C43);

			}

		return ret;

	}
}
