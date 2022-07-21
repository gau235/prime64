package lgpl3.recycle;

import java.io.Serializable;

import lgpl3.o.B;

/**
 * @version 2021/02/22_06:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=NodInLinkedList32" >NodInLinkedList32.java</a>
 *
 * @see LinkedList32
 */
public class NodInLinkedList32 implements Serializable {

	private static final Class<?> THIS = NodInLinkedList32.class;

	private static final long serialVersionUID = B.genId32(THIS);

	public int val;

	public NodInLinkedList32 next;

	public NodInLinkedList32(int val) {

		this.val = val;
	}

	public StringBuilder toStr() {

		return new StringBuilder().append(val);
	}

}
