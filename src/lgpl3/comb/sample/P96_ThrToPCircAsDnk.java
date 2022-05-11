package lgpl3.comb.sample;

import lgpl3.comb.thr.PeerByThrToPCircAsDnk;

/**
 * 環狀排列且全錯排.<br/>
 * Derangement and circular permutation.
 *
 * @version 2020/03/20_18:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=P96_ThrToPCircAsDnk" >P96_ThrToPCircAsDnk.java</a>
 *
 */
public class P96_ThrToPCircAsDnk {

	public static void main(String[] sAry) throws Throwable {

		int n = 10;
		int k = n;
		int numOfThr = 4;

		PeerByThrToPCircAsDnk thr = new PeerByThrToPCircAsDnk();
		thr.n = n;
		thr.k = k;
		thr.numOfThr = numOfThr;

		thr.start();

//		long[] ary = thr.box.trim().ary;
//
//		O.eqX(thr.count32, DCirc.int64(n, k));
//
//		java.util.Arrays.sort(ary);
//
//		StringBuilder str = B64W6.toStrByAryOfB64W6(ary, O.S_ARY_A_Z, O.L);
//		O.l(str);
//
//		MapK64V32 mapK64V32 = new MapK64V32();
//
//		for (int i = 0; i != ary.length; i++) {
//
//			mapK64V32.easyPutNCount(ary[i] >>> B64W6.$6 * (n - 1));
//		}
//
//		for (int i = 0; i != mapK64V32.iLen; i++) {
//
//			K64V32 k64V32 = mapK64V32.arr[i];
//			StringBuilder tmpStr = B64W6.toStrByValMinus1InVCell(k64V32.int64, O.S_ARY_A_Z);
//
//			O.l(tmpStr + "\t diff=" + (k64V32.int32 - PCirc.int64(n - 1)));
//
//		}
//
//		O.l("len=" + SByN.f(thr.box.iLen) + O.S9 + "diff=" + (PCirc.int64(n) - thr.count32));
//		O.l("costT=" + T64.difInF32Sec(t0));

	}

}
