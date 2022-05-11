package lgpl3.comb.sample;

import lgpl3.comb.DCirc;
import lgpl3.comb.PCirc;
import lgpl3.o.O;

/**
 * 全錯排.<br/>
 * 即 n 個人排成一列後解散再排成一列, 沒有人排在自己原先的位置的方法數.
 *
 * @version 2020/03/07_11:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=D35_DCircDiff" >D35_DCircDiff.java</a>
 *
 * @see DCirc
 */
public class D35_DCircDiff {

	public static void main(String[] sAry) throws Throwable {

		for (int i = 3; i != 21; i++)

			O.l("diff=" + O.f(PCirc.int64(i) - DCirc.int64(i)));

	}
}
