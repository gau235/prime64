package lgpl3.other.sample;

import lgpl3.o.O;
import lgpl3.o.ary.Ary32_2D;

/**
 * Matrix.<br/>
 * Matrix.
 *
 * @version 2022/04/17_09:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex274_MatrixChain" >Ex274_MatrixChain.java</a>
 *
 */
public class Ex274_MatrixChain {

	// A=4*3 B=3*2 C=2*5
	// public static int[] chain = { 0, 4, 3, 2, 5 }; // 4*3*2 + 4*2*5 VS 3*2*5 + 4*3*5

	public static int[] chain = { 0, 8, 4, 10, 3, 20, 4 };

	public static int n = chain.length - 2;

	public static int[][] costM = new int[n + 1][n + 1];

	public static int[][] midM = new int[n + 1][n + 1];

	public static void main(String[] sAry) {

		// Ary32_2D.fill(costM, 9999);

		int i, j, k, gap, tmpCost;

		String myS;
		char cI, cJ, cK;

		for (gap = 1; gap < n; gap++)

			for (i = 1, j = i + gap; j <= n; i++, j++) {

				cI = (char) (64 + i);
				cJ = (char) (64 + j);

				O.l("costM " + cI + "," + cJ);

				costM[i][j] = 9_999;

				for (k = i; k < j; k++) {

					tmpCost = costM[i][k] + costM[k + 1][j] + chain[i] * chain[k + 1] * chain[j + 1];

					if (tmpCost < costM[i][j]) {

						cK = (char) (64 + k);

						myS = cI + "X" + cJ + "=>" + cI + "~" + cK + "X[other] new " + cI + "~" + cJ + "= " + tmpCost;

						O.l(myS);

						costM[i][j] = tmpCost;

						midM[i][j] = k;

					}
				}
			}

		O.l("costM=" + O.L + Ary32_2D.toStr(costM));

		O.l("A X " + ((char) (64 + n)) + " thru " + ((char) (64 + midM[1][n])));
		O.l("midM=" + O.L + Ary32_2D.toMatrixStr(midM));

	}
}
