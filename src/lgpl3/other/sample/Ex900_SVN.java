package lgpl3.other.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import lgpl3.o.O;

/**
 * SVN.<br/>
 * SVN.
 *
 * @version 2020/12/27_12:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex900_SVN" >Ex900_SVN.java</a>
 *
 */
public class Ex900_SVN {

	public static final Path pathOfFile = Paths.get("C:/tmp/a.txt");

	public static void main(String[] sAry) throws Throwable {

		// 方法 1:
		// cd c:\tmp
		// svn log -v --limit 40 https://gau89/svn/www2/src/ >a.txt
		// file have to be UTF-8

		// 方法 2:
		// everything.exe 可查出最近 更新 java 檔

		String string;

		ArrayList<String> ttt = new ArrayList<String>();

		try (BufferedReader bufR = Files.newBufferedReader(pathOfFile, StandardCharsets.UTF_8);) {

			while ((string = bufR.readLine()) != null) {

				if (string.endsWith(".java")) {

					string = O.subSBetween(new StringBuilder(string), "/", ".java");
					ttt.add(string);

					// O.l(string);

				}
			}

		} catch (IOException iOEx) {

			iOEx.printStackTrace();
		}

		for (String s : ttt)
			O.l(s);

	}
}