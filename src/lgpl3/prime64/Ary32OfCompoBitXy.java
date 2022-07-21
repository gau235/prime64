package lgpl3.prime64;

import lgpl3.o.B;
import lgpl3.o.ary.Arr;

/**
 * 本類別質數隊伍.<br/>
 * 如果這個不好吃, 可以選擇不要吃.
 *
 * @version 2021/08/23_18:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ary32OfCompoBitXy" >Ary32OfCompoBitXy.java</a>
 *
 * @see Ary32OfCompoBitWr
 */
public class Ary32OfCompoBitXy extends Arr<Ary32OfCompoBitWr> {

	private static final Class<?> THIS = Ary32OfCompoBitXy.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * 建構方法.<br/>
	 * The constructor.
	 */
	public Ary32OfCompoBitXy() {

		super(Ary32OfCompoBitWr.class);

		arr = new Ary32OfCompoBitWr[fixedLen = PrimeAry2D.DEF_LEN];

	}
}
