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
 * @version 2021/04/29_11:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex11_C_RecurCarteProd" >
 *          Ex11_C_RecurCarteProd.java</a>
 *
 */
public class Ex11_C_RecurCarteProd {

	public static void main(String[] sAry) throws Throwable {

		Arr<String[]> arrOfSAry = new Arr<String[]>(String[].class);

		String[] sAry1 = { "A", "B", "C" };
		String[] sAry2 = { "甲", "乙", "丙" };
		String[] sAry3 = { "100", "200", };

		arrOfSAry.a(sAry1);
		arrOfSAry.a(sAry2);
		arrOfSAry.a(sAry3);

		String[] bigSAry = Strva.mergeIn1SAry(arrOfSAry);

		long b64As2Pow;

		Ary2D ary2D = new Ary2D();

		b64As2Pow = ~(-0b1L << sAry1.length);
		ary2D.a(new ThrToCBySpareB64As2Pow(b64As2Pow, 2, B.I).box);

		b64As2Pow = ~(-0b1L << sAry2.length);
		b64As2Pow <<= sAry1.length;
		ary2D.a(new ThrToCBySpareB64As2Pow(b64As2Pow, 2, B.I).box);

		b64As2Pow = ~(-0b1L << sAry3.length);
		b64As2Pow <<= sAry1.length;
		b64As2Pow <<= sAry2.length;
		ary2D.a(new ThrToCBySpareB64As2Pow(b64As2Pow, 1, B.I).box);

		Arr<Seq> retArr = CarteProd.recur(ary2D);

		O.l(CarteProdCnk.toStrByArrOfSeq(retArr, bigSAry, O.S9, O.L));

	}
}