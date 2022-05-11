package lgpl3.other.sample;

import java.io.File;
import java.util.Arrays;

import lgpl3.o.O;
import lgpl3.o.time.T64;
import lgpl3.other.iO.IOr;
import lgpl3.prime64.Miner;
import lgpl3.prime64.Ranger;

/**
 * To loan then to check primes.<br/>
 * To loan then to check primes.
 *
 * @version 2017/10/14_16:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex990_LoadNCheckPrime" >
 *          Ex990_LoadNCheckPrime.java</a>
 *
 */
public class Ex990_LoadNCheckPrime {

	private static final Class<?> THIS = Ex990_LoadNCheckPrime.class;

	public static void main(String[] sAry) throws Throwable {

		long t0 = O.t();

		File f = new File("C:/Users/gau/Desktop/tmp299.txt");
		long[] tmpAryOfP = IOr.readFileNConvertToAryOfP(f);

		O.l("tmpAryOfP.len=" + O.f(tmpAryOfP.length));
		O.l("t=" + T64.difInF32Sec(t0));

		long n;
		for (int i = tmpAryOfP.length - 1; i != 0; i--) {

			n = tmpAryOfP[i];

			if (n >= 5L) {

				if (i % IOr.BOUND32_TO_FLUSH == 0) {

					O.l("i=" + O.f(i), THIS);
					O.l("n=" + O.f(n), THIS);
					O.l("t=" + T64.difInF32Sec(t0));

				}

				if (n < Ranger.$2POW31_MINUS1) {

					if (!Miner.testPrime32((int) n)) {

						O.l("ppp=" + O.f(n), THIS);
						O.l(O.f(n) + "=" + Arrays.toString(Miner.decompo(n)).replaceAll(", ", "*"), THIS);
						O.l("file=" + f);

					}

				} else if (!Miner.testPrime(n)) {

					O.l("ppp=" + O.f(n), THIS);
					O.l(O.f(n) + "=" + Arrays.toString(Miner.decompo(n)).replaceAll(", ", "*"), THIS);
					O.l("file=" + f);

				}
			}
		}
	}
}