package lgpl3.o.str;

import java.io.Serializable;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * 本類別字串包覆者.<br/>
 * The wrapper for string.
 *
 * @version 2022/04/07_09:50:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=SW" >SW.java</a>
 *
 */
public class SW implements Serializable {

	private static final Class<?> THIS = SW.class;

	private static final long serialVersionUID = B.genId32(THIS);

	/**
	 * 換行符號.<br/>
	 * The line separator.
	 */
	public CharSequence lineWr = O.L;

	/**
	 * 內建的字串建立者.<br/>
	 * The inside StringBuilder.
	 */
	public StringBuilder str = new StringBuilder(O.defLenForStr);

	/**
	 * 串接文字.<br/>
	 * To append.
	 */
	public SW a(boolean b) {

		str.append(b);

		return this;

	}

	/**
	 * 串接文字.<br/>
	 * To append.
	 */
	public SW a(int int32) {

		str.append(int32);

		return this;

	}

	/**
	 * 串接文字.<br/>
	 * To append.
	 */
	public SW a(long int64) {

		str.append(int64);

		return this;

	}

	/**
	 * 串接文字.<br/>
	 * To append.
	 */
	public SW a(float f32) {

		str.append(f32);

		return this;

	}

	/**
	 * 串接文字.<br/>
	 * To append.
	 */
	public SW a(double f64) {

		str.append(f64);

		return this;

	}

	/**
	 * 串接文字.<br/>
	 * To append.
	 */
	public SW a(char c) {

		str.append(c);

		return this;

	}

	/**
	 * 串接文字.<br/>
	 * To append.
	 */
	public SW a(char[] charAry) {

		str.append(charAry);

		return this;

	}

	/**
	 * 串接文字.<br/>
	 * To append.
	 */
	public SW a(CharSequence charSeq) {

		str.append(charSeq);

		return this;

	}

	/**
	 * 串接文字.<br/>
	 * To append.
	 */
	public SW l(boolean b) {

		str.append(b).append(lineWr);

		return this;

	}

	/**
	 * 串接文字.<br/>
	 * To append.
	 */
	public SW l(int int32) {

		str.append(int32).append(lineWr);

		return this;

	}

	/**
	 * 串接文字.<br/>
	 * To append.
	 */
	public SW l(long int64) {

		str.append(int64).append(lineWr);

		return this;

	}

	/**
	 * 串接文字.<br/>
	 * To append.
	 */
	public SW l(float f32) {

		str.append(f32).append(lineWr);

		return this;

	}

	/**
	 * 串接文字.<br/>
	 * To append.
	 */
	public SW l(double f64) {

		str.append(f64).append(lineWr);

		return this;

	}

	/**
	 * 串接文字.<br/>
	 * To append.
	 */
	public SW l(char c) {

		str.append(c).append(lineWr);

		return this;

	}

	/**
	 * 串接文字.<br/>
	 * To append.
	 */
	public SW l(char[] charAry) {

		str.append(charAry).append(lineWr);

		return this;

	}

	/**
	 * 串接文字.<br/>
	 * To append.
	 */
	public SW l(CharSequence charSeq) {

		str.append(charSeq).append(lineWr);

		return this;

	}

	/**
	 * 串接文字.<br/>
	 * To append.
	 */
	public SW l() {

		str.append(lineWr);

		return this;

	}

	@Override
	public SW clone() {

		SW newSW = new SW();

		newSW.str = new StringBuilder(str);

		return newSW;

	}

	/**
	 * To clone then append.<br/>
	 * To clone then append.
	 */
	public SW cNA(boolean b) {

		SW newSW = new SW();

		newSW.str = new StringBuilder(str).append(b);

		return newSW;

	}

	/**
	 * To clone then append.<br/>
	 * To clone then append.
	 */
	public SW cNA(int int32) {

		SW newSW = new SW();

		newSW.str = new StringBuilder(str).append(int32);

		return newSW;

	}

	/**
	 * To clone then append.<br/>
	 * To clone then append.
	 */
	public SW cNA(long int64) {

		SW newSW = new SW();

		newSW.str = new StringBuilder(str).append(int64);

		return newSW;

	}

	/**
	 * To clone then append.<br/>
	 * To clone then append.
	 */
	public SW cNA(float f32) {

		SW newSW = new SW();

		newSW.str = new StringBuilder(str).append(f32);

		return newSW;

	}

	/**
	 * To clone then append.<br/>
	 * To clone then append.
	 */
	public SW cNA(double f64) {

		SW newSW = new SW();

		newSW.str = new StringBuilder(str).append(f64);

		return newSW;

	}

	/**
	 * To clone then append.<br/>
	 * To clone then append.
	 */
	public SW cNA(char c) {

		SW newSW = new SW();

		newSW.str = new StringBuilder(str).append(c);

		return newSW;

	}

	/**
	 * To clone then append.<br/>
	 * To clone then append.
	 */
	public SW cNA(char[] charAry) {

		SW newSW = new SW();

		newSW.str = new StringBuilder(str).append(charAry);

		return newSW;

	}

	/**
	 * To clone then append.<br/>
	 * To clone then append.
	 */
	public SW cNA(CharSequence charSeq) {

		SW newSW = new SW();

		newSW.str = new StringBuilder(str).append(charSeq);

		return newSW;

	}
}