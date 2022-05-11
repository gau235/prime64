package lgpl3.comb.thr;

import lgpl3.b32.B32va;
import lgpl3.comb.Cnk;
import lgpl3.o.B;
import lgpl3.o.ary.Seq32;
import lgpl3.o.thr.ThrWBox;

/**
 * 從 1 全相異數列中取出 n 個數.<br/>
 * To pick several numbers from a list of distinct numbers.
 *
 * @version 2022/04/15_21:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=ThrToCBySpareB64As2Pow" >
 *          ThrToCBySpareB64As2Pow.java</a>
 *
 * @see ThrToPByB64As2Pow
 *
 * @see ThrToCBySpareB64As2Pow
 *
 * @see ThrToDCirc
 */
public class ThrToCBySpareB64As2Pow extends ThrWBox<long[]> {

	// private static final Class<?> THIS = ThrToCBySpareB64As2Pow.class;

	public final long oriAllBit;

	public final int k;

	public int iLen = 0;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrToCBySpareB64As2Pow(long allBit, int k, boolean isToRun) {

		this.oriAllBit = allBit;
		this.k = k;

		box = new long[(int) Cnk.int64(Long.bitCount(allBit), k)];

		if (isToRun)

			run();

	}

	/**
	 * To pick some items with closed mode.<br/>
	 * To pick some items with closed mode.
	 *
	 * @see Cnk #colRecur(int, int, int, int, Seq32)
	 */
	public void oldColRecur(long rmdBit, int rmdK, final long prefix, long curBit) {

		if (--rmdK == 0) {

			do {
				box[iLen++] = (curBit | prefix);

				if ((rmdBit &= ~curBit) == 0b0L)

					return;

				curBit = (-rmdBit & rmdBit);

			} while (B.I);

		}

		do
			oldColRecur((rmdBit &= ~curBit), rmdK, (curBit | prefix), curBit = (-rmdBit & rmdBit));

		while (Long.bitCount(rmdBit) != rmdK); // bitCount > rmdK A~D 取2; 發 A,B,C 開頭即可

	}

	/**
	 * To pick some items with closed mode.<br/>
	 * To pick some items with closed mode.
	 *
	 * @see B32va #next1BitL(int, int)
	 */
	public void colRecur(int rmdK, long my1Bit, long prefix) { // 原創

		// 第 1 次 my1Bit 是 lowest1 所以 (-my1Bit & oriAllBit) 沒有 cut 效果
		long b64AftCutTail = (-my1Bit & oriAllBit); // 對數字 2 的 n 次方取負號, 恰好是在其左邊位元全都補 1

		// oriAllBit=1110
		// while my1Bit=0100 => -my1Bit=1100

		if (--rmdK == 0) { // termination condition

			do {
				box[iLen++] = (prefix | my1Bit);

				if ((b64AftCutTail = (~my1Bit & b64AftCutTail)) == 0b0L)

					return;

				my1Bit = (-b64AftCutTail & b64AftCutTail);

			} while (B.I);

		}

		long next1BitL;

		do { // O.l("allBit=" + B32va.toStrByLog2AtB32BySAry((int) allBit, O.S_ARY_A_Z));

			next1BitL = (-(my1Bit << 1) & oriAllBit); // B32va.next1BitL();
			next1BitL = (-next1BitL & next1BitL); // B32va.next1BitL();

			colRecur(rmdK, next1BitL, (prefix | my1Bit));

			// O.l("b64AftCutTail=" + B32va.str16((int) b64AftCutTail));
			// O.l("my1Bit=" + B32va.str16((int) my1Bit));
			// O.l("-my1Bit=" + B32va.str16((int) -my1Bit));
			// O.l("~my1Bit=" + B32va.str16((int) ~my1Bit));

			if (Long.bitCount(b64AftCutTail = (~my1Bit & b64AftCutTail)) == rmdK)

				return;

			my1Bit = next1BitL;

		} while (B.I); // bitCount > rmdK A~D 取2; 發 A,B,C 開頭即可

	}

	@Override
	public void run() {

		// oldColRecur(oriAllBit, k, 0b0L, (-oriAllBit & oriAllBit));

		colRecur(k, (-oriAllBit & oriAllBit), 0b0L);

	}
}
