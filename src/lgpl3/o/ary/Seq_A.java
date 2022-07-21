package lgpl3.o.ary;

import java.io.Serializable;
import java.util.Arrays;

import lgpl3.b32.B32va;
import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 64 位元整數伍.<br/>
 * The int64 sequence.
 *
 * @version 2022/05/05_09:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Seq_A" >Seq_A.java</a>
 *
 * @see Seq
 */
public abstract class Seq_A implements Serializable {

	private static final Class<?> THIS = Seq_A.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * 內部陣列的初始長度值.<br/>
	 * Initial length of the inside array.
	 */
	public static final int DEF_LEN = 0b1111_1111;

	/**
	 * 內部陣列.<br/>
	 * The inside array.
	 */
	public long[] ary;

	/**
	 * 內部陣列長度.<br/>
	 * The length of the inside array.
	 */
	public int fixedLen;

	/**
	 * 內部陣列的最末項的後 1 個位置.<br/>
	 * The position after the last element of the inside array.
	 */
	public int i; // index, length

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

		System.arraycopy(ary, 0, (ary = new long[fixedLen = (fixedLen << 1) | fixedLen]), 0, oldLen);

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

		System.arraycopy(ary, 0, (ary = new long[fixedLen]), 0, oldLen);

	}

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public Seq_A(long[] ary) {

		if (ary == null || (fixedLen = ary.length) == 0)

			O.x();

		this.ary = ary;

		if (fixedLen < DEF_LEN)

			extLen(DEF_LEN);

	}

	/**
	 * 縮減空間.<br/>
	 * To trim the inside array length to the number of elements.
	 */
	public Seq_A trim() {

		if (i != fixedLen)

			System.arraycopy(ary, 0, (ary = new long[fixedLen = i]), 0, i);

		return this;

	}

	/**
	 * To sort.<br/>
	 * To sort.
	 */
	public Seq_A sort() {

		Arrays.sort(ary, 0, i);

		return this;

	}

	/**
	 * 陣列內元素位置顛倒.<br/>
	 * To reverse.
	 */
	public Seq_A rev() {

		long tmp;
		for (int idx = 0, lenDiv2 = (i >>> 1), lenMinus1 = (i - 1); idx != lenDiv2; idx++) {

			tmp = ary[idx];
			ary[idx] = ary[lenMinus1 - idx];
			ary[lenMinus1 - idx] = tmp;

		}

		return this;

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public StringBuilder toStr() {

		StringBuilder ret = new StringBuilder(O.defLenForStr);

		for (int idx = 0; idx != i;) {

			ret.append(ary[idx]);

			if (++idx != i)

				ret.append(O.C44);

		}

		return ret;

	}

	/**
	 * 取得第 0 個項.<br/>
	 * To return the 0-th element (head) of this.<br/>
	 * Not thread safe.<br/>
	 *
	 * @see #tail()
	 */
	public long head() {

		return ((i == 0) ? Long.MIN_VALUE : ary[0]);
	}

	/**
	 * 取得第末個項.<br/>
	 * To return the last element (tail) of this.<br/>
	 * Not thread safe.<br/>
	 *
	 * @see #head()
	 */
	public long tail() {

		return ((i == 0) ? Long.MIN_VALUE : ary[i - 1]);
	}

	/**
	 * 取得並移除第 0 個項.<br/>
	 * To return and to remove the first element (head) of this.
	 */
	public long cutHead() {

		if (i == 0)

			return Long.MIN_VALUE; // fuck

		long head = ary[0];

		System.arraycopy(ary, 1, ary, 0, --i);

		return head;

	}

	/**
	 * 取得並移除第末個項.<br/>
	 * To return and to remove the last element (tail) of this.
	 */
	public long cutTail() {

		try {
			return ary[--i];

		} catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsEx) {

			O.l("aryIdxOutOfBound: iLen=" + i + " fixedLen=" + fixedLen, THIS);

			return Long.MIN_VALUE; // fuck

		}
	}

	/**
	 * 取得此伍第 index 位置, 把其餘項往前移動.<br/>
	 * To cut the element to the idx-th position and return.
	 */
	public long cutAt(int idx) {

		if (idx >= i || idx < 0)

			return Long.MIN_VALUE;

		long ret = ary[idx];

		if (--i > idx)

			System.arraycopy(ary, idx + 1, ary, idx, i - idx);

		return ret;

	}

	/**
	 * To sum.<br/>
	 * To sum.
	 */
	public long sum() {

		long ans = 0L;

		for (int idx = 0; idx != i; idx++)

			ans += ary[idx];

		return ans;

	}
}
