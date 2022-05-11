package lgpl3.comb.onto.thr;

import lgpl3.b32.B32va;
import lgpl3.comb.b64W6.B64W6;
import lgpl3.comb.filter.Condi;
import lgpl3.comb.stirlingN.thr.ThrS2PWDynaB64;
import lgpl3.o.B;

/**
 * Onto.<br/>
 * Onto.
 *
 * @version 2022/02/23_11:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=ThrOntoPWDynaB64" >ThrOntoPWDynaB64.java</a>
 *
 */
public class ThrOntoPWDynaB64 extends ThrS2PWDynaB64 {

	private static final Class<?> THIS = ThrOntoPWDynaB64.class;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrOntoPWDynaB64(Condi condi, boolean isToRun) {

		super(condi, isToRun);
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

		// O.l("lowest1=" + B32va.str16(lowest1), THIS);

		if (lowest1 == rmdB32) { // termination condition

			do
				if (lowest1 > (((int) (prefix >>> dToShift)) & baseB32))

					if (ifEveryCellLegal(tmp = prefix | (((long) lowest1) << dToShift)))

						pAlongAtK(0b0L, (((int) tmp) & baseB32), new long[k], 0);

			while ((dToShift += n) != nMulK);

			return;

		}

		do
			if (lowest1 > (tmp32 = ((int) (prefix >>> dToShift)) & baseB32))

				if (B32va.countOf1(tmp32) < max)

					cVert(prefix | (((long) lowest1) << dToShift), (~lowest1 & rmdB32));

		while ((dToShift += n) != nMulK);

	}

	/**
	 * 從 1 列全相異數列中取出 k 個數.<br/>
	 * To pick several numbers from a list of distinct numbers.
	 */
	public void pHori(int keptB32, int rmdK, long prefix) {

		int rmdB32 = (~keptB32 & baseB32), lowest1;

		// O.l("rmdB32=" + B32va.str16(rmdB32), THIS);

		prefix <<= n;

		if (--rmdK == 0) {

			do {
				B.n++;

				lowest1 = (-rmdB32 & rmdB32);

				if ((keptB32 & 0b1) == 0b0) { // 基礎橫列必含有 A

					if ((lowest1 & 0b1) != 0b0)

						cVert((prefix | 0b1), (~(keptB32 | 0b1) & baseB32));

					return; // 最多只有一次 後續沒有了

				} else
					cVert((prefix | lowest1), (~(keptB32 | lowest1) & baseB32));

			} while ((rmdB32 = (~lowest1 & rmdB32)) != 0b0);

			return; // 記得寫 return

		}

		do
			pHori(keptB32 | (lowest1 = (-rmdB32 & rmdB32)), rmdK, (prefix | lowest1));

		while ((rmdB32 = (~lowest1 & rmdB32)) != 0b0);

	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public void colWNEqK(long prefix, int keptB32) {

		int rmdB32 = (~keptB32 & baseB32);

		prefix <<= B64W6.$6;

		if ((-rmdB32 & rmdB32) == rmdB32) { // O.l("add=" + toStr(new long[] { prefix | B32va.log2NPlus1(rmdB32) }));

			box.a(new long[] { prefix | B32va.log2NPlus1(rmdB32) });

			return;

		}

		int lowest1;
		do
			colWNEqK(prefix | B32va.log2NPlus1(lowest1 = (-rmdB32 & rmdB32)), (keptB32 | lowest1));

		while ((rmdB32 = (~lowest1 & rmdB32)) != 0b0); // 子彈打完

	}

	@Override
	public void run() {

		if (n == k) {

			colWNEqK(0b0L, 0b0);

			return;

		}

		// baseB32 = baseB32 >>> (min - 1); // todo: 基礎橫列必定要含有 A

		pHori(0b0, k, 0b0L);

	}
}
