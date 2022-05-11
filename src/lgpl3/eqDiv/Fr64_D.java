package lgpl3.eqDiv;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.prime64.Ranger;

/**
 * @version 2019/05/27_10:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Fr64_D" >Fr64_D.java</a>
 *
 * @see Fr64
 */
public abstract class Fr64_D extends Fr64_A {

	private static final Class<?> THIS = Fr64_D.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * 把小數轉 long[].<br/>
	 * To converse the BigDecimal to long[].
	 */
	public static long[] toNuDe(BigDecimal num) {

		int scale = num.scale();

		if (scale < 0) // todo: bug
			O.x("scale=" + scale);

		if (scale == 0)
			return new long[] { num.toBigInteger().longValue(), 1L };

		return new long[] { num.movePointRight(scale).toBigInteger().longValue(), (long) StrictMath.pow($10_F64, scale) };

	}

	/**
	 * 把字串建立者轉 long[].<br/>
	 * To converse the String to long[].
	 */
	public static long[] toNuDe(int idxOfDecimalPoint, StringBuilder str) {

		int scale = str.length() - idxOfDecimalPoint - 1;

		return new long[] { Long.parseLong(str.deleteCharAt(idxOfDecimalPoint).toString()), (long) StrictMath.pow($10_F64, scale) };

	}

	/**
	 * 把字串轉 long[].<br/>
	 * To converse the String to long[].
	 */
	public static long[] toNuDe(String sNuSlashDe) {

		StringBuilder str = new StringBuilder(sNuSlashDe);

		int idx = str.indexOf(O.S47);
		if (idx > 0)
			return new long[] { Long.parseLong(str.substring(0, idx)), Long.parseLong(str.substring(idx + 1)) };

		else if ((idx = str.indexOf(O.S46)) > 0) // Decimal 小數
			return toNuDe(idx, str);

		else
			return new long[] { Long.parseLong(sNuSlashDe), 1L };

	}

	/**
	 * 將輸入兩數同除以兩數最大公因數.<br/>
	 * Both two long to be divided by their G.C.D.
	 */
	public static long[] reduceByGcd(long plusNum1, long plusNum2) {

		long gcd = gcd(plusNum1, plusNum2);

		return new long[] { plusNum1 / gcd, plusNum2 / gcd };

	}

	/**
	 * 純量比較.<br/>
	 * To compare in magnitude.<br/>
	 * nu1*nu2*de1*de2 must &gt;=0
	 *
	 * @throws IndexOutOfBoundsException
	 */
	public static int compareInMagnitude(long nu1, long de1, long nu2, long de2) {

		long gcdOfDe = gcd(de1, de2);
		long factor1 = de1 / gcdOfDe;
		long factor2 = de2 / gcdOfDe;

		long nu1MulFactor2 = Ranger.calculateNCheckOutOfBound(nu1, factor2, Ranger.TYPE32_MUL);

		long nu2MulFactor1 = Ranger.calculateNCheckOutOfBound(nu2, factor1, Ranger.TYPE32_MUL);

		long newNu = nu1MulFactor2 - nu2MulFactor1;

		if (newNu > 0L)
			return 1;

		if (newNu < 0L)
			return -1;

		return 0;

	}

	/**
	 * 純量加法.<br/>
	 * To add in magnitude.
	 *
	 * @throws IndexOutOfBoundsException
	 */
	public static long[] addInMagnitude(long nu1, long de1, long nu2, long de2) {

		long gcdOfDe = gcd(de1, de2);
		long factor1 = de1 / gcdOfDe;
		long factor2 = de2 / gcdOfDe;

		long nu1MulFactor2 = Ranger.calculateNCheckOutOfBound(nu1, factor2, Ranger.TYPE32_MUL);

		long nu2MulFactor1 = Ranger.calculateNCheckOutOfBound(nu2, factor1, Ranger.TYPE32_MUL);

		long newNu = Ranger.calculateNCheckOutOfBound(nu1MulFactor2, nu2MulFactor1, Ranger.TYPE32_ADD);

		long factor1MulFactor2 = Ranger.calculateNCheckOutOfBound(factor1, factor2, Ranger.TYPE32_MUL);

		long newDe = Ranger.calculateNCheckOutOfBound(factor1MulFactor2, gcdOfDe, Ranger.TYPE32_MUL);

		return reduceByGcd(newNu, newDe);

	}

