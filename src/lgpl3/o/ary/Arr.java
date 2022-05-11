package lgpl3.o.ary;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

import lgpl3.b32.B32va;
import lgpl3.o.B;
import lgpl3.o.O;

/**
 * The array wrapper.<br/>
 * 伍的特性:<br/>
 * 內含的項可重複.<br/>
 * 項有些情況下可排序.<br/>
 * 可同時多執行緒存取.<br/>
 * 存取的依據是 index.<br/>
 * 不可加入 null.<br/>
 * 可關閉.<br/>
 * 當伍在膨脹中, 則執行緒安全, 且存取不易取得 null.<br/>
 *
 * @version 2022/03/10_19:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Arr" >Arr.java</a>
 *
 * @see Arr
 *
 * @see Seq
 *
 * @see Seq32
 */
public class Arr<T> implements Serializable {

	private static final Class<?> THIS = Arr.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * 內部陣列.<br/>
	 * The inside array.
	 */
	public T[] arr;

	/**
	 * 內部陣列長度.<br/>
	 * The length of the inside array.
	 */
	public int fixedLen;

	/**
	 * 內部陣列的最末項的後 1 個位置.<br/>
	 * The position after the last element of the inside array.
	 */
	public int iLen;

	/**
	 * 內部陣列.<br/>
	 * The inside array.
	 */
	public final Class<T> classForT;

	/**
	 * 用於多執行緒的同步.<br/>
	 * For synchronizing.
	 */
	public final Object keyToSyn = new Object();

	/**
	 * 確保不會 IndexOutOfBoundsException.<br/>
	 * To extend the length of inside array and to avoid the IndexOutOfBoundsException.<br/>
	 */
	@SuppressWarnings("unchecked")
	public void extLen() {

		final int oldLen = fixedLen;

		if (O.isDev)

			O.l("oldLen=" + oldLen + " extLen=" + B32va.str((oldLen << 1) | oldLen), THIS);

		System.arraycopy(arr, 0, (arr = (T[]) Array.newInstance(classForT, (fixedLen = ((fixedLen << 1) | fixedLen)))), 0, oldLen);

	}

	/**
	 * 確保不會 IndexOutOfBoundsException.<br/>
	 * To extend the length of inside array and to avoid the IndexOutOfBoundsException.<br/>
	 */
	@SuppressWarnings("unchecked")
	public void extLen(int newLen) {

		final int oldLen = fixedLen;

		do
			if ((fixedLen = ((fixedLen << 1) | fixedLen)) < 0b0)

				O.x();

		while (fixedLen < newLen);

		if (O.isDev)

			O.l("oldLen=" + oldLen + ", fixedLen=" + B32va.str(fixedLen), THIS);

		System.arraycopy(arr, 0, (arr = (T[]) Array.newInstance(classForT, fixedLen)), 0, oldLen);

	}

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	@SuppressWarnings("unchecked")
	public Arr(Class<T> componentType) {

		arr = (T[]) Array.newInstance((classForT = componentType), (fixedLen = Seq.DEF_LEN));
	}

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	@SuppressWarnings("unchecked")
	public Arr(T[] aryOfT) {

		arr = aryOfT;

		classForT = (Class<T>) aryOfT[0].getClass(); // classForT = (Class<T>) aryOfT.getClass().getComponentType();

		iLen = fixedLen = aryOfT.length;

		if (iLen < Seq.DEF_LEN) {

			O.l("iLen=" + fixedLen, THIS);

			extLen(Seq.DEF_LEN);

		}
	}

	/**
	 * 排序.<br/>
	 * To sort.
	 */
	public Arr<T> sort() {

		Arrays.sort(arr, 0, iLen);

		return this;

	}

	/**
	 * 排序.<br/>
	 * To sort.
	 */
	public Arr<T> sort(Comparator<T> compa) {

		Arrays.sort(arr, 0, iLen, compa);

		return this;

	}

	/**
	 * 排序.<br/>
	 * To sort.
	 */
	public Arr<T> sort(int from, int to, Comparator<T> compa) {

		Arrays.sort(arr, from, to, compa);

		return this;

	}

	/**
	 * 加 all 個項到此伍末之後.<br/>
	 * To append the all to after the iLen of this.
	 *
	 * @see #insertAt(int, Object)
	 */
	public Arr<T> appendAll(T[] otherArr, int from, int to) { // to is not included

		int diff = to - from;
		int lenPlusOtherLen = iLen + diff;

		if (lenPlusOtherLen >= fixedLen)

			extLen(lenPlusOtherLen);

		System.arraycopy(otherArr, from, arr, iLen, diff);

		iLen = lenPlusOtherLen;

		return this;

	}

