package lgpl3.prime64.thr;

import lgpl3.prime64.Ary32OfCompoBitWr;
import lgpl3.prime64.Ary32OfCompoBitXy;

/**
 * The thread to add.<br/>
 * The thread to add.
 *
 * @version 2021/08/21_13:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=ThrToInAry32OfCompoBitXy"
 *          >ThrToInAry32OfCompoBitXy.java</a>
 *
 * @see ThrToAddInPrimeAry2D
 */
public class ThrToInAry32OfCompoBitXy extends Thread {

	// private static final Class<?> THIS = ThrToInAry32OfCompoBitXy.class;

	public Ary32OfCompoBitXy ary32OfCompoBitXy;

	public Ary32OfCompoBitWr[] theArr;

	public Ary32OfCompoBitWr ary32OfCompoBitWr;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrToInAry32OfCompoBitXy(Ary32OfCompoBitXy ary32OfCompoBitXy, Ary32OfCompoBitWr ary32OfCompoBitWr) {

		this.ary32OfCompoBitXy = ary32OfCompoBitXy;

		this.theArr = ary32OfCompoBitXy.arr;

		this.ary32OfCompoBitWr = ary32OfCompoBitWr;

		start(); // auto start

	}

	@Override
	public void run() {

		synchronized (ary32OfCompoBitXy.keyToSyn) { // not extLen

			theArr[ary32OfCompoBitXy.i++] = ary32OfCompoBitWr;
		}
	}
}
