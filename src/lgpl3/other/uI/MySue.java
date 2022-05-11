package lgpl3.other.uI;

import java.nio.file.Path;

import lgpl3.o.O;
import lgpl3.o.str.SByN;
import lgpl3.o.str.SW;
import lgpl3.o.time.T64;
import lgpl3.other.iO.IOr;
import lgpl3.other.jsp.Jsp;
import lgpl3.other.jsp.ThrToSendHttpErr;
import lgpl3.other.uI.thr.FanOfMarker;

/**
 * My aide.<br/>
 * My aide.
 *
 * @version 2015/07/18_10:27:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=MySue" >MySue.java</a>
 *
 */
public abstract class MySue extends MySue_L {

	// private static final Class<?> THIS = MySue.class;

	/**
	 * 回報 Marker 執行的情況.<br/>
	 * To report the proceeding of Marker.
	 */
	public static void checkErrNSend(FanOfMarker fanOfMarker, final long totalP) {

		if (fanOfMarker.oriN1 <= 2L && fanOfMarker.oriN2 == $MAX_TAIL_N_FOR_GROW_ORI_ARY_OF_P) {

			if (totalP != $MAX_LEN_OF_ORI_ARY_OF_P) {

				SW errS = new SW();
				errS.lineWr = Jsp.L;

				errS.l(T64.timeStr());
				errS.l("n1=" + O.f(fanOfMarker.oriN1));
				errS.l("n2=" + O.f(fanOfMarker.oriN2));
				errS.l("totalP=" + O.f(totalP));
				errS.l("boxLen=" + O.f(fanOfMarker.box.box.length));
				errS.l("timeCost=" + T64.difInF32Sec(fanOfMarker.tStart));

				final long ans2 = fanOfMarker.box.countP(fanOfMarker.oriN1, fanOfMarker.oriN2);
				errS.l("ans2=" + O.f(ans2));

				int int0_1 = fanOfMarker.box.b01InAry32OfCompoBit(1_934_397_729L); // not a prime
				errS.l("int0_1=" + int0_1);

				new ThrToSendHttpErr(errS.str, O.SYS_USER_DOT_NAME);

				//////////////////////////////////////

				Path pathOfFile = MySue.defPathOfDirToSaveMP.resolve(SByN.genPadded0Str("tmp", ".txt", 3).toString());

				try {
					IOr.newDirNFile(pathOfFile);

				} catch (Throwable throwable) {

					throwable.printStackTrace();
				}

				//////////////////////////////////////

				IOr.savePrimeToFile(fanOfMarker.box, fanOfMarker.oriN1, fanOfMarker.oriN2, pathOfFile);

			}
		}
	}
}
