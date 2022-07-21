package lgpl3.comb.thr;

import lgpl3.b64.B64va;
import lgpl3.comb.Pnk;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.thr.ThrWBox;

/**
 * 從 1 全相異數列中取出 n 個數.<br/>
 * To pick several numbers from a list of distinct numbers.
 *
 * @version 2021/04/27_11:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=ThrPnkBySpareB64" >ThrPnkBySpareB64.java</a>
 *
 * @see ThrPnkBySpareB64
 *
 * @see ThrCnkBySpareB64
 *
 * @see ThrToDCirc
 */
public class ThrPnkBySpareB64 extends ThrWBox<long[]> {

	// private static final Class<?> THIS = ThrPnkBySpareB64.class;

	public final long baseB64;

	public final int k;

	public int iLen = 0;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrPnkBySpareB64(long baseB64, int k, boolean isToRun) {

		this.baseB64 = baseB64; // O.l("baseB64=" + B32va.str16((int) baseB64) + O.S9 + THIS);

		this.k = k;

		box = new long[(int) Pnk.int64(Long.bitCount(baseB64), k)];

		if (isToRun)

			run();

	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public void colRecur(long rmdB64, long prefix, int lv) {

		long lowest1;

		prefix <<= B64W6.$6;

		if (--lv == 0) {

			do
				box[iLen++] = (prefix | B64va.log2NPlus1(lowest1 = (-rmdB64 & rmdB64)));

			while ((rmdB64 = (~lowest1 & rmdB64)) != 0b0L);

			return;

		}

		long tmp = rmdB64; // 子彈 // O.l("tmp=" + B64va.str(tmp));

		do
			colRecur((~(lowest1 = (-tmp & tmp)) & rmdB64), (prefix | B64va.log2NPlus1(lowest1)), lv);

		while ((tmp = (~lowest1 & tmp)) != 0b0L); // 子彈打完

	}

	@Override
	public void run() {

		colRecur(baseB64, 0b0L, k);
	}
}
