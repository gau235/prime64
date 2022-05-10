package lgpl3.b64.sample;

import lgpl3.comb.b64W6.B64W6;
import lgpl3.o.O;

/**
 * To generate the string to use.<br/>
 * To generate the string to use.
 *
 * @version 2019/12/22_19:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex94_GenB64StrForProgram" >
 *          Ex94_GenB64StrForProgram.java</a>
 *
 */
public class Ex94_GenB64StrForProgram { // a tool

	public static void main(String[] sAry) {

		StringBuilder str = new StringBuilder();

		int i = 0;
		for (long theY = 0b111111L; i < 10; theY <<= 6, i++) {

			// 0b1111_000000_000000_000000_111111_111111_111111_111111_111111_111111_000000
			str = B64W6.str(~theY);
			O.l("MASK0_" + (i * 6 + 1) + "TO_" + (i * 6 + 6) + "=0b" + str + "L;\n");

		}
	}
}
