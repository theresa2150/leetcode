package leetcode.easy.ListNode;

// Definition for singly-linked list. 
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	public static ListNode convertor(int[] arr) {
		if (arr == null) {
			return null;
		}
		ListNode ln = new ListNode(0);
		ListNode cur = ln;
		for (int i = 0; i < arr.length; i++) {
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
		return ln.next;
	}

	public static ListNode connector(ListNode head, ListNode tail) {
		if (head == null) {
			return tail;
		}
		ListNode cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		if (tail != null)
			cur.next = tail;
		return head;
	}

	public static void printListNode(ListNode ln1) {
		ListNode cur;
		int i;
		cur = ln1;
		i = 0;
		while (i < 40) {
			if (cur != null) {
//				System.out.println(i + " " + cur.val);
				System.out.print(cur.val + " ");
				cur = cur.next;
			}
			i++;
		}
		System.out.println();
	}
}
