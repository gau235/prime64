package lgpl3.o.keyNV;

import java.io.Serializable;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 本類別 int32 與 int64.<br/>
 * It is like an int32 which is attached to the int64int32.
 *
 * @version 2021/01/05_13:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=K32V64" >K32V64.java</a>
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
public class K32V64 implements Comparable<K32V64>, Serializable {

	private static final Class<?> THIS = K32V64.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * The int.<br/>
	 * The int.
	 */
	public final int k;

	/**
	 * The int.<br/>
	 * The int.
	 */
	public long v;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public K32V64(int int32, long int64) {

		k = int32;
		v = int64;

	}

	/**
	 * 比較彼此的 32 位元整數的大小.<br/>
	 * To compare to other's at0().
	 */
	@Override
	public int compareTo(K32V64 otherK32V64) {

		return (k - otherK32V64.k);
	}

	/**
	 * 比較彼此的 32 位元整數的大小.<br/>
	 * To compare to other's at0().
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj == null)

			return B.O;

		if (obj instanceof K32V64)

			return k == ((K32V64) obj).k;

		return B.O;

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public StringBuilder toStr() {

		return new StringBuilder(O.defLenForStr).append(O.C40).append(k).append(O.C94).append(v).append(O.C41);
	}
}
