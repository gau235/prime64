package lgpl3.comb.thr;

import java.util.Arrays;

import lgpl3.comb.CatalanNum;
import lgpl3.comb.Cnk;
import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Aryva;
import lgpl3.o.thr.ThrWBox;

/**
 * To win or to lose.<br/>
 * 1 麻雀在 2 平行電線跳動.
 *
 * @version 2022/04/11_17:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=ThrWinToChamp" >ThrWinToChamp.java</a>
 *
 */
public class ThrWinToChamp extends ThrWBox<long[]> { // 遮蔽 最後一場 可破解

	// private static final Class<?> THIS = ThrWinToChamp.class;

	public final int nWinToChamp;

	public static final int ID_AS_WIN = CatalanNum.ID_AS_WIN;

	public static final int ID_AS_LOSE = CatalanNum.ID_AS_LOSE;

	public int iLen = 0;

	/**
	 * 公式 C(7,3)*2, 7 戰 4 勝 統一最多可以輸 0, 1, 2, 3 場, 同理兄弟也是.<br/>
	 * 輸 0 場: 勝勝勝_勝 C(3,0)<br/>
	 * 輸 1 場: 勝敗勝勝_勝 C(4,1)<br/>
	 * 輸 2 場: 勝敗敗勝勝_勝 C(5,2)<br/>
	 * 輸 3 場: 勝敗敗敗勝勝_勝 C(6,3)
	 */
	// 公式 5 戰 3 勝 = C(5,2)*2
	public static long total(int nWinToChamp) {

		long totalGamePlayedBefFirstTeamToChamp = Cnk.int64(((--nWinToChamp << 1) + 1), nWinToChamp);

		return (totalGamePlayedBefFirstTeamToChamp << 1);

	}

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrWinToChamp(int nWinToChamp, boolean isToRun) {

		this.nWinToChamp = nWinToChamp;

		box = new long[(int) total(nWinToChamp)];

		if (isToRun)

			run();

	}

	/**
	 * 公式 C(7,3)*2, 7 戰 4 勝 統一最多可以輸 0, 1, 2, 3 場, 同理兄弟也是.<br/>
	 * 輸 0 場: 勝勝勝_勝 C(3,0)<br/>
	 * 輸 1 場: 勝敗勝勝_勝 C(4,1)<br/>
	 * 輸 2 場: 勝敗敗勝勝_勝 C(5,2)<br/>
	 * 輸 3 場: 勝敗敗敗勝勝_勝 C(6,3)
	 */
	public void canWinHoweverCanLoseToo(long prefix, int countWin, int countLose) {

		if (countWin == nWinToChamp || countLose == nWinToChamp) {

			box[iLen++] = prefix;

			return;

		}

		canWinHoweverCanLoseToo(((prefix << B64W6.$6) | ID_AS_WIN), (countWin + 1), countLose); // win
		canWinHoweverCanLoseToo(((prefix << B64W6.$6) | ID_AS_LOSE), countWin, (countLose + 1)); // lose

	}

	@Override
	public void run() {

		canWinHoweverCanLoseToo(ID_AS_WIN, 1, 0); // win
		canWinHoweverCanLoseToo(ID_AS_LOSE, 0, 1); // lose

	}

	public static void main(String[] sAry) throws Throwable {

		final String[] allNameOfTeam = { "統", "兄" };

		int nWinToChamp = 3;

		///////////////////////////////////////////////////

		ThrWinToChamp thr = new ThrWinToChamp(nWinToChamp, B.I);

		long[] aryAsSet = Aryva.checkDup(thr.box);

		Arrays.sort(aryAsSet);

		for (int idx = 0, size = aryAsSet.length; idx != size; idx++)

			O.l(B64W6.strByVCellMinus1AftRevBySAry(aryAsSet[idx], allNameOfTeam));

		O.l("total=" + O.eq(thr.iLen, aryAsSet.length));

	}
}
