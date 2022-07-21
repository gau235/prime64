package lgpl3.comb.stirlingN;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.comb.carteProd.CarteProdPnk;
import lgpl3.comb.filter.Condi;
import lgpl3.divIntoHeap.Dih;
import lgpl3.o.B;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Seq;

/**
 * @version 2022/02/23_17:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=S2P_Y" >S2P_Y.java</a>
 *
 * @see S2P_Z
 */
public abstract class S2P_Y extends S2P_A {

	// private static final Class<?> THIS = S2P_Y.class;

	/**
	 * Stirling number of the third kind.<br/>
	 * Stirling number of the third kind.
	 *
	 * @see S2nk#colRecur(Condi)
	 */
	public static Arr<Seq> goByCartesianProd(Condi condi) {

		long[] aryOfB64W6 = Dih.col(condi.n, condi.k, condi.min, condi.max);

		Arr<Seq> retArrOfSeq = new Arr<Seq>(Seq.class), tmpArrOfSeq;

		int minMinus1 = condi.min - 1;
		for (int idx = 0; idx != aryOfB64W6.length; idx++) {

			if (condi.min == 1)

				tmpArrOfSeq = CarteProdPnk.prodAmongGroup(condi.n, B64W6.revAmongVCell(aryOfB64W6[idx]), B.I);
			else
				tmpArrOfSeq = CarteProdPnk.prodAmongGroup(condi.n, B64W6.revAmongVCell(B64W6.plusAllWV32(aryOfB64W6[idx], minMinus1)), B.I);

			retArrOfSeq.appendAll(tmpArrOfSeq.arr, 0, tmpArrOfSeq.i);

		}

		return retArrOfSeq;

	}

	/**
	 * Stirling number of the third kind.<br/>
	 * Stirling number of the third kind.
	 */
	public static Arr<Seq> colToKByToGoByCartesianProd(Condi condi) {

		final int endK = condi.k;

		Condi clonedCondi = condi.clone();
		clonedCondi.min = 1; // fuck

		Arr<Seq> retArrOfSeq = new Arr<Seq>(Seq.class), tmpArrOfSeq;

		for (int k = 1; k <= endK; k++) {

			clonedCondi.k = k;

			retArrOfSeq.appendAll((tmpArrOfSeq = goByCartesianProd(clonedCondi)).arr, 0, tmpArrOfSeq.i);

		}

		return retArrOfSeq;

	}
}
