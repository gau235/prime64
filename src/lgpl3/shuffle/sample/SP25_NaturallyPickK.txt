package lgpl3.shuffle.sample;

import java.util.Arrays;
import java.util.TreeSet;

import lgpl3.comb.filter.CompaForAry32;
import lgpl3.o.O;
import lgpl3.shuffle.Shuffler;

/**
 * To shuffle the array.<br/>
 * To shuffle the array.
 *
 * @version 2020/08/24_11:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=SP25_NaturallyPickK" >SP25_NaturallyPickK.java</a>
 *
 */
public class SP25_NaturallyPickK {

	public static void main(String[] sAry) throws Throwable {

		final int nTest = 100;

		int[] ary = { 10, 20, 30, 40, 50 };

		O.l("ary=");
		O.l(ary);

		TreeSet<int[]> myFilter = new TreeSet<int[]>(CompaForAry32.COMPA);

		for (int i = 0; i != nTest; i++) {

			myFilter.add(Shuffler.pickK(ary, ary.length));
		}

		Object[] objAry = myFilter.toArray();
		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);
		for (int i = 0; i != objAry.length; i++) {

			retStr.append(Arrays.toString((int[]) objAry[i])).append(O.C_A_L).append(O.C_A_L);
		}

		O.l(retStr.append("total=" + objAry.length));

	}
}