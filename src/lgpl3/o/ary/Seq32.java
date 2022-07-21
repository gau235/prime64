package lgpl3.o.ary;

import lgpl3.o.B;

/**
 * 32 位元整數伍.<br/>
 * The int32 sequence.
 *
 * @version 2021/06/02_21:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Seq32" >Seq32.java</a>
 *
 * @see Arr
 *
 * @see Seq
 *
 * @see Seq32
 */
public class Seq32 extends Seq32_A {

	private static final Class<?> THIS = Seq32.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public Seq32(int... ary32) {

		super(ary32);

		// iLen = fixedLen;
		i = ary32.length; // it's the ori len

	}

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public Seq32() {

		super(new int[Seq.DEF_LEN]);
	}

	@Override
	public Seq32 clone() {

		Seq32 newSeq32 = new Seq32(ary32.clone());

		newSeq32.i = i;
		newSeq32.fixedLen = fixedLen;

		return newSeq32;

	}

	/**
	 * 加 1 個項到此 32 位元整數伍末之後.<br/>
	 * To append the element to after the iLen of this.
	 */
	public Seq32 a(int int32) {

		if (i == fixedLen)

			extLen();

		ary32[i++] = int32;

		return this;

	}

	/**
	 * 加 1 個項到此 32 位元整數伍末之後.<br/>
	 * To append the element to after the iLen of this.
	 */
	public boolean appendIfNotFound(int int32) { // todo: rename

		for (int idx = 0; idx != i; idx++)

			if (ary32[idx] == int32)

				return B.O;

		if (i == fixedLen)

			extLen();

		ary32[i++] = int32;

		return B.I;

	}

	/**
	 * To clone then append.<br/>
	 * To clone then append.
	 */
	public Seq32 cNA(int int32) {

		if (i == fixedLen)

			extLen(); // very tricky

		ary32[i] = int32; // very tricky

		Seq32 newSeq32 = new Seq32(ary32.clone());

		newSeq32.i = i + 1; // very tricky
		newSeq32.fixedLen = fixedLen;

		return newSeq32;

	}

	/**
	 * To rotate right.<br/>
	 * To rotate right.
	 */
	public Seq32 rotateR(int offset) {

		if (offset > i)

			throw new IllegalArgumentException("offset" + offset + " iLen=" + i);

		if (i + offset >= fixedLen)

			extLen(i + offset);

		for (int idx = i - 1; idx >= 0; idx--)

			ary32[idx + offset] = ary32[idx]; // ext tail

		// O.l(O.delTailAll0(ary32));

		System.arraycopy(ary32, i, ary32, 0, offset);

		return this;

	}

	/**
	 * To rotate left.<br/>
	 * To rotate left.
	 */
	public Seq32 rotateL(int offset) {

		if (offset > i)

			throw new IllegalArgumentException("offset" + offset + " iLen=" + i);

		if (i + offset >= fixedLen)

			extLen(i + offset);

		for (int idx = i, head = 0; head != offset;)

			ary32[idx++] = ary32[head++]; // ext tail

		System.arraycopy(ary32, offset, ary32, 0, i);

		return this;

	}

	/**
	 * 加 all 個項到此 32 位元整數伍末之後.<br/>
	 * To append the all to after the iLen of this.
	 */
	public Seq32 appendAll(Seq32 otherSeq32) {

		int lenPlusOtherLen = i + otherSeq32.i;

		if (lenPlusOtherLen >= fixedLen)

			extLen(lenPlusOtherLen);

		System.arraycopy(otherSeq32.ary32, 0, ary32, i, otherSeq32.i);

		i = lenPlusOtherLen;

		return this;

	}

	/**
	 * 加 all 個項到此 32 位元整數伍末之後.<br/>
	 * To append the all to after the iLen of this.
	 */
	public Seq32 appendAll(int[] otherAry32) {

		int lenPlusOtherLen = i + otherAry32.length;

		if (lenPlusOtherLen >= fixedLen)

			extLen(lenPlusOtherLen);

		System.arraycopy(otherAry32, 0, ary32, i, otherAry32.length);

		i = lenPlusOtherLen;

		return this;

	}
}
