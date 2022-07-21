package lgpl3.comb.onto;

import lgpl3.comb.filter.Condi;
import lgpl3.comb.stirlingN.S2nk;
import lgpl3.o.O;

/**
 * 回傳 Onto 函數值; 求 m 本相異書分給 n 個小孩的方法數.<br/>
 * To return the number of that m distinguish books giving to n people<br/>
 * then everyone at least got one.<br/>
 * Onto(n,k)=C(k,0)*k^n -C(k,1)*(k-1)^n +C(k,2)*(k-2)^n- ... +-C(k,k-1)*1^n
 *
 * @version 2022/02/23_17:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Onto" >Onto.java</a>
 *
 * @see S2nk
 */
public abstract class Onto extends Onto_Z {

	// private static final Class<?> THIS = Onto.class;

	/**
	 * If passes test.<br/>
	 * If passes test.
	 */
	public static void test() {

		Condi condi = new Condi();

		for (int n = 10, k, min; n != 0; n--)

			for (k = n; k != 0; k--)

				for (min = n / k; min >= 1; min--) {

					condi.n = n;
					condi.k = k;
					condi.min = min;
					condi.max = n;

					condi.checkArg();

					if ((condi.min == 1) && (bigIntByToInEx(condi.n, condi.k).longValue() != int64ByToInEx(condi.n, condi.k)))

						O.x(condi.toStr());

					if (bigIntByHxy(condi).longValue() != int64ByHxy(condi))

						O.x(condi.toStr());

				}
	}
}
