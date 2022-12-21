package leetcode.easy;

import org.junit.jupiter.api.Test;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {

		int p1 = 0, p2 = 1;
		while (p2 < nums.length) {
			if (nums[p2] != nums[p1]) {
				p1++;
				nums[p1] = nums[p2];
			}
			p2++;
		}
		return ++p1;
	}

	public int removeDuplicates1(int[] nums) {
		int p1 = 0;

		for (int p2 = 1; p2 < nums.length;) {
			if (nums[p2] == nums[p1]) {
				p2++;
				continue;
			}
			nums[p1 + 1] = nums[p2];
			p1++;
		}
		return ++p1;
	}

	@Test
	void test() {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }; // Input array
		int[] expectedNums = { 0, 1, 2, 3, 4 }; // The expected answer with correct length

		int k = removeDuplicates(nums); // Calls your implementation

		assert k == expectedNums.length;
		for (int i = 0; i < k; i++) {
			assert nums[i] == expectedNums[i];
		}
	}
}
