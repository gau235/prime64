package lgpl3.comb.sample;

import lgpl3.comb.DCirc;
import lgpl3.o.O;

/**
 * 全錯排.<br/>
 * 即 n 個人排成一列後解散再排成一列, 沒有人排在自己原先的位置的方法數.
 *
 * @version 2020/03/07_11:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=D33_DCircInt" >D33_DCircInt.java</a>
 *
 * @see DCirc
 */
public class D33_DCircInt {

	public static void main(String[] sAry) throws Throwable {

		// DCirc.passTest();

		int endN = 8;

		long sum = 0L;
		long bigSum = 0L;

		for (int n = 1; n <= endN; n++) {

			for (int k = 2; k <= n; k++) {

				O.l("DCirc=(" + n + "," + k + ")=" + DCirc.int64(n, k));

				sum += DCirc.int64(n, k);

			}

			O.l("sum=" + sum);

			bigSum += sum;

			O.l("bigSum=" + bigSum);

			sum = 0L;

		}
	}
}
