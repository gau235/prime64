package lgpl3.o.keyNV;

import java.util.Arrays;

import lgpl3.o.B;
import lgpl3.o.ary.Arr;

/**
 * A map for K32V.<br/>
 * To use K32V.
 *
 * @version 2021/08/22_16:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=MapK32V" >MapK32V.java</a>
 *
 * @see K32V
 */
public class MapK32V<V> extends Arr<K32V<V>> {

	private static final Class<?> THIS = MapK32V.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	@SuppressWarnings("unchecked")
	public MapK32V() {

		// super((Class<K32V<V>>) K32V.class);
		super((Class<K32V<V>>) ((Class<?>) K32V.class)); // fuck

	}

	/**
	 * 加入.<br/>
	 * To append without checking.
	 */
	public void a(int int32, V v) {

		if (i == fixedLen)
			extLen();

		arr[i++] = new K32V<V>(int32, v);

	}

	/**
	 * 檢查後加入.<br/>
	 * To append after checked.
	 */
	public V get(int int32) {

		final int iFound = Arrays.binarySearch(arr, 0, i, new K32V<V>(int32, null));

		return ((iFound < 0) ? null : arr[iFound].v);

	}
}
