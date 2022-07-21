package lgpl3.prime64;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.prime64.thr.Marker;
import lgpl3.prime64.thr.Moon;
import lgpl3.prime64.thr.PeerByThrToEtch;
import lgpl3.prime64.thr.ThrToEtch;

/**
 * @version 2022/05/04_19:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Etchva" >src</a>
 *
 * @see Marker
 */
public abstract class Etchva {

	private static final Class<?> THIS = Etchva.class;

	/**
	 * 初始化時會找 1 ~ $INIT_TAIL_N32_FOR_MY_ARY32_OF_P 的質數.<br/>
	 * The tail prime of origin array of prime.
	 */
	public static final int $INIT_TAIL_N32_FOR_MY_ARY32_OF_P = 370_759;

	/**
	 * 找質數的人初始化時會找 1 ~ $INIT_TAIL_N32_FOR_MY_ARY_OF_P 的質數.<br/>
	 * 用來裝這些質數的陣列的長度.<br/>
	 * The length of origin array of prime.
	 */
	public static final int $COUNT32_OF_P_LTE_INIT_TAIL_N32 = 31_580;

	/**
	 * 64 numbers per cell.<br/>
	 * 64 numbers per cell.
	 */
	public static final int $LOG2_OF_NUM_PER_CELL = 6;

	/**
	 * 找質數 EtchPrime 時所允許輸入最大數 .<br/>
	 * The maximum input number for etching primes.
	 */
	// public static final long $MAX_TEST_N_OVER_1_ARY32 = 137_438_953_279L;
	public static final long $MAX_TEST_N_OVER_1_ARY32 = (((long) (O.$MAX_LEN_OF_ARY - 1)) << 6) + 64L;
	// 137,438,953,216 ok
	// 137,438,953,217
	// 137,438,953,218
	// 137,438,953,278 this
	// 137_438_953_279L this
	// 137_438_953_280L

	/**
	 * 初始化 (質數) 陣列.<br/>
	 * To init the origin array of primes.
	 */
	public static int[] genMyAry32OfP() {

		int ret[] = new int[$COUNT32_OF_P_LTE_INIT_TAIL_N32], idx = 0, n32 = 5;

		ret[idx++] = 2; // fuck
		ret[idx++] = 3; // fuck

		for (boolean b4 = B.I; n32 <= $INIT_TAIL_N32_FOR_MY_ARY32_OF_P; n32 += ((b4 = !b4) ? 4 : 2))

			if (Miner.testPrime32(n32))

				ret[idx++] = n32; // keep it

		O.l("genMyAry32OfP maxP=" + O.f(ret[ret.length - 1]), THIS);

		return ret;

	}

	/**
	 * 內建的質數陣列.<br/>
	 * The inside origin array of prime.
	 */
	public static int[] myAry32OfP = genMyAry32OfP();

	/**
	 * The range.
	 */
	public static final int RANGE32 = 0b1 << 24;

	/**
	 * To etch.<br/>
	 * To etch.
	 */
	public static Ary32OfCompoBitWr etch(long headN, long tailN) {

		headN |= 0b1;

		if (((int) tailN & 0b1) == 0)

			tailN--;

		final int sqrt32OfTailNPlus1 = ((int) StrictMath.sqrt(tailN) + 1);

		final int[] ary32 = new int[(RANGE32 >>> $LOG2_OF_NUM_PER_CELL) + 1];

		final int offset = (int) (headN >>> $LOG2_OF_NUM_PER_CELL); // todo: minusOffset

		int div32 = 3;

		long divSq; // div * div

		int div32X2, tmp32;

		for (int idx = 1; div32 < sqrt32OfTailNPlus1; div32 = myAry32OfP[++idx]) {

			tmp32 = (div32 & 0b11_1111) >>> 1;

			divSq = (divSq = div32) * divSq; // convert to int64

			div32X2 = div32 << 1;

			if (divSq < headN) {

				divSq += (((headN - divSq) / div32X2)) * div32X2;

				if (divSq < headN)
					divSq += div32X2;

			}

			if (divSq <= tailN) {

				do { // (divSq >>> offsetPlus6) go err

					tmp32 = (((int) divSq) & 0b11_1111) >>> 1; // r=2 or r=3, the pos is 1

					ary32[((int) (divSq >>> $LOG2_OF_NUM_PER_CELL)) - offset] |= (0b1 << tmp32);

				} while ((divSq += div32X2) <= tailN);

			}
		}

		return new Ary32OfCompoBitWr(headN, tailN, ary32, offset);

	}

