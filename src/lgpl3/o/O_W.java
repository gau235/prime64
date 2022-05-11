package lgpl3.o;

/**
 * @version 2022/04/23_20:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=O_W" >O_W.java</a>
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
	 * The runtime object.<br/>
	 * The runtime object.
	 */
	public static final Runtime RUNTIME = Runtime.getRuntime();

	/**
	 * The number of CPU threads.<br/>
	 * The number of CPU threads.
	 */
	public static final int $NUM_OF_CPU_THR = RUNTIME.availableProcessors();

	/**
	 * The max number of CPU threads.<br/>
	 * The max number of CPU threads.
	 */
	public static final int $MAX_NUM_OF_CPU_THR = 128;

	/**
	 * 列出系統核心數, 由多到少遞減.<br/>
	 * To int[] of number of processor threads in descending order.
	 */
	public static int[] genMyAry32OfCpuThr() {

		int totalElem = 10, numOfThr = (($NUM_OF_CPU_THR > $MAX_NUM_OF_CPU_THR) ? $MAX_NUM_OF_CPU_THR : $NUM_OF_CPU_THR);

		int stepAkaGap = (numOfThr / totalElem + 1), idx = 0;

		// numOfThr = 192;

		int[] retAry32 = new int[totalElem];

		while ((numOfThr -= stepAkaGap) > 0)

			retAry32[idx++] = numOfThr;

		if (retAry32[idx - 1] != 1)

			retAry32[idx] = 1;

		/////////////////////////////////////// delTailAll0

		idx = totalElem;

		while (idx-- != 0)

			if (retAry32[idx] != 0)

				break;

		if (++idx != totalElem) // 縮短陣列情況下可用這個

			System.arraycopy(retAry32, 0, (retAry32 = new int[idx]), 0, idx);

		/////////////////////////////////////// delTailAll0

		return retAry32;

	}

	/**
	 * 列出系統核心數, 由多到少遞減.<br/>
	 * To int[] of number of processor threads in descending order.
	 */
	public static final int[] MY_ARY32_OF_CPU_THR = genMyAry32OfCpuThr();

	/**
	 * To return the all amount of memory in mega bytes.<br/>
	 * To return the all amount of memory in mega bytes.
	 */
	public static int $XMX = (int) (RUNTIME.maxMemory() >> 20);

	/**
	 * 記憶體是慢慢的從作業系統那裡挖的，基本上用多少挖多少，挖到 maxMemory() 為止，所以 totalMemory() 是慢慢增大的。<br/>
	 * 如果用了-Xms引數，程式在啟動的時候就會無條件的從作業系統中挖 -Xms<br/>
	 * To return the dirtied amount of memory in mega bytes.
	 */
	public static int totalMem() {

		return (int) (RUNTIME.totalMemory() >> 20);
	}

	/**
	 * To return the free amount of memory in mega bytes.<br/>
	 * To return the free amount of memory in mega bytes.
	 */
	public static int freeMem() {

		return (int) (RUNTIME.freeMemory() >> 20);
	}

	/**
	 * To return the free amount of memory in mega bytes.<br/>
	 * To return the free amount of memory in mega bytes.
	 */
	public static int curUsingMem() {

		long tmp = ((RUNTIME.totalMemory() - RUNTIME.freeMemory()) >> 20);

		return (int) ((tmp >>> 3) << 3);
	}

	/**
	 * Is high amount of memory?<br/>
	 * Is high amount of memory?
	 */
	public static final boolean IS_HIGH_XMX = ($XMX >= 5);

}
