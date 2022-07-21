package lgpl3.comb.carteProd;

import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Seq;

/**
 * Cartesian product.<br/>
 * Cartesian product.
 *
 * @version 2021/03/16_11:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=CarteProd_A" >CarteProd_A.java</a>
 *
 * @see CarteProd
 */
public abstract class CarteProd_A {

	// private static final Class<?> THIS = CarteProd_A.class;

	/**
	 * the separator.<br/>
	 * the separator.
	 */
	public static CharSequence charSeqAsSeparator = new StringBuilder(" || ");

	/**
	 * To clone then to join.<br/>
	 * To clone then to join.
	 */
	public static void cloneNJoinExtTail(Seq leftSeq, long[] ary, Arr<Seq> retArr) {

		for (int idx = 0, lenMinus1 = ary.length - 1; idx <= lenMinus1; idx++)

			if (idx == lenMinus1) {

				retArr.a(leftSeq.a(ary[idx]));

				return;

			} else
				retArr.a(leftSeq.cNA(ary[idx]));

	}
}
