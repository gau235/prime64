package lgpl3.comb.stirlingN.thr;

import lgpl3.b32.B32va;
import lgpl3.comb.filter.Condi;
import lgpl3.comb.stirlingN.S2nk;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.str.Strva;

/**
 * S2.<br/>
 * S2.
 *
 * @version 2022/02/09_15:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=ThrS2WDynaB64" >ThrS2WDynaB64.java</a>
 *
 */
public class ThrS2WDynaB64 extends ThrS2WDynaB64_A {

	private static final Class<?> THIS = ThrS2WDynaB64.class;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrS2WDynaB64(Condi condi, boolean isToRun) { // ThrS2WDynaB64(n,k) while 9*8 =72 超過 64 bit

		n = condi.n;
		k = condi.k;
		min = condi.min;

		max = condi.max;

		// boundBit = 0b1 << n;
		boundBit = (0b1 << (n - min + 1)); // important

		baseB32 = ~((-0b1) << n); // todo: (-1) change to -0b1

		nMulK = n * k;

		box = new long[(int) S2nk.int64ByDih(condi)];

		if (isToRun)

			run();

	}

	/**
	 * To convert.<br/>
	 * To convert.
	 */
	public long toB64NRev(int b32As2Pow) {

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

				if (ifEveryCellLegal(tmp = (prefix | (((long) lowest1) << dToShift)))) {

					if (!O.IS_LINUX || (iLen < Strva.maxRowInHtml))

						box[iLen++] = tmp; // to put on
					else
						return;

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

				box[iLen++] = baseB32;

				return;

			}

			if (k == n) {

				box[iLen++] = toB64NRev(baseB32); // O.l("baseB32=" + B32va.str(baseB32) , THIS);

				return;

			}

			cHori(k - 1, 0b1, 0b10); // the 'A' symbol must be at the most left hand side

			return;

		}

		// min == 0

		min = 1; // important
		boundBit = 0b1 << n; // important

		for (; k != 0; k--) { // O.l("tmpK=" + tmpK, THIS);

			if (k == 1) {

				box[iLen++] = baseB32;

				return;

			}

			if (k == n) {

				box[iLen++] = toB64NRev(baseB32); // O.l("baseB32=" + B32va.str(baseB32) , THIS);

				continue;

			}

			nMulK = n * k; // O.l("nMulK=" + nMulK, THIS);

			cHori(k - 1, 0b1, 0b10); // the 'A' symbol must be at the most left hand side

		}
	}
}
