package lgpl3.other.jsp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 本類別關閉資料庫連線的執行緒.<br/>
 * The thread to close database connection.
 *
 * @version 2021/09/06_09:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=ThrCloseConnToDd" >ThrCloseConnToDd.java</a>
 *
 */
public class ThrCloseConnToDd extends Thread {

	// private static final Class<?> THIS = ThrCloseConnToDd.class;

	public final ResultSet RESULT_SET;

	public final Statement STATEMENT;

	public final Connection CONN;

	/**
	 * 關閉連線.<br/>
	 * To close connection.
	 */
	public static void close(ResultSet resultSet, Statement statement, Connection conn) throws Throwable {

		if (resultSet != null && !resultSet.isClosed())
			resultSet.close();

		if (statement != null && !statement.isClosed())
			statement.close();

		if (conn != null && !conn.isClosed())
			conn.close();

	}

	/**
	 * 關閉連線.<br/>
	 * To close.
	 */
	public static void close(Statement statement, Connection conn) throws Throwable {

		close(null, statement, conn);
	}

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrCloseConnToDd(ResultSet resultSet, Statement statement, Connection conn) {

		RESULT_SET = resultSet;
		STATEMENT = statement;
		CONN = conn;

		start(); // auto start

	}

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public ThrCloseConnToDd(Statement statement, Connection conn) {

		this(null, statement, conn);
	}

	@Override
	public void run() {

		try {
			close(RESULT_SET, STATEMENT, CONN); // O.l("close" , THIS);

		} catch (Throwable throwable) {

			throwable.printStackTrace();
		}
	}
}
