package leetcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PalindromeNumber {

	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int size = (int) Math.log10(x), i = 0;
		String s = String.valueOf(x);
//		String s = Integer.toString(x);
		while (i < (size + 1) / 2) {
			if (s.charAt(i) != s.charAt(size - i)) {
				return false;
			}
			i++;
		}
		return true;
	}

	public boolean isPalindrome1(int x) {
		if (x < 0)
			return false;

		int size = (int) Math.log10(x), i = 0;
		String s = x + "";
		while (i < (size + 1) / 2) {
			if (Character.compare(s.charAt(i), s.charAt(size - i)) != 0) {
				return false;
			}
			i++;
		}
		return true;
	}

	public boolean isPalindrome2(int x) {
		String s = x + "";
		int i = 0;
		int size = s.length() + 1;
		while (i < size / 2) {
			if (s.charAt(i) != s.charAt(size - i - 2)) {
				return false;
			}
			i++;
		}
		return true;
	}

	public boolean isPalindrome3(int x) {
		String s = x + "";
		char[] chArr = s.toCharArray();
		int i = 0;
		while (i < (chArr.length + 1) / 2) {
			if (chArr[i] != chArr[chArr.length - i - 1]) {
				return false;
			}
			i++;
		}
		return true;
	}

	public boolean isPalindrome_fail(int x) {
		int numOfDigit = (int) Math.log10(x) + 1;
//		int highDigit = 0, lowDigit = 0;
		double highDigit = 0, lowDigit = 0;
		int i = 0;

		if (x < 0) {
			return false;
		} else if (x == 0) {
			return true;
		} else {
			while (i <= (numOfDigit + 1) / 2) {
//				highDigit = (int) (x / Math.pow(10, numOfDigit - i - 1));
//				lowDigit = (int) (x % Math.pow(10, i + 1));

				highDigit = x / Math.pow(10, numOfDigit - i - 1);
				lowDigit = x % Math.pow(10, i + 1);

				if (highDigit == lowDigit) {
					return true;
				}

				x -= highDigit * Math.pow(10, numOfDigit - i - 1);
				x /= 10;

				i++;
			}
		}
		return false;
	}

	@ParameterizedTest
	@CsvSource({ "true, 0", "true, 1", "true, 121", "true, 456654", "false, 123", "false, -121",
			"false, -1", "false, 400", "false, 10" })
	void test(boolean b, int i) {
		assertEquals(b, isPalindrome(i));
	}
}
