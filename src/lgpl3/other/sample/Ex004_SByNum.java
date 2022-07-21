package lgpl3.other.sample;

import lgpl3.o.O;
import lgpl3.other.jsp.Jsp;

/**
 * 全形中文空白.<br/>
 * 全形中文空白.
 *
 * @version 2021/06/15_22:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex004_SByNum" >Ex004_SByNum.java</a>
 *
 */
public class Ex004_SByNum {

	public static void main(String[] sAry) throws Throwable {

		String dirtyS = "1, ,,　2，，3,4，　　　4５  　，１０,12　40，7Y 8Z  60 70";

		int[] ary32 = Jsp.genAry32FromDirtyCharSeq(dirtyS);

		O.l("ary32=");
		O.l(ary32);

	}
}
