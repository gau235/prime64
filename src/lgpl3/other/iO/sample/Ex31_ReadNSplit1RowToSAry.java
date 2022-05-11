package lgpl3.other.iO.sample;

import java.nio.file.Paths;

import lgpl3.o.O;
import lgpl3.other.iO.IOr;

/**
 * 行列互換.<br/>
 * Row to column.
 *
 * @version 2019/05/08_16:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex31_ReadNSplit1RowToSAry" >
 *          Ex31_ReadNSplit1RowToSAry.java</a>
 *
 * @see Ex31_ReadNSplit1RowToSAry
 *
 * @see Ex32_ReadNMergeSomeSInto1Row
 *
 * @see Ex34_ReadStringAsF32NSort
 */
public class Ex31_ReadNSplit1RowToSAry {

	public static void main(String[] sAry) throws Throwable {

		// such as:
		// String aaa = "A,B,C,D,E,F,G,H,I";
		// sAry = aaa.split(",");
		//
		// O.l("sAry=");
		// O.l(sAry);

		sAry = IOr.readNSplit1RowToSAry(Paths.get("C:/tmp/a.txt"), O.S44);
		O.l(sAry);

	}
}
