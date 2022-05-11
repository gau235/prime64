package lgpl3.comb.b64W6;

import lgpl3.b32.B32va;
import lgpl3.o.B;
import lgpl3.o.ary.Ary32va;

/**
 * To make a 64-bit long divide into every 6-bit cell.<br/>
 * The first index of cell from the right hand side is 0.
 *
 * @version 2022/03/07_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=B64W6" >B64W6.java</a>
 *
 * @see B32va
 */
public abstract class B64W6 extends B64W6_L {

	private static final Class<?> THIS = B64W6.class;

	/**
	 * To gen the ascending B64W6.<br/>
	 * To return 0011_0010_0001 as 3,2,1 like int[]{1,2,3}
	 */
	public static long genB64W6ByAry32(int... ary32) { // all integers must be positive

		long retB64W6 = 0b0L;

		for (int idx = ary32.length; B.I;) {

			retB64W6 |= ary32[--idx];

			if (idx == 0)

				return retB64W6; // O.l("retB64W6=" + O.L + str24(retB64W6), THIS);

			retB64W6 <<= $6;

		}
	}

	/**
	 * To sum.<br/>
	 * To sum.
	 */
	public static int sum32(long b64W6) {

		int ret = 0;
		do
			ret += (((int) b64W6) & MASK32);

		while ((b64W6 >>>= $6) != 0b0L);

		return ret;

	}

	/**
	 * If contain.<br/>
	 * The bound inclusive.
	 *
	 * @see Ary32va#findFirstOccurDownTo0(int[], int, int)
	 */
	public static int findFirstOccurDownTo0(long b64W6, int bound, int key32) {

		for (; bound-- != 0;)

			if (((int) (b64W6 >>> ($6 * bound)) & MASK32) == key32)

				return bound;

		return Integer.MIN_VALUE;

	}

	/**
	 * To count the occurrence of every value.<br/>
	 * The input need to sort first, as 0b000011_000010_000001<br/>
	 * When inputing 0b000010_000001_000001_000001 then it returns: 000000_000011<br/>
	 * When inputing 0b000000_000000_000001_000011 then it returns: 000000_000000
	 *
	 * @see #countDup(long)
	 */
	public static int countDupNRev(long sortedB64W6) {

		int min = (((int) sortedB64W6) & MASK32) /* sortedB64W6 must not be 0b0L */, vCell, count = 1, retB32W6 = 0b0;

		do {
			if ((vCell = ((int) (sortedB64W6 >>>= $6)) & MASK32) == 0b0) {

				if (count != 1)

					retB32W6 = ((retB32W6 << $6) | count);

				return retB32W6;

			}

			if (vCell == min)

				count++;
			else {

				if (count != 1)

					retB32W6 = ((retB32W6 << $6) | count);

				// O.l("count=" + count, THIS);

				min = vCell; // change to next
				count = 1; // fuck

			}

		} while (B.I);

	}

	/**
	 * To count the occurrence.<br/>
	 * When the ary32 is {1, 3, 3}, then to return: 0b000010_000001<br/>
	 * To count of occurrence.
	 *
	 * @see #countAllOccur(long)
	 */
	public static long countAllOccurNRev(long sortedB64W6) { // sortedB64W6 must not be 0b0L

		int min = (((int) sortedB64W6) & MASK32) /* sortedB64W6 must not be 0b0L */, vCell, count = 1;

		long retB64W6 = 0b0L;

		do {
			if ((vCell = ((int) (sortedB64W6 >>>= $6)) & MASK32) == 0b0) // O.l("retB64W6=" + O.L + str24(retB64W6), THIS);

				return retB64W6 = ((retB64W6 << $6) | count);

			if (vCell == min)

				count++;
			else {

				retB64W6 = ((retB64W6 << $6) | count); // O.l("count=" + count, THIS);

				min = vCell; // check if pass This.genB64W6ByAry32(1, 1, 2, 3, 4)
				count = 1; // fuck

			}

		} while (B.I);

	}

	/**
	 * To count the occurrence of every value.<br/>
	 * The input need to sort first, as 0b000011_000010_000001<br/>
	 * When inputing 0b000010_000001_000001_000001 then it returns: 000000_000011<br/>
	 * When inputing 0b000000_000000_000001_000011 then it returns: 000000_000000
	 */
	public static int countDup(long sortedB64W6) {

		return revAmongVCell(countDupNRev(sortedB64W6));
	}

	/**
	 * To count the occurrence.<br/>
	 * When the ary32 is {1, 3, 3}, then to return: 0b000010_000001
	 */
	public static long countAllOccur(long sortedB64W6) { // sortedB64W6 must not be 0b0L

		return revAmongVCell(countAllOccurNRev(sortedB64W6));
	}
}
