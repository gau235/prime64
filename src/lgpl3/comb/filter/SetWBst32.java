package lgpl3.comb.filter;

import java.io.Serializable;

import lgpl3.comb.b64WVCell.B64W6;
import lgpl3.o.B;
import lgpl3.o.keyNV.BiSearchTree32;

/**
 * The set to filter.<br/>
 * The set to filter.
 *
 * @version 2021/03/30_14:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=SetWBst32" >SetWBst32.java</a>
 *
 * @see IdxSet32
 */
public class SetWBst32 implements Serializable {

	private static final Class<?> THIS = SetWBst32.class;

	private static final long serialVersionUID = B.genId32(THIS);

	public static final int $6 = B64W6.$6;

	/**
	 * 0b111111<br/>
	 * 0b111111
	 */
	public static final int MASK32 = 0b111111;

	public final int n;

	public final int nPow2;

	public final int nPow3;

	public final BiSearchTree32[] aryOfBst32;

	public int i1;

	public int i2;

	public int i3;

	public int i4;

	public int hit1 = -1; // fuck; first to be del

	public int hit2 = -1; // fuck; sec to be del

	public int hit3 = -1; // fuck; sec to be del

	public BiSearchTree32 hit1Obj; // first to be del

	public BiSearchTree32 hit2Obj; // sec to be del

	public BiSearchTree32 hit3Obj; // sec to be del

	public BiSearchTree32 tmpObj;

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public SetWBst32(int n) {

		this.n = n;
		this.nPow2 = n * n;
		this.nPow3 = nPow2 * n;

		aryOfBst32 = new BiSearchTree32[((n - 1) * nPow3) + ((n - 1) * nPow2) + ((n - 1) * n) + ((n - 1) - 1) + 1]; // 降維的觀念

		// O.l("aryOfBst32.len=" + aryOfBst32.length , THIS);

	}

	/**
	 * To add.<br/>
	 * To add.
	 */
	public boolean addIfNotFound(long b64W6) {

		i1 = ((int) b64W6) & MASK32;
		b64W6 >>>= $6;

		i2 = ((int) b64W6) & MASK32;
		b64W6 >>>= $6;

		i3 = ((int) b64W6) & MASK32;
		b64W6 >>>= $6;

		i4 = ((int) b64W6) & MASK32;
		b64W6 >>>= $6;

		i1 = nPow3 * (i1 - 1) + nPow2 * (i2 - 1) + n * (i3 - 1) + (i4 - 1);

		if (i1 == hit1) { // hit 被打中, 向後移

			hit1 = hit2;
			hit2 = hit3;
			hit3 = i1; // replace old, first to be del

			tmpObj = hit1Obj;

			hit1Obj = hit2Obj;
			hit2Obj = hit3Obj;
			hit3Obj = tmpObj; // replace old, first to be del

			return hit3Obj.addIfNotFound((int) b64W6);

		}

		if (i1 == hit2) { // hit 被打中, 向後移

			hit2 = hit3;
			hit3 = i1; // replace old, first to be del

			tmpObj = hit2Obj;

			hit2Obj = hit3Obj;
			hit3Obj = tmpObj; // replace old, first to be del

			return hit3Obj.addIfNotFound((int) b64W6);

		}

		if (i1 == hit3) { // hit

			return hit3Obj.addIfNotFound((int) b64W6);
		}

		// not hit then check null

		if (hit1 == -1) {

			// if (hit2Obj == null) { // 1 null 2 null

			hit1 = i1;

			hit1Obj = new BiSearchTree32();
			hit1Obj.add((int) b64W6);

			aryOfBst32[i1] = hit1Obj;

			return B.I;

		}

		if (hit2 == -1) { // 1 not null and 2 null

			hit2 = i1; // to fill the empty space

			hit2Obj = new BiSearchTree32();
			hit2Obj.add((int) b64W6);

			aryOfBst32[i1] = hit2Obj;

			return B.I;

		}

		if (hit3 == -1) { // 1 not null and 2 null

			hit3 = i1; // to fill the empty space

			hit3Obj = new BiSearchTree32();
			hit3Obj.add((int) b64W6);

			aryOfBst32[i1] = hit3Obj;

			return B.I;

		}

		// not hit then 1 not null and 2 not null and 3 not null

		hit1 = hit2;
		hit2 = hit3;
		hit3 = i1; // replace old, first to be del

		hit1Obj = hit2Obj; // replace old, first to be del
		hit2Obj = hit3Obj;

		if ((tmpObj = aryOfBst32[i1]) == null) {

			aryOfBst32[i1] = hit3Obj = new BiSearchTree32();

		} else {

			hit3Obj = tmpObj;
		}

		return hit3Obj.addIfNotFound((int) b64W6);

	}
}
