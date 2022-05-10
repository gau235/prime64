package lgpl3.comb.powerSet.sample;

import lgpl3.o.O;

/**
 * To give change.<br/>
 * 貪婪法 vs 動態規劃.
 *
 * @version 2021/12/26_15:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex10_GiveChange_2Loop" >
 *          Ex10_GiveChange_2Loop.java</a>
 *
 */
public class Ex10_GiveChange_2Loop {

	public static int[] allCoin = { 50, 30, 20, 15, 10, 2, 1, 1, 1 };
	// static int[] allCoin = { 50, 20, 20, 15, 10, 2, 1, 1, 1 };

	public static void main(String[] sAry) {

		int targetV = 75;

		for (int bigI = 0; bigI != allCoin.length; bigI++) {

			int tmp = targetV - allCoin[bigI];
			String prefix = allCoin[bigI] + " ";

			O.l("bigI=" + bigI + " tmp=" + tmp);

			for (int idx = bigI + 1; idx != allCoin.length; idx++) {

				if (allCoin[idx] <= tmp) {

					tmp -= allCoin[idx];
					prefix += (allCoin[idx] + " ");

					if (tmp == 0) {

						O.l("ok=" + prefix);

						break;

					}
				}
			}
		}
	}
}