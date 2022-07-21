package lgpl3.prime64.thr;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.prime64.GuessFromGauss;

/**
 * @version 2021/10/06_12:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Marker_L" >Marker_L.java</a>
 *
 * @see Marker
 */
public abstract class Marker_L extends Marker_A {

	private static final Class<?> THIS = Marker_L.class;

	/**
	 * To get the mark.<br/>
	 * To get the mark.
	 */
	public int b01InAry32OfCompoBit(long n) {

		// int rDiv2 = (((int) n) & 0b11_1111) >>> 1; // mod 64 嗎 當 r=2 or r=3, the pos is 1

		return (box[((int) (n >>> 6)) - offset] >>> ((((int) n) & 0b11_1111) >>> 1)) & 0b1;

	}

	/**
	 * To retrieve.<br/>
	 * To retrieve.
	 */
	public long[] retrieveP(long n1, long n2) {

		int lenByGuess = (GuessFromGauss.guessTotalPNRetInt32(n1, n2) << 1);
		long[] retAry = new long[lenByGuess];

		int iKeep = 0;

		zoneLittlePrime: {

			if (n1 == 1L) {

				if (n2 == 1L)
					return O.ARY0;

				if (n2 == 2L)
					return new long[] { 2L };

				if (n2 == 3L)
					return new long[] { 2L, 3L };

				if (n2 >= 4L) {

					retAry[iKeep++] = 2L;
					retAry[iKeep++] = 3L;

					n1 = 5L;

					break zoneLittlePrime;

				}
			}

			if (n1 == 2L) {

				if (n2 == 2L)
					return new long[] { 2L };

				if (n2 == 3L)
					return new long[] { 2L, 3L };

				if (n2 >= 4L) {

					retAry[iKeep++] = 2L;
					retAry[iKeep++] = 3L;

					n1 = 5L;

					break zoneLittlePrime;

				}
			}

			if (n1 == 3L) {

				if (n2 == 3L)
					return new long[] { 3L };

				if (n2 >= 4L) {

					retAry[iKeep++] = 3L;

					n1 = 5L;

					break zoneLittlePrime;

				}
			}
		}

		n1 |= 0b1; // 4~4 not to do

		int tmp32Not0;

		boolean b4;

		if ((tmp32Not0 = (int) (n1 % 6)) == 1) // 6n + 1

			b4 = B.I;
		else {

			if (tmp32Not0 == 3) // 6n + 3
				n1 += 2; // 6n + 5

			b4 = B.O; // 6n + 5

		}

		b4 = !b4; // important

		for (; n1 <= n2; n1 += ((b4 = !b4) ? 4 : 2)) { // 檢查 5 以上

			tmp32Not0 = (((int) n1) & 0b11_1111) >>> 1;

			if (((box[((int) (n1 >>> 6)) - offset] >>> tmp32Not0) & 0b1) == 0b0) {

				if (iKeep == lenByGuess) {

					if (O.isDev)
						O.l("aryIdxOutOfBound n1=" + O.f(n1) + " n2=" + O.f(n2) + " len=" + O.f(lenByGuess), THIS);

					System.arraycopy(retAry, 0, (retAry = new long[lenByGuess <<= 1]), 0, iKeep);

				}

				retAry[iKeep++] = n1;

			}
		}

		///////////////////////////////////////// O.delTailAll0

		for (tmp32Not0 = lenByGuess; --tmp32Not0 >= 0;)
			if (retAry[tmp32Not0] != 0L)
				break;

		if (++tmp32Not0 != lenByGuess) // 縮短陣列
			System.arraycopy(retAry, 0, (retAry = new long[tmp32Not0]), 0, tmp32Not0);

		/////////////////////////////////////////

		// O.l(retAry, THIS);

		return retAry;

	}

	/**
	 * 找出輸入兩正整數之間所含質數數目.<br/>
	 * To count the number of primes between n1 and n2.
	 */
	public long countP(long n1, long n2) { // return int64

		long count = 0;

		zoneLittlePrime: {

			if (n1 == 1L) {

				if (n2 == 1L)
					return 0L;

				if (n2 == 2L)
					return 1L;

				if (n2 == 3L)
					return 2L;

				if (n2 >= 4L) {

					count = 2L;
					n1 = 5L;

					break zoneLittlePrime;

				}
			}

			if (n1 == 2L) {

				if (n2 == 2L)
					return 1L;

				if (n2 == 3L)
					return 2L;

				if (n2 >= 4L) {

					count = 2L;
					n1 = 5L;

					break zoneLittlePrime;

				}
			}

			if (n1 == 3L) {

				if (n2 == 3L)
					return 1L;

				if (n2 >= 4L) {

					count = 1L;
					n1 = 5L;

					break zoneLittlePrime;

				}
			}
		}

		n1 |= 0b1; // 4~4 not to do

		int tmp32Not0;
		boolean b4;

		if (O.isDev)
			O.l("now n1=" + O.f(n1) + " count=" + O.f(count), THIS);

		if ((tmp32Not0 = (int) (n1 % 6)) == 1) // 6n + 1

			b4 = B.I;
		else {

			if (tmp32Not0 == 3) // 6n + 3
				n1 += 2; // 6n + 5

			b4 = B.O; // 6n + 5

		}

		b4 = !b4; // important

		for (; n1 <= n2; n1 += ((b4 = !b4) ? 4 : 2)) {

			tmp32Not0 = (((int) n1) & 0b11_1111) >>> 1;

			if (((box[((int) (n1 >>> 6)) - offset] >>> tmp32Not0) & 0b1) == 0b0)
				count++;

		}

		return count;

	}
}
