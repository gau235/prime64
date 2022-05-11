package lgpl3.comb.stirlingN.thr;

import lgpl3.b32.B32va;
import lgpl3.comb.Pnk;
import lgpl3.comb.b64W6.B64W6;
import lgpl3.comb.filter.Condi;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Ary2D;
import lgpl3.o.keyNV.KAryV32;
import lgpl3.o.thr.ThrWBox;

/**
 * S3.<br/>
 * S3.
 *
 * @version 2022/02/21_12:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=ThrS2PWDynaB64" >ThrS2PWDynaB64.java</a>
 *
 */
public class ThrS2PWDynaB64 extends ThrWBox<Ary2D> {

	private static final Class<?> THIS = ThrS2PWDynaB64.class;

	public int n;

	public int k;

	public int min;

	public int max;

	public int baseB32;

	public int nMulK;

	public int boundBit;

	public int tmp32;

	public long tmp;

	// public long[] tmpAry;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrS2PWDynaB64(Condi condi, boolean isToRun) {

		n = condi.n;
		k = condi.k;
		min = condi.min;

		max = condi.max;

		// boundBit = 0b1 << n;
		boundBit = (0b1 << (n - min + 1)); // important

		baseB32 = ~((-0b1) << n); // todo: (-1) change to -0b1

		nMulK = n * k;

		box = new Ary2D();

		if (isToRun)

