package leetcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RomanToInteger {

	public enum Level {
		I(1), V(5), X(10), L(50), C(100), D(500), M(1000);

		private int num;

		public int getNum() {
			return this.num;
		}

		Level(int n) {
			this.num = n;
		}
	}

	public int romanToInt(String s) {

		int sum = 0, lastValue = 0;
		char[] charArray = s.toCharArray();

		for (int i = charArray.length - 1; i >= 0; i--) {
			Integer currentValue = Level.valueOf(String.valueOf(charArray[i])).getNum();
			if (currentValue < lastValue) {
				sum -= currentValue;
			} else {
				sum += currentValue;
			}
			lastValue = currentValue;
		}
		return sum;
	}

	public int romanToInt2(String s) {

		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int sum = 0, lastValue = 0;
		char[] charArray = s.toCharArray();

		for (int i = charArray.length - 1; i >= 0; i--) {
			Integer currentValue = map.get(charArray[i]);
			if (currentValue < lastValue) {
				sum -= currentValue;
			} else {
				sum += currentValue;
			}
			lastValue = currentValue;
		}
		return sum;
	}

	@ParameterizedTest
	@CsvSource({ "III, 3", "LVIII, 58", "MCMXCIV, 1994" })
	void test(String s, int i) {
		assertEquals(i, romanToInt(s));
	}
}
