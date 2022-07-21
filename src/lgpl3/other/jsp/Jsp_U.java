package lgpl3.other.jsp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.TreeMap;

import lgpl3.o.B;

/**
 * @version 2018/04/09_21:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Jsp_U" >Jsp_U.java</a>
 *
 * @see Jsp
 */
public abstract class Jsp_U extends Jsp_K {

	// private static final Class<?> THIS = Jsp_U.class;

	/**
	 * From MapOfParam to arg.<br/>
	 * From MapOfParam to arg.
	 *
	 * @throws UnsupportedEncodingException
	 */
	public static StringBuilder encodeMapOfParam(TreeMap<? extends CharSequence, ? extends CharSequence> mapOfParam)
			throws UnsupportedEncodingException {

		StringBuilder retStr = new StringBuilder(defLenForStr);

		// Ery<String> eryOfKey = new Ery<String>(mapOfParam.keySet());
		CharSequence[] sAryOfKey = mapOfParam.keySet().toArray(CHAR_SEQ_ARY0);
		CharSequence[] sAryOfVal = mapOfParam.values().toArray(CHAR_SEQ_ARY0);

		CharSequence key;
		for (int idx = 0, lenMinus1 = sAryOfKey.length - 1; idx <= lenMinus1; idx++) {

			key = sAryOfKey[idx];

			if (idx == 0)

				retStr.append(key).append(C61);
			else
				retStr.append(C38).append(key).append(C61);

			retStr.append(URLEncoder.encode(sAryOfVal[idx].toString(), S_UTF_8)); // important

		}

		return retStr;

	}

	/**
	 * To do HTML post.<br/>
	 * To do HTML post.
	 *
	 * @throws IOException
	 */
	public static void doPost(String sUrl, TreeMap<? extends CharSequence, ? extends CharSequence> mapOfParam)

			throws IOException {

		// l("stringForUrl=" + S32 + THIS + L + stringForUrl);

		HttpURLConnection httpUrlConn = (HttpURLConnection) (new URL(sUrl).openConnection());

		httpUrlConn.setDoOutput(B.I);
		// httpUrlConn.setDoInput(B.I);
		httpUrlConn.setRequestMethod(STRING_POST);
		httpUrlConn.connect();

		try (OutputStreamWriter outWriter = new OutputStreamWriter(httpUrlConn.getOutputStream());
				BufferedWriter bufWriter = new BufferedWriter(outWriter);) {

			bufWriter.write(encodeMapOfParam(mapOfParam).toString()); // first to write then to flush
			bufWriter.flush();

		}

		// int respCode = httpUrlConn.getResponseCode();
		// l("respCode=" + respCode);
		// if (respCode == HttpURLConnection.HTTP_OK) {}
		// try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(httpUrlConn.getInputStream()));) {}

		httpUrlConn.getInputStream().close(); // fuck
		httpUrlConn.disconnect();

	}

	/**
	 * To do HTML post.<br/>
	 * To do HTML post.
	 *
	 * @throws IOException
	 */
	public static StringBuilder doPostNDownload(String sUrl, TreeMap<? extends CharSequence, ? extends CharSequence> mapOfParam)

			throws IOException {

		// l("stringForUrl=" + S32 + THIS + L + stringForUrl);

		String someParam = encodeMapOfParam(mapOfParam).toString();
		// l("someParam=" + someParam + S32 + THIS);

		HttpURLConnection httpUrlConn = (HttpURLConnection) (new URL(sUrl).openConnection());

		httpUrlConn.setDoOutput(B.I);
		httpUrlConn.setDoInput(B.I);
		httpUrlConn.setRequestMethod(STRING_POST);
		httpUrlConn.connect();

		try (BufferedWriter bufWriter = new BufferedWriter(new OutputStreamWriter(httpUrlConn.getOutputStream()))) {

			bufWriter.write(someParam); // first to write then to flush
			bufWriter.flush();

		}

		// download
		StringBuilder retStr = new StringBuilder(defLenForStr);
		try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(httpUrlConn.getInputStream()))) {

			String sLine;
			while ((sLine = bufReader.readLine()) != null) // l(sLine + S32 + THIS);

				retStr.append(sLine).append(C_A_L);

		}

		httpUrlConn.disconnect();

		return retStr;

	}

	/**
	 * To do HTML post.<br/>
	 * To do HTML post.
	 *
	 * @throws IOException
	 */
	public static StringBuilder doPostNDownload(String sUrl) throws IOException {

		// l("sUrl=" + sUrl);

		HttpURLConnection httpConn = (HttpURLConnection) (new URL(sUrl).openConnection());

		httpConn.setDoOutput(B.I);
		httpConn.setDoInput(B.I);
		httpConn.setRequestMethod(STRING_POST);
		httpConn.connect();

		// download
		StringBuilder retStr = new StringBuilder(defLenForStr);
		try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));) {

			String tmpS;
			while ((tmpS = bufReader.readLine()) != null)
				retStr.append(tmpS).append(C_A_L);

		}

		httpConn.disconnect();

		return retStr;

	}
}
