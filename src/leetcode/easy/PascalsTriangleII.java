package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> ans = new ArrayList<>();
		int N = rowIndex;
		long pre = 1;
		ans.add(1);
		for (int k = 1; k <= N; k++) {
			long cur = pre * (N - k + 1) / k;
			ans.add((int) cur);
			pre = cur;
		}
		return ans;
	}

	public List<Integer> getRow1(int k) {
		Integer[] arr = new Integer[k + 1];
		Arrays.fill(arr, 0);
		arr[0] = 1;

		for (int i = 1; i <= k; i++)
			for (int j = i; j > 0; j--)
				arr[j] = arr[j] + arr[j - 1];

		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("");
		return Arrays.asList(arr);
	}

	public List<Integer> getRow2(int rowIndex) {
		List<Integer> currentRow = new ArrayList<>(Arrays.asList(1));

		if (rowIndex == 0)
			return currentRow;
		List<Integer> lastRow = currentRow;
		while (rowIndex > 0) {
			currentRow = new ArrayList<>(Arrays.asList(1));
			int j = 1, lastLength = lastRow.size();
			while (j < lastLength) {
				currentRow.add(lastRow.get(lastLength - j) + lastRow.get(lastLength - 1 - j));
				j++;
			}
			currentRow.add(1);
			lastRow = currentRow;
			rowIndex--;
			currentRow.forEach(n -> System.out.print(n + " "));
			System.out.println("");
		}
		return currentRow;
	}

	@ParameterizedTest
	@CsvSource({ "0", "1", "2", "3", "4", "5", "6" })
	void test(int input) {
		getRow1(input);
	}

	@Test
	void test1() {
		Integer[] arr = new Integer[10];
		Arrays.fill(arr, 1);
		System.out.println(Arrays.asList(arr));
	}

}
