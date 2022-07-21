package lgpl3.other.iO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.prime64.Ary32OfCompoBitXy;
import lgpl3.prime64.PrimeAry2D;
import lgpl3.prime64.thr.Marker;

/**
 * @version 2022/04/25_10:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=IOr_W" >IOr_W.java</a>
 *
 * @see IOr
 */
public abstract class IOr_W extends IOr_U {

	private static final Class<?> THIS = IOr_W.class;

	/**
	 * 每 1 列 10 質數, 每 2 個質數用逗點分隔.<br/>
	 * The number of primes per line.
	 */
	public static int numOfPrimeEveryLine = 10;

	/**
	 * 每多少個就 flush.<br/>
	 * The bound to flush.
	 */
	public static final int BOUND32_TO_FLUSH = 500;

	/**
	 * 把質數隊伍存檔到 myPrimeFile.txt.<br/>
	 * 每一列 10 質數, 每 2 個質數用逗點分隔.<br/>
	 * To save the myPrimeFile object to the myPrimeFile.txt.
	 */
	public static void savePrimeToFile(PrimeAry2D sortedPrimeAry2D, Path pathOfFile) {

		try (BufferedWriter bufW = Files.newBufferedWriter(pathOfFile, StandardCharsets.UTF_8, StandardOpenOption.WRITE);) {

			O.l("bef PrimeAry2D len=" + sortedPrimeAry2D.i, THIS);

			long[] artOfP;

			StringBuilder str;

			int countOfPInLine = 0;

			boolean isToGoOut = B.O;

			int iTail;
			int iHead;
			int idx;

			for (iTail = sortedPrimeAry2D.i; !isToGoOut; iTail -= BOUND32_TO_FLUSH) {

				iHead = iTail - BOUND32_TO_FLUSH;
				if (iHead < 0) {

					iHead = 0;
					isToGoOut = B.I;

				}

				if (O.isDev)
					O.l("iTail=" + iTail + " iHead=" + iHead, THIS);

				artOfP = sortedPrimeAry2D.mergeIn1Ary(iHead, iTail); // fuck

				O.l("aft mergeIn1Ary len=" + artOfP.length, THIS);

				str = new StringBuilder(O.defLenForStr);
				for (idx = artOfP.length - 1; idx != -1; idx--) {

					str.append(artOfP[idx]).append(O.C44);

					if (++countOfPInLine == numOfPrimeEveryLine) {

						countOfPInLine = 0;

						str.append(O.C_A_L);

					}
				}

				bufW.append(str).flush();

			}

		} catch (IOException iOEx) {

			iOEx.printStackTrace();
		}
	}

	/**
	 * 把質數隊伍存檔到 myPrimeFile.txt.<br/>
	 * 每一列 10 質數, 每 2 個質數用逗點分隔.<br/>
	 * To save the PrimeAry2D object to the myPrimeFile.txt.
	 */
	public static void savePrimeToFile(Marker marker, long n1, long n2, Path pathOfFile) {

		try (BufferedWriter bufW = Files.newBufferedWriter(pathOfFile, StandardCharsets.UTF_8, StandardOpenOption.WRITE);) {

			if ((n2 > 2L) && (((int) n2) & 0b1) == 0b0)
				n2--; // fuck

			long myN1 = n1;
			if (n1 < 3L)
				myN1 = 3L;

			long myN2 = n2;

			StringBuilder str = new StringBuilder(O.defLenForStr);

			for (int countOfPInLine = 0, countToFlush = 0; myN2 >= myN1; myN2 -= 2) {

				if (marker.b01InAry32OfCompoBit(myN2) == 0b0) {

					str.append(myN2).append(O.C44);

					if (++countOfPInLine == numOfPrimeEveryLine) {

						countOfPInLine = 0;
						str.append(O.C_A_L);

						if (++countToFlush == BOUND32_TO_FLUSH) {

							countToFlush = 0;

							bufW.append(str).flush();

							str = new StringBuilder(O.defLenForStr);

						}
					}
				}
			}

			if (n1 <= 2L && n2 > 1L)
				str.append(2).append(O.C44); // todo: Etchva zoneLittlePrime

			bufW.append(str).flush();

		} catch (IOException iOEx) {

			iOEx.printStackTrace();
		}
	}

	/**
	 * 把質數隊伍存檔到 myPrimeFile.txt.<br/>
	 * 每一列 10 質數, 每 2 個質數用逗點分隔.<br/>
	 * To save the myPrimeFile object to the myPrimeFile.txt.
	 */
	public static void savePrimeToFile(Ary32OfCompoBitXy ary32OfCompoBitXy, Path pathOfFile) {

		try (BufferedWriter bufW = Files.newBufferedWriter(pathOfFile, StandardCharsets.UTF_8, StandardOpenOption.WRITE);) {

			O.l("bef ary32OfCompoBitXy len=" + ary32OfCompoBitXy.i, THIS);

			long[] artOfP;

			StringBuilder str;

			int countOfPInLine = 0;

			int iTail;
			int idx;

			for (iTail = ary32OfCompoBitXy.i - 1; iTail != -1; iTail--) {

				artOfP = ary32OfCompoBitXy.arr[iTail].retrieveP();

				str = new StringBuilder(O.defLenForStr);
				for (idx = artOfP.length - 1; idx != -1; idx--) {

					str.append(artOfP[idx]).append(O.C44);

					if (++countOfPInLine == numOfPrimeEveryLine) {

						countOfPInLine = 0;

						str.append(O.C_A_L);

					}
				}

				bufW.append(str).flush();

			}

		} catch (IOException iOEx) {

			iOEx.printStackTrace();
		}
	}
}