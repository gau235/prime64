package lgpl3.other.sample;

import lgpl3.o.O;
import lgpl3.o.str.Strva;

/**
 * 列出 java 系統基本參數.<br/>
 * <br/>
 * To print java system properties.
 * 
 * @version 2014/10/25_23:37:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex130_PrintJvmProperty" >
 *          Ex130_PrintJvmProperty.java</a>
 * 
 */
public class Ex130_PrintJvmProperty {

	public static void main(String[] sAry) throws Throwable {

		O.l(Strva.toStrOfProp(System.getProperties(), O.L));

	}

}