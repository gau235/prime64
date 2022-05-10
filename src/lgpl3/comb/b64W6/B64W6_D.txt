package lgpl3.comb.b64W6;

import lgpl3.o.B;

/**
 * The first index of cell from the right hand side is 0.
 *
 * @version 2021/02/15_13:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=B64W6_D" >B64W6_D.java</a>
 *
 * @see B64W6_G
 */
public abstract class B64W6_D extends B64W6_C {

	// private static final Class<?> THIS = B64W6_D.class;

	/**
	 * To sort.<br/>
	 * The most right hand side is the smallest.<br/>
	 */
	public static long easySort(long b64W6, int totalVCell) { // 簡單粗暴: 找最大, 放到容器; 找最大, 放到容器

		// if (totalVCell == 0) return b64W6;

		long tmp;

		int max; // 1 <= max <=63
		int v32;

		long ret = 0b0L;

		do {

			max = 1; // 0b1
			tmp = b64W6;

			do
				if ((v32 = ((int) tmp & MASK32)) > max) // O.l("v=" + v + O.S9 + THIS);
					max = v32;

			while ((tmp >>>= $6) != 0b0L);

			ret = (ret << $6) | max;

			/////////////////////////////////////////////// return
			if (--totalVCell == 0)
				return ret;
			///////////////////////////////////////////////

			if (((int) b64W6 & MASK32) == max)
				b64W6 = (b64W6 & MASK32_0) | 0b00_000000_000000_000000_000000_000001; // 改成最小值 1

			else if (((int) b64W6 & MASK32_1_7TO_12) >>> 6 == max)
				b64W6 = (b64W6 & MASK32_0_7TO_12) | 0b00_000000_000000_000000_000001_000000;

			else if (((int) b64W6 & MASK32_1_13TO_18) >>> 12 == max)
				b64W6 = (b64W6 & MASK32_0_13TO_18) | 0b00_000000_000000_000001_000000_000000;

			else if (((int) b64W6 & MASK32_1_19TO_24) >>> 18 == max)
				b64W6 = (b64W6 & MASK32_0_19TO_24) | 0b00_000000_000001_000000_000000_000000;

			else if (((int) b64W6 & MASK32_1_25TO_30) >>> 24 == max)
				b64W6 = (b64W6 & MASK32_0_25TO_30) | 0b00_000001_000000_000000_000000_000000;

			else if (((int) ((b64W6 & MASK1_31TO_36) >>> 30)) == max)
				b64W6 = (b64W6 & MASK0_31TO_36) | 0b0000_000000_000000_000000_000000_000001_000000_000000_000000_000000_000000L;

			else if (((int) ((b64W6 & MASK1_37TO_42) >>> 36)) == max)
				b64W6 = (b64W6 & MASK0_37TO_42) | 0b0000_000000_000000_000000_000001_000000_000000_000000_000000_000000_000000L;

			else if (((int) ((b64W6 & MASK1_43TO_48) >>> 42)) == max)
				b64W6 = (b64W6 & MASK0_43TO_48) | 0b0000_000000_000000_000001_000000_000000_000000_000000_000000_000000_000000L;

			else if (((int) ((b64W6 & MASK1_49TO_54) >>> 48)) == max)
				b64W6 = (b64W6 & MASK0_49TO_54) | 0b0000_000000_000001_000000_000000_000000_000000_000000_000000_000000_000000L;

			else if (((int) ((b64W6 & MASK1_55TO_60) >>> 54)) == max)
				b64W6 = (b64W6 & MASK0_55TO_60) | 0b0000_000001_000000_000000_000000_000000_000000_000000_000000_000000_000000L;

		} while (B.I);

	}

