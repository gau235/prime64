package lgpl3.comb.powerSet.thr;

import lgpl3.comb.CatalanNum;
import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.thr.ThrWBox;

/**
 * To gen subset.<br/>
 * To gen subset.
 *
 * @version 2022/04/20_21:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=ThrGenSubset" >ThrGenSubset.java</a>
 *
 */
public class ThrGenSubset extends ThrWBox<long[]> {

	private static final Class<?> THIS = ThrGenSubset.class;

	public final int nOfElem;

	public static final int $YES = CatalanNum.ID_AS_WIN;

	public static final int $NO = CatalanNum.ID_AS_LOSE;

	public int iLen;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrGenSubset(int nOfElem, boolean isToRun) {

		this.nOfElem = nOfElem;

		box = new long[0b1 << nOfElem];

		if (isToRun)

			run();

	}

	/**
	 * To gen subset.<br/>
	 * To pick it or not.
	 */
	public void pickIt(long prefix, int countOfYes, int countOfNo) {

		if (countOfYes + countOfNo == nOfElem) {

			box[iLen++] = prefix;

			return;

		}

		// pick it or not

		pickIt(((prefix << B64W6.$6) | $YES), (countOfYes + 1), countOfNo);
		notPickIt(((prefix << B64W6.$6) | $NO), countOfYes, (countOfNo + 1));

	}

	/**
	 * To gen subset.<br/>
	 * To pick it or not.
	 */
	public void notPickIt(long prefix, int countOfYes, int countOfNo) {

		if (countOfYes + countOfNo == nOfElem) {

			box[iLen++] = prefix;

			return;

		}

		// pick it or not

		pickIt(((prefix << B64W6.$6) | $YES), (countOfYes + 1), countOfNo);
		notPickIt(((prefix << B64W6.$6) | $NO), countOfYes, (countOfNo + 1));

	}

	@Override
	public void run() {

		pickIt($YES, 1, 0);
		notPickIt($NO, 0, 1);

	}

	/**
	 * To string by B64W6.<br/>
	 * To string by B64W6.
	 */
	public StringBuilder toStr() {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		long myB64;
		for (int iBig = 0, iLocal; iBig != iLen;) {

			myB64 = box[iBig]; // O.l("myB64=" + B64W6.str24(myB64), THIS);

			iLocal = 0;
			do {
				if (((int) (myB64 & B64W6.MASK32)) == $YES) // 原創

					retStr.append(O.S_ARY_A_Z[iLocal]); // sss += O.S_ARY_A_Z[iLocal];

				if ((myB64 >>>= B64W6.$6) == 0b0L)

					break;

				iLocal++;

			} while (B.I);

			if (++iBig != iLen)

				retStr.append(O.C_A_L);

			// O.l("sss=" + sss, THIS);

		}

		return retStr;

	}
}
