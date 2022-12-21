package leetcode.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class SymmetricTree {
	TreeNode a = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
			new TreeNode(2, new TreeNode(4), new TreeNode(3)));
	TreeNode b = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)),
			new TreeNode(2, null, new TreeNode(3)));
	TreeNode c = new TreeNode(1, new TreeNode(2, new TreeNode(2), null),
			new TreeNode(2, new TreeNode(2), null));

	public boolean isSymmetric(TreeNode root) {
		List<Integer> list = inorderTraversal(root);
		for (int i = 0; i < list.size() / 2; i++) {
			if (list.get(i) != list.get(list.size() - i - 1)) {
				return false;
			}
		}
		return true;
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
		System.out.println(list);
		return list;
	}

	@Test
	void test_true() {
		assert isSymmetric(a);
	}

	@Test
	void test_false() {
		assert !isSymmetric(b);
		assert !isSymmetric(c);
	}
}
