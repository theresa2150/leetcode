package leetcode.easy.TreeNode;

import java.util.Stack;

import org.junit.jupiter.api.Test;

public class SameTree {

	TreeNode a = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
	TreeNode b = new TreeNode(1, null, new TreeNode(2));
	TreeNode c = new TreeNode(1, new TreeNode(2), new TreeNode(3));
	TreeNode d = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
			new TreeNode(3, new TreeNode(6), null));
	TreeNode e = new TreeNode(1,
			new TreeNode(2, new TreeNode(4, new TreeNode(8), null),
					new TreeNode(5, null, new TreeNode(9))),
			new TreeNode(3, new TreeNode(6), new TreeNode(7, null, new TreeNode(10))));

	public boolean isSameTree(TreeNode p, TreeNode q) {
		TreeNode curP = p, curQ = q;
		Stack<TreeNode> stackP = new Stack<>();
		Stack<TreeNode> stackQ = new Stack<>();
		while (curP != null || !stackP.isEmpty()) {
			while (curP != null) {
				if (curP != curQ) {
					return false;
				}
				stackP.add(curP);
				stackQ.add(curQ);
				curP = curP.left;
				curQ = curQ.left;
			}
			curP = stackP.pop();
			curQ = stackQ.pop();

			curP = curP.right;
			curQ = curQ.right;
		}
		return true;
	}

	@Test
	void test_true() {
		assert isSameTree(a, a);
		assert isSameTree(b, b);
		assert isSameTree(c, c);
		assert isSameTree(d, d);
	}

	@Test
	void test_false() {
		assert !isSameTree(a, b);
		assert !isSameTree(a, c);
		assert !isSameTree(a, d);
		assert !isSameTree(b, c);
		assert !isSameTree(b, d);
		assert !isSameTree(c, d);
	}
}
