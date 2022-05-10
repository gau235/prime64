package lgpl3.prime64.thr;

import lgpl3.prime64.Ary32OfCompoBitXy;
import lgpl3.prime64.PrimeAry2D;

/**
 * The dash board.<br/>
 * The dash board.
 *
 * @version 2021/10/02_10:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Moon" >Moon.java</a>
 */
public class Moon<T extends Thread> {

	public long oriN1;

	public long oriN2;

	public int numOfThr;

	public T[] aryOfThr;

	public PrimeAry2D primeAry2D;

	public Ary32OfCompoBitXy ary32OfCompoBitXy;

	public long totalP;

	public Thread otherThr;

	public Object tmpObj;

	/**
	 * 用於多執行緒的同步.<br/>
	 * For synchronizing.
	 */
	public final Object keyToSyn = new Object();

}