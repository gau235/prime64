package lgpl3.other.uI;

import java.awt.Color;
import java.awt.event.MouseListener;

import javax.swing.DefaultRowSorter;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import lgpl3.comb.filter.CompaForCharSeqAsF32;
import lgpl3.comb.filter.CompaForStr;
import lgpl3.o.B;

/**
 * 本類別記錄用表格.<br/>
 * The table to record.
 *
 * @version 2021/09/06_09:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=MyTablePane" >MyTablePane.java</a>
 *
 * @see MyTableModel
 */
@SuppressWarnings("serial")
public class MyTablePane extends JScrollPane {

	// private static final Class<?> THIS = MyTablePane.class;

	public static final DefaultTableModel TABLE_MODEL = new MyTableModel(new Object[][] {},
			new Object[] { "N1", "N2", "Thr", "#Prime", "Cost(s)", "Time" });

	public static final JTable TABLE = new JTable(TABLE_MODEL);

	public static final TableColumnModel TABLE_COL_MODEL = TABLE.getColumnModel();

	public static final TableColumn[] TABLE_COL_ARY0 = new TableColumn[0];

	/**
	 * The row height.<br/>
	 * The row height.
	 */
	public static final int H_PER_ROW = (int) (MySwingva.hOfFontDialog_1_26 * 1.0F + 1.0F);

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public MyTablePane() {

		TABLE.setFont(MySwingva.dynaFontDialog_1_26);
		TABLE.setBackground(MySwingva.COLOR_TXT_BACKGROUND);
		TABLE.setBorder(MySwingva.EMPTY_BORDER);
		TABLE.setRowHeight(H_PER_ROW);

		TABLE.setSelectionBackground(MySwingva.COLOR_BACKGROUND);
		TABLE.setCellSelectionEnabled(B.I);
		TABLE.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		TABLE.setFillsViewportHeight(B.I);
		TABLE.setShowHorizontalLines(B.O);
		// TABLE.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		// setAutoCreateRowSorter(B.I);
		// TABLE.setOpaque(B.I);

		TableColumn tabCol0 = TABLE_COL_MODEL.getColumn(0);
		TableColumn tabCol1 = TABLE_COL_MODEL.getColumn(1);
		TableColumn tabCol2 = TABLE_COL_MODEL.getColumn(2);
		TableColumn tabCol3 = TABLE_COL_MODEL.getColumn(3);
		TableColumn tabCol4 = TABLE_COL_MODEL.getColumn(4);
		TableColumn tabCol5 = TABLE_COL_MODEL.getColumn(5);

		DefaultTableCellRenderer myCellR = new DefaultTableCellRenderer();
		myCellR.setHorizontalAlignment(SwingConstants.RIGHT);
		// myCellR.setForeground(Color.RED);

		tabCol0.setPreferredWidth(80); // N1
		tabCol1.setPreferredWidth(130); // N2

		// tabCol2.setPreferredWidth(50); // Thr
		// tabCol3.setPreferredWidth(95); // #Prime
		// tabCol4.setPreferredWidth(95); // Cost(s)
		tabCol5.setPreferredWidth(145); // T10

		tabCol0.setCellRenderer(myCellR);
		tabCol1.setCellRenderer(myCellR);
		tabCol2.setCellRenderer(myCellR);
		tabCol3.setCellRenderer(myCellR);
		tabCol4.setCellRenderer(myCellR);
		tabCol5.setCellRenderer(myCellR);

		DefaultRowSorter<DefaultTableModel, ?> myRowSorter = new TableRowSorter<DefaultTableModel>(TABLE_MODEL);

		myRowSorter.setComparator(0, MyCompaForInt64InColOfTable.COMPA); // N1
		myRowSorter.setComparator(1, MyCompaForInt64InColOfTable.COMPA); // N2

		if (!CompaForStr.IS_COMPARABLE)
			myRowSorter.setComparator(2, CompaForStr.COMPA); // THR

		myRowSorter.setComparator(3, MyCompaForInt64InColOfTable.COMPA); // NumOfP
		myRowSorter.setComparator(4, CompaForCharSeqAsF32.COMPA); // COST(s)

		if (!CompaForStr.IS_COMPARABLE)
			myRowSorter.setComparator(5, CompaForStr.COMPA); // TIME

		TABLE.setRowSorter(myRowSorter);

		// TABLE.setAutoscrolls(B.I);
		// TABLE.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		// TABLE.setPreferredSize(null);

		JTableHeader tabHeader = TABLE.getTableHeader();
		tabHeader.setBackground(MySwingva.COLOR_TXT_BACKGROUND);
		tabHeader.setBorder(MySwingva.EMPTY_BORDER);
		tabHeader.setFont(MySwingva.dynaFontDialog_1_26);
		// tabHeader.setOpaque(B.O);

		MouseListener myLsnr = new MyPopupMenuToSave(MySue.KEY_REC0);

		tabHeader.addMouseListener(myLsnr);

		/////////////////////////////////////////////////////////////

		JScrollBar hScrlbar, vScrlbar;

		hScrlbar = getHorizontalScrollBar();
		hScrlbar.setBackground(MySwingva.COLOR_BACKGROUND);
		hScrlbar.setBorder(MySwingva.EMPTY_BORDER);
		hScrlbar.setDoubleBuffered(B.I);

		vScrlbar = getVerticalScrollBar();
		vScrlbar.setBackground(MySwingva.COLOR_BACKGROUND);
		vScrlbar.setBorder(MySwingva.EMPTY_BORDER);
		vScrlbar.setDoubleBuffered(B.I);

		vScrlbar.addMouseListener(myLsnr);

		JViewport viewport = new JViewport();
		viewport.setBackground(Color.BLACK); // important, tabHeader 背景

		setColumnHeader(viewport);
		setViewportView(TABLE);

		setBorder(MySwingva.EMPTY_BORDER);

		setBackground(MySwingva.COLOR_BACKGROUND);
		// setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setDoubleBuffered(B.I);

		// getRootPane().setBackground(Color.red);

		viewport = getViewport();

		// viewport.setBorder(MySwingva.EMPTY_BORDER); // error JViewport.setBorder() not supported
		viewport.setBackground(Color.BLACK); // important, 表格表頭 拖拉的背景

	}
}
