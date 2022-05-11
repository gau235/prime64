package lgpl3.o.keyNV;

import java.io.Serializable;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * @version 2020/08/23_11:20:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=BiSearchTree" >BiSearchTree.java</a>
 *
 * @see NodInBiSearchTree
 */
public class BiSearchTree implements Serializable {

	private static final Class<?> THIS = BiSearchTree.class;

	private static final long serialVersionUID = B.genId32(THIS);

	public NodInBiSearchTree root;

	public NodInBiSearchTree notNullNod;

	public static StringBuilder tmpStr;

	public void add(long int32) {

		if (root == null) {

			root = new NodInBiSearchTree(int32);
			return;

		}

		NodInBiSearchTree tmp = root;

		do {

			notNullNod = tmp;

			if (int32 > tmp.val) {

				tmp = tmp.right;

			} else {

				tmp = tmp.left;
			}

		} while (tmp != null);

		if (int32 > notNullNod.val) {

			notNullNod.right = new NodInBiSearchTree(int32);

		} else {

			notNullNod.left = new NodInBiSearchTree(int32);
		}

	}

	public boolean ifContain(long int64) {

		notNullNod = root;
		while (notNullNod != null) {

			if (int64 > notNullNod.val) {

				notNullNod = notNullNod.right;
				continue;

			}

			if (int64 < notNullNod.val) {

				notNullNod = notNullNod.left;
				continue;

			}

			return B.I;

		}

		return B.O;

	}

	/**
	 * If the value is absent then to insert.<br/>
	 * If the value is absent then to insert.
	 */
	public boolean addIfNotFound(long int64) {

		if (root == null) {

			root = new NodInBiSearchTree(int64);
			return B.I;

		}

		NodInBiSearchTree tmp = root;

		do {

			notNullNod = tmp;

			if (int64 > tmp.val) {

				tmp = tmp.right;
				continue;

			}

			if (int64 < tmp.val) {

				tmp = tmp.left;
				continue;

			}

			return B.O;

		} while (tmp != null);

		if (int64 > notNullNod.val) {

			notNullNod.right = new NodInBiSearchTree(int64);

		} else {

			notNullNod.left = new NodInBiSearchTree(int64);
		}

		return B.I;

	}

	public void toStrInorder(NodInBiSearchTree root) {

		if (root == null) {

			return;
		}

		toStrInorder(root.left);
		tmpStr.append(root.val).append(O.C_A_L);
		// O.l(root.val);

		toStrInorder(root.right);

	}

	public StringBuilder toStrInorder() {

		tmpStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		toStrInorder(root);

		StringBuilder reStr = tmpStr;

		tmpStr = null;

		return reStr;

	}

	public void toStrPreorder(NodInBiSearchTree root) {

		if (root == null) {

			return;
		}

		tmpStr.append(root.val).append(O.C_A_L);
		// O.l(root.val);

		toStrPreorder(root.left);
		toStrPreorder(root.right);

	}

	public StringBuilder toStrPreorder() {

		tmpStr = new StringBuilder(O.DEF_CAPACITY32_FOR_STR);

		toStrPreorder(root);

		StringBuilder reStr = tmpStr;

		tmpStr = null;

		return reStr;

	}
}
