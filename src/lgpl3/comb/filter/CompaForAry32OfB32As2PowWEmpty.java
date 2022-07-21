package lgpl3.comb.filter;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

import lgpl3.b32.B32va;
import lgpl3.o.B;

/**
 * 32 位元整數陣列比較器.<br/>
 * The comparator of int[].
 *
 * @version 2022/01/31_12:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=CompaForAry32OfB32As2PowWEmpty" >
 *          CompaForAry32OfB32As2PowWEmpty.java</a>
 *
 * @see CompaForAry32OfB32As2Pow
 *
 * @see CompaForAry32OfB32As2PowWEmpty
 *
 * @see CompaForAryOfB64W6
 */
public class CompaForAry32OfB32As2PowWEmpty implements Comparator<int[]>, Serializable {

	// private static final Class<?> THIS = CompaForAry32OfB32As2PowWEmpty.class;

	private static final long serialVersionUID = B.genId32(CompaForAry32OfB32As2PowWEmpty.class);

	/**
	 * To compare.<br/>
	 * To compare.
	 */
	public static int compa(int[] ary32OfB32As2PowA, int[] ary32OfB32As2PowB) {

		int lenOrLenMinus1 = ary32OfB32As2PowA.length;
		if ((lenOrLenMinus1 -= ary32OfB32As2PowB.length) != 0)
			return lenOrLenMinus1;

		// 第一輪先比每個房間內部人數
		lenOrLenMinus1 = ary32OfB32As2PowA.length - 1; // 最後一個不用比

		int idx = 0, myC;
		for (; idx != lenOrLenMinus1; idx++) {

			// O.l("bitCountA=" + bitCountA + ", bitCountB=" + bitCountB, THIS);

			// StringBuilder str1 = Strva.toStrToOntoByB32As2Pow(ary32OfB32As2PowA[i]);
			// StringBuilder str1 = B32va.toStrByLog2AtB32(ary32OfB32As2PowA[i]);
			// O.l("str1=" + str1, THIS);

			if ((myC = (B32va.countOf1(ary32OfB32As2PowB[idx]) - B32va.countOf1(ary32OfB32As2PowA[idx]))) != 0) // 反向
				return myC;

		}

		// 第二輪針對每一個房間內的人名比順序
		for (idx = 0; idx != lenOrLenMinus1; idx++)

			if ((myC = CompaForAry32OfB32As2Pow.compaToSelSort(ary32OfB32As2PowA[idx], ary32OfB32As2PowB[idx])) != 0)
				return myC;

		return 0;

	}

	/**
	 * 內建的比較器.<br/>
	 * The Comparator inside.
	 */
	public static final CompaForAry32OfB32As2PowWEmpty COMPA = new CompaForAry32OfB32As2PowWEmpty();

	/**
	 * 內建的比較器 (反向).<br/>
	 * The Comparator inside.
	 */
	public static final Comparator<int[]> REV_COMPA = Collections.reverseOrder(COMPA);

	@Override
	public int compare(int[] ary32OfB32As2PowA, int[] ary32OfB32As2PowB) {

		return compa(ary32OfB32As2PowA, ary32OfB32As2PowB);
	}
}