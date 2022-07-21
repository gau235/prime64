package lgpl3.o;

/**
 * Boole.<br/>
 * Boole.
 *
 * @version 2022/05/16_10:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=B" >src</a>
 *
 */
public abstract class B { // 陰陽 正負

	/**
	 * 0; outside<br/>
	 * 0
	 */
	public static final boolean O = false;

	/**
	 * 1; inside<br/>
	 * 1
	 */
	public static final boolean I = true; // !O

	// [toReplace1//toReplace1]

	/**
	 * To count number of callings.<br/>
	 * To count number of callings.
	 */
	public static long n;

	/**
	 * To count number of callings.<br/>
	 * To count number of callings.
	 */
	public static int n32;

	/**
	 * 產生 ID.<br/>
	 * The create a number as ID.
	 */
	public static int genId32(Class<?> calledByWhichClass) {

		char[] cAry = calledByWhichClass.getCanonicalName().toCharArray();

		int ans = 0, idx = 0, tmp;

		for (; idx != cAry.length;)

			ans += (tmp = cAry[idx]) * tmp * (++idx);

		// ans = 20;

		// [toReplace2//toReplace2]

		return ans;

	}
}