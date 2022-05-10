package lgpl3.comb.carteProd;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.comb.thr.ThrToCBySpareB64As2Pow;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Seq;

/**
 * @version 2022/05/04_20:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=CarteProdCnk_U" >CarteProdCnk_U.java</a>
 *
 * @see CarteProdCnk
 */
public abstract class CarteProdCnk_U extends CarteProdCnk_A {

	private static final Class<?> THIS = CarteProdCnk_U.class;

	/**
	 * To pick.
	 *
	 * @see CarteProdPnk#prodAmongGroup(int, long, boolean)
	 */
	public static Arr<Seq> oldProdAmongHeap(int n, long b64W6WAllV) {

		// todo: 若 n=6 k=3
		// 第一組 firstRound 只允許 [A,B] [A,C] [A,D]... A 開頭
		// 第一組 firstRound 不允許 [B,C] 如 [B,C] [E,F] => error

		if (n >= 63) // int newB32As2Pow = (curB32As2Pow << 1) -1; // so max int32 must be 30 bits or 29 bits?

			O.x("n=" + n);

		int totalVCell = B64W6.totalVCell(b64W6WAllV), iCell = 0,

				vCell = ((int) (b64W6WAllV >>> (B64W6.$6 * iCell))) & B64W6.MASK32, idx, iFound;

		// O.l("vCell=" + vCell + O.S9 + THIS);

		long allB64As2Pow = ~(-0b1L << n); // O.l("allB64As2Pow=" + B32va.str((int) allB64As2Pow) + O.S9 + THIS);

		Arr<Seq> arrA = new Arr<Seq>(Seq.class), arrB;

		ThrToCBySpareB64As2Pow thrToC = new ThrToCBySpareB64As2Pow(allB64As2Pow, vCell, B.I);

		long[] leftAry = thrToC.box;
		for (idx = 0; idx != leftAry.length; idx++)

			arrA.a(new Seq(leftAry[idx]));

		// O.l("firstRound=" + O.L + Cva.toStrToCByB64As2PowBySAry(leftAry, O.S_ARY_A_Z, O.L));

		for (Seq leftSeq; ++iCell != totalVCell;) {

			vCell = ((int) (b64W6WAllV >>> (B64W6.$6 * iCell))) & B64W6.MASK32;

			// check if duplicated groups
			iFound = B64W6.findFirstOccurDownTo0(b64W6WAllV, iCell - 1, vCell);

			arrB = new Arr<Seq>(Seq.class);

			for (idx = 0; idx != arrA.iLen; idx++) {

				thrToC = new ThrToCBySpareB64As2Pow((~unionAll(leftSeq = arrA.arr[idx]) & allB64As2Pow), vCell, B.I);

				// O.l("thrToC.unionB64=" + B32va.str((int) thrToC.unionB64) + O.S9 + THIS);

				cloneNJoinIfGt(leftSeq, thrToC.box, iFound, arrB);

			}

			arrA = arrB; // todo: swap 重複使用

		}

		return arrA;

	}
}
