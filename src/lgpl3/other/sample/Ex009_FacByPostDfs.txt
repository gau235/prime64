package lgpl3.other.sample;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * To test.<br/>
 * To test.
 *
 * @version 2021/01/11_21:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex009_FacByPostDfs" >Ex009_FacByPostDfs.java</a>
 *
 * @see Ex010_FacByCount
 */
public class Ex009_FacByPostDfs {

	public static void facRecur(int n) {

		if (n == 1) { // usually be skipped

			B.n32++;
			O.l("O.y32=" + B.n32);

			return;

		}

		for (int i = 1; i <= n; i++) {

			B.n++;
			facRecur(n - 1);

		}
	}

	public static void main(String[] sAry) throws Throwable {

		B.n = B.n32 = 0;

		int n = 4;
		facRecur(n);

		O.l("fac(" + n + ")=" + B.n32);
		O.l("num of calls=" + B.n);

	}
}
