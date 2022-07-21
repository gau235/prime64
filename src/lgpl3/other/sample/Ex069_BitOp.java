package lgpl3.other.sample;

import lgpl3.b32.B32va;
import lgpl3.b64.B64va;
import lgpl3.o.O;

/**
 * bit op.<br/>
 * bit op.
 *
 * @version 2022/02/04_18:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex069_BitOp" >Ex069_BitOp.java</a>
 *
 * @see Ex066_BitOp
 *
 * @see Ex068_BitOp
 *
 * @see Ex069_BitOp
 */
public class Ex069_BitOp {

	public static void main2(String[] sAry) throws Throwable {

		// long b64 = -1L;
		// long b64 = (long) Integer.MAX_VALUE << 4;
		long b64 = 0b1000_0000_0000_0000_0000_0000_0000_0001_0000_1111_1111_1111_1111_1111_1111_1111L;

		O.l("b64=" + B64va.str(b64));
		O.l("b64=" + b64);

		int b32 = (int) b64;

		O.l("b32=" + B32va.str(b32));
		O.l("b32=" + b32);

	}

	public static void main(String[] sAry) throws Throwable {

		long b64 = 0b1L << 65;

		O.l("b64=" + b64);
		O.l("b64=" + ((int) b64));
		O.l("countOf1=" + B64va.countOf1(b64));

		// 注意 fail => if ((((int) b64) >>>= 6) != 0) b64++;

	}
}
