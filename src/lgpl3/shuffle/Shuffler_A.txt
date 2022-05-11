package lgpl3.shuffle;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Ary2D;
import lgpl3.o.ary.Seq;

/**
 * To shuffle the array.<br/>
 * To shuffle the array.
 *
 * @version 2021/06/05_14:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Shuffler_A" >Shuffler_A.java</a>
 *
 * @see Shuffler
 */
public abstract class Shuffler_A {

	// private static final Class<?> THIS = Shuffler_A.class;

	public static final int N_TO_SHIFT = 16; // limited len of ary

	public static final int MASK32 = ~(-0b1 << N_TO_SHIFT);

	public static final int RANGE32 = (0b1 << N_TO_SHIFT);

	/**
	 * To shuffle.<br/>
	 * To shuffle.
	 */
	public static long[] shuffle(long[] ary) {

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		long tmp;
		for (int idx = 0, len = ary.length, newIdx; idx != len; idx++)

			if ((newIdx = rnd.nextInt(len)) != idx) {

				tmp = ary[idx];
				ary[idx] = ary[newIdx];
				ary[newIdx] = tmp;

			}

		return ary;

	}

	/**
	 * To shuffle.<br/>
	 * 從外面多呼叫一次, 效能差.
	 */
	public static long[] shuffleIfGt(long[] ary, int bound) {

		if (O.intRnd1To100() > bound) {

			ThreadLocalRandom rnd = ThreadLocalRandom.current();

			bound = ary.length;

			long tmp;
			for (int idx = 0, newIdx; idx != bound; idx++)

				if ((newIdx = rnd.nextInt(bound)) != idx) {

					tmp = ary[idx];
					ary[idx] = ary[newIdx];
					ary[newIdx] = tmp;

				}
		}

		return ary;

	}

	/**
	 * To shuffle.<br/>
	 * To shuffle.
	 */
	public static long[] shuffleByShift(long[] ary) { // ary.length limited

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		int idx;
		for (idx = ary.length - 1; idx >= 0; idx--)

			ary[idx] = (rnd.nextInt(RANGE32) << N_TO_SHIFT) | ary[idx];

		Arrays.sort(ary);

		for (idx = ary.length - 1; idx >= 0; idx--)

			ary[idx] &= MASK32;

		return ary;

	}

	/**
	 * To shuffle.<br/>
	 * To shuffle.
	 */
	public static int[] shuffle(int[] ary32) {

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		for (int idx = 0, len = ary32.length, newIdx, tmp32; idx != len; idx++)

			if ((newIdx = rnd.nextInt(len)) != idx) {

				tmp32 = ary32[idx];
				ary32[idx] = ary32[newIdx];
				ary32[newIdx] = tmp32;

			}

		return ary32;

	}

	/**
	 * To shuffle.<br/>
	 * 從外面多呼叫一次, 效能差.
	 */
	public static int[] shuffleIfGt(int[] ary32, int bound) {

		if (O.intRnd1To100() > bound) {

			ThreadLocalRandom rnd = ThreadLocalRandom.current();

			bound = ary32.length;

			for (int idx = 0, newIdx, tmp32; idx != bound; idx++)

				if ((newIdx = rnd.nextInt(bound)) != idx) {

					tmp32 = ary32[idx];
					ary32[idx] = ary32[newIdx];
					ary32[newIdx] = tmp32;

				}
		}

		return ary32;

	}

	/**
	 * To shuffle.<br/>
	 * To shuffle.
	 */
	public static int[] shuffleByShift(int[] ary32) {

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		int idx;
		for (idx = ary32.length - 1; idx >= 0; idx--)

			ary32[idx] = (rnd.nextInt(RANGE32) << N_TO_SHIFT) | ary32[idx];

		Arrays.sort(ary32);

		for (idx = ary32.length - 1; idx >= 0; idx--)

			ary32[idx] &= MASK32;

		return ary32;

	}

	/**
	 * To shuffle.<br/>
	 * To shuffle.
	 */
	public static Ary2D shuffle(Ary2D ary2D) {

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		long[][] allAry = ary2D.arr;
		long[] tmpAry;
		for (int idx = 0, newIdx, bigLen = ary2D.iLen; idx != bigLen; idx++)

			if ((newIdx = rnd.nextInt(bigLen)) != idx) {

				tmpAry = allAry[idx];
				allAry[idx] = allAry[newIdx];
				allAry[newIdx] = tmpAry;

			}

		return ary2D;

	}

	/**
	 * To shuffle.<br/>
	 * To shuffle.
	 */
	public static Arr<Seq> shuffle(Arr<Seq> arrOfSeq) {

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		Seq[] allSeq = arrOfSeq.arr;
		Seq tmpSeq;
		for (int idx = 0, bigLen = arrOfSeq.iLen, newIdx; idx != bigLen; idx++)

			if ((newIdx = rnd.nextInt(bigLen)) != idx) {

				tmpSeq = allSeq[idx];
				allSeq[idx] = allSeq[newIdx];
				allSeq[newIdx] = tmpSeq;

			}

		return arrOfSeq;

	}

	/**
	 * To shuffle.<br/>
	 * 從外面多呼叫一次, 效能差.
	 */
	public static Arr<Seq> shuffleIfGt(Arr<Seq> arrOfSeq, int bound) {

		if (O.intRnd1To100() > bound) {

			ThreadLocalRandom rnd = ThreadLocalRandom.current();

			Seq[] allSeq = arrOfSeq.arr;
			Seq tmpSeq;
			for (int idx = 0, bigLen = arrOfSeq.iLen, newIdx; idx != bigLen; idx++)

				if ((newIdx = rnd.nextInt(bigLen)) != idx) {

					tmpSeq = allSeq[idx];
					allSeq[idx] = allSeq[newIdx];
					allSeq[newIdx] = tmpSeq;

				}
		}

		return arrOfSeq;

	}

	/**
	 * To shuffle.<br/>
	 * To shuffle.
	 */
	public static String[] shuffle(String[] sAry) {

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		String tmpS;
		for (int idx = 0, len = sAry.length, newIdx; idx != len; idx++)

			if ((newIdx = rnd.nextInt(len)) != idx) {

				tmpS = sAry[idx];
				sAry[idx] = sAry[newIdx];
				sAry[newIdx] = tmpS;

			}

		return sAry;

	}

	/**
	 * To shuffle.<br/>
	 * To shuffle.
	 */
	public static char[] shuffle(char[] charAry) {

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		char tmpChar;
		for (int idx = 0, len = charAry.length, newIdx; idx != len; idx++)

			if ((newIdx = rnd.nextInt(len)) != idx) {

				tmpChar = charAry[idx];
				charAry[idx] = charAry[newIdx];
				charAry[newIdx] = tmpChar;

			}

		return charAry;

	}
}
