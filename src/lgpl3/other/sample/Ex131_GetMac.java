package lgpl3.other.sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import lgpl3.o.O;

/**
 * 列出系統 Mac.<br/>
 * <br/>
 * To get Mac.
 * 
 * @version 2014/10/25_23:37:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex131_GetMac" >Ex131_GetMac.java</a>
 * 
 */
public class Ex131_GetMac {

	public static void main(String[] sAry) throws Throwable {

		Process process = O.RUN_TIME.exec("getmac");

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

		String line;

		while ((line = bufferedReader.readLine()) != null) {

			O.l(line);

		}

		process.destroy();

	}

}