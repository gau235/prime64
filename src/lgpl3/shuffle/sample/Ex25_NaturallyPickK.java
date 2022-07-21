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
 * @version 2022/04/24_11:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex25_NaturallyPickK" >src</a>
 *
 */
public class Ex25_NaturallyPickK {

	public static void main(String[] sAry) throws Throwable {

		int nTest = 200;

		int ary[] = { 10, 20, 30, 40, 50 }, idx;

		O.l("ary=");
		O.l(ary);

		TreeSet<int[]> myFilter = new TreeSet<int[]>(CompaForAry32.COMPA);

		for (; nTest-- != 0;)

			myFilter.add(Shuffler.pickK(ary, ary.length));

		Object[] objAry = myFilter.toArray();
		StringBuilder str = new StringBuilder(O.defLenForStr);

		for (idx = 0; idx != objAry.length; idx++)

			str.append(Arrays.toString((int[]) objAry[idx])).append(O.C_A_L).append(O.C_A_L);

		O.l(str.append("total=" + objAry.length));

	}
}