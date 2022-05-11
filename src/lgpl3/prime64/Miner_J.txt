package lgpl3.prime64;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * @version 2021/08/27_23:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Miner_J" >Miner_J.java</a>
 *
 * @see Miner_Y
 */
public abstract class Miner_J extends Miner_D {

	private static final Class<?> THIS = Miner_J.class;

	/**
	 * 找出輸入兩正整數之間所含質數, 裝入陣列回傳.<br/>
	 * To mine all primes between n1 and n2(both inclusive).
	 */
	public static long[] mineNRetAry(long n1, long n2) {

		int lenByGuess = GuessFromGauss.guessTotalPNRetInt32(n1, n2);

		// O.lD("lenByGuess=" + O.f(lenByGuess), THIS);

		long[] retAry = new long[lenByGuess];

		int iKeep = 0;

		int tmp32Not0;

		boolean b4;

		if (n1 != 2L)
			n1 |= 0b1; // important, 1 ~ 1 will not do

		if (n1 <= 17) {

			if (n1 <= 2L && n2 > 1L) { // for n= 1~ 2

				retAry[iKeep++] = 2L;
				n1 = 3L;

			}

			if (n2 <= 17) {

				for (; n1 <= n2; n1 += 2) {

					if (n1 == 3L || n1 == 5L || n1 == 7L || n1 == 11L || n1 == 13L || n1 == 17L)
						retAry[iKeep++] = n1;

				}

			} else { // n2 > 17

				for (; n1 <= 17; n1 += 2) {

					if (n1 == 3L || n1 == 5L || n1 == 7L || n1 == 11L || n1 == 13L || n1 == 17L)
						retAry[iKeep++] = n1;

				}
			}
		}

		if ((tmp32Not0 = (int) (n1 % 6)) == 1) // 6n + 1
			b4 = B.I;

		else {

			if (tmp32Not0 == 3) // 6n + 3
				n1 += 2; // 6n + 5

			b4 = B.O; // 6n + 5

		}

		b4 = !b4; // important

		// O.lD("retAry=", THIS);
		// O.lD(retAry, THIS);

		if (n2 < Ranger.$2POW31_MINUS1) {

			int n1_32 = (int) n1;
			int n2_32 = (int) n2;

			for (; n1_32 <= n2_32; n1_32 += ((b4 = !b4) ? 4 : 2)) {

				// O.lD("n1_32=" + O.f(n1_32) + O.L + "b4=" + b4, THIS);

				if ((n1_32 % 3 == 0) || (n1_32 % 5 == 0) || (n1_32 % 7 == 0) || (n1_32 % 11 == 0) || (n1_32 % 13 == 0))
					continue;

				if (testPrime32FromDiv17(n1_32)) {

					if (iKeep == lenByGuess) {

						lenByGuess = lenByGuess + (lenByGuess >>> 6) + 64;

						System.arraycopy(retAry, 0, (retAry = new long[lenByGuess]), 0, iKeep);

						if (O.isDev)
							O.l("N1=" + O.f(n1) + " N2=" + O.f(n2) + " n1=" + O.f(n1_32) + " n2=" + O.f(n2_32) + " oldL=" + O.f(iKeep)
									+ " newL=" + O.f(lenByGuess) + " difL=" + O.f(lenByGuess - iKeep), THIS); // maybe again

					}

					retAry[iKeep++] = n1_32;

				}
			}

		} else {

			for (; n1 <= n2; n1 += ((b4 = !b4) ? 4 : 2)) {

				if (((int) (n1 % 3) == 0) || ((int) (n1 % 5) == 0) || ((int) (n1 % 7) == 0) || ((int) (n1 % 11) == 0)
						|| ((int) (n1 % 13) == 0))
					continue;

				if (testPrimeFromDiv17(n1)) {

					if (iKeep == lenByGuess) {

						lenByGuess = lenByGuess + (lenByGuess >>> 6) + 64;

						System.arraycopy(retAry, 0, (retAry = new long[lenByGuess]), 0, iKeep);

						if (O.isDev)
							O.l("N1=" + O.f(n1) + " N2=" + O.f(n2) + " n1=" + O.f(n1) + " n2=" + O.f(n2) + " oldL=" + O.f(iKeep) + " newL="
									+ O.f(lenByGuess) + " difL=" + O.f(lenByGuess - iKeep), THIS); // maybe again

					}

					retAry[iKeep++] = n1;

				}
			}
		}

		//////////////////////////////

		// if (!O.isDev)
		// return O.delTailAll0(retAry);

		// O.lD("retAry L=" + retAry.length, THIS);
		// O.lD("tmp32Not0=" + lenByGuess, THIS);

		for (tmp32Not0 = lenByGuess; --tmp32Not0 >= 0;) {

			if (retAry[tmp32Not0] != 0L)
				break;

		}

		if (++tmp32Not0 != lenByGuess) // 縮短陣列
			System.arraycopy(retAry, 0, (retAry = new long[tmp32Not0]), 0, tmp32Not0);

		//////////////////////////////

		// O.lD(retAry, THIS);

		return retAry;

	}

	/**
	 * 找出輸入兩正整數之間所含質數數目.<br/>
	 * To count the number of primes between n1 and n2.<br/>
	 * If n1 is 1, then it will be π(n2)
	 */
	public static int countP(long n1, long n2) { // return int32

		// Ranger.checkBetween(n1, 1, n2);

		int count = 0;

		int tmp32Not0;

		boolean b4;

		if (n1 != 2L)
			n1 |= 0b1; // important, 1 ~ 1 will not do

		if (n1 <= 17) {

			if (n1 <= 2L && n2 > 1L) { // for n= 1~ 2

				count++;
				n1 = 3L;

			}

			if (n2 <= 17) {

				for (; n1 <= n2; n1 += 2) {

					if (n1 == 3L || n1 == 5L || n1 == 7L || n1 == 11L || n1 == 13L || n1 == 17L)
						count++;

				}

			} else { // n2 > 17

				for (; n1 <= 17; n1 += 2) {

					if (n1 == 3L || n1 == 5L || n1 == 7L || n1 == 11L || n1 == 13L || n1 == 17L)
						count++;

				}
			}
		}

		if ((tmp32Not0 = (int) (n1 % 6)) == 1) // 6n + 1
			b4 = B.I;

		else {

			if (tmp32Not0 == 3) // 6n + 3
				n1 += 2; // 6n + 5

			b4 = B.O; // 6n + 5

		}

		b4 = !b4; // important

		if (n2 < Ranger.$2POW31_MINUS1) {

			int n1_32 = (int) n1;
			int n2_32 = (int) n2;

			// O.lD("n1_32" + n1_32 + " n2_32=" + n2_32, THIS);

			for (; n1_32 <= n2_32; n1_32 += ((b4 = !b4) ? 4 : 2)) {

				if ((n1_32 % 3 == 0) || (n1_32 % 5 == 0) || (n1_32 % 7 == 0) || (n1_32 % 11 == 0) || (n1_32 % 13 == 0))
					continue;

				if (testPrime32FromDiv17(n1_32))
					count++;

			}

		} else {

			for (; n1 <= n2; n1 += ((b4 = !b4) ? 4 : 2)) {

				if (((int) (n1 % 3) == 0) || ((int) (n1 % 5) == 0) || ((int) (n1 % 7) == 0) || ((int) (n1 % 11) == 0)
						|| ((int) (n1 % 13) == 0))
					continue;

				if (testPrimeFromDiv17(n1))
					count++;

			}
		}

		return count;

	}
}
