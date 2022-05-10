package lgpl3.comb.carteProd.thr;

import lgpl3.b32.B32va;
import lgpl3.comb.b64W6.B64W6;
import lgpl3.comb.carteProd.CarteProd;
import lgpl3.comb.carteProd.CarteProdCnk;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Ary32_2D;
import lgpl3.o.ary.Seq32;
import lgpl3.o.str.Strva;
import lgpl3.o.thr.ThrWBox;

/**
 * @version 2022/02/25_15:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=ThrCarteProdCAmongBoxWTag" >
 *          ThrCarteProdCAmongBoxWTag.java</a>
 *
 * @see CarteProdCnk
 */
public class ThrCarteProdCAmongBoxWTag extends ThrWBox<Ary32_2D> {

	private static final Class<?> THIS = ThrCarteProdCAmongBoxWTag.class;

	public int allBit;

	public long allVCell;

	public long tmp;

	public int tmp32;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrCarteProdCAmongBoxWTag(int allBit, long allVCell, boolean isToRun) {

		this.allBit = allBit;
		this.allVCell = allVCell;

		box = new Ary32_2D();

		if (isToRun)

			run();

	}

	/**
	 * To product.<br/>
	 * To product.
	 */
	// todo: OntoWMin0 [0,0,5] [1,1,3] the B64WB6 min is 1
	public void colRecur(long allVCell, int rmdK, int rmd, int buf, Seq32 leftSeq32, int allLeftBit, int lv) {

		int curBit, myBuf, myAllLeftBit;

		if (--rmdK == 0) { // termination condition

			if ((allVCell >>>= B64W6.$6) == 0b0L) {

				do {
					B32va.lv(lv, "buf3", buf);
					B32va.lv(lv, "rmd3", rmd);

					curBit = (-rmd & rmd);

					myBuf = (curBit | buf);

					B32va.lv(lv, "add", myBuf); // 加入 buf

					box.a(leftSeq32.cNA(myBuf).trim().ary32);

					rmd = (~curBit & rmd);

				} while (rmd != 0b0); // 發完

				return; // 記得寫 return

			} else { // reset 換下一個 VCell

				rmdK = ((int) (allVCell)) & B64W6.MASK32;

				do {
					B32va.lv(lv, "buf2", buf);
					B32va.lv(lv, "rmd2", rmd);

					curBit = (-rmd & rmd);

					B32va.lv(lv, "curBit2", curBit);

					myBuf = (curBit | buf);

					B32va.lv(lv, "myBuf2", myBuf);

					rmd = (~curBit & rmd);

					myAllLeftBit = (allLeftBit | myBuf); // 加入 buf

					B32va.lv(lv, "myAllLeft2", myAllLeftBit);

					B32va.lv(lv, "reset", 0);

					colRecur(allVCell, rmdK, (~myAllLeftBit & allBit), 0b0 /* reset */, leftSeq32.cNA(myBuf), myAllLeftBit, lv + 1);

				} while (rmd != 0b0); // 發完

				return; // 記得寫 return

			}
		}

		do {
			B32va.lv(lv, "buf1", buf);
			B32va.lv(lv, "rmd1", rmd);

			curBit = (-rmd & rmd);

			myBuf = (curBit | buf);

			B32va.lv(lv, "myBuf1", myBuf);

			rmd = (~curBit & rmd);

			colRecur(allVCell, rmdK, rmd, myBuf, leftSeq32 /* 先不加入 */, allLeftBit, lv + 1);

		} while (Integer.bitCount(rmd) != rmdK); // bitCount(rmdAllBit) > rmdK A~D 取2; 發 A,B,C 開頭即可

	}

	@Override
	public void run() {

		colRecur(allVCell, ((int) (allVCell & B64W6.MASK32)), allBit, 0b0, new Seq32(), 0b0, 1);
	}

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the array to StringBuilder.
	 */
	public static StringBuilder toStrByAryOfB32As2Pow(int[] aryOfB32As2Pow, String[] sAry) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		for (int idx = 0; idx != aryOfB32As2Pow.length;) {

			retStr.append(B32va.strByLog2InB32BySAry(aryOfB32As2Pow[idx], sAry));

			if (++idx != aryOfB32As2Pow.length)

				retStr.append(CarteProd.charSeqAsSeparator);

		}

		return retStr;

	}

	/**
	 * 把伍轉成字串建立者.<br/>
	 * To convert the Arr to StringBuilder.
	 */
	public static StringBuilder toStrByAry32_2D(Ary32_2D ary32_2D, String[] sAry, CharSequence charSeqAftRowNum32, CharSequence lineWr) {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		for (int idx = 0; idx != ary32_2D.iLen;) {

			retStr.append(idx + 1).append(charSeqAftRowNum32).append(toStrByAryOfB32As2Pow(ary32_2D.arr[idx++], sAry));

			if (idx != ary32_2D.iLen)

				if (idx == Strva.maxRowInHtml)

					return retStr;
				else
					retStr.append(lineWr);

		}

		return retStr;

	}

	/**
	 * main.<br/>
	 * main.
	 *
	 * @see #colRecur(long, int, int, int, Seq32, int, int)
	 */
	public static void main(String[] sAry) throws Throwable {

		int allBit = 0b010_1111_1111;

		// int allBit = 0b0000_0001_1111;

		long allV = B64W6.genB64W6ByAry32(2, 2, 1);

		ThrCarteProdCAmongBoxWTag thr = new ThrCarteProdCAmongBoxWTag(allBit, allV, B.I);

		O.eq(thr.box.iLen, CarteProdCnk.mulAmongBoxWTag(B32va.countOf1(allBit), allV));

		O.l("str=" + O.L + toStrByAry32_2D(thr.box, O.S_ARY_A_Z, O.S9, O.L));

	}
}
