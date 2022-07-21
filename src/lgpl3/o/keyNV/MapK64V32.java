package lgpl3.o.keyNV;

import java.io.Serializable;

import lgpl3.o.B;
import lgpl3.o.O;
import lgpl3.o.ary.Arr;

/**
 * 問題在資料結構.<br/>
 * 因為資料結構不好, 才會想一直抓住它, 丟也丟不掉 若資料結構好, 心中的大石頭就放下了.
 *
 * @version 2020/02/18_17:30:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=MapK64V32" >MapK64V32.java</a>
 *
 * @see MapK64V32
 *
 * @see MapKSV32
 */
public class MapK64V32 extends Arr<K64V32> implements Serializable {

	private static final Class<?> THIS = MapK64V32.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * 建構方法.<br/>
	 * Constructor.
	 */
	public MapK64V32() {

		super(K64V32.class);
	}

	/**
	 * To put and count.<br/>
	 * To put and count.
	 */
	public void easyPutNCount(long b64) {

		K64V32 tmpK64V32 = new K64V32(b64, 1); // count, start with 1
		// O.l("easyPutNCount=" + B64W6.toStrByVCell(b64), THIS);

		if (i == 0) {

			if (i == fixedLen)
				extLen();

			arr[i++] = tmpK64V32;

		} else {

			K64V32 tailK64V32 = arr[i - 1];

			if (tmpK64V32.k == tailK64V32.k)

				tailK64V32.v++;
			else {

				if (i == fixedLen)
					extLen();

				arr[i++] = tmpK64V32;

			}
		}
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

		K64V32 tmpK64V32;
		for (int idx = 0; idx != i;) {

			tmpK64V32 = arr[idx];
			str.append(idx + 1).append(prefix).append(tmpK64V32.k).append(O.C94).append(tmpK64V32.v);

			if (++idx != i) { // todo: if (i++ != Strva.int32MaxRowForHtml)

				str.append(lineWr);
			}
		}

		return str;

	}
}
