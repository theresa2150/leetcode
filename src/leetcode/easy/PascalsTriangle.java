package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<Integer> currentRow = new ArrayList<>(Arrays.asList(1));
		List<List<Integer>> row = new ArrayList<>(Arrays.asList(currentRow));

		if (numRows == 1)
			return row;
		List<Integer> lastRow = currentRow;
		while (numRows > 1) {
			currentRow = new ArrayList<>(Arrays.asList(1));
			int j = 1, lastLength = lastRow.size();
			while (j < lastLength) {
				currentRow.add(lastRow.get(lastLength - j) + lastRow.get(lastLength - 1 - j));
				j++;
			}
			currentRow.add(1);
			row.add(currentRow);
			lastRow = currentRow;
			numRows--;
			currentRow.forEach(n -> System.out.print(n + " "));
			System.out.println("");
		}
		return row;
	}

	public List<List<Integer>> generate1(int numRows) {
		List<Integer> currentRow = new ArrayList<>(Arrays.asList(1));
		List<List<Integer>> row = new ArrayList<>(Arrays.asList(currentRow));

		if (numRows == 1)
			return row;

		currentRow = new ArrayList<>(Arrays.asList(1, 1));
		row.add(currentRow);

		if (numRows == 2)
			return row;

		List<Integer> lastRow = currentRow;

		while (numRows > 2) {
			currentRow = new ArrayList<Integer>();
			int i = 0, helfSize = lastRow.size() / 2;

			while (i < helfSize) {
				int addValue = lastRow.get(helfSize - i) + lastRow.get(helfSize - i - 1);
				currentRow.add(addValue);
				currentRow.add(0, addValue);
				i++;
			}
			if (lastRow.size() % 2 == 0) {
				currentRow.remove(helfSize);
			}
			currentRow.add(1);
			currentRow.add(0, 1);

			row.add(currentRow);
			currentRow.forEach(n -> System.out.print(n + " "));
			System.out.println("");

			lastRow = currentRow;
			numRows--;
		}
		return row;
	}

	@ParameterizedTest
//	@CsvSource({ "1", "2", "3", "4", "5", "6" })
	@CsvSource({ "10" })
	void test(int input) {
		generate(input);
	}

	@Test
	void test1() {
		List<Integer> list = new ArrayList<>();
		int i = 5;
		list.add(5);
		i--;
		while (i > 0) {
			list.add(0, i);
			list.add(i);
			i--;
		}
		list.forEach(n -> System.out.print(n + " "));
	}
}
