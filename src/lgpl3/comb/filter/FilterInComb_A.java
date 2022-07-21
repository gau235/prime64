package lgpl3.comb.filter;

import lgpl3.b32.B32va;
import lgpl3.o.B;

/**
 * To filter.<br/>
 * To filter.
 *
 * @version 2022/01/29_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=FilterInComb_A" >FilterInComb_A.java</a>
 *
 * @see FilterInComb
 */
public abstract class FilterInComb_A {

	// private static final Class<?> THIS = FilterInComb_A.class;

	/**
	 * To check if int32 all between min and max (both inclusive).<br/>
	 * To check if int32 all between min and max (both inclusive).
	 */
	public static boolean ifEveryBitCountInAry32Between(int[] ary32, int min, int max) {

		for (int idx = 0, bitCount; idx != ary32.length; idx++)

			if ((bitCount = B32va.countOf1(ary32[idx])) < min || bitCount > max) // O.l("bitCount=" + bitCount, THIS);
				return B.O;

		return B.I;

	}
}