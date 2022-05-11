package lgpl3.comb.selfCallva;

import lgpl3.o.O;
import lgpl3.prime64.GuessFromGauss;
import lgpl3.prime64.Miner;

/**
 * 本類別前進式自己呼叫自己的人.<br/>
 * To call self forward.
 *
 * @version 2022/04/04_10:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=ForwardSelfCallva_A" >ForwardSelfCallva_A.java</a>
 *
 * @see ForwardSelfCallva
 */
public abstract class ForwardSelfCallva_A extends SelfCallva {

	// private static final Class<?> THIS = ForwardSelfCallva_A.class;

	/**
	 * To print.<br/>
	 * To print.
	 */
	public static void print(int[] ary, int from) {

		if (from == (ary.length - 1)) {

			O.l(ary[from]);

			return;

		}

		O.l(ary[from]);

		print(ary, (from + 1));

	}

	/**
	 * Fibonacci number.<br/>
	 * Fibonacci number.
	 */
	public static int fib(int f1, int f2, int n, int lv) { // the n starts from 3

		if (lv == n)

			return (f1 + f2);

		// 准备 2 个变数, 如同费氏数列 fn, fn_1, fn_2 这样的迭代关系
		return fib(f2, (f1 + f2), n, (lv + 1)); // 重要, 每走一步, 上了一個台階

	}

	/**
	 * 自己呼叫自己法找質數.<br/>
	 * To count prime by to call self.
	 */
	public static int countPrime(long n1, long n2) {

		long myN2 = n1 + GuessFromGauss.range32ToCountPrime(n1);

		if (myN2 >= n2)

			return Miner.countP(n1, n2);

		// return countPrime(n1, myN2) + countPrime(myN2 + 1, n2);
		return Miner.countP(n1, myN2) + countPrime(myN2 + 1, n2);

	}
}
