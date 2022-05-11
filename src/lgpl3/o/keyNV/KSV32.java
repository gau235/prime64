package lgpl3.o.keyNV;

import java.io.Serializable;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 本類別 String 與 int.<br/>
 * Something like a String which is attached to the int.
 *
 * @version 2021/01/05_22:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=KSV32" >KSV32.java</a>
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
public class KSV32 implements Comparable<KSV32>, Serializable {

	private static final Class<?> THIS = KSV32.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * The String.<br/>
	 * The String.
	 */
	public final String s;

	/**
	 * The int.<br/>
	 * The int.
	 */
	public int int32;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public KSV32(String s, int int32) {

		this.s = s;
		this.int32 = int32;

	}

	/**
	 * 比較彼此的 32 位元整數的大小.<br/>
	 * To compare to other's at0().
	 */
	@Override
	public int compareTo(KSV32 otherKSV32) {

		return s.compareTo(otherKSV32.s);
	}

	/**
	 * 比較彼此的 32 位元整數的大小.<br/>
	 * To compare to other's at0().
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj == null)

			return B.O;

		if (obj instanceof KSV32)

			return s.equals(((KSV32) obj).s);

		return B.O;

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public StringBuilder toStr() {

		return new StringBuilder(O.DEF_CAPACITY32_FOR_STR).append(O.C40).append(this.s).append(O.C94).append(this.int32).append(O.C41);
	}
}
