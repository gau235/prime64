package lgpl3.o.keyNV;

import java.io.Serializable;

import lgpl3.comb.filter.CompaForAry;
import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 本類別 32 位元整數與泛型物件, 其內第 0 位置是 32 位元整數, 第 1 位置是泛型物件.<br/>
 * Something like a long which is attached to the generic type object.
 *
 * @version 2022/04/07_13:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=KAryV32" >KAryV32.java</a>
 *
 * @see K64V32
 *
 * @see K64V32V32
 *
 * @see K64V
 *
 * @see K32V64
 *
 * @see K32VSeq
 *
 * @see K32V
 *
 * @see KSV32
 */
public class KAryV32 implements Comparable<KAryV32>, Serializable {

	private static final Class<?> THIS = KAryV32.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * 本可比較介面與泛型物件中的泛型物件 ( 第 1 位置 ).<br/>
	 * The generic type object(the 1-th position) of this.
	 */
	public final long[] ary;

	/**
	 * 本可比較介面與泛型物件中的可比較介面 ( 第 0 位置 ).<br/>
	 * The Comparable(the 0-th position) of this.
	 */
	public int int32;

	/**
	 * 建構方法, 生成物件的 64 位元整數是 at0, 第 1 位置的泛型物件 at1.<br/>
	 * Constructor; the K64V object's int64 is at0 and the generic type object is at1.
	 */
	public KAryV32(long[] ary, int int32) {

		this.ary = ary;
		this.int32 = int32;

	}

	/**
	 * 建構方法, 生成物件的 64 位元整數是 at0, 第 1 位置的泛型物件 at1.<br/>
	 * Constructor; the K64V object's int64 is at0 and the generic type object is at1.
	 */
	public KAryV32(long ansAsLen) {

		this.ary = new long[(int) ansAsLen];
		this.int32 = 0;

	}

	/**
	 * 比較彼此的 32 位元整數的大小.<br/>
	 * To compare to other's at0().
	 */
	@Override
	public int compareTo(KAryV32 otherKAryV32) {

		return CompaForAry.compa(ary, otherKAryV32.ary);
	}

	/**
	 * 比較彼此的 64 位元整數的大小.<br/>
	 * To compare to other's at0().
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj == null)

			return B.O;

		if (obj instanceof KAryV32)

			return CompaForAry.compa(ary, ((KAryV32) obj).ary) == 0;

		return B.O;

	}

	/**
	 * 加入.<br/>
	 * To append.
	 */
	public KAryV32 a(long num) {

		ary[int32++] = num;

		return this;

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public StringBuilder toStr() {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		retStr.append("([");

		for (int idx = 0, len = ary.length; idx != len;) {

			retStr.append(ary[idx]);

			if (++idx == len)

				break;
			else
				retStr.append(O.STR_C44C32);

		}

		return retStr.append("]^").append(int32).append(O.C41);

	}
}
