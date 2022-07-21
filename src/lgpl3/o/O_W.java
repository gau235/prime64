package lgpl3.o;

import static java.lang.System.out;

/**
 * @version 2022/04/23_20:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=O_W" >O_W.java</a>
 *
 * @see O
 */
public abstract class O_W extends O_V {

	/**
	 * The max size of the arrays.<br/>
	 * The max size of the arrays.
	 */
	public static final int $MAX_LEN_OF_ARY = 2_147_483_645;

	/**
	 * The runtime object.
	 */
	public static final Runtime RUN_TIME = Runtime.getRuntime();

	/**
	 * The number of CPU threads.<br/>
	 * The number of CPU threads.
	 */
	public static final int $NUM_OF_CPU_THR = RUN_TIME.availableProcessors();

	/**
	 * The max number of CPU threads.<br/>
	 * The max number of CPU threads.
	 */
	public static final int $MAX_NUM_OF_CPU_THR = 128;

	/**
	 * To return the all amount of memory in mega bytes.<br/>
	 * To return the all amount of memory in mega bytes.
	 */
	public static int $XMX = (int) (RUN_TIME.maxMemory() >> 20);

	/**
	 * 記憶體是慢慢的從作業系統那裡挖的，基本上用多少挖多少，挖到 maxMemory() 為止，所以 totalMemory() 是慢慢增大的。<br/>
	 * 如果用了-Xms引數，程式在啟動的時候就會無條件的從作業系統中挖 -Xms<br/>
	 * To return the dirtied amount of memory in mega bytes.
	 */
	public static int totalMem() {

		return (int) (RUN_TIME.totalMemory() >> 20);
	}

	/**
	 * To return the free amount of memory in mega bytes.<br/>
	 * To return the free amount of memory in mega bytes.
	 */
	public static int freeMem() {

		return (int) (RUN_TIME.freeMemory() >> 20);
	}

	/**
	 * To return the free amount of memory in mega bytes.<br/>
	 * To return the free amount of memory in mega bytes.
	 */
	public static int curUsingMem() {

		long tmp = ((RUN_TIME.totalMemory() - RUN_TIME.freeMemory()) >> 20);

		return (int) ((tmp >>> 3) << 3);
	}

	/**
	 * Is high amount of memory?<br/>
	 * Is high amount of memory?
	 */
	public static final boolean IS_HIGH_XMX = ($XMX >= 5);

	/**
	 * To run the garbage collector.
	 */
	public static Runtime gc(Class<?> calledByWhichClass) {

		out.println(new StringBuilder(defLenForStr).append("gc @").append(calledByWhichClass.getSimpleName()));

		RUN_TIME.gc();

		return RUN_TIME;
	}

}
