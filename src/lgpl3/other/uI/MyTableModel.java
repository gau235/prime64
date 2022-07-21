package lgpl3.other.uI;

import javax.swing.table.DefaultTableModel;

import lgpl3.o.B;

/**
 * 本類別記錄用表格的模組.<br/>
 * <br/>
 * The TableModel of table for record.
 *
 * @version 2017/04/11_15:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=MyTableModel" >MyTableModel.java</a>
 *
 * @see MyTablePane
 */
@SuppressWarnings("serial")
public class MyTableModel extends DefaultTableModel {

	// private static final Class<?> THIS = MyTableModel.class;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public MyTableModel(Object[][] objAry2D, Object[] objAryOfColumnName) {

		super(objAry2D, objAryOfColumnName);
	}

	@Override
	public boolean isCellEditable(int row, int col) {

		return B.O;
	}

//	@Override
//	public Class<?> getColumnClass(int i) {
//
//		return getValueAt(0, i).getClass();
//	}
}
