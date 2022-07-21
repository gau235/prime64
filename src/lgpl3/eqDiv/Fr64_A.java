package lgpl3.eqDiv;

import java.io.Serializable;

import lgpl3.o.B;

/**
 * 本類別 64 位元分數.<br/>
 * The 64 bit fraction.
 *
 * @version 2019/07/20_12:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Fr64_A" >Fr64_A.java</a>
 *
 * @see Fr64_D
 */
public abstract class Fr64_A implements Serializable {

	private static final Class<?> THIS = Fr64_A.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * 正號, 代碼為 1.<br/>
	 * The plus sign.
	 */
	public static final int SIGN_PLUS = 1;

	/**
	 * 負號, 代碼為 -1.<br/>
	 * The minus sign.
	 */
	public static final int SIGN_MINUS = -1;

	/**
	 * 0, 代碼為 0.<br/>
	 * The sign of 0.
	 */
	public static final int SIGN_0 = 0;

	/**
	 * 10<br/>
	 * 10
	 */
	public static final double $10_F64 = 10D;

	/**
	 * 此分數的分子; 正數或 0.<br/>
	 * Numerator; positive or 0.
	 */
	public final long NU; // positive or 0

	/**
	 * 此分數的分母; 正數.<br/>
	 * Denominator; positive.
	 */
	public final long DE; // positive

	/**
	 * 此分數的符號, 決定正負或 0.<br/>
	 * Sign.
	 */
	public final int sign;

	/**
	 * Temp String like 1/5 or 1.5<br/>
	 * Temp String like 1/5 or 1.5
	 */
	public String sNuSlashDe;

	/**
	 * 找最大公因數 G.C.D.<br/>
	 * To return the G.C.D.
	 */
	public static long gcd(long n1, long n2) {

		// if (n1 < 1L || n2 < 1L) x();

		for (long r; (r = n1 % n2) != 0L; n1 = n2, n2 = r) // 准备 2 个变数, 如同费氏数列 fn, fn_1, fn_2 这样的迭代关系
			;

		return n2; // l("n2=" + n2 + S32 + THIS);

	}

	/**
	 * 用符號和 64位元整數純量新生成分數, 分子是正數或 0, 分母是正數.<br/>
	 * To construct a new Fr64 with the sign and magnitude(plusOr0Nu and plusDe).
	 */
	public Fr64_A(int int32Sign, long plusOr0Nu, long plusDe) {

		if (plusOr0Nu < 0 || plusDe <= 0)
			throw new ArithmeticException("plusOr0Nu=" + plusOr0Nu + ", plusDe=" + plusDe);

		if (int32Sign == SIGN_0) {

			NU = 0L;
			DE = 1L;

		} else { // sign == SIGN_PLUS or SIGN_MINUS

			if (plusOr0Nu == 0L)
				throw new ArithmeticException();

			long gcd = gcd(plusOr0Nu, plusDe);

			NU = plusOr0Nu / gcd;
			DE = plusDe / gcd;

		}

		sign = int32Sign;

	}
}
