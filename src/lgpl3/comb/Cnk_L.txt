package lgpl3.comb;

import lgpl3.o.O;
import lgpl3.o.ary.Seq32;
import lgpl3.o.keyNV.KAry32V32;

/**
 * @version 2022/03/18_21:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Cnk_L" >Cnk_L.java</a>
 *
 * @see Cnk_V
 */
public abstract class Cnk_L extends Cnk_A {

	private static final Class<?> THIS = Cnk_L.class;

	/**
	 * 從 1 列全相異數列中取出 k 個數.<br/>
	 * To pick several numbers from a list of distinct numbers.
	 */
	public static void colRecur(final int boundBit, int rmdK, int prefix, int curBit, KAry32V32 retSeq32) {

		// O.y32++;

		if (--rmdK == 0) { // termination condition

			do
				retSeq32.ary32[retSeq32.int32++] = (curBit | prefix);

			while ((curBit <<= 1) != boundBit);

			return;

		}

		// if you pick 3 from [A,B,C,D] then at most you can start from B as [B,C,D] not [C,D,X]
		int newBoundBit = boundBit >>> rmdK;

		// O.l("rmdK=" + rmdK + ", newBoundBit=" + B32va.str16(newBoundBit), THIS);

		do
			colRecur(boundBit, rmdK, (curBit | prefix), (curBit <<= 1), retSeq32);

		while (curBit != newBoundBit); // while ((curBit << rmdK) <= boundBit);
		// while ((curBit << rmdK) < newBoundBit);

	}

	/**
	 * 從 1 列全相異數列中取出 k 個數.<br/>
	 * To pick several numbers from a list of distinct numbers.
	 */
	public static void colRecur(final int boundBit, int rmdK, int prefix, int curBit, Seq32 retSeq32) { // for other class to call

		// O.y32++;

		if (--rmdK == 0) { // termination condition

			do
				retSeq32.a(curBit | prefix);

			while ((curBit <<= 1) != boundBit);

			return;

		}

		// if you pick 3 from [A,B,C,D] then at most you can start from B as [B,C,D] not [C,D,X]
		int newBoundBit = boundBit >>> rmdK;

		// O.l("rmdK=" + rmdK + ", newBoundBit=" + B32va.str16(newBoundBit), THIS);

		do
			colRecur(boundBit, rmdK, (curBit | prefix), (curBit <<= 1), retSeq32);

		while (curBit != newBoundBit); // while ((curBit << rmdK) <= boundBit);
		// while ((curBit << rmdK) < newBoundBit);

	}

	/**
	 * 從 1 列全相異數列中取出 k 個數.<br/>
	 * To pick several numbers from a list of distinct numbers.
	 */
	public static int[] colRecur(int n, int k) {

		if (n > 30) // fuck see toStrToOntoBySAryByB32

			O.x("n=" + n);

		if (n == k)

			return new int[] { ~(-0b1 << n) };

		KAry32V32 retKAry32V32 = new KAry32V32(int64(n, k));

		colRecur(0b1 << n, k, 0b0, 0b1, retKAry32V32);

		// O.l(retKAry32V32.toStr(), THIS);

		return retKAry32V32.ary32;

	}
}
