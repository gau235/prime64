package lgpl3.o.keyNV.sample;

import lgpl3.o.O;
import lgpl3.o.keyNV.K32V;
import lgpl3.o.keyNV.MapK32V;

/**
 * To use MapK32V.<br/>
 * To use MapK32V.
 *
 * @version 2021/02/02_17:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex26_MapK32V" >Ex26_MapK32V.java</a>
 *
 */
public class Ex26_MapK32V {

	public static void main(String[] sAry) throws Throwable {

		MapK32V<String> mayMap = new MapK32V<String>();

		mayMap.a(new K32V<String>(5, "H55"));

		mayMap.a(9, "C99");
		mayMap.a(8, "H88");

		mayMap.sort();

		O.l("get=" + mayMap.get(5));
		O.l("cutTail=" + mayMap.cutTail().toStr());

		O.l("iLen=" + mayMap.iLen);
		O.l("myMap" + O.L + mayMap.toStr());

	}
}
