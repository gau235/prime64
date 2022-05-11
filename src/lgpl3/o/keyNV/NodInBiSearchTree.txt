package lgpl3.o.keyNV;

import java.io.Serializable;

import lgpl3.o.B;

/**
 * @version 2020/02/29_09:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=NodInBiSearchTree" >NodInBiSearchTree.java</a>
 *
 * @see BiSearchTree
 */
public class NodInBiSearchTree implements Serializable {

	private static final Class<?> THIS = NodInBiSearchTree.class;

	private static final long serialVersionUID = B.genId32(THIS);

	public long val;

	public NodInBiSearchTree left;

	public NodInBiSearchTree right;

	public NodInBiSearchTree(long val) {

		this.val = val;
	}
}
