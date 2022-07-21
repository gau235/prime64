package lgpl3.comb.wDup;

import java.io.Serializable;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.comb.filter.CompaByVInKSV32;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.o.keyNV.KSV32;
import lgpl3.o.keyNV.MapK64V32;
import lgpl3.o.keyNV.MapKSV32;

/**
 * The datum for to Hxy.<br/>
 *
 * @version 2020/02/19_20:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=DatWDup_A" >DatWDup_A.java</a>
 *
 * @see DatWDup
 */
public abstract class DatWDup_A implements Serializable { // 同時 for Hxy and C 或是 Hxy and P

	private static final Class<?> THIS = DatWDup_A.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * Default divisor.<br/>
	 * Default divisor.
	 */
	public static final int DEF_DIVISOR_INT32 = 6;

	public String oriS;

	public int k;

	public String[] distinctSortedSAry;

	public String[] distinctSortedSAryToHxy;

	public String[] catagSAry;

	public String[] catagSAryToHxy;

	public long b64As2PowOfQRPlus1;

	public long b64W6OfQtyPlus1ToHxy; // sorted desc

	public String regToIn = O.Z;

	public String regToEx = O.S64;

	public Matcher matcherIn; // Pattern.compile(regToIn).matcher(O.Z).reset(tmpStr);

	public Matcher matcherEx;

	public int total32ToHxy;

	public int total32ToC;

	public int total32ToP;

	public MapK64V32 mapK64V32 = new MapK64V32(); // distinct set

	public StringBuilder retStrToHxy = new StringBuilder(O.defLenForStr);

	public CharSequence prefixForRowNum = new StringBuilder();

	public CharSequence postfixForRowNum = new StringBuilder(O.S9);

	public CharSequence charSeqAsSeparator = new StringBuilder(O.S44);

	public CharSequence prefixForVal = new StringBuilder(O.S61); // charSeqAsDelimiter

	public CharSequence postfixForVal = new StringBuilder();

	public CharSequence lineWr = O.L;

	/**
	 * To gen B64W6 of QRPlus1.<br/>
	 * To gen B64W6 of QRPlus1.
	 */
	public static long genB64As2PowOfQRPlus1(String[] catagSAry) {

		String curHeadS = catagSAry[0];

		long b64As2PowOfQRPlus1 = 0b0L;

		int q = 0;
		int r = 0;

		String tmpS;
		for (int i = 0; i != catagSAry.length;) {

			tmpS = catagSAry[i];

			if (curHeadS.equals(tmpS)) {

				// Q+R=0; bit64 = 1
				b64As2PowOfQRPlus1 |= (0b1L << (q + r));
				// b64As2PowOfQRPlus1 = b64As2PowOfQRPlus1 | B64W6.toB64As2PowByEveryB6CellMinus1(qAgainstDiv32 +
				// rAgainstDiv32);

				// O.l("tmpQRPlus1=" + (qAgainstDiv32 + rAgainstDiv32) + ",b64As2PowOfQRPlus1=" + b64As2PowOfQRPlus1 + O.S64
				// + THIS);

				if ((r++) == DEF_DIVISOR_INT32)
					throw new IndexOutOfBoundsException("tmpS=" + tmpS);

				i++;

			} else {

				curHeadS = tmpS;

				q = q + DEF_DIVISOR_INT32;
				r = 0;

			}

		}

		// O.l("str24=" + O.L + B64W6.str24(b64As2PowOfQRPlus1) + O.S64 + THIS);

		return b64As2PowOfQRPlus1;

	}

	/**
	 * To gen B64W6 of QR.<br/>
	 * To gen B64W6 of QR.
	 */
	public void intiToHxy() {

		MapKSV32 mapKSV32ToHxy = new MapKSV32(catagSAry);
		mapKSV32ToHxy.sort(CompaByVInKSV32.COMPA); // important

		O.l("mapKSV32ToHxy" + O.S64 + THIS + "=");
		O.l(mapKSV32ToHxy.toStr());

		///////////////////////////////////////////////////////////////////////////

		distinctSortedSAryToHxy = new String[mapKSV32ToHxy.i];

		Arr<String> arrOfS = new Arr<String>(String.class);

		KSV32[] aryOfKSV32 = mapKSV32ToHxy.arr;
		KSV32 kSV32;

		for (int i = 0; i != mapKSV32ToHxy.i; i++) {

			kSV32 = aryOfKSV32[i];

			distinctSortedSAryToHxy[i] = kSV32.k;

			// O.l("kSV32=" + kSV32.toStr() + O.S64 + THIS);

			for (int iArrOfS = 0; iArrOfS != kSV32.v; iArrOfS++)
				arrOfS.a(kSV32.k);

			b64W6OfQtyPlus1ToHxy = (b64W6OfQtyPlus1ToHxy << B64W6.$6) | (kSV32.v + 1);

		}

		O.l("distinctSortedSAryToHxy" + O.S64 + THIS + "=");
		O.l(distinctSortedSAryToHxy);

		catagSAryToHxy = arrOfS.trim().arr;

		O.l("catagSAryToHxy" + O.S64 + THIS + "=");
		O.l(catagSAryToHxy);

		O.l("b64W6OfQtyPlus1ToHxy=" + B64W6.str24(b64W6OfQtyPlus1ToHxy) + O.S64 + THIS);

	}

	/**
	 * To gen B64W6 of QR.<br/>
	 * To gen B64W6 of QR.
	 */
	public void initAll() {

		String[] oriSAry = oriS.split(O.S44);

		Arrays.sort(oriSAry); // important

		catagSAry = oriSAry;

		O.l("catagSAry" + O.S64 + THIS + "=");
		O.l(catagSAry);

		///////////////////////////////////////////////////////////////////////////

		distinctSortedSAry = new MapKSV32(oriSAry).allKey();

		O.l("distinctSortedSAry" + O.S64 + THIS + "=");
		O.l(distinctSortedSAry);

		///////////////////////////////////////////////////////////////////////
		b64As2PowOfQRPlus1 = genB64As2PowOfQRPlus1(catagSAry);

		matcherIn = Pattern.compile(this.regToIn).matcher(O.Z);
		matcherEx = Pattern.compile(this.regToEx).matcher(O.Z);

		intiToHxy();

	}

}
