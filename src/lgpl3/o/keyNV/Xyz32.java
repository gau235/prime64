package lgpl3.o.keyNV;

import java.io.Serializable;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 本類別 int32 跟 int32 跟 int32<br/>
 * It is like an int32 which is attached to the int32.
 *
 * @version 2021/11/15_13:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Xyz32" >Xyz32.java</a>
 *
 */
public class Xyz32 implements Comparable<Xyz32>, Serializable {

	private static final Class<?> THIS = Xyz32.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * The int.<br/>
	 * The int.
	 */
	public int x;

	/**
	 * The int.<br/>
	 * The int.
	 */
	public int y;

	/**
	 * The int.<br/>
	 * The int.
	 */
	public int z;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public Xyz32(int x, int y, int z) {

		this.x = x;
		this.y = y;
		this.z = z;

	}

	/**
	 * 比較彼此的 32 位元整數的大小.<br/>
	 * To compare to other's at0().
	 */
	@Override
	public int compareTo(Xyz32 otherXyz32) {

		if (x > otherXyz32.x)
			return 1;

		if (x < otherXyz32.x) // else if (x < otherXyz32.x)
			return -1;

		if (y > otherXyz32.y)
			return 1;

		if (y < otherXyz32.y)
			return -1;

		if (z > otherXyz32.z)
			return 1;

		if (z < otherXyz32.z)
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

		if (obj instanceof Xyz32) {

			Xyz32 otherXyz32 = (Xyz32) obj;

			return (otherXyz32.x == x) && (otherXyz32.y == y) && (otherXyz32.z == z);

		}

		return B.O;

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public StringBuilder toStr() {

		return new StringBuilder(O.defLenForStr).append(O.C40).append(x).append(O.C94).append(y).append(O.C94).append(z)
				.append(O.C41);
	}
}
