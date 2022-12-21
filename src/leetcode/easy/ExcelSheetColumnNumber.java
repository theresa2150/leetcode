package leetcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String columnTitle) {
		int length = columnTitle.length(), j = 0, output = 0;
		while (j < length) {
			output += Math.pow(26, j++) * (columnTitle.charAt(length - j) - 64);
		}
		return output;
	}

	public int titleToNumber1(String columnTitle) {
		int length = columnTitle.length() - 1, j = 0, index = 1;
		int output = columnTitle.charAt(length) - 64;
		while (j < length) {
			index *= 26;
			output += index * (columnTitle.charAt(length - ++j) - 64);
		}
		return output;
	}

	@ParameterizedTest
	@CsvSource({ "A, 1", "X, 24", "Z, 26", "AA, 27", "AAA, 703", "BAA, 1379", "ZY, 701",
			"XSH, 16726", "XAA, 16251", "XBA, 16277", "FXSHRXW, 2147483647" })
	void test(String title, int expected) {
		int actual = titleToNumber(title);
		assertEquals(expected, actual);
	}
}
