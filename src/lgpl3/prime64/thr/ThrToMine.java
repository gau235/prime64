package lgpl3.prime64.thr;

import lgpl3.prime64.GuessFromGauss;
import lgpl3.prime64.Miner;
import lgpl3.prime64.PrimeAry2D;

/**
 * 找質數的執行緒.<br/>
 * The thread to mine and to count number of primes.
 *
 * @version 2021/08/22_16:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=ThrToMine" >ThrToMine.java</a>
 *
 * @see ThrToEtch
 */
public class ThrToMine extends Thread {

	// private static final Class<?> THIS = ThrToMine.class;

	/**
	 * 初數.<br/>
	 * bigN1.
	 */
	public long bigN1;

	/**
	 * 原始的末數.<br/>
	 * The origin N2.
	 */
	public final long oriN2;

	public final long bigN2;

	public final int numOfThr;

	public final int bigRange32;

	public final int bigRange32Minus1;

	public final int bigRange32MulNumOfThr;

	public final ThrToMine[] aryOfThr;

	public int myIdx;

	public final PrimeAry2D primeAry2D;

	public int count32;

	/**
	 * 找質數數目的執行緒的建構方法.<br/>
	 * Constructor.
	 */
	public ThrToMine(long fromN, long oriN2, int numOfThr, int bigRange32, ThrToMine[] aryOfThr, PrimeAry2D primeAry2D, int myIdx) {

		bigN1 = fromN; // bigN1 already <= originToNum

		this.oriN2 = oriN2;

		this.numOfThr = numOfThr;

		this.bigRange32 = bigRange32;

		this.bigRange32Minus1 = bigRange32 - 1;

		this.bigRange32MulNumOfThr = bigRange32 * numOfThr;

		bigN2 = bigN1 + bigRange32Minus1;

		this.aryOfThr = aryOfThr;

		this.primeAry2D = primeAry2D;

		this.myIdx = myIdx;

		start(); // auto start

	}

	@Override
	public void run() {

		long n1;

		int range32;
		int range32Minus1;

		long n2;

		// KeyToSyn keyToSyn = primeAry2D.keyToSyn;
		// long[][] ary2D = primeAry2D.arr;
		// int iLen = primeAry2D.iLen;

		if (bigN2 >= oriN2) {

			n1 = bigN1;
			// long range = 10_000L;
			range32 = GuessFromGauss.range32ToMinePrime(n1);
			// O.lD("range32=" + O.f(range32), THIS);

			range32Minus1 = range32 - 1;
			n2 = n1 + range32Minus1;

			for (; n2 < oriN2;) {

				new ThrToAddInPrimeAry2D(primeAry2D, Miner.mineNRetAry(n1, n2));

				n1 += range32;
				n2 = n1 + range32Minus1;

			}

			// the rest part
			if (n1 <= oriN2) {

				new ThrToAddInPrimeAry2D(primeAry2D, Miner.mineNRetAry(n1, oriN2));

				return;

			}

		} else { // bigN2 < oriN2

			n1 = bigN1;
			// long range = 10_000L;
			range32 = GuessFromGauss.range32ToMinePrime(n1);
			// O.lD("range32=" + O.f(range32) + " n1=" + O.f(n1), THIS);

			range32Minus1 = range32 - 1;
			n2 = n1 + range32Minus1;

			for (; n2 < bigN2;) {

				new ThrToAddInPrimeAry2D(primeAry2D, Miner.mineNRetAry(n1, n2));

				n1 += range32;
				n2 = n1 + range32Minus1;

			}

			// the rest part
			if (n1 <= bigN2)
				new ThrToAddInPrimeAry2D(primeAry2D, Miner.mineNRetAry(n1, bigN2));

			if ((bigN1 += bigRange32MulNumOfThr) <= oriN2) { // newThrToMine.setDaemon(B.I);

				aryOfThr[myIdx] = new ThrToMine(bigN1, oriN2, numOfThr, bigRange32, aryOfThr, primeAry2D, myIdx);
			}
		}
	}
}