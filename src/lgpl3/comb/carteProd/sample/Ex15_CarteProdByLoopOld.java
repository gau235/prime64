package lgpl3.comb.carteProd.sample;

import lgpl3.comb.carteProd.CarteProd;
import lgpl3.comb.carteProd.CarteProdCnk;
import lgpl3.comb.thr.ThrCnkBySpareB64;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.o.ary.Ary2D;
import lgpl3.o.ary.Seq;

/**
 * To product.<br/>
 * To product.
 *
 * @version 2022/07/09_00:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex15_CarteProdByLoopOld" >src</a>
 *
 */
public class Ex15_CarteProdByLoopOld {

	public static void main(String[] sAry) throws Throwable {

		String[] sAry1 = { "A", "B", "C" };
		String[] sAry2 = { "blue", "green", "red" };
		String[] sAry3 = { "甲", "乙", "丙" };

		long b64As2Pow;

		Ary2D ary2D = new Ary2D();

		b64As2Pow = (0b1L << sAry1.length) - 0b1L;
		ary2D.a(new ThrCnkBySpareB64(b64As2Pow, 2, B.I).box);

		b64As2Pow = (0b1L << sAry2.length) - 0b1L;
		b64As2Pow = b64As2Pow << sAry1.length;
		ary2D.a(new ThrCnkBySpareB64(b64As2Pow, 1, B.I).box);

		b64As2Pow = (0b1L << sAry3.length) - 0b1L;
		b64As2Pow = b64As2Pow << (sAry1.length + sAry2.length);
		ary2D.a(new ThrCnkBySpareB64(b64As2Pow, 2, B.I).box);

		Arr<Seq> ret = CarteProd.oldProdByLoop(ary2D);

		O.eq(ret.i, sAry1.length * sAry2.length * sAry3.length);

		O.l(CarteProdCnk.toStrByArrOfSeq(ret, O.mergeIn1SAry(sAry1, sAry2, sAry3), O.S9, O.L));

	}
}