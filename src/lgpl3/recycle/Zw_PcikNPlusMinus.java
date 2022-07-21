package lgpl3.recycle;

import lgpl3.comb.Pnk;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.O;

/**
 * @version 2022/05/24_10:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Zw_PcikNPlusMinus" >src</a>
 *
 */
public abstract class Zw_PcikNPlusMinus {

	private static final Class<?> THIS = Zw_PcikNPlusMinus.class;

	public static int baseAry32[] = { 8, 5, 9, 1, 22 }, n = baseAry32.length;

	public static int k = 3;

	public static int ans = 13;

	public static void main(String[] sAry) throws Throwable {

		long ary[] = Pnk.colByLoopBreadth(n, k), b64W6;

		for (int idx = 0, v1, v2, v3; idx != ary.length; idx++) {

			b64W6 = ary[idx];

			v1 = baseAry32[(((int) b64W6) & B64W6.MASK32) - 1];

			b64W6 >>>= B64W6.$6;

			v2 = baseAry32[(((int) b64W6) & B64W6.MASK32) - 1];

			b64W6 >>>= B64W6.$6;

			v3 = baseAry32[(((int) b64W6) & B64W6.MASK32) - 1];

			if (v1 + v2 + v3 == ans) // +++ // todo: 可用後置運算

				O.l(v1 + " + " + v2 + " + " + v3 + " = " + ans);

			if (v1 + v2 - v3 == ans) // ++-

				O.l(v1 + " + " + v2 + " - " + v3 + " = " + ans);

			if (v1 - v2 + v3 == ans) // +-+

				O.l(v1 + " - " + v2 + " + " + v3 + " = " + ans);

			if (v1 - v2 - v3 == ans) // +--

				O.l(v1 + " - " + v2 + " - " + v3 + " = " + ans);

		}

		// O.l(Pnk.strByAryOfRevB64W6BySAry(ary, O.S_ARY_A_Z));

	}

	public static void main2(String[] sAry) throws Throwable {

		long ary[] = Pnk.colByLoopBreadth(n, k), b64W6;

		for (int idx = 0, v1, v2; idx != ary.length; idx++) {

			b64W6 = ary[idx];

			v1 = baseAry32[(((int) b64W6) & B64W6.MASK32) - 1];

			b64W6 >>>= B64W6.$6;

			v2 = baseAry32[(((int) b64W6) & B64W6.MASK32) - 1];

			if (v1 + v2 == ans)

				O.l(v1 + " + " + v2 + " = " + ans);

			if (v1 - v2 == ans)

				O.l(v1 + " - " + v2 + " = " + ans);

		}

		// O.l(Pnk.strByAryOfRevB64W6BySAry(ary, O.S_ARY_A_Z));

	}
}
