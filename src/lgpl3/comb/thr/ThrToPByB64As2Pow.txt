package lgpl3.comb.thr;

import lgpl3.b64.B64va;
import lgpl3.comb.Pnk;
import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.thr.ThrWBox;

/**
 * 從 1 全相異數列中取出 n 個數.<br/>
 * To pick several numbers from a list of distinct numbers.
 *
 * @version 2021/04/27_11:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=ThrToPByB64As2Pow" >ThrToPByB64As2Pow.java</a>
 *
 * @see ThrToPByB64As2Pow
 *
 * @see ThrToCBySpareB64As2Pow
 *
 * @see ThrToDCirc
 */
public class ThrToPByB64As2Pow extends ThrWBox<long[]> {

	// private static final Class<?> THIS = ThrToPByB64As2Pow.class;

	public final long baseB64;

	public final int k;

	public int iLen = 0;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrToPByB64As2Pow(long baseB64, int k, boolean isToRun) {

		this.baseB64 = baseB64;
		// O.l("baseB64=" + B32va.str16((int) baseB64) + O.S9 + THIS);

		this.k = k;
		box = new long[(int) Pnk.int64(B64va.countOf1(baseB64), k)];

		if (isToRun)
			run();

	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public void recur(long prefix, long rmdB64, int rmdKAsLv) {

		prefix <<= B64W6.$6;
		long lowest1;

		if (--rmdKAsLv == 0) {

			do
				box[iLen++] = (prefix | B64va.log2NPlus1(lowest1 = (-rmdB64 & rmdB64)));

			while ((rmdB64 = (~lowest1 & rmdB64)) != 0b0L);

			return;

		}

		long tmpRmdB64 = rmdB64; // 子彈
		// O.l("lowest1=" + lowest1);
		// O.l("r32=" + B32va.str16(r32));

		do
			recur((prefix | B64va.log2NPlus1(lowest1 = (-tmpRmdB64 & tmpRmdB64))), (~lowest1 & rmdB64), rmdKAsLv);

		while ((tmpRmdB64 = (~lowest1 & tmpRmdB64)) != 0b0L); // 子彈打完

	}

	@Override
	public void run() {

		recur(0b0L, baseB64, k);
	}
}
