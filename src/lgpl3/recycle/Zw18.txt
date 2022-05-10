package lgpl3.recycle;

import java.io.File;
import java.nio.charset.Charset;
import java.util.TreeMap;

import lgpl3.comb.filter.CompaForStr;
import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.str.SByN;
import lgpl3.other.jsp.Jsp;
import lgpl3.other.uI.Recva;

/**
 * @version 2020/02/14_10:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=Zw18" >Zw18.java</a>
 *
 * @see Zw08
 */
public abstract class Zw18 {

	private static final Class<?> THIS = Zw18.class;

	public static void main(String[] sAry) throws Throwable {

		char[] ccc = new char[50];

		int test = ccc[0];

		O.l("test[0]=" + test);

		int y = 1;
		y = y / y--;

		O.l(y);

		int a = 4 > 2 ? 5 < 3 ? 3 : 5 : 7;

		O.l(a);

	}

	public static void main9(String[] sAry) throws Throwable {

		StringBuilder aaa = new StringBuilder("aba");
		StringBuilder bbb = new StringBuilder("abc");

		long a1 = O.t();

		for (int i = 0; i != 100000000; i++) {

			// aaa.compareTo(bbb); // Java 11, StringBuilder.compareTo

		}

		O.l("compare1=" + (O.t() - a1));
		a1 = O.t();

		for (int i = 0; i != 100000000; i++) {

			CompaForStr.COMPA.compare(aaa, bbb);
		}

		O.l("compare2=" + (O.t() - a1));

	}

	public static void main65(String[] sAry) throws Throwable {

		Recva recva = new Recva();

		recva.n1 = 1;
		recva.n2 = 100;
		recva.numOfThr = 1;

		recva.totalP = 50;
		recva.f32TimeCost = 50;

		recva.note = new StringBuilder(O.DEF_CAPACITY32_FOR_STR).append("EP").append(SByN.pad0D2(1));
		recva.tmpObj = O.SYS_USER_DOT_NAME;

		String S_URL = "http://c64.tw/w20/test/insertDb.jsp";

		TreeMap<String, String> mapOfParam = new TreeMap<String, String>();

		mapOfParam.put("n1", O.f(recva.n1).toString());
		mapOfParam.put("n2", O.f(recva.n2).toString());
		mapOfParam.put("numOfThr", Integer.toString(recva.numOfThr));

		mapOfParam.put("totalP", O.f(recva.totalP).toString());
		mapOfParam.put("timeCost", String.format(SByN.REGEX_FLOAT, recva.f32TimeCost));

		mapOfParam.put("note", recva.note.toString());
		mapOfParam.put("tmpObj", recva.tmpObj.toString());

		try {
			Jsp.doPost(S_URL, mapOfParam);

		} catch (Throwable throwable) {

			throwable.printStackTrace();
		}
	}

	public static void main55(String[] sAry) throws Throwable {

		File f = new File("D:/err2.txt");

		f.setReadable(B.I, B.O);
		f.setWritable(B.I, B.O);
		f.setExecutable(B.I, B.O);

		O.l("file exist=" + f.exists());
		// O.l("file delete=" + f.delete());

	}

	public static void main33(String[] sAry) throws Throwable {

		System.setProperty("sun.jnu.encoding", "UTF-8");
		System.setProperty("file.encoding", "UTF-8");

		O.l("\u6E2C\u8A66");
		O.l("====測試編碼212_1====", THIS);
		O.l("Default Charset=" + Charset.defaultCharset(), THIS);
		O.l("file.encoding=" + System.getProperty("file.encoding"), THIS);
		O.l("sun.jnu.encoding=" + System.getProperty("sun.jnu.encoding"), THIS);
		O.l("====測試編碼212_2====" + THIS);

	}
}
