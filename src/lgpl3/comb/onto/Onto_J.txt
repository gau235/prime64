package lgpl3.comb.onto;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.comb.carteProd.thr.ThrCarteProdCAmongBoxWTag;
import lgpl3.comb.filter.Condi;
import lgpl3.comb.stirlingN.S2nk;
import lgpl3.o.B;
import lgpl3.o.ary.Ary32_2D;
import lgpl3.shareWXyz.Hxy;

/**
 * @version 2021/03/25_22:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Onto_J" >Onto_J.java</a>
 *
 * @see Onto_Z
 */
public abstract class Onto_J extends Onto_A {

	// private static final Class<?> THIS = Onto_J.class;

	/**
	 * Onto.
	 *
	 * @see S2nk#carteProd(Condi)
	 */
	public static Ary32_2D onto(Condi condi) {

		long[] aryAftHxy = Hxy.col(condi.n, condi.k, condi.min, condi.max);

		int allBit = ~(-0b1 << condi.n);

		Ary32_2D retArr = new Ary32_2D();

		ThrCarteProdCAmongBoxWTag thr;

		int diff = (condi.min - 1), idx;

		if (diff == 0)

			for (idx = 0; idx != aryAftHxy.length; idx++) {

				thr = new ThrCarteProdCAmongBoxWTag(allBit, B64W6.revAmongVCell(aryAftHxy[idx]), B.I);

				retArr.appendAll(thr.box.arr, 0, thr.box.iLen);

			}

		else
			for (idx = 0; idx != aryAftHxy.length; idx++) {

				thr = new ThrCarteProdCAmongBoxWTag(allBit, B64W6.plusAllWV32NRev(aryAftHxy[idx], diff), B.I);

				retArr.appendAll(thr.box.arr, 0, thr.box.iLen);

			}

		return retArr;

	}
}
