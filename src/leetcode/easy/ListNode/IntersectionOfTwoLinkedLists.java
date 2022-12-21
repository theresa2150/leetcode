package leetcode.easy.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class IntersectionOfTwoLinkedLists {

	// 尾端切齊，超快
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode ptrA = headA;
		ListNode ptrB = headB;

		int lenA = 0;
		int lenB = 0;

		while (ptrA != null) {
			lenA++;
			ptrA = ptrA.next;
		}

		while (ptrB != null) {
			lenB++;
			ptrB = ptrB.next;
		}

		// move headA and headB to the same start point
		while (lenA > lenB) {
			headA = headA.next;
			lenA--;
		}
		while (lenA < lenB) {
			headB = headB.next;
			lenB--;
		}
		// find the intersection until end
		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}

	@Test
	void test1() {
		int[] arr1 = { 4, 1 };
		int[] arr2 = { 5, 6, 1 };
		int[] arrInt = { 8, 4, 5 };
		ListNode ints = ListNode.convertor(arrInt);
		ListNode ln1 = ListNode.connector(ListNode.convertor(arr1), ints);
		ListNode ln2 = ListNode.connector(ListNode.convertor(arr2), ints);

//		ListNode.printListNode(ln1);
//		ListNode.printListNode(ln2);
		assert ints == getIntersectionNode(ln1, ln2);
	}

	@Test
	void test2() {
		int[] arr1 = { 1, 9, 1 };
		int[] arr2 = { 3 };
		int[] arrInt = { 2, 4 };
		ListNode ints = ListNode.convertor(arrInt);
		ListNode ln1 = ListNode.connector(ListNode.convertor(arr1), ints);
		ListNode ln2 = ListNode.connector(ListNode.convertor(arr2), ints);

//		ListNode.printListNode(ln1);
//		ListNode.printListNode(ln2);
		assert ints == getIntersectionNode(ln1, ln2);
	}

	@Test
	void test3() {
		int[] arr1 = { 2, 6, 4 };
		int[] arr2 = { 1, 5 };
		int[] arrInt = null;
		ListNode ints = ListNode.convertor(arrInt);
		ListNode ln1 = ListNode.connector(ListNode.convertor(arr1), ints);
		ListNode ln2 = ListNode.connector(ListNode.convertor(arr2), ints);

//		ListNode.printListNode(ln1);
//		ListNode.printListNode(ln2);
		assert ints == getIntersectionNode(ln1, ln2);
	}

	@Test
	void test4() {
		int[] arr1 = { 2, 2, 4, 5 };
		int[] arr2 = { 2, 2, 4, 5 };
		int[] arrInt = { 4 };
		ListNode ints = ListNode.convertor(arrInt);
		ListNode ln1 = ListNode.connector(ListNode.convertor(arr1), ints);
		ListNode ln2 = ListNode.connector(ListNode.convertor(arr2), ints);

//		ListNode.printListNode(ln1);
//		ListNode.printListNode(ln2);
		assertEquals(ints.val,
				getIntersectionNode(ln1, ln2) == null ? null : getIntersectionNode(ln1, ln2).val);
	}

	@Test
	void test5() {
		int[] arr1 = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29 };
		int[] arr2 = null;
		int[] arrInt = { 30, 31, 32 };
		ListNode ints = ListNode.convertor(arrInt);
		ListNode ln1 = ListNode.connector(ListNode.convertor(arr1), ints);
		ListNode ln2 = ListNode.connector(ListNode.convertor(arr2), ints);

//		ListNode.printListNode(ln1);
//		ListNode.printListNode(ln2);
		assertEquals(ints.val,
				getIntersectionNode(ln1, ln2) == null ? null : getIntersectionNode(ln1, ln2).val);
	}

	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		Set<ListNode> set = new HashSet<>();
		ListNode curA = headA, curB = headB;
		if (curA == null && curB == null)
			return null;
		while (curA != null || curB != null) {
			if (set.contains(curA) || curA == curB) {
				return curA;
			} else if (set.contains(curB)) {
				return curB;
			} else if (curA != null) {
				set.add(curA);
				curA = curA.next;
			} else {
				set.add(curB);
				curB = curB.next;
			}
		}
		return null;
	}

	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		Set<ListNode> set = new HashSet<>();
		ListNode curA = headA, curB = headB;
		while (curA != null || curB != null) {
			if (curA != null) {
				if (set.contains(curA)) {
					return curA;
				}
				set.add(curA);
				curA = curA.next;
			}
			if (curB != null) {
				if (set.contains(curB)) {
					return curB;
				}
				set.add(curB);
				curB = curB.next;
			}
		}
		return null;
	}

	public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
		ListNode curA = headA, curB = headB;
		if (curA == null || curB == null)
			return null;

		while (curA != curB) {
			curA = curA == null ? headA : curA.next;
			curB = curB == null ? headB : curB.next;
		}
		return curA;
	}
}
