package lgpl3.other.jsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import lgpl3.o.ary.Arr;
import lgpl3.o.str.SW;

/**
 * 本類別 JSP 娃.<br/>
 * The class to handle JSP.
 *
 * @version 2021/09/22_11:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Jsp" >Jsp.java</a>
 *
 */
public abstract class Jsp extends Jsp_U {

	// private static final Class<?> THIS = Jsp.class;

	/**
	 * To insert data into table.<br/>
	 * To insert data into table.
	 *
	 * @throws SQLException
	 */
	public static boolean insertIntoTable(Connection conn, String nameOfTable, TreeMap<String, String> mapOfParam) throws SQLException {

		SW str = new SW();// important
		str.a("INSERT INTO" + S32 + nameOfTable + S40);

		String[] sAryOfKey = mapOfParam.keySet().toArray(S_ARY0);
		String key;
		for (int idx = 0, lenMinus1 = sAryOfKey.length - 1; idx <= lenMinus1; idx++) {

			key = sAryOfKey[idx];

			if (idx < lenMinus1)
				str.a(key + S44);

			else
				str.a(key);

		}

		str.a(S41 + "VALUES" + S40 + S39);// important

		String[] sAryOfVal = mapOfParam.values().toArray(S_ARY0);
		String value;
		for (int idx = 0, lenMinus1 = sAryOfVal.length - 1; idx <= lenMinus1; idx++) {

			value = sAryOfVal[idx];

			if (idx < lenMinus1)
				str.a(value + S39 + S44 + S39);

			else
				str.a(value + S39);

		}

		str.a(S41);// important

		// l(str);

		try (Statement statement = conn.createStatement();) {

			return statement.execute(str.str.toString());
		}
	}

	/**
	 * From MapOfParam to arg.<br/>
	 * From MapOfParam to arg.
	 *
	 * @throws SQLException
	 */
	public static PreparedStatement toPreparedStatementToInsert(Connection conn, String nameOfTable, Arr<String> arrOfColName)
			throws SQLException {

		SW str = new SW(); // important
		str.a("INSERT INTO" + S32 + nameOfTable + S40);

		String[] sAry = arrOfColName.arr;
		String key;
		for (int idx = 0, lenMinus1 = arrOfColName.iLen - 1; idx <= lenMinus1; idx++) {

			key = sAry[idx];

			if (idx < lenMinus1)
				str.a(key + S44);

			else
				str.a(key);

		}

		str.a(S41 + "VALUES" + S40);

		for (int idx = 0, lenMinus1 = arrOfColName.iLen - 1; idx <= lenMinus1; idx++) {

			if (idx < lenMinus1)
				str.a(S63 + S44);

			else
				str.a(S63);

		}

		str.a(S41); // important

		// l(str);

		return conn.prepareStatement(str.str.toString());

	}

	/**
	 * To delete data before.<br/>
	 * To delete data before.
	 *
	 * @throws SQLException
	 */
	public static boolean delDatBef(Connection conn, String tableName, String colName, String stringbound) throws SQLException {

		try (Statement statement = conn.createStatement();) {

			String sql = "DELETE FROM " + tableName + " WHERE " + colName + " < '" + stringbound + "'";
			// l("sql=" + sql + S32, THIS);

			return statement.execute(sql);

		}
	}
}