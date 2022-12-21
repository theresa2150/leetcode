package leetcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

// StringBuilder append v.s. insert
public class AddBinary {
	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int sum = 0, carry = 0, i = a.length() - 1, j = b.length() - 1;
		char[] aArr = a.toCharArray();
		char[] bArr = b.toCharArray();

		while (i >= 0 || j >= 0) {
			if (i >= 0) {
				sum += aArr[i] - 48;
				i--;
			}
			if (j >= 0) {
				sum += bArr[j] - 48;
				j--;
			}
			sum += carry;
			sb.append(sum % 2);
			carry = sum / 2;
			sum = 0;
		}
		if (carry == 1)
			sb.append(1);
		return sb.reverse().toString();
	}

	public String addBinary1(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int sum = 0, carry = 0, i = a.length() - 1, j = b.length() - 1;
		char[] aArr = a.toCharArray();
		char[] bArr = b.toCharArray();

		while (i >= 0 || j >= 0) {
			if (i >= 0) {
				sum += aArr[i] - 48;
				i--;
			}
			if (j >= 0) {
				sum += bArr[j] - 48;
				j--;
			}
			sum += carry;
			sb.insert(0, sum % 2);
			carry = sum / 2;
			sum = 0;
		}
		if (carry == 1)
			sb.insert(0, 1);
		return sb.toString();
	}

	public String addBinary2(String a, String b) {
		int carry = 0, j = 0;
		StringBuilder sb = new StringBuilder();

		int subtract = a.length() - b.length();
		if (subtract > 0) {
			while (j < subtract) {
				b = 0 + b;
				j++;
			}
		} else {
			while (j < 0 - subtract) {
				a = 0 + a;
				j++;
			}
		}
		int index = a.length() - 1, sum;
		while (index >= 0) {
			sum = a.charAt(index) + b.charAt(index) - 96 + carry;
			sb.insert(0, sum % 2);
			carry = sum / 2;
			index--;
		}

		if (carry == 1) {
			sb.insert(0, 1);
		}
		return sb.toString();
	}

	@ParameterizedTest
	@CsvSource({ "0, 0, 0", "101, 101, 1010", "11, 1, 100", "1010, 1011, 10101", "1111, 1, 10000",
			"1, 1111, 10000", "1111, 1111, 11110" })
	void test(String a, String b, String expected) {

		assertEquals(expected, addBinary(a, b));
	}
}