			run();

	}

	/**
	 * To convert.<br/>
	 * To convert.
	 */
	public long toB64NRev(int b32As2Pow) {

		// O.l("b32As2Pow=" + b32As2Pow, THIS);

		tmp = 0b0L;

		int lowest1;
		do
			tmp = (tmp << n) | (lowest1 = -b32As2Pow & b32As2Pow);

		while ((b32As2Pow = (~lowest1 & b32As2Pow)) != 0b0);

		// reverse
		long retB64 = 0b0L;

		do {
			retB64 |= (((int) tmp) & baseB32);

			if (((int) (tmp >>>= n)) == 0b0)

				return retB64;

			retB64 <<= n;

		} while (B.I);

	}

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Ary2D to StringBuilder.
	 */
	public static StringBuilder toStr(long[] ary) { // to trace code

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		retStr.append(O.C91);

		for (int iSmall = 0; iSmall != ary.length;) {

			retStr.append(B64W6.strByVCellMinus1AftRevBySAry(ary[iSmall], O.S_ARY_A_Z));

			if (++iSmall != ary.length)

				retStr.append(O.C124);

		}

		return retStr.append(O.C93);

	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public void pAlongAtK(long prefix, int rmdB32, long[] ary, int atK) {

		prefix <<= B64W6.$6;

		if ((-rmdB32 & rmdB32) == rmdB32) { // O.l("up tmp=" + B32va.str16((int) tmp));

			ary[atK++] = (prefix | B32va.log2NPlus1(rmdB32));

			if (atK == k) // O.l("add=" + toStr(ary));

				box.a(ary);
			else
				pAlongAtK(0b0L, (((int) (tmp >>> n * atK)) & baseB32), ary, atK); // go along the right hand side, atK 是地圖指南

			return;

		}

		int myRmdB32 = rmdB32, lowest1;

		do
			if ((lowest1 = (-myRmdB32 & myRmdB32)) == myRmdB32)

				pAlongAtK(prefix | B32va.log2NPlus1(lowest1), (~lowest1 & rmdB32), ary, atK);
			else
				pAlongAtK(prefix | B32va.log2NPlus1(lowest1), (~lowest1 & rmdB32), ary.clone(), atK); // 源頭管理

		while ((myRmdB32 = (~lowest1 & myRmdB32)) != 0b0); // 子彈打完

	}

	/**
	 * To check if int32 all between min and max (both inclusive).<br/>
	 * To check if int32 all between min and max (both inclusive).
	 */
	public boolean ifEveryCellLegal(long b64) {

		do
			if (((tmp32 = B32va.countOf1(((int) b64) & baseB32)) < min) || (tmp32 > max)) // O.l("bitCount=" + bitCount, THIS);

				return B.O;

		while (((int) (b64 >>>= n)) != 0b0);

		return B.I;

	}

	/**
	 * The tail process of S2 function.<br/>
	 * The tail process of S2 function.<br/>
	 * S2: 水平组合後再垂直组合<br/>
	 * Onto: 水平排列後再垂直组合
	 */
	public void cVert(final long prefix, int rmdB32) {

		int lowest1 = (-rmdB32 & rmdB32), dToShift = 0; // displacement from the first cell

		if (lowest1 == rmdB32) { // termination condition

			do {
				if (lowest1 < (((int) (prefix >>> dToShift)) & baseB32))
					return;

				if (ifEveryCellLegal(tmp = (prefix | (((long) lowest1) << dToShift)))) // O.l("tmp" + (++B.n32) + "= " + tmp);

					pAlongAtK(0b0L, (((int) tmp) & baseB32), new long[k], 0);

			} while ((dToShift += n) != nMulK);

			return;

		}

		do {
			if (lowest1 < (tmp32 = ((int) (prefix >>> dToShift)) & baseB32))
				return;

			if (B32va.countOf1(tmp32) < max)

				cVert(prefix | (((long) lowest1) << dToShift), (~lowest1 & rmdB32));

		} while ((dToShift += n) != nMulK);

	}

	/**
	 * 從 1 列全相異數列中取出 k 個數.<br/>
	 * To pick several numbers from a list of distinct numbers.
	 */
	public void cHori(int rmdK, int prefixB32, int curBit) {

		if (--rmdK == 0) { // termination condition

			do
				cVert(toB64NRev(tmp32 = (curBit | prefixB32)), (~tmp32 & baseB32));

			while ((curBit <<= 1) != boundBit);

			return;

		}

		int myBoundBit = boundBit >>> rmdK;

		do
			cHori(rmdK, (curBit | prefixB32), (curBit <<= 1));

		while (curBit != myBoundBit);

	}

	@Override
	public void run() {

		if (min != 0) {

			if (k == 1) {

				KAryV32 retKAryV32 = new KAryV32(Pnk.int64(n));

				Pnk.colRecurWNEqK(0b0L, baseB32, retKAryV32);

				// O.l("retKAryV32=" + retKAryV32.int32, THIS);

				while (retKAryV32.int32-- != 0)

					box.a(new long[] { retKAryV32.ary[retKAryV32.int32] });

				return;

			}

			if (k == n) {

				long[] tmpAry = new long[n];

				int idx = 0;
				do
					tmpAry[idx] = ++idx;

				while (idx != n);

				box.a(tmpAry);

				return;

			}

			cHori(k - 1, 0b1, 0b10); // the 'A' symbol must be at the most left hand side

			return;

		}

		// min == 0

		min = 1; // important
		boundBit = 0b1 << n; // important

		for (; k != 0; k--) { // O.l("k=" + k, THIS);

			if (k == 1) { // O.l("baseB32=" + baseB32, THIS);

				KAryV32 retKAryV32 = new KAryV32(Pnk.int64(n));

				Pnk.colRecurWNEqK(0b0L, baseB32, retKAryV32);

				while (retKAryV32.int32-- != 0)

					box.a(new long[] { retKAryV32.ary[retKAryV32.int32] });

				continue;

			}

			if (k == n) {

				long[] tmpAry = new long[n];

				int idx = 0;
				do
					tmpAry[idx] = ++idx;

				while (idx != n);

				box.a(tmpAry);

				continue;

			}

			nMulK = n * k; // O.l("nMulK=" + nMulK, THIS);

			cHori(k - 1, 0b1, 0b10); // the 'A' symbol must be at the most left hand side

		}
	}
}
