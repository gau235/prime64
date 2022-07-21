package lgpl3.other.sample;

import lgpl3.o.O;
import lgpl3.o.time.T64;
import lgpl3.other.jsp.Jsp;

/**
 * 時間範例.<br/>
 * The sample of time.
 *
 * @version 2017/10/14_12:53:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex104_Time10" >Ex104_Time10.java</a>
 *
 */
public class Ex104_Time10 {

	public static void main(String[] sAry) {

		// float milliSecFromT10 = 791.70F * 86.4F * 1000 - (8 * 3600 * 1000);
		float milliSecFromT10 = 377.25F * 86.4F * 1000 - (8 * 3600 * 1000);

		O.l("(long)milliSecFromT10=" + (long) milliSecFromT10);
		O.l("T64.toTimeStr=" + T64.toTimeStr((long) milliSecFromT10, Jsp.MY_TIME_ZONE));

		milliSecFromT10 = 0.79170F * 24F;
		O.l("milliSecFromT10=" + milliSecFromT10);

	}
}
