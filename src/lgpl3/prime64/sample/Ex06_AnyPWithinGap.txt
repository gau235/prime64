package lgpl3.prime64.sample;

import lgpl3.o.O;
import lgpl3.prime64.Miner;

/**
 * To find the gap.<br/>
 * x, y = 200, 210<br/>
 * x, y = 1330, 1360<br/>
 * x, y = 31400, 31460<br/>
 * x, y = 370270, 370370<br/>
 *
 * @version 2022/04/26_20:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex06_AnyPWithinGap" >Ex06_AnyPWithinGap.java</a>
 *
 */
public class Ex06_AnyPWithinGap {

	private static final Class<?> THIS = Ex06_AnyPWithinGap.class;

	public static void main(String[] sAry) throws Throwable {

		int head = 1, tail = 9999, gap = 30, gapMinus1 = (gap - 1);

		int smallI, n32, r;

		for (; head < gap; head += 10) // O.l("head=" + head, THIS);

			for (smallI = head; smallI <= tail; smallI += gap)

				if (!Miner.isAnyPWithin(smallI, (smallI + gapMinus1)))

					for (n32 = (int) O.xy(smallI, smallI += gapMinus1); n32 != smallI; n32++)

						if ((r = n32 % 10) == 1 || r == 3 || r == 7 || r == 9)

							O.l(n32 + " = " + Miner.easyDecompo(n32) + " * X", THIS);

	}
}