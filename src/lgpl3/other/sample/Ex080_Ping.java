package lgpl3.other.sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

import lgpl3.o.O;
import lgpl3.o.time.T64;
import lgpl3.other.iO.IOr;

/**
 * To ping.<br/>
 * To ping.
 *
 * @version 2018/10/19_18:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex080_Ping" >Ex080_Ping.java</a>
 *
 */
public class Ex080_Ping {

	public static final String[] S_ARY_FOR_CMD_TO_PING = new String[] { "cmd.exe", "/C", "ping", "briian.com" };

	public static final Path PATH_TO_LOG = Paths.get("O:/log.txt");

	public static void main(String[] sAry) throws Throwable {

		int numOfTry = 50_000;
		int duration = 2_600;

		Process cmdProcess;
		for (int i = 0; i != numOfTry; i++) {

			O.l("i=" + i);

			cmdProcess = O.RUN_TIME.exec("ping briian.com");

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cmdProcess.getInputStream()));

			String line;

			while ((line = bufferedReader.readLine()) != null) {

				line = line.trim();
				// O.l(line.length());
				// O.l(line.equals(O.Z));
				// O.l(line.equals(O.S0));

				if (line.equals(O.Z))
					continue;

				if (!line.startsWith("Ping briian.com")) {

					O.l(T64.timeStr() + line + O.L);
					IOr.appendToUtf8File(PATH_TO_LOG, T64.timeStr() + line + O.L);

				} else
					break;

				// O.l(line);

			}

			cmdProcess.destroy();

			Thread.sleep(duration);

		}
	}
}