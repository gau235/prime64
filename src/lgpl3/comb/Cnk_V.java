package lgpl3.comb;

import lgpl3.b32.B32va;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Seq32;

/**
 * @version 2022/05/22_10:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Cnk_V" >src</a>
 *
 * @see Cnk
 */
public abstract class Cnk_V extends Cnk_A {

	private static final Class<?> THIS = Cnk_V.class;

	/**
	 * 從 1 全相異數列中取出 k 個數.<br/>
	 * To pick several numbers from a list of distinct numbers.
	 *
	 * @see #colRecur(int, int)
	 */
	public static int[] colByLoopBreadthFirst(int n, int k) { // 如同廣先搜尋

		if (n <= 0 || k <= 0 || n < k || n > 30)

			O.x("n=" + n + ", k=" + k);

		if (n == k)

			return new int[] { ~(-0b1 << n) };

		int curBit = 0b1, boundBit = ((0b1 << (n - k)) << 1), idx, keptB32;

		// O.l("boundBit=" + B32va.strByLog2InB32BySAry(boundBit, O.S_ARY_A_Z), THIS);

		Seq32 seq32Sun = new Seq32(), seq32Moon = new Seq32(), seq32ToSwap; // 提升可閱讀性 但是浪費記憶體

		// init; for example: C(4,3) the base is [1~] [2~] [3~] [4~]
		do
			seq32Sun.a(curBit);

		while ((curBit <<= 1) != boundBit); // k - atK + atBase <= n

		if (--k == 0)

			return seq32Sun.trim().ary32; // 往下就不會執行

		do {
			idx = 0;
			n = seq32Sun.i;

			do {
				curBit = B32va.highest1(keptB32 = seq32Sun.ary32[idx]);

				do
					seq32Moon.a((curBit <<= 1) | keptB32);

				while (curBit != boundBit); // k - atK + atBase <= n

			} while (++idx != n); // termination condition

			if (--k == 0)

				return seq32Moon.trim().ary32; // 往下就不會執行 // 此方法回傳 desc 排序集合

			boundBit <<= 1; // important // O.l("boundBit=" + B32va.strByLog2InB32BySAry(boundBit, O.S_ARY_A_Z), THIS);

			// swap 重複使用 // 原創
			seq32ToSwap = seq32Sun;

			seq32Sun = seq32Moon;

			(seq32Moon = seq32ToSwap).i = 0;
			// end swap 重複使用

		} while (B.I); // termination condition

	}
}
