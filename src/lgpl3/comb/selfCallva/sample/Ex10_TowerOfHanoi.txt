package lgpl3.comb.selfCallva.sample;

import lgpl3.comb.selfCallva.Recur;
import lgpl3.o.O;

/**
 * 河內塔的演算法, 將有盤子的柱子 A, 搬動到柱子 B, 搬動的過程中可利用柱子 T.<br/>
 * Tower Of Hanoi recursion.
 *
 * @version 2020/01/25_21:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex10_TowerOfHanoi" >Ex10_TowerOfHanoi. java</a>
 *
 */
public class Ex10_TowerOfHanoi {

	public static void main(String[] sAry) throws Throwable {

		StringBuilder str = Recur.towerOfHanoi('A', 'B', 'T', 3);

		O.l(str);

	}
}
