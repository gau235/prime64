package lgpl3.comb.powerSet.sample;

import lgpl3.o.O;

/**
 * To give change.<br/>
 * 貪婪法 vs 動態規劃.
 *
 * @version 2021/12/01_12:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex09_GiveChange_Greedy" >
 *          Ex09_GiveChange_Greedy.java</a>
 *
 */
public class Ex09_GiveChange_Greedy {

	public static int[] allCoin = { 50, 20, 20, 15, 10, 2, 1, 1, 1 };

	public static int targetV = 75;

	public static void main(String[] sAry) {

		String prefix = "";

		for (int idx = 0; idx != allCoin.length; idx++) {

			if (allCoin[idx] <= targetV) {

				targetV -= allCoin[idx];
				prefix += (allCoin[idx] + " ");

				if (targetV == 0) {

					O.l("ok=" + prefix);

					break;

				}
			}
		}
	}
}