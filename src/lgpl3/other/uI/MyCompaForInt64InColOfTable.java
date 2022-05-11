package lgpl3.other.uI;

import java.util.Collections;
import java.util.Comparator;

import lgpl3.comb.filter.CompaForCharSeqAsF32;
import lgpl3.o.O;

/**
 * 本類別比較器, 用於表格直行的排序.<br/>
 * The Comparator to sort by the column of table for record.
 *
 * @version 2019/03/14_14:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=MyCompaForInt64InColOfTable" >
 *          MyCompaForInt64InColOfTable.java</a>
 *
 * @see MyCompaForInt64InColOfTable
 *
 * @see CompaForCharSeqAsF32
 */
public class MyCompaForInt64InColOfTable implements Comparator<CharSequence> {

	// private static final Class<?> THIS = MyCompaForInt64InColOfTable.class;

	/**
	 * 比較器, 用於表格直行的排序.<br/>
	 * The Comparator to sort by the column of table to record.
	 */
	public static final MyCompaForInt64InColOfTable COMPA = new MyCompaForInt64InColOfTable();

	/**
	 * 內建的比較器 (反向).<br/>
	 * The Comparator inside.
	 */
	public static final Comparator<CharSequence> REV_COMPA = Collections.reverseOrder(COMPA);

	@Override
	public final int compare(CharSequence charSeq1, CharSequence charSeq2) {

		long int64_1 = Long.parseLong(charSeq1.toString().replace(O.S44, O.Z), 10); // like 1,874
		long int64_2 = Long.parseLong(charSeq2.toString().replace(O.S44, O.Z), 10);

		if (int64_1 > int64_2)
			return 1;

		if (int64_1 < int64_2)
			return -1;

		return 0;

	}
}
