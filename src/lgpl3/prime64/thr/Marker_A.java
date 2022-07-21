package lgpl3.prime64.thr;

import lgpl3.o.thr.ThrWBox;

/**
 * To mark primes.<br/>
 * To mark primes.
 *
 * @version 2021/09/01_08:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Marker_A" >Marker_A.java</a>
 *
 * @see Marker_L
 */
public abstract class Marker_A extends ThrWBox<int[]> {

	// private static final Class<?> THIS = Marker_A.class;

	/**
	 * The head number.<br/>
	 * The head number.
	 */
	public long headN = 1L;

	/**
	 * The tail number.<br/>
	 * The tail number.
	 */
	public long tailN;

	/**
	 * The square root.<br/>
	 * The square root.
	 */
	public int sqrt32OfTailNPlus1;

	/**
	 * The divisor as marker.<br/>
	 * The divisor as marker.
	 */
	public int div32 = 3;

	/**
	 * The offset.<br/>
	 * The offset.
	 */
	public int offset;

}
