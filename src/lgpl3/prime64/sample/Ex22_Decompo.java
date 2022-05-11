package lgpl3.prime64.sample;

import java.util.Arrays;

import lgpl3.o.O;
import lgpl3.prime64.Miner;

/**
 * To decompose a number.<br/>
 * To decompose a number.
 *
 * @version 2022/04/08_11:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex22_Decompo" >Ex22_Decompo.java</a>
 *
 */
public class Ex22_Decompo {

	public static void main(String[] sAry) {

		String s = "29 ;100; 64 ; 1";

		sAry = O.splitNTrimAll(s, ";");

		long n;
		for (int idx = 0; idx != sAry.length; idx++)

			O.l((n = Long.parseLong(sAry[idx])) + "=" + Arrays.toString(Miner.decompo(n)).replaceAll(O.STR_C44C32.toString(), "*"));

	}
}