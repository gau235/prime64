package lgpl3.comb.filter;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

import lgpl3.o.B;

/**
 * StringBuilder 陣列比較器.<br/>
 * The comparator of StringBuilder[].
 *
 * @version 2022/01/29_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=CompaForStrAry" >CompaForStrAry.java</a>
 *
 */
public class CompaForStrAry implements Comparator<StringBuilder[]>, Serializable {

	private static final Class<?> THIS = CompaForStrAry.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * To compare.<br/>
	 * To compare.
	 */
	public static int compa(StringBuilder[] strAry1, StringBuilder[] strAry2) {

		// [toReplace1//toReplace1]

		return 0;

	}

	/**
	 * 內建的比較器.<br/>
	 * The Comparator inside.
	 */
	public static final CompaForStrAry COMPA = new CompaForStrAry();

	/**
	 * 內建的比較器 (反向).<br/>
	 * The Comparator inside.
	 */
	public static final Comparator<StringBuilder[]> REV_COMPA = Collections.reverseOrder(COMPA);

	@Override
	public int compare(StringBuilder[] strAry1, StringBuilder[] strAry2) {

		return compa(strAry1, strAry2);
	}
}