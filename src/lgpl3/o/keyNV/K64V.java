package lgpl3.o.keyNV;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 本類別 64 位元整數與泛型物件, 其內第 0 位置是 64 位元整數, 第 1 位置是泛型物件.<br/>
 * Something like a long which is attached to the generic type object.
 *
 * @version 2020/02/23_10:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=K64V" >K64V.java</a>
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
public class K64V<V> implements Comparable<K64V<V>>, Serializable {

	private static final Class<?> THIS = K64V.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * 本可比較介面與泛型物件中的可比較介面 ( 第 0 位置 ).<br/>
	 * The Comparable(the 0-th position) of this.
	 */
	public final long k;

	/**
	 * 本可比較介面與泛型物件中的泛型物件 ( 第 1 位置 ).<br/>
	 * The generic type object(the 1-th position) of this.
	 */
	public final V v;

	/**
	 * 建構方法, 生成物件的 64 位元整數是 at0, 第 1 位置的泛型物件 at1.<br/>
	 * Constructor; the K64V object's k is at0 and the generic type object is at1.
	 */
	public K64V(long int64, V v) {

		k = int64;
		this.v = v;

	}

	/**
	 * 比較彼此的 64 位元整數的大小.<br/>
	 * To compare to other's k.
	 */
	@Override
	public int compareTo(K64V<V> otherK64V) {

		if (k > otherK64V.k)

			return 1;

		if (k < otherK64V.k)

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

		if (obj instanceof K64V)

			return k == ((K64V<V>) obj).k;

		return B.O;

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public StringBuilder toStr() {

		StringBuilder ret = new StringBuilder(O.defLenForStr);

		ret.append(O.C40).append(k).append(O.C94);

		try {
			return ret.append((StringBuilder) v.getClass().getMethod(O.S_METHOD_TO_STR).invoke(v)).append(O.C41);

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException

				| InvocationTargetException ex) {

			if (O.isDev)

				O.l(ex.toString(), THIS);

		}

		return ret.append(v.toString()).append(O.C41);

	}
}
