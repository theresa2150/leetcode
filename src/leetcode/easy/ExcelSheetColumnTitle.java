package leetcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ExcelSheetColumnTitle {
	public String convertToTitle(int columnNumber) {
		StringBuilder sb = new StringBuilder();
		while (columnNumber > 0) {
			int c = columnNumber % 26;
			if (c == 0) {
				c = 26;
				columnNumber -= 1;
			}
			sb.append((char) ('A' + c - 1));
			columnNumber /= 26;
		}
		return sb.reverse().toString();
	}

	@ParameterizedTest
	@CsvSource({ "1, A", "28, AB", "701, ZY", "18277, ZZY", "18267, ZZO" })
//	@CsvSource({ "18267, ZZO" })
	void test(int input, String expected) {
//		convertToTitle(input);
		assertEquals(expected, convertToTitle(input));
	}
}
