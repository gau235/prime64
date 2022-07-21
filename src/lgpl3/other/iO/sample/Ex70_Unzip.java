package lgpl3.other.iO.sample;

import lgpl3.o.O;
import lgpl3.other.iO.IOr;

/**
 * To unzip.<br/>
 * To unzip.
 *
 * @version 2019/04/19_19:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex70_Unzip" >Ex70_Unzip.java</a>
 *
 */
public class Ex70_Unzip {

	public static final String[] S_ARY_FOR_CMD_TO_DEL = new String[] { "cmd.exe", "/C", "RMDIR", "/SW", "/Q", "O:\\test" };

	public static void main(String[] sAry) throws Throwable {

		// Thread t = new ThrToCmd(S_ARY_FOR_CMD_TO_DEL);
		// t.start();
		// t.join();

		String sZipFile = "O:/test.zip";
		String sOutputDir = "O:/test";

		IOr.unzip(sZipFile, sOutputDir);

		O.l("unzip done");

	}
}