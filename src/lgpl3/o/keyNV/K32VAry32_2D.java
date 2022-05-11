package lgpl3.o.keyNV;

import java.io.Serializable;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Ary32_2D;

/**
 * 本類別 int32 與 Ary32_2D.<br/>
 * It is like a Ary32_2D which is attached to the integer.
 *
 * @version 2022/02/02_17:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=K32VAry32_2D" >K32VAry32_2D.java</a>
 *
 */
public class K32VAry32_2D implements Comparable<K32VAry32_2D>, Serializable {

	private static final Class<?> THIS = K32VAry32_2D.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * The int.<br/>
	 * The int.
	 */
	public final int int32;

	/**
	 * The int.<br/>
	 * The int.
	 */
	public Ary32_2D ary32_2D;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public K32VAry32_2D(int int32, Ary32_2D ary32_2D) {

		this.int32 = int32;
		this.ary32_2D = ary32_2D;

	}

	/**
	 * 比較彼此的 32 位元整數的大小.<br/>
	 * To compare to other's at0().
	 */
	@Override
	public int compareTo(K32VAry32_2D otherK32VAry32_2D) {

		if (int32 > otherK32VAry32_2D.int32)

			return 1;

		if (int32 < otherK32VAry32_2D.int32)

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

		if (obj instanceof K32VAry32_2D)

			return int32 == ((K32VAry32_2D) obj).int32;

		return B.O;

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public StringBuilder toStr() {

		return new StringBuilder(O.DEF_CAPACITY32_FOR_STR).append(O.C40).append(int32).append(O.C94).append(ary32_2D.toStr()).append(O.C41);
	}
}
