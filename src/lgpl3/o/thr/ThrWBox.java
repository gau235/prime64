package lgpl3.o.thr;

/**
 * The thread with box.<br/>
 * The thread with box.
 *
 * @version 2022/03/31_10:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=ThrWBox" >ThrWBox.java</a>
 *
 */
public abstract class ThrWBox<T> extends Thread {

	/**
	 * 執行緒的作用資料.<br/>
	 * The box inside for data.
	 */
	public T box;

	/**
	 * 類別被建立的時間.<br/>
	 * The start time .
	 */
	public final long tStart = System.currentTimeMillis();

	/**
	 * 監測間隔時間.<br/>
	 * The sleep duration for this thread.
	 */
	public int duration32 = 400;

}