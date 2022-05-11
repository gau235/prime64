package lgpl3.eqDiv;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 64 位元均等分數類別.<br/>
 * 由符號, 分子, 分母 (正數或 0) 構成.<br/>
 * The class for fraction.
 *
 * @version 2020/07/10_10:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Fr64" >Fr64.java</a>
 *
 */
public class Fr64 extends Fr64_D implements Comparable<Fr64> {

	private static final Class<?> THIS = Fr64.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * 1 除以0.<br/>
	 * 0/1.
	 */
	public static final Fr64 $0 = new Fr64(0L, 1L);

	/**
	 * 1 除以 1.<br/>
	 * 1/1.
	 */
	public static final Fr64 $1 = new Fr64(1L, 1L);

	/**
	 * 1 除以 2; 一半.<br/>
	 * 1/2.
	 */
	public static final Fr64 $1_2 = new Fr64(1L, 2L);

	/**
	 * -1 除以 1.<br/>
	 * -1/1.
	 */
	public static final Fr64 $_1 = new Fr64(-1L, 1L);

	/**
	 * The reverse order.<br/>
	 * The reverse order.
	 */
	public static final Comparator<Fr64> REV_COMPA = Collections.reverseOrder();

	/**
	 * 分數類別的建構方法, 新生分數分子是 nu, 分母是 plusDe.<br/>
	 * Constructor; to create a fraction with nu and plusDe.
	 */
	public Fr64(int int32Sign, long plusOr0Nu, long plusDe) {

		super(int32Sign, plusOr0Nu, plusDe);
	}

	/**
	 * 分數類別的建構方法, 新生分數分子是 nu, 分母是 plusDe.<br/>
	 * Constructor; to create a fraction with nu and plusDe.
	 */
	public Fr64(long nu, long plusDe) {

		super((nu > 0L) ? SIGN_PLUS : ((nu < 0L) ? SIGN_MINUS : 0), (nu >= 0L) ? nu : -nu, plusDe);
	}

	/**
	 * 分數類別的建構方法, 新生分數分子是 num, 分母是 1.<br/>
	 * Constructor; to create a fraction with num and 1.
	 */
	public Fr64(long num) {

		super((num > 0L) ? SIGN_PLUS : ((num < 0L) ? SIGN_MINUS : 0), (num >= 0L) ? num : -num, 1L);
	}

	/**
	 * 分數類別的建構方法.<br/>
	 * Constructor.
	 */
	private Fr64(long[] nuDe) {

		this(nuDe[0], nuDe[1]);
	}

	/**
	 * 分數類別的建構方法.<br/>
	 * 若輸入 num 是 new BigDecimal("5.99"), 此分數分子是 599 分母是 100.<br/>
	 * Constructor.
	 */
	public Fr64(BigDecimal num) { // only plus?

		this(toNuDe(num));
	}

	/**
	 * 分數類別的建構方法. 請輸入一含有斜線字串的字串.<br/>
	 * 若輸入 num 是 "3/4", 此分數分子是 3 分母是 4.<br/>
	 * Constructor. Please input a string containing "/".
	 */
	public Fr64(String sNuSlashDe) { // only plus

		this(toNuDe(sNuSlashDe));

		this.sNuSlashDe = sNuSlashDe;

	}

	/**
	 * 比較此分數和 fr64 的大小.<br/>
	 * 此分數大於 fr64 回傳 1, 等於 fr64 回傳 0, 小於 fr64 回傳 -1.<br/>
	 * Compares this to fr64.<br/>
	 * To return 1 if great than; to return 0 if equal to; to return -1 if less than.
	 */
	@Override
	public int compareTo(Fr64 fr64) {

		if (sign == SIGN_PLUS && fr64.sign == SIGN_PLUS)
			return compareInMagnitude(NU, DE, fr64.NU, fr64.DE);

		if (sign == SIGN_PLUS && fr64.sign == SIGN_0)
			return 1;

		if (sign == SIGN_PLUS && fr64.sign == SIGN_MINUS)
			return 1;

		if (sign == SIGN_0 && fr64.sign == SIGN_PLUS)
			return -1;

		if (sign == SIGN_0 && fr64.sign == SIGN_0)
			return 0;

		if (sign == SIGN_0 && fr64.sign == SIGN_MINUS)
			return 1;

		if (sign == SIGN_MINUS && fr64.sign == SIGN_PLUS)
			return -1;

		if (sign == SIGN_MINUS && fr64.sign == SIGN_0)
			return -1;

		// sign == SIGN_MINUS && fr64.sign == SIGN_MINUS
		return -compareInMagnitude(NU, DE, fr64.NU, fr64.DE);

	}

