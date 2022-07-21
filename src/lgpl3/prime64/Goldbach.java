package lgpl3.prime64;

import lgpl3.o.B;

/**
 * Goldbach's Conjecture.<br/>
 * Goldbach's Conjecture.
 *
 * @version 2022/04/21_13:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Goldbach" >src</a>
 *
 * @see Miner
 */
public abstract class Goldbach extends Miner_A {

	private static final Class<?> THIS = Goldbach.class;

	/**
	 * 任一大於 7 的奇數都可以表示為三個奇素數之和.
	 */
	public static long[] decompoOdd(long n) {

		if (Miner.isInMyAryOfP(n))

			return new long[] { 0L, 0L, n };

		int idx1 = 1, idx2; // with nature aryOfP, idx1 starts from 1

		long p1, p2, p3;

		do {
			p1 = myAryOfP[(idx2 = idx1++)];

			do {
				p2 = myAryOfP[idx2++];
				p3 = n - (p2 + p1);

				// O.l("p1=" + p1 + " p2=" + p2 + " p3=" + p3, THIS);

				if (p2 > p3)

					break;

				B.n32++;

				if (isInMyAryOfP(p3))

					return new long[] { p1, p2, p3 };

			} while (B.I);

		} while (B.I);

	}

	/**
	 * 任一大於 7 的奇數都可以表示為三個奇素數之和.
	 */
	public static long easyDecompoOdd(long n) { // b64 for two 32 bit // 原創

		if (Miner.isInMyAryOfP(n))

			return 0b0L;

		int idx1 = 1, idx2; // with nature aryOfP, idx1 starts from 1

		long p1, p2, p3, ret = 0b0L;

		do {
			p1 = myAryOfP[(idx2 = idx1++)];

			do {
				if ((p2 = myAryOfP[idx2++]) > (p3 = n - (p2 + p1)))

					break;

				if (isInMyAryOfP(p3))

					return ret = (((ret | p2) << 32) | p1);

			} while (B.I);

		} while (B.I);

	}

	/**
	 * Goldbach's Conjecture.<br/>
	 * Goldbach's Conjecture.
	 */
	public static long decompo(long even) {

		int idx = 1; // with nature aryOfP, idx starts from 1
		long p;

		do
			if (isInMyAryOfP(even - (p = myAryOfP[idx++])))

				return p;

		while (B.I);

	}
}
