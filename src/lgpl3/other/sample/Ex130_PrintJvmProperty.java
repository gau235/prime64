package lgpl3.other.sample;

import lgpl3.o.O;

/**
 * 列出 java 系統基本參數.<br/>
 * <br/>
 * To print java system properties.
 *
 * @version 2022/07/09_00:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex130_PrintJvmProperty" >src</a>
 *
 */
public class Ex130_PrintJvmProperty {

	public static void main(String[] sAry) throws Throwable {

		O.l(O.strOfProp(System.getProperties(), O.L));
	}
}