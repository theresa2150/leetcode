package leetcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SqrtX {

//	牛頓法
	public int mySqrt(int x) {
		if (x == 0)
			return 0;
		long i = x;
		while (i > x / i)
			i = (i + x / i) / 2;
		return (int) i;
	}

	public int mySqrt1(int x) {
		if (x == 0)
			return 0;
		double output = -1;
		double cur = x, pre = 0;
		while ((int) pre != (int) cur) {
			output = (cur + x / cur) / 2;
			pre = cur;
			cur = output;
		}
		return (int) output;
	}

	public int mySqrt2(int x) {
		if (x == 0) {
			return 0;
		}

		String s = String.valueOf(x);
		int length = s.length(), current, i;
		if (length % 2 == 1) {
			current = Integer.parseInt(s.substring(0, 1));
			i = 1;
		} else {
			current = Integer.parseInt(s.substring(0, 2));
			i = 2;
		}

		int least = init(current);
		int temp = current - least * least;
		int output = least;
		while (i < length - 1) {
			current = temp * 100 + Integer.parseInt(s.substring(i, i + 2));
			least = current / (output * 20);
			if (least > 9)
				least = 9;
			temp = current - (output * 20 + least) * least;
			if (temp < 0) {
				least--;
				temp = current - (output * 20 + least) * least;
			}
			output = output * 10 + least;
			i += 2;
		}
		return output;
	}

	public int mySqrt3(int x) {
		if (x == 0) {
			return 0;
		}

		List<Integer> list = new ArrayList<>();
		int temp = x;
		while (temp > 0) {
			list.add(0, temp % 100);
			temp /= 100;
		}

//		list.forEach((n) -> System.out.println(n));
		int current = list.get(0);
		int least = init(current);
		temp = current - least * least;
		int output = least;
		for (int i = 1; i < list.size(); i++) {
			current = temp * 100 + list.get(i);
			least = current / (output * 20);
			if (least > 9)
				least = 9;
			temp = current - (output * 20 + least) * least;
			if (temp < 0) {
				least--;
				temp = current - (output * 20 + least) * least;
			}
			output = output * 10 + least;
		}
		return output;
//		return (int) Math.pow(x, 0.5);
//		return (int) Math.sqrt(x);
	}

	@ParameterizedTest
	@CsvSource({ "0, 0", "4, 2", "8, 2", "9, 3", "626, 25", "624, 24", "361, 19", "360, 18",
			"324, 18", "323, 17", "841, 29", "7921, 89", "7920, 88", "159201, 399",
			"21464689, 4633", "2147395599, 46339" })
	void test(int input, int expected) {
		int actual = mySqrt(input);
		assertEquals(expected, actual);
	}

	int init(int i) {
		if (i == 0)
			return 0;
		else if (i < 4)
			return 1;
		else if (i < 9)
			return 2;
		else if (i < 16)
			return 3;
		else if (i < 25)
			return 4;
		else if (i < 36)
			return 5;
		else if (i < 49)
			return 6;
		else if (i < 64)
			return 7;
		else if (i < 81)
			return 8;
		else if (i < 100)
			return 9;
		else
			return 0;
	}
}
