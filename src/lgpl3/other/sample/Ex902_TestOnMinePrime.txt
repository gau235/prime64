package lgpl3.other.sample;

import lgpl3.o.O;
import lgpl3.prime64.Miner;
import lgpl3.prime64.thr.Moon;
import lgpl3.prime64.thr.ThrToMine;

/**
 * 啟動多執行緒找質數.<br/>
 * To mine prime with threads.
 *
 * @version 2021/08/20_13:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex902_TestOnMinePrime" >
 *          Ex902_TestOnMinePrime.java</a>
 *
 */
public class Ex902_TestOnMinePrime {

	public static void main(String[] sAry) throws Throwable {

		Moon<ThrToMine> moonMP = Miner.mineWThr(1, 123456789, 8);

		moonMP.otherThr.run();

		O.eq(moonMP.primeAry2D.totalP(), 7_027_260);

		/////////////////////////////////////////////////////////

		O.eq(Miner.mineNRetAry(1, 1).length, 0);
		O.eq(Miner.mineNRetAry(1, 2).length, 1);
		O.eq(Miner.mineNRetAry(1, 3).length, 2);
		O.eq(Miner.mineNRetAry(1, 4).length, 2);

		O.eq(Miner.mineNRetAry(2, 2).length, 1);
		O.eq(Miner.mineNRetAry(2, 3).length, 2);
		O.eq(Miner.mineNRetAry(2, 4).length, 2);

		O.eq(Miner.mineNRetAry(3, 3).length, 1);
		O.eq(Miner.mineNRetAry(3, 4).length, 1);

		O.eq(Miner.mineNRetAry(4, 4).length, 0);

		if (Miner.mineNRetAry(10, 20).length != 4) {

			O.l(Miner.mineNRetAry(10, 20));
			O.x();

		}

		///////////////////////////////////////////////////////////////////////

		O.eq(Miner.mineNRetAry(2_147_483_645L, 2_147_483_645L).length, 0);
		O.eq(Miner.mineNRetAry(2_147_483_645L, 2_147_483_646L).length, 0);
		O.eq(Miner.mineNRetAry(2_147_483_645L, 2_147_483_647L).length, 1);
		O.eq(Miner.mineNRetAry(2_147_483_645L, 2_147_483_648L).length, 1);
		O.eq(Miner.mineNRetAry(2_147_483_645L, 2_147_483_649L).length, 1); // 2_147_483_645L

		O.eq(Miner.mineNRetAry(2_147_483_646L, 2_147_483_646L).length, 0);
		O.eq(Miner.mineNRetAry(2_147_483_646L, 2_147_483_647L).length, 1);
		O.eq(Miner.mineNRetAry(2_147_483_646L, 2_147_483_648L).length, 1);
		O.eq(Miner.mineNRetAry(2_147_483_646L, 2_147_483_649L).length, 1); // 2_147_483_646L

		O.eq(Miner.mineNRetAry(2_147_483_647L, 2_147_483_647L).length, 1);
		O.eq(Miner.mineNRetAry(2_147_483_647L, 2_147_483_648L).length, 1);
		O.eq(Miner.mineNRetAry(2_147_483_647L, 2_147_483_649L).length, 1); // 2_147_483_647L

		O.eq(Miner.mineNRetAry(2_147_483_648L, 2_147_483_648L).length, 0);
		O.eq(Miner.mineNRetAry(2_147_483_648L, 2_147_483_649L).length, 0); // 2_147_483_648L

		O.eq(Miner.mineNRetAry(2_147_483_649L, 2_147_483_649L).length, 0); // 2_147_483_649L

		///////////////////////////////////////////////////////////////////////

		O.eq(Miner.countP(1, 1), 0);
		O.eq(Miner.countP(1, 2), 1);
		O.eq(Miner.countP(1, 3), 2);
		O.eq(Miner.countP(1, 4), 2);

		O.eq(Miner.countP(2, 2), 1);
		O.eq(Miner.countP(2, 3), 2);
		O.eq(Miner.countP(2, 4), 2);

		O.eq(Miner.countP(3, 3), 1);
		O.eq(Miner.countP(3, 4), 1);

		O.eq(Miner.countP(4, 4), 0);

		O.eq(Miner.countP(10, 20), 4);
		O.eq(Miner.countP(100, 300), 37);

		///////////////////////////////////////////////////////////////////////

		O.eq(Miner.countP(2_147_483_645L, 2_147_483_645L), 0);
		O.eq(Miner.countP(2_147_483_645L, 2_147_483_646L), 0);
		O.eq(Miner.countP(2_147_483_645L, 2_147_483_647L), 1);
		O.eq(Miner.countP(2_147_483_645L, 2_147_483_648L), 1);
		O.eq(Miner.countP(2_147_483_645L, 2_147_483_649L), 1); // 2_147_483_645L

		O.eq(Miner.countP(2_147_483_646L, 2_147_483_646L), 0);
		O.eq(Miner.countP(2_147_483_646L, 2_147_483_647L), 1);
		O.eq(Miner.countP(2_147_483_646L, 2_147_483_648L), 1);
		O.eq(Miner.countP(2_147_483_646L, 2_147_483_649L), 1); // 2_147_483_646L

		O.eq(Miner.countP(2_147_483_647L, 2_147_483_647L), 1);
		O.eq(Miner.countP(2_147_483_647L, 2_147_483_648L), 1);
		O.eq(Miner.countP(2_147_483_647L, 2_147_483_649L), 1); // 2_147_483_647L

		O.eq(Miner.countP(2_147_483_648L, 2_147_483_648L), 0);
		O.eq(Miner.countP(2_147_483_648L, 2_147_483_649L), 0); // 2_147_483_648L

		O.eq(Miner.countP(2_147_483_649L, 2_147_483_649L), 0); // 2_147_483_649L

	}
}