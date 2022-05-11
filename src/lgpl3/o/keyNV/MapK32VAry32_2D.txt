package lgpl3.o.keyNV;

import java.util.Arrays;

import lgpl3.o.B;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Ary32_2D;

/**
 * A map for K32VAry32_2D.<br/>
 * A map for K32VAry32_2D.
 *
 * @version 2021/02/02_17:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=MapK32VAry32_2D" >MapK32VAry32_2D.java</a>
 *
 */
public class MapK32VAry32_2D extends Arr<K32VAry32_2D> {

	private static final Class<?> THIS = MapK32VAry32_2D.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public MapK32VAry32_2D() {

		super(K32VAry32_2D.class); // fuck
	}

	/**
	 * 加入.<br/>
	 * To append without checking.
	 */
	public void a(int int32, Ary32_2D ary32_2D) {

		if (iLen == fixedLen)
			extLen();

		arr[iLen++] = new K32VAry32_2D(int32, ary32_2D);

	}

	/**
	 * 檢查後加入.<br/>
	 * To append after checked.
	 */
	public Ary32_2D get(int int32) {

		final int iFound = Arrays.binarySearch(arr, 0, iLen, new K32VAry32_2D(int32, null));

		return ((iFound < 0) ? null : arr[iFound].ary32_2D);

	}
}
