package lgpl3.other.sample;

import java.util.Arrays;

import lgpl3.o.O;
import lgpl3.o.ary.Ary32va;

/**
 * The array.<br/>
 * The array.
 *
 * @version 2022/04/11_09:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex040_AryEx" >Ex040_AryEx.java</a>
 *
 */
public class Ex040_AryEx {

	public static void main(String sAry[]) throws Throwable {

		int[] ary = { 10, 20, 20, 30, 30, 30, 40, 50, 60 };
		int[] aryEx = { 10, 30, 70 };

		Arrays.sort(aryEx);

		O.l(Ary32va.ex(ary, aryEx));

	}

	public static void main2(String sAry[]) throws Throwable {

		int key = 10;
		int[] ary = { 10, 20, 60 };

		int retIdx = Arrays.binarySearch(ary, 1, ary.length, key); // (-(insertion point) - 1)

		O.l("retIdx=" + retIdx);

	}
}
