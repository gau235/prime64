package lgpl3.comb.onto;

import lgpl3.b32.B32va;
import lgpl3.comb.filter.Condi;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Ary32_2D;

/**
 * Onto freely.<br/>
 * Onto freely.
 *
 * @version 2020/02/10_22:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=OntoWMin0_A" >OntoWMin0_A.java</a>
 *
 * @see OntoWMin0
 */
public abstract class OntoWMin0_A extends Onto_Z {

	private static final Class<?> THIS = OntoWMin0_A.class;

	/**
	 * To put n people in k rooms.<br/>
	 * To put n people in k rooms.
	 */
	public static void colByLoop(int curB32As2Pow, int[] ary32AsAllRoom, final int max, Ary32_2D ary32_2D) {

		int idx = 0, lenMinus1 = (ary32AsAllRoom.length - 1), keptB32;
		int[] clonedAry32;

		do
			if (idx != lenMinus1) {

				if (B32va.countOf1(keptB32 = ary32AsAllRoom[idx]) < max) {

					(clonedAry32 = ary32AsAllRoom.clone())[idx] = (keptB32 | curB32As2Pow);
					ary32_2D.a(clonedAry32);

				}

				idx++;

			} else { // 老師影印考卷 正本留最後用

				if (B32va.countOf1(keptB32 = ary32AsAllRoom[idx]) < max) {

					ary32AsAllRoom[idx] = (keptB32 | curB32As2Pow);
					ary32_2D.a(ary32AsAllRoom);

				}

				return;

			}

		while (B.I);

	}

	/**
	 * To put n people in k rooms.<br/>
	 * To put n people in k rooms.
	 */
	public static Ary32_2D colByLoop(Condi condi) {

		O.l("n, k, min, max=" + condi.n + ", " + condi.k + ", " + condi.min + ", " + condi.max, THIS);

		if (condi.min != 0)
			throw new IllegalArgumentException();

		Ary32_2D retAry32_2D = new Ary32_2D();
		retAry32_2D.a(new int[condi.k]); // init

		Ary32_2D tmpAry32_2D;

		final int maxB32As2Pow = 0b1 << (condi.n - 1);
		int curB32As2Pow = 0b1;

		int[][] aryOfAry32;

		int idx;
		for (; curB32As2Pow <= maxB32As2Pow; curB32As2Pow <<= 1) {

			aryOfAry32 = retAry32_2D.arr;
			tmpAry32_2D = new Ary32_2D();

			for (idx = 0; idx != retAry32_2D.i; idx++)
				colByLoop(curB32As2Pow, aryOfAry32[idx], condi.max, tmpAry32_2D);

			retAry32_2D = tmpAry32_2D;

		}

		return retAry32_2D;

	}
}
