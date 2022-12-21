package leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestLeetcode {
	public String longestCommonPrefix(String[] strs) {
		return null;
	}

	@Test
	void test() {

		String[] strs1 = { "flower", "flow", "flight" };
		String result1 = "fl";
		assertEquals(result1, longestCommonPrefix(strs1));

		String[] strs2 = { "dog", "racecar", "car" };
		String result2 = "";
		assertEquals(result2, longestCommonPrefix(strs2));

		String[] strs3 = { "google", "goose", "good", "goodbye" };
		String result3 = "goo";
		assertEquals(result3, longestCommonPrefix(strs3));

		String[] strs4 = { "", "cbc", "c", "ca" };
		String result4 = "";
		assertEquals(result4, longestCommonPrefix(strs4));

		String[] strs5 = { "a", "a", "aabc", "aa", "acc" };
		String result5 = "a";
		assertEquals(result5, longestCommonPrefix(strs5));

		String[] strs6 = { "ab", "a" };
		String result6 = "a";
		assertEquals(result6, longestCommonPrefix(strs6));

		String[] strs7 = { "", "" };
		String result7 = "";
		assertEquals(result7, longestCommonPrefix(strs7));
	}
}
