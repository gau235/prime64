package lgpl3.other.uI.thr;

import java.awt.Frame;
import java.lang.management.ManagementFactory;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.other.uI.MySwingva;

/**
 * The thread to show CPU and memory usage.<br/>
 * The thread to show CPU and memory usage.
 *
 * @version 2021/09/07_19:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=MyThrToShowCpuLoad" >MyThrToShowCpuLoad.java</a>
 *
 */
public class MyThrToShowCpuLoad extends Thread {

	// private static final Class<?> THIS = MyThrToShowCpuLoad.class;

	public static final com.sun.management.OperatingSystemMXBean OS_BEAN = (com.sun.management.OperatingSystemMXBean) ManagementFactory
			.getOperatingSystemMXBean();

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public MyThrToShowCpuLoad() {

		setDaemon(B.I);
		start(); // auto start

	}

	@Override
	public void run() {

		StringBuilder tailStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR).append(" / ").append(O.f(O.$XMX)).append(" MB");

		StringBuilder str;

		Frame targetFrame = MySwingva.mainFrame;

		do {

			try {
				sleep(400);

			} catch (InterruptedException interruptedEx) {

				interruptedEx.printStackTrace();
			}

			str = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

			str.append("CPU=").append(String.format("%02d", (int) (100.0F * (float) OS_BEAN.getProcessCpuLoad()))).append("%   MEM=");

			str.append(O.f(O.curUsingMem())).append(tailStr);

			targetFrame.setTitle(str.toString());

		} while (B.I);
	}
}
