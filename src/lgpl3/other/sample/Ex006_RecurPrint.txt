package lgpl3.other.sample;

import static java.lang.System.out;

/**
 * To print.<br/>
 * To print.
 *
 * @version 2020/12/08_15:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex006_RecurPrint" >Ex006_RecurPrint.java</a>
 *
 */
public class Ex006_RecurPrint {

	public static void recurPrint(int curN, int increment, int endN, int lv) {

		if (curN > endN)
			return;

		out.println("lv=" + lv + " curN=" + curN);
		recurPrint(curN + increment, increment, endN, ++lv);

	}

	public static void main(String[] sAry) throws Throwable {

		recurPrint(3, 2, 10, 1); // from 3 to 10; step 2
	}
}
