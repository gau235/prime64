package lgpl3.o.keyNV;

import java.io.Serializable;

import lgpl3.o.B;

/**
 * @version 2020/05/27_15:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=NodInBiSearchTree32" >NodInBiSearchTree32.java</a>
 *
 * @see BiSearchTree32
 */
public class NodInBiSearchTree32 implements Serializable {

	private static final Class<?> THIS = NodInBiSearchTree32.class;

	private static final long serialVersionUID = B.genId32(THIS);

	public int val;

	public NodInBiSearchTree32 left;

	public NodInBiSearchTree32 right;

	public NodInBiSearchTree32(int val) {

		this.val = val;
	}
}
