package lgpl3.comb.selfCallva;

import lgpl3.o.O;

/**
 * 本類別後退式自己呼叫自己的人.<br/>
 * To call self backward.
 *
 * @version 2021/09/02_22:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=BackwardSelfCallva_A" >BackwardSelfCallva_A.java</a>
 *
 * @see Recur
 */
public abstract class BackwardSelfCallva_A extends SelfCallva {

	// private static final Class<?> THIS = BackwardSelfCallva_A.class;

	/**
	 * 河內塔的演算法, 將第 1 根有盤子的柱子 A, 搬動到第 2 根柱子 B, 搬動的過程中可利用第 3 根柱子 T.<br/>
	 * Tower Of Hanoi recursion.
	 */
	public static StringBuilder towerOfHanoi(char from, char to, char tmp, final int n, final StringBuilder str) {

		if (n == 1)

			return str.append(O.C49).append(charSeqAsSeparator).append(from).append(O.C45).append(O.C62).append(to).append(lineWr);
		else {

			str.append(towerOfHanoi(from, tmp, to, n - 1, new StringBuilder(O.defLenForStr)));

			str.append(n).append(charSeqAsSeparator).append(from).append(O.C45).append(O.C62).append(to).append(lineWr);

			str.append(towerOfHanoi(tmp, to, from, n - 1, new StringBuilder(O.defLenForStr)));

			return str;

		}
	}

	/**
	 * 河內塔的演算法, 將第 1 根有盤子的柱子 A, 搬動到第 2 根柱子 B, 搬動的過程中可利用第 3 根柱子 T.<br/>
	 * Tower Of Hanoi recursion.
	 */
	public static StringBuilder towerOfHanoi(char from, char to, char tmp, final int n) {

		return towerOfHanoi(from, to, tmp, n, new StringBuilder(O.defLenForStr));
	}
}
