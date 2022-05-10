package lgpl3.comb.sample;

import lgpl3.comb.Pnk;
import lgpl3.o.O;

/**
 * 排列.<br/>
 * Permutation.
 *
 * @version 2022/03/22_21:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=P04_PWWornSHead" >P04_PWWornSHead.java</a>
 */
public class P04_PWWornSHead {

	// 甲 帶著冠軍獎牌站在 1 號位置
	// 乙 帶著亞軍獎牌站在 2 號位置
	// 丙 帶著季軍獎牌站在 3 號位置

	// 位 1, 位 2, 位 3

	// 甲冠, 乙亞, 丙季
	// 甲冠, 丙季, 乙亞
	// 乙亞, 甲冠, 丙季
	// 乙亞, 丙季, 甲冠
	// 丙季, 甲冠, 乙亞
	// 丙季, 乙亞, 甲冠

	// 甲冠, 乙季, 丙亞
	// 甲冠, 丙亞, 乙季
	// 乙季, 甲冠, 丙亞
	// 乙季, 丙亞, 甲冠
	// 丙亞, 甲冠, 乙季
	// 丙亞, 乙季, 甲冠

	// 甲亞, 乙冠, 丙季
	// 甲亞, 丙季, 乙冠
	// 乙冠, 甲亞, 丙季
	// 乙冠, 丙季, 甲亞
	// 丙季, 甲亞, 乙冠
	// 丙季, 乙冠, 甲亞

	// 甲亞, 乙季, 丙冠
	// 甲亞, 丙冠, 乙季
	// 乙季, 甲亞, 丙冠
	// 乙季, 丙冠, 甲亞
	// 丙冠, 甲亞, 乙季
	// 丙冠, 乙季, 甲亞

	// 甲季, 乙冠, 丙亞
	// 甲季, 丙亞, 乙冠
	// 乙冠, 甲季, 丙亞
	// 乙冠, 丙亞, 甲季
	// 丙亞, 甲季, 乙冠
	// 丙亞, 乙冠, 甲季

	// 甲季, 乙亞, 丙冠
	// 甲季, 丙冠, 乙亞
	// 乙亞, 甲季, 丙冠
	// 乙亞, 丙冠, 甲季
	// 丙冠, 甲季, 乙亞
	// 丙冠, 乙亞, 甲季

	public static final String[] S_ARY_HAED = { "甲", "乙", "丙" };

	public static void main(String[] sAry) throws Throwable { // 3! * 3! or not?

		int n = 3;
		int k = 3;

		long[] aryAsSet = Pnk.colRecur(n, k);

		O.l(Pnk.strWWornHeadByAryOfRevB64W6(aryAsSet, O.S_ARY_A_Z, S_ARY_HAED, O.L));

		O.l("len=" + O.eq(aryAsSet.length, Pnk.int64(n, k)));

	}
}