	/**
	 * To sort.<br/>
	 * The most right hand side is the smallest.<br/>
	 */
	public static long easySortAftTotalVCell(long b64W6) {

		int totalVCell = totalVCell(b64W6);

		long tmp64;

		int max;
		int v;

		long ret64 = 0b0L;

		do {

			max = 1; // 0b1
			tmp64 = b64W6;

			do
				if ((v = ((int) tmp64 & MASK32)) > max) // O.l("v=" + v + O.S9 + THIS);
					max = v;

			while (((int) (tmp64 >>>= $6)) != 0b0); // b64W6 不會在兩 cell 之間有空的 cell

			ret64 = (ret64 << $6) | max;

			/////////////////////////////////////////////// return
			if (--totalVCell == 0)
				return ret64;
			///////////////////////////////////////////////

			if (((int) b64W6 & MASK32) == max)
				b64W6 = (b64W6 & MASK32_0) | 0b00_000000_000000_000000_000000_000001;

			else if (((int) b64W6 & MASK32_1_7TO_12) >>> 6 == max)
				b64W6 = (b64W6 & MASK32_0_7TO_12) | 0b00_000000_000000_000000_000001_000000;

			else if (((int) b64W6 & MASK32_1_13TO_18) >>> 12 == max)
				b64W6 = (b64W6 & MASK32_0_13TO_18) | 0b00_000000_000000_000001_000000_000000;

			else if (((int) b64W6 & MASK32_1_19TO_24) >>> 18 == max)
				b64W6 = (b64W6 & MASK32_0_19TO_24) | 0b00_000000_000001_000000_000000_000000;

			else if (((int) b64W6 & MASK32_1_25TO_30) >>> 24 == max)
				b64W6 = (b64W6 & MASK32_0_25TO_30) | 0b00_000001_000000_000000_000000_000000;

			else if (((int) ((b64W6 & MASK1_31TO_36) >>> 30)) == max)
				b64W6 = (b64W6 & MASK0_31TO_36) | 0b0000_000000_000000_000000_000000_000001_000000_000000_000000_000000_000000L;

			else if (((int) ((b64W6 & MASK1_37TO_42) >>> 36)) == max)
				b64W6 = (b64W6 & MASK0_37TO_42) | 0b0000_000000_000000_000000_000001_000000_000000_000000_000000_000000_000000L;

			else if (((int) ((b64W6 & MASK1_43TO_48) >>> 42)) == max)
				b64W6 = (b64W6 & MASK0_43TO_48) | 0b0000_000000_000000_000001_000000_000000_000000_000000_000000_000000_000000L;

			else if (((int) ((b64W6 & MASK1_49TO_54) >>> 48)) == max)
				b64W6 = (b64W6 & MASK0_49TO_54) | 0b0000_000000_000001_000000_000000_000000_000000_000000_000000_000000_000000L;

			else if (((int) ((b64W6 & MASK1_55TO_60) >>> 54)) == max)
				b64W6 = (b64W6 & MASK0_55TO_60) | 0b0000_000001_000000_000000_000000_000000_000000_000000_000000_000000_000000L;

		} while (B.I);

	}

	/**
	 * To sort in descending order.<br/>
	 * To sort in descending order.<br/>
	 */
	public static long easySortDesc(long b64W6, int totalVCell) {

		long tmp64;

		int min;
		int v;

		long ret64 = 0b0L;

		do {

			min = 63; // 0b11_1111;
			tmp64 = b64W6;

			do
				if ((v = ((int) tmp64 & MASK32)) < min)
					min = v;

			while ((tmp64 >>>= $6) != 0b0L);

			ret64 = (ret64 << $6) | min;

			/////////////////////////////////////////////// return
			if (--totalVCell == 0)
				return ret64;
			///////////////////////////////////////////////

			if (((int) b64W6 & MASK32) == min)
				b64W6 |= MASK32; // 原本 min 處 改 63 最大

			else if (((int) b64W6 & MASK32_1_7TO_12) >>> 6 == min)
				b64W6 |= MASK32_1_7TO_12;

			else if (((int) b64W6 & MASK32_1_13TO_18) >>> 12 == min)
				b64W6 |= MASK32_1_13TO_18;

			else if (((int) b64W6 & MASK32_1_19TO_24) >>> 18 == min)
				b64W6 |= MASK32_1_19TO_24;

			else if (((int) b64W6 & MASK32_1_25TO_30) >>> 24 == min)
				b64W6 |= MASK32_1_25TO_30;

			else if (((int) ((b64W6 & MASK1_31TO_36) >>> 30)) == min)
				b64W6 |= MASK1_31TO_36;

			else if (((int) ((b64W6 & MASK1_37TO_42) >>> 36)) == min)
				b64W6 |= MASK1_37TO_42;

			else if (((int) ((b64W6 & MASK1_43TO_48) >>> 42)) == min)
				b64W6 |= MASK1_43TO_48;

			else if (((int) ((b64W6 & MASK1_49TO_54) >>> 48)) == min)
				b64W6 |= MASK1_49TO_54;

			else if (((int) ((b64W6 & MASK1_55TO_60) >>> 54)) == min)
				b64W6 |= MASK1_55TO_60;

		} while (B.I);

	}
}
