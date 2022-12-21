package leetcode.easy.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ReverseLinkedList {

	int[] arr1 = { 2, 4 };
	int[] arr2 = { 1, 3, 5, 8 };
	int[] arr3 = {};
	int[] arr4 = { 1, 1, 2, 3, 4, 4 };
	int[] arr5 = { 0 };

//	遞迴
	public ListNode1 reverseList(ListNode1 head) {
		ListNode1 newHead;
		if (head == null || head.next == null) {
			return head;
		}
		newHead = reverseList(head.next); // head.next 作为剩余部分的头指针
		// head.next 代表新链表的尾，将它的 next 置为 head，就是将 head 加到末尾了。
		head.next.next = head;
		head.next = null;
		return newHead;
	}

//	迭代
	public ListNode1 reverseList0(ListNode1 head) {

		ListNode1 reverse = null;
		ListNode1 cursor = head;

		while (cursor != null) {
			ListNode1 nextCur = cursor.next;
			cursor.next = reverse;
			reverse = cursor;
			cursor = nextCur;
		}
		return reverse;
	}

	public ListNode1 reverseList1(ListNode1 head) {

		if (head != null) {
			ListNode1 reverse = new ListNode1(head.val, null);
			ListNode1 cursor = head.next;

			while (cursor != null) {
				reverse = new ListNode1(cursor.val, reverse);
				cursor = cursor.next;
			}
			return reverse;
		}
		return null;
	}

	public ListNode1 reverseList2(ListNode1 head) {
		List<Integer> temp = new ArrayList<>();
		ListNode1 cursor = head;

		while (cursor != null) {
			temp.add(cursor.val);
			cursor = cursor.next;
		}

		head = new ListNode1();
		cursor = head;

		for (int j = temp.size() - 1; j >= 0; j--) {
			cursor.next = new ListNode1(temp.get(j));
			cursor = cursor.next;
		}
		return head.next;
	}

	@Test
	void test1() {
		ListNode1 listnode = ListNode1.creator(arr1);
		ListNode1 reverse = reverseList(listnode);

		List<Integer> inlist = ListNode1.converter(listnode);
		List<Integer> outList = ListNode1.converter(reverse);
		Collections.reverse(inlist);

		assertEquals(inlist, outList);
	}

	@Test
	void test2() {
		ListNode1 listnode = ListNode1.creator(arr2);
		ListNode1 reverse = reverseList(listnode);

		List<Integer> inlist = ListNode1.converter(listnode);
		List<Integer> outList = ListNode1.converter(reverse);
		Collections.reverse(inlist);

		assertEquals(inlist, outList);
	}

	@Test
	void test3() {
		ListNode1 listnode = ListNode1.creator(arr3);
		ListNode1 reverse = reverseList(listnode);

		List<Integer> inlist = ListNode1.converter(listnode);
		List<Integer> outList = ListNode1.converter(reverse);
		Collections.reverse(inlist);

		assertEquals(inlist, outList);
	}

	@Test
	void test4() {
		ListNode1 listnode = ListNode1.creator(arr4);
		ListNode1 reverse = reverseList(listnode);

		List<Integer> inlist = ListNode1.converter(listnode);
		List<Integer> outList = ListNode1.converter(reverse);
		Collections.reverse(inlist);

		assertEquals(inlist, outList);
	}

	@Test
	void test5() {
		ListNode1 listnode = ListNode1.creator(arr5);
		ListNode1 reverse = reverseList(listnode);

		List<Integer> inlist = ListNode1.converter(listnode);
		List<Integer> outList = ListNode1.converter(reverse);
		Collections.reverse(inlist);

		assertEquals(inlist, outList);
	}
}
