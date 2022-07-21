package lgpl3.comb.filter;

import java.io.Serializable;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Seq32;

/**
 * The set to filter.<br/>
 * The set to filter.
 *
 * @version 2020/09/20_21:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=IdxSet32" >IdxSet32.java</a>
 *
 * @see SetWBst32
 */
public class IdxSet32 implements Serializable {

	private static final Class<?> THIS = IdxSet32.class;

	private static final long serialVersionUID = B.genId32(THIS);

	public static final int $6 = B64W6.$6;

	/**
	 * 0b111111<br/>
	 * 0b111111
	 */
	public static final int MASK32 = B64W6.MASK32;

	public final int n;

	public final Seq32[] aryOfSeq32;

	public int i1, i2;

	public int hitIdx = -1; // fuck

	public Seq32 hitSeq32;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public IdxSet32(int n) {

		this.n = n; // n * n 方陣嗎

		aryOfSeq32 = new Seq32[((n - 1) * n) + ((n - 1) - 1) + 1]; // 降維的觀念

		O.l("aryOfSeq32.len=" + aryOfSeq32.length, THIS);

	}

	/**
	 * To add.<br/>
	 * To add.
	 */
	public boolean aN(long b64W6) {

		i1 = ((int) b64W6) & MASK32; // 第幾列嗎
		b64W6 >>>= $6;

		i2 = ((int) b64W6) & MASK32; // 第幾行個 嗎
		b64W6 >>>= $6;

		i1 = (i1 - 1) * n + (i2 - 1);

		if (i1 == hitIdx) // hit

			return hitSeq32.appendIfNotFound((int) b64W6);

		// not hit
		hitIdx = i1; // reset

		if ((hitSeq32 = aryOfSeq32[i1]) == null) { // first time

			aryOfSeq32[i1] = hitSeq32 = new Seq32().a((int) b64W6);

			return B.I;

		}

		return hitSeq32.appendIfNotFound((int) b64W6);

	}
}
