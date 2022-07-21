package lgpl3.o.keyNV;

import java.util.Arrays;

import lgpl3.o.B;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Seq;

/**
 * A map for K32VSeq.<br/>
 * A map for K32VSeq.
 *
 * @version 2021/01/15_23:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=MapK32VSeq" >MapK32VSeq.java</a>
 *
 * @see K64V
 */
public class MapK32VSeq extends Arr<K32VSeq> {

	private static final Class<?> THIS = MapK32VSeq.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public MapK32VSeq() {

		super(K32VSeq.class); // fuck
	}

	/**
	 * 加入.<br/>
	 * To append without checking.
	 */
	public void a(int int32, Seq seq) {

		if (i == fixedLen)
			extLen();

		arr[i++] = new K32VSeq(int32, seq);

	}

	/**
	 * 檢查後加入.<br/>
	 * To append after checked.
	 */
	public Seq get(int int32) {

		final int iFound = Arrays.binarySearch(arr, 0, i, new K32VSeq(int32, null));

		return ((iFound < 0) ? null : arr[iFound].v);

	}
}
