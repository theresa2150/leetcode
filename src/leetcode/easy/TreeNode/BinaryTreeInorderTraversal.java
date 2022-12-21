package leetcode.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class BinaryTreeInorderTraversal {
	// Skip - Morris Traversal
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		return list;
	}

	@Test
	void test1() {
		TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
		List<Integer> list = inorderTraversal(root);
		System.out.println(list);
	}

	@Test
	void test2() {
		TreeNode root = new TreeNode(1, null, new TreeNode(2));
		List<Integer> list = inorderTraversal(root);
		System.out.println(list);
	}

	@Test
	void test3() {
		TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		List<Integer> list = inorderTraversal(root);
		System.out.println(list);
	}

	@Test
	void test4() {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
				new TreeNode(3, new TreeNode(6), null));
		List<Integer> list = inorderTraversal(root);
		System.out.println(list);
	}

	@Test
	void test5() {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4,
				new TreeNode(8, null, new TreeNode(11, new TreeNode(12), new TreeNode(13))), null),
				new TreeNode(5, null, new TreeNode(9))),
				new TreeNode(3, new TreeNode(6), new TreeNode(7, null, new TreeNode(10))));
		List<Integer> list = inorderTraversal(root);
		System.out.println(list);
	}

	@Test
	void test6() {
		TreeNode root = new TreeNode(1,
				new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(8), new TreeNode(9))),
				new TreeNode(3, new TreeNode(6), new TreeNode(7)));
		List<Integer> list = inorderTraversal(root);
		System.out.println(list);
	}

	// Stack
	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		TreeNode pointer = root;
		if (pointer == null) {
			return null;
		}
		while (pointer != null || !stack.isEmpty()) {
			while (pointer != null) {
				stack.push(pointer);
				pointer = pointer.left;
			}
			pointer = stack.pop();
			list.add(pointer.val);
			pointer = pointer.right;
		}
		return list;
	}

	// 遞迴
	public List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		next(root, result);
		return result;
	}

	private void next(TreeNode pointer, List<Integer> list) {
		if (pointer == null) {
			return;
		}
		next(pointer.left, list);
		list.add(pointer.val);
		next(pointer.right, list);
	}
}
