package lgpl3.other.sample;

import lgpl3.o.O;

/**
 * bit op.<br/>
 * bit op.
 *
 * @version 2020/03/09_10:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex054_EasyC" >Ex054_EasyC.java</a>
 *
 * @see Ex052_EasyP
 *
 * @see Ex054_EasyC
 *
 * @see Ex056_EasyD
 */
public class Ex054_EasyC {

	public static void main(String[] sAry) throws Throwable {

		int n = 4;

		int i1, i2, i3;
		String tmp1 = O.Z;
		String tmp2 = O.Z;
		String tmp3 = O.Z;
		for (i1 = 1; i1 <= n; i1++) {

			tmp1 = Integer.toString(i1);

			for (i2 = i1 + 1; i2 <= n; i2++) {

				tmp2 = tmp1 + i2;

				for (i3 = i2 + 1; i3 <= n; i3++) {

					tmp3 = tmp2 + i3;
					O.l(tmp3);

				}

			}

		}

	}

}
