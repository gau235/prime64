package lgpl3.o.ary;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * The wrapper for int[][]<br/>
 * The wrapper for int[][]
 *
 * @version 2022/03/27_09:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ary32_2D" >Ary32_2D.java</a>
 *
 * @see Ary2D
 */
public class Ary32_2D extends Arr<int[]> {

	private static final Class<?> THIS = Ary32_2D.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * 質數隊伍的建構方法.<br/>
	 * The constructor.
	 */
	public Ary32_2D() {

		super(int[].class);
	}

	/**
	 * 質數隊伍的建構方法.<br/>
	 * The constructor.
	 */
	public Ary32_2D(int[][] aryOfAry32) {

		super(aryOfAry32);
	}

//	/**
//	 * 加 all 個項到此伍末之後.<br/>
//	 * To append the all to after the iLen of this.
//	 */
//	public void appendAll(Ary32_2D otherAry32_2D) { // appendAll(int[][]) 有爭議
//
//		int lenPlusOtherLen = iLen + otherAry32_2D.iLen;
//
//		if (lenPlusOtherLen >= fixedLen)
//
//			extLen(lenPlusOtherLen);
//
//		System.arraycopy(otherAry32_2D.arr, 0, arr, iLen, otherAry32_2D.iLen);
//
//		iLen = lenPlusOtherLen;
//
//		for (int idx = 0; idx != iLen; idx++)
//
//			O.l("idx " + idx + "=" + arr[idx]);
//
//	}

	/**
	 * To fill.<br/>
	 * To fill.
	 */
	public static int[][] fill(int[][] ary32_2D, int v32) {

		int iBig, iSmall;
		int[] ary32;

		for (iBig = 0; iBig != ary32_2D.length; iBig++) {

			ary32 = ary32_2D[iBig];

			for (iSmall = 0; iSmall != ary32.length; iSmall++)

				ary32[iSmall] = v32;

		}

		O.l("fill=" + O.L + Ary32_2D.toStr(ary32_2D) + O.L + O.S64 + THIS);

		return ary32_2D;

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	@Override
	public StringBuilder toStr() {

		StringBuilder retStr = new StringBuilder(O.defLenForStr);

		int iBig, iSmall;
		int[] ary32;

		for (iBig = 0; iBig != i;) {

			ary32 = arr[iBig++];

			for (iSmall = 0; iSmall != ary32.length;) {

				retStr.append(ary32[iSmall++]);

				if (iSmall != ary32.length)

					retStr.append(O.STR_C44C32);

			}

			// O.l("ary32.length=" + ary32.length, THIS);

			if (iBig != i)

				retStr.append(O.C_A_L);

		}

		return retStr;

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public static StringBuilder toStr(int[][] ary32_2D) {

		StringBuilder retStr = new StringBuilder(O.defLenForStr);

		int iBig, iSmall;
		int[] ary32;

		for (iBig = 0; iBig != ary32_2D.length;) {

			ary32 = ary32_2D[iBig++];

			for (iSmall = 0; iSmall != ary32.length;) {

				retStr.append(ary32[iSmall++]);

				if (iSmall != ary32.length)

					retStr.append(O.STR_C44C32);

			}

			if (iBig != ary32_2D.length)

				retStr.append(O.C_A_L);

		}

		return retStr;

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public static StringBuilder toMatrixStr(int[][] ary32_2D) {

		StringBuilder retStr = new StringBuilder(O.defLenForStr);

		int iBig, iSmall, v32;
		int[] ary32;

		for (iBig = 1; iBig != ary32_2D.length;) {

			ary32 = ary32_2D[iBig++];

			for (iSmall = 1; iSmall != ary32.length;) {

				retStr.append((v32 = ary32[iSmall++]) == 0 ? O.C48 : (char) (64 + v32));

				if (iSmall != ary32.length)

					retStr.append(O.STR_C44C32);

			}

			if (iBig != ary32_2D.length)

				retStr.append(O.C_A_L);

		}

		return retStr;

	}
}
