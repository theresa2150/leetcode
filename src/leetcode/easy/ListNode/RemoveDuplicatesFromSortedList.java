package leetcode.easy.ListNode;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class RemoveDuplicatesFromSortedList {
	int[] arr1 = { 1, 1, 2, 3, 3 };
	int[] exp1 = { 1, 2, 3 };
	int[] arr2 = { -3, -1, 0, 0, 0, 3, 3 };
	int[] exp2 = { -3, -1, 0, 3 };
	int[] arr3 = { 1, 2, 3 };
	int[] exp3 = { 1, 2, 3 };
	int[] arr4 = { 1, 1, 2 };
	int[] exp4 = { 1, 2 };
	int[] arr5 = { Integer.MIN_VALUE, Integer.MIN_VALUE };
	int[] exp5 = { Integer.MIN_VALUE };
	int[] arr6 = {};
	int[] exp6 = {};

	public ListNode1 deleteDuplicates(ListNode1 head) {
		if (head == null) {
			return null;
		}

		ListNode1 cur = head;
		while (cur.next != null) {
			if (cur.next.val != cur.val) {
				cur = cur.next;
			} else {
				cur.next = cur.next.next;
			}
		}
		return head;
	}

	public ListNode1 deleteDuplicates1(ListNode1 head) {
		if (head == null) {
			return null;
		}
		ListNode1 next = head;
		ListNode1 cur = head.next;

		while (cur != null) {
			if (cur.val != next.val) {
				next.next = cur;
				next = next.next;
			}
			cur = cur.next;
		}
		next.next = null;
		return head;
	}

	public ListNode1 deleteDuplicates2(ListNode1 head) {
		if (head == null) {
			return null;
		}

		int pre = head.val;
		ListNode1 inCur = head;
		ListNode1 output = new ListNode1(pre);
		ListNode1 outCur = output;

		inCur = inCur.next;
		while (inCur != null) {
			int cur = inCur.val;
			if (cur != pre) {
				outCur.next = new ListNode1(cur);
				outCur = outCur.next;
			}
			pre = cur;
			inCur = inCur.next;
		}
		return output;
	}

	public ListNode1 deleteDuplicates3(ListNode1 head) {
		ListNode1 pointer = head;
		Set<Integer> set = new TreeSet<>();

		while (pointer != null) {
			set.add(pointer.val);
			pointer = pointer.next;
		}

		head = new ListNode1();
		pointer = head;

		for (int i : set) {
			pointer.next = new ListNode1(i);
			pointer = pointer.next;
		}
		return head.next;
	}

	@Test
	void test1() {
		ListNode1 input = ListNode1.creator(arr1);
		ListNode1 output = deleteDuplicates(input);

		ListNode1.printer(output);
		System.out.println(Arrays.toString(exp1));
	}

	@Test
	void test2() {
		ListNode1 input = ListNode1.creator(arr2);
		ListNode1 output = deleteDuplicates(input);

		ListNode1.printer(output);
		System.out.println(Arrays.toString(exp2));
	}

	@Test
	void test3() {
		ListNode1 input = ListNode1.creator(arr3);
		ListNode1 output = deleteDuplicates(input);

		ListNode1.printer(output);
		System.out.println(Arrays.toString(exp3));
	}

	@Test
	void test4() {
		ListNode1 input = ListNode1.creator(arr4);
		ListNode1 output = deleteDuplicates(input);

		ListNode1.printer(output);
		System.out.println(Arrays.toString(exp4));
	}

	@Test
	void test5() {
		ListNode1 input = ListNode1.creator(arr5);
		ListNode1 output = deleteDuplicates(input);

		ListNode1.printer(output);
		System.out.println(Arrays.toString(exp5));
	}

	@Test
	void test6() {
		ListNode1 input = ListNode1.creator(arr6);
		ListNode1 output = deleteDuplicates(input);

		ListNode1.printer(output);
		System.out.println(Arrays.toString(exp6));
	}
}
