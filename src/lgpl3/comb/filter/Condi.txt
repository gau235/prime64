package lgpl3.comb.filter;

import java.io.Serializable;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * Condition.<br/>
 * Condition.
 *
 * @version 2022/02/21_13:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Condi" >Condi.java</a>
 *
 */
public class Condi implements Serializable {

	private static final Class<?> THIS = Condi.class;

	private static final long serialVersionUID = B.genId32(THIS);

	public int n;

	public int k;

	public int min;

	public int max;

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Ery to StringBuilder.
	 */
	public StringBuilder toStr() {

		return new StringBuilder(O.DEF_CAPACITY32_FOR_STR).append("n,k,min,max=(" + n + "," + k + "," + min + "," + max + ")");
	}

	/**
	 * 檢查是否超出界限.<br/>
	 * To check if it is between.
	 */
	public void checkArg() {

		if (n <= 0 || n > 30 || k <= 0 || min < 0 || max > n || min > max) // n > 30, see toStrToOntoBySAryByB32

			O.x(toStr());

		// if (min == 0 && n < k)
		//
		// O.x(toStr());

	}

	@Override
	public Condi clone() {

		Condi retConi = new Condi();

		retConi.n = n;
		retConi.k = k;
		retConi.min = min;
		retConi.max = max;

		return retConi;

	}
}
