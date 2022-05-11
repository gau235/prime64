package lgpl3.o.ary;

import lgpl3.o.B;

/**
 * 64 位元整數伍.<br/>
 * The int64 sequence.
 *
 * @version 2021/06/07_11:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Seq" >Seq.java</a>
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
		iLen = ary.length; // it's the ori len

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

		newSeq.iLen = iLen;
		newSeq.fixedLen = fixedLen;

		return newSeq;

	}

	/**
	 * 加 1 個項到此 64 位元整數伍末之後.<br/>
	 * To append the element to after the iLen of this.
	 */
	public Seq a(long int64) {

		if (iLen == fixedLen)

			extLen();

		ary[iLen++] = int64;

		return this;

	}

	/**
	 * To clone then append.<br/>
	 * To clone then append.
	 */
	public Seq cNA(long int64) {

		if (iLen == fixedLen)

			extLen(); // very tricky

		ary[iLen] = int64; // very tricky

		Seq newSeq = new Seq(ary.clone());

		newSeq.iLen = iLen + 1; // very tricky
		newSeq.fixedLen = fixedLen;

		return newSeq;

	}

	/**
	 * To rotate right.<br/>
	 * To rotate right.
	 */
	public Seq rotateR(int offset) {

		if (offset > iLen)

			throw new RuntimeException("offset" + offset + " iLen=" + iLen);

		if (iLen + offset >= fixedLen)

			extLen(iLen + offset);

		for (int idx = iLen - 1; idx >= 0; idx--)

			ary[idx + offset] = ary[idx]; // ext tail

		// O.l(O.delTailAll0(ary32));

		System.arraycopy(ary, iLen, ary, 0, offset);

		return this;

	}

	/**
	 * To rotate left.<br/>
	 * To rotate left.
	 */
	public Seq rotateL(int offset) {

		if (offset > iLen)

			throw new RuntimeException("offset" + offset + " iLen=" + iLen);

		if (iLen + offset >= fixedLen)

			extLen(iLen + offset);

		for (int idx = iLen, head = 0; head != offset;)

			ary[idx++] = ary[head++]; // ext tail

		System.arraycopy(ary, offset, ary, 0, iLen);

		return this;

	}

	/**
	 * 加 all 個項到此 64 位元整數伍末之後.<br/>
	 * To append the all to after the iLen of this.
	 */
	public Seq appendAll(Seq otherSeq) {

		int lenPlusOtherLen = iLen + otherSeq.iLen;

		if (lenPlusOtherLen >= fixedLen)

			extLen(lenPlusOtherLen);

		System.arraycopy(otherSeq.ary, 0, ary, iLen, otherSeq.iLen);

		iLen = lenPlusOtherLen;

		return this;

	}

	/**
	 * 加 all 個項到此 32 位元整數伍末之後.<br/>
	 * To append the all to after the iLen of this.
	 */
	public Seq appendAll(long[] otherAry) {

		int lenPlusOtherLen = iLen + otherAry.length;

		if (lenPlusOtherLen >= fixedLen)

			extLen(lenPlusOtherLen);

		System.arraycopy(otherAry, 0, ary, iLen, otherAry.length);

		iLen = lenPlusOtherLen;

		return this;

	}
}
