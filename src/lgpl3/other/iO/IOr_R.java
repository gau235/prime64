package lgpl3.other.iO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import lgpl3.o.B;

/**
 * @version 2020/02/05_09:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=IOr_R" >IOr_R.java</a>
 *
 * @see IOr_U
 */
public abstract class IOr_R extends IOr_N {

	// private static final Class<?> THIS = IOr_R.class;

	/**
	 * 解壓縮.<br/>
	 * 不支援中文檔案名稱, 不支援中文內容.<br/>
	 * To unzip.
	 */
	public static void unzip(String sZipFile, String sOutputDir) throws IOException {

		final int size32OfBuff = 2048;
		byte[] byteAry = new byte[size32OfBuff];

		try (ZipFile zipFile = new ZipFile(sZipFile, StandardCharsets.UTF_8);) {

			Enumeration<? extends ZipEntry> allZEntry = zipFile.entries();

			while (allZEntry.hasMoreElements()) {

				ZipEntry zEntry = allZEntry.nextElement();

				String sFileOrDir = zEntry.getName();

				Path pFileOrDir = Paths.get(sOutputDir, sFileOrDir);
				File fileOrDir = pFileOrDir.toFile();

				// O.l("fileOrDir=" + fileOrDir.getAbsoluteFile() , THIS);

				if (zEntry.isDirectory()) {

					// O:/tmp/jre/COPYRIGHT
					fileOrDir.mkdirs(); // todo: need improve

					// Files.createDirectories(pFileOrDir);

					// File parentOfFileOrDir = fileOrDir.getParentFile();
					// O.l("parentOfFileOrDir=" + parentOfFileOrDir.getAbsoluteFile() , THIS);

					// when exists
					fileOrDir.setReadable(B.I, B.O);
					fileOrDir.setWritable(B.I, B.O);
					fileOrDir.setExecutable(B.I, B.O);

					continue;

				} else {// it will be dir/file

					File parentOfFileOrDir = fileOrDir.getParentFile();

					// if (parentOfFileOrDir != null) {}

					// create all non exists folders else you get FileNotFoundException
					parentOfFileOrDir.mkdirs();

					// when exists
					parentOfFileOrDir.setReadable(B.I, B.O);
					parentOfFileOrDir.setWritable(B.I, B.O);
					parentOfFileOrDir.setExecutable(B.I, B.O);

				}

				try (BufferedInputStream bufIn = new BufferedInputStream(zipFile.getInputStream(zEntry));) {

					try (FileOutputStream fileOut = new FileOutputStream(fileOrDir);
							BufferedOutputStream bufOut = new BufferedOutputStream(fileOut);) {

						int len;
						while ((len = bufIn.read(byteAry)) > 0)
							bufOut.write(byteAry, 0, len);

						bufOut.flush(); // first to write then to flush

					}

					// when exists
					fileOrDir.setReadable(B.I, B.O);
					fileOrDir.setWritable(B.I, B.O);
					fileOrDir.setExecutable(B.I, B.O);

				}
			}
		}
	}
}