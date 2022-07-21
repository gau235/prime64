package lgpl3.comb.filter;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

import lgpl3.o.B;

/**
 * 32 位元整數陣列比較器.<br/>
 * The comparator of int[].
 *
 * @version 2022/01/29_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=CompaForAry32" >CompaForAry32.java</a>
 *
 */
public class CompaForAry32 implements Comparator<int[]>, Serializable {

	private static final Class<?> THIS = CompaForAry32.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * To compare.<br/>
	 * To compare.
	 */
	public static int compa(int[] ary32A, int[] ary32B) { // 比長度, 之後再逐一比對元素

		int lenA = ary32A.length;

		if ((lenA -= ary32B.length) != 0)

			return lenA;

		// lenA == lenB
		lenA = ary32A.length;

		for (int idx = 0, v; idx != lenA; idx++)

			if ((v = (ary32A[idx] - ary32B[idx])) != 0)

				return v;

		return 0;

	}

	/**
	 * 內建的比較器.<br/>
	 * The Comparator inside.
	 */
	public static final CompaForAry32 COMPA = new CompaForAry32();

	/**
	 * 內建的比較器 (反向).<br/>
	 * The Comparator inside.
	 */
	public static final Comparator<int[]> REV_COMPA = Collections.reverseOrder(COMPA);

	@Override
	public int compare(int[] ary32A, int[] ary32B) {

		return compa(ary32A, ary32B);
	}
}