package lgpl3.comb.wDup.thr;

import java.util.Arrays;

import lgpl3.b64.B64va;
import lgpl3.comb.Cnk;
import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.comb.wDup.DatWDup;
import lgpl3.o.B;
import lgpl3.o.ary.Seq;
import lgpl3.o.keyNV.KAry32V32;
import lgpl3.o.thr.ThrWBox;

/**
 * To pick with duplicated.<br/>
 *
 * @version 2019/08/17_18:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=ThrToCWDup" >ThrToCWDup.java</a>
 *
 * @see ThrToPWDup
 */
public class ThrToCWDup extends ThrWBox<DatWDup> {

	// private static final Class<?> THIS = ThrToCWDup.class;

	protected long allB64As2Pow;

	protected final int k;

	protected int kMinus1MinusBitCountPrefixB64As2Pow;

	protected long tmp64;

	public Seq tmpSeq = new Seq();

	/**
	 * To convert.<br/>
	 * To convert.
	 */
	public static long convertVal32NPlus1InB64As2Pow(long b64As2Pow) {

		long retB64W6 = 0b0L;

		long maskB64 = 0b1L;
		long tmpB64;

		do {

			tmpB64 = b64As2Pow & maskB64;
			maskB64 = maskB64 << 1;
			// O.l("tmp32=" + str16(tmp32) , THIS);

			int val32;

			if (b64As2Pow < maskB64) {// terminate

				if (tmpB64 != 0b0L) {// its necessary

					val32 = B64va.log2(tmpB64) / DatWDup.DEF_DIVISOR_INT32;

					retB64W6 = (retB64W6 << B64W6.$6) | val32 + 1;

				}

				return retB64W6;

			} else {

				if (tmpB64 != 0b0L) {// its necessary

					val32 = B64va.log2(tmpB64) / DatWDup.DEF_DIVISOR_INT32;

					retB64W6 = (retB64W6 << B64W6.$6) | val32 + 1;

				}

			}

		} while (B.I);

	}

	/**
	 * To pick some items with closed mode.<br/>
	 * To pick some items with closed mode.
	 *
	 * @see Cnk #colRecur(int, int, int, int, KAry32V32)
	 */
	public void reGo(long prefixB64As2Pow, long curB64As2Pow) {

		B.n32++;

		kMinus1MinusBitCountPrefixB64As2Pow = k - 1 - B64va.countOf1(prefixB64As2Pow);

		if (kMinus1MinusBitCountPrefixB64As2Pow == 0) {// termination condition

			for (; curB64As2Pow <= allB64As2Pow;) {

				if ((allB64As2Pow & curB64As2Pow) == 0b0L) {// spareB64As2Pow

					curB64As2Pow = curB64As2Pow << 1;

					continue;

				}

				// O.l("up allB64=" + B32va.str16((int) allB64As2Pow) , THIS);
				// O.l("up prefixB64=" + B32va.str16((int) prefixB64As2Pow) , THIS);
				// O.l("up curB64As2Pow=" + B32va.str16((int) curB64As2Pow) , THIS);

				// long tmp64 = prefixB64As2Pow | curB64As2Pow;
				// O.l("add=" + B32va.str16((int) tmp64) , THIS);
				// O.l();

				// curB64As2Pow often bigger than prefixB64As2Pow

				tmp64 = convertVal32NPlus1InB64As2Pow(curB64As2Pow | prefixB64As2Pow);

				curB64As2Pow = curB64As2Pow << 1;

				if (box.ifPassToInEx(tmp64)) {

					// O.l("putNCount=" + B64W6.toStrByValInB6Cell(tmp64) , THIS);

					// box.Map.putNCount(tmp64);
					tmpSeq.a(tmp64);
					// box.retDistinctSetFromMap.easyPutNCount(tmp64);
					box.total32ToC++;

				}

			}

		}

		long maskB64;// for performance
		// long tmpAns;// very important

		// for (; (curB64As2Pow << kMinus1MinusBitCount) <= maxB32As2Pow;) {// k - atK + atBase <= n
		for (; curB64As2Pow <= allB64As2Pow;) {

			if ((allB64As2Pow & curB64As2Pow) == 0b0L) {// spareB64As2Pow

				curB64As2Pow = curB64As2Pow << 1;

				continue;

			}

			maskB64 = (curB64As2Pow << 1) - 1L;// not (curB32As2Pow<<1) ^ 0b1 //by the way so max int32 must be 30 bits

			// O.l("kMinus1MinusBitCountPrefixB64As2Pow=" + kMinus1MinusBitCountPrefixB64As2Pow , THIS);

			//////////////////////////////////////////
			// A=1010
			// B=10 aka 0010
			//
			// mask = (B<<1)-1 = 11
			// maskedA = A & mask = 1010 & 11 = 0010

			// bitCount(A-maskedA) = 1 // aka A ^ maskedA
			// bitCount(A-maskedA) must be gte (k-atK-1)

			if (B64va.countOf1(allB64As2Pow ^ (allB64As2Pow & maskB64)) < kMinus1MinusBitCountPrefixB64As2Pow) {

				break;

			}

			////////////////////////////////////////
			// O.l("allB64=" + B32va.str16((int) allB64As2Pow) , THIS);
			// O.l("prefixB64=" + B32va.str16((int) prefixB64As2Pow) , THIS);
			// O.l("curB64As2Pow=" + B32va.str16((int) curB64As2Pow) , THIS);

			// /O.l("call tmpAns=" + B32va.str16((int) tmpAns) , THIS);
			// O.l("call curB64As2Pow=" + B32va.str16((int) curB64As2Pow) , THIS);
			// O.l();

			tmp64 = curB64As2Pow | prefixB64As2Pow;
			curB64As2Pow = curB64As2Pow << 1;

			if (!box.isToEx(convertVal32NPlus1InB64As2Pow(tmp64))) {

				reGo(tmp64, curB64As2Pow);

			}

		}

	}

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrToCWDup(DatWDup datWDup) {

		box = datWDup;

		this.allB64As2Pow = datWDup.b64As2PowOfQRPlus1;

		this.k = datWDup.k;

	}

	@Override
	public void run() {

		// reGo(0b0L, Long.lowestOneBit(box.b64As2PowOfQRPlus1));// prefixB64As2Pow is 0b0L
		reGo(0b0L, (allB64As2Pow & -allB64As2Pow));// prefixB64As2Pow is 0b0L

		final long[] aryOfB64 = tmpSeq.trim().ary;
		Arrays.sort(aryOfB64);

		for (int i = 0; i != aryOfB64.length; i++) {

			box.mapK64V32.easyPutNCount(aryOfB64[i]);

		}

	}

}
