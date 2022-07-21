package lgpl3.other.sample;

import lgpl3.comb.selfCallva.ForwardSelfCallva;

/**
 * To print.<br/>
 * To print.
 *
 * @version 2022/05/08_15:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex006_PrintByCallSelf" >Ex006_PrintByCallSelf.java</a>
 *
 */
public class Ex006_PrintByCallSelf {

	public static void main(String[] sAry) throws Throwable {

		ForwardSelfCallva.printByCallSelf(3, 2, 10, 1); // from 3 to 10; step 2
	}
}