	/**
	 * To count.<br/>
	 * To count.
	 */
	public static int countPAftEtch(long headN, long tailN) {

		headN |= 0b1;

		if (((int) tailN & 0b1) == 0)

			tailN--;

		final int sqrt32OfTailNPlus1 = ((int) StrictMath.sqrt(tailN) + 1);

		final int[] ary32 = new int[(RANGE32 >>> $LOG2_OF_NUM_PER_CELL) + 1];

		final int offset = (int) (headN >>> $LOG2_OF_NUM_PER_CELL);

		int div32 = 3;

		long divSq; // div * div

		int div32X2, tmpAsCount32;

		for (int idx = 1; div32 < sqrt32OfTailNPlus1; div32 = myAry32OfP[++idx]) {

			tmpAsCount32 = (div32 & 0b11_1111) >>> 1;

			divSq = (divSq = div32) * divSq; // convert to int64

			div32X2 = div32 << 1;

			if (divSq < headN) {

				divSq += (((headN - divSq) / div32X2)) * div32X2;

				if (divSq < headN)
					divSq += div32X2;

			}

			if (divSq <= tailN) {

				do { // (divSq >>> offsetPlus6) go err

					tmpAsCount32 = (((int) divSq) & 0b11_1111) >>> 1; // r=2 or r=3, the pos is 1

					ary32[((int) (divSq >>> $LOG2_OF_NUM_PER_CELL)) - offset] |= (0b1 << tmpAsCount32);

				} while ((divSq += div32X2) <= tailN);

			}
		}

		///////////////////////////////////////////////////////////

		tmpAsCount32 = 0;

		zoneLittlePrime: {

			if (headN == 1L) {

				if (tailN == 1L)
					return 0;

				if (tailN == 2L)
					return 1;

				if (tailN == 3L)
					return 2;

				if (tailN >= 4L) {

					tmpAsCount32 = 2;
					headN = 5L;

					break zoneLittlePrime;

				}
			}

			if (headN == 2L) {

				if (tailN == 2L)
					return 1;

				if (tailN == 3L)
					return 2;

				if (tailN >= 4L) {

					tmpAsCount32 = 2;
					headN = 5L;

					break zoneLittlePrime;

				}
			}

			if (headN == 3L) {

				if (tailN == 3L)
					return 1;

				if (tailN >= 4L) {

					tmpAsCount32 = 1;
					headN = 5L;

					break zoneLittlePrime;

				}
			}
		}

		headN |= 0b1; // 4~4 not to do

		int tmp32Not0;
		boolean b4;

		// O.lD("headN=" + O.f(this.headN) + " count=" + O.f(tmpAsCount32), THIS);

		if ((tmp32Not0 = (int) (headN % 6)) == 1) // 6n + 1
			b4 = B.I;

		else {

			if (tmp32Not0 == 3) // 6n + 3
				headN += 2; // 6n + 5

			b4 = B.O; // 6n + 5

		}

		b4 = !b4; // important

		for (; headN <= tailN; headN += ((b4 = !b4) ? 4 : 2)) {

			tmp32Not0 = (((int) headN) & 0b11_1111) >>> 1;

			if (((ary32[((int) (headN >>> 6)) - offset] >>> tmp32Not0) & 0b1) == 0b0)
				tmpAsCount32++;

		}

		// O.lD("headN=" + O.f(headN) + " tailN=" + O.f(tailN) + " count=" + O.f(tmpAsCount32), THIS);

		return tmpAsCount32;

	}

	/**
	 * 啟動多執行緒找 n1 ~ n2 間所有質數.<br/>
	 * To mine all primes between n1 and n2 (both inclusive) with threads.
	 */
	public static Moon<ThrToEtch> etchWThr(final long n1, final long n2, final int numOfThr) {

		////////////////////////////////
		ThrToEtch[] aryOfThr = new ThrToEtch[numOfThr];
		Moon<ThrToEtch> moon = new Moon<ThrToEtch>();

		long myN1;
		int idx = 0;
		for (; idx != numOfThr; idx++) {

			if ((myN1 = n1 + (RANGE32 * idx)) <= n2)

				aryOfThr[idx] = new ThrToEtch(myN1, n2, numOfThr, idx, moon);
			else
				break;

		}

		///////////////////////////////////////////// delTailAllNull

		idx = aryOfThr.length - 1;
		for (; idx != -1; idx--)
			if (aryOfThr[idx] != null)
				break;

		if (++idx != aryOfThr.length) // 縮短陣列情況下可用這個
			System.arraycopy(aryOfThr, 0, (aryOfThr = new ThrToEtch[idx]), 0, idx);

		/////////////////////////////////////////////

		moon.oriN1 = n1;
		moon.oriN2 = n2;
		moon.numOfThr = numOfThr;

		moon.aryOfThr = aryOfThr;

		moon.ary32OfCompoBitXy = new Ary32OfCompoBitXy();

		moon.otherThr = new PeerByThrToEtch(moon);

		return moon;

	}
}
