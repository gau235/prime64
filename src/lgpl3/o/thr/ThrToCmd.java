package lgpl3.o.thr;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import lgpl3.o.O;

/**
 * To command.<br/>
 * To command.
 *
 * @version 2021/09/02_05:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=ThrToCmd" >ThrToCmd.java</a>
 *
 */
public class ThrToCmd extends Thread {

	// private static final Class<?> THIS = ThrToCmd.class;

	/**
	 * The String array for the commands.<br/>
	 * The String array for the commands.
	 */
	public final String[] sAryForCmd;

	/**
	 * To construct.<br/>
	 * To construct.
	 */
	public ThrToCmd(String[] sAryForCmd) {

		this.sAryForCmd = sAryForCmd;
		start(); // auto start

	}

	@Override
	public void run() {

		try {

			Process cmdProcess = new ProcessBuilder(sAryForCmd).start();

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cmdProcess.getInputStream()));

			String line;

			while ((line = bufferedReader.readLine()) != null)
				O.l(line);

			cmdProcess.destroy();

		} catch (Throwable throwable) {

			throwable.printStackTrace();
		}
	}
}
