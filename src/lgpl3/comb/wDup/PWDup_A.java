package lgpl3.comb.wDup;

import java.io.Serializable;

import lgpl3.comb.Pnk;
import lgpl3.o.B;
import lgpl3.shareWXyz.Hxy;
import lgpl3.shareWXyz.ShareWXyzVal;

/**
 * @version 2019/08/17_18:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=PWDup_A" >PWDup_A.java</a>
 *
 * @see PWDup_V
 */
public abstract class PWDup_A implements Serializable {

	private static final Class<?> THIS = PWDup_A.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * To permutate with duplicated char.<br/>
	 * To permutate with duplicated char.
	 */
	public static long int64ByHxy(int k, int lenOfDistinctCharAry, long b64W6OfQtyPlus1) {

		long[] ary = Hxy.colWLim0ToMax(k, lenOfDistinctCharAry, b64W6OfQtyPlus1);
		final long factorialOfK = Pnk.int64(k);

		long ans = 0L;

		for (int idx = 0; idx != ary.length; idx++)

			ans += ShareWXyzVal.factorialNDiv(factorialOfK, ary[idx]);

		return ans;

	}
}
