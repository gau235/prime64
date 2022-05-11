package lgpl3.prime64;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Ary2D;
import lgpl3.other.jsp.ThrToSendHttpErr;
import lgpl3.prime64.thr.ThrToAddInPrimeAry2D;

/**
 * 本類別質數隊伍.<br/>
 * 如果這個不好吃, 可以選擇不要吃.
 *
 * @version 2021/08/23_18:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=PrimeAry2D" >PrimeAry2D.java</a>
 *
 * @see ThrToAddInPrimeAry2D
 */
public class PrimeAry2D extends Arr<long[]> {

	private static final Class<?> THIS = PrimeAry2D.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * 內部陣列的初始長度值.<br/>
	 * Initial length of the inside array.
	 */
	public static final int DEF_LEN = 0b1 << 18; // todo: guess def len

	/**
	 * 顯示用 index.<br/>
	 * The index that viewed.
	 */
	public int idxViewed = -1;

	/**
	 * 質數隊伍的建構方法.<br/>
	 * The constructor.
	 */
	public PrimeAry2D() {

		super(long[].class);

		arr = new long[fixedLen = DEF_LEN][];

	}

	/**
	 * To return the tail prime.<br/>
	 * To return the last prime.
	 *
	 * @return 0 if this is empty.
	 */
	public long tailP() {

		if (iLen == 0)

			return 0L; // fuck

		long[] tmpAry = arr[iLen - 1];

		// O.lD("tmpAry.len=" + tmpAry.length, THIS);

		if (tmpAry == null) { // 膨脹中 偷懶不用 syn

			new ThrToSendHttpErr("#tailP", O.SYS_USER_DOT_NAME);

			return 0L; // fuck

		}

		return tmpAry[tmpAry.length - 1];

	}

	/**
	 * 取得本 64 位元整數與 64 位元整數陣列伍內所有數字個數.<br/>
	 * To return the total primes inside.
	 */
	public int totalP() {

		int totalP = 0;

		for (int idx = 0; idx != iLen; idx++) // when this is expanding, it does no harm

			totalP += arr[idx].length;

		return totalP;

	}

	/**
	 * 取得本 64 位元整數與 64 位元整數陣列伍內所有數字個數.<br/>
	 * To return the total number of numbers from from to to (exclusive).
	 */
	public int totalP(int from, int to) { // when this is expanding, it does no harm

		int totalP = 0;

		for (int idx = from; idx < to; idx++)
			totalP += arr[idx].length;

		return totalP;

	}

	/**
	 * 把本 64 位元整數與 64 位元整數陣列伍所有 64 位元整數陣列內的數融合成 1 個陣列.<br/>
	 * To merge all numbers in long[] into one array.<br/>
	 * Note: from &lt;= index &lt; to
	 *
	 * @see #mergeIn1Ary(int, int)
	 *
	 * @see #mergeIn1Ary()
	 *
	 * @see Ary2D#mergeIn1Ary()
	 */
	public long[] mergeIn1Ary(int from, int to) {

		int totalLen = 0;
		int idx = from;

		for (; idx < to; idx++)
			totalLen += arr[idx].length;

		// O.l("totalLen=" + O.f(totalLen), THIS);

		long[] retAry = new long[totalLen];
		long[] tmpAry;

		totalLen = 0;
		idx = from;
		for (; idx < to; idx++, totalLen += tmpAry.length)
			System.arraycopy((tmpAry = arr[idx]), 0, retAry, totalLen, tmpAry.length);

		return retAry;

	}

	/**
	 * 把本 64 位元整數與 64 位元整數陣列伍所有 64 位元整數陣列內的數融合成 1 個陣列.<br/>
	 * To merge all numbers in long[] into one array.<br/>
	 * Note: from &lt;= index &lt; to
	 *
	 * @see #mergeIn1Ary(int, int)
	 *
	 * @see #mergeIn1Ary()
	 *
	 * @see Ary2D#mergeIn1Ary()
	 */
	public long[] mergeIn1Ary() { // same as Ary2D

		return mergeIn1Ary(0, iLen);
	}

	/**
	 * 找出輸入的 PrimeAry2D 物件中含有的全部連續質數伍的最末位置的之後.<br/>
	 * To get the index after tail among the sequential arrays of prime.
	 */
	public static void checkIfAllAryConjoined(PrimeAry2D sortedPrimeAry2D) {

		long[][] tmpPAry2D = sortedPrimeAry2D.arr;
		long[] aryOfP = tmpPAry2D[0];
		long from = aryOfP[aryOfP.length - 1] + 1;

		int idx = 1;

		long to;
		for (int len = sortedPrimeAry2D.iLen; idx != len; idx++) {

			aryOfP = tmpPAry2D[idx];
			to = aryOfP[0] - 1;

			// O.l("oldTailP=" + SByN.f(to), THIS);
			// O.l("aryOfP[0]=" + SByN.f(aryOfP[0]), THIS);

			if ((from > to) || Miner.isAnyPWithin(from, to))
				O.x("from=" + from + " to=" + to);

			from = aryOfP[aryOfP.length - 1] + 1;

		}
	}
}
