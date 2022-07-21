package lgpl3.b64.sample;

import lgpl3.b32.B32va;
import lgpl3.b64.B64va;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.O;

/**
 * B64 to String.<br/>
 * B64 to String.
 *
 * @version 2022/04/30_19:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex11_ToStr" >Ex11_ToStr.java</a>
 *
 */
public class Ex11_ToStr {

	public static void main(String[] sAry) throws Throwable {

		// long int64 = 0b0111_0001_0010_0011;
		// long int64 = 0b1111_001111_111111_111111_111111_111111_111111_111111_111111_111111_111111L;
		// long int64 = -0b1L;
		long int64 = Long.MIN_VALUE;

		int int32 = (int) int64;

		O.l("B64va.str=" + O.L + B64va.str(int64));

		O.l();

		O.l("B32va.str16=" + O.L + B32va.str16(int32));
		O.l("B32va.str32=" + O.L + B32va.str(int32));

		O.l();
		O.l("B64W6.str24=" + O.L + B64W6.str24(int64));

		O.l();

		O.l("B64W6.str=" + O.L + B64W6.str(int64));

	}
}
