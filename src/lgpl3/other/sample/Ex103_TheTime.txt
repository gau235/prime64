package lgpl3.other.sample;

import lgpl3.o.O;
import lgpl3.o.time.T64;

/**
 * 時間範例.<br/>
 * The sample of time.
 *
 * @version 2016/07/04_21:17:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex103_TheTime" >Ex103_TheTime.java</a>
 *
 */
public class Ex103_TheTime {

	public static void main(String[] sAry) {

		long from = O.t();
		from = from + T64.$1_DAY_IN_MILLI * 90;
		Object theTime = T64.toTimeStr(from, T64.DEF_TIME_ZONE);

		O.l("theTime=" + theTime);

	}
}