	/**
	 * 加 1 個項到此伍末之後.<br/>
	 * To append the element to after the iLen of this.
	 *
	 * @see #insertAt(int, Object)
	 */
	public Arr<T> a(T t) {

		if (iLen == fixedLen)

			extLen();

		arr[iLen++] = t;

		return this;

	}

	/**
	 * 取得第 0 個項.<br/>
	 * To return the 0-th element (head) of this.<br/>
	 * Not thread safe.<br/>
	 *
	 * @see #tail()
	 */
	public T head() {

		return ((iLen == 0) ? null : arr[0]);
	}

	/**
	 * 取得第末個項.<br/>
	 * To return the last element (tail) of this.<br/>
	 * Not thread safe.<br/>
	 *
	 * @see #head()
	 */
	public T tail() {

		return ((iLen == 0) ? null : arr[iLen - 1]);
	}

	/**
	 * 取得並移除第 0 個項.<br/>
	 * 運算成本高.<br/>
	 * To return and to remove the 0-th element (head) of this.<br/>
	 * It costs a lot.
	 *
	 * @see #cutTail()
	 */
	public T cutHead() {

		if (iLen == 0)

			return null; // fuck

		T head = arr[0];

		System.arraycopy(arr, 1, arr, 0, --iLen);

		arr[iLen] = null; // gc

		return head;

	}

	/**
	 * 取得並移除第末個項.<br/>
	 * To return and to remove the last element (tail) of this.
	 *
	 * @see #cutHead()
	 */
	public T cutTail() {

		try {
			T tail = arr[--iLen];
			arr[iLen] = null; // gc

			return tail;

		} catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsEx) {

			O.l("aryIdxOutOfBound: iLen=" + iLen + " arr.len=" + fixedLen, THIS);

			return null; // fuck

		}
	}

	/**
	 * 加 1 個項到此伍第 index 位置, 把其餘項往後移動.<br/>
	 * To add the element to the index-th position.
	 */
	public Arr<T> insertAt(int idx, T t) { // [10,20,30] insertAt(0, 50) => [50,10,20,30]

		if (idx >= iLen || idx < 0)

			O.x("idx=" + idx);

		int numOfElemNeedToShiftR = iLen - idx;

		if (iLen++ == fixedLen)

			extLen();

		if (numOfElemNeedToShiftR != 0) // O.lD("shiftR", THIS);

			System.arraycopy(arr, idx, arr, idx + 1, numOfElemNeedToShiftR); // shift right

		arr[idx] = t;

		return this;

	}

	/**
	 * 把陣列轉成字串建立者.<br/>
	 * To convert the array to StringBuilder.
	 */
	public StringBuilder toStr() {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		if (iLen == 0)

			return retStr;

		Method methodToStr = null;
		try {
			methodToStr = classForT.getMethod(O.S_METHOD_TO_STR);

		} catch (NoSuchMethodException | SecurityException ex) {

			// ex.printStackTrace();
		}

		// O.l("methodToStr=" + methodToStr, THIS);

		int idx;
		T t;

		if (methodToStr != null) {

			for (idx = 0; idx != iLen;) {

				if ((t = arr[idx]) != null)

					try {
						retStr.append(methodToStr.invoke(t));

					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {

						retStr.append(t.toString());
					}

				else
					retStr.append("null");

				if (++idx != iLen)

					retStr.append(O.C_A_L);

			}

		} else
			for (idx = 0; idx != iLen;) {

				if ((t = arr[idx]) != null)

					retStr.append(t.toString());
				else
					retStr.append("null");

				if (++idx != iLen)

					retStr.append(O.C_A_L);

			}

		return retStr;

	}

	/**
	 * 縮減空間.<br/>
	 * To trim the inside array length to the number of elements.
	 */
	@SuppressWarnings("unchecked")
	public Arr<T> trim() {

		// if (iLen != fixedLen) {
		// arr = Arrays.copyOf(aryOfElem, iLen);

		// T[] newArr;
		// if (classForT == Object.class) {
		//
		// O.l("classForT == Object.class" , THIS);
		// newArr = (T[]) new Object[iLen];
		//
		// } else
		// newArr = (T[]) Array.newInstance(classForT, iLen);
		//
		// }

		if (iLen != fixedLen)

			System.arraycopy(arr, 0, (arr = (T[]) Array.newInstance(classForT, (fixedLen = iLen))), 0, iLen);

		return this;

	}
}
