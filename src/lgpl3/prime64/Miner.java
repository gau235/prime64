package lgpl3.prime64;

import lgpl3.o.O;
import lgpl3.prime64.thr.Moon;
import lgpl3.prime64.thr.PeerByThrToMine;
import lgpl3.prime64.thr.ThrToMine;

/**
 * 本類別找質數的人.<br/>
 * 在找質數的人類別撰寫完後, 我發現要將找一段質數這件大工作分成一小段一小段找, 每次只找一小段區間質數, 放入質數隊伍,<br/>
 * 繼續找下一小段區間質數.<br/>
 * 所以質數卵就是由找質數的人, 質數隊伍, 找質數的執行緒, 縱貫構成.<br/>
 * <br/>
 * To mine prime by threads.
 *
 * @version 2022/04/30_13:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Miner" >Miner.java</a>
 *
 * @see PrimeAry2D
 *
 * @see Etchva
 */
public abstract class Miner extends Miner_Y {

	private static final Class<?> THIS = Miner.class;

	/**
	 * To get the GCD then to print.<br/>
	 * To get the GCD then to print.
	 */
	public static long gcdNPrint(long x, long y) { // 原創

		if (x > y) {

			long tmp = x;
			x = y;
			y = tmp;

		}

		long div = 2L, gcd = 1L;

		int idx = 0;

		for (O.xy(x, y); x != 1L && div <= x;) {

			if (x % div == 0L && y % div == 0L) {

				x /= div;
				y /= div;

				gcd *= div;

				O.l(div + " | " + x + O.STR_C44C32 + y);

				continue;

			}

			div = oriAryOfP[++idx];

		}

		O.l("gcd=" + gcd, THIS);

		return gcd;

	}

	/**
	 * 檢查參數合法性.<br/>
	 * Is the argument legal?
	 */
	public static void checkArgBefMine(long n1, long n2, int numOfThr) {

		Ranger.checkBetween(n1, 1, n2);
		Ranger.checkBetween(n2, n1, Miner.curMaxNToTest());

		if (numOfThr < 1)
			O.x();

	}

	/**
	 * 啟動多執行緒找 n1 ~ n2 間所有質數.
	 */
	public static Moon<ThrToMine> mineWThr(long n1, long n2, int numOfThr) {

		final int bigRange32 = GuessFromGauss.bigRange32ForThrToMinePrime(n1);

		ThrToMine[] aryOfThr = new ThrToMine[numOfThr];
		PrimeAry2D pAry2D = new PrimeAry2D();

		long bigN1;
		int idx = 0;
		for (; idx != numOfThr; idx++) {

			bigN1 = n1 + (bigRange32 * idx); // n1 + (bigRange32 * idx) may be > 2^63-1

			if (bigN1 <= n2)

				aryOfThr[idx] = new ThrToMine(bigN1, n2, numOfThr, bigRange32, aryOfThr, pAry2D, idx);
			else
				break;

		}

		///////////////////////////////////////////// delTailAllNull

		idx = aryOfThr.length - 1;
		for (; idx != -1; idx--)
			if (aryOfThr[idx] != null)
				break;

		if (++idx != aryOfThr.length) // 縮短陣列情況下可用這個
			System.arraycopy(aryOfThr, 0, (aryOfThr = new ThrToMine[idx]), 0, idx);

		/////////////////////////////////////////////

		Moon<ThrToMine> moon = new Moon<ThrToMine>();

		moon.oriN1 = n1;
		moon.oriN2 = n2;
		moon.numOfThr = numOfThr;

		moon.aryOfThr = aryOfThr;
		moon.primeAry2D = pAry2D;

		moon.otherThr = new PeerByThrToMine(moon);

		return moon;

	}
}
