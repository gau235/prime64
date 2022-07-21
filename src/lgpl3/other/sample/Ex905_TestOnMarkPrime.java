package lgpl3.other.sample;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.prime64.Miner;
import lgpl3.prime64.thr.Marker;
import lgpl3.prime64.thr.PeerByMarker;

/**
 * The test on to mark primes.<br/>
 * The test on to mark primes.
 *
 * @version 2021/08/27_22:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex905_TestOnMarkPrime" >
 *          Ex905_TestOnMarkPrime.java</a>
 *
 */
public abstract class Ex905_TestOnMarkPrime {

	public static void main(String[] sAry) throws Throwable {

		Marker marker = new Marker(1, Miner.$MAX_TAIL_N_FOR_GROW_MY_ARY_OF_P / 1, B.O);
		marker.start();

		new PeerByMarker(marker).run();

		O.eq(marker.countP(1, Miner.$MAX_TAIL_N_FOR_GROW_MY_ARY_OF_P), Miner.$MAX_LEN_OF_MY_ARY_OF_P);

		/////////////////////////////////////////////////////
		// O.lD("test little prime", THIS);

		O.eq(marker.retrieveP(1, 1).length, 0);

		O.eq(marker.retrieveP(1, 2).length, 1);

		O.eq(marker.retrieveP(1, 3).length, 2);

		O.eq(marker.retrieveP(1, 4).length, 2);

		O.eq(marker.retrieveP(2, 2).length, 1);

		O.eq(marker.retrieveP(2, 3).length, 2);

		O.eq(marker.retrieveP(2, 4).length, 2);

		O.eq(marker.retrieveP(3, 3).length, 1);

		O.eq(marker.retrieveP(3, 4).length, 1);

		O.eq(marker.retrieveP(4, 4).length, 0);

		if (marker.retrieveP(10, 20).length != 4) {

			O.l(marker.retrieveP(10, 20));
			O.x();

		}

		/////////////////////////////////////////////////////

		O.eq(marker.countP(1, 1), 0);

		O.eq(marker.countP(1, 2), 1);

		O.eq(marker.countP(1, 3), 2);

		O.eq(marker.countP(1, 4), 2);

		O.eq(marker.countP(2, 2), 1);

		O.eq(marker.countP(2, 3), 2);

		O.eq(marker.countP(2, 4), 2);

		O.eq(marker.countP(3, 3), 1);

		O.eq(marker.countP(3, 4), 1);

		O.eq(marker.countP(4, 4), 0);

		O.eq(marker.countP(10, 20), 4);
		O.eq(marker.countP(100, 300), 37);

	}
}