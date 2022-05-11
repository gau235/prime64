package lgpl3.other.sample;

import java.util.TreeMap;

import lgpl3.o.O;
import lgpl3.other.jsp.Jsp;

/**
 * To open a Http connection.<br/>
 * To open a Http connection.
 *
 * @version 2017/01/14_20:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Ex109_HttpConn" >Ex109_HttpConn.java</a>
 *
 */
public class Ex109_HttpConn {

	public static void main(String[] sAry) throws Throwable {

		String sUrl = "http://c64.tw/w20/fraction/doFr64NoneJson.jsp";
		// String sUrl = "http://gau89:8080/w20/fraction/doFr64NoneJson.jsp";
		TreeMap<CharSequence, CharSequence> mapOfParam = new TreeMap<CharSequence, CharSequence>();
		mapOfParam.put("f1", "1/2");
		mapOfParam.put("f2", "0.3");
		mapOfParam.put("op", "add");

		O.l(Jsp.doPostNDownload(sUrl, mapOfParam));

	}
}
