package lgpl3.other.uI;

import java.io.Serializable;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * The record.<br/>
 * The record.
 *
 * @version 2021/09/06_09:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Recva" >Recva.java</a>
 */
public class Recva implements Serializable {

	private static final long serialVersionUID = B.genId32(Recva.class);

	public long n1;

	public long n2;

	public int numOfThr;

	public long totalP;

	public float f32TimeCost;

	public CharSequence note = new StringBuilder(O.defLenForStr);

	public Object tmpObj = new StringBuilder(O.defLenForStr);

}