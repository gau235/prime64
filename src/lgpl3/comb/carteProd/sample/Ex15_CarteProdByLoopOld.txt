package lgpl3.comb.carteProd.sample;

import lgpl3.comb.carteProd.CarteProd;
import lgpl3.comb.carteProd.CarteProdCnk;
import lgpl3.comb.thr.ThrToCBySpareB64As2Pow;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Ary2D;
import lgpl3.o.ary.Seq;
import lgpl3.o.str.Strva;

/**
 * To product.<br/>
 * To product.
 *
 * @version 2021/03/23_09:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex15_CarteProdByLoopOld" >
 *          Ex15_CarteProdByLoopOld.java</a>
 *
 */
public class Ex15_CarteProdByLoopOld {

	public static void main(String[] sAry) throws Throwable {

		Arr<String[]> arrOfSAry = new Arr<String[]>(String[].class);

		String[] sAry1 = { "A", "B", "C" };
		String[] sAry2 = { "blue", "green", "red" };
		String[] sAry3 = { "甲", "乙", "丙" };

		arrOfSAry.a(sAry1);
		arrOfSAry.a(sAry2);
		arrOfSAry.a(sAry3);

		String[] bigSAry = Strva.mergeIn1SAry(arrOfSAry);

		long b64As2Pow;

		Ary2D ary2D = new Ary2D();

		b64As2Pow = (0b1L << sAry1.length) - 0b1L;
		ary2D.a(new ThrToCBySpareB64As2Pow(b64As2Pow, 2, B.I).box);

		b64As2Pow = (0b1L << sAry2.length) - 0b1L;
		b64As2Pow = b64As2Pow << sAry1.length;
		ary2D.a(new ThrToCBySpareB64As2Pow(b64As2Pow, 1, B.I).box);

		b64As2Pow = (0b1L << sAry3.length) - 0b1L;
		b64As2Pow = b64As2Pow << (sAry1.length + sAry2.length);
		ary2D.a(new ThrToCBySpareB64As2Pow(b64As2Pow, 2, B.I).box);

		Arr<Seq> retArr = CarteProd.oldProdByLoop(ary2D);
		O.l("retArr.iLen=" + retArr.iLen);

		StringBuilder str = CarteProdCnk.toStrByArrOfSeq(retArr, bigSAry, O.S9, O.L);
		O.l("str=");
		O.l(str);

	}
}