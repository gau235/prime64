package lgpl3.o.keyNV;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 本類別 32 位元整數與泛型物件, 其內第 0 位置是 32 位元整數, 第 1 位置是泛型物件.<br/>
 * Something like a long which is attached to the generic type object.
 *
 * @version 2020/02/18_14:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=K32V" >K32V.java</a>
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
public class K32V<V> implements Comparable<K32V<V>>, Serializable {

	private static final Class<?> THIS = K32V.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * 本可比較介面與泛型物件中的可比較介面 ( 第 0 位置 ).<br/>
	 * The Comparable(the 0-th position) of this.
	 */
	public final int int32;

	/**
	 * 本可比較介面與泛型物件中的泛型物件 ( 第 1 位置 ).<br/>
	 * The generic type object(the 1-th position) of this.
	 */
	public final V v;

	/**
	 * 建構方法, 生成物件的 64 位元整數是 at0, 第 1 位置的泛型物件 at1.<br/>
	 * Constructor; the K64V object's int64 is at0 and the generic type object is at1.
	 */
	public K32V(int int32, V v) {

		this.int32 = int32;
		this.v = v;

	}

	/**
	 * The base K32V.<br/>
	 * The base K32V.
	 */
	public static final K32V<Object> DEF_K32V = new K32V<Object>(0, null);

	/**
	 * 比較彼此的 32 位元整數的大小.<br/>
	 * To compare to other's at0().
	 */
	@Override
	public int compareTo(K32V<V> otherK32V) {

		if (int32 > otherK32V.int32)
			return 1;

		if (int32 < otherK32V.int32)
			return -1;

		return 0;
	}

	/**
	 * 比較彼此的 64 位元整數的大小.<br/>
	 * To compare to other's at0().
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {

		if (obj == null)

			return B.O;

		if (obj instanceof K32V)

			return int32 == ((K32V<V>) obj).int32;

		return B.O;

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public StringBuilder toStr() {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		retStr.append(O.C40).append(int32).append(O.C94);

		try {
			return retStr.append((StringBuilder) v.getClass().getMethod(O.S_METHOD_TO_STR).invoke(v)).append(O.C41);

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException ex) {

			if (O.isDev)
				O.l(ex.toString(), THIS);

		}

		return retStr.append(v.toString()).append(O.C41);

	}
}
