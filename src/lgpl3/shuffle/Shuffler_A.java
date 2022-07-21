package lgpl3.shuffle;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Ary2D;
import lgpl3.o.ary.Seq;

/**
 * To shuffle the array.<br/>
 * To shuffle the array.
 *
 * @version 2022/06/05_14:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Shuffler_A" >src</a>
 *
 * @see Shuffler
 */
public abstract class Shuffler_A {

	// private static final Class<?> THIS = Shuffler_A.class;

	public static final int N_TO_SHIFT = 48; // limited len of ary

	public static final long MASK = ~(-0b1L << N_TO_SHIFT);
	// MASK = 0000_0000_0000_0000_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111

	public static final int RANGE32 = (0b1 << (64 - N_TO_SHIFT)); // 65_536

	/**
	 * To shuffle.
	 */
	public static long[] shuffle(long[] ary) {

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		int bound = ary.length << 3; // 適用短陣列

		long tmp;
		for (int idx = 0, newIdx; idx != ary.length; idx++)

			if ((newIdx = (rnd.nextInt(bound) >>> 3)) != idx) {

				tmp = ary[idx];
				ary[idx] = ary[newIdx];
				ary[newIdx] = tmp;

			}

		return ary;

	}

	/**
	 * To shuffle.<br/>
	 * To shuffle.
	 */
	public static long[] shuffleByShift(long[] ary) { // element value limited 2 ^ 48

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		int idx;
		for (idx = ary.length - 1; idx >= 0; idx--)

			ary[idx] = (((long) rnd.nextInt(RANGE32)) << N_TO_SHIFT) | ary[idx];

		Arrays.sort(ary);

		for (idx = ary.length - 1; idx >= 0; idx--)

			ary[idx] &= MASK;

		return ary;

	}

	/**
	 * To shuffle.<br/>
	 * To shuffle.
	 */
	public static int[] shuffle(int[] ary32) {

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		int bound = ary32.length << 3; // 適用短陣列

		for (int idx = 0, newIdx, tmp32; idx != ary32.length; idx++)

			if ((newIdx = (rnd.nextInt(bound) >>> 3)) != idx) {

				tmp32 = ary32[idx];
				ary32[idx] = ary32[newIdx];
				ary32[newIdx] = tmp32;

			}

		return ary32;

	}

	/**
	 * To shuffle.<br/>
	 * To shuffle.
	 */
	public static Ary2D shuffle(Ary2D ary2D) {

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		int bound = ary2D.i << 3; // 適用短陣列

		long allAry[][] = ary2D.arr, tmpAry[];

		for (int idx = 0, newIdx; idx != ary2D.i; idx++)

			if ((newIdx = (rnd.nextInt(bound) >>> 3)) != idx) {

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

		int bound = arrOfSeq.i << 3; // 適用短陣列

		Seq allSeq[] = arrOfSeq.arr, tmpSeq;

		for (int idx = 0, newIdx; idx != arrOfSeq.i; idx++)

			if ((newIdx = (rnd.nextInt(bound) >>> 3)) != idx) {

				tmpSeq = allSeq[idx];
				allSeq[idx] = allSeq[newIdx];
				allSeq[newIdx] = tmpSeq;

			}

		return arrOfSeq;

	}

	/**
	 * To shuffle.<br/>
	 * To shuffle.
	 */
	public static String[] shuffle(String[] sAry) {

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		int bound = sAry.length << 3; // 適用短陣列

		String tmpS;
		for (int idx = 0, newIdx; idx != sAry.length; idx++)

			if ((newIdx = (rnd.nextInt(bound) >>> 3)) != idx) {

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

		int bound = charAry.length << 3; // 適用短陣列

		char tmpChar;
		for (int idx = 0, newIdx; idx != charAry.length; idx++)

			if ((newIdx = (rnd.nextInt(bound) >>> 3)) != idx) {

				tmpChar = charAry[idx];
				charAry[idx] = charAry[newIdx];
				charAry[newIdx] = tmpChar;

			}

		return charAry;

	}
}
