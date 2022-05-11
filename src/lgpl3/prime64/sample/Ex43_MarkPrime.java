package lgpl3.prime64.sample;

import lgpl3.b32.B32va;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.time.T64;
import lgpl3.other.uI.MyStrva;
import lgpl3.prime64.thr.Marker;

/**
 * To grow b32 array for composite.<br/>
 * To grow b32 array for composite.
 *
 * @version 2021/08/23_18:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex43_MarkPrime" >Ex43_MarkPrime.java</a>
 *
 */
public abstract class Ex43_MarkPrime {

	public static void main(String[] sAry) {

		long t64_0 = O.t();

		final long headN = 21;
		final long tailN = 100;

		Marker marker = new Marker(headN, tailN, B.I);

		long[] aryOfP = marker.retrieveP(headN, tailN);

		O.l(aryOfP);

		long countOfP = marker.countP(headN, tailN);

		O.eq(countOfP, aryOfP.length);

		StringBuilder str = MyStrva.genStrToShowFrom1PrimeAry(aryOfP, T64.difInF32Sec(t64_0));

		O.l(str);
		O.l("countOfP=" + countOfP);

		O.l(B32va.str(marker.box[0]));

	}
}