package lgpl3.comb.onto;

import lgpl3.comb.PInEx;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.comb.filter.Condi;
import lgpl3.comb.stirlingN.S2nk;
import lgpl3.o.O;
import lgpl3.shareWXyz.Hxy;

/**
 * @version 2022/02/01_10:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Onto_Z" >Onto_Z.java</a>
 *
 * @see Onto
 */
public abstract class Onto_Z extends Onto_J {

	// private static final Class<?> THIS = Onto_Z.class;

	/**
	 * 回傳 Onto 函數值; 求 n 本相異書分給 k 個人的方法數.<br/>
	 * To return the number of ways to give n distinguish books to k people<br/>
	 * then everyone at least gets one book.<br/>
	 * Onto(n,k)=C(k,0)*k^n -C(k,1)*(k-1)^n +C(k,2)*(k-2)^n- ... +-C(k,k-1)*1^n
	 *
	 * @see PInEx#script(int, int, CharSequence)
	 */
	public static StringBuilder scriptByToInEx(Condi condi, CharSequence lineWr) {

		StringBuilder ret = new StringBuilder(O.defLenForStr);

		for (int i = 0, kMinus1 = condi.k - 1; i != condi.k; i++) {

			if ((i & 0b1) == 0b0)

				ret.append("C(").append(condi.k).append(O.C44).append(i).append(")*").append(condi.k - i).append(O.C94).append(condi.n)
						.append(O.C32);

			else {

				ret.append("-C(").append(condi.k).append(O.C44).append(i).append(")*").append(condi.k - i).append(O.C94).append(condi.n)
						.append(O.C32);

				if (i != kMinus1) // its a special case and do not use ++i != condi.k

					ret.append(lineWr).append(O.C43);

			}
		}

		return ret;

	}

	/**
	 * 回傳 Onto 函數值; 求 n 本相異書分給 k 個人的方法數.<br/>
	 * To return the number of ways to give n distinguish books to k people<br/>
	 * then everyone at least gets one book.<br/>
	 * Onto(n,k)=C(k,0)*k^n -C(k,1)*(k-1)^n +C(k,2)*(k-2)^n- ... +-C(k,k-1)*1^n
	 *
	 * @see S2nk#script(Condi, CharSequence)
	 */
	public static StringBuilder scriptByS2(Condi condi, CharSequence lineWr) { // script by S2, min must be > 0

		return new StringBuilder(Integer.toString(condi.k)).append("!*[").append(S2nk.script(condi, lineWr)).append(O.C93);
	}

	/**
	 * script.<br/>
	 * script.
	 */
	public static StringBuilder script(Condi condi, CharSequence lineWr) {

		StringBuilder ret = new StringBuilder(O.defLenForStr);

		final int diff = condi.min - 1; // reduced for performance
		long[] ary = Hxy.col(condi.n, condi.k, condi.min, condi.max);

		long b64W6ForC;

		int tmp, restN = condi.n;

		for (int iAry = 0; iAry != ary.length;) {

			b64W6ForC = B64W6.revAmongVCell(ary[iAry]);
			// O.l("b64W6ForC=" + B64W6.str24((int) b64W6ForC), THIS);

			while (b64W6ForC != 0b0L) {

				tmp = (((int) b64W6ForC) & B64W6.MASK32) + diff;

				ret.append("C(").append(restN).append(O.C44).append(tmp).append(O.C41);

				restN -= tmp;

				if ((b64W6ForC >>>= B64W6.$6) != 0b0L)
					ret.append(O.C42);

			}

			if (++iAry < ary.length) {

				ret.append(lineWr).append(O.C43);
				restN = condi.n;

			}
		}

		return ret;

	}
}
