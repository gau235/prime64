package lgpl3.comb;

import java.math.BigInteger;

/**
 * To derange.<br/>
 * Derangement.
 *
 * @version 2021/05/22_11:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Dnk_A" >Dnk_A.java</a>
 *
 * @see Dnk_J
 */
public abstract class Dnk_A {

	// private static final Class<?> THIS = Dnk_A.class;

	/**
	 * 在一個已完成的錯排隊伍 (全錯排) 中, 若 n 坐了第 k 位:<br/>
	 * 情況 1: 假設 k 去坐第 n 位時, 除了 n 和 k 以外還有 n-2 人, 其錯排數為 D(n-2)<br/>
	 *
	 * 情況 2: 假設 k 不坐在第 n 位 (強假設), 可把第 n 位當成一個另類的 "第 k 位" (k 的忌諱)<br/>
	 * 這時包括 k 在內的剩下 n-1 人形成的每一種錯排,<br/>
	 * 都等價於 n-1 人隊伍的錯排 (只是其中 k 這人的忌諱已變成第 n 位)<br/>
	 *
	 * 尼古拉一世·伯努利: Dn=(n-1)*(Dn-1+Dn-2)
	 */
	public static long int64(int n) {

		// if (n < 0) O.x("n=" + n);

		// if (n == 0) return 1L;

		if (n == 1)

			return 0L;

		if (n == 2)

			return 1L;

		if (n == 3)

			return 2L;

		if (n == 4)

			return 9L;

		if (n == 5)

			return 44L;

		if (n == 6)

			return 265L;

		if (n == 7)

			return 1_854L;

		if (n == 8)

			return 14_833L;

		if (n == 9)

			return 133_496L;

		if (n == 10)

			return 1_334_961L;

		if (n == 11)

			return 14_684_570L;

		if (n == 12)

			return 176_214_841L;

		if (n == 13)

			return 2_290_792_932L;

		if (n == 14)

			return 32_071_101_049L;

		if (n == 15)

			return 481_066_515_734L;

		if (n == 16)

			return 7_697_064_251_745L;

		if (n == 17)

			return 130_850_092_279_664L;

		if (n == 18)

			return 2_355_301_661_033_953L;

		if (n == 19)

			return 44_750_731_559_645_106L;

		if (n == 20)

			return 895_014_631_192_902_121L;

		throw new IllegalArgumentException("n=" + n);

	}

	/**
	 * 在一個已完成的錯排隊伍 (全錯排) 中, 若 n 坐了第 k 位:<br/>
	 * 情況 1: 假設 k 去坐第 n 位時, 除了 n 和 k 以外還有 n-2 人, 其錯排數為 D(n-2)<br/>
	 *
	 * 情況 2: 假設 k 不坐在第 n 位 (強假設), 可把第 n 位當成一個另類的 "第 k 位" (k 的忌諱)<br/>
	 * 這時包括 k 在內的剩下 n-1 人形成的每一種錯排,<br/>
	 * 都等價於 n-1 人隊伍的錯排 (只是其中 k 這人的忌諱已變成第 n 位)<br/>
	 *
	 * 尼古拉一世·伯努利: Dn=(n-1)*(Dn-1+Dn-2)
	 */
	public static BigInteger bigInt(int n) { // recur

		// if (n <= 0) O.x("n=" + n);

		if (n == 0)

			return BigInteger.ONE;

		if (n == 1)

			return BigInteger.ZERO;

		BigInteger ans, tmpAns = BigInteger.ZERO;

		int i = 2;
		do
			tmpAns = ans = ((i & 0b1) == 0b0) ? tmpAns.multiply(BigInteger.valueOf(i)).add(BigInteger.ONE)

					: tmpAns.multiply(BigInteger.valueOf(i)).subtract(BigInteger.ONE); // 連用 2 個等號

		while (i++ != n);

		return ans;

	}

	/**
	 * 回傳亂序數.<br/>
	 * 即 n 個人排成一列後解散再排成一列, 沒有人排在自己原先的位置的方法數.<br/>
	 * D(n,k)=C(n,k)*D(k)<br/>
	 * To return the number of ways that n people line up then dismiss, and<br/>
	 * line up again but nobody is at the previous position.
	 */
	public static long int64(int n, int k) {

		return Cnk.int64(n, k) * int64(k);
	}

	/**
	 * 回傳亂序數.<br/>
	 * 即 n 個人排成一列後解散再排成一列, 沒有人排在自己原先的位置的方法數.<br/>
	 * D(n,k)=C(n,k)*D(k)<br/>
	 * To return the number of ways that n people line up then dismiss, and<br/>
	 * line up again but nobody is at the previous position.
	 */
	public static BigInteger bigInt(int n, int k) {

		return Cnk.bigInt(n, k).multiply(bigInt(k));
	}
}
