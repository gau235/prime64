package lgpl3.o.keyNV;

import java.io.Serializable;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * @version 2021/03/30_09:40:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/searchDocOfSrc.jsp?nameOfClass=BiSearchTree32" >BiSearchTree32.java</a>
 *
 * @see NodInBiSearchTree32
 */
public class BiSearchTree32 implements Serializable {

	private static final Class<?> THIS = BiSearchTree32.class;

	private static final long serialVersionUID = B.genId32(THIS);

	public NodInBiSearchTree32 root;

	public NodInBiSearchTree32 notNullNod;

	public static StringBuilder tmpStr;

	public void add(int v32) {

		if (root == null) {

			root = new NodInBiSearchTree32(v32);

			return;

		}

		NodInBiSearchTree32 tmp = root;
		do {

			notNullNod = tmp;

			if (v32 > tmp.val)

				tmp = tmp.right;
			else
				tmp = tmp.left;

		} while (tmp != null);

		if (v32 > notNullNod.val)

			notNullNod.right = new NodInBiSearchTree32(v32);
		else
			notNullNod.left = new NodInBiSearchTree32(v32);

	}

	public boolean ifContain(int v32) {

		notNullNod = root;
		while (notNullNod != null) {

			if (v32 > notNullNod.val) {

				notNullNod = notNullNod.right;

				continue;

			}

			if (v32 < notNullNod.val) {

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
	public boolean addIfNotFound(int v32) {

		if (root == null) {

			root = new NodInBiSearchTree32(v32);
			return B.I;

		}

		NodInBiSearchTree32 tmp = root;

		do {

			notNullNod = tmp;

			if (v32 > tmp.val) {

				tmp = tmp.right;
				continue;

			}

			if (v32 < tmp.val) {

				tmp = tmp.left;
				continue;

			}

			return B.O;

		} while (tmp != null);

		if (v32 > notNullNod.val)

			notNullNod.right = new NodInBiSearchTree32(v32);
		else
			notNullNod.left = new NodInBiSearchTree32(v32);

		return B.I;

	}

	public void toStrInorder(NodInBiSearchTree32 root) {

		if (root == null)
			return;

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

	public void toStrPreorder(NodInBiSearchTree32 root) {

		if (root == null)
			return;

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
