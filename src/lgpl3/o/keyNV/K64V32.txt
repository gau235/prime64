package lgpl3.o.keyNV;

import java.io.Serializable;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 本類別 int64 與 int32.<br/>
 * It is like an int64 which is attached to the int32.
 *
 * @version 2021/01/05_13:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=K64V32" >K64V32.java</a>
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
public class K64V32 implements Comparable<K64V32>, Serializable {

	private static final Class<?> THIS = K64V32.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * The int.<br/>
	 * The int.
	 */
	public final long int64;

	/**
	 * The int.<br/>
	 * The int.
	 */
	public int int32;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public K64V32(long int64, int int32) {

		this.int64 = int64;
		this.int32 = int32;

	}

	/**
	 * 比較彼此的 32 位元整數的大小.<br/>
	 * To compare to other's at0().
	 */
	@Override
	public int compareTo(K64V32 otherK64V32) {

		if (this.int64 > otherK64V32.int64)
			return 1;

		if (this.int64 < otherK64V32.int64)
			return -1;

		return 0;

	}

	/**
	 * 比較彼此的 32 位元整數的大小.<br/>
	 * To compare to other's at0().
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj == null)

			return B.O;

		if (obj instanceof K64V32)

			return int64 == ((K64V32) obj).int64;

		return B.O;

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public StringBuilder toStr() {

		return new StringBuilder(O.DEF_CAPACITY32_FOR_STR).append(O.C40).append(int64).append(O.C94).append(int32).append(O.C41);
	}
}
