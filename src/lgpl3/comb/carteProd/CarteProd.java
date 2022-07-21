package lgpl3.comb.carteProd;

import lgpl3.o.B;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Ary2D;
import lgpl3.o.ary.Seq;

/**
 * Cartesian product.<br/>
 * Cartesian product.
 *
 * @version 2021/03/17_11:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=CarteProd" >CarteProd.java</a>
 *
 * @see CarteProd
 *
 * @see CarteProdCnk
 *
 * @see CarteProdPnk
 */
public abstract class CarteProd extends CarteProd_A {

	// private static final Class<?> THIS = CarteProd.class;

	/**
	 * To product iteratively.<br/>
	 * [A,B] X [1,2] = [A,1]~[A,2]~[B,1]~[B,2]
	 */
	public static Arr<Seq> oldProdByLoop(Ary2D ary2D) {

		Arr<Seq> arrSun = new Arr<Seq>(Seq.class), arrMoon, arrToSwap;

		long[] curAry = ary2D.arr[0], rightAry;

		int idx = 0, iAry2D = 0;

		for (; idx != curAry.length; idx++)

			arrSun.a(new Seq().a(curAry[idx]));

		if (++iAry2D == ary2D.i)

			return arrSun;

		arrMoon = new Arr<Seq>(Seq.class);

		do {
			rightAry = ary2D.arr[iAry2D];

			for (idx = 0; idx != arrSun.i; idx++)

				cloneNJoinExtTail(arrSun.arr[idx], rightAry, arrMoon);

			if (++iAry2D == ary2D.i) // termination condition

				return arrMoon;

			// swap 重複使用 // 原創
			arrToSwap = arrSun;

			arrSun = arrMoon;

			(arrMoon = arrToSwap).i = 0;
			// end swap 重複使用

		} while (B.I);
	}

	/**
	 * To product iteratively.<br/>
	 * [A,B] X [1,2] = [A,1]~[A,2]~[B,1]~[B,2]
	 */
	public static void recur(Seq leftSeq, Ary2D baseAry2D, int iBaseAry2D, Arr<Seq> retArr) {

		// O.lD("iBaseAry2D=" + iBaseAry2D);

		long[] curAry = baseAry2D.arr[iBaseAry2D];

		int curLenMinus1 = curAry.length - 1, iAry = 0;

		if (++iBaseAry2D == baseAry2D.i) { // termination condition

			do {

				if (iAry == curLenMinus1) {

					retArr.a(leftSeq.a(curAry[iAry]));

					return;

				}

				retArr.a(leftSeq.cNA(curAry[iAry++]));

			} while (B.I);

		}

		do {

			if (iAry == curLenMinus1) {

				recur(leftSeq.a(curAry[iAry]), baseAry2D, iBaseAry2D, retArr); // 老師影印考卷 正本留最後用

				return;

			}

			recur(leftSeq.cNA(curAry[iAry++]), baseAry2D, iBaseAry2D, retArr);

		} while (B.I);

	}

	/**
	 * To product iteratively.<br/>
	 * [A,B] X [1,2] = [A,1]~[A,2]~[B,1]~[B,2]
	 */
	public static Arr<Seq> recur(Ary2D ary2D) {

		Arr<Seq> ret = new Arr<Seq>(Seq.class);

		if (ary2D.i == 0)

			return ret;

		long[] curAry = ary2D.arr[0];
		int idx = 0;

		if (ary2D.i == 1) {

			do
				ret.a(new Seq(curAry[idx]));

			while (++idx != curAry.length);

			return ret;

		}

		// ary2D.iLen >= 2
		do
			recur(new Seq(curAry[idx]), ary2D, 1, ret);

		while (++idx != curAry.length);

		return ret;

	}
}
