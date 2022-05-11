package lgpl3.o.ary;

import java.io.Serializable;
import java.util.Arrays;

import lgpl3.b32.B32va;
import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 32 位元整數伍.<br/>
 * The int32 sequence.
 *
 * @version 2022/04/23_22:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Seq32_A" >Seq32_A.java</a>
 *
 * @see Seq32
 */
public abstract class Seq32_A implements Serializable {

	private static final Class<?> THIS = Seq32_A.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * 內部陣列.<br/>
	 * The inside array.
	 */
	public int[] ary32;

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
	 * 用於多執行緒的同步.<br/>
	 * For synchronizing.
	 */
	public final Object keyToSyn = new Object();

	/**
	 * 確保不會 IndexOutOfBoundsException.<br/>
	 * To extend the length of inside array and to avoid the IndexOutOfBoundsException.<br/>
	 */
	public void extLen() {

		final int oldLen = fixedLen;

		if (O.isDev)

			O.l("oldLen=" + oldLen + " extLen=" + B32va.str((oldLen << 1) | oldLen), THIS);

		System.arraycopy(ary32, 0, (ary32 = new int[fixedLen = (fixedLen << 1) | fixedLen]), 0, oldLen);

	}

	/**
	 * 確保不會 IndexOutOfBoundsException.<br/>
	 * To extend the length of inside array and to avoid the IndexOutOfBoundsException.<br/>
	 */
	public void extLen(int newLen) {

		final int oldLen = fixedLen;

		do
			if ((fixedLen = ((fixedLen << 1) | fixedLen)) < 0b0)

				O.x();

		while (fixedLen < newLen);

		if (O.isDev)

			O.l("oldLen=" + oldLen + ", fixedLen=" + B32va.str(fixedLen), THIS);

		System.arraycopy(ary32, 0, (ary32 = new int[fixedLen]), 0, oldLen);

	}

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public Seq32_A(int[] ary32) {

		if (ary32 == null || (fixedLen = ary32.length) == 0)

			O.x();

		this.ary32 = ary32;

		if (fixedLen < Seq.DEF_LEN)

			extLen(Seq.DEF_LEN);

	}

	/**
	 * 縮減空間.<br/>
	 * To trim the inside array length to the number of elements.
	 */
	public Seq32_A trim() {

		if (iLen != fixedLen)

			System.arraycopy(ary32, 0, (ary32 = new int[fixedLen = iLen]), 0, iLen);

		// if (O.isDev) O.l("trim=", THIS);

		return this;

	}

	/**
	 * To sort.<br/>
	 * To sort.
	 */
	public Seq32_A sort() {

		Arrays.sort(ary32, 0, iLen);

		return this;

	}

	/**
	 * 陣列內元素位置顛倒.<br/>
	 * To reverse.
	 */
	public Seq32_A rev() {

		int idx = 0, lenDiv2 = (iLen >>> 1), lenMinus1 = (iLen - 1), tmp32;

		for (; idx != lenDiv2; idx++) {

			tmp32 = ary32[idx];
			ary32[idx] = ary32[lenMinus1 - idx];
			ary32[lenMinus1 - idx] = tmp32;

		}

		return this;

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public StringBuilder toStr() {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		for (int idx = 0; idx != iLen;) {

			retStr.append(ary32[idx]);

			if (++idx != iLen)

				retStr.append(O.C44);

		}

		return retStr;

	}

	/**
	 * 取得第 0 個項.<br/>
	 * To return the 0-th element (head) of this.<br/>
	 * Not thread safe.<br/>
	 *
	 * @see #tail()
	 */
	public int head() {

		return ((iLen == 0) ? Integer.MIN_VALUE : ary32[0]);
	}

	/**
	 * 取得第末個項.<br/>
	 * To return the last element (tail) of this.<br/>
	 * Not thread safe.<br/>
	 *
	 * @see #head()
	 */
	public int tail() {

		return ((iLen == 0) ? Integer.MIN_VALUE : ary32[iLen - 1]);
	}

	/**
	 * 取得並移除第 0 個項.<br/>
	 * To return and to remove the first element (head) of this.
	 */
	public int cutHead() {

		if (iLen == 0)

			return Integer.MIN_VALUE; // fuck

		int head = ary32[0];

		System.arraycopy(ary32, 1, ary32, 0, --iLen);

		return head;

	}

	/**
	 * 取得並移除第末個項.<br/>
	 * To return and to remove the last element (tail) of this.
	 */
	public int cutTail() {

		// O.l("iLen=" + iLen, THIS);
		// O.l("fixedLen=" + fixedLen, THIS);
		// O.l("ary32=" + ary32.length, THIS);

		return ((iLen == 0) ? Integer.MIN_VALUE : ary32[--iLen]);

	}

	/**
	 * 取得此伍第 index 位置, 把其餘項往前移動.<br/>
	 * To cut the element to the idx-th position and return.
	 */
	public int cutAt(int idx) {

		if (idx >= iLen || idx < 0)

			return Integer.MIN_VALUE;

		int ret32 = ary32[idx];

		if (--iLen > idx)

			System.arraycopy(ary32, idx + 1, ary32, idx, iLen - idx);

		return ret32;

	}

	/**
	 * To sum.<br/>
	 * To sum.
	 */
	public long sum() {

		long ans = 0;

		for (int idx = 0; idx != iLen; idx++)

			ans += ary32[idx];

		return ans;

	}
}