	/**
	 * 純量減法.<br/>
	 * To subtract in magnitude.
	 *
	 * @throws IndexOutOfBoundsException
	 */
	public static long[] subInMagnitude(long nu1, long de1, long nu2, long de2) { // nu1/de1 is more than nu2/de2

		long gcdOfDe = gcd(de1, de2);
		long factor1 = de1 / gcdOfDe;
		long factor2 = de2 / gcdOfDe;

		long factor1MulFactor2 = Ranger.calculateNCheckOutOfBound(factor1, factor2, Ranger.TYPE32_MUL);

		long newDe = Ranger.calculateNCheckOutOfBound(factor1MulFactor2, gcdOfDe, Ranger.TYPE32_MUL);

		long nu1MulFactor2 = Ranger.calculateNCheckOutOfBound(nu1, factor2, Ranger.TYPE32_MUL);

		long nu2MulFactor1 = Ranger.calculateNCheckOutOfBound(nu2, factor1, Ranger.TYPE32_MUL);

		long newNu = nu1MulFactor2 - nu2MulFactor1;

		// if (newNu < 0) {
		//
		// if (newNu == Long.MIN_VALUE) {
		//
		// throw new ArithmeticException("-(2^63) out of bound");
		//
		// }
		//
		// long[] ary32 = reduceByGcd(-newNu, newDe);
		//
		// ary32[0] = -ary32[0];
		//
		// return ary32;
		//
		// }
		//
		// if (newNu == 0) {
		//
		// return new long[] { 0, 1 };
		// }

		return reduceByGcd(newNu, newDe);

	}

	/**
	 * 純量乘法.<br/>
	 * To multiply in magnitude.
	 *
	 * @throws IndexOutOfBoundsException
	 */
	public static long[] mulInMagnitude(long nu1, long de1, long nu2, long de2) { // all are plus

		long nu1MulNu2 = Ranger.calculateNCheckOutOfBound(nu1, nu2, Ranger.TYPE32_MUL);
		long de1MulDe2 = Ranger.calculateNCheckOutOfBound(de1, de2, Ranger.TYPE32_MUL);

		return reduceByGcd(nu1MulNu2, de1MulDe2);

	}

	/**
	 * 用符號和 64位元整數純量新生成分數, 分子是正數或 0, 分母是正數.<br/>
	 * To construct a new Fr64 with the sign and magnitude(plusOr0Nu and plusDe).
	 */
	public Fr64_D(int int32Sign, long plusOr0Nu, long plusDe) {

		super(int32Sign, plusOr0Nu, plusDe);
	}

	/**
	 * 回傳 64 位元整數, 其值為此分數分子除以分母的結果.<br/>
	 * To return a long whose value equals the sign*NU divided by the DE.
	 */
	public long toInt64() {

		if (sign == SIGN_0)
			return 0L;

		if (sign == SIGN_PLUS)
			return NU / DE;

		return -NU / DE;

	}

	/**
	 * 回傳分子除以分母的 64 位元浮點數.<br/>
	 * To return value of the sign*NU divided by the DE in double.<br/>
	 */
	public float toF32() {

		if (sign == SIGN_0)
			return 0F;

		if (sign == SIGN_PLUS)
			return ((float) NU) / DE;

		return ((float) -NU) / DE;

	}

	/**
	 * 回傳一個新分數其值為此分數的倒數.<br/>
	 * To return a new Fr64 which is sign*DE/NU.<br/>
	 */
	public Fr64 inv() {

		return new Fr64(sign, DE, NU);
	}

	/**
	 * 回傳此分數分子除以分母的正餘數 .<br/>
	 * To return the plus remainder of dividing NU by DE.
	 */
	public long rem() {

		return NU % DE;
	}

	/**
	 * 此分數是整數嗎 ?<br/>
	 * Is this F64 an integer?
	 */
	public boolean isInt() {

		return DE == 1L;
	}

	/**
	 * 回傳分子除以分母的 BigDecimal.<br/>
	 * To return value of the NU divided by the DE in BigDecimal.
	 */
	public BigDecimal bigDecimal(int scale) {

		if (sign == SIGN_0)
			return BigDecimal.ZERO;

		if (sign == SIGN_PLUS)
			return new BigDecimal(NU).divide(new BigDecimal(DE), scale, RoundingMode.HALF_UP);

		return new BigDecimal(-NU).divide(new BigDecimal(DE), scale, RoundingMode.HALF_UP);

	}

	/**
	 * 回傳一個字串建立者 : 分子 / 分母.<br/>
	 * To return a StringBuilder: NU/DE.
	 */
	public StringBuilder toStr() {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		if (sign == SIGN_MINUS)
			retStr.append(O.C45);

		return retStr.append(NU).append(O.C47).append(DE);

	}

	/**
	 * 回傳一個字串建立者 : 分子 / 分母.<br/>
	 * To return a StringBuilder: NU/DE.
	 */
	public StringBuilder toSimpleStr() {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		if (DE == 1L)
			return retStr.append(sign * NU);

		else
			return retStr.append(sign * NU).append(O.C47).append(DE);

	}

	/**
	 * 回傳一個字串 : 分子 / 分母.<br/>
	 * To return a string: NU/DE.
	 */
	@Override
	public String toString() {

		StringBuilder retStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		if (sign == SIGN_MINUS)
			retStr.append(O.C45);

		return retStr.append(NU).append(O.C47).append(DE).toString();

	}
}
