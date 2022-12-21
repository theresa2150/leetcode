package leetcode.easy.TreeNode;

import org.junit.jupiter.api.Test;

public class TestTreeNode {
	@Test
	void test1() {
//		Integer[] arr = { 1, null, 2, 3 };
		Integer[] arr = { 1, 2, 3, 4, 5, null, 6, 7, 8, 9, 0, 22, 33, 44, 55 };
//		Integer[] arr = { 1, 2, 3, 4, 5, 6 };
	}

	@Test
	void test2() {

		TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
	}
}
