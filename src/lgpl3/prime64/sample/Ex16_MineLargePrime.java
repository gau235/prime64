package lgpl3.prime64.sample;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.time.T64;
import lgpl3.prime64.Miner;
import lgpl3.prime64.thr.Marker;

/**
 * 找較大質數.<br/>
 * To load prime then to mine larger primes.
 *
 * @version 2021/08/27_22:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex16_MineLargePrime" >Ex16_MineLargePrime.java</a>
 *
 */
public abstract class Ex16_MineLargePrime {

	public static void main(String[] sAry) {

		final long downToN = Long.MAX_VALUE - 60;

		long t0;

		if (Miner.maxInOriAryP() < Miner.$MAX_TAIL_N_FOR_GROW_ORI_ARY_OF_P) {

			t0 = O.t();

			Miner.setOriAryOfP(
					new Marker(1, Miner.$MAX_TAIL_N_FOR_GROW_ORI_ARY_OF_P, B.I).retrieveP(1, Miner.$MAX_TAIL_N_FOR_GROW_ORI_ARY_OF_P),
					Ex16_MineLargePrime.class);

			O.l("costT=" + T64.difInF32Sec(t0));

		}

		O.l();

		t0 = O.t();

		O.l(Miner.mineNRetAry(downToN, Long.MAX_VALUE - 1));

		O.l("costT=" + T64.difInF32Sec(t0));

		t0 = O.t();

		O.l(Miner.mineFrom2Pow63DownTo(downToN));

		O.l("costT=" + T64.difInF32Sec(t0), Ex16_MineLargePrime.class);

	}
}
