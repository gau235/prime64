package lgpl3.comb.stirlingN;

import lgpl3.b32.B32va;
import lgpl3.comb.Cnk;
import lgpl3.comb.filter.Condi;
import lgpl3.comb.filter.FilterInComb;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Ary32_2D;
import lgpl3.o.keyNV.KAry32V32;

/**
 * @version 2022/05/25_18:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=S2nk_B" >S2nk_B.java</a>
 *
 * @see S2nk_U
 */
public abstract class S2nk_B extends S2nk_A {

	private static final Class<?> THIS = S2nk_B.class;

	/**
	 * The tail process of S2 function.<br/>
	 * The tail process of S2 function.<br/>
	 * S2: 水平组合後再垂直组合<br/>
	 * Onto: 水平排列後再垂直组合
	 */
	// put on VS put upon
	public static void putOnVerticallyIfGt(int[] aryOfB32, final int rmdB32, Condi condi, Ary32_2D retAry32_2D) {

		B.n32++;

		int lowest1 = (-rmdB32 & rmdB32), idx = 0, tmp32, clonedAry32[];

		if (lowest1 == rmdB32) { // termination condition

			for (; idx != aryOfB32.length; idx++) { // for (int i = aryOfB32.length - 1; i >= iHorizontal; i--)

				if (lowest1 < (tmp32 = aryOfB32[idx])) // all items are distinct and 8 > 4+2+1

					return;

				(clonedAry32 = aryOfB32.clone())[idx] = (lowest1 | tmp32); // to put on

				// if (B32va.countOf1(tmp32) >= condi.min && B32va.countOf1(tmp32) <= condi.max) { // condi.max maybe n
				// O.l("lowest1=" + B32va.toStrByLog2AtB32BySAry(lowest1, O.S_ARY_A_Z));
				// O.l("idx=" + idx + " bitCount=" + B32va.countOf1(tmp32) , THIS);
				// O.l("=" + Cnk.toStrToCByB32As2PowBySAry(clonedAry32, O.S_ARY_A_Z, "|"));

				if (FilterInComb.ifEveryBitCountInAry32Between(clonedAry32, condi.min, condi.max))

					retAry32_2D.a(clonedAry32);

			}

			return;

		}

		for (; idx != aryOfB32.length; idx++) {

			if (lowest1 < (tmp32 = aryOfB32[idx]))

				return;

			if (B32va.countOf1(tmp32) < condi.max) {

				(clonedAry32 = aryOfB32.clone())[idx] = (lowest1 | tmp32); // to put on

				putOnVerticallyIfGt(clonedAry32, (~lowest1 & rmdB32), condi, retAry32_2D);

			} // else { O.l("FilterInComb here=" , THIS);}
		}
	}

	/**
	 * To collect.<br/>
	 * To collect.
	 */
	public static Ary32_2D colRecur(Condi condi) {

		Ary32_2D ret = new Ary32_2D();

		int baseB32 = ~(-0b1 << condi.n);

		// int newB32Base = 0b1 << (condi.n - condi.min + 1) - 0b1;
		int boundBit = (0b1 << (condi.n - condi.min + 1)); // important

		if (condi.k == 1) {

			ret.a(new int[] { baseB32 });

			return ret;

		}

		if (condi.n == condi.k) {

			ret.a(B32va.distributeOver1Ary32(baseB32));

			return ret;

		}

		KAry32V32 kAry32V32 = new KAry32V32(int64ByDih(condi));

		// the 'A' symbol must be at the most left hand side
		Cnk.colRecur(boundBit, (condi.k - 1), 0b1, 0b10, kAry32V32);

		////////////////////////
		// O.l(Cnk.strByAryOfB32As2Pow(kAry32V32.k), THIS);
		////////////////////////

		for (int idx = 0, keptB32; idx != kAry32V32.v; idx++)

			putOnVerticallyIfGt(B32va.distributeOver1Ary32(keptB32 = kAry32V32.k[idx]), (~keptB32 & baseB32), condi, ret);

		return ret;

	}

	/**
	 * min=0, To collect.<br/>
	 * min=0, To collect.
	 */
	public static Ary32_2D colToK(Condi condi) { // ThrS2WDynaB64(n,k) while 9*8 =72 超過 64 bit

		if (condi.n < condi.k) // 天然 自然的檢驗

			O.x("condi.n=" + condi.n + " condi.k=" + condi.k);

		Condi clonedCondi = condi.clone();
		clonedCondi.min = 1; // min starts from 1

		Ary32_2D retAry32_2D = new Ary32_2D(), tmpAry32_2D;

		for (int k = condi.k; k != 0; k--) {

			clonedCondi.k = k;

			retAry32_2D.appendAll((tmpAry32_2D = colRecur(clonedCondi)).arr, 0, tmpAry32_2D.i);

			// O.l("n", "k", clonedCondi.n, k);

		}

		return retAry32_2D;

	}
}
