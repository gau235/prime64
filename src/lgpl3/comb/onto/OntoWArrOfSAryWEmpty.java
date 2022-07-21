package lgpl3.comb.onto;

import java.util.Arrays;

import lgpl3.comb.filter.CompaForSAryWEmpty;
import lgpl3.comb.powerSet.PowerSet;
import lgpl3.o.O;
import lgpl3.o.ary.Arr;

/**
 * 要讓電腦當掉很容易.<br/>
 * Onto for Arr of String[]
 *
 * @version 2022/01/30_18:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=OntoWArrOfSAryWEmpty" >OntoWArrOfSAryWEmpty.java</a>
 *
 * @see PowerSet
 */
public class OntoWArrOfSAryWEmpty {

	/**
	 * OntoWMin0.<br/>
	 * 100 個元素, 2 個 box, 2^100 電腦當掉.
	 */
	public static void colRecur(final String[] base, int curIdx, String[] preSAry, Arr<String[]> retArr) {

		String curS = base[curIdx];
		String[] tmpSAry;

		if (curIdx == base.length - 1) { // curIdx as z-index

			for (int i = 0; i != preSAry.length; i++) {

				(tmpSAry = preSAry.clone())[i] += curS;

				retArr.a(tmpSAry);

			}

			return;

		}

		curIdx++;

		for (int i = 0; i != preSAry.length; i++) {

			(tmpSAry = preSAry.clone())[i] += curS;

			colRecur(base, curIdx, tmpSAry, retArr);

		}
	}

	public static void main(String[] sAry) {

		String[] base = { "A", "B", };
		String[] allBox = { "", "", "" };

		Arr<String[]> retArr = new Arr<String[]>(String[].class);

		colRecur(base, 0, allBox, retArr);

		retArr.sort(CompaForSAryWEmpty.COMPA);
		// retArr.sort(CompaForSAry.COMPA);

		for (int idx = 0; idx != retArr.i; idx++)
			O.l(Arrays.toString(retArr.arr[idx]));

		O.l("len=" + retArr.i);

	}
}