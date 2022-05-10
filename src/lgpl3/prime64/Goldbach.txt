package lgpl3.prime64;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * Goldbach's Conjecture.<br/>
 * Goldbach's Conjecture.
 *
 * @version 2021/09/21_13:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Miner_Y" >Miner_Y.java</a>
 *
 * @see Miner
 */
public abstract class Goldbach {

	private static final Class<?> THIS = Goldbach.class;

	public static long[] oriAryOfP = Miner.oriAryOfP;

	/**
	 * Is the key in the array?<br/>
	 * Is the key in the array?
	 */
	public static boolean isInOriAryOfP(long key) { // biSearch

		int iLeft = 0, iRight = oriAryOfP.length - 1, iMid;

		long vMid;

		while (iLeft <= iRight) {

			vMid = oriAryOfP[iMid = (iRight + iLeft) >>> 1];

			if (vMid == key)

				return B.I;

			if (vMid < key)

				iLeft = iMid + 1;
			else
				iRight = iMid - 1; // vMid > key

		}

		return B.O;

	}

	/**
	 * Goldbach's Conjecture.<br/>
	 * 任一大於 7 的奇數都可以表示為三個奇素數之和.
	 */
	public static long[] conjOdd(long n) {

		// with nature aryOfP, i1 starts from 1
		// with odd aryOfP, i1 starts from 0

		int i1 = 1, i2;

		long p1, p2, p3;

		do {
			p1 = oriAryOfP[(i2 = i1++)];

			do {
				p2 = oriAryOfP[i2++];
				p3 = n - (p2 + p1);

				if (O.isDev)

					O.l("p1=" + p1 + " p2=" + p2 + " p3=" + p3, THIS);

				if (p2 > p3)
					break;

				B.n32++;

				if (isInOriAryOfP(p3))

					return new long[] { p1, p2, p3 };

			} while (B.I);

		} while (B.I);

	}

	/**
	 * Goldbach's Conjecture.<br/>
	 * Goldbach's Conjecture.
	 */
	public static long conj(long n) {

		// with nature aryOfP, i1 starts from 1
		// with odd aryOfP, i1 starts from 0
		int idx = 1;
		long p;

		do
			if (isInOriAryOfP(n - (p = oriAryOfP[idx++])))

				return p;

		while (B.I);

	}
}
