package leetcode.easy;

import org.junit.jupiter.api.Test;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int carry = 0, sum = 0;
		int length = digits.length;
		int currentDigit = length - 1;
		digits[currentDigit] += 1;

		while (currentDigit >= 0) {
			sum = digits[currentDigit] + carry; // 9 + 1 = 10
			digits[currentDigit] = sum % 10; // ans 19 % 10 = 9
			carry = sum / 10; // carry 19 / 10 = 1
			currentDigit--;
		}

		if (digits[0] == 0) {
			int[] newDigits = new int[length + 1];
			newDigits[0] = 1;
			return newDigits;
		} else {
			return digits;
		}
	}

	public int[] plusOne1(int[] digits) {
		int carry = 0, sum = 0;
		int length = digits.length;
		int currentDigit = length - 1;
		digits[currentDigit] += 1;

		for (int j = 0; j < length;) {
			currentDigit = length - 1 - j;
			sum = digits[currentDigit] + carry; // 9 + 1 = 10
			digits[currentDigit] = sum % 10; // ans 19 % 10 = 9
			carry = sum / 10; // carry 19 / 10 = 1
			j++;
		}

		if (digits[0] == 0) {
			int[] newDigits = new int[length + 1];
			newDigits[0] = 1;
			return newDigits;
		}
		return digits;
	}

	public int[] plusOne2(int[] digits) {
		int currentDigit;

		for (int j = 0; j < digits.length;) {
			currentDigit = digits.length - 1 - j;

			if (digits[currentDigit] == 10) {
				digits[currentDigit] = 0;
				digits[currentDigit - 1] += 1;
			} else {
				digits[currentDigit] += 1;
				if (digits[currentDigit] != 10) {
					break;
				}
			}
			if (digits[currentDigit] != 9) {
				j++;
			}
		}

		for (int i = 0; i < digits.length; i++) {
			if (digits[i] == 10)
				digits[i] = 0;
		}

		if (digits[0] == 0) {
			int[] newArr = new int[digits.length + 1];
			newArr[0] = 1;
			for (int i = 1; i < newArr.length; i++) {
				newArr[i] = digits[i - 1];
			}
			return newArr;
		}
		return digits;
	}

	@Test
	void test1() {
		int[] digits = { 4, 3, 9, 9 };
		int[] expected = { 4, 4, 0, 0 };
		int[] result = plusOne(digits);

		for (int i = result.length - 1; i >= 0; i--) {
			System.out.println(expected[i] + " " + result[i]);
//			assert expected[i] == result[i];
		}
	}

	@Test
	void test2() {
		int[] digits = { 1, 2, 3 };
		int[] expected = { 1, 2, 4 };
		int[] result = plusOne(digits);

		for (int i = 0; i < result.length; i++) {
			System.out.println(expected[i] + " " + result[i]);
			assert expected[i] == result[i];
		}
	}

	@Test
	void test3() {
		int[] digits = { 9, 9, 9 };
		int[] expected = { 1, 0, 0, 0 };
		int[] result = plusOne(digits);

		for (int i = 0; i < result.length; i++) {
			System.out.println(expected[i] + " " + result[i]);
			assert expected[i] == result[i];
		}
	}

	@Test
	void test4() {
		int[] digits = { 9 };
		int[] expected = { 1, 0 };
		int[] result = plusOne(digits);

		for (int i = 0; i < result.length; i++) {
			System.out.println(expected[i] + " " + result[i]);
			assert expected[i] == result[i];
		}
	}
}
