package lgpl3.other.sample;

import lgpl3.o.O;

/**
 * 排列.<br/>
 * Permutation.
 *
 * @version 2021/01/13_19:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex052_EasyP" >Ex052_EasyP.java</a>
 *
 * @see Ex052_EasyP
 *
 * @see Ex054_EasyC
 *
 * @see Ex056_EasyD
 */
public class Ex052_EasyP {

	public static void main(String[] sAry) throws Throwable {

		int n = 3;

		int i1, i2, i3;
		String tmp1 = O.Z;
		String tmp2 = O.Z;
		String tmp3 = O.Z;
		for (i1 = 1; i1 <= n; i1++) {

			tmp1 = Integer.toString(i1);

			for (i2 = 1; i2 <= n; i2++) {

				if (i2 == i1)
					continue;

				tmp2 = tmp1 + i2;

				for (i3 = 1; i3 <= n; i3++) {

					if (i3 == i1 || i3 == i2)
						continue;

					tmp3 = tmp2 + i3;
					O.l(tmp3);

				}
			}
		}
	}
}
