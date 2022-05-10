package lgpl3.other.sample;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.O;

/**
 * Easy permutation.<br/>
 * Easy permutation.
 *
 * @version 2020/03/09_10:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex053_EasyP" >Ex053_EasyP.java</a>
 *
 * @see Ex053_EasyP
 *
 * @see Ex054_EasyC
 *
 * @see Ex056_EasyD
 */
public class Ex053_EasyP {

	public static void main(String[] sAry) throws Throwable {

		int n = 3;

		int i1, i2, i3;

		long prefix1 = 0b0L;
		long prefix2 = 0b0L;
		long prefix3 = 0b0L;

		for (i1 = 1; i1 <= n; i1++) {

			prefix1 = i1;

			for (i2 = 1; i2 <= n; i2++) {

				if (B64W6.findIdx(prefix1, i2) != Integer.MIN_VALUE)
					continue;

				prefix2 = (prefix1 << B64W6.$6) | i2;

				for (i3 = 1; i3 <= n; i3++) {

					if (B64W6.findIdx(prefix2, i3) != Integer.MIN_VALUE)
						continue;

					prefix3 = (prefix2 << B64W6.$6) | i3;

					O.l(B64W6.strByVCellAftRev(prefix3));

				}
			}
		}
	}
}
