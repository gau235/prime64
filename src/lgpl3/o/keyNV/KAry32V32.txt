package lgpl3.o.keyNV;

import java.io.Serializable;

import lgpl3.comb.filter.CompaForAry32;
import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 本類別 32 位元整數與泛型物件, 其內第 0 位置是 32 位元整數, 第 1 位置是泛型物件.<br/>
 * Something like a long which is attached to the generic type object.
 *
 * @version 2022/02/14_11:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=KAry32V32" >KAry32V32.java</a>
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
public class KAry32V32 implements Comparable<KAry32V32>, Serializable {

	private static final Class<?> THIS = KAry32V32.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * 本可比較介面與泛型物件中的泛型物件 ( 第 1 位置 ).<br/>
	 * The generic type object(the 1-th position) of this.
	 */
	public final int[] ary32;

	/**
	 * 本可比較介面與泛型物件中的可比較介面 ( 第 0 位置 ).<br/>
	 * The Comparable(the 0-th position) of this.
	 */
	public int int32;

	/**
	 * 建構方法, 生成物件的 64 位元整數是 at0, 第 1 位置的泛型物件 at1.<br/>
	 * Constructor; the K64V object's int64 is at0 and the generic type object is at1.
	 */
	public KAry32V32(int[] ary32, int int32) {

		this.ary32 = ary32;
		this.int32 = int32;

	}

	/**
	 * 建構方法, 生成物件的 64 位元整數是 at0, 第 1 位置的泛型物件 at1.<br/>
	 * Constructor; the K64V object's int64 is at0 and the generic type object is at1.
	 */
	public KAry32V32(long ansAsLen) {

		this.ary32 = new int[(int) ansAsLen];
		this.int32 = 0;

	}

	/**
	 * 比較彼此的 32 位元整數的大小.<br/>
	 * To compare to other's at0().
	 */
	@Override
	public int compareTo(KAry32V32 otherKAry32V32) {

		return CompaForAry32.compa(ary32, otherKAry32V32.ary32);
	}

	/**
	 * 比較彼此的 64 位元整數的大小.<br/>
	 * To compare to other's at0().
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj == null)

			return B.O;

		if (obj instanceof KAry32V32)

			return CompaForAry32.compa(ary32, ((KAry32V32) obj).ary32) == 0;

		return B.O;

	}

	/**
	 * 加入.<br/>
	 * To append.
	 */
	public KAry32V32 a(int num32) {

		ary32[int32++] = num32;

		return this;

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public StringBuilder toStr() {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		retStr.append("([");

		for (int idx = 0, len = ary32.length; idx != len;) {

			retStr.append(ary32[idx]);

			if (++idx == len)

				break;
			else
				retStr.append(O.STR_C44C32);

		}

		return retStr.append("]^").append(int32).append(O.C41);

	}
}
