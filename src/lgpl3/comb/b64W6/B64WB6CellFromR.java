package lgpl3.comb.b64W6;

/**
 * To make a 64-bit long divide into every 6-bit cell.<br/>
 * The first index of cell from the right hand side is 0.
 *
 * @version 2020/12/31_11:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=B64WB6CellFromR" >B64WB6CellFromR.java</a>
 *
 * @see B64W6_A
 */
public abstract class B64WB6CellFromR {

	// private static final Class<?> THIS = B64WB6CellFromR.class;

	/**
	 * 6 bits per cell.<br/>
	 * 6 bits per cell.
	 */
	public static final int $NUM_OF_BIT_PER_CELL = 6;

	/**
	 * 6 bits per cell.<br/>
	 * 6 bits per cell.
	 */
	public static final int $6 = $NUM_OF_BIT_PER_CELL;

	/**
	 * 6 bits per cell.<br/>
	 * 6 bits per cell.
	 */
	public static final int $TOTAL_CELL = 10;

	/**
	 * max value per cell.<br/>
	 * max value per cell.
	 */
	public static final int $MAX_INT32_IN_CELL = 63;

	/**
	 * 0b0000_000000_000000_000000_000000_000000_000000_000000_000000_000000_111111L<br/>
	 */
	public static final long MASK1_1TO_6 = 0b0000_000000_000000_000000_000000_000000_000000_000000_000000_000000_111111L;

	/**
	 * 0b0000_000000_000000_000000_000000_000000_000000_000000_000000_111111_000000L<br/>
	 */
	public static final long MASK1_7TO_12 = 0b0000_000000_000000_000000_000000_000000_000000_000000_000000_111111_000000L;

	/**
	 * 0b0000_000000_000000_000000_000000_000000_000000_000000_111111_000000_000000L<br/>
	 */
	public static final long MASK1_13TO_18 = 0b0000_000000_000000_000000_000000_000000_000000_000000_111111_000000_000000L;

	/**
	 * 0b0000_000000_000000_000000_000000_000000_000000_111111_000000_000000_000000L<br/>
	 */
	public static final long MASK1_19TO_24 = 0b0000_000000_000000_000000_000000_000000_000000_111111_000000_000000_000000L;

	/**
	 * 0b0000_000000_000000_000000_000000_000000_111111_000000_000000_000000_000000L<br/>
	 */
	public static final long MASK1_25TO_30 = 0b0000_000000_000000_000000_000000_000000_111111_000000_000000_000000_000000L;

	/**
	 * 0b0000_000000_000000_000000_000000_111111_000000_000000_000000_000000_000000L<br/>
	 */
	public static final long MASK1_31TO_36 = 0b0000_000000_000000_000000_000000_111111_000000_000000_000000_000000_000000L;

	/**
	 * 0b0000_000000_000000_000000_111111_000000_000000_000000_000000_000000_000000L<br/>
	 */
	public static final long MASK1_37TO_42 = 0b0000_000000_000000_000000_111111_000000_000000_000000_000000_000000_000000L;

	/**
	 * 0b0000_000000_000000_111111_000000_000000_000000_000000_000000_000000_000000L<br/>
	 */
	public static final long MASK1_43TO_48 = 0b0000_000000_000000_111111_000000_000000_000000_000000_000000_000000_000000L;

	/**
	 * 0b0000_000000_111111_000000_000000_000000_000000_000000_000000_000000_000000L<br/>
	 */
	public static final long MASK1_49TO_54 = 0b0000_000000_111111_000000_000000_000000_000000_000000_000000_000000_000000L;

	/**
	 * 0b0000_111111_000000_000000_000000_000000_000000_000000_000000_000000_000000L<br/>
	 */
	public static final long MASK1_55TO_60 = 0b0000_111111_000000_000000_000000_000000_000000_000000_000000_000000_000000L;

	/**
	 * 0b1111_111111_000000_000000_000000_000000_000000_000000_000000_000000_000000L<br/>
	 */
	public static final long MASK1_55TO_64 = 0b1111_111111_000000_000000_000000_000000_000000_000000_000000_000000_000000L;

	/**
	 * 0b111111<br/>
	 * 0b111111
	 */
	public static final int MASK32 = 0b111111;

	/**
	 * 0b00_000000_000000_000000_111111_000000<br/>
	 * 0b00_000000_000000_000000_111111_000000
	 */
	public static final int MASK32_1_7TO_12 = 0b00_000000_000000_000000_111111_000000;

	/**
	 * 0b00_000000_000000_111111_000000_000000<br/>
	 * 0b00_000000_000000_111111_000000_000000
	 */
	public static final int MASK32_1_13TO_18 = 0b00_000000_000000_111111_000000_000000;

