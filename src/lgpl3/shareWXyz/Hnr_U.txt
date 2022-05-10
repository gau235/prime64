package lgpl3.shareWXyz;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.divIntoHeap.Dih;
import lgpl3.o.ary.Seq;

/**
 * @version 2021/04/29_18:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Hnr_U" >Hnr_U.java</a>
 *
 * @see Hnr
 */
public abstract class Hnr_U extends Hnr_A {

	// private static final Class<?> THIS = Hnr_U.class;

	/**
	 * 即 n 個相同物品分成給 k 人, 每人最少 0 個.<br/>
	 * 缺點: min, max 沒作用.<br/>
	 * To return the number of ways to share several identical items with every person.
	 */
	public static void easyRecur(final int maxSymbol, long prefix, int rmdN, Seq retSeq) {

		int tailV = (((int) prefix) & B64W6.MASK32);

		prefix <<= B64W6.$6;

		if (--rmdN == 0) {

			do
				retSeq.a(prefix | tailV);

			while (++tailV <= maxSymbol);

			return;

		}

		do
			easyRecur(maxSymbol, (prefix | tailV), rmdN, retSeq);

		while (++tailV <= maxSymbol);

	}

	/**
	 * 即 n 個相同物品分成給 k 人, 每人最少 0 個.<br/>
	 * qtyB64=[2,3,4] means [1,2,3]<br/>
	 * To return the number of ways to share several identical items with every person.
	 */
	public static void recur(final int maxSymbol, long prefix, int rmdN, long qtyB64, Seq retSeq) {

		// O.lte(B.n32++, 120);

		int tailV = (((int) prefix) & B64W6.MASK32); // O.l("up tailV=" + tailV);

		prefix <<= B64W6.$6;

		if (--rmdN == 0) { // O.l("up rmdN=" + rmdN);

			do
				if ((((int) (qtyB64 >>> (B64W6.$6 * (tailV - 1)))) & B64W6.MASK32) > 1) // (tailV - 1) as idx
					retSeq.a(prefix | tailV);

			while (++tailV <= maxSymbol);

			return;

		}

		int curQty;
		long newQtyB64;

		do {
			curQty = ((int) (qtyB64 >>> (B64W6.$6 * (tailV - 1)))) & B64W6.MASK32; // todo: 第 2 次才需檢查 curQty

			if (curQty > 1) {

				newQtyB64 = B64W6.plusAt(qtyB64, (tailV - 1), -1); // minus 1
				// O.l("plusAt=\n" + B64W6.str(newQtyB64));

				recur(maxSymbol, (prefix | tailV), rmdN, newQtyB64, retSeq);

			}

		} while (++tailV <= maxSymbol); // 同一 LV, tailV 遞增

	}

	/**
	 * 即 n 個相同物品分成給 k 人, 每人最少 0 個.<br/>
	 * 缺點: min, max 沒作用.<br/>
	 * To return the number of ways to share several identical items with every person.
	 */
	public static long[] easyRecur(int numOfXyz, int totalN) {

		// H(3,5) with min==0 equals to H(3,8) with min==1
		// H(3,8) with min==1 equals to Hxy(8,3) with min==1
		// H(3,5) = C(7,5)
		// Hxy(8,3) = C(7,2)

		Seq retSeq = new Seq();

		// Dih.reguNCheck
		Dih.checkArg(totalN + numOfXyz, numOfXyz, 1, totalN + numOfXyz);

		// 符號 1 開頭, 一直取尾巴走下去 => 1,1,1 or 1,1,2 ...
		// 永遠不會出現符號 2 開頭 => 2,2,2
		int initSymbol = 1; // to evolve
		final int finalSymbol = numOfXyz;
		int rmdN = totalN - 1;

		for (; initSymbol <= numOfXyz; initSymbol++)
			easyRecur(finalSymbol, initSymbol, rmdN, retSeq); // O.lD("here=" + initSymbol + O.S9 + THIS);

		return retSeq.trim().ary;

	}

	/**
	 * 即 n 個相同物品分成給 k 人, 每人最少 0 個.<br/>
	 * qtyB64=[2,3,4] means [1,2,3]
	 */
	public static long[] recur(int numOfXyz, int totalN, long qtyB64) {

		Seq retSeq = new Seq();

		// 符號 1 開頭, 一直取尾巴走下去 => 1,1,1 or 1,1,2 ...
		// 永遠不會出現符號 2 開頭 => 2,2,2

		int initSymbol = 1; // to evolve
		final int finalSymbol = numOfXyz;
		int rmdN = totalN - 1;

		long tmpQtyB64 = qtyB64;

		for (; initSymbol <= numOfXyz;) {

			if (B64W6.sum32(tmpQtyB64) < totalN)
				break;

			recur(finalSymbol, initSymbol, rmdN, B64W6.plusAt(qtyB64, (initSymbol - 1), -1), retSeq);

			initSymbol++; // evolve
			tmpQtyB64 >>>= B64W6.$6;

		}

		return retSeq.trim().ary;

	}
}
