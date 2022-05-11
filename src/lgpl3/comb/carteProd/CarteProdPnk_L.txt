package lgpl3.comb.carteProd;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.comb.thr.ThrToPByB64As2Pow;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Seq;

/**
 * @version 2021/11/29_11:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=CarteProdPnk_L" >CarteProdPnk_L.java</a>
 *
 * @see CarteProdPnk
 */
public abstract class CarteProdPnk_L extends CarteProdPnk_A {

	// private static final Class<?> THIS = CarteProdPnk_L.class;

	/**
	 * To clone then to join.<br/>
	 * To clone then to join.
	 */
	public static void cloneNJoinIfGt(Seq leftSeq, long[] rightAryOfB64W6, final int iFound, Arr<Seq> retArr) {

		if (iFound == Integer.MIN_VALUE)

			for (int idx = 0; idx != rightAryOfB64W6.length; idx++)

				retArr.a(leftSeq.cNA(rightAryOfB64W6[idx]));

		else {

			final int leftV = B64W6.getMin(leftSeq.ary[iFound]);

			long rB64W6;
			for (int idx = 0; idx != rightAryOfB64W6.length; idx++)

				if (B64W6.getMin(rB64W6 = rightAryOfB64W6[idx]) > leftV)

					retArr.a(leftSeq.cNA(rB64W6));

		}
	}

	/**
	 * To union.<br/>
	 * To union.
	 */
	public static long unionAllAftConvertToB64As2PowByB6Cell(long[] ary, int from, int to) {

		long retB64As2Pow = 0b0L;
		for (int idx = from; idx < to; idx++)
			retB64As2Pow |= B64W6.toB64As2PowByB6Cell(ary[idx]);

		return retB64As2Pow;

	}

	/**
	 * To pick.<br/>
	 * To pick.
	 *
	 * @see CarteProdCnk#oldProdAmongHeap(int, long)
	 */
	public static Arr<Seq> prodAmongGroup(int n, long b64W6WAllVal, boolean isIdentGroup) {

		if (n >= 63) // long allB64As2Pow = (0b1L << n) - 1L;
			O.x("n=" + n);

		int totalVCell = B64W6.totalVCell(b64W6WAllVal);

		long allB64As2Pow = ~(-0b1L << n);

		Arr<Seq> retArr = new Arr<Seq>(Seq.class);
		Arr<Seq> tmpArr = new Arr<Seq>(Seq.class);

		int iCell = 0;
		int vCell = ((int) (b64W6WAllVal >>> (B64W6.$6 * iCell))) & B64W6.MASK32;
		// B64W6.findFirstOccurFromTail(b64W6ForAllVal32, iForVal32 - 1, val32);
		iCell++;

		ThrToPByB64As2Pow thrToPByB64As2Pow = new ThrToPByB64As2Pow(allB64As2Pow, vCell, B.I);

		long[] leftAry = thrToPByB64As2Pow.box;
		for (int idx = 0; idx != leftAry.length; idx++)
			retArr.a(new Seq().a(leftAry[idx]));

		/////////////////////////////////////
		// StringBuilder str = B64W6.toStrByAryOfB64W6(tmpAry, O.L);
		// O.l(str);
		/////////////////////////////////////

		Seq leftSeq;

		int iFound, idx;
		for (; iCell != totalVCell; iCell++) {

			vCell = ((int) (b64W6WAllVal >>> (B64W6.$6 * iCell))) & B64W6.MASK32; // B64W6.at()

			iFound = B64W6.findFirstOccurDownTo0(b64W6WAllVal, iCell - 1, vCell);

			tmpArr = new Arr<Seq>(Seq.class);

			for (idx = 0; idx != retArr.iLen; idx++) {

				leftSeq = retArr.arr[idx];

				// A,B,C,D if we already have A,C then to take B,D
				thrToPByB64As2Pow = new ThrToPByB64As2Pow(
						~unionAllAftConvertToB64As2PowByB6Cell(leftSeq.ary, 0, leftSeq.iLen) & allB64As2Pow, vCell, B.I);

				if (isIdentGroup) // O.l("cloneNJoinIfGt=", THIS);

					cloneNJoinIfGt(leftSeq, thrToPByB64As2Pow.box, iFound, tmpArr);
				else
					cloneNJoinExtTail(leftSeq, thrToPByB64As2Pow.box, tmpArr);

			}

			retArr = tmpArr;

		}

		return retArr;

	}
}
