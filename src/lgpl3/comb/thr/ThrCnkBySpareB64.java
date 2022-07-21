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
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=ThrCnkBySpareB64" >src</a>
 *
 * @see ThrPnkBySpareB64
 *
 * @see ThrCnkBySpareB64
 *
 * @see ThrToDCirc
 */
public class ThrCnkBySpareB64 extends ThrWBox<long[]> {

	// private static final Class<?> THIS = ThrCnkBySpareB64.class;

	public final long oriAllBit;

	public final int k;

	public int iLen = 0;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrCnkBySpareB64(long allBit, int k, boolean isToRun) {

		this.oriAllBit = allBit;
		this.k = k;

		box = new long[(int) Cnk.int64(Long.bitCount(allBit), k)];

		if (isToRun)

			run();

	}

	/**
	 * To pick some items with closed mode.
	 *
	 * @see Cnk #colRecur(int, int, int, int, Seq32)
	 */
	public void oldColRecur(long rmdBit, final long prefix, long curBit, int lv) {

		B.n32++;

		if (--lv == 0) { // 終止條件

			do {
				B32va.lv(lv + 1, "done=", (int) (curBit | prefix));

				box[iLen++] = (curBit | prefix);

				if ((rmdBit = ~curBit & rmdBit) == 0b0L)

					return;

				curBit = (-rmdBit & rmdBit);

			} while (B.I);

		}

		do {
			B32va.lv(lv + 1, "rmd=", (int) rmdBit);
			B32va.lv(lv + 1, "add=", (int) curBit);

			oldColRecur((rmdBit = ~curBit & rmdBit), (curBit | prefix), curBit = (-rmdBit & rmdBit), lv);

		} while (Long.bitCount(rmdBit) != lv); // 至少要留 1 bit 給終止條件

	}

	/**
	 * To pick some items with closed mode.<br/>
	 * To pick some items with closed mode.
	 *
	 * @see B32va #next1BitL(int, int)
	 */
	public void colRecur(int rmdK, long my1Bit, long prefix) { // 原創

		// 第 1 次 my1Bit 是 lowest1 所以 (-my1Bit & oriAllBit) 沒抹除 沒遮蔽
		long b64AftCutTail = (-my1Bit & oriAllBit); // 對數字 2 的 n 次方取負號, 恰好是在其左邊位元全都補 1

		// oriAllBit=1110
		// while my1Bit=0100 => -my1Bit=1100

		if (--rmdK == 0) {

			do {
				box[iLen++] = (prefix | my1Bit);

				if ((b64AftCutTail = (~my1Bit & b64AftCutTail)) == 0b0L)

					return;

				my1Bit = (-b64AftCutTail & b64AftCutTail);

			} while (B.I);

		}

		long next1BitL;

		do { // O.l("allBit=" + B32va.toStrByLog2AtB32BySAry((int) allBit, O.S_ARY_A_Z));

			next1BitL = (-(my1Bit << 1) & oriAllBit); // 抹除, B32va.next1BitL()
			next1BitL = (-next1BitL & next1BitL); // B32va.next1BitL();

			colRecur(rmdK, next1BitL, (prefix | my1Bit));

			// O.l("b64AftCutTail=" + B32va.str16((int) b64AftCutTail));
			// O.l("my1Bit=" + B32va.str16((int) my1Bit));
			// O.l("-my1Bit=" + B32va.str16((int) -my1Bit));
			// O.l("~my1Bit=" + B32va.str16((int) ~my1Bit));

			if (Long.bitCount(b64AftCutTail = (~my1Bit & b64AftCutTail)) == rmdK)

				return;

			my1Bit = next1BitL;

		} while (B.I); // bitCount > rmdK => A,B,C,D 取 2 發 A,B,C 開頭即可

	}

	@Override
	public void run() {

		// oldColRecur(oriAllBit, k, 0b0L, (-oriAllBit & oriAllBit));

		colRecur(k, (-oriAllBit & oriAllBit), 0b0L);

	}
}
