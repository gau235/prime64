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
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=KAry32V32" >KAry32V32.java</a>
 *
 * @see K32V
 *
 * @see K32V64
 *
 * @see K32VAry32_2D
 *
 * @see K32VSeq
 *
 * @see K64V
 *
 * @see K64V32
 *
 * @see K64V32V32
 *
 * @see KAry32V32
 *
 * @see KAryV32
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
	public final int[] k;

	/**
	 * 本可比較介面與泛型物件中的可比較介面 ( 第 0 位置 ).<br/>
	 * The Comparable(the 0-th position) of this.
	 */
	public int v;

	/**
	 * 建構方法, 生成物件的 64 位元整數是 at0, 第 1 位置的泛型物件 at1.<br/>
	 * Constructor; the K64V object's int64 is at0 and the generic type object is at1.
	 */
	public KAry32V32(int[] ary32, int int32) {

		k = ary32;
		v = int32;

	}

	/**
	 * 建構方法, 生成物件的 64 位元整數是 at0, 第 1 位置的泛型物件 at1.<br/>
	 * Constructor; the K64V object's int64 is at0 and the generic type object is at1.
	 */
	public KAry32V32(long ansAsLen) {

		k = new int[(int) ansAsLen];
	}

	/**
	 * 比較彼此的 32 位元整數的大小.<br/>
	 * To compare to other's at0().
	 */
	@Override
	public int compareTo(KAry32V32 otherKAry32V32) {

		return CompaForAry32.compa(k, otherKAry32V32.k);
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

			return CompaForAry32.compa(k, ((KAry32V32) obj).k) == 0;

		return B.O;

	}

	/**
	 * 加入.<br/>
	 * To append.
	 */
	public KAry32V32 a(int num32) {

		k[v++] = num32;

		return this;

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public StringBuilder toStr() {

		StringBuilder ret = new StringBuilder(O.defLenForStr);

		ret.append("([");

		for (int idx = 0, len = k.length; idx != len;) {

			ret.append(k[idx]);

			if (++idx == len)

				break;
			else
				ret.append(O.STR_C44C32);

		}

		return ret.append("]^").append(v).append(O.C41);

	}
}
