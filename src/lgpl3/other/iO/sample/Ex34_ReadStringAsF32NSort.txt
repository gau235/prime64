package lgpl3.other.iO.sample;

import java.nio.file.Paths;
import java.util.Arrays;

import lgpl3.comb.filter.CompaForCharSeqAsF32;
import lgpl3.o.O;
import lgpl3.other.iO.IOr;

/**
 * To read and sort.<br/>
 * To read and sort.
 *
 * @version 2019/04/19_20:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex34_ReadStringAsF32NSort" >
 *          Ex34_ReadStringAsF32NSort.java</a>
 *
 * @see Ex31_ReadNSplit1RowToSAry
 *
 * @see Ex32_ReadNMergeSomeSInto1Row
 *
 * @see Ex34_ReadStringAsF32NSort
 */
public class Ex34_ReadStringAsF32NSort { // for 曜明, 用 excel 比較方便

	public static void main(String[] sAry) throws Throwable {

		StringBuilder retStr = IOr.readStrFrom(Paths.get("C:/tmp/a.txt"));

		sAry = O.splitNTrimAll(retStr.toString(), O.L.toString());

		Arrays.sort(sAry, CompaForCharSeqAsF32.REV_COMPA);

		O.l(sAry);

	}
}
