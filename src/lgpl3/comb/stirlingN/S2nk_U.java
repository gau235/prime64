package lgpl3.comb.stirlingN;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.comb.carteProd.CarteProdCnk;
import lgpl3.comb.filter.Condi;
import lgpl3.comb.onto.Onto;
import lgpl3.divIntoHeap.Dih;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Seq;

/**
 * @version 2020/02/12_20:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=S2nk_U" >S2nk_U.java</a>
 *
 * @see S2nk_Y
 */
public abstract class S2nk_U extends S2nk_B {

	private static final Class<?> THIS = S2nk_U.class;

	/**
	 * Stirling number of the second kind.<br/>
	 * Stirling number of the second kind.
	 *
	 * @see Onto #onto(Condi)
	 */
	public static Arr<Seq> carteProd(Condi condi) {

		long[] aryOfB64W6 = Dih.col(condi.n, condi.k, condi.min, condi.max);

		Arr<Seq> retArrOfSeq = new Arr<Seq>(Seq.class);
		Arr<Seq> tmpArrOfSeq;

		int minMinus1 = condi.min - 1;
		for (int i = 0; i != aryOfB64W6.length; i++) {

			if (condi.min == 1) // O.l("condi.min=", THIS);

				tmpArrOfSeq = CarteProdCnk.oldProdAmongHeap(condi.n, B64W6.revAmongVCell(aryOfB64W6[i]));
			else
				tmpArrOfSeq = CarteProdCnk.oldProdAmongHeap(condi.n,

						B64W6.revAmongVCell(B64W6.plusAllWV32(aryOfB64W6[i], minMinus1)));

			retArrOfSeq.appendAll(tmpArrOfSeq.arr, 0, tmpArrOfSeq.i);

		}

		return retArrOfSeq;

	}

	/**
	 * Stirling number of the second kind.<br/>
	 * Stirling number of the second kind.
	 */
	public static Arr<Seq> colToKByCarteProd(Condi condi) {

		Arr<Seq> retArrOfSeq = new Arr<Seq>(Seq.class);
		Arr<Seq> tmpArrOfSeq;

		final int endK = condi.k;

		Condi clonedCondi = condi.clone();
		clonedCondi.min = 1; // fuck

		for (int k = 1; k <= endK; k++) {

			clonedCondi.k = k;

			tmpArrOfSeq = carteProd(clonedCondi);
			retArrOfSeq.appendAll(tmpArrOfSeq.arr, 0, tmpArrOfSeq.i);

		}

		return retArrOfSeq;

	}
}
