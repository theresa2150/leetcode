package leetcode.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class BinaryTreePreorderTraversal {
	// Skip - Morris Traversal
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		return list;
	}

	// Stack
	public List<Integer> preorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> output = new ArrayList<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.add(cur);
				output.add(cur.val);
				cur = cur.left;
			}
			cur = stack.pop();
			cur = cur.right;
		}
		return output;
	}

	// 遞迴
	public List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		TreeNode cur = root;
		next(cur, list);
		return list;
	}

	private void next(TreeNode cur, List<Integer> list) {
		if (cur == null) {
			return;
		}
		list.add(cur.val);
		next(cur.left, list);
		next(cur.right, list);
	}

	@Test
	void test1() {
		TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
		List<Integer> list = preorderTraversal(root);
		System.out.println(list);
	}

	@Test
	void test2() {
		TreeNode root = new TreeNode(1, null, new TreeNode(2));
		List<Integer> list = preorderTraversal(root);
		System.out.println(list);
	}

	@Test
	void test3() {
		TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		List<Integer> list = preorderTraversal(root);
		System.out.println(list);
	}

	@Test
	void test4() {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
				new TreeNode(3, new TreeNode(6), null));
		List<Integer> list = preorderTraversal(root);
		System.out.println(list);
	}

	@Test
	void test5() {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4,
				new TreeNode(8, null, new TreeNode(11, new TreeNode(12), new TreeNode(13))), null),
				new TreeNode(5, null, new TreeNode(9))),
				new TreeNode(3, new TreeNode(6), new TreeNode(7, null, new TreeNode(10))));
		List<Integer> list = preorderTraversal(root);
		System.out.println(list);
	}

	@Test
	void test6() {
		TreeNode root = new TreeNode(1,
				new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(8), new TreeNode(9))),
				new TreeNode(3, new TreeNode(6), new TreeNode(7)));
		List<Integer> list = preorderTraversal(root);
		System.out.println(list);
	}

	@Test
	void test() {
		Stack<Integer> stack = new Stack<>();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.add(4);
		stack.insertElementAt(5, stack.size() - 1);
	}
}
