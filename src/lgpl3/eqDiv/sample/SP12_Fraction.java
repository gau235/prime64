package lgpl3.eqDiv.sample;

import java.util.Arrays;

import lgpl3.eqDiv.Fr64;
import lgpl3.o.O;

/**
 * 分數比大小.<br/>
 * To sort the array of Fr64.
 * 
 * @version 2019/05/27_10:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=SP12_Fraction" >SP12_Fraction.java</a>
 * 
 */
public class SP12_Fraction {

	public static void main(String[] sAry) throws Throwable {

		Fr64 f1 = new Fr64("0.8");
		Fr64 f2 = new Fr64("5/7");
		Fr64 f3 = new Fr64("1.3");

		Fr64[] aryOfFr64 = { f1, f2, f3 };

		Arrays.sort(aryOfFr64);

		for (int i = 0; i != aryOfFr64.length; i++) {

			O.l(aryOfFr64[i].sNuSlashDe);

		}

	}

}
