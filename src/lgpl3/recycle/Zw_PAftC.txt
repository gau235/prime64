package lgpl3.recycle;

import lgpl3.b32.B32va;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Seq;
import lgpl3.o.thr.ThrWBox;

/**
 * 從 1 全相異數列中取出 n 個數.<br/>
 * To pick several numbers from a list of distinct numbers.
 *
 * @version 2022/03/29_21:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Zw_PAftC" >Zw_PAftC.java</a>
 *
 */
public class Zw_PAftC extends ThrWBox<Seq> { // 先 C 後 P, 輔助性質類別

	private static final Class<?> THIS = Zw_PAftC.class;

	public int n;

	public int k;

	public int boundBit;

	public int baseB32;

	public final int mask32;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public Zw_PAftC(int n, int k) {

		this.n = n;
		this.k = k;

		mask32 = ~((-0b1) << n);

		box = new Seq();

	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public void pRecurWNEqK(int keptB32, long prefix) {

		int rmdB32 = (baseB32 & ~keptB32);

		// O.l("baseB32=" + B32va.str16(baseB32), THIS);

		prefix <<= n;

		if ((rmdB32 & -rmdB32) == rmdB32) {

			box.a(prefix | B32va.log2NPlus1(rmdB32));

			return;

		}

		int lowest1;

		do
			pRecurWNEqK(keptB32 | (lowest1 = (rmdB32 & -rmdB32)), prefix | B32va.log2NPlus1(lowest1));

		while ((rmdB32 &= ~lowest1) != 0b0);

	}

	/**
	 * 從 1 列全相異數列中取出 k 個數.<br/>
	 * To pick several numbers from a list of distinct numbers.
	 */
	public void cRecur(int rmdK, int prefix, int curBit) {

		// O.l("rmdK=" + rmdK , THIS);

		if (--rmdK == 0) {

			do {

				baseB32 = (curBit | prefix);
				pRecurWNEqK(0b0, 0b0L);

			} while ((curBit <<= 1) != boundBit);

			return;

		}

		// if you pick 3 from [A,B,C,D] then at most you can start from B as [B,C,D] not [C,D,X]
		int newBoundBit = boundBit >>> rmdK;

		do
			cRecur(rmdK, (curBit | prefix), (curBit <<= 1));

		while (curBit != newBoundBit);

	}

	@Override
	public void run() {

		cRecur(k, 0b0, 0b1);
	}

	/**
	 * To string by B64W6.<br/>
	 * To string by B64W6.
	 */
	public StringBuilder toRowStr(long b64) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		// reverse
		long retB64 = 0b0L;

		do {

			retB64 |= (((int) b64) & mask32);

			if (((int) (b64 >>>= n)) == 0b0) // O.l("retB64=" + B64va.str(retB64), THIS);
				break;

			retB64 <<= n;

		} while (B.I);
		// end reverse

		do {

			retStr.append(((int) retB64) & mask32);

			if (((int) (retB64 >>>= n)) == 0b0)

				return retStr;

			retStr.append(O.C44);

		} while (B.I);

	}

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Ery to StringBuilder.
	 */
	public StringBuilder toStr() {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		long[] ary = box.ary;

		for (int idx = 0, len = box.iLen; idx != len;) {

			retStr.append(toRowStr(ary[idx]));

			if (++idx != len)
				retStr.append(O.C_A_L);

		}

		return retStr;

	}
}
