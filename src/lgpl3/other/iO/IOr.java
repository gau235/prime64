package lgpl3.other.iO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Iterator;

import lgpl3.o.O;
import lgpl3.o.ary.Aryva;
import lgpl3.prime64.GuessFromGauss;

/**
 * 本類別檔案讀寫人.<br/>
 * To input and to output.
 *
 * @version 2021/09/07_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=IOr" >IOr.java</a>
 *
 */
public abstract class IOr extends IOr_W {

	private static final Class<?> THIS = IOr.class;

	/**
	 * 讀取 myPrimeFile.txt 找最大質數.<br/>
	 * To read the max prime from myPrimeFile.txt
	 */
	public static long readPrimeInFirstLine(File file) throws IOException {

		try (FileInputStream fileIn = new FileInputStream(file);
				InputStreamReader inReader = new InputStreamReader(fileIn, StandardCharsets.UTF_8);
				BufferedReader bufReader = new BufferedReader(inReader);) {

			String s = bufReader.readLine();

			// long int64 = Long.parseLong(s.substring(0, s.indexOf(O.S44)));

			return Long.parseLong(s.substring(0, s.indexOf(O.S44)));

		}
	}

	/**
	 * 讀取 myPrimeFile.txt 並轉成 PrimeAry2D .<br/>
	 * To read myPrimeFile.txt file and to convert to long[].
	 */
	public static long[] readFileNConvertToAryOfP(File file) throws IOException {

		long theMaxPrime = readPrimeInFirstLine(file);

		try (FileInputStream fileIn = new FileInputStream(file);
				InputStreamReader inReader = new InputStreamReader(fileIn, StandardCharsets.UTF_8);
				BufferedReader bufReader = new BufferedReader(inReader);) {

			long[] aryOfP = new long[(GuessFromGauss.guessTotalPNRetInt32(1, theMaxPrime) / 3) << 2]; // fuck

			String tmpS;
			String[] sAry;

			int idx;
			int idx2;
			long int64;

			for (idx = aryOfP.length - 1; (tmpS = bufReader.readLine()) != null;) {

				sAry = tmpS.split(O.S44);

				for (idx2 = 0; idx2 != sAry.length; idx2++) {

					int64 = Long.parseLong(sAry[idx2]);

					if (idx % BOUND32_TO_FLUSH == 0)
						if (O.isDev)
							O.l(O.f(int64), THIS);

					aryOfP[idx--] = int64;

				}
			}

			return Aryva.delHeadAll0(aryOfP);

		}
	}

	/**
	 * To delete.<br/>
	 * To delete.
	 */
	public static void delDirRecur(Path path) throws IOException {

		if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {

			try (DirectoryStream<Path> allEntry = Files.newDirectoryStream(path)) {

				Iterator<Path> iterator = allEntry.iterator();

				while (iterator.hasNext())
					delDirRecur(iterator.next());

			}
		}

		// else
		Files.delete(path);

	}
}