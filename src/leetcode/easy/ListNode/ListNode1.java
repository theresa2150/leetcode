package leetcode.easy.ListNode;

import java.util.ArrayList;
import java.util.List;

// Definition for singly-linked list.
public class ListNode1 {
	int val;
	ListNode1 next;

	ListNode1() {
	}

	ListNode1(int val) {
		this.val = val;
	}

	ListNode1(int val, ListNode1 next) {
		this.val = val;
		this.next = next;
	}

	protected static ListNode1 creator(int[] arr) {
		int i = 0;
		ListNode1 head = new ListNode1();
		ListNode1 pointer = head;

		while (i < arr.length) {
			pointer.next = new ListNode1(arr[i]);
			pointer = pointer.next;
			i++;
		}
		return head.next;
	}

	protected static List<Integer> converter(ListNode1 node) {
		List<Integer> list = new ArrayList<>();
		ListNode1 pointer = new ListNode1();
		pointer = node;

		while (pointer != null) {
			list.add(pointer.val);
			pointer = pointer.next;
		}
		return list;
	}

	protected static void printer(ListNode1 node) {
		List<Integer> list = converter(node);
		System.out.println(list.toString());
	}
}
