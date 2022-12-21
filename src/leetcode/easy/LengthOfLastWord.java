package leetcode.easy;

import org.junit.jupiter.api.Test;

public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		int count = 0, i = s.length() - 1;
		while (i >= 0) {
			if (s.charAt(i) != ' ') {
				count++;
			} else if (count > 0) {
				return count;
			}
			i--;
		}
		return count;
	}

	public int lengthOfLastWord1(String s) {
		int length = s.length() - 1;
		int i = length;

		if (s.charAt(length) == ' ') {
			while (s.charAt(i) == ' ') {
				i--;
			}
		}
		length = i;

		while (i >= 0) {
			if (s.charAt(i) != ' ') {
				i--;
			} else {
				return length - i;
			}
		}
		return length - i;
	}

	public int lengthOfLastWord2(String s) {
		String[] arr = s.split(" ");
		String last = arr[arr.length - 1];
		return last.length();
	}

//	假設s含有空格、字母以外的字元
	public int lengthOfLastWord3(String s) {
		int i = s.length() - 1;
		int output = 0;
		boolean boo = true;
		while (i >= 0) {
			int a = s.charAt(i) + 0;
			i--;

			if ((a >= 97 && a <= 122) || (a >= 65 && a <= 90)) {
				output++;
				boo = false;
			} else if (boo) {
				continue;
			} else {
				break;
			}
		}
		return output;
	}

	@Test
	void test() {
		String s1 = "Hello World";
		int r1 = 5;
		assert r1 == lengthOfLastWord(s1);

		String s2 = "   fly me   to   the moon  ";
		int r2 = 4;
		assert r2 == lengthOfLastWord(s2);

		String s3 = "luffy is still joyboy";
		int r3 = 6;
		assert r3 == lengthOfLastWord(s3);
//		
		String s4 = "a";
		int r4 = 1;
		assert r4 == lengthOfLastWord(s4);
	}
}
