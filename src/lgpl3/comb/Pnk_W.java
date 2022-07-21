package lgpl3.comb;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.B;
import lgpl3.o.keyNV.KAryV32;

/**
 * @version 2022/06/24_10:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Pnk_W" >src</a>
 *
 * @see Pnk_Z
 */
public abstract class Pnk_W extends Pnk_J {

	private static final Class<?> THIS = Pnk_W.class;

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public static void colBySwap(long prefix, int len, int from, KAryV32 kV) {

		B.n32++;

		int fromPlus1 = from + 1;

		if (fromPlus1 == len - 1) { // 剩下 2 個

			kV.k[kV.v++] = prefix;

			do
				kV.k[kV.v++] = B64W6.swapVCell(prefix, from, fromPlus1);

			while (++fromPlus1 != len);

			return;

		}

		// 一次跑到底
		colBySwap(prefix, len, fromPlus1, kV); // 當 nxt==from 跳過 不用每次都 swap

		for (int nxt = fromPlus1; nxt != len; nxt++)

			colBySwap(B64W6.swapVCell(prefix, from, nxt), len, fromPlus1, kV); // 當 nxt==from 跳過 不用每次都 swap

	}

	/**
	 * 從 1 列全相異數列中取出 k 個數.<br/>
	 * To pick several numbers from a list of distinct numbers.
	 */
	public static void cBefColBySwap(final int boundBit, int rmdK, int prefix, int curBit, KAryV32 kV) {

		if (--rmdK == 0) {

			final int n = Integer.bitCount(prefix) + 1; // O.l("n=" + n, THIS);

			do
				colBySwap(B64W6.toB64W6ByLog2NPlus1(curBit | prefix), n, 0, kV);

			while ((curBit <<= 1) != boundBit);

			return;

		}

		int newBoundBit = boundBit >>> rmdK;

		do
			cBefColBySwap(boundBit, rmdK, (curBit | prefix), (curBit <<= 1), kV);

		while (curBit != newBoundBit);

	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public static long[] colBySwap(int n, int k) {

		KAryV32 retKV = new KAryV32(int64(n, k));

		cBefColBySwap((0b1 << n), k, 0b0, 0b1, retKV);

		return retKV.k;

	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public static void colBySwapWNGteK(long prefix, int totalVCell, int from, KAryV32 kV, int lv) {

		B.n32++;

		int fromPlus1 = from + 1;

		if (fromPlus1 == lv) {

			long mask = ~(B64W6.MASK0_1TO_6 << (B64W6.$6 * from)); // O.l("mask=" + B64W6.str(mask), THIS);

			kV.k[kV.v++] = prefix & mask;

			for (; fromPlus1 != totalVCell; fromPlus1++)

				kV.k[kV.v++] = B64W6.pasteAt(prefix, from, (((int) (prefix >>> (B64W6.$6 * fromPlus1))) & B64W6.MASK32)) & mask;

			return;

		}

		// 一次跑到底
		colBySwapWNGteK(prefix, totalVCell, fromPlus1, kV, lv); // 當 nxt==from 跳過 不用每次都 swap

		for (int nxt = fromPlus1; nxt != totalVCell; nxt++)

			colBySwapWNGteK(B64W6.swapVCell(prefix, from, nxt), totalVCell, fromPlus1, kV, lv);

	}
}
