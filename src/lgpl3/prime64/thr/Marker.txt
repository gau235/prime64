package lgpl3.prime64.thr;

import lgpl3.o.O;
import lgpl3.prime64.Etchva;
import lgpl3.prime64.Miner;

/**
 * To mark primes.<br/>
 * To mark primes.
 *
 * @version 2021/08/23_18:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Marker" >Marker.java</a>
 *
 * @see Miner
 */
public class Marker extends Marker_L {

	private static final Class<?> THIS = Marker.class;

	// 123,456,700 ~ 123,456,766 we have 4 p
	//
	// 347*347==120409
	//
	// 123,456,701 == 347*355783
	//
	@Override
	public void run() {

		final int[] oriAry32OfP = Etchva.oriAry32OfP;

		long divSq; // div * div

		int div32X2, tmp32;

		for (int idx = 1; div32 < sqrt32OfTailNPlus1; div32 = oriAry32OfP[++idx]) {

			// O.lD("div32=" + div32, THIS);

			tmp32 = (div32 & 0b11_1111) >>> 1;

			divSq = (divSq = div32) * divSq; // convert to int64
			// O.lD("divSq=" + divSq, THIS);

			div32X2 = div32 << 1;
			// O.lD("div32X2=" + div32X2, THIS);

			if (divSq < headN) {

				// divSq += (((headN - divSq) / div32X2) + 1) * div32X2;
				divSq += (((headN - divSq) / div32X2)) * div32X2;

				if (divSq < headN) // O.lD("small=" + divSq, THIS);
					divSq += div32X2;

			}

			// if (div32 == 347) O.lD("bef do=" + divSq, THIS);

			if (divSq <= tailN) {

				do {

					// O.lD("do div32=" + div32 + " divSq=" + divSq, THIS);

					// (divSq >>> offsetPlus6) go err
					tmp32 = (((int) divSq) & 0b11_1111) >>> 1; // r=2 or r=3, the pos is 1

					box[((int) (divSq >>> 6)) - offset] |= (0b1 << tmp32);

				} while ((divSq += div32X2) <= tailN);

			} // else O.lD("divSq too big=" + divSq, THIS);

		}
	}

	/**
	 * To construct.<br/>
	 * To construct.
	 */
	public Marker(long n1, long n2, boolean isToRun) {

		if (n2 < 1L || n2 > Etchva.$MAX_TEST_N_OVER_1_ARY32)
			O.x("n2=" + n2);

		StringBuilder str = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		headN = (n1 | 0b1);

		if (((int) n2 & 0b1) == 0)

			tailN = n2 - 1;
		else
			tailN = n2;

		sqrt32OfTailNPlus1 = ((int) StrictMath.sqrt(tailN) + 1);

		offset = (int) (headN >>> 6);

		box = new int[((int) (tailN >>> 6)) - offset + 1]; // 50 to 80 outOfBound

		str.append("headN=" + O.f(headN)).append(O.C_A_L);
		str.append("tailN=" + O.f(tailN)).append(O.C_A_L);
		str.append("sqrt32OfTailNPlus1=" + O.f(sqrt32OfTailNPlus1)).append(O.C_A_L);
		str.append("lenCompoAry32=" + O.f(box.length)).append(O.C_A_L);
		str.append("offset=" + O.f(offset));

		O.l(str, THIS);

		if (isToRun)
			run(); // auto run

	}
}
