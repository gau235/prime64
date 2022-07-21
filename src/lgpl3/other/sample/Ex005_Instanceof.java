package lgpl3.other.sample;

import lgpl3.o.O;

/**
 * To checkArg.<br/>
 * To checkArg.
 *
 * @version 2022/04/30_20:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex005_Instanceof" >src</a>
 *
 */
public class Ex005_Instanceof {

	public static void checkArg(Object[] objAry) {

		O.l("len=" + objAry.length);
	}

	public static void main(String[] sAry) throws Throwable {

		StringBuilder[] aryOfStr = new StringBuilder[2];

		O.l("=====" + (aryOfStr instanceof Object[]));

		checkArg(aryOfStr);

	}
}
