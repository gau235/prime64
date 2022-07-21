package lgpl3.comb.thr;

import lgpl3.b32.B32va;
import lgpl3.b64.B64va;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Seq;
import lgpl3.o.thr.ThrWBox;

/**
 * 從 1 全相異數列中取出 n 個數.<br/>
 * To pick several numbers from a list of distinct numbers.
 *
 * @version 2022/02/01_23:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=ThrPWDynaB64" >ThrPWDynaB64.java</a>
 *
 * @see ThrPWDynaB64
 *
 * @see ThrCnkBySpareB64
 *
 * @see ThrToDCirc
 */
public class ThrPWDynaB64 extends ThrWBox<Seq> {

	private static final Class<?> THIS = ThrPWDynaB64.class;

	public final int n;

	public final int k;

	public final long baseB64;

	public final int dToShift; // displacement from the first cell

	public final long mask;

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public void col(long keptB64, int rmdK, long prefix) {

		long rmdB64 = (~keptB64 & baseB64), lowest1;

		// O.l("baseB64=" + B32va.str((int) baseB64) , THIS);
		// O.l("rmdB64=" + B32va.str((int) rmdB64) , THIS);

		prefix <<= dToShift;

		if (--rmdK == 0) {

			do {

				// O.l("lowest1=" + B32va.str((int) (lowest1)) , THIS);
				// long tmp = B64va.log2NPlus1(lowest1 = (rmdB64 & -rmdB64));
				// O.l("tmp=" + B32va.str((int) (prefix | tmp)) , THIS);

				box.a(prefix | B64va.log2NPlus1(lowest1 = (-rmdB64 & rmdB64)));

			} while ((rmdB64 &= ~lowest1) != 0b0L);

			return;

		}

		// O.l("keptB64", "rmdB64", B64va.str(keptB64), B64va.str(rmdB64));

		do
			col(keptB64 | (lowest1 = (-rmdB64 & rmdB64)), rmdK, (prefix | B64va.log2NPlus1(lowest1)));

		while ((rmdB64 &= ~lowest1) != 0b0L);

	}

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrPWDynaB64(int n, int k, boolean isToRun) {

		this.n = n;
		this.k = k;

		baseB64 = ~((-0b1L) << n);
		O.l("baseB64=" + B64va.str(baseB64), THIS);

		dToShift = B32va.biLog2NPlus1(n);
		O.l("dToShift=" + dToShift, THIS);

		mask = ~((-0b1L) << dToShift);
		O.l("mask=" + B64va.str(mask), THIS);

		box = new Seq();

		if (isToRun)
			run();

	}

	@Override
	public void run() {

		col(0b0L, k, 0b0L);
	}

	/**
	 * To string by B64W6.<br/>
	 * To string by B64W6.
	 */
	public StringBuilder toRowStr(long b64) {

		StringBuilder retStr = new StringBuilder(O.defLenForStr);

		// reverse
		long retB64 = 0b0L;
		do {
			retB64 |= (((int) b64) & mask);

			if (((int) (b64 >>>= dToShift)) == 0b0) // O.l("retB64=" + B64va.str(retB64), THIS);
				break;

			retB64 <<= dToShift;

		} while (B.I);
		// end reverse

		do {
			retStr.append(((int) retB64) & mask);

			if (((int) (retB64 >>>= dToShift)) == 0b0)
				return retStr;

			retStr.append(O.C44);

		} while (B.I);

	}

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Ery to StringBuilder.
	 */
	public StringBuilder toStr() {

		StringBuilder retStr = new StringBuilder(O.defLenForStr);

		long[] ary = box.ary;
		int len = box.i;

		for (int idx = 0; idx != len;) {

			retStr.append(toRowStr(ary[idx]));

			if (++idx != len)
				retStr.append(O.C_A_L);

		}

		return retStr;

	}
}
