package lgpl3.other.sample;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * To get max length of an array.<br/>
 * To get max length of an array.
 *
 * @version 2021/04/30_20:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex070_GetMaxLenOfAry" >Ex070_GetMaxLenOfAry.java</a>
 *
 */
public class Ex070_GetMaxLenOfAry {

	public static void main(String[] sAry) {

		int len = Integer.MAX_VALUE;
		for (; B.I; len--) {

			try {

				O.l("maxLen=" + O.f(new boolean[len].length) + O.S32 + Ex070_GetMaxLenOfAry.class);
				return;

			} catch (Throwable throwable) {

				// throwable.printStackTrace();
			}
		}
	}
}
