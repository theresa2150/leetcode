package leetcode.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SearchInsertPosition {
	int[] nums = { 1, 3, 5, 6 };
	int[] nums2 = { 10, 30, 50, 70, 90, 110, 130, 150 };
	int[] nums3 = { 1, 3 };

	public int searchInsert(int[] nums, int target) {
		int length = nums.length;
		int cur = length / 2;

		if (target > nums[length - 1]) {
			return length;
		} else if (target <= nums[0]) {
			return 0;
		} else {
			int newLength = length;
			int newStart = 0;
			int newEnd = length;
			while (cur < length - 1) {
				if (target > nums[cur + 1]) {
					newStart = newStart + newLength / 2;
				} else if (target < nums[cur - 1]) {
					newEnd = newEnd - newLength / 2;
				} else if (target == nums[cur - 1]) {
					return --cur;
				} else if (target > nums[cur]) {
					return ++cur;
				} else {
					return cur;
				}
				cur = (newStart + newEnd) / 2;
				newLength = newLength / 2;
			}
		}
		return cur;
	}

	public int searchInsert1(int[] nums, int target) {
		int index = 0;

		while (index < nums.length) {
			if (nums[index] >= target) {
				break;
			}
			index++;
		}
		return index;
	}

	@ParameterizedTest
	@CsvSource({ "5, 2", "2, 1", "7, 4", "4, 2" })
	void test(int target, int expected) {
		assert searchInsert(nums, target) == expected;
	}

	@ParameterizedTest
	@CsvSource({ "30, 1", "49, 2", "50, 2", "51, 3", "90, 4" })
	void test2(int target, int expected) {
		assert searchInsert(nums2, target) == expected;
	}

	@ParameterizedTest
	@CsvSource({ "1, 0", "2, 1" })
	void test3(int target, int expected) {
		assert searchInsert(nums3, target) == expected;
	}
}
