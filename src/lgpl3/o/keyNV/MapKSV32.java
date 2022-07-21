package lgpl3.o.keyNV;

import java.io.Serializable;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Arr;

/**
 * 問題在資料結構.<br/>
 * 因為資料結構不好, 才會想一直抓住它, 丟也丟不掉 若資料結構好, 心中的大石頭就放下了.<br/>
 *
 * @version 2020/02/23_21:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=MapKSV32" >MapKSV32.java</a>
 *
 * @see MapK64V32
 *
 * @see MapKSV32
 */
public class MapKSV32 extends Arr<KSV32> implements Serializable {

	private static final Class<?> THIS = MapKSV32.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * To put and count.<br/>
	 * To put and count.
	 */
	public void easyPutNCount(String s) {

		KSV32 tmpKSV32 = new KSV32(s, 1); // count, start with 1

		if (i == 0) {

			if (i == fixedLen)
				extLen();

			arr[i++] = tmpKSV32;

		} else {

			KSV32 tailKSV32 = arr[i - 1];

			if (tmpKSV32.k.equals(tailKSV32.k))

				tailKSV32.v++;
			else {

				if (i == fixedLen)
					extLen();

				arr[i++] = tmpKSV32;

			}
		}
	}

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public MapKSV32(String[] sortedSAry) {

		super(KSV32.class); // fuck

		for (int idx = 0; idx != sortedSAry.length; idx++)
			easyPutNCount(sortedSAry[idx]);

	}

	/**
	 * To array of distinct items.<br/>
	 * To array of distinct items.
	 */
	public String[] allKey() {

		final String[] retSAry = new String[i];

		for (int idx = 0; idx != i; idx++)
			retSAry[idx] = arr[idx].k;

		return retSAry;

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	@Override
	public StringBuilder toStr() {

		StringBuilder str = new StringBuilder(O.defLenForStr);

		for (int idx = 0; idx != i;) {

			str.append(arr[idx].toStr());

			if (++idx != i)
				str.append(O.C_A_L);

		}

		return str;

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public StringBuilder toStr(CharSequence prefix, CharSequence lineWr) {

		StringBuilder str = new StringBuilder(O.defLenForStr);

		KSV32 kSV32;
		for (int idx = 0; idx != i;) {

			kSV32 = arr[idx];
			str.append(idx + 1).append(prefix).append(kSV32.k).append(O.C61).append(kSV32.v);

			if (++idx != i) // todo: if (i++ != Strva.int32MaxRowForHtml)
				str.append(lineWr);

		}

		return str;

	}
}
