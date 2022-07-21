package lgpl3.other.uI;

import java.awt.Desktop;
import java.io.File;
import java.nio.file.Path;

import lgpl3.o.O;
import lgpl3.o.ary.Seq32;
import lgpl3.other.uI.thr.FanOfEtchva;
import lgpl3.other.uI.thr.FanOfMarker;
import lgpl3.prime64.Miner;
import lgpl3.prime64.thr.Marker;
import lgpl3.prime64.thr.Moon;
import lgpl3.prime64.thr.ThrToMine;

/**
 * My aide.<br/>
 * My aide.
 *
 * @version 2022/05/12_17:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=MySue_A" >MySue_A.java</a>
 *
 * @see MySue_C
 */
public abstract class MySue_A extends Miner {

	/**
	 * 列出系統核心數, 由多到少遞減.<br/>
	 * To int[] of number of processor threads in descending order.
	 */
	public static int[] genMyAry32OfCpuThr() { // 需求至少 2 核心

		int totalPart = 4,

				numOfThr = ((O.$NUM_OF_CPU_THR > O.$MAX_NUM_OF_CPU_THR) ? O.$MAX_NUM_OF_CPU_THR : O.$NUM_OF_CPU_THR),
				// numOfThr=40

				stepAkaGap = (numOfThr / totalPart + 1);

		// xy(numOfThr, stepAkaGap);

		Seq32 retSeq32 = new Seq32();

		for (numOfThr = (numOfThr * 9 / 10); numOfThr > 0; numOfThr -= stepAkaGap)

			retSeq32.a(numOfThr);

		if (retSeq32.tail() != 1)

			retSeq32.a(1);

		return retSeq32.trim().ary32;

	}

	/**
	 * 列出系統核心數, 由多到少遞減.<br/>
	 * To int[] of number of processor threads in descending order.
	 */
	public static final int[] MY_ARY32_OF_CPU_THR = genMyAry32OfCpuThr();

	// private static final Class<?> THIS = MySue_A.class;

	public static int baseKey32 = 0;

	public static final int INCR_OF_KEY = 10;

	public static final int KEY_MP0 = (baseKey32++) * INCR_OF_KEY; // left txtfld
	public static final int KEY_MP1 = KEY_MP0 + 1; // right txtfld
	public static final int KEY_MP3 = KEY_MP0 + 3; // save
	public static final int KEY_MP4 = KEY_MP0 + 4; // esc
	public static final int KEY_MP5 = KEY_MP0 + 5; // the tabbedPane's tab

	public static final int KEY_EP0 = (baseKey32++) * INCR_OF_KEY; // left txtfld
	public static final int KEY_EP1 = KEY_EP0 + 1; // right txtfld
	public static final int KEY_EP3 = KEY_EP0 + 3;
	public static final int KEY_EP4 = KEY_EP0 + 4;
	public static final int KEY_EP5 = KEY_EP0 + 5; // the tabbedPane's tab

	public static final int KEY_DIY0 = (baseKey32++) * INCR_OF_KEY; // left txtfld
	public static final int KEY_DIY1 = KEY_DIY0 + 1; // right txtfld
	public static final int KEY_DIY5 = KEY_DIY0 + 5; // the tabbedPane's tab

	public static final int KEY_CONF0 = (baseKey32++) * INCR_OF_KEY; // left txtfld
	public static final int KEY_CONF5 = KEY_CONF0 + 5; // the tabbedPane's tab

	public static final int KEY_REC0 = (baseKey32++) * INCR_OF_KEY;
	public static final int KEY_REC3 = KEY_REC0 + 3;
	public static final int KEY_REC5 = KEY_REC0 + 5; // the tabbedPane's tab

	public static Moon<ThrToMine> moonMP; // avoid NullPointerException

	public static Marker myMarker;

	public static FanOfMarker fanOfMarker;

	public static FanOfEtchva fanOfEtchva;

	public static Thread myThrToSaveMP = O.THR0;

	public static Thread myThrToSaveEP = O.THR0;

	public static final int MAX_NUM_OF_THR_TO_SHOW_EVERY_PRIME = 9;

	public static final int BOUND32_TO_CLEAR_TXT = 62_000_000; // Ranger.$2POW20_INT32 * 80;

	public static final int BOUND32_TO_CLEAR_REC = 500;

	/**
	 * The count.<br/>
	 * The count.
	 */
	public static int pctWhileRepeatMP; // only 1 round while repeating

	/**
	 * The count.<br/>
	 * The count.
	 */
	public static int pctWhileRepeatEP; // only 1 round while repeating

	public static final String MY_TXT_SAVE = "Save";

	public static final String MY_TXT_ESC = "Esc";

	public static final String MY_TXT_OK_AFT_SAVE = "OK";

	/**
	 * 主檔名.<br/>
	 * The base name of the file.
	 */
	public static final String MY_FILE_BASENAME = "p";

	/**
	 * 副檔名.<br/>
	 * The extension name of the TXT file.
	 */
	public static final String MY_TXT_FILENAME_EXTENSION = "txt";

	/**
	 * 檔名.<br/>
	 * The file name of the TXT file.
	 */
	public static final String MY_FULL_FILE_NAME_TO_REC = "rec.log";

	public static final String S_TMP_DIR = "tmp"; // for MP and EP

	public static Path defPathOfDirToSaveMP; // for MP and EP

	public static File defDirToSaveMP; // for MP and EP

	public static String sDefDirToSaveMP; // for MP and EP

	/**
	 * To get Desktop.<br/>
	 * To get Desktop.
	 */
	public static Desktop getDesktop() {

		try {
			return Desktop.getDesktop();

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		return null;

	}

	/**
	 * The Desktop.<br/>
	 * The Desktop.
	 */
	public static final Desktop MY_DESKTOP = getDesktop();

}
