package leetcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidParentheses {

	static enum Parentheses {
		A, B, C, D;
	};

	public boolean isValid(String s) {

		List<Integer> flagList = new ArrayList<>();
		flagList.add(0);

		for (int i = 0; i < s.length(); i++) {

			int lastIndex = flagList.size() - 1;

			switch (s.charAt(i)) {
			case '(':
				flagList.add(1);
				break;
			case ')':
				if (flagList.get(lastIndex) != 1) {
					return false;
				}
				flagList.remove(lastIndex);
				break;
			case '[':
				flagList.add(2);
				break;
			case ']':
				if (flagList.get(lastIndex) != 2) {
					return false;
				}
				flagList.remove(lastIndex);
				break;
			case '{':
				flagList.add(3);
				break;
			case '}':
				if (flagList.get(lastIndex) != 3) {
					return false;
				}
				flagList.remove(lastIndex);
				break;
			}
		}
		return flagList.size() == 1;
	}

	public boolean isValid1(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '{')
				stack.push('}');
			else if (c == '(')
				stack.push(')');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}

	public boolean isValid2(String s) {

		List<Integer> flagList = new ArrayList<>();
		flagList.add(0);

		for (int i = 0; i < s.length(); i++) {

			int lastIndex = flagList.size() - 1;

			switch (s.charAt(i)) {
			case '(':
				flagList.add(1);
				break;
			case ')':
				if (flagList.get(lastIndex) != 1) {
					return false;
				}
				flagList.remove(lastIndex);
				break;
			case '[':
				flagList.add(2);
				break;
			case ']':
				if (flagList.get(lastIndex) != 2) {
					return false;
				}
				flagList.remove(lastIndex);
				break;
			case '{':
				flagList.add(3);
				break;
			case '}':
				if (flagList.get(lastIndex) != 3) {
					return false;
				}
				flagList.remove(lastIndex);
				break;
			}
		}
		return flagList.size() == 1;
	}

	public boolean isValid3(String s) {

		List<Parentheses> flagList = new ArrayList<>();
		flagList.add(Parentheses.D);

		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '(':
				flagList.add(Parentheses.A);
				break;
			case ')':
				if (flagList.get(flagList.size() - 1) != Parentheses.A) {
					return false;
				}
				flagList.remove(flagList.size() - 1);
				break;
			case '[':
				flagList.add(Parentheses.B);
				break;
			case ']':
				if (flagList.get(flagList.size() - 1) != Parentheses.B) {
					return false;
				}
				flagList.remove(flagList.size() - 1);
				break;
			case '{':
				flagList.add(Parentheses.C);
				break;
			case '}':
				if (flagList.get(flagList.size() - 1) != Parentheses.C) {
					return false;
				}
				flagList.remove(flagList.size() - 1);
				break;
			}
		}
		return flagList.size() == 1;
	}

	@ParameterizedTest
	@CsvSource({ "false, ]", "false, (", "false, ({", "true, ()", "true, ()[]{}", "false, (]",
			"false, ([{)]}", "true, ([{}]){}" })
	void test(boolean boo, String s) {
		assertEquals(boo, isValid(s));
	}
}
