package lgpl3.o.keyNV;

import java.io.Serializable;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 本類別 String 與 int.<br/>
 * Something like a String which is attached to the int.
 *
 * @version 2022/05/15_22:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=KSV32" >KSV32.java</a>
 *
 * @see K32V
 *
 * @see K32V64
 *
 * @see K32VAry32_2D
 *
 * @see K32VSeq
 *
 * @see K64V
 *
 * @see K64V32
 *
 * @see K64V32V32
 *
 * @see KAry32V32
 *
 * @see KAryV32
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
	public final String k;

	/**
	 * The int.<br/>
	 * The int.
	 */
	public int v;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public KSV32(String s, int int32) {

		k = s;
		v = int32;

	}

	/**
	 * 比較彼此的 32 位元整數的大小.<br/>
	 * To compare to other's at0().
	 */
	@Override
	public int compareTo(KSV32 otherKSV32) {

		return k.compareTo(otherKSV32.k);
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

			return k.equals(((KSV32) obj).k);

		return B.O;

	}

//	/**
//	 * 比較彼此的 32 位元整數的大小.<br/>
//	 * To compare to other's at0().
//	 */
//	public boolean equals(KSV32 otherKSV32) {
//
//		if (otherKSV32 == null)
//
//			return B.O;
//
//		return k.equals(otherKSV32.k);
//
//	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public StringBuilder toStr() {

		return new StringBuilder(O.defLenForStr).append(O.C40).append(k).append(O.C94).append(v).append(O.C41);
	}
}