	/**
	 * 0b00_000000_111111_000000_000000_000000<br/>
	 * 0b00_000000_111111_000000_000000_000000
	 */
	public static final int MASK32_1_19TO_24 = 0b00_000000_111111_000000_000000_000000;

	/**
	 * 0b00_111111_000000_000000_000000_000000<br/>
	 * 0b00_111111_000000_000000_000000_000000
	 */
	public static final int MASK32_1_25TO_30 = 0b00_111111_000000_000000_000000_000000;

	//////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 0b1111_111111_111111_111111_111111_111111_111111_111111_111111_111111_000000L<br/>
	 */
	public static final long MASK0_1TO_6 = 0b1111_111111_111111_111111_111111_111111_111111_111111_111111_111111_000000L;

	/**
	 * 0b1111_111111_111111_111111_111111_111111_111111_111111_111111_000000_111111L<br/>
	 */
	public static final long MASK0_7TO_12 = 0b1111_111111_111111_111111_111111_111111_111111_111111_111111_000000_111111L;

	/**
	 * 0b1111_111111_111111_111111_111111_111111_111111_111111_000000_111111_111111L<br/>
	 */
	public static final long MASK0_13TO_18 = 0b1111_111111_111111_111111_111111_111111_111111_111111_000000_111111_111111L;

	/**
	 * 0b1111_111111_111111_111111_111111_111111_111111_000000_111111_111111_111111L<br/>
	 */
	public static final long MASK0_19TO_24 = 0b1111_111111_111111_111111_111111_111111_111111_000000_111111_111111_111111L;

	/**
	 * 0b1111_111111_111111_111111_111111_111111_000000_111111_111111_111111_111111L<br/>
	 */
	public static final long MASK0_25TO_30 = 0b1111_111111_111111_111111_111111_111111_000000_111111_111111_111111_111111L;

	/**
	 * 0b1111_111111_111111_111111_111111_000000_111111_111111_111111_111111_111111L<br/>
	 */
	public static final long MASK0_31TO_36 = 0b1111_111111_111111_111111_111111_000000_111111_111111_111111_111111_111111L;

	/**
	 * 0b1111_111111_111111_111111_000000_111111_111111_111111_111111_111111_111111L<br/>
	 */
	public static final long MASK0_37TO_42 = 0b1111_111111_111111_111111_000000_111111_111111_111111_111111_111111_111111L;

	/**
	 * 0b1111_111111_111111_000000_111111_111111_111111_111111_111111_111111_111111L<br/>
	 */
	public static final long MASK0_43TO_48 = 0b1111_111111_111111_000000_111111_111111_111111_111111_111111_111111_111111L;

	/**
	 * 0b1111_111111_000000_111111_111111_111111_111111_111111_111111_111111_111111L<br/>
	 */
	public static final long MASK0_49TO_54 = 0b1111_111111_000000_111111_111111_111111_111111_111111_111111_111111_111111L;

	/**
	 * 0b1111_000000_111111_111111_111111_111111_111111_111111_111111_111111_111111L<br/>
	 */
	public static final long MASK0_55TO_60 = 0b1111_000000_111111_111111_111111_111111_111111_111111_111111_111111_111111L;

	/**
	 * 0b0000_000000_111111_111111_111111_111111_111111_111111_111111_111111_111111L<br/>
	 */
	public static final long MASK0_55TO_64 = 0b0000_000000_111111_111111_111111_111111_111111_111111_111111_111111_111111L;

	/**
	 * 0b11_111111_111111_111111_111111_000000<br/>
	 * 0b11_111111_111111_111111_111111_000000
	 */
	public static final int MASK32_0 = ~MASK32;

	/**
	 * 0b11_111111_111111_111111_000000_111111<br/>
	 * 0b11_111111_111111_111111_000000_111111
	 */
	public static final int MASK32_0_7TO_12 = ~MASK32_1_7TO_12;

	/**
	 * 0b11_111111_111111_000000_111111_111111<br/>
	 * 0b11_111111_111111_000000_111111_111111
	 */
	public static final int MASK32_0_13TO_18 = ~MASK32_1_13TO_18;

	/**
	 * 0b11_111111_000000_111111_111111_111111<br/>
	 * 0b11_111111_000000_111111_111111_111111
	 */
	public static final int MASK32_0_19TO_24 = ~MASK32_1_19TO_24;

	/**
	 * 0b11_000000_111111_111111_111111_111111<br/>
	 * 0b11_000000_111111_111111_111111_111111
	 */
	public static final int MASK32_0_25TO_30 = ~MASK32_1_25TO_30;

}
