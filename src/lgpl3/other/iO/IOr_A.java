package lgpl3.other.iO;

import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 本類別檔案讀寫娃.<br/>
 * To input and to output.
 *
 * @version 2022/05/26_00:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=IOr_A" >src</a>
 *
 * @see IOr_N
 */
public abstract class IOr_A {

	// private static final Class<?> THIS = IOr_A.class;

	/**
	 * 關閉所有 Closeable.<br/>
	 * To close all.
	 *
	 * @throws IOException
	 */
	public static void closeAll(Closeable... aryOfCloseable) throws IOException {

		Closeable closeableObj;
		for (int idx = 0; idx != aryOfCloseable.length; idx++)

			if ((closeableObj = aryOfCloseable[idx]) != null)

				closeableObj.close();

	}

	/**
	 * java 7 檔案不能恰在 根目錄 之下 Path targetPath = Paths.get("D:/z.txt");<br/>
	 * 會造成 Exception in thread "main" java.io.IOException: Root directory does not exist<br/>
	 * at java.nio.file.Files.createDirectories(Files.java:713)
	 *
	 * @throws IOException
	 */
	public static Path newDirNFile(Path pathOfFile) throws IOException {

		Files.createDirectories(pathOfFile.getParent());

		if (!Files.exists(pathOfFile))

			Files.createFile(pathOfFile);

		return pathOfFile;

	}
}