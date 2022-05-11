package lgpl3.comb.filter;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.B;

/**
 * B64W6 陣列比較器.<br/>
 * The comparator of long[] of B64W6.
 *
 * @version 2022/01/31_12:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=CompaForAryOfB64W6" >CompaForAryOfB64W6.java</a>
 *
 * @see CompaForAry32OfB32As2Pow
 */
public class CompaForAryOfB64W6 implements Comparator<long[]>, Serializable {

	private static final long serialVersionUID = B.genId32(CompaForAryOfB64W6.class);

	/**
	 * To compare.<br/>
	 * To compare.
	 */
	public static int compa(long[] aryA, long[] aryB) {

		int lenA = aryA.length;
		if ((lenA -= aryB.length) != 0)
			return lenA;

		// lenA == lenB
		lenA = aryA.length;

		int idx, vA, vB;

		for (idx = 0; idx != lenA; idx++) // O.l("strA=" + B64W6.toStrByVCell(aryA[idx]), THIS);

			if ((vA = (B64W6.totalVCell(aryA[idx]) - B64W6.totalVCell(aryB[idx]))) != 0)

				return vA;

		// every totalA == every totalB
		// compare every cell

		long sortedB64A, sortedB64B;
		for (idx = 0; idx != lenA; idx++) {

			// sortedB64A = B64W6.bubbleSortDesc(sortedB64A);
			sortedB64A = B64W6.revAmongVCell(aryA[idx]);
			sortedB64B = B64W6.revAmongVCell(aryB[idx]);

			// O.l("strA=" + B64W6.toStrByVCell(sortedB64A), THIS);

			do {
				vA = ((int) sortedB64A) & B64W6.MASK32;
				vB = ((int) sortedB64B) & B64W6.MASK32;

				if ((vA -= vB) != 0)

					return vA;

				sortedB64A >>>= B64W6.$6;

			} while (((int) (sortedB64B >>>= B64W6.$6)) != 0b0);
		}

		return 0;

	}

	/**
	 * 內建的比較器.<br/>
	 * The Comparator inside.
	 */
	public static final CompaForAryOfB64W6 COMPA = new CompaForAryOfB64W6();

	/**
	 * 內建的比較器 (反向).<br/>
	 * The Comparator inside.
	 */
	public static final Comparator<long[]> REV_COMPA = Collections.reverseOrder(COMPA);

	@Override
	public int compare(long[] ary1, long[] ary2) {

		return compa(ary1, ary2);
	}
}