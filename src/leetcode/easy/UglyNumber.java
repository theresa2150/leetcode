package leetcode.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

// An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
public class UglyNumber {
	public boolean isUgly(int n) {
		if (n == 0) {
			return false;
		}

		int[] prime = { 5, 3, 2 };
		for (int i : prime) {
			while (n % i == 0) {
				n /= i;
			}
		}
		return n == 1;
	}

	public boolean isUgly1(int n) {
		if (n == 0) {
			return false;
		}
		while (n % 5 == 0) {
			n /= 5;
		}
		while (n % 3 == 0) {
			n /= 3;
		}
		while (n % 2 == 0) {
			n /= 2;
		}
		return n == 1;
	}

	@ParameterizedTest
	@CsvSource({ "1", "6" })
	void test_true(int input) {
		assert isUgly(input);
	}

	@ParameterizedTest
	@CsvSource({ "0", "14", "13" })
	void test_false(int input) {
		assert !isUgly(input);
	}
}
