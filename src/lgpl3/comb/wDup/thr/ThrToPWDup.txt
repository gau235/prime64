package lgpl3.comb.wDup.thr;

import java.util.Arrays;

import lgpl3.b64.B64va;
import lgpl3.comb.b64W6.B64W6;
import lgpl3.comb.wDup.DatWDup;
import lgpl3.o.ary.Seq;
import lgpl3.o.thr.ThrWBox;

/**
 * To pick with duplicated.<br/>
 *
 * @version 2019/08/17_18:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=ThrToPWDup" >ThrToPWDup.java</a>
 *
 * @see ThrToCWDup
 */
public class ThrToPWDup extends ThrWBox<DatWDup> {

	// private static final Class<?> THIS = ThrToPWDup.class;

	protected long allB64As2Pow;

	protected final int k;

	protected long tmp64;

	public Seq tmpSeq = new Seq();

	/**
	 * To convert.<br/>
	 * To convert.
	 */
	public static long convertVal32NPlus1InB64W6(long b64W6OfQRPlus1) {

		b64W6OfQRPlus1 = B64W6.revAmongVCell(b64W6OfQRPlus1);

		long retB64W6 = 0b0L;

		int v32;

		do {

			v32 = (((int) b64W6OfQRPlus1 & B64W6.MASK32) - 1) / DatWDup.DEF_DIVISOR_INT32 + 1; // must plus 1

			retB64W6 = ((retB64W6 << B64W6.$6) | v32);

		} while ((b64W6OfQRPlus1 >>>= B64W6.$6) != 0b0L);

		return retB64W6;

	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public void reGo(long prefixB64W6) {

		// O.l("prefix=" + O.L + B64W6.str24(prefix));

		long prefixB64As2Pow = B64W6.toB64As2PowByB6Cell(prefixB64W6);

		long rmdB64 = allB64As2Pow ^ prefixB64As2Pow;
		long lowest1;
		int v32;

		if ((k - B64va.countOf1(prefixB64As2Pow)) == 1) {

			for (; rmdB64 != 0b0L; rmdB64 = rmdB64 ^ lowest1) {

				lowest1 = (rmdB64 & -rmdB64);
				v32 = B64va.log2NPlus1(lowest1);

				// seq.add((prefixB64W6 << B64W6.$NUM_OF_BIT_PER_CELL_INT32) | (long) value32);

				tmp64 = (prefixB64W6 << B64W6.$6) | v32;
				tmp64 = convertVal32NPlus1InB64W6(tmp64);

				if (box.ifPassToInEx(tmp64)) {

					// box.Map.putNCount(tmp64);// easyPutNCount
					tmpSeq.a(tmp64);
					box.total32ToP++;

				}

				// box.addAftPassedInExNCount((prefixB64W6 << B64W6.$NUM_OF_BIT_PER_CELL_INT32) | (long) value32);
				// O.l("prefixB64W6=" + O.L + B64W6.str24(prefixB64W6) + O.S44 + THIS);

				// err:
				// prefixB64W6 = ((prefixB64W6 << B64W6.$NUM_OF_BIT_PER_CELL_INT32) | (long) value32);
				// box.addAftPassedInExNCount(prefixB64W6);

			}

			return;

		}

		for (; rmdB64 != 0b0L; rmdB64 = rmdB64 ^ lowest1) {

			lowest1 = (rmdB64 & -rmdB64);
			v32 = B64va.log2NPlus1(lowest1);

			if (!box.isToEx(convertVal32NPlus1InB64W6(tmp64 = (prefixB64W6 << B64W6.$6) | v32)))
				reGo(tmp64);

		}
	}

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrToPWDup(DatWDup datWDup) {

		box = datWDup;

		this.allB64As2Pow = datWDup.b64As2PowOfQRPlus1;

		this.k = datWDup.k;

	}

	@Override
	public void run() {

		reGo(0b0L);

		long[] aryOfB64 = tmpSeq.trim().ary;
		Arrays.sort(aryOfB64); // fuck

		for (int i = 0; i != aryOfB64.length; i++)
			box.mapK64V32.easyPutNCount(aryOfB64[i]);

	}
}
