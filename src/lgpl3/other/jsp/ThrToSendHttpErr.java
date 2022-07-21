package lgpl3.other.jsp;

import java.io.IOException;
import java.util.TreeMap;

import lgpl3.o.O;

/**
 * The thread to send the record to Http.<br/>
 * The thread to send the record to Http.
 *
 * @version 2021/08/20_13:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=ThrToSendHttpErr" >ThrToSendHttpErr.java</a>
 *
 */
public class ThrToSendHttpErr extends Thread {

	private static final Class<?> THIS = ThrToSendHttpErr.class;

	/**
	 * The URL to record error.<br/>
	 * The URL to record error.
	 */
	public static final String S_URL_TO_SEND_HTTP_ERR = "http://c64.tw/w20/o/recErr.jsp";

	public TreeMap<CharSequence, CharSequence> mapOfParam = new TreeMap<CharSequence, CharSequence>();;

	public ThrToSendHttpErr(CharSequence err, CharSequence note) {

		mapOfParam.put("err", err);
		mapOfParam.put("note", note);

		start(); // auto start

	}

	@Override
	public void run() {

		if (O.isDev)
			O.l("mapOfParam=" + mapOfParam, THIS);

		try {
			Jsp.doPost(S_URL_TO_SEND_HTTP_ERR, mapOfParam);

		} catch (IOException iOEx) {

			iOEx.printStackTrace();
		}
	}
}
