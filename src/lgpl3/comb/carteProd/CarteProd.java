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
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=CarteProd" >CarteProd.java</a>
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

		Arr<Seq> tmpArr = new Arr<Seq>(Seq.class);

		long[] curAry = ary2D.arr[0];
		for (int idx = 0; idx != curAry.length; idx++)

			tmpArr.a(new Seq().a(curAry[idx]));

		if (ary2D.iLen == 1)

			return tmpArr;

		int iAry2D;
		long[] rightAry;
		Arr<Seq> retArr;
		int iTmpArr;

		for (iAry2D = 1; B.I;) {

			rightAry = ary2D.arr[iAry2D];
			retArr = new Arr<Seq>(Seq.class);

			for (iTmpArr = 0; iTmpArr != tmpArr.iLen; iTmpArr++)

				cloneNJoinExtTail(tmpArr.arr[iTmpArr], rightAry, retArr);

			if (++iAry2D == ary2D.iLen) // termination condition

				return retArr;

			tmpArr = retArr;

		}
	}

	/**
	 * To product iteratively.<br/>
	 * [A,B] X [1,2] = [A,1]~[A,2]~[B,1]~[B,2]
	 */
	public static void recur(Seq leftSeq, Ary2D baseAry2D, int iBaseAry2D, Arr<Seq> retArr) {

		// O.lD("iBaseAry2D=" + iBaseAry2D);

		long[] curAry = baseAry2D.arr[iBaseAry2D];
		int curLenMinus1 = curAry.length - 1;
		int iAry = 0;

		if (++iBaseAry2D == baseAry2D.iLen) { // termination condition

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

		Arr<Seq> retArr = new Arr<Seq>(Seq.class);

		if (ary2D.iLen == 0)
			return retArr;

		long[] curAry = ary2D.arr[0];
		int idx = 0;

		if (ary2D.iLen == 1) {

			do
				retArr.a(new Seq(curAry[idx]));

			while (++idx != curAry.length);

			return retArr;

		}

		// ary2D.iLen >= 2
		do
			recur(new Seq(curAry[idx]), ary2D, 1, retArr);

		while (++idx != curAry.length);

		return retArr;

	}
}
