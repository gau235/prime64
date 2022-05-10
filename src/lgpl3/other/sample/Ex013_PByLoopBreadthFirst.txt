package lgpl3.other.sample;

import lgpl3.comb.Pnk;
import lgpl3.o.O;
import lgpl3.o.time.T64;

/**
 * To test.<br/>
 * To test.
 *
 * @version 2022/02/13_22:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex013_PByLoopBreadthFirst" >
 *          Ex013_PByLoopBreadthFirst.java</a>
 *
 * @see Ex009_FacByPostDfs
 */
public class Ex013_PByLoopBreadthFirst {

	public static void main(String[] sAry) throws Throwable {

		int n = 5;
		int k = 3;

		long t0 = O.t();

		long[] ary = Pnk.colByLoopBreadthNDepthFirst(n, k);

		O.l("costT=" + T64.difInF32Sec(t0));

		if (n <= 8) {

			java.util.Arrays.sort(ary);
			O.l(Pnk.strByAryOfRevB64W6BySAry(ary, O.S_ARY_A_Z));

		}

		O.l("len=" + O.eq(ary.length, Pnk.int64(n, k)));

	}
}
