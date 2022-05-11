package lgpl3.prime64;

import java.io.Serializable;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 本類別 n1 與 ary32OfCompoBit.<br/>
 * It is like a ary32OfCompoBit which is attached to the integer.
 *
 * @version 2021/09/18_19:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ary32OfCompoBitWr" >Ary32OfCompoBitWr.java</a>
 *
 * @see Ary32OfCompoBitXy
 */
public class Ary32OfCompoBitWr implements Comparable<Ary32OfCompoBitWr>, Serializable {

	private static final Class<?> THIS = Ary32OfCompoBitWr.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * The int.<br/>
	 * The int.
	 */
	public final long n1;

	/**
	 * The int.<br/>
	 * The int.
	 */
	public final long n2;

	/**
	 * The array.<br/>
	 * The array.
	 */
	public final int[] ary32OfCompoBit;

	/**
	 * The offset.<br/>
	 * The offset.
	 */
	public final int offset;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public Ary32OfCompoBitWr(long n1, long n2, int[] ary32OfCompoBit, int offset) {

		this.n1 = n1;
		this.n2 = n2;

		this.ary32OfCompoBit = ary32OfCompoBit;

		this.offset = offset;

	}

	/**
	 * 比較彼此的 32 位元整數的大小.<br/>
	 * To compare to other's at0().
	 */
	@Override
	public int compareTo(Ary32OfCompoBitWr ary32OfCompoBitWr) {

		if (this.n1 > ary32OfCompoBitWr.n1)
			return 1;

		if (this.n1 < ary32OfCompoBitWr.n1)
			return -1;

		return 0;

	}

	/**
	 * 比較彼此的 32 位元整數的大小.<br/>
	 * To compare to other's at0().
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return B.O;

		if (obj instanceof Ary32OfCompoBitWr)
			return (((Ary32OfCompoBitWr) obj).n1 == this.n1);

		return super.equals(obj);

	}

	/**
	 * 找出輸入兩正整數之間所含質數數目.<br/>
	 * To count the number of primes between n1 and n2.
	 */
	public int countP() {

		long myN1 = this.n1;
		int count32 = 0;

		if (myN1 <= 2L && n2 > 1L) { // for n1= 1 ~ 2

			count32++;
			myN1 = 3L;

		}

		if ((((int) myN1) & 0b1) == 0b0 || myN1 == 1L) // n1 is even or [1 ~ 1, 0p]
			myN1++;

		int tmp32Not0;
		boolean b4;

		// O.lD("n1=" + O.f(this.n1) + " count=" + O.f(count), THIS);

		if ((tmp32Not0 = (int) (myN1 % 6)) == 1) // 6n + 1

			b4 = B.I;
		else {

			if (tmp32Not0 == 3) { // 6n + 3

				if (myN1 == 3L && myN1 <= n2) // fuck
					count32++;

				myN1 += 2; // 6n + 5

			}

			b4 = B.O;

		}

		b4 = !b4; // important

		for (; myN1 <= n2; myN1 += ((b4 = !b4) ? 4 : 2)) {

			tmp32Not0 = (((int) myN1) & 0b11_1111) >>> 1;

			if (((ary32OfCompoBit[((int) (myN1 >>> 6)) - offset] >>> tmp32Not0) & 0b1) == 0b0)
				count32++;

		}

		// O.lD("n1=" + O.f(this.n1) + " n2=" + O.f(n2) + " count=" + O.f(count), THIS);

		return count32;

	}

	/**
	 * To retrieve.<br/>
	 * To retrieve.
	 */
	public long[] retrieveP() {

		long n1 = this.n1;

		int lenByGuess = GuessFromGauss.guessTotalPNRetInt32(n1, n2);
		long[] retAry = new long[lenByGuess];

		int iKeep = 0; // the prime 2

		int tmp32Not0;

		if (n1 <= 2L && n2 > 1L) { // for n1= 1 ~ 2

			retAry[iKeep++] = 2L;
			n1 = 3L;

		}

		if ((((int) n1) & 0b1) == 0b0 || n1 == 1L) // n1 is even or [1 ~ 1, 0p]
			n1++;

		boolean b4;

		if ((tmp32Not0 = (int) (n1 % 6)) == 1) // 6n + 1
			b4 = B.I;

		else if (tmp32Not0 == 3) { // 6n + 3

			if (n1 == 3L && n1 <= n2) // fuck
				retAry[iKeep++] = n1;

			n1 += 2; // 6n + 5
			b4 = B.O;

		} else // 6n + 5
			b4 = B.O;

		b4 = !b4; // important

		for (; n1 <= n2; n1 += ((b4 = !b4) ? 4 : 2)) { // 檢查 5 以上

			if (((ary32OfCompoBit[((int) (n1 >>> 6)) - offset] >>> ((((int) n1) & 0b11_1111) >>> 1)) & 0b1) == 0b0) {

				if (iKeep == lenByGuess) {

					if (O.isDev)
						O.l("aryIdxOutOfBound n1=" + O.f(n1) + " n2=" + O.f(n2) + " len=" + O.f(lenByGuess), THIS);

					System.arraycopy(retAry, 0, (retAry = new long[lenByGuess <<= 1]), 0, iKeep);

				}

				retAry[iKeep++] = n1;

			}
		}

		////////////////////////////// O.delTailAll0

		for (tmp32Not0 = lenByGuess; --tmp32Not0 >= 0;)
			if (retAry[tmp32Not0] != 0L)
				break;

		if (++tmp32Not0 != lenByGuess) // 縮短陣列
			System.arraycopy(retAry, 0, (retAry = new long[tmp32Not0]), 0, tmp32Not0);

		//////////////////////////////

		// O.lD(retAry, THIS);

		return retAry;

	}
}
