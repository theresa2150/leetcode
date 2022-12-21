package leetcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class MergeSortedArray {
	public int[] merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1, k = nums1.length - 1;

		while (i >= 0 && j >= 0) {
			if (nums2[j] > nums1[i]) {
				nums1[k--] = nums2[j--];
			} else {
				nums1[k--] = nums1[i--];
			}
		}

		if (i == -1) {
			while (j >= 0) {
				nums1[k--] = nums2[j--];
			}
		}
		return nums1;
	}

	public int[] merge1(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1, k = nums1.length - 1;

		while (i >= 0 && j >= 0) {
			if (nums2[j] > nums1[i]) {
				nums1[k--] = nums2[j--];
			} else {
				nums1[k--] = nums1[i--];
			}
		}

		if (i == -1) {
//		if (j >= 0) {
			for (int l = 0; l <= j; l++) {
				nums1[l] = nums2[l];
			}
		}
		return nums1;
	}

	public int[] merge2(int[] nums1, int m, int[] nums2, int n) {
		int i = 0, j = 0, k = 0;
		int[] merge = new int[nums1.length];

		while (i < m && j < n) {
			if (nums1[i] <= nums2[j]) {
				merge[k] = nums1[i];
				i++;
			} else {
				merge[k] = nums2[j];
				j++;
			}
			k++;
		}

		if (i < m) {
			for (int l = k; l < merge.length; l++) {
				merge[l] = nums1[i];
				i++;
			}
		} else {
			for (int l = k; l < merge.length; l++) {
				merge[l] = nums2[j];
				j++;
			}
		}

		for (int l = 0; l < merge.length; l++) {
			nums1[l] = merge[l];
		}

		return nums1;
	}

	public int[] merge3(int[] nums1, int m, int[] nums2, int n) {
		int j = 0;
		for (int i = m; i < nums1.length; i++) {
			nums1[i] = nums2[j];
			j++;
		}
		Arrays.sort(nums1);
		return nums1;
	}

//	public int[] merge_fail(int[] nums1, int m, int[] nums2, int n) {
//		int i = 0, j = 0;
//		boolean boo = false;
//
//		if (m == 0) {
//			while (j < n) {
//				nums1[j] = nums2[j];
//				j++;
//			}
//		} else {
//			while (j < n && i < nums1.length) {
//				if (i > m - 1 && nums1[i - 1] > 0) {
//					boo = true;
//				} 
//				if (nums1[i] == 0 && boo == true) {
//					for (int k = i; k < nums1.length; k++) {
//						nums1[k] = nums2[j];
//						j++;
//					}
//				} else if (nums2[j] < nums1[i]) {
//					for (int k = nums1.length - 1; k > i; k--) {
//						nums1[k] = nums1[k - 1];
//					}
//					nums1[i] = nums2[j];
//					j++;
//				}
//				i++;
//			}
//		}
//		return nums1;
//	}

