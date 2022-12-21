package leetcode.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

//Definition for a binary tree node.
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

//	Queue
	public static void listToTreeNode_fail(Integer[] arr) {
		List<TreeNode[]> temp = new ArrayList<>();
		int length = arr.length;
		int left = length, i = 0, l = 0;

		while (left > 0 && l < length) {
			int decrease = (int) Math.pow(2, i);
			left -= decrease;
			temp.add(new TreeNode[decrease]);
			int k = 0;
			while (k < decrease) {
				if (l < length) {
					arr[l] = arr[l] == null ? -1 : arr[l];
					temp.get(temp.size() - 1)[k] = new TreeNode(arr[l]);
					l++;
				} else {
					temp.get(temp.size() - 1)[k] = new TreeNode(-1);
				}
				k++;
			}
			i++;
		}
		add(temp);
		for (int j = 0; j < temp.size(); j++) {
			for (int k = 0; k < temp.get(j).length; k++) {
				System.out.print(temp.get(j)[k].val + " ");
			}
			System.out.println();
		}
	}

	public static TreeNode add(List<TreeNode[]> temp) {
		TreeNode pointer = null;

		int i = temp.size() - 1;
		while (i > 0) {
			int j = 0, k = 0;
			while (j < temp.get(i - 1).length) {
				pointer = temp.get(i - 1)[j];
				if (pointer.val != -1) {
					pointer.left = temp.get(i)[k];
					pointer.right = temp.get(i)[k + 1];
					k += 2;
				} else {
					pointer = null;
				}
				j++;
			}
			i--;
		}

		System.out.println("ssss1 " + pointer.val);
		System.out.println();
		System.out.println("ssss2 " + pointer.left.val);
		System.out.println("ssss2 " + pointer.right.val);
		System.out.println();
		System.out.println("ssss3 " + pointer.left.left.val);
		System.out.println("ssss3 " + pointer.left.right.val);
//		System.out.println("ssss3 " + pointer.right.left.val);
		System.out.println("ssss3 " + pointer.right.right.val);
		System.out.println();
		System.out.println("ssss4 " + pointer.left.left.left.val);
		System.out.println("ssss4 " + pointer.left.left.right.val);
		System.out.println("ssss4 " + pointer.left.right.left.val);
		System.out.println("ssss4 " + pointer.left.right.right.val);
//		System.out.println("ssss4 " + pointer.right.left.left.val);
//		System.out.println("ssss4 " + pointer.right.left.right.val);
		System.out.println("ssss4 " + pointer.right.right.left.val);
		System.out.println("ssss4 " + pointer.right.right.right.val);
		System.out.println();
		System.out.println("ssss5 " + pointer.left.left.left.val);
		System.out.println("ssss5 " + pointer.left.left.left.val);
//		System.out.println("ssss5 " + pointer.left.left.right.left.val);
//		System.out.println("ssss5 " + pointer.left.left.right.right.val);
		System.out.println();

		return pointer;
	}

	public static int isNull(TreeNode node) {
		return node == null ? -1 : node.val;
	}

	public static void listToTreeNode1(Integer[] arr) {
//		TreeNode head = new TreeNode(arr[0]);
//		TreeNode pointer = head;
		List<Integer[]> temp = new ArrayList<>();
		int length = arr.length;
		int left = length, i = 0, l = 0;

		while (left > 0 && l < length) {
			int decrease = (int) Math.pow(2, i);
			left -= decrease;
			temp.add(new Integer[decrease]);
//			System.out.println("decrease=" + decrease); // 1 2 4 8
//			System.out.println(temp.size()); // 1 2 3 4
			int k = 0;
			while (k < decrease && l < length) {
				temp.get(temp.size() - 1)[k] = arr[l];
				l++;
				k++;
			}
			i++;
		}

		for (int j = 0; j < temp.size(); j++) {
			for (int k = 0; k < temp.get(j).length; k++) {
				System.out.print(temp.get(j)[k] + " ");
			}
			System.out.println();
		}
	}
}
