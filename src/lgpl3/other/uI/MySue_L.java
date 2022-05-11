package lgpl3.other.uI;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

import lgpl3.o.O;
import lgpl3.o.ary.Arr;
import lgpl3.o.str.SByN;
import lgpl3.o.time.T64;
import lgpl3.other.iO.IOr;
import lgpl3.other.jsp.Jsp;
import lgpl3.other.jsp.ThrToSendHttpErr;

/**
 * @version 2021/10/07_19:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=MySue_L" >MySue_L.java</a>
 *
 * @see MySue
 */
public abstract class MySue_L extends MySue_G {

	private static final Class<?> THIS = MySue_L.class;

	/**
	 * To generate the Arr as all rows in table.<br/>
	 * To generate the Arr as all rows in table.
	 */
	public static Arr<CharSequence> genArrAsRowInTable(Recva recva) {

		Arr<CharSequence> arrOfCharSeq = new Arr<CharSequence>(CharSequence.class);

		arrOfCharSeq.a(new StringBuilder(O.f(recva.n1)));
		arrOfCharSeq.a(new StringBuilder(O.f(recva.n2)));
		arrOfCharSeq.a(recva.note); // fuck

		arrOfCharSeq.a(new StringBuilder(O.f(recva.totalP)));
		arrOfCharSeq.a(new StringBuilder(String.format(SByN.REGEX_FLOAT, recva.f32TimeCost)));

		arrOfCharSeq.a(new StringBuilder(T64.timeStr().substring(8, 19)));

		return arrOfCharSeq;

	}

	/**
	 * To insert one row into table.<br/>
	 * To insert one row into table.
	 */
	public static void insertRowIntoTable(Arr<CharSequence> arrOfCharSeq) {

		// O.l("arrOfCharSeq=" + arrOfCharSeq, THIS);

		// find NullPointerEx
		// DefaultRowSorter.convertRowIndexToModel(DefaultRowSorter.java:518)

		try {

			if (MyTablePane.TABLE_MODEL.getRowCount() == BOUND32_TO_CLEAR_REC)
				MyTablePane.TABLE_MODEL.setRowCount(0);

			MyTablePane.TABLE_MODEL.insertRow(0, arrOfCharSeq.trim().arr);

		} catch (Throwable throwable) {

			throwable.printStackTrace();

			new ThrToSendHttpErr(O.toStrByThrowable(throwable, Jsp.L), O.SYS_USER_DOT_NAME);

		}
	}

	/**
	 * To open the dir.<br/>
	 * To open the dir.
	 */
	public static void openDefDir() {

		try {
			MY_DESKTOP.open(defDirToSaveMP);

		} catch (IllegalArgumentException illegalArgumentEx) {

			if (O.isDev)

				O.l(illegalArgumentEx.getMessage(), THIS);

		} catch (IOException iOEx) {

			O.l(iOEx.toString(), THIS);
		}
	}

	/**
	 * To write data of all rows to rec.log<br/>
	 * To write data of all rows to rec.log
	 */
	public static void writeDatToFile() { // synchronized (allRow)

		Vector<?> allRow = MyTablePane.TABLE_MODEL.getDataVector();
		final int sizeAllRow = allRow.size();

		TableColumn[] aryOfTablCol = Collections.list(MyTablePane.TABLE_COL_MODEL.getColumns()).toArray(MyTablePane.TABLE_COL_ARY0);

		// Enumeration<TableColumn> eee = MyTablePane.TABLE.getColumnModel().getColumns();
		// for (; eee.hasMoreElements();) {
		//
		// TableColumn ttt = eee.nextElement();
		//
		// O.l(ttt.getHeaderValue().toString(), THIS);
		// O.l(ttt.getModelIndex() + "", THIS);
		//

		Vector<?> singleRow;
		JTable myTable = MyTablePane.TABLE;

		StringBuilder str = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		int iRow, sizeAllCol, iCol;
		for (iRow = 0; iRow != sizeAllRow;) {

			singleRow = (Vector<?>) allRow.get(myTable.convertRowIndexToModel(iRow));

			// O.l("sizeAllCol=" + sizeAllCol, THIS);

			for (iCol = 0, sizeAllCol = singleRow.size(); iCol != sizeAllCol;) {

				str.append(singleRow.get(aryOfTablCol[iCol].getModelIndex()));

				if (++iCol != sizeAllCol)
					str.append(O.C59);

			}

			if (++iRow != sizeAllRow)
				str.append(O.C_A_L);

		}

		///////////////////////////////////////////
		Path pathOfFile = defPathOfDirToSaveMP.resolve(MY_FULL_FILE_NAME_TO_REC);

		try {
			IOr.newDirNFile(pathOfFile);

		} catch (IOException iOEx) {

			if (!(iOEx instanceof FileAlreadyExistsException))
				O.l(iOEx.toString(), THIS);

		}

		///////////////////////////////////////////

		IOr.writeCharSeqToFile(str, pathOfFile);

	}
}
