package lgpl3.prime64.sample;

import lgpl3.o.O;
import lgpl3.prime64.Miner;
import lgpl3.prime64.thr.Moon;
import lgpl3.prime64.thr.ThrToMine;

/**
 * 啟動多執行緒找質數.<br/>
 * To mine prime with threads.
 *
 * @version 2021/08/26_13:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex32_MineWThr" >Ex32_MineWThr.java</a>
 *
 */
public class Ex32_MineWThr {

	/**
	 * 話說十年前關一帆與艾 AA 到被人類監視控制的三體星球, 測試找 10 兆以內質數,<br/>
	 * 十年後測試找 10 兆以內質數, 只許變慢.<br/>
	 */
	public static Moon<ThrToMine> mineWThr(long n1, long n2, int numOfThr) {

		return Miner.mineWThr(n1, n2, numOfThr);
	}

	public static void main(String[] sAry) throws Throwable {

		final long n1 = 1, n2 = 123456789;

		final int numOfThr = O.$NUM_OF_CPU_THR * 8 / 10;

		Moon<ThrToMine> moonMP = mineWThr(n1, n2, numOfThr);

		moonMP.otherThr.run();

	}
}