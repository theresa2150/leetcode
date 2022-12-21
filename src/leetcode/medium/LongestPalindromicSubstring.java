package leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LongestPalindromicSubstring {
//	Manacher's Algorithm 馬拉車算法
	public String longestPalindrome(String s) {

		return null;
	}

	@ParameterizedTest
//	@CsvSource({ "aca, aacabdkacaa", "erere, ccererefffbabad", "r, rew", "werew, werew",
//			"bab, babad", "bb, cbbd",
//			"khvhk, mwwfjysbkebpdjyabcfkgprtxpwvhglddhmvaprcvrnuxifcrjpdgnktvmggmguiiquibmtviwjsqwtchkqgxqwljouunurcdtoeygdqmijdympcamawnlzsxucbpqtuwkjfqnzvvvigifyvymfhtppqamlgjozvebygkxawcbwtouaankxsjrteeijpuzbsfsjwxejtfrancoekxgfyangvzjkdskhssdjvkvdskjtiybqgsmpxmghvvicmjxqtxdowkjhmlnfcpbtwvtmjhnzntxyfxyinmqzivxkwigkondghzmbioelmepgfttczskvqfejfiibxjcuyevvpawybcvvxtxycrfbcnpvkzryrqujqaqhoagdmofgdcbhvlwgwmsmhomknbanvntspvvhvccedzzngdywuccxrnzbtchisdwsrfdqpcwknwqvalczznilujdrlevncdsyuhnpmheukottewtkuzhookcsvctsqwwdvfjxifpfsqxpmpwospndozcdbfhselfdltmpujlnhfzjcgnbgprvopxklmlgrlbldzpnkhvhkybpgtzipzotrgzkdrqntnuaqyaplcybqyvidwcfcuxinchretgvfaepmgilbrtxgqoddzyjmmupkjqcypdpfhpkhitfegickfszermqhkwmffdizeoprmnlzbjcwfnqyvmhtdekmfhqwaftlyydirjnojbrieutjhymfpflsfemkqsoewbojwluqdckmzixwxufrdpqnwvwpbavosnvjqxqbosctttxvsbmqpnolfmapywtpfaotzmyjwnd" })
//	@CsvSource({ "bab, lasdkjlkjcbabd" })
//	@CsvSource({ "aaabbbaaa, caaabbbaaad" })
	@CsvSource({ "aca, aacabdkacaa" })
	void test(String expected, String input) {
		String actual = longestPalindrome(input);
//		assertEquals(expected, actual);
	}

//	最長公共子字串2
//	動態規劃-一維陣列
	public String longestPalindrome1(String s) {
		int length = s.length();
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		String reverse = sb.toString();
		int largestLength = 0;
		int largestIndex = -1;

		int[] temp = new int[length];
		for (int j = 0; j < length; j++) {
			for (int k = length - 1; k >= 0; k--) {
				if (s.charAt(j) == reverse.charAt(k)) {
					if (k > 0 && j > 0) {
						temp[k] = temp[k - 1] + 1;
					} else {
						temp[k] = 1;
					}
				} else {
					temp[k] = 0;
				}
				if (temp[k] > largestLength) {
					int beforeRev = length - 1 - k;
					if (beforeRev + temp[k] - 1 == j) {
						largestLength = temp[k];
						largestIndex = j;
					}
				}
				System.out.print(temp[k] + " ");
			}
			System.out.println();
		}
		return s.substring(largestIndex - largestLength + 1, largestIndex + 1);
	}

//	最長公共子字串1
//	動態規劃-二維陣列
	public String longestPalindrome2(String s) {
		int length = s.length();
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		String reverse = sb.toString();
		int largestLength = 0;
		int largestIndex = -1;

		int[][] temp = new int[length][length];
		for (int j = 0; j < length; j++) {
			for (int k = 0; k < length; k++) {
				if (s.charAt(j) == reverse.charAt(k)) {
					if (k > 0 && j > 0) {
						temp[j][k] = temp[j - 1][k - 1] + 1;
					} else {
						temp[j][k] = 1;
					}
				}
				if (temp[j][k] > largestLength) {
					int beforeRev = length - 1 - k;
					if (beforeRev + temp[j][k] - 1 == j) { // 判斷下標是否對應
						largestLength = temp[j][k];
						largestIndex = j;
					}
				}
			}
		}

		for (int j = 0; j < length; j++) {
			for (int k = 0; k < length; k++) {
				System.out.print(temp[j][k] + " ");
			}
			System.out.println();
		}
//		return reverse.substring(length - largestIndex - 1,
//				length - largestIndex - 1 + largestLength);
		return s.substring(largestIndex - largestLength + 1, largestIndex + 1);
	}

//	暴力迴圈
	public String longestPalindrome3(String s) {
		StringBuilder sb = new StringBuilder();
		int i, j, length = s.length();
		for (i = length - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		String reverse = sb.toString();
		i = 0;
		while (i < length) {
			j = 0;
			while (j <= i) {
				String subS = s.substring(0 + j, length - i + j);
				String subR = reverse.substring(0 + i - j, length - j);
//				System.out.println(subS + " " + subR);
				if (subS.equals(subR)) {
					return subS;
				}
				j++;
			}
			i++;
		}
		return null;
	}

	public String longestPalindrome4(String s) {
		String subStr;
		int j = 0, length = s.length();
		while (j < length) {
			int i = 0;
			while (i <= j) {
				subStr = s.substring(0 + i, length + i - j);
				if (isPalindrome(subStr)) {
					return subStr;
				}
				i++;
			}
			j++;
		}
		return null;
	}

	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
