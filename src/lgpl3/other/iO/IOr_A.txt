package lgpl3.other.iO;

import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 本類別檔案讀寫娃.<br/>
 * To input and to output.
 *
 * @version 2014/07/06_06:24:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=IOr_A" >IOr_A.java</a>
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
	 * To new dir and files.<br/>
	 * To new dir and files.
	 *
	 * @throws IOException
	 */
	public static void newDirNFile(Path pathOfFile) throws IOException {

		Files.createDirectories(pathOfFile.getParent());
		Files.createFile(pathOfFile);

	}
}