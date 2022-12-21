package leetcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

/*  Given a non-empty array of integers nums, every element appears
 *  twice except for one. Find that single one.
 *  You must implement a solution with a linear runtime complexity 
 *  and use only constant extra space. */
public class SingleNumber {
	public int singleNumber(int[] nums) {
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			ans ^= nums[i];
//			System.out.println(i + " " + nums[i] + " " + ans);
		}
		return ans;
	}

	public int singleNumber1(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int sum = 0, compare = 0;
		for (int i : nums) {
			sum += i;
			if (set.contains(i)) {
				compare += i;
			}
			set.add(i);
		}
		return sum - compare * 2;
	}

	public int singleNumber2(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			if (!set.contains(i)) {
				set.add(i);
			} else {
				set.remove(i);
			}
		}
		return set.iterator().next();
	}

	public int singleNumber3(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int before = 0;
		for (int i : nums) {
			before = set.size();
			set.add(i);
			if (set.size() == before) {
				set.remove(i);
			}
		}
		return (int) set.toArray()[0];
	}

	@Test
	void test1() {
		int[] arr = { 2, 2, 1 };
		int expected = 1;
		int actual = singleNumber(arr);
		assertEquals(expected, actual);
	}

	@Test
	void test2() {
		int[] arr = { 4, 1, 2, 1, 2 };
		int expected = 4;
		int actual = singleNumber(arr);
		assertEquals(expected, actual);
	}

	@Test
	void test3() {
		int[] arr = { 1 };
		int expected = 1;
		int actual = singleNumber(arr);
		assertEquals(expected, actual);
	}
}
