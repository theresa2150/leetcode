package leetcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ClimbingStairs {
	public int climbStairs(int n) {
		int a = 1, b = 1;
		while (n-- > 0)
			a = (b += a) - a;
		return a;
	}

	public int climbStairs1(int n) {
		if (n == 1) {
			return 1;
		}
		int pre = 1, cur = 1, i = 2, output = 0;
		while (i <= n) {
			output = pre + cur;
			pre = cur;
			cur = output;
			i++;
		}
		return output;
	}

	public int climbStairs2(int n) {
		int output = 0;
		if (n == 1) {
			output = 1;
		} else if (n == 2) {
			output = 2;
		} else {
			output = climbStairs1(n - 1) + climbStairs1(n - 2);
		}
		return output;
	}

	@ParameterizedTest
	@CsvSource({ "3, 3", "4, 5", "5, 8", "6, 13", "30, 1346269", "45, 1836311903" })
	void test(int input, int expected) {
		int actual = climbStairs(input);
		assertEquals(expected, actual);
	}
}
