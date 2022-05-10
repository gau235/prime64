package lgpl3.comb.filter;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

import lgpl3.o.B;

/**
 * char 陣列比較器.<br/>
 * The comparator of char[].
 *
 * @version 2021/12/02_21:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=CompaForCharAry" >CompaForCharAry.java</a>
 *
 */
public class CompaForCharAry implements Comparator<char[]>, Serializable {

	private static final Class<?> THIS = CompaForCharAry.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * To compare.<br/>
	 * To compare.
	 */
	public static int compa(char[] cAry1, char[] cAry2) {

		int len1 = cAry1.length;
		if ((len1 -= cAry2.length) != 0)
			return len1;

		// len1 == len2
		len1 = cAry1.length;

		for (int idx = 0, v; idx != len1; idx++)
			if ((v = (cAry1[idx] - cAry2[idx])) != 0)
				return v;

		return 0;

	}

	/**
	 * 內建的比較器.<br/>
	 * The Comparator inside.
	 */
	public static final CompaForCharAry COMPA = new CompaForCharAry();

	/**
	 * 內建的比較器 (反向).<br/>
	 * The Comparator inside.
	 */
	public static final Comparator<char[]> REV_COMPA = Collections.reverseOrder(COMPA);

	@Override
	public int compare(char[] cAry1, char[] cAry2) {

		int len1 = cAry1.length;
		if ((len1 -= cAry2.length) != 0)
			return len1;

		// len1 == len2
		len1 = cAry1.length;

		for (int idx = 0, v; idx != len1; idx++)
			if ((v = (cAry1[idx] - cAry2[idx])) != 0)
				return v;

		return 0;

	}
}