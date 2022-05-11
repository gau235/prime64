package lgpl3.prime64.thr;

import lgpl3.o.O;
import lgpl3.prime64.Etchva;

/**
 * 找質數的執行緒.<br/>
 * The thread to mine and to count number of primes.
 *
 * @version 2021/08/22_16:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=ThrToEtch" >ThrToEtch.java</a>
 *
 * @see ThrToMine
 */
public class ThrToEtch extends Thread {

	private static final Class<?> THIS = ThrToEtch.class;

	public static final int RANGE32_MINUS_1 = Etchva.RANGE32 - 1;

	public static final int BOUND32_TO_BREAK = 12;

	/**
	 * 原始的初數.<br/>
	 * The origin N1.
	 */
	public final long oriN1;

	/**
	 * 原始的末數.<br/>
	 * The origin N2.
	 */
	public final long oriN2;

	public long myN1;

	public final int numOfThr;

	public final int range32MulNumOfThr;

	public int myIdx;

	public Moon<ThrToEtch> moon;

	/**
	 * 找質數數目的執行緒的建構方法.<br/>
	 * Constructor.
	 */
	public ThrToEtch(long oriN1, long oriN2, int numOfThr, int myIdx, Moon<ThrToEtch> moon) {

		this.oriN1 = oriN1;

		this.oriN2 = oriN2;

		this.numOfThr = numOfThr;

		this.myN1 = oriN1;

		this.range32MulNumOfThr = Etchva.RANGE32 * numOfThr;

		this.myIdx = myIdx;

		this.moon = moon;

		start(); // auto start

	}

	@Override
	public void run() {

		//
		// 1~ 350 range=100 countToBreak=2
		// thr1 1~100
		// thr2 101~200
		//
		// thr1 201~300
		// thr2 301~400
		//
		// thr1 401~500 xxx

		long myN2 = myN1 + RANGE32_MINUS_1;

		int count32 = 0;

		final Object keyToSyn = moon.keyToSyn;

		for (int count32ToBreak = 0; myN2 < oriN2;) {

			if (count32ToBreak++ == BOUND32_TO_BREAK)
				break;

			count32 += Etchva.countPAftEtch(myN1, myN2);

			// O.lD(getName(), THIS);

			// new ThrToInAry32OfCompoBitXy(ary32OfCompoBitXy, ary32OfCompoBitWr).start();

			myN1 += range32MulNumOfThr;
			myN2 = myN1 + RANGE32_MINUS_1;

		}

		synchronized (keyToSyn) {

			moon.totalP += count32;
		}

		// O.lD("myIdx=" + myIdx + ", myN1=" + O.f(myN1) + ", myN2=" + O.f(myN2), THIS);

		if (myN1 <= oriN2) {

			if (myN2 >= oriN2) { // the rest part

				if (O.isDev)
					O.l("tail idx=" + myIdx, THIS);

				count32 = Etchva.countPAftEtch(myN1, oriN2);

				synchronized (keyToSyn) {

					moon.totalP += count32;
				}

				return;

			} else
				moon.aryOfThr[myIdx] = new ThrToEtch(myN1, oriN2, numOfThr, myIdx, moon);

		}
	}
}