package lgpl3.comb.stirlingN.thr;

import lgpl3.b32.B32va;
import lgpl3.comb.PCirc;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.comb.filter.Condi;
import lgpl3.o.keyNV.KAryV32;

/**
 * S1.<br/>
 * S1.
 *
 * @version 2022/02/21_12:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=ThrS2PCircWDynaB64" >src</a>
 *
 */
public class ThrS2PCircWDynaB64 extends ThrS2PWDynaB64 {

	private static final Class<?> THIS = ThrS2PCircWDynaB64.class;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrS2PCircWDynaB64(Condi condi, boolean isToRun) {

		super(condi, isToRun);
	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	@Override
	public void pAlongAtK(long prefix, int rmdB32, long[] ary, int atK) {

		if ((-rmdB32 & rmdB32) == rmdB32) { // O.l("up tmp=" + B32va.str16((int) tmp));

			if (rmdB32 == 0b0) // important

				ary[atK++] = prefix;
			else
				ary[atK++] = (prefix << B64W6.$6) | B32va.log2NPlus1(rmdB32);

			if (atK == k) // O.l("add=" + toStr(ary));s

				box.a(ary);
			else {

				tmp32 = ((int) (tmp >>> n * atK)) & baseB32;

				int myLowest1;

				// go along the right hand side, atK 是地圖指南
				pAlongAtK(B32va.log2NPlus1(myLowest1 = (-tmp32 & tmp32)), (~myLowest1 & tmp32), ary, atK);

			}

			return;

		}

		prefix <<= B64W6.$6;

		int myRmdB32 = rmdB32, lowest1;

		do
			if ((lowest1 = (-myRmdB32 & myRmdB32)) == myRmdB32) // O.l("lowest1=" + lowest1);

				pAlongAtK(prefix | B32va.log2NPlus1(lowest1), (~lowest1 & rmdB32), ary, atK);
			else
				pAlongAtK(prefix | B32va.log2NPlus1(lowest1), (~lowest1 & rmdB32), ary.clone(), atK);

		while ((myRmdB32 = (~lowest1 & myRmdB32)) != 0b0); // 子彈打完

	}

	/**
	 * The tail process of S2 function.<br/>
	 * The tail process of S2 function.<br/>
	 * S2: 水平组合後再垂直组合<br/>
	 * Onto: 水平排列後再垂直组合
	 */
	@Override
	public void cVert(final long prefix, int rmdB32) {

		int lowest1 = (-rmdB32 & rmdB32), dToShift = 0; // displacement from the first cell

		if (lowest1 == rmdB32) { // termination condition

			do {
				if (lowest1 < (((int) (prefix >>> dToShift)) & baseB32))
					return;

				if (ifEveryCellLegal(tmp = (prefix | (((long) lowest1) << dToShift)))) {

					tmp32 = ((int) tmp) & baseB32; // O.l("tmp32=" + B32va.str16(tmp32));

					int myLowest1;

					pAlongAtK(B32va.log2NPlus1(myLowest1 = (-tmp32 & tmp32)), (~myLowest1 & tmp32), new long[k], 0);

				}

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
	@Override
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

			if (k == n) {

				long[] tmpAry = new long[n];

				int idx = 0;
				do
					tmpAry[idx] = ++idx;

				while (idx != n);

				box.a(tmpAry);

				return;

			}

			if (k == 1) {

				KAryV32 retKAryV32 = new KAryV32(PCirc.int64(n));

				int tmp32 = (-baseB32 & baseB32);

				PCirc.colRecurWNEqK((~tmp32 & baseB32), B32va.log2NPlus1(tmp32), retKAryV32);

				// O.l("retKAryV32=" + retKAryV32.int32, THIS);

				while (retKAryV32.v-- != 0)

					box.a(new long[] { retKAryV32.k[retKAryV32.v] });

				return;

			}

			cHori(k - 1, 0b1, 0b10); // the 'A' symbol must be at the most left hand side

			return;

		}

		// min == 0

		min = 1; // important
		boundBit = 0b1 << n; // important

		for (; k != 0; k--) {

			// O.l("k=" + k, THIS);

			if (k == n) { // PCirc must first check k==n

				long[] tmpAry = new long[n];

				int idx = 0;
				do
					tmpAry[idx] = ++idx;

				while (idx != n);

				box.a(tmpAry);

				continue;

			}

			if (k == 1) {

				// O.l("n=" + n, THIS);

				KAryV32 retKAryV32 = new KAryV32(PCirc.int64(n));

				int tmp32 = (-baseB32 & baseB32);

				PCirc.colRecurWNEqK((~tmp32 & baseB32), B32va.log2NPlus1(tmp32), retKAryV32);

				while (retKAryV32.v-- != 0)

					box.a(new long[] { retKAryV32.k[retKAryV32.v] });

				continue;

			}

			nMulK = n * k;

			// O.l("nMulK=" + nMulK, THIS);

			cHori(k - 1, 0b1, 0b10); // the 'A' symbol must be at the most left hand side

		}
	}
}
