package lgpl3.comb.powerSet.thr;

import lgpl3.comb.powerSet.PowerSet;
import lgpl3.o.thr.ThrWBox;

/**
 * To give change.<br/>
 * To give change.
 *
 * @version 2022/01/28_20:00:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=ThrGiveChange" >ThrGiveChange.java</a>
 *
 */
public class ThrGiveChange extends ThrWBox<long[]> {

	// private static final Class<?> THIS = ThrGiveChange.class;

	public int[] baseAry32;

	public int targetV32;

	/**
	 * 建構方法.<br/>
	 * baseAry32 array must be descend.<br/>
	 * baseAry32 array can not contain 0 or negative element.
	 */
	public ThrGiveChange(int[] baseAry32, int targetV, boolean isToRun) {

		this.baseAry32 = baseAry32;
		this.targetV32 = targetV;

		if (isToRun)

			run();

	}

	@Override
	public void run() {

		box = PowerSet.colAllMatchV(baseAry32, targetV32);
	}
}