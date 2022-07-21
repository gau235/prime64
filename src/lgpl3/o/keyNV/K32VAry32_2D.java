package lgpl3.o.keyNV;

import java.io.Serializable;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Ary32_2D;

/**
 * 本類別 int32 與 Ary32_2D.<br/>
 * It is like an Ary32_2D which is attached to the integer.
 *
 * @version 2022/05/02_17:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=K32VAry32_2D" >src</a>
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
public class K32VAry32_2D implements Comparable<K32VAry32_2D>, Serializable {

	private static final Class<?> THIS = K32VAry32_2D.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * The key.
	 */
	public final int k;

	/**
	 * The value.
	 */
	public Ary32_2D v;

	/**
	 * Constructor.
	 */
	public K32VAry32_2D(int int32, Ary32_2D ary32_2D) {

		k = int32;
		v = ary32_2D;

	}

	/**
	 * To compare to other's key.
	 */
	@Override
	public int compareTo(K32VAry32_2D otherK32VAry32_2D) {

		return (k - otherK32VAry32_2D.k);
	}

	/**
	 * To compare to other's key.
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj == null)

			return B.O;

		if (obj instanceof K32VAry32_2D)

			return k == ((K32VAry32_2D) obj).k;

		return B.O;

	}

	/**
	 * To StringBuilder.
	 */
	public StringBuilder toStr() {

		return new StringBuilder(O.defLenForStr).append(O.C40).append(k).append(O.C94).append(v.toStr()).append(O.C41);
	}
}