//	public int[] merge_fail1(int[] nums1, int m, int[] nums2, int n) {
//		int i = 0, j = 0;
//
//		if (m == 0) {
//			for (int k = 0; k < nums1.length; k++) {
//				nums1[k] = nums2[k];
//			}
//		} else if (n != 0) {
//			while (j < n) {
//				if (nums1[i] > nums2[j] || i >= m) {
//					for (int k = nums1.length - 1; k > i; k--) {
//						nums1[k] = nums1[k - 1];
//					}
//					nums1[i] = nums2[j];
//					j++;
//				}
//				i++;
//			}
//		}
//		return nums1;
//	}

	@Test
	void test1() {
		int[] arr1 = { 1, 3, 5, 0, 0, 0 };
		int[] arr2 = { 2, 4, 6 };
		int[] result = { 1, 2, 3, 4, 5, 6 };
		int m = 3, n = 3;

		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println("\nm=" + m + " n=" + n + "\n");

		int[] merge = merge(arr1, m, arr2, n);
		for (int i = 0; i < merge.length; i++) {
			System.out.println(result[i] + " " + merge[i]);
//			assertEquals(result[i], merge[i]);
		}
	}

	@Test
	void test2() {
		int[] arr1 = { 1, 2, 3, 0, 0, 0 };
		int[] arr2 = { 2, 5, 6 };
		int[] result = { 1, 2, 2, 3, 5, 6 };
		int m = 3, n = 3;

		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println("\nm=" + m + " n=" + n + "\n");

		int[] merge = merge(arr1, m, arr2, n);
		for (int i = 0; i < merge.length; i++) {
			System.out.println(result[i] + " " + merge[i]);
			assertEquals(result[i], merge[i]);
		}
	}

	@Test
	void test3() {
		int[] arr1 = { 1, 3, 5, 0, 0, 0 };
		int[] arr2 = { 2, 4, 6 };
		int[] result = { 1, 2, 3, 4, 5, 6 };
		int m = 3, n = 3;

		int[] merge = merge(arr1, m, arr2, n);
		for (int i = 0; i < merge.length; i++) {
			System.out.println(result[i] + " " + merge[i]);
			assertEquals(result[i], merge[i]);
		}
	}

	@Test
	void test4() {
		int[] arr1 = { 1, 2, 3, 0, 0, 0 };
		int[] arr2 = { 4, 5, 6 };
		int[] result = { 1, 2, 3, 4, 5, 6 };
		int m = 3, n = 3;

		int[] merge = merge(arr1, m, arr2, n);
		for (int i = 0; i < merge.length; i++) {
			System.out.println(result[i] + " " + merge[i]);
			assertEquals(result[i], merge[i]);
		}
	}

	@Test
	void test5() {
		int[] arr1 = { 1 };
		int[] arr2 = {};
		int[] result = { 1 };
		int m = 1, n = 0;

		int[] merge = merge(arr1, m, arr2, n);
		for (int i = 0; i < merge.length; i++) {
			System.out.println(result[i] + " " + merge[i]);
			assertEquals(result[i], merge[i]);
		}
	}

	@Test
	void test6() {
		int[] arr1 = { 0 };
		int[] arr2 = { 1 };
		int[] result = { 1 };
		int m = 0, n = 1;

		int[] merge = merge(arr1, m, arr2, n);
		for (int i = 0; i < merge.length; i++) {
			System.out.println(result[i] + " " + merge[i]);
			assertEquals(result[i], merge[i]);
		}
	}

	@Test
	void test7() {
		int[] arr1 = { 1, 2, 4, 5, 6, 0 };
		int[] arr2 = { 3 };
		int[] result = { 1, 2, 3, 4, 5, 6 };
		int m = 5, n = 1;

		int[] merge = merge(arr1, m, arr2, n);
		for (int i = 0; i < merge.length; i++) {
			System.out.println(result[i] + " " + merge[i]);
			assertEquals(result[i], merge[i]);
		}
	}

	@Test
	void test8() {
		int[] arr1 = { -1, 0, 0, 3, 3, 3, 0, 0, 0 };
		int[] arr2 = { 1, 2, 2 };
		int[] result = { -1, 0, 0, 1, 2, 2, 3, 3, 3 };
		int m = 6, n = 3;

		int[] merge = merge(arr1, m, arr2, n);
		for (int i = 0; i < merge.length; i++) {
			System.out.println(result[i] + " " + merge[i]);
			assertEquals(result[i], merge[i]);
		}
	}

	@Test
	void test9() {
		int[] arr1 = { -1, -1, 0, 0, 0, 0 };
		int[] arr2 = { -1, 0 };
		int[] result = { -1, -1, -1, 0, 0, 0 };
		int m = 4, n = 2;

		int[] merge = merge(arr1, m, arr2, n);
		for (int i = 0; i < merge.length; i++) {
			System.out.println(result[i] + " " + merge[i]);
			assertEquals(result[i], merge[i]);
		}
	}

	@Test
	void test10() {
		int[] arr1 = { 0, 0, 3, 0, 0, 0, 0, 0, 0 };
		int[] arr2 = { -1, 1, 1, 1, 2, 3 };
		int[] result = { -1, 0, 0, 1, 1, 1, 2, 3, 3 };
		int m = 3, n = 6;

		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println("\nm=" + m + " n=" + n + "\n");

		int[] merge = merge(arr1, m, arr2, n);
		for (int i = 0; i < merge.length; i++) {
			System.out.println(result[i] + " " + merge[i]);
//			assertEquals(result[i], merge[i]);
		}
	}

	@Test
	void test11() {
		int[] arr1 = { -12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int[] arr2 = { -49, -45, -42, -41, -40, -39, -39, -39, -38, -36, -34, -34, -33, -33, -32,
				-31, -29, -28, -26, -26, -24, -21, -20, -20, -18, -16, -16, -14, -11, -7, -6, -5,
				-4, -4, -3, -3, -2, -2, -1, 0, 0, 0, 2, 2, 6, 7, 7, 8, 10, 10, 13, 13, 15, 15, 16,
				17, 17, 19, 19, 20, 20, 20, 21, 21, 22, 22, 24, 24, 25, 26, 27, 29, 30, 30, 30, 35,
				36, 36, 36, 37, 39, 40, 41, 42, 45, 46, 46, 46, 47, 48 };
		int[] result = { -49, -45, -42, -41, -40, -39, -39, -39, -38, -36, -34, -34, -33, -33, -32,
				-31, -29, -28, -26, -26, -24, -21, -20, -20, -18, -16, -16, -14, -12, -11, -7, -6,
				-5, -4, -4, -3, -3, -2, -2, -1, 0, 0, 0, 2, 2, 6, 7, 7, 8, 10, 10, 13, 13, 15, 15,
				16, 17, 17, 19, 19, 20, 20, 20, 21, 21, 22, 22, 24, 24, 25, 26, 27, 29, 30, 30, 30,
				35, 36, 36, 36, 37, 39, 40, 41, 42, 45, 46, 46, 46, 47, 48 };
		int m = 1, n = 90;

		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println("\nm=" + m + " n=" + n + "\n");

		int[] merge = merge(arr1, m, arr2, n);
		for (int i = 0; i < merge.length; i++) {
			System.out.println(result[i] + " " + merge[i]);
//			assertEquals(result[i], merge[i]);
		}
	}
}
