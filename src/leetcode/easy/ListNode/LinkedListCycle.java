package leetcode.easy.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class LinkedListCycle {
	// 快慢指針
	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;

		ListNode fast = head.next;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			if (fast == slow) {
				return true;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return false;
	}

	public boolean hasCycle1(ListNode head) {
		if (head == null || head.next == null)
			return false;
		Set<ListNode> set = new HashSet<>();
		ListNode cur = head;

		while (cur != null) {
			set.add(cur);
			cur = cur.next;
			if (set.contains(cur)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasCycle2(ListNode head) {
		if (head == null || head.next == null)
			return false;
		Map<Integer, ListNode> map = new HashMap<>();
		ListNode cur = head;
		int index = 0;
		while (cur != null && index < Integer.MAX_VALUE) {
			map.put(index, cur);
			cur = cur.next;
			index++;
			if (map.containsValue(cur)) {
				return true;
			}
		}
		return false;
	}

	@Test
	void test1() {
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(2);
		ln1.next = ln2;
		ln2.next = ln1;

		assert hasCycle(ln1) == true;
//		ListNode.printListNode(ln1);
	}

	@Test
	void test2() {
		ListNode ln1 = new ListNode(4);
		ListNode ln2 = new ListNode(5);
		ln1.next = ln2;
		ListNode cur = ln2;
		int i = 0;
		while (i < 2) {
			cur.next = new ListNode(i);
			cur = cur.next;
			i++;
		}
		cur.next = ln2;

		assert hasCycle(ln1) == true;
//		ListNode.printListNode(ln1);
	}

	@Test
	void test3() {
		ListNode ln1 = new ListNode(1);

		assert hasCycle(ln1) == false;
//		ListNode.printListNode(ln1);
	}

	@Test
	void test4() {
		ListNode ln1 = null;

		assert hasCycle(ln1) == false;
//		ListNode.printListNode(ln1);
	}

	@Test
	void test5() {
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(2);
		ln1.next = ln2;

		assert hasCycle(ln1) == false;
//		ListNode.printListNode(ln1);
	}

	@Test
	void test6() {
		int[] arr = { -21, 10, 17, 8, 4, 26, 5, 35, 33, -7, -16, 27, -12, 6, 29, -12, 5, 9, 20, 14,
				14, 2, 13, -24, 21, 23, -21, 5 };
		ListNode ln1 = ListNode.convertor(arr);
//		ListNode.printListNode(ln1);
		assert hasCycle(ln1) == false;
	}

	@Disabled
	@Test
	void testLinkedListCycle() {
		ListNode ln1 = new ListNode(4);
		ListNode ln2 = new ListNode(5);
		ln1.next = ln2;
		ListNode cur = ln2;
		int i = 0;
		while (i < 5) {
			cur.next = new ListNode(i);
			cur = cur.next;
			i++;
		}
		cur.next = ln2;

		ListNode.printListNode(ln1);
	}

}
