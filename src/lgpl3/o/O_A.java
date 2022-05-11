package lgpl3.o;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @version 2022/04/14_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=O_A" >O_A.java</a>
 *
 * @see O_M
 */
public abstract class O_A extends Origin {

	// aaa=-1 shift >>> 31 後 shift 1 不等於 aaa shift 32

	// 有時想 減法原則 想如何退場

	// 數學是離散的 面積 5X5 是方陣 隊伍 而非面積

	// 反向思考 多人開發軟體不可行

	// 科學是一點一點悟出來的

	// 數學 國際共通語言

	// 學數學 翻過門檻 翻過高牆 想前進到 主屋門口
	// 踏著前人走過的血路

	// 倚天盾 (先求自保) 屠龍刀
	// 剛性民族 日本 柔性 中華
	// 科學追求清楚 政治保持模糊

	// 科學發揚理性 延伸理性
	// 幾何學 不是數學 (好東西 給出去 障眼法補救)

	// 數學是離散的 不連續的

	// String.replaceFirst(s1, s2); // when call replaceFirst but java's bug

	// 在Windows中：
	// '\r' 回到行首，而不会换到下一行，如果接着输出的话，本行以前的内容会被逐一覆盖
	//
	// '\n' 换行，换到当前位置的下一行，而不会回到行首；

	// 數學 vs 工程
	// add ext tail
	// subtract dif
	// mul cross product
	// div circle

	// 中華文明有革命
	// 數學很久無革命推翻 (參加社團)
	// 中華革命注入數學

	// =========================
	//
	// 上帝對軟體限制:
	// 數學不可故事接龍 (參加社團)
	// 需要背舊包袱
	//
	// 數學沒辦法廣播討論
	// 看一個外星球文明發展 看他們有辦法討論數學
	// =========================

	/*
	 * 西洋人喜歡 放大多少倍加多少 Y= 4X+3
	 *
	 * 西洋人喜歡 分成多少箱 還剩多少 a = bq + r
	 */

	// 笛卡爾 獨立 jsp
	// Onto OntoWMin0 Onto 笛卡爾 獨立 jsp

	// chinese-utils-1.0 金為部首, 如銅 銀 鉤 釣 轉簡體字太笨了

	// 整個排列組合就是判斷什麼叫'同' 什麼叫'不同'

	// 排列先取再排 (用組合實做)
	// P(5,3) = C(5,3)*3!

	// 組合用有序排列實作 (用排列實做)
	// 從黑箱取 2 物先左手抓第 1 物, 後右手抓第 2 物 (有序)
	// C(5,3) = 5取1 * 4取1 * 3取1 後除以 3!
	// => P(5,1)*P(4,1)*P(3,1) / 3 ! 即一個一個 (連續) 取, 是排列

	// 排列組合, 少用除法
	// 電腦沒有減法, ex: 5 顆球 減法減掉 3 顆球 剩下 2 顆球, 記憶體使用愈用愈多.
	// 搬家不是搬房屋, 而是搬人; 土地面積不會消失 (減法)

	// 5! always eq C(5,2)*2!*C(3,3)*3!
	// C(6,1)*C(5,2)*C(3,3) eq 定值 eq C(6,2)*C(4,3)*C(1,1)

	// 水平整合器 如 Moon

	// swap with XOR
	// n1 = n1 ^ n2;
	// n2 = n1 ^ n2;
	// n1 = n1 ^ n2;

	// rewrite ... 點點點 the three point argument to one argument or with array

	// Jsp_V mapOfParamToEncodedArg(TreeMap<String, String> mapOfParam)
	// change to Jsp_V mapOfParamToEncodedArg(TreeMap<String, CharSeq> mapOfParam)

	// Strva_H StringBuilder str = new StringBuilder(DEF_CAPACITY32_FOR_STR) str.delete(str) do not delete lastIndexOf

	// new File(), mkdirs() convert to nio.Path.get() 但是仍不完美

	// 到底先 syn 還是先 call method?
	//
	// syn{
	//
	// 先 syn 後 call method 後再離開
	// syn 區塊
	//
	// }

	// Circ W Blank for JSP c314.jsp

	// note: Arrays.fill(charAry, '0');
	// for (int i = 0, len = charAry.length; i != len; i++)

	///////////////////////////////////////////////

	// if(obj==null) 比較快
	// 還是
	// if(int32==0) 比較快

	///////////////////////////////////////////////

	/**
	 * The power of.<br/>
	 * The power of.
	 */
	public static long pow(int base, int exp) {

		// if (exp < 0) x("exp=" + exp);

		long ans = 1L;

		while (exp-- != 0)
			ans *= base;

		return ans;

	}

	/**
	 * To throw RuntimeException.<br/>
	 * To throw RuntimeException.
	 */
	public static void x() {

		throw new RuntimeException();
	}

	/**
	 * To throw RuntimeException.<br/>
	 * To throw RuntimeException.
	 */
	public static void x(CharSequence charSeq) {

		throw new RuntimeException((charSeq instanceof String) ? ((String) charSeq) : charSeq.toString());
	}

	/**
	 * Is equal or not?<br/>
	 * Is equal or not?
	 */
	public static long eq(long num, long ans) {

		if (num != ans)

			throw new RuntimeException("num=" + num + " ans=" + ans);

		return num;

	}

	/**
	 * Is greater than or equal to?<br/>
	 * Is greater than or equal to?
	 */
	public static long gte(long num, long bound) {

		if (num < bound)
			throw new RuntimeException("num=" + num + " bound=" + bound);

		return num;

	}

	/**
	 * Is less than or equal to?<br/>
	 * Is less than or equal to?
	 */
	public static long lte(long num, long bound) {

		if (num > bound)
			throw new RuntimeException("num=" + num + " bound=" + bound);

		return num;

	}

	/**
	 * To StringBuilder by Exception.<br/>
	 * To StringBuilder by Exception.
	 */
	public static StringBuilder toStrByThrowable(Throwable throwable, CharSequence lineWr) {

		StringBuilder str = new StringBuilder(DEF_CAPACITY32_FOR_STR);
		str.append(throwable.toString()).append(lineWr);

		StackTraceElement[] allStackTraceElem = throwable.getStackTrace();

		for (int i = 0; i != allStackTraceElem.length; i++)
			str.append(allStackTraceElem[i].toString()).append(lineWr);

		return str;

	}

	/**
	 * 取得現在時間 64 位元毫秒數.<br/>
	 * To return current time in millisecond.
	 */
	public static long t() {

		return System.currentTimeMillis();
	}

	/**
	 * To return the random number from 1 to 100<br/>
	 * To return the random number from 1 to 100
	 */
	public static int intRnd1To100() {

		return (ThreadLocalRandom.current().nextInt(8, 808) >>> 3);
	}

	/**
	 * 把數字轉格式化字串.<br/>
	 * To format and to string.
	 */
	public static String f(long n) {

		return String.format(REGEX_INT, n);
	}

	/**
	 * 把數字轉格式化字串.<br/>
	 * To format and to string.
	 */
	public static String f(int n) {

		return String.format(REGEX_INT, n);
	}

	/**
	 * To return 0 or 1<br/>
	 * To return 0 or 1
	 */
	public static String f(boolean b) {

		return (b ? S49 : S48);
	}
}
