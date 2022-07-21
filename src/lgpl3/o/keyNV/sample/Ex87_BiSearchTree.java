package lgpl3.o.keyNV.sample;

import lgpl3.o.O;
import lgpl3.o.keyNV.BiSearchTree;

/**
 * To use BiSearchTree.<br/>
 * To use BiSearchTree.
 *
 * @version 2021/02/02_17:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=Ex87_BiSearchTree" >Ex87_BiSearchTree.java</a>
 */
public class Ex87_BiSearchTree {

	public static void main(String[] sAry) throws Throwable {

		BiSearchTree biSearchTree = new BiSearchTree();

		biSearchTree.add(50);
		biSearchTree.add(20);
		biSearchTree.add(10);

		O.l("toStrInorder=" + O.L + biSearchTree.toStrInorder());
		O.l("ifContain=" + biSearchTree.ifContain(30));

		O.l("toStrPreorder=" + O.L + biSearchTree.toStrPreorder());

	}
}
