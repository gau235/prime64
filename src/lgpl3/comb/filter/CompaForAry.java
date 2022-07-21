package lgpl3.comb.filter;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

import lgpl3.o.B;

/**
 * 64 位元整數陣列比較器.<br/>
 * The comparator of long[].
 *
 * @version 2022/04/29_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=CompaForAry" >CompaForAry.java</a>
 *
 */
public class CompaForAry implements Comparator<long[]>, Serializable {

	private static final Class<?> THIS = CompaForAry.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * To compare.<br/>
	 * To compare.
	 */
	public static int compa(long[] aryA, long[] aryB) { // 比長度, 之後再逐一比對元素

		int lenA = aryA.length;

		if ((lenA -= aryB.length) != 0)

			return lenA;

		// lenA == lenB
		lenA = aryA.length;

		long vA;
		for (int idx = 0; idx != lenA; idx++) {

			if ((vA = (aryA[idx] - aryB[idx])) > 0L)

				return 1;

			if (vA < 0L)

				return -1;

		}

		return 0;

	}

	/**
	 * 內建的比較器.<br/>
	 * The Comparator inside.
	 */
	public static final CompaForAry COMPA = new CompaForAry();

	/**
	 * 內建的比較器 (反向).<br/>
	 * The Comparator inside.
	 */
	public static final Comparator<long[]> REV_COMPA = Collections.reverseOrder(COMPA);

	@Override
	public int compare(long[] aryA, long[] aryB) {

		return compa(aryA, aryB);
	}
}