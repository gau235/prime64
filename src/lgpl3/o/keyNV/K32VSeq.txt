package lgpl3.o.keyNV;

import java.io.Serializable;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Seq;

/**
 * 本類別 int32 與 Seq.<br/>
 * It is like a Seq which is attached to the integer.
 *
 * @version 2022/03/15_12:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=K32VSeq" >K32VSeq.java</a>
 *
 * @see K64V32
 *
 * @see K64V32V32
 *
 * @see K64V
 *
 * @see K32V64
 *
 * @see K32VSeq
 *
 * @see K32V
 *
 * @see KSV32
 */
public class K32VSeq implements Comparable<K32VSeq>, Serializable {

	private static final Class<?> THIS = K32VSeq.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * The int.<br/>
	 * The int.
	 */
	public final int int32;

	/**
	 * The int.<br/>
	 * The int.
	 */
	public Seq seq;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public K32VSeq(int int32, Seq seq) {

		this.int32 = int32;
		this.seq = seq;

	}

	/**
	 * 比較彼此的 32 位元整數的大小.<br/>
	 * To compare to other's at0().
	 */
	@Override
	public int compareTo(K32VSeq otherK32VSeq) {

		if (this.int32 > otherK32VSeq.int32)

			return 1;

		if (this.int32 < otherK32VSeq.int32)

			return -1;

		return 0;

	}

	/**
	 * 比較彼此的 32 位元整數的大小.<br/>
	 * To compare to other's at0().
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj == null)

			return B.O;

		if (obj instanceof K32VSeq)

			return int32 == ((K32VSeq) obj).int32;

		return B.O;

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public StringBuilder toStr() {

		return new StringBuilder(O.DEF_CAPACITY32_FOR_STR).append(O.C40).append(int32).append(O.C94).append(seq.toStr()).append(O.C41);
	}
}
