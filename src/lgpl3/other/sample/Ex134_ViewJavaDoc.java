package lgpl3.other.sample;

/**
 * 看線上 Java doc.<br/>
 * To view online Java doc.
 * 
 * @version 2019/05/26_11:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex134_ViewJavaDoc" >Ex134_ViewJavaDoc.java </a>
 * 
 */
public class Ex134_ViewJavaDoc {

	public static void main(String[] sAry) throws Throwable {

		ProcessBuilder processBuilder = new ProcessBuilder("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe",
				"http://c64.tw/w20/prime64Lgpl/srcTxtNDoc/doc");

		Process process = processBuilder.start();

		// int exitValue = process.waitFor();
		// O.l("exitValue=" + exitValue);

		process.destroy();

	}

}
