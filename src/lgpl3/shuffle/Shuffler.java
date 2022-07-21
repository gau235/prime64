package lgpl3.shuffle;

import java.util.concurrent.ThreadLocalRandom;

import lgpl3.b64.B64va;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Ary32va;

/**
 * To shuffle the array.<br/>
 * To shuffle the array.
 *
 * @version 2022/06/25_10:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Shuffler" >src</a>
 *
 */
public abstract class Shuffler extends Shuffler_A {

	// private static final Class<?> THIS = Shuffler.class;

	/**
	 * To shuffle then to pick.
	 */
	public static int pickKNRetB32As2Pow(int n, int k) { // C(63,k)

		if (k >= (n >>> 1))

			O.x("k=" + k);

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		int nMul32 = (n << 5), tmp, ret = 0b0; // 寬鬆

		do {
			tmp = (0b1 << (rnd.nextInt(nMul32) >>> 5));

			if ((tmp & ret) != 0b0) // O.l("tmp=" + tmp, THIS);

				continue;

			if (B64va.countOf1(ret |= tmp) == k)

				break;

		} while (B.I);

		return ret;

	}

	/**
	 * To shuffle then to pick.
	 */
	// ary32.length 最大長度 64, every ary32[i] 最大值 63, k 最大長度 10
	public static long pickKNRetB64W6(int[] ary32, int k) {

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		int idx, lenMul8 = (ary32.length << 3); // 寬鬆

		long tmp, kept = 0b0L, ret = 0b0L;

		do {
			idx = rnd.nextInt(lenMul8) >>> 3;
			tmp = (0b1L << idx);

			if ((tmp & kept) != 0b0L) // O.l("tmp=" + tmp, THIS);

				continue;

			ret <<= B64W6.$6;
			ret |= ary32[idx];

			if (B64va.countOf1(kept |= tmp) == k)

				break;

		} while (B.I);

		return ret;

	}

	/**
	 * To shuffle then to pick.
	 */
	// every ary32[i] 最大值 63 and k 最大長度 10
	public static long pickKNRetB64W6(int[] sortedAry32, int k, int[] exSortedAry32) {

		return pickKNRetB64W6(Ary32va.ex(sortedAry32, exSortedAry32), k);
	}

	/**
	 * To shuffle then to pick.<br/>
	 * To shuffle then to pick.
	 */
	public static int[] pickK(int[] ary32, int k) {

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		int idx, lenMul8 = (ary32.length << 3) /* 寬鬆 */, ret[] = new int[k], iRet = 0;

		long tmp, kept = 0b0L;

		do {
			idx = rnd.nextInt(lenMul8) >>> 3;
			tmp = (0b1L << idx);

			if ((tmp & kept) != 0b0L) // O.l("tmp=" + tmp, THIS);

				continue;

			ret[iRet++] = ary32[idx];

			if (B64va.countOf1(kept |= tmp) == k)

				break;

		} while (B.I);

		return ret;

	}

	/**
	 * To shuffle then to pick.<br/>
	 * To shuffle then to pick.
	 */
	public static String[] pickK(String[] sAry, int k) {

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		int idx, lenMul8 = (sAry.length << 3) /* 寬鬆 */, iRet = 0;

		long tmp, kept = 0b0L;

		String[] ret = new String[k];

		do {
			idx = rnd.nextInt(lenMul8) >>> 3;
			tmp = (0b1L << idx);

			if ((tmp & kept) != 0b0L) // O.l("tmp=" + tmp, THIS);

				continue;

			ret[iRet++] = sAry[idx];

			if (B64va.countOf1(kept |= tmp) == k)

				break;

		} while (B.I);

		return ret;

	}
}
