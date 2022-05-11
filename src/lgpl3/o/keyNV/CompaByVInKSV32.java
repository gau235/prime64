package lgpl3.o.keyNV;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

import lgpl3.o.B;

/**
 * KSV32 比較器.<br/>
 * The comparator for KSV32.
 *
 * @version 2020/02/18_17:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=CompaByVInKSV32" >CompaByVInKSV32.java</a>
 *
 */
public class CompaByVInKSV32 implements Comparator<KSV32>, Serializable {

	private static final Class<?> THIS = CompaByVInKSV32.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * 內建的比較器.<br/>
	 * The Comparator inside.
	 */
	public static final CompaByVInKSV32 COMPA = new CompaByVInKSV32();

	/**
	 * 內建的比較器 (反向).<br/>
	 * The Comparator inside.
	 */
	public static final Comparator<KSV32> REV_COMPA = Collections.reverseOrder(COMPA);

	@Override
	public int compare(KSV32 kSV32, KSV32 otherKSV32) {

		if (kSV32.int32 > otherKSV32.int32)
			return 1;

		if (kSV32.int32 < otherKSV32.int32)
			return -1;

		return 0;

	}
}