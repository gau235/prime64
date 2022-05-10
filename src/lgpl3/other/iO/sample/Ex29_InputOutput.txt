package lgpl3.other.iO.sample;

import java.nio.file.Paths;

import lgpl3.o.O;
import lgpl3.other.iO.IOr;

/**
 * 輸入與輸出.<br/>
 * To input and to output.
 *
 * @version 2021/02/07_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex29_InputOutput" >Ex29_InputOutput.java</a>
 *
 */
public class Ex29_InputOutput {

	public static void main(String[] sAry) throws Throwable {

		StringBuilder str = IOr.readStrFrom(Paths.get("Z:/go.py"));
		O.l(str);

	}
}
