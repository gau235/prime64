package lgpl3.comb.filter;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

import lgpl3.o.B;

/**
 * String 陣列比較器.<br/>
 * The comparator of String[].
 *
 * @version 2022/01/29_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=CompaForSAryWEmpty" >CompaForSAryWEmpty.java</a>
 *
 */
public class CompaForSAryWEmpty implements Comparator<String[]>, Serializable {

	private static final Class<?> THIS = CompaForSAryWEmpty.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * To compare.<br/>
	 * To compare.
	 */
	public static int compa(String[] sAry1, String[] sAry2) {

		int len1 = sAry1.length;
		if ((len1 -= sAry2.length) != 0)
			return len1;

		// len1 == len2
		len1 = sAry1.length;

		String s1, s2;

		for (int idx = 0, v; idx != len1; idx++) {

			// O.l("smallLen1=" + smallLen1 + " smallLen2=" + smallLen2, THIS);

			if ((v = ((s2 = sAry2[idx]).length() - (s1 = sAry1[idx]).length())) != 0) // important
				return v;

			if ((v = s1.compareTo(s2)) != 0)
				return v;

		}

		return 0;

	}

	/**
	 * 內建的比較器.<br/>
	 * The Comparator inside.
	 */
	public static final CompaForSAryWEmpty COMPA = new CompaForSAryWEmpty();

	/**
	 * 內建的比較器 (反向).<br/>
	 * The Comparator inside.
	 */
	public static final Comparator<String[]> REV_COMPA = Collections.reverseOrder(COMPA);

	@Override
	public int compare(String[] sAry1, String[] sAry2) {

		int len1 = sAry1.length;
		if ((len1 -= sAry2.length) != 0)
			return len1;

		// len1 == len2
		len1 = sAry1.length;

		String s1, s2;

		for (int idx = 0, v; idx != len1; idx++) {

			// O.l("smallLen1=" + smallLen1 + " smallLen2=" + smallLen2, THIS);

			if ((v = ((s2 = sAry2[idx]).length() - (s1 = sAry1[idx]).length())) != 0) // important
				return v;

			if ((v = s1.compareTo(s2)) != 0)
				return v;

		}

		return 0;

	}
}