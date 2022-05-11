package lgpl3.other.iO.sample;

import java.nio.file.Paths;

import lgpl3.o.O;
import lgpl3.other.iO.IOr;

/**
 * 行列互換.<br/>
 * Row to column.
 *
 * @version 2019/04/19_20:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex32_ReadNMergeSomeSInto1Row" >
 *          Ex32_ReadNMergeSomeSInto1Row.java</a>
 *
 * @see Ex31_ReadNSplit1RowToSAry
 *
 * @see Ex32_ReadNMergeSomeSInto1Row
 *
 * @see Ex34_ReadStringAsF32NSort
 */
public class Ex32_ReadNMergeSomeSInto1Row {

	public static void main(String[] sAry) throws Throwable {

		StringBuilder str = IOr.readNMergeSomeSInto1Row(Paths.get("C:/tmp/a.txt"), O.L.toString(), O.S44);
		O.l(str);

	}
}
