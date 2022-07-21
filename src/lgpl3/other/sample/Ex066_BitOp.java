package lgpl3.other.sample;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.O;
import lgpl3.o.time.T64;

/**
 * bit op.<br/>
 * bit op.
 *
 * @version 2020/03/09_16:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex066_BitOp" >Ex066_BitOp.java</a>
 *
 * @see Ex066_BitOp
 *
 * @see Ex068_BitOp
 *
 * @see Ex069_BitOp
 */
public class Ex066_BitOp {

	public static void main(String[] sAry) throws Throwable {

		final long base = B64W6.genB64W6ByAry32(1, 2, 3, 4, 5, 6, 7);

		int i, j, testN = 30_000;

		long tmp = base;
		long t0 = System.currentTimeMillis();

		for (i = 0; i != testN; i++) {

			for (j = 0; j != testN; j++)

				do
					sAry = null;

				while (((int) (tmp >>>= 4)) != 0b0);

		}

		O.l("cost32=" + T64.difInF32Sec(t0));

		/////////////////////////////////////////

		tmp = base;
		t0 = System.currentTimeMillis();

		for (i = 0; i != testN; i++) {

			for (j = 0; j != testN; j++)

				do
					sAry = null;

				while ((tmp >>>= 4) != 0b0L);

		}

		O.l("cost=" + T64.difInF32Sec(t0));

	}
}
