package lgpl3.comb;

import java.util.Arrays;

import lgpl3.b32.B32va;
import lgpl3.comb.b64W6.B64W6;
import lgpl3.comb.selfCallva.SelfCallva;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Ary32va;
import lgpl3.o.ary.Aryva;
import lgpl3.o.keyNV.KAryV32;

/**
 * C(2n,n)-C(2n,n-1)<br/>
 * CatalanNum(4)=14
 *
 * @version 2022/04/06_11:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=CatalanNum" >CatalanNum.java</a>
 *
 * @see SelfCallva
 */
public abstract class CatalanNum {

	private static final Class<?> THIS = CatalanNum.class;

	public static final int ID_AS_WIN = 0b01;

	public static final int ID_AS_LOSE = 0b10;

	/**
	 * Catalan number.<br/>
	 * C(2n,n)-C(2n,n-1)
	 */
	public static long int64(int n) {

		return (Cnk.int64(n << 1, n) / (n + 1));
	}

	/**
	 * C(2n,n)-C(2n,n-1)<br/>
	 * C(2n,n)-C(2n,n-1)
	 */
	public static void winOrLose(final int totalW, long prefix, int countW, int countL, KAryV32 allRet) { // first time must be 0b1L

		// if (++B.n32 > 15) O.x();

		if (countW == totalW) {

			if (countW > countL) {

				B32va.l((countW + countL), "prefix=" + B64W6.strByVCellAftRev(prefix) + " W > L 補滿");

				do
					prefix = ((prefix << B64W6.$6) | ID_AS_LOSE); // O.l("loop=" + B64W6.str24(prefix));

				while (++countL != countW);

				allRet.ary[allRet.int32++] = prefix; // allRet.a(prefix);

				return;

			}

			// if (countW == countL)

		}

		// countW < totalWin

		if (countW > countL) {

			B32va.l((countW + countL), "prefix=" + B64W6.strByVCellAftRev(prefix) + " W > L");

			winOrLose(totalW, ((prefix << B64W6.$6) | ID_AS_WIN), (countW + 1), countL, allRet);
			winOrLose(totalW, ((prefix << B64W6.$6) | ID_AS_LOSE), countW, (countL + 1), allRet);

			return;

		}

		B32va.l((countW + countL), "prefix=" + B64W6.strByVCellAftRev(prefix) + " W == L");

		winOrLose(totalW, ((prefix << B64W6.$6) | ID_AS_WIN), (countW + 1), countL, allRet);

	}

	/**
	 * C(2n,n)-C(2n,n-1)<br/>
	 * C(2n,n)-C(2n,n-1)
	 */
	public static void push(long base, long stack, long ret, KAryV32 allRet) {

		// O.l("bef push base=" + B64W6.str24(base));
		// O.l("bef push in=" + B64W6.str24(in));
		// O.l("bef push out=" + B64W6.str24(out));

		// if (base == 0b0L) return;

		// O.l("push vCell=" + B64W6.str24(vCell=(int) (base & B64W6.MASK32)));

		stack = (stack << B64W6.$6) | (base & B64W6.MASK32); // vCell= (int) (base & B64W6.MASK32)

		pushPop((base >>> B64W6.$6), stack, ret, allRet);

	}

	/**
	 * C(2n,n)-C(2n,n-1)<br/>
	 * C(2n,n)-C(2n,n-1)
	 */
	public static void pop(long base, long stack, long ret, KAryV32 allRet) {

		ret = (ret << B64W6.$6) | (stack & B64W6.MASK32); // vCell= (int) (stack & B64W6.MASK32)

		pushPop(base, (stack >>> B64W6.$6), ret, allRet);

	}

	/**
	 * C(2n,n)-C(2n,n-1)<br/>
	 * C(2n,n)-C(2n,n-1)
	 */
	public static void pushPop(long base, long stack, long ret, KAryV32 allRet) {

		if (base == 0b0L) {

			// O.l("bef ret= base=" + B64W6.str24(base));
			// O.l("bef ret= in=" + B64W6.str24(in));
			// O.l("bef ret= out=" + B64W6.str24(out));

			// stack 此情況下不空

			do
				ret = (ret << B64W6.$6) | (stack & B64W6.MASK32); // O.l("loop out=" + B64W6.str24(out));

			while ((stack >>>= B64W6.$6) != 0b0L);

			allRet.ary[allRet.int32++] = ret;

			// B32va.l(0, null, 0);

			// O.l("ret=" + B64W6.toStrByVCellMinus1BySAry(out, O.S_ARY_A_Z));

			return;

		}

		push(base, stack, ret, allRet);

		if (stack != 0b0L)

			pop(base, stack, ret, allRet);

	}

	public static void main1(String[] sAry) throws Throwable {

		int n = 3;

		sAry = new String[] { "W", "L" };

		KAryV32 allRet = new KAryV32(int64(n));

		winOrLose(n, ID_AS_WIN, 1, 0, allRet);

		long[] aryAsSet = Aryva.checkDup(allRet.ary);

		Arrays.sort(aryAsSet);

		for (int idx = 0, size = aryAsSet.length; idx != size; idx++)

			O.l(B64W6.strByVCellMinus1AftRevBySAry(aryAsSet[idx], sAry));

		O.l("len=" + O.eq(allRet.int32, aryAsSet.length));

		B.n32 = 0;

	}

	public static void main(String[] sAry) throws Throwable {

		main1(null);

		int n = 3;

		long base = B64W6.genB64W6ByAry32(Ary32va.genAscAry32From1(n));

		O.l("init base=" + B64W6.str24(base), THIS);

		KAryV32 allRet = new KAryV32(int64(n));

		pushPop(base, 0b0L, 0b0L, allRet);

		long[] aryAsSet = Aryva.checkDup(allRet.ary);

		Arrays.sort(aryAsSet);

		for (int idx = 0, size = aryAsSet.length; idx != size; idx++)

			O.l(B64W6.strByVCellMinus1AftRevBySAry(aryAsSet[idx], O.S_ARY_A_Z));

		O.l("len=" + O.eq(allRet.int32, aryAsSet.length));

	}
}
