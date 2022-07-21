package lgpl3.comb;

import lgpl3.b32.B32va;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.o.keyNV.K64V32V32;

/**
 * @version 2022/02/13_21:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Pnk_J" >Pnk_J.java</a>
 *
 * @see Pnk_W
 */
public abstract class Pnk_J extends Pnk_H {

	private static final Class<?> THIS = Pnk_J.class;

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * 剪尾巴後再延伸法.
	 */
	public static long[] colByLoopBreadthNDepthFirst(int n, int k) {

		// rule: [1,2,3] => 1,2,31,32=>1,2,31,(321)=>1,2,(312),(321)=>1,23,21,(312),(321)=>...

		final int baseB32 = ~(-0b1 << n);

		int rmdB32 = baseB32, keptB32 = 0b0, lowest1, iStack = 0, iRet = 0;

		final K64V32V32[] stack = new K64V32V32[(n - 1) * k + 1]; // good

		O.l("stackLen=" + stack.length, THIS);

		long[] ret = new long[(int) int64(n, k)];

		if (--k == 0) {

			do
				ret[iRet++] = n;

			while (--n != 0);

			return ret;

		}

		// init
		do
			stack[iStack++] = new K64V32V32(B32va.log2NPlus1(lowest1 = (-rmdB32 & rmdB32)), lowest1, k);

		while ((rmdB32 = (~lowest1 & rmdB32)) != 0b0);
		// init ends

		O.l("k=" + k, THIS);

		O.l("stack=" + O.L + new Arr<K64V32V32>(stack).toStr(), THIS);
		O.l("iStack=" + iStack, THIS);

		K64V32V32 kVV;
		long prefix = 0b0L;

		do {
			kVV = stack[--iStack];

			prefix = kVV.k;
			keptB32 = kVV.v1;
			k = kVV.v2;

			rmdB32 = (~keptB32 & baseB32); // rmdB32 是子彈

			// O.l("keptB32=" + B32va.str16(keptB32) + " rmdB32=" + B32va.str16(rmdB32), THIS);

			prefix <<= B64W6.$6;

			if (--k == 0) // 檢查是否剩下最後一個位元

				do
					ret[iRet++] = (prefix | B32va.log2NPlus1(lowest1 = (-rmdB32 & rmdB32)));

				while ((rmdB32 = (~lowest1 & rmdB32)) != 0b0);

			else
				do
					stack[iStack++] = new K64V32V32(prefix | B32va.log2NPlus1(lowest1 = (-rmdB32 & rmdB32)),

							(keptB32 | lowest1), k);

				while ((rmdB32 = (~lowest1 & rmdB32)) != 0b0);

		} while (iStack != 0);

		return ret;

	}
}
