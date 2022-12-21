package leetcode.easy.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MergeTwoSortedLists {

	public ListNode1 mergeTwoLists(ListNode1 node1, ListNode1 node2) {

		ListNode1 dummy = new ListNode1();
		ListNode1 pointer = dummy;

		if (node1 == null) {
			return node2;
		} else if (node2 == null) {
			return node1;
		}

		while (node1 != null && node2 != null) {

			if (node1.val <= node2.val) {
				pointer.next = node1;
				node1 = node1.next;
			} else {
				pointer.next = node2;
				node2 = node2.next;
			}
			pointer = pointer.next;
		}

		if (node1 == null) {
			pointer.next = node2;
		} else {
			pointer.next = node1;
		}
		return dummy.next;
	}

	public ListNode1 mergeTwoLists1(ListNode1 node1, ListNode1 node2) {

		ListNode1 dummy = new ListNode1();
		ListNode1 pointer = dummy;
		int v1, v2;

		if (node1 == null) {
			return node2;
		} else if (node2 == null) {
			return node1;
		}

		while (node1 != null && node2 != null) {

			v1 = node1.val;
			v2 = node2.val;

			if (v1 <= v2) {
				pointer.next = new ListNode1(v1);
				node1 = node1.next;
			} else {
				pointer.next = new ListNode1(v2);
				node2 = node2.next;
			}
			pointer = pointer.next;
		}

		if (node1 == null) {
			pointer.next = node2;
		} else {
			pointer.next = node1;
		}
		return dummy.next;
	}

	@Test
	void test1() {
		int[] arr1 = { 2, 4 };
		ListNode1 l1 = ListNode1.creator(arr1);
		int[] arr2 = { 1, 3, 5, 8 };
		ListNode1 l2 = ListNode1.creator(arr2);
		int[] r = { 1, 2, 3, 4, 5, 8 };
		ListNode1 result = ListNode1.creator(r);

//		printer(l1);
//		printer(l2);
//		printer(mergeTwoLists(l1, l2));

		assertEquals(ListNode1.converter(result), ListNode1.converter(mergeTwoLists(l1, l2)));
	}

	@Test
	void test2() {
		int[] arr1 = {};
		ListNode1 l1 = ListNode1.creator(arr1);
		int[] arr2 = {};
		ListNode1 l2 = ListNode1.creator(arr2);
		int[] r = {};
		ListNode1 result = ListNode1.creator(r);

//		printer(l1);
//		printer(l2);
//		printer(mergeTwoLists(l1, l2));

		assertEquals(ListNode1.converter(result), ListNode1.converter(mergeTwoLists(l1, l2)));
	}

	@Test
	void test3() {
		int[] arr1 = {};
		ListNode1 l1 = ListNode1.creator(arr1);
		int[] arr2 = { 0 };
		ListNode1 l2 = ListNode1.creator(arr2);
		int[] r = { 0 };
		ListNode1 result = ListNode1.creator(r);

//		printer(l1);
//		printer(l2);
//		printer(mergeTwoLists(l1, l2));

		assertEquals(ListNode1.converter(result), ListNode1.converter(mergeTwoLists(l1, l2)));
	}

	@Test
	void test4() {
		int[] arr1 = { 1, 2, 4 };
		ListNode1 l1 = ListNode1.creator(arr1);
		int[] arr2 = { 1, 3, 4 };
		ListNode1 l2 = ListNode1.creator(arr2);
		int[] r = { 1, 1, 2, 3, 4, 4 };
		ListNode1 result = ListNode1.creator(r);

//		printer(l1);
//		printer(l2);
//		printer(mergeTwoLists(l1, l2));

		assertEquals(ListNode1.converter(result), ListNode1.converter(mergeTwoLists(l1, l2)));
	}
}