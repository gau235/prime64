package lgpl3.comb.filter;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 本類別比較器, 用於表格直行的排序.<br/>
 * The Comparator to sort by the column of table for record.
 *
 * @version 2022/01/31_12:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=CompaForCharSeqAsF32" >
 *          CompaForCharSeqAsF32.java</a>
 *
 */
public class CompaForCharSeqAsF32 implements Comparator<CharSequence>, Serializable {

	private static final long serialVersionUID = B.genId32(CompaForCharSeqAsF32.class);

	/**
	 * To compare.<br/>
	 * To compare.
	 */
	public int compa(CharSequence charSeqA, CharSequence charSeqB) { // todo: bad performance

		float f32A = Float.parseFloat(charSeqA.toString().replace(O.S44, O.Z)); // like 1,874.123
		float f32B = Float.parseFloat(charSeqB.toString().replace(O.S44, O.Z));

		if (f32A > f32B)
			return 1;

		if (f32A < f32B)
			return -1;

		return 0;

	}

	/**
	 * 比較器, 用於表格直行的排序.<br/>
	 * The Comparator to sort by the column of table to record.
	 */
	public static final CompaForCharSeqAsF32 COMPA = new CompaForCharSeqAsF32();

	/**
	 * 內建的比較器 (反向).<br/>
	 * The Comparator inside.
	 */
	public static final Comparator<CharSequence> REV_COMPA = Collections.reverseOrder(COMPA);

	@Override
	public int compare(CharSequence charSeqA, CharSequence charSeqB) { // todo: bad performance

		float f32A = Float.parseFloat(charSeqA.toString().replace(O.S44, O.Z)); // like 1,874.123
		float f32B = Float.parseFloat(charSeqB.toString().replace(O.S44, O.Z));

		if (f32A > f32B)
			return 1;

		if (f32A < f32B)
			return -1;

		return 0;

	}
}
