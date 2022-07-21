package lgpl3.comb.carteProd;

import lgpl3.comb.Cnk;
import lgpl3.comb.Pnk;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.comb.thr.ThrCnkBySpareB64;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Seq;

/**
 * Cartesian product.<br/>
 * Cartesian product.
 *
 * @version 2022/06/19_00:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=CarteProdCnk_A" >src</a>
 *
 * @see CarteProdCnk_Z
 */
public abstract class CarteProdCnk_A extends CarteProd {

	private static final Class<?> THIS = CarteProdCnk_A.class;

	/**
	 * To sum after multiplied.
	 *
	 * @see CarteProdPnk #mulAmongBoxWTag(int, long)
	 */
	public static long mulAmongBoxWTag(int n, long b64W6) {

		long ret = 1L;

		int vCell = ((int) b64W6) & B64W6.MASK32;
		do {
			ret *= Cnk.int64(n, vCell);
			n -= vCell;

		} while ((vCell = ((int) (b64W6 >>>= B64W6.$6)) & B64W6.MASK32) != 0b0);

		return ret;

	}

	/**
	 * To sum after multiplied.
	 *
	 * @see CarteProdPnk #mulAmongHeap(int, long)
	 */
	public static long mulAmongHeap(int n, long sortedB64W6) { // must be sorted

		long oldB64W6 = sortedB64W6, ret = 1L; // must keep sortedB64W6

		int vCell = (((int) sortedB64W6) & B64W6.MASK32), b32W6;
		do {
			ret *= Cnk.int64(n, vCell);
			n -= vCell;

		} while ((vCell = ((int) (sortedB64W6 >>>= B64W6.$6)) & B64W6.MASK32) != 0b0);

		if ((b32W6 = B64W6.countDupNRev(oldB64W6)) == 0b0)

			return ret;

		do
			ret /= Pnk.int64(b32W6 & B64W6.MASK32);

		while ((b32W6 >>>= B64W6.$6) != 0b0);

		return ret; // O.l("ret=" + ret, THIS);

	}

	/**
	 * To union.<br/>
	 * To union.
	 */
	public static long unionAll(Seq seq) {

		int idx = seq.i - 1;

		long ary[] = seq.ary, retB64As2Pow = ary[idx];

		for (; idx-- != 0;)

			retB64As2Pow |= ary[idx];

		// O.l("unionAll=" + B32va.str((int) retB64As2Pow) + O.S9 + THIS);

		return retB64As2Pow;

	}

	/**
	 * To clone then to join.
	 */
	public static void cloneNJoinIfGt(Seq leftSeq, long[] rightAryOfB64As2Pow, final int iFound, Arr<Seq> retArr) {

		int idx = 0;

		if (iFound == Integer.MIN_VALUE) // O.l("iFound=" + iFound, THIS);

			for (; idx != rightAryOfB64As2Pow.length; idx++)

				retArr.a(leftSeq.cNA(rightAryOfB64As2Pow[idx]));

		else
			for (long left = leftSeq.ary[iFound], leftLowest1 = (-left & left), right; idx != rightAryOfB64As2Pow.length; idx++)

				if ((-(right = rightAryOfB64As2Pow[idx]) & right) > leftLowest1) // O.l("leftLowest1=" + leftLowest1, THIS);

					retArr.a(leftSeq.cNA(right));

	}

	/**
	 * To pick.
	 *
	 * @see CarteProdPnk #prodAmongGroup(int, long, boolean)
	 */
	public static Arr<Seq> oldProdAmongHeap(int n, long allVCell) {

		// todo: 若 n=5, allVCell = 2,2
		// 第一組 firstRound 允許 [A,B] [A,C] [A,D]... A 開頭
		// 第一組 firstRound 也允許 [B,E] and [C,D]

		if (n >= 63)

			O.x("n=" + n);

		int totalVCell = B64W6.totalVCell(allVCell), iCell = 0,

				vCell = (((int) allVCell) & B64W6.MASK32), idx, iFound; // O.l("vCell=" + vCell, THIS);

		long allBit = ~(-0b1L << n);

		Arr<Seq> arrSun = new Arr<Seq>(Seq.class), arrMoon, arrToSwap;

		ThrCnkBySpareB64 thrC = new ThrCnkBySpareB64(allBit, vCell, B.I);

		for (idx = 0; idx != thrC.box.length; idx++)

			arrSun.a(new Seq(thrC.box[idx]));

		// O.l("firstTime=" + O.L + Cnk.strByAryOfB64As2Pow(leftAry));

		arrMoon = new Arr<Seq>(Seq.class);

		for (Seq leftSeq; ++iCell != totalVCell;) {

			vCell = ((int) (allVCell >>> (B64W6.$6 * iCell))) & B64W6.MASK32;

			// check if two groups with the same number of elements
			iFound = B64W6.findFirstOccurDownTo0(allVCell, iCell - 1, vCell);

			// O.l("allVCell" + B64W6.str24(allVCell), THIS);
			// O.l("iFound=" + iFound, THIS);

			for (idx = 0; idx != arrSun.i; idx++) {

				thrC = new ThrCnkBySpareB64((~unionAll(leftSeq = arrSun.arr[idx]) & allBit), vCell, B.I);

				cloneNJoinIfGt(leftSeq, thrC.box, iFound, arrMoon);

			}

			// swap 重複使用 // 原創
			arrToSwap = arrSun;

			arrSun = arrMoon;

			(arrMoon = arrToSwap).i = 0;
			// end swap 重複使用

		}

		return arrSun;

	}
}
