package leetcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ValidPalindrome {
	private static final char[] charMap = new char[123];
	static {
		// 映射 '0' 到 '9'
		for (int i = 0; i < 10; i++) {
			charMap[i + '0'] = (char) (1 + i); // numeric
		}
		// 映射 'a' 到 'z' 和 映射 'A' 到 'Z'
		for (int i = 0; i < 26; i++) {
			charMap[i + 'a'] = charMap[i + 'A'] = (char) (11 + i);
		}
	}

	public boolean isPalindrome(String s) {
		char[] pChars = s.toCharArray();
		int start = 0, end = pChars.length - 1;
		char cS, cE;
		while (start < end) {
			// 得到映射後的數字
			cS = charMap[pChars[start]];
			cE = charMap[pChars[end]];
			if (cS != 0 && cE != 0) {
				if (cS != cE)
					return false;
				start++;
				end--;
			} else {
				if (cS == 0)
					start++;
				if (cE == 0)
					end--;
			}
		}
		return true;
	}

	public boolean isPalindrome1(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			char head = s.charAt(i);
			while (!isValid1(head) && i < j) {
				head = s.charAt(++i);
			}

			char tail = s.charAt(j);
			while (!isValid1(tail) && j > i) {
				tail = s.charAt(--j);
			}
			if (head - tail != 0 && head - tail != 32 && head - tail != -32) {
				return false;
			} else if (Character.isDigit(head) != Character.isDigit(tail)) {
				return false;
			}
			j--;
			i++;
		}
		return true;
	}

	public boolean isPalindrome2(String s) {
		int i = 0, j = s.length() - 1;
		s = s.toLowerCase();
		while (i < j) {
			char head = s.charAt(i);
			while (!isValid2(head) && i < j) {
				head = s.charAt(++i);
			}

			char tail = s.charAt(j);
			while (!isValid2(tail) && j > i) {
				tail = s.charAt(--j);
			}
			if (head != tail)
				return false;
			j--;
			i++;
		}
		return true;
	}

	public boolean isPalindrome3(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			char head = s.charAt(i);
			while (!isValid3(head) && i < j) {
				head = s.charAt(++i);
			}

			char tail = s.charAt(j);
			while (!isValid3(tail) && j > i) {
				tail = s.charAt(--j);
			}
			int subtract = head - tail;

			if (Character.isDigit(tail) != Character.isDigit(head)) {
				return false;
			} else if (subtract != 0 && subtract != 32 && subtract != -32) {
				return false;
			}
			j--;
			i++;
		}
		return true;
	}

	private boolean isValid1(char ch) {
		return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
	}

	private boolean isValid2(char ch) {
		return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
	}

	private boolean isValid3(char ch) {
		return Character.isAlphabetic(ch) || Character.isDigit(ch);
	}

	@Test
	void test() {
		String s = "A man, a plan, a canal: Panama";
		boolean expected = true;
		boolean actual = isPalindrome(s);
		assertEquals(expected, actual);
	}

	@Test
	void test2() {
		String s = "race a car";
		boolean expected = false;
		boolean actual = isPalindrome(s);
		assertEquals(expected, actual);
	}

	@Test
	void test3() {
		String s = " ";
		boolean expected = true;
		boolean actual = isPalindrome(s);
		assertEquals(expected, actual);
	}

	@Test
	void test4() {
		String s = "0P";
		boolean expected = false;
		boolean actual = isPalindrome(s);
		assertEquals(expected, actual);
	}
}
