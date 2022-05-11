package lgpl3.recycle;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.thr.ThrWBox;
import lgpl3.prime64.thr.Marker;

/**
 * @version 2021/08/14_10:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Markva" >Markva.java</a>
 *
 * @see Marker
 */
public class Markva extends ThrWBox<int[]> {

	private static final Class<?> THIS = Markva.class;

	/**
	 * The tail number.<br/>
	 * The tail number.
	 */
	public long tailN;

	/**
	 * The square root.<br/>
	 * The square root.
	 */
	public int sqrt32OfTailNPlus1;

	/**
	 * The divisor as marker.<br/>
	 * The divisor as marker.
	 */
	public int div32 = 3;

	@Override
	public void run() {

		int tmp32;

		long divPow2;

		int div32Mul2;

		if (div32 < sqrt32OfTailNPlus1) { // 抽出 3 獨立做一輪

			divPow2 = (divPow2 = div32) * divPow2; // convert to int64

			if (((box[div32 >>> 6] >>> divPow2) & 0b1) == 0b0) { // if (get0Or1InB32AryForCompo == 0b0)

				div32Mul2 = div32 << 1;

				do {

					tmp32 = (((int) divPow2) & 0b11_1111) >>> 1; // mod 64 嗎 當 r=2 or r=3, the pos is 1

					box[(int) (divPow2 >>> 6)] |= (0b1 << tmp32);

				} while ((divPow2 += div32Mul2) <= tailN);

			}
		}

		boolean b4 = B.I; // !B.O important

		for (div32 = 5; div32 < sqrt32OfTailNPlus1; div32 += ((b4 = !b4) ? 4 : 2)) {

			// O.lD("div32=" + div32, THIS);

			tmp32 = (div32 & 0b11_1111) >>> 1;

			if (((box[div32 >>> 6] >>> tmp32) & 0b1) == 0b0) { // if (get0Or1InB32AryForCompo == 0b0)

				divPow2 = (divPow2 = div32) * divPow2; // convert to int64

				div32Mul2 = div32 << 1;

				do { // mark1InB32AryForCompo(divisorMulDivisor);

					tmp32 = (((int) divPow2) & 0b11_1111) >>> 1; // r=2 or r=3, the pos is 1

					box[(int) (divPow2 >>> 6)] |= (0b1 << tmp32);

				} while ((divPow2 += div32Mul2) <= tailN);

			} // else O.lD("kick2=" + div32, THIS);

		}
	}

	/**
	 * To construct.<br/>
	 * To construct.
	 */
	public Markva(long tailN, boolean isToRun) {

		StringBuilder str = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		this.tailN = tailN;
		sqrt32OfTailNPlus1 = ((int) StrictMath.sqrt(tailN) + 1);

		box = new int[((int) (tailN >>> 6)) + 1];

		str.append("tailN=" + O.f(tailN)).append(O.C_A_L);
		str.append("sqrt32OfTailNPlus1=" + O.f(sqrt32OfTailNPlus1)).append(O.C_A_L);
		str.append("lenB32Ary=" + O.f(box.length));

		O.l(str, THIS);

		if (isToRun)
			run();

	}
}