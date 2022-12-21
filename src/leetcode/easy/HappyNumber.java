package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class HappyNumber {
	public boolean isHappy(int n) {
		int result = n;
		Set<Integer> set = new HashSet<>();
		set.add(result);
		while (true) {
			result = cal(result);
			if (result == 1) {
				return true;
			} else if (set.contains(result)) {
				return false;
			}
			set.add(result);
		}
	}

	private int cal(int n) {
		int next = 0;
		while (n > 0) {
			int t = n % 10;
			next += t * t;
			n /= 10;
		}
		return next;
	}

	private int cal1(int result) {
		char[] charArray = String.valueOf(result).toCharArray();
		result = 0;
		for (int j = 0; j < charArray.length; j++) {
			result += Math.pow(charArray[j] - 48, 2);
		}
		return result;
	}

	@ParameterizedTest
	@CsvSource({ "1", "19", "23", "536" })
	void test_true(int input) {
		assert isHappy(input);
	}

	@ParameterizedTest
	@CsvSource({ "2", "20", "21", "22", "24", "2147483647" })
	void test_false(int input) {
		assert !isHappy(input);
	}

	public boolean isHappy1(int n) {
		if (n == 1) {
			return true;
		}
		int result = n;
		int i = 0;

		while (result != 1 && i < 6) {
			result = cal(result);
			if (result == 1) {
				return true;
			} else if (i > 0 && result == n) {
				return false;
			}
			i++;
		}
		return false;
	}
}
