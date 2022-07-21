package lgpl3.o.ary;

import java.util.Arrays;

import lgpl3.comb.filter.CompaForAryOfPrime;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.prime64.PrimeAry2D;

/**
 * 本類別二維陣列.<br/>
 * The wrapper for long[][]
 *
 * @version 2022/03/04_11:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ary2D" >Ary2D.java</a>
 *
 * @see Ary32_2D
 *
 * @see PrimeAry2D
 */
public class Ary2D extends Arr<long[]> {

	private static final Class<?> THIS = Ary2D.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * To convert.<br/>
	 * To convert.
	 */
	public static Ary2D toAry2D(Ary32_2D ary32_2D) {

		int[] ary32;
		long[] ary;

		int iBig, lenBig = ary32_2D.i, iSmall;

		long[][] aryOfAry = new long[lenBig][];

		for (iBig = 0; iBig != lenBig; iBig++) {

			ary32 = ary32_2D.arr[iBig];
			ary = new long[ary32.length];

			for (iSmall = 0; iSmall != ary32.length; iSmall++)

				ary[iSmall] = ary32[iSmall];

			aryOfAry[iBig] = ary;

		}

		return new Ary2D(aryOfAry);

	}

	/**
	 * 質數隊伍的建構方法.<br/>
	 * The constructor.
	 */
	public Ary2D() {

		super(long[].class);
	}

	/**
	 * 質數隊伍的建構方法.<br/>
	 * The constructor.
	 */
	public Ary2D(long[][] aryOfAry) {

		super(aryOfAry);
	}

	/**
	 * 排序.<br/>
	 * To sort.
	 */
	@Override
	public Ary2D sort() {

		Arrays.sort(arr, 0, i, CompaForAryOfPrime.COMPA);

		return this;

	}

	/**
	 * 把本 64 位元整數與 64 位元整數陣列伍所有 64 位元整數陣列內的數融合成 1 個陣列.<br/>
	 * To merge all numbers in long[] into one array.<br/>
	 * Note: from &lt;= index &lt; to
	 *
	 * @see PrimeAry2D#mergeIn1Ary(int, int)
	 */
	public long[] mergeIn1Ary() { // same as PrimeAry2D_A

		int totalLen = 0, idx = 0;

		for (; idx != i; idx++)

			totalLen += arr[idx].length;

		long[] retAry = new long[totalLen], tmpAry;

		totalLen = idx = 0; // 連用 2 個等號

		for (; idx != i; idx++, totalLen += tmpAry.length)

			System.arraycopy((tmpAry = arr[idx]), 0, retAry, totalLen, tmpAry.length);

		return retAry;

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	@Override
	public StringBuilder toStr() {

		StringBuilder ret = new StringBuilder(O.defLenForStr);

		int iBig, iSmall;
		long[] ary;

		for (iBig = 0; iBig != i;) {

			ary = arr[iBig++];

			for (iSmall = 0; iSmall != ary.length;) {

				ret.append(ary[iSmall++]);

				if (iSmall != ary.length)

					ret.append(O.STR_C44C32);

			}

			// O.l("ary.len=" + ary.length, THIS);

			if (iBig != i)

				ret.append(O.C_A_L);

		}

		return ret;

	}
}
