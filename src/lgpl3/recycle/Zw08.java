package lgpl3.recycle;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import lgpl3.b32.B32va;
import lgpl3.comb.filter.CompaForAryOfPrime;
import lgpl3.o.O;
import lgpl3.prime64.PrimeAry2D;

/**
 * @version 2020/02/08_11:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Zw08" >src</a>
 *
 * @see Zw18
 */
public abstract class Zw08 {

	static long[] ary1 = { 10, 20, 30 };
	static long[] ary2 = { 80, 90 };
	static long[] ary3 = { 40, 50, 60 };

	public static void main(String[] sAry) throws Throwable {

		char[] ccc = { '哈', '一', '口' };

		O.l(ccc);

		// int aaa = Integer.MIN_VALUE;
		int aaa = -0b000001000000;
		aaa = (0b1 << 48);

		O.l("bef=" + B32va.str(aaa));

		aaa = aaa >>> 31;
		// aaa = aaa >>> 1;

		O.l("aft=" + B32va.str(aaa));
		O.l("v=" + aaa);

		O.l("-1=" + B32va.str(-1 >> 51));

	}

	public static void main4(String[] sAry) throws Throwable {

		float f = -50f;
		int bits = Float.floatToIntBits(f);
		// Extract each bit from 'bits' and compare it by '0'
		for (int i = 31; i >= 0; --i) {
			// int mask = 1 << i;
			// int oneBit = bits & mask;
			// oneBit == 0 or 1?
			System.out.print((bits & (1 << i)) == 0 ? "0" : "1");

		}

	}

	public static void main05(String[] sAry) throws Throwable { // for o.jsp

		BufferedReader bufR = Files.newBufferedReader(Paths.get("C:\\Users\\gau\\Desktop/a.txt"), StandardCharsets.UTF_8);

		int count = 1;
		for (String s; (s = bufR.readLine()) != null;) {

			O.l("<%@ page import=\"" + s + ".*\"%>");

			if (count++ == 5) {

				O.l();

				count = 0;

			}
		}
	}

	public static void main553(String[] sAry) throws Throwable {

		O.l("str16=" + B32va.str16(0b0111_1111_1111_1111));
		O.l("str16=" + B32va.str16(0b1100_0000_0000_0000));

		O.l("str16=" + B32va.str16(0b1111_1111_1111_1111));

		O.l("str16=" + B32va.str16(0b1111_1111_1111_1111_1111_1111_1111_1111));

	}

	public static void main5(String[] sAry) throws Throwable {

		O.l("str=" + B32va.str(0b1111_1111_1111_1111_1111_1111_1111_1111));
		O.l("str=" + B32va.str(0b1000_0000_0000_0000_0000_0000_0000_0000));

		O.l("str16=" + B32va.str16(0b0111_1111_1111_1111));
		O.l("str16=" + B32va.str16(0b1000_0000_0000_0000));
		O.l("str16=" + B32va.str16(0b1111_1111_1111_1111));

		O.l("str16=" + B32va.str16(0b1111_1111_1111_1111_1111_1111_1111_1111));

		O.l("0x55555555=0b" + B32va.str16(0x55555555));
		O.l("0x33333333=0b" + B32va.str16(0x33333333));
		O.l("0x0f0f0f0f=0b" + B32va.str16(0x0f0f0f0f));
		O.l("0x3f=0b" + B32va.str16(0x3f));

	}

	public static void main433(String[] sAry) throws Throwable {

		// 國仁
		int fileupload1;

		int fileupload_Ali;

		int fileupload_Tsmc;

		// new_fileupload
		// new_new_fileupload

		long aaa = 9_223_372_036_854_775_783L;

		O.l("p2=" + (aaa % 6));

	}

	public static void main3(String[] sAry) throws Throwable {

		long n1 = 123456701;

		long p = 347;
		O.l("p2=" + p);

		long pX2 = p << 1;
		O.l("pX2=" + pX2);

		long pSq = p * p;

		O.l("pSq=" + pSq);

		long q = (n1 - pSq) / pX2;

		O.l("q=" + q);

		// ++q;

		long pX2MulQ = pX2 * q;

		O.l("pX2MulQ=" + pX2MulQ);

		long newN1 = pX2 * q + pSq;
		O.l("newN1=" + newN1);

		newN1 += pX2;
		O.l("newN1=" + newN1);

		newN1 += pX2;
		O.l("newN1=" + newN1);

	}

	public static void main68(String[] sAry) throws Throwable {

		new PrimeAry2D().tailP();

		long[][] aryOfAry = new long[3][];
		aryOfAry[0] = ary1;
		aryOfAry[1] = ary2;
		aryOfAry[2] = ary3;

		Arrays.sort(aryOfAry, CompaForAryOfPrime.COMPA);

		O.l("h0=" + aryOfAry[0][0]);
		O.l("h1=" + aryOfAry[1][0]);
		O.l("h2=" + aryOfAry[2][0]);

		new PrimeAry2D().sort(CompaForAryOfPrime.COMPA);

	}

	public static void main92(String[] sAry) throws Throwable {

		long aaa = 0b1L << 63;

		O.l("MAX_VALUE=" + Long.MAX_VALUE);
		O.l("aaa=" + Long.toBinaryString(aaa));
		O.l("aaa=" + aaa);
		O.l();
		O.l("MIN_VALUE=" + Long.MIN_VALUE);
		O.l("aaa-1=" + Long.toBinaryString(aaa - 1L));
		O.l("aaa-1=" + (aaa - 1L));

	}

	public static void main6(String[] sAry) throws Throwable {

		Object[] base = new Object[] { new int[] { 10, 20 }, new int[] { 30, 40 } };

		Object[] newAry = new Object[20];

		System.arraycopy(base, 0, newAry, 0, base.length);

		int[] tmpAry = (int[]) base[0];

		O.l("ans1=" + tmpAry[1]);
		tmpAry[1] = 99;

		int[] tmpAry2 = (int[]) newAry[0];
		O.l("ans2=" + tmpAry2[1]);

	}
}
