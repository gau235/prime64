package lgpl3.recycle;

import java.io.Serializable;

import lgpl3.o.B;
import lgpl3.o.O;

/**
 * @version 2020/02/22_10:10:00<br/>
 *          <a target="_blank" href="http://c64.tw/w20/o/srchSrc.jsp?nameOfClass=LinkedList32" >LinkedList32.java</a>
 *
 * @see NodInLinkedList32
 */
public class LinkedList32 implements Serializable {

	private static final Class<?> THIS = LinkedList32.class;

	private static final long serialVersionUID = B.genId32(THIS);

	public NodInLinkedList32 first;

	public void addBetween(NodInLinkedList32 cur, NodInLinkedList32 next, NodInLinkedList32 newNod) {

		O.l("addBetween newNod.val=" + newNod.val);
		newNod.next = next;
		cur.next = newNod;

	}

	public void addBetweenNodNTail(NodInLinkedList32 cur, NodInLinkedList32 next, NodInLinkedList32 newNod) {

		// O.l("addBetweenNodNTail newNod.val=" + newNod.val);
		// newNod.next =null;
		cur.next = newNod;

	}

	public void add(int newN) {

		NodInLinkedList32 newNod = new NodInLinkedList32(newN);

		if (first == null) {

			first = newNod;
			return;

		}

		if (newNod.val < first.val) {

			newNod.next = first;
			first = newNod;

			// O.l("newNod.next=" + newNod.next.val);
			return;

		}

		// NodInLinkedList32 prev;
		NodInLinkedList32 cur = first;
		NodInLinkedList32 next = first.next;
		while (next != null) {

			// O.l("next.val=" + next.val + " newNod.val=" + newNod.val);
			if (newNod.val < next.val) {

				addBetween(cur, next, newNod);
				return;

			}

			// prev = cur; // prev 往後挪
			cur = next; // cur 往後挪
			next = cur.next; // next 往後挪

		}

		// next==null
		addBetweenNodNTail(cur, null, newNod);

	}

	public void del(int n) {

		if (first == null) {

			return;
		}

		// first != null

		if (first.val == n) {

			if (first.next == null) {

				first = null;
				return;

			}

			first = first.next;

		}

		// NodInLinkedList32 prev = null;
		NodInLinkedList32 cur = first;
		NodInLinkedList32 next = first.next;
		while (next != null) {

			if (next.val == n) {

				cur.next = next.next;
				return;

			}

			cur = next; // cur 往後挪
			next = next.next; // next 往後挪

		}

	}

	public void reverse() {

		if (first == null) {

			return;
		}

		// 准备 3 个变数, 如同费氏数列 fn, fn_1, fn_2 这样的迭代关系
		// 處長升官退休, 副處長變處長, 經理變副處長
		NodInLinkedList32 prev = null;
		NodInLinkedList32 cur = first;
		NodInLinkedList32 next = first.next;

		while (next != null) {

			cur.next = prev; // 把 cur->next 转向

			// 迭代关系
			prev = cur; // previous 往後挪
			cur = next; // cur 往後挪
			next = next.next; // newNext 往後挪

		}

		O.l("reverse========done");

		cur.next = prev; // 此时 cur 位於最後 node, 将 cur->next 转向
		first = cur;

	}

	public StringBuilder toStr() {

		StringBuilder str = new StringBuilder();

		NodInLinkedList32 cur = first;
		while (cur != null) {

			// O.l("cur=" + cur.toStr());
			str.append(cur.toStr());

			if (cur.next != null) {

				str.append("->");
			}

			cur = cur.next;

		}

		return str;

	}

}
