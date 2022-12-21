package leetcode.easy;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		int i = 0;
		int n = nums.length;
		while (i < n) {
			if (nums[i] == val) {
				nums[i] = nums[n - 1];
				n--;
			} else {
				i++;
			}
		}
		return n;
	}

	public int removeElement1(int[] nums, int val) {
		int i = 0, cur = 0;
		while (i < nums.length) {
			if (nums[i] != val) {
				nums[cur++] = nums[i];
			}
			i++;
		}
		return cur;
	}

	@Test
	void test() {
		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int val = 2;
		int[] expectedNums = { 0, 1, 4, 0, 3 }; // The expected answer with correct
		// length.
		// It is sorted with no values equaling val.

//		int[] nums = { 3, 2, 2, 3 };
//		int val = 3;
//		int[] expectedNums = { 2, 2 };

		int k = removeElement(nums, val); // Calls your implementation
		assert k == expectedNums.length;
		Arrays.sort(nums, 0, k); // Sort the first k elements of nums

		for (int i = 0; i < expectedNums.length; i++) {
			assert nums[i] == expectedNums[i];
		}
	}
}
