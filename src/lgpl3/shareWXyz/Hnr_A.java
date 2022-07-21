package lgpl3.shareWXyz;

import lgpl3.comb.Cnk;

/**
 * 即 n 個相同物品分成給 k 人, 每人最少 1 個.<br/>
 * To return the number of ways to share several identical items with every person.
 *
 * @version 2020/02/23_21:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Hnr_A" >Hnr_A.java</a>
 *
 * @see Hnr_U
 */
public abstract class Hnr_A {

	// private static final Class<?> THIS = Hnr_A.class;

	/**
	 * H(n,r) = C(n+r-1,r)<br/>
	 * H(n,r) while at least everyone gets 1 = C(r-1,n-1) // r gte n
	 */
	public static long int64(int numOfXyz, int total32) {

		return Cnk.int64(numOfXyz + total32 - 1, total32);
	}

	/**
	 * H(n,r) = C(n+r-1,r)<br/>
	 * H(n,r) at least 1 = C(r-1,n-1) // r gte n
	 */
	public static long hAtLeast1(int numOfXyz, int total32) {

		return Cnk.int64(total32 - 1, numOfXyz - 1);
	}
}
