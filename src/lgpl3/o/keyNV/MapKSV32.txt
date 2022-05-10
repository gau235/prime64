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
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=MapKSV32" >MapKSV32.java</a>
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

		if (iLen == 0) {

			if (iLen == fixedLen)
				extLen();

			arr[iLen++] = tmpKSV32;

		} else {

			KSV32 tailKSV32 = arr[iLen - 1];

			if (tmpKSV32.s.equals(tailKSV32.s))

				tailKSV32.int32++;
			else {

				if (iLen == fixedLen)
					extLen();

				arr[iLen++] = tmpKSV32;

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

		final String[] retSAry = new String[iLen];

		for (int idx = 0; idx != iLen; idx++)
			retSAry[idx] = arr[idx].s;

		return retSAry;

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	@Override
	public StringBuilder toStr() {

		StringBuilder str = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		for (int idx = 0; idx != iLen;) {

			str.append(arr[idx].toStr());

			if (++idx != iLen)
				str.append(O.C_A_L);

		}

		return str;

	}

	/**
	 * To StringBuilder.<br/>
	 * To StringBuilder.
	 */
	public StringBuilder toStr(CharSequence prefix, CharSequence lineWr) {

		StringBuilder str = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		KSV32 kSV32;
		for (int idx = 0; idx != iLen;) {

			kSV32 = arr[idx];
			str.append(idx + 1).append(prefix).append(kSV32.s).append(O.C61).append(kSV32.int32);

			if (++idx != iLen) // todo: if (i++ != Strva.int32MaxRowForHtml)
				str.append(lineWr);

		}

		return str;

	}
}
