package lgpl3.comb;

/**
 * 環狀排列且全錯排.<br/>
 * Derangement and circular permutation.
 *
 * @version 2020/03/30_07:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=DCirc_A" >DCirc_A.java</a>
 *
 * @see DCirc
 */
public abstract class DCirc_A {

	// private static final Class<?> THIS = DCirc_A.class;

	/**
	 * 回傳 Dnk as circ.<br/>
	 * Dnk as circ.
	 */
	public static long int64(int n) {

		// if (n < 0) O.x("n=" + n);

		if ((n & 0b1) == 0b0)
			return PCirc.int64(n);

		if (n == 1)
			return 0L;

		if (n == 3)
			return 1L;

		if (n == 5)
			return 21L;

		if (n == 7)
			return 701L;

		if (n == 9)
			return 40_095L;

		if (n == 11)
			return 3_625_359L;

		if (n == 13)
			return 478_922_341L;

		if (n == 15)
			return 87_175_867_005L; // costT=6300 sec

		if (n == 17)
			return 20_922_695_416_911L;

		if (n == 19)
			return 6_402_369_092_207_111L;

		if (n == 21)
			return 2_432_901_733_027_986_885L;

		// https://oeis.org/A003111/b003111.txt
		// # A003111 (b-file synthesized from sequence entry)
		// 0: 1
		// 1: 1
		// 2: 3
		// 3: 19
		// 4: 225
		// 5: 3441
		// 6: 79259
		// 7: 2424195
		// 8: 94471089
		// 9: 4613520889
		// 10: 275148653115
		// 11: 19686730313955
		// 12: 1664382756757625

		throw new IllegalArgumentException("n=" + n);

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
}
