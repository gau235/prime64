package lgpl3.shuffle;

import java.util.concurrent.ThreadLocalRandom;

import lgpl3.b64.B64va;
import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.B;
import lgpl3.o.ary.Ary32va;

/**
 * To shuffle the array.<br/>
 * To shuffle the array.
 *
 * @version 2020/09/15_10:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Shuffler" >Shuffler.java</a>
 *
 */
public abstract class Shuffler extends Shuffler_A {

	// private static final Class<?> THIS = Shuffler.class;

	/**
	 * To shuffle then to pick.<br/>
	 * To shuffle then to pick.
	 */
	public static long pickKNRetB64W6(int[] ary32, int k) { // every ary32[i] <= 63 最大值 and k <= 10 長度

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		long keptB64 = 0b0L;

		long retB64 = 0b0L;

		int idx;
		int lenMul2 = (ary32.length << 1); // 寬鬆

		long tmp;

		do {

			idx = rnd.nextInt(lenMul2) >>> 1;
			tmp = (keptB64 | (0b1L << idx));
			// O.l("tmp=" + tmp , THIS);

			if (tmp == keptB64)
				continue;

			else {

				retB64 <<= B64W6.$6;
				retB64 |= ary32[idx];

				keptB64 = tmp;

			}

			if (B64va.countOf1(keptB64) == k)
				break;

		} while (B.I);

		return retB64;

	}

	/**
	 * To shuffle then to pick.<br/>
	 * To shuffle then to pick.
	 */
	public static long pickKNRetB64W6(int[] sortedAry32, int k, int[] exSortedAry32) { // every ary32[i] <= 63 最大值 and k <= 10 長度

		return pickKNRetB64W6(Ary32va.ex(sortedAry32, exSortedAry32), k);
	}

	/**
	 * To shuffle then to pick.<br/>
	 * To shuffle then to pick.
	 */
	public static int[] pickK(int[] ary32, int k) {

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		long keptB64 = 0b0L;

		int idx;
		int lenMul2 = (ary32.length << 1); // 寬鬆
		long tmp;

		int[] retAry32 = new int[k];
		int iRetAry32 = 0;
		do {

			idx = rnd.nextInt(lenMul2) >>> 1;
			tmp = (keptB64 | (0b1L << idx));
			// O.l("tmp=" + tmp , THIS);

			if (tmp == keptB64)
				continue;

			else {

				retAry32[iRetAry32++] = ary32[idx];
				keptB64 = tmp;

			}

			if (B64va.countOf1(keptB64) == k)
				break;

		} while (B.I);

		return retAry32;

	}

	/**
	 * To shuffle then to pick.<br/>
	 * To shuffle then to pick.
	 */
	public static String[] pickK(String[] sAry, int k) {

		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		long keptB64 = 0b0L;

		int idx;
		int lenMul2 = (sAry.length << 1); // 寬鬆
		long tmp;

		String[] retSAry = new String[k];
		int iRetSAry = 0;
		do {

			idx = rnd.nextInt(lenMul2) >>> 1;
			tmp = (keptB64 | (0b1L << idx));
			// O.l("tmp=" + tmp , THIS);

			if (tmp == keptB64)
				continue;

			else {

				retSAry[iRetSAry++] = sAry[idx];
				keptB64 = tmp;

			}

			if (B64va.countOf1(keptB64) == k)
				break;

		} while (B.I);

		return retSAry;

	}
}
