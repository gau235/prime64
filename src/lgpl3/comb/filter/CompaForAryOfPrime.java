package lgpl3.comb.filter;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

import lgpl3.o.B;

/**
 * 64 位元整數陣列比較器.<br/>
 * The comparator of long[].
 *
 * @version 2022/01/30_19:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=CompaForAryOfPrime" >CompaForAryOfPrime.java</a>
 *
 */
public class CompaForAryOfPrime implements Comparator<long[]>, Serializable {

	private static final Class<?> THIS = CompaForAryOfPrime.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * To compare.<br/>
	 * To compare.
	 */
	public static int compa(long[] ary1, long[] ary2) { // 逐一比對元素

		int len1 = ary1.length, len2 = ary2.length, idx;

		long n1, n2;

		if (len1 > len2) {

			for (idx = 0; idx != len2; idx++) {

				if ((n1 = ary1[idx]) > (n2 = ary2[idx]))
					return 1;

				if (n1 < n2)
					return -1;

			}

			return 1;

		}

		if (len1 < len2) {

			for (idx = 0; idx != len1; idx++) {

				if ((n1 = ary1[idx]) > (n2 = ary2[idx]))
					return 1;

				if (n1 < n2)
					return -1;

			}

			return -1;

		}

		// len1 == len2
		for (idx = 0; idx != len1; idx++) {

			if ((n1 = ary1[idx]) > (n2 = ary2[idx]))
				return 1;

			if (n1 < n2)
				return -1;

		}

		return 0;

	}

	/**
	 * 內建的比較器.<br/>
	 * The Comparator inside.
	 */
	public static final CompaForAryOfPrime COMPA = new CompaForAryOfPrime();

	/**
	 * 內建的比較器 (反向).<br/>
	 * The Comparator inside.
	 */
	public static final Comparator<long[]> REV_COMPA = Collections.reverseOrder(COMPA);

	@Override
	public int compare(long[] ary1, long[] ary2) {

		int len1 = ary1.length, len2 = ary2.length, idx;

		long n1, n2;

		if (len1 > len2) {

			for (idx = 0; idx != len2; idx++) {

				if ((n1 = ary1[idx]) > (n2 = ary2[idx]))
					return 1;

				if (n1 < n2)
					return -1;

			}

			return 1;

		}

		if (len1 < len2) {

			for (idx = 0; idx != len1; idx++) {

				if ((n1 = ary1[idx]) > (n2 = ary2[idx]))
					return 1;

				if (n1 < n2)
					return -1;

			}

			return -1;

		}

		// len1 == len2
		for (idx = 0; idx != len1; idx++) {

			if ((n1 = ary1[idx]) > (n2 = ary2[idx]))
				return 1;

			if (n1 < n2)
				return -1;

		}

		return 0;

	}
}