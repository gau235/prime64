package lgpl3.o.keyNV;

import java.io.Serializable;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 本類別 int64 跟 int32 跟 int32<br/>
 * It is like an int64 which is attached to the int32.
 *
 * @version 2022/05/05_13:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=K64V32V32" >src</a>
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
public class K64V32V32 implements Comparable<K64V32V32>, Serializable {

	private static final Class<?> THIS = K64V32V32.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * The key.
	 */
	public final long k;

	/**
	 * The value 1.
	 */
	public int v1;

	/**
	 * The value 2.
	 */
	public int v2;

	/**
	 * Constructor.
	 */
	public K64V32V32(long int64, int int32A, int int32B) {

		k = int64;

		v1 = int32A;
		v2 = int32B;

	}

	/**
	 * To compare to other's key.
	 */
	@Override
	public int compareTo(K64V32V32 otherK64V32V32) {

		if (k > otherK64V32V32.k)

			return 1;

		if (k < otherK64V32V32.k)

			return -1;

		return 0;

	}

	/**
	 * To compare to other's key.
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj == null)

			return B.O;

		if (obj instanceof K64V32V32)

			return k == ((K64V32V32) obj).k;

		return B.O;

	}

	/**
	 * To StringBuilder.
	 */
	public StringBuilder toStr() {

		return new StringBuilder(O.defLenForStr).append(O.C40).append(k).append(O.C94).append(v1).append(O.C94).append(v2).

				append(O.C41);

	}
}
