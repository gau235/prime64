package lgpl3.prime64.thr;

import lgpl3.prime64.PrimeAry2D;

/**
 * The thread to add.<br/>
 * The thread to add.
 *
 * @version 2022/05/06_09:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=ThrToAddInPrimeAry2D" >
 *          ThrToAddInPrimeAry2D.java</a>
 *
 * @see ThrToInAry32OfCompoBitXy
 */
public class ThrToAddInPrimeAry2D extends Thread {

	// private static final Class<?> THIS = ThrToAddInPrimeAry2D.class;

	public PrimeAry2D primeAry2D;

	public long[][] ary2D;

	public long[] aryOfP;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrToAddInPrimeAry2D(PrimeAry2D primeAry2D, long[] aryOfP) {

		this.primeAry2D = primeAry2D;

		this.ary2D = primeAry2D.arr;

		this.aryOfP = aryOfP;

		// this.keyToSyn = primeAry2D.keyToSyn;

		start(); // auto start

	}

	@Override
	public void run() {

		if (aryOfP.length == 0)

			return;

		synchronized (primeAry2D.keyToSyn) { // not extLen

			ary2D[primeAry2D.i++] = aryOfP;
		}
	}
}