	/**
	 * 分數的加法.<br/>
	 * 回傳一個新分數其值為此分數加 fr64.<br/>
	 * To return a new fraction which is this adds fr64.
	 */
	public Fr64 add(Fr64 fr64) {

		if (sign == SIGN_PLUS && fr64.sign == SIGN_PLUS) {

			long[] ary = addInMagnitude(NU, DE, fr64.NU, fr64.DE);

			return new Fr64(ary[0], ary[1]);

		}

		if (sign == SIGN_PLUS && fr64.sign == SIGN_0)
			return this; // this.clone()

		if (sign == SIGN_PLUS && fr64.sign == SIGN_MINUS) {

			int myCompa = compareInMagnitude(NU, DE, fr64.NU, fr64.DE);

			if (myCompa == 1) { // this is larger

				long[] ary = subInMagnitude(NU, DE, fr64.NU, fr64.DE);

				return new Fr64(ary[0], ary[1]);

			}

			if (myCompa == -1) { // fr64 is larger

				long[] ary = subInMagnitude(fr64.NU, fr64.DE, NU, DE);

				return new Fr64(-ary[0], ary[1]);

			}

			return $0;

		}

		if (sign == SIGN_0) // fr64.sign == SIGN_PLUS || fr64.sign == SIGN_0||fr64.sign == SIGN_MINUS
			return fr64;

		if (sign == SIGN_MINUS && fr64.sign == SIGN_PLUS) {

			int myCompa = compareInMagnitude(NU, DE, fr64.NU, fr64.DE);

			if (myCompa == 1) { // this is larger

				long[] ary = subInMagnitude(NU, DE, fr64.NU, fr64.DE);

				return new Fr64(-ary[0], ary[1]);

			}

			if (myCompa == -1) { // fr64 is larger

				long[] ary = subInMagnitude(fr64.NU, fr64.DE, NU, DE);

				return new Fr64(ary[0], ary[1]);

			}

			return $0;

		}

		if (sign == SIGN_MINUS && fr64.sign == SIGN_0)
			return this; // this.clone()

		// sign == SIGN_MINUS && fr64.sign == SIGN_MINUS
		long[] ary = addInMagnitude(NU, DE, fr64.NU, fr64.DE);

		return new Fr64(-ary[0], ary[1]);

	}

	/**
	 * 分數的減法.<br/>
	 * 回傳一個新分數其值為此分數減掉 fr64.<br/>
	 * To return a new fraction which is this subtracts fr64.
	 */
	public Fr64 sub(Fr64 fr64) {

		return add(new Fr64(-fr64.sign, fr64.NU, fr64.DE));
	}

	/**
	 * 分數的乘法.<br/>
	 * 回傳一個新分數其值為此分數乘以 fr64.<br/>
	 * To return a new fraction which is this multiplies fr64.
	 */
	public Fr64 mul(Fr64 fr64) {

		if (sign == SIGN_0 || fr64.sign == SIGN_0)
			return $0;

		long[] ary = mulInMagnitude(NU, DE, fr64.NU, fr64.DE);

		// O.l("ary=" , THIS);
		// O.l(ary);

		if (sign == SIGN_PLUS && fr64.sign == SIGN_PLUS)
			return new Fr64(SIGN_PLUS, ary[0], ary[1]);

		if (sign == SIGN_MINUS && fr64.sign == SIGN_MINUS)
			return new Fr64(SIGN_PLUS, ary[0], ary[1]);

		return new Fr64(SIGN_MINUS, ary[0], ary[1]);

	}

	/**
	 * 分數的除法.<br/>
	 * 回傳一個新分數其值為此分數除以 f.<br/>
	 * To return a new fraction which is this subtracts f.
	 */
	public Fr64 div(Fr64 fr64) {

		if (fr64.sign == SIGN_0)
			throw new ArithmeticException();

		if (sign == SIGN_0)
			return $0;

		return mul(new Fr64(fr64.sign, fr64.DE, fr64.NU)); // mul(fr64.inv());

	}

	/**
	 * 此分數等於 obj ?<br/>
	 * 若 obj 是 Fr64, 則此分數和 Fr64 比較是否相等.
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return B.O;

		if (obj instanceof Fr64)
			return compareTo((Fr64) obj) == 0;

		return super.equals(obj);

	}

	/**
	 * 回傳一個新分數, 其值為此分數取負性質.<br/>
	 * To return a new Fr64 whose value is -this.<br/>
	 */
	public Fr64 neg() {

		if (sign != SIGN_0)
			return new Fr64(-sign, NU, DE);

		return $0;

	}

	/**
	 * To sum.<br/>
	 * To sum.
	 */
	public static Fr64 sum(Fr64... aryOfFr64) {

		Fr64 ans = $0;
		Fr64 fr64;
		for (int idx = 0; idx != aryOfFr64.length; idx++) {

			if ((fr64 = aryOfFr64[idx]) == null)
				continue;

			ans = ans.add(fr64);

		}

		return ans;

	}

	/**
	 * To sum.<br/>
	 * To sum.
	 */
	public static Fr64 sumViaSAry(String... aryOfStringFr64) {

		Fr64 ans = $0;
		String sFr64;

		for (int idx = 0; idx != aryOfStringFr64.length; idx++) {

			if ((sFr64 = aryOfStringFr64[idx]) == null || O.Z.equals(sFr64 = sFr64.trim()))
				continue;

			ans = ans.add(new Fr64(sFr64));

		}

		return ans;

	}

	/**
	 * 比較一群分數的大小.<br/>
	 * To sort the array of Fr64.
	 */
	public static Fr64[] sortViaSAry(String[] aryOfStringFr64, boolean isAsc) {

		Fr64[] retAryOfFr64 = new Fr64[aryOfStringFr64.length];

		String sFr64;

		for (int idx = 0, iRet = 0; idx != aryOfStringFr64.length; idx++) {

			if ((sFr64 = aryOfStringFr64[idx]) == null || O.Z.equals(sFr64 = sFr64.trim()))
				continue;

			retAryOfFr64[iRet++] = new Fr64(sFr64);

		}

		if (isAsc)

			Arrays.sort(retAryOfFr64 = O.delTailAllNull(retAryOfFr64));
		else
			Arrays.sort(retAryOfFr64 = O.delTailAllNull(retAryOfFr64), REV_COMPA);

		return retAryOfFr64;

	}
}
