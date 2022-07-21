package lgpl3.o.ary;

import lgpl3.o.B;

/**
 * 64 位元整數伍.<br/>
 * The int64 sequence.
 *
 * @version 2021/06/07_11:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Seq" >Seq.java</a>
 *
 * @see Arr
 *
 * @see Seq
 *
 * @see Seq32
 */
public class Seq extends Seq_A {

	private static final Class<?> THIS = Seq.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public Seq(long... ary) {

		super(ary);

		// iLen = fixedLen;
		i = ary.length; // it's the ori len

	}

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public Seq() {

		super(new long[DEF_LEN]);
	}

	@Override
	public Seq clone() {

		Seq newSeq = new Seq(ary.clone());

		newSeq.i = i;
		newSeq.fixedLen = fixedLen;

		return newSeq;

	}

	/**
	 * 加 1 個項到此 64 位元整數伍末之後.<br/>
	 * To append the element to after the iLen of this.
	 */
	public Seq a(long int64) {

		if (i == fixedLen)

			extLen();

		ary[i++] = int64;

		return this;

	}

	/**
	 * To clone then append.<br/>
	 * To clone then append.
	 */
	public Seq cNA(long int64) {

		if (i == fixedLen)

			extLen(); // very tricky

		ary[i] = int64; // very tricky

		Seq newSeq = new Seq(ary.clone());

		newSeq.i = i + 1; // very tricky
		newSeq.fixedLen = fixedLen;

		return newSeq;

	}

	/**
	 * To rotate right.<br/>
	 * To rotate right.
	 */
	public Seq rotateR(int offset) {

		if (offset > i)

			throw new IllegalArgumentException("offset" + offset + " iLen=" + i);

		if (i + offset >= fixedLen)

			extLen(i + offset);

		for (int idx = i - 1; idx >= 0; idx--)

			ary[idx + offset] = ary[idx]; // ext tail

		// O.l(O.delTailAll0(ary32));

		System.arraycopy(ary, i, ary, 0, offset);

		return this;

	}

	/**
	 * To rotate left.<br/>
	 * To rotate left.
	 */
	public Seq rotateL(int offset) {

		if (offset > i)

			throw new IllegalArgumentException("offset" + offset + " iLen=" + i);

		if (i + offset >= fixedLen)

			extLen(i + offset);

		for (int idx = i, head = 0; head != offset;)

			ary[idx++] = ary[head++]; // ext tail

		System.arraycopy(ary, offset, ary, 0, i);

		return this;

	}

	/**
	 * 加 all 個項到此 64 位元整數伍末之後.<br/>
	 * To append the all to after the iLen of this.
	 */
	public Seq appendAll(Seq otherSeq) {

		int lenPlusOtherLen = i + otherSeq.i;

		if (lenPlusOtherLen >= fixedLen)

			extLen(lenPlusOtherLen);

		System.arraycopy(otherSeq.ary, 0, ary, i, otherSeq.i);

		i = lenPlusOtherLen;

		return this;

	}

	/**
	 * 加 all 個項到此 32 位元整數伍末之後.<br/>
	 * To append the all to after the iLen of this.
	 */
	public Seq appendAll(long[] otherAry) {

		int lenPlusOtherLen = i + otherAry.length;

		if (lenPlusOtherLen >= fixedLen)

			extLen(lenPlusOtherLen);

		System.arraycopy(otherAry, 0, ary, i, otherAry.length);

		i = lenPlusOtherLen;

		return this;

	}
}
