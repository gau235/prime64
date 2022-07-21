package lgpl3.comb.filter;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * StringBuilder 比較器.<br/>
 * The comparator for StringBuilder.
 *
 * @version 2022/01/29_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=CompaForStr" >CompaForStr.java</a>
 *
 */
public class CompaForStr implements Comparator<StringBuilder>, Serializable {

	private static final long serialVersionUID = B.genId32(CompaForStr.class);

	/**
	 * compareTo 的方法名稱.<br/>
	 * The name of compareTo method.
	 */
	public static boolean isStrComparable() {

		try {
			StringBuilder.class.getMethod("compareTo", StringBuilder.class);

		} catch (NoSuchMethodException | SecurityException ex) { // ex.printStackTrace();

			return B.O;
		}

		return B.I;

	}

	/**
	 * compareTo 的方法名稱.<br/>
	 * The name of compareTo method.
	 */
	public static final boolean IS_COMPARABLE = isStrComparable();

	/**
	 * To compare.<br/>
	 * To compare.
	 */
	public static int compa(StringBuilder str1, StringBuilder str2) {

		int len1 = ((len1 = str1.length()) > O.defLenForStr) ? O.defLenForStr : len1;

		int len2 = ((len2 = str2.length()) > O.defLenForStr) ? O.defLenForStr : len2;

		int idx, v;

		char[] cAry1 = new char[len1], cAry2 = new char[len2];

		str1.getChars(0, len1, cAry1, 0);
		str2.getChars(0, len2, cAry2, 0);

		if (len1 > len2) {

			for (idx = 0; idx != len2; idx++)

				if ((v = (cAry1[idx] - cAry2[idx])) != 0)

					return v;

			return 1;

		}

		if (len1 < len2) {

			for (idx = 0; idx != len1; idx++)

				if ((v = (cAry1[idx] - cAry2[idx])) != 0)

					return v;

			return -1;

		}

		// len1 == len2
		for (idx = 0; idx != len1; idx++)

			if ((v = (cAry1[idx] - cAry2[idx])) != 0)

				return v;

		return 0;

	}

	/**
	 * 比較器, 用於表格直行的排序.<br/>
	 * The Comparator to sort by the column of table to record.
	 */
	public static final CompaForStr COMPA = new CompaForStr();

	/**
	 * 內建的比較器 (反向).<br/>
	 * The Comparator inside.
	 */
	public static final Comparator<StringBuilder> REV_COMPA = Collections.reverseOrder(COMPA);

	@Override
	public int compare(StringBuilder str1, StringBuilder str2) {

		return compa(str1, str2);
	}
}