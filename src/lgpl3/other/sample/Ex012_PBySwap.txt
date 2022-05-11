package lgpl3.other.sample;

import lgpl3.comb.Pnk;
import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Ary32va;
import lgpl3.o.ary.Seq;
import lgpl3.o.time.T64;

/**
 * Permutation.<br/>
 * Permutation.
 *
 * @version 2021/01/05_11:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex012_PBySwap" >Ex012_PBySwap.java</a>
 *
 */
public class Ex012_PBySwap {

	/**
	 * To string by B64W6.<br/>
	 * To string by B64W6.
	 */
	public static StringBuilder toStrNotRev(long b64W6) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		do {

			retStr.append(O.S_ARY_A_Z[(((int) b64W6) & B64W6.MASK32) - 1]);

			if (((int) (b64W6 >>>= B64W6.$6)) == 0b0)
				return retStr;

			retStr.append(O.C44);

		} while (B.I);

	}

	/**
	 * To string by B64W6.<br/>
	 * To string by B64W6.
	 */
	public static StringBuilder toStr(long[] ary) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		for (int i = 0; i != ary.length;) {

			retStr.append(toStrNotRev(ary[i]));

			if (++i != ary.length)
				retStr.append(O.C_A_L);

		}

		return retStr;

	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public static void p(long prefix, int len, int from, Seq retSeq) {

		++B.n32;

		int fromPlus1 = from + 1;
		if (fromPlus1 == len) {

			retSeq.a(prefix);

			return;

		}

		p(prefix, len, fromPlus1, retSeq); // do not swap

		for (int i = fromPlus1; i != len; i++)
			p(B64W6.swapVCell(prefix, from, i), len, fromPlus1, retSeq);

	}

	public static void main(String[] args) throws Throwable {

		int n = 12;
		int k = n;

		long prefix = B64W6.genB64W6ByAry32(Ary32va.genAscAry32From1(n));
		Seq retSeq = new Seq();

		if (n >= 11)
			retSeq.extLen(O.$MAX_LEN_OF_ARY >>> 1);

		long t0 = O.t();

		p(prefix, n, 0, retSeq); // todo: call Cva first

		O.l("costT=" + T64.difInF32Sec(t0));

		O.eq(retSeq.iLen, Pnk.int64(n, k));

		if (n <= 8)
			O.l("str=" + O.L + toStr(retSeq.trim().ary));

		O.l("len=" + O.f(retSeq.iLen));
		O.l("O.y32=" + O.f(B.n32));

		B.n32 = 0;

	}
}