package lgpl3.comb.wDup;

import java.util.Arrays;

import lgpl3.comb.wDup.thr.ThrToPWDup;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Aryva;
import lgpl3.shareWXyz.HxyVal;
import lgpl3.shareWXyz.Hxy;

/**
 * @version 2019/08/17_18:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=PWDup" >PWDup.java</a>
 *
 * @see Hxy
 */
public abstract class PWDup extends PWDup_V {

	private static final Class<?> THIS = PWDup.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * If passes test.<br/>
	 * If passes test.
	 */
	@SuppressWarnings("unused")
	public static void main(String[] sAry) throws Throwable {

		test1: {

			String s = "A,A,A,A,A,A,B,B,B,B,B,B,C,C,C,C,C,C,D,D,D,D,D,D,E,E,E,E,E,E,F,F,F,F,F,F";
			int k = 3;

			DatWDup datWDup = new DatWDup();

			datWDup.oriS = s;
			datWDup.k = k;

			datWDup.initAll();

			long ans = HxyVal.int64WLim0ToMax(k, datWDup.distinctSortedSAry.length, datWDup.b64W6OfQtyPlus1ToHxy);

			long[] ary = Hxy.colWLim0ToMax(k, datWDup.distinctSortedSAry.length, datWDup.b64W6OfQtyPlus1ToHxy);

			Arrays.sort(ary);
			Aryva.checkDup(ary);

			O.eq(O.eq(ary.length, ans), 56);

		}

		test2: {

			String s = "A,B,B,C,C,C";
			int k = 3;

			DatWDup datWDup = new DatWDup();

			datWDup.oriS = s;
			datWDup.k = k;

			datWDup.initAll();

			/////////////////////////////////////////////////////

			long ans = int64ByHxy(k, datWDup.distinctSortedSAryToHxy.length, datWDup.b64W6OfQtyPlus1ToHxy);

			new ThrToPWDup(datWDup).run();

			O.eq(O.eq(datWDup.mapK64V32.i, ans), 19);

		}
	}
}
