package leetcode.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class IntegerToRoman {

	static int[] intArr = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
	static String[] indexArr = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM",
			"M" };

	static Map<Integer, String> map;

	static {
		map = new LinkedHashMap<>(16, 0.75f, true);
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");
	}

	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();

		for (int i = intArr.length - 1; i >= 0;) {
			if (num >= intArr[i]) {
				sb.append(indexArr[i]);
				num -= intArr[i];
			} else {
				i--;
			}
		}
		return sb.toString();
	}

	public String intToRoman2(int num) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			int times = num / entry.getKey();
			while (num > 0 && times > 0) {
				num -= entry.getKey();
				sb.append(entry.getValue());
				times--;
			}
		}
		return sb.length() == 0 ? "" : sb.toString();
	}

	public String intToRoman3(int num) {
		String output = "";
		int[] intArr = { 1, 5, 10, 50, 100, 500, 1000 };
		char[] indexArr = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
//		for (int i = intArr.length - 1; i >= 0; i--) {
//			System.out.println(intArr[i] + " " + indexArr[i]);
//		}

		for (int i = intArr.length - 1; i >= 0;) {
			if (num >= intArr[i]) {
				output += indexArr[i];
				num -= intArr[i];
			} else {
				i--;
			}
		}

		output = output.replace("DCCCC", "CM");
		output = output.replace("CCCC", "CD");
		output = output.replace("LXXXX", "XC");
		output = output.replace("XXXX", "XL");
		output = output.replace("VIIII", "IX");
		output = output.replace("IIII", "IV");

		return output;
	}

	public String intToRoman4(int num) {
		String output = "";
		int[] intArr = { 1, 5, 10, 50, 100, 500, 1000 };
		char[] indexArr = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
//		for (int i = intArr.length - 1; i >= 0; i--) {
//			System.out.println(intArr[i] + " " + indexArr[i]);
//		}

		for (int i = intArr.length - 1; i >= 0;) {
			int log10 = (int) Math.log10(intArr[i]);

//			System.out.println(
//					"num=" + num + " intArr[i]=" + intArr[i] + " subtractNum=" + subtractNum);

			if (intArr[i] - (int) Math.pow(10, log10) == 0 && num / intArr[i] == 4) {
				output += indexArr[i] + "" + indexArr[i + 1];
				num -= intArr[i] * 4;
				i--;

			} else if (num / intArr[i] == 1 && num % intArr[i] >= 4 * (int) Math.pow(10, log10)) { // 9xx
				output += indexArr[i - 1] + "" + indexArr[i + 1];
				num -= intArr[i - 1] * 9;
				i--;

			} else if (num / intArr[i] >= 1) {
//				int t = num / intArr[i];
//				for (int j = 0; j < t; j++) {
//					output += indexArr[i];
//					num -= intArr[i];
//				}
				output += indexArr[i];
				num -= intArr[i];

			} else {
				i--;
			}
		}
//		System.out.println("======== " + output);
		return output;
	}

	@ParameterizedTest
	@CsvSource({ "III, 3", "LVIII, 58", "MCMXCIV, 1994" })
//	@CsvSource({ "MCMXCIV, 1994" })
	void test(String s, int i) {
		assertEquals(s, intToRoman(i));
	}
}
