package lgpl3.other.sample;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.O;
import lgpl3.o.time.T64;

/**
 * bit op.<br/>
 * bit op.
 *
 * @version 2020/03/09_16:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex068_BitOp" >Ex068_BitOp.java</a>
 *
 * @see Ex066_BitOp
 *
 * @see Ex068_BitOp
 *
 * @see Ex069_BitOp
 */
public class Ex068_BitOp {

	public static void main(String[] sAry) throws Throwable {

		final long base = B64W6.genB64W6ByAry32(1, 2, 3, 4, 5, 6, 7);

		int i, j, testN = 60_000;

		long tmp = base;
		long t0 = System.currentTimeMillis();

		for (i = 0; i != testN; i++) {

			for (j = 0; j != testN; j++)

				if ((((int) tmp) & 0b1111) == 0b0)

					sAry = null;

		}

		O.l("cost32=" + T64.difInF32Sec(t0));

		////////////////////////////////////////////////////

		t0 = System.currentTimeMillis();

		for (i = 0; i != testN; i++) {

			for (j = 0; j != testN; j++)

				if ((tmp & 0b1111) == 0b0L)

					sAry = null;

		}

		O.l("cost=" + T64.difInF32Sec(t0));

	}
}
