package lgpl3.other.sample;

import static java.lang.System.out;

import java.util.concurrent.atomic.AtomicInteger;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.o.keyNV.K32V64;

/**
 * To test.<br/>
 * To test.
 *
 * @version 2021/01/12_13:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex010_FacByCount" >Ex010_FacByCount.java</a>
 *
 * @see Ex009_FacByPostDfs
 */
public class Ex010_FacByCount {

	public static void print(Arr<K32V64> allDat) {

		for (int i = 0; i != allDat.i; i++)
			if (allDat.arr[i] != null)
				out.print("dat[" + i + "]=" + allDat.arr[i].toStr() + " ");

	}

	/**
	 * 從 1 全相異數列中取出 k 個數做排列.<br/>
	 * To pick several numbers from a list of distinct numbers then to permutate.
	 */
	public static void count(AtomicInteger lv, Arr<K32V64> allDat) {

		int newN = allDat.tail().k - 1; // n - 1
		int numOfLoop = (int) allDat.tail().v;

		O.l("lv=" + lv.intValue() + " numOfLoop=" + numOfLoop + " nextN=" + newN);

		int count = 0; // newNumOfLoop
		for (; numOfLoop != 0; numOfLoop--) {

			for (int i = 0; i < newN; i++)
				++count;

		}

		O.l("newNumOfLoop=" + count);

		if (lv.getAndAdd(1) < allDat.head().k) // append next one
			allDat.a(new K32V64(newN, count));

		print(allDat);

	}

	public static void main(String[] sAry) throws Throwable {

		final int n = 4;

		Arr<K32V64> allDat = new Arr<K32V64>(K32V64.class);
		allDat.a(new K32V64(n, n));

		AtomicInteger lv = new AtomicInteger(1);

		O.l("init allDat[0]=" + allDat.head().toStr() + O.L);

		do {

			if (lv.intValue() == n)
				return;

			count(lv, allDat);
			O.l();
			O.l();

		} while (B.I);

		// output:
		/*
		 * init allDat[0]=(4^4)
		 *
		 * lv=1 numOfLoop=4 nextN=3 newNumOfLoop=12 dat[0]=(4^4) dat[1]=(3^12)
		 *
		 * lv=2 numOfLoop=12 nextN=2 newNumOfLoop=24 dat[0]=(4^4) dat[1]=(3^12) dat[2]=(2^24)
		 *
		 * lv=3 numOfLoop=24 nextN=1 newNumOfLoop=24 dat[0]=(4^4) dat[1]=(3^12) dat[2]=(2^24) dat[3]=(1^24)
		 */

	}
}
