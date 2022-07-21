package lgpl3.other.sample;

import java.io.File;

import lgpl3.o.O;

/**
 * To get free space of disk.<br/>
 * To get free space of disk.
 *
 * @version 2020/08/26_23:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex132_ShowFreeSpaceOfDisk" >
 *          Ex132_ShowFreeSpaceOfDisk.java</a>
 *
 */
public class Ex132_ShowFreeSpaceOfDisk {

	public static void main(String[] sAry) throws Throwable {

		File[] aryOfRoot = File.listRoots();

		long all = 0L;
		File fRoot;
		long freeSpace;
		if (aryOfRoot != null && aryOfRoot.length > 0) {

			for (int i = 0; i != aryOfRoot.length; i++) {

				fRoot = aryOfRoot[i];

				freeSpace = fRoot.getFreeSpace();

				O.l(fRoot.toString().substring(0, 1) + "=" + O.f(freeSpace / (0b1 << 20)) + " M");

				all += freeSpace;

			}
		}

		O.l("all=" + O.f(all / (0b1 << 30)) + "G");

	}
}